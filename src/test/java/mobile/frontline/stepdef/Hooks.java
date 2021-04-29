package mobile.frontline.stepdef;

import java.io.IOException;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import mobile.Frontline.utils.*;
import org.apache.logging.log4j.ThreadContext;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	CapabilitiesManager caps = new CapabilitiesManager();
	public String testName;
	GlobalParams params = new GlobalParams();

	@Before
	public void initialize(Scenario scenario) throws Exception {
		System.out.println("Before Class called");
		testName = scenario.getName();
		GlobalParams params = new GlobalParams();
		params.initializeGlobalParams();

		ThreadContext.put("ROUTINGKEY", params.getPlatformName() + "_" + params.getDeviceName());

		new ServerManager().startServer();
		new DriverManager().initializeDriver();
	}

	@After
	public void quit(Scenario scenario) throws IOException, UnirestException {
		System.out.println("After Class called");
		DriverManager driverManager = new DriverManager();
		String sessionID=driverManager.getDriver().getSessionId().toString();
		if (scenario.isFailed()) {
			byte[] screenshot = new DriverManager().getDriver().getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png", scenario.getName());

			if(params.getEnvironmentName().contains("Cloud")) {
				Unirest.setTimeouts(0, 0);
				HttpResponse<String> response = Unirest.put("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionID + ".json")
						.header("Content-Type", "application/json")
						.header("Authorization", "Basic c2hpdmFuaWdvZWwyOm1xSHFCc3laVW5lNFV3QlRpcDdG")
						.body("{\"status\":\"failed\", \"reason\":\"Element not found on the login page\"}")
						.asString();
			}
		}
		if(params.getEnvironmentName().contains("Cloud")) {
			Unirest.setTimeouts(0, 0);
			HttpResponse<String> response = Unirest.put("https://api-cloud.browserstack.com/app-automate/sessions/"+sessionID+".json")
					.header("Content-Type", "application/json")
					.header("Authorization", "Basic c2hpdmFuaWdvZWwyOm1xSHFCc3laVW5lNFV3QlRpcDdG")
					.body("{\"status\":\"passed\", \"reason\":\"Test Case has Passed\"}")
					.asString();
		}

		if (driverManager.getDriver() != null) {
			driverManager.getDriver().quit();
			driverManager.setDriver(null);
		}
		ServerManager serverManager = new ServerManager();
		if (serverManager.getServer() != null) {
			serverManager.getServer().stop();
		}
	}
}
