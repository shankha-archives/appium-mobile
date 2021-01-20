package mobile.frontline.pages;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import org.junit.Assert;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import mobile.Frontline.utils.TestDataManager;

public class ApiCallClass {

	public TestDataManager testdata = new TestDataManager();
	String token;
	String BaseURL= "https://aesopapistage.flqa.net";
	//ArrayList<String> confirmationNumbers = new ArrayList<String>();
	
	public String generateAesopToken() throws UnirestException {
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest.post(BaseURL+"/api/v1.0/Login")
		  .header("Content-Type", "application/json")
		  .body("{\n\"loginId\": \""+testdata.read_property("testingData", "users", "APILoginID")+"\",\n\"pin\": \""+testdata.read_property("testingData", "users", "APIPin")+"\",\n\"forceRefreshSession\": true\n}")
		  .asString();
		
		return response.getBody();
		
//		JSONObject json = new JSONObject(response.getBody());
//		token = json.getJSONObject("data").get("token").toString();
//		
		//token = json.getJSONObject("data").get("token").toString();
		//Assert.assertEquals("", token);
	}
	
	public String getAbsenceFromDate(String token) throws UnirestException{
	//	generateAesopToken();
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest.get(BaseURL+"/api/v1.0/Workers/"+testdata.read_property("testingData", "users", "APIWorkerID")+"/AbsenceRequests")
		  .queryString("startDate", "01/20/2021")
		  .queryString("endDate", "01/25/2021")
		  .header("Accept", "application/json")
		  .header("AesopToken", token)
		 .asString();
		
		return response.getBody();
		
//		JSONObject json = new JSONObject(response.getBody());
//		
//		int numberOfAbsence = json.getJSONArray("data").length();//getInt(0);
//		
//		if(numberOfAbsence>0) {
//		for (int i=0; i<numberOfAbsence; i++)  
//			confirmationNumbers.add(json.getJSONArray("data").getJSONObject(i).get("id").toString());
//		}

	}
	
	public void deleteAbsenceFromConfirmationNumber(ArrayList<String> confirmationNumbers) throws UnirestException{
		//generateAesopToken();
		//getAbsenceFromDate();
		
		for(int i=0 ; i<confirmationNumbers.size();i++)
		{
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest.delete(BaseURL+"/api/v1.0/AbsenceRequests/"+confirmationNumbers.get(i))
		  .header("Accept", "application/json")
		  .header("AesopToken", token)
		  .asString();
		}
	}
	
}
