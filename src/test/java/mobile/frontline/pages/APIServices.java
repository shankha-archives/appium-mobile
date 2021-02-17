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
	ArrayList<String> timeClockEventsIDS = new ArrayList<String>();
	int numberOfAbsence, numberOfTimeEvents;
	String aesoptoken, bearerToken, timesheetsID;

	public void apiTokenGeneration(String apiLoginID) throws Throwable {
		HttpResponse<String> responseGenerateTokenAPI = apiObject.generateAesopToken(apiLoginID);
		Assert.assertEquals(responseGenerateTokenAPI.getStatus(), 200);
		JSONObject json = new JSONObject(responseGenerateTokenAPI.getBody());
		aesoptoken = json.getJSONObject("data").get("token").toString();
		utils.log().info("Aesop Token"+responseGenerateTokenAPI);
	}

	public void apiGetConfirmationIds(String workerID, String absenceDay) throws Throwable {
		HttpResponse<String> responseGetAbsenceConfirmationNumberAPI = apiObject.getAbsenceFromDate(aesoptoken,
				workerID, absenceDay);
		Assert.assertEquals(responseGetAbsenceConfirmationNumberAPI.getStatus(), 200);
		JSONObject json = new JSONObject(responseGetAbsenceConfirmationNumberAPI.getBody());

		numberOfAbsence = json.getJSONArray("data").length();

		for (int i = 0; i < numberOfAbsence; i++)
			confirmationNumbers.add(json.getJSONArray("data").getJSONObject(i).get("id").toString());
		utils.log().info("Confirmation ids of absences"+responseGetAbsenceConfirmationNumberAPI);
	}

	public void apiDeleteAbsence() throws Throwable {
		if (!confirmationNumbers.isEmpty()) {
			for (String confNumber : confirmationNumbers) {
				HttpResponse<String> responseAbsenceDelete = apiObject.deleteAbsenceFromConfirmationNumber(confNumber,
						aesoptoken);
				Assert.assertEquals(responseAbsenceDelete.getStatus(), 200);
				utils.log().info("Delete absences"+responseAbsenceDelete);
			}
		} else
			utils.log().info("No Absence Found");
	
	}

	public void apiCreateAbsence(String workerID, String absenceDay) throws Throwable {
		HttpResponse<String> responseCreateAbsence = apiObject.createEmployeeAbsence(aesoptoken, workerID, absenceDay);
		Assert.assertEquals(responseCreateAbsence.getStatus(), 201);
		utils.log().info("Create absences"+responseCreateAbsence);
	}

	public void apiBearerTokenGeneration(String automationEmployee) throws Throwable {
		HttpResponse<String> responseGenerateBearerTokenAPI = apiObject.generateBearerToken(automationEmployee);
		Assert.assertEquals(responseGenerateBearerTokenAPI.getStatus(), 200);
		JSONObject json = new JSONObject(responseGenerateBearerTokenAPI.getBody());
		bearerToken = json.get("access_token").toString();
		utils.log().info("Bearer Token"+ responseGenerateBearerTokenAPI);
	}

	public void apiGetTimesheetsForWeek(String timesheetDay, String orgID, String workerID) throws Throwable {
		HttpResponse<String> responseGetTimeClockIDs = apiObject.getWeekTimesheet(timesheetDay, bearerToken, aesoptoken,
				orgID, workerID);
		Assert.assertEquals(responseGetTimeClockIDs.getStatus(), 200);
		JSONObject json = new JSONObject(responseGetTimeClockIDs.getBody());
		System.out.println("********* Timesheet 1************");
		timesheetsID = json.getJSONArray("weekSummaries").getJSONObject(0).getJSONArray("dates").getJSONObject(0)
				.getJSONArray("timesheets").getJSONObject(0).get("id").toString();
		
		
		System.out.println("********* Timesheet 2************");
		//******************** make changes here***************** 
		numberOfTimeEvents = json.getJSONArray("weekSummaries").getJSONObject(0).getJSONArray("dates").getJSONObject(0)
				.getJSONArray("timesheets").getJSONObject(0).getJSONArray("timeClockEvents").length();
		System.out.println("********* Timesheet 3************");
		for (int i = 0; i < numberOfTimeEvents; i++)
			{System.out.println("********* Timesheet 4************");
			timeClockEventsIDS.add(json.getJSONArray("weekSummaries").getJSONObject(0).getJSONArray("dates")
					.getJSONObject(0).getJSONArray("timesheets").getJSONObject(0).getJSONArray("timeClockEvents")
					.getJSONObject(i).get("id").toString());
			}
		utils.log().info("Get All timesheet details"+ responseGetTimeClockIDs);
	}

	public void apiDeleteTimeEvents(String orgID, String workerID) throws Throwable {
		if (!timeClockEventsIDS.isEmpty()) {
			for (String timeEventID : timeClockEventsIDS) {
				HttpResponse<String> responseAbsenceDelete = apiObject.deleteDayTimesheets(bearerToken, aesoptoken,
						orgID, workerID, timesheetsID, timeEventID);
				Assert.assertEquals(responseAbsenceDelete.getStatus(), 204);
				utils.log().info("Delete timesheet"+ responseAbsenceDelete);
			}
		} else
			utils.log().info("No Absence Found");
	}
	
	public void apiCreateTimesheet(String orgID, String workerID, String timesheetDay) throws Throwable {
		HttpResponse<String> responseCreateTimesheet = apiObject.createTimesheet(bearerToken, aesoptoken, orgID, workerID, timesheetDay);
		Assert.assertEquals(responseCreateTimesheet.getStatus(), 200);
		utils.log().info("Create timesheet"+ responseCreateTimesheet);
	}
}
