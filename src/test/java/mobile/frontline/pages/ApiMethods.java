package mobile.frontline.pages;

import java.util.ArrayList;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import mobile.Frontline.utils.TestDataManager;

public class ApiMethods {

	public TestDataManager testdata = new TestDataManager();
	SmokeMethods smokePage = new SmokeMethods();

	public HttpResponse<String> generateAesopToken(String apiLoginID) throws UnirestException {
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest.post(testdata.read_property("testingData", "users", "BaseURL")+"/api/v1.0/Login")
		  .header("Content-Type", "application/json")
		  .body("{\n\"loginId\": \""+testdata.read_property("testingData", "users", apiLoginID)+"\",\n\"pin\": \""+testdata.read_property("testingData", "users", "APIPin")+"\",\n\"forceRefreshSession\": true\n}")
		  .asString();
		return response;
	}
	
	public HttpResponse<String> getAbsenceFromDate(String token, String workerID, String absenceDay) throws Throwable{
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest.get(testdata.read_property("testingData", "users", "BaseURL")+"/api/v1.0/Workers/"+testdata.read_property("testingData", "users", workerID)+"/AbsenceRequests")
		  .queryString("startDate", smokePage.nextWorkingDay(absenceDay,"MM/dd/yyyy"))
		  .queryString("endDate", smokePage.nextWorkingDay(absenceDay,"MM/dd/yyyy"))
		  .header("Accept", "application/json")
		  .header("AesopToken", token)
		 .asString();
		return response;
	}
	
	public HttpResponse<String> deleteAbsenceFromConfirmationNumber(ArrayList<String> confirmationNumbers, String token) throws UnirestException{
		HttpResponse<String> response = null;
		for(int i=0 ; i<confirmationNumbers.size();i++)
		{
		Unirest.setTimeouts(0, 0);
		response = Unirest.delete(testdata.read_property("testingData", "users", "BaseURL")+"/api/v1.0/AbsenceRequests/"+confirmationNumbers.get(i))
		  .header("Accept", "application/json")
		  .header("AesopToken", token)
		  .asString();
		}
	return response;
	}
	
	public HttpResponse<String> createEmployeeAbsence(String token, String workerID, String absenceDay) throws Throwable {
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest.post(testdata.read_property("testingData", "users", "BaseURL")+"/api/v1.0/AbsenceRequests")
		  .header("Content-Type", "application/json")
		  .header("Accept", "application/json")
		  .header("AesopToken", token)
		  .body("{\"needSub\" : true, \"worker\":{  \"id\":"+testdata.read_property("testingData", "users", workerID)+" }, \"absences\":[ { \"date\":\""+smokePage.nextWorkingDay(absenceDay,"MM/dd/yyyy")+"\", \"institution\":{ \"id\":"+testdata.read_property("testingData", "users", "APISchoolID")+"   }, \"entitlement\":{ \"id\":"+testdata.read_property("testingData", "users", "APIReasonID")+" }, \"shiftType\":1, \"absenceStartTime\":\"09:00 AM\", \"absenceEndTime\":\"03:00 PM\"  } ]}")
		  .asString();
		return response;
	}
}
