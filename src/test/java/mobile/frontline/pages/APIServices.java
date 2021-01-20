package mobile.frontline.pages;

import java.util.ArrayList;

import org.json.JSONObject;
import org.junit.Assert;

import com.mashape.unirest.http.exceptions.UnirestException;

public class APIServices {
	String token;
	public ApiCallClass apicall = new ApiCallClass();
	ArrayList<String> confirmationNumbers = new ArrayList<String>();
	int numberOfAbsence;
	
	public void apiResponseTokenGeneration() throws Throwable {
		String responseGenerateTokenAPI = apicall.generateAesopToken();
		JSONObject json = new JSONObject(responseGenerateTokenAPI);
		token = json.getJSONObject("data").get("token").toString();
		//Assert.assertEquals("", token);
    //	apicall.deleteAbsenceFromConfirmationNumber();
	}
	
	public void apiResponseAbsenceDateCount() throws UnirestException {
		String responseGetAbsenceConfirmationNumberAPI = apicall.getAbsenceFromDate(token);
		JSONObject json = new JSONObject(responseGetAbsenceConfirmationNumberAPI);
		
		 numberOfAbsence = json.getJSONArray("data").length();//getInt(0);
		
		for (int i=0; i<numberOfAbsence; i++)  
			confirmationNumbers.add(json.getJSONArray("data").getJSONObject(i).get("id").toString());
		Assert.assertEquals("", confirmationNumbers);
	}
	
	public void apiResponseDeleteAbsence() {
		
	}
}
