package mobile.frontline.pages;

import java.util.ArrayList;

import org.json.JSONObject;
import org.junit.Assert;
import com.mashape.unirest.http.HttpResponse;

import mobile.Frontline.utils.TestUtils;

public class APIServices {
	
	public ApiMethods apiObject = new ApiMethods();
	TestUtils utils = new TestUtils();
	ArrayList<String> confirmationNumbers = new ArrayList<String>();
	int numberOfAbsence;
	String token;
	
	public void apiTokenGeneration(String apiLoginID) throws Throwable {
		HttpResponse<String> responseGenerateTokenAPI = apiObject.generateAesopToken(apiLoginID);
		Assert.assertEquals(responseGenerateTokenAPI.getStatus(),200);
		JSONObject json = new JSONObject(responseGenerateTokenAPI.getBody());
		token = json.getJSONObject("data").get("token").toString();
	}
	
	public void apiGetConfirmationIds(String workerID, String absenceDay) throws Throwable {
		HttpResponse<String> responseGetAbsenceConfirmationNumberAPI = apiObject.getAbsenceFromDate(token,workerID,absenceDay);
		Assert.assertEquals(responseGetAbsenceConfirmationNumberAPI.getStatus(),200);
		JSONObject json = new JSONObject(responseGetAbsenceConfirmationNumberAPI.getBody());
		
		 numberOfAbsence = json.getJSONArray("data").length();
		
		for (int i=0; i<numberOfAbsence; i++)  
			confirmationNumbers.add(json.getJSONArray("data").getJSONObject(i).get("id").toString());
	}
	
	public void apiDeleteAbsence() throws Throwable {
		if(!confirmationNumbers.isEmpty())
			{HttpResponse<String> responseAbsenceDelete= apiObject.deleteAbsenceFromConfirmationNumber(confirmationNumbers,token);
			Assert.assertEquals(responseAbsenceDelete.getStatus(),200);
			}
		else
			utils.log().info("No Absence Found");
	}
	
	public void apiCreateAbsence(String workerID, String absenceDay) throws Throwable {
		HttpResponse<String> responseCreateAbsence= apiObject.createEmployeeAbsence(token,workerID,absenceDay);
		Assert.assertEquals(responseCreateAbsence.getStatus(),201);
	}
}
