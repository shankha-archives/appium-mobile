package mobile.frontline.stepdef;

import java.io.IOException;

import org.apache.logging.log4j.ThreadContext;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import mobile.Frontline.utils.CommandPrompt;
import mobile.Frontline.utils.DriverManager;
import mobile.Frontline.utils.GlobalParams;
import mobile.Frontline.utils.ServerManager;
import mobile.Frontline.utils.VideoManager;

public class Hooks {

	@Before
	public void initialize() throws Exception {
		System.out.println("Before Class called");
		GlobalParams params = new GlobalParams();
		params.initializeGlobalParams();

		ThreadContext.put("ROUTINGKEY", params.getPlatformName() + "_" + params.getDeviceName());

		new ServerManager().startServer();
		new DriverManager().initializeDriver();
	//	new VideoManager().startRecording();
	}

	@After
	public void quit(Scenario scenario) throws IOException {
		System.out.println("After Class called");
		if (scenario.isFailed()) {
			byte[] screenshot = new DriverManager().getDriver().getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png", scenario.getName());
		}
		new VideoManager().stopRecording(scenario.getName());
		DriverManager driverManager = new DriverManager();
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
