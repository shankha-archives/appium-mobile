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
	}

	public void apiGetConfirmationIds(String workerID, String absenceDay) throws Throwable {
		HttpResponse<String> responseGetAbsenceConfirmationNumberAPI = apiObject.getAbsenceFromDate(aesoptoken,
				workerID, absenceDay);
		Assert.assertEquals(responseGetAbsenceConfirmationNumberAPI.getStatus(), 200);
		JSONObject json = new JSONObject(responseGetAbsenceConfirmationNumberAPI.getBody());

		numberOfAbsence = json.getJSONArray("data").length();

		for (int i = 0; i < numberOfAbsence; i++)
			confirmationNumbers.add(json.getJSONArray("data").getJSONObject(i).get("id").toString());
	}

	public void apiDeleteAbsence() throws Throwable {
		if (!confirmationNumbers.isEmpty()) {
			for (String confNumber : confirmationNumbers) {
				HttpResponse<String> responseAbsenceDelete = apiObject.deleteAbsenceFromConfirmationNumber(confNumber,
						aesoptoken);
				Assert.assertEquals(responseAbsenceDelete.getStatus(), 200);
			}
		} else
			utils.log().info("No Absence Found");
	}

	public void apiCreateAbsence(String workerID, String absenceDay) throws Throwable {
		HttpResponse<String> responseCreateAbsence = apiObject.createEmployeeAbsence(aesoptoken, workerID, absenceDay);
		Assert.assertEquals(responseCreateAbsence.getStatus(), 201);
	}

	public void apiBearerTokenGeneration(String automationEmployee) throws Throwable {
		HttpResponse<String> responseGenerateBearerTokenAPI = apiObject.generateBearerToken(automationEmployee);
		Assert.assertEquals(responseGenerateBearerTokenAPI.getStatus(), 200);
		JSONObject json = new JSONObject(responseGenerateBearerTokenAPI.getBody());
		bearerToken = json.get("access_token").toString();
		utils.log().info("");
	}

	public void apiGetTimesheetsForWeek(String timesheetDay, String orgID, String workerID) throws Throwable {
		HttpResponse<String> responseGetTimeClockIDs = apiObject.getWeekTimesheet(timesheetDay, bearerToken, aesoptoken,
				orgID, workerID);
		// utils.log().info("error token"+responseGetTimeClockIDs.getBody().toString());
		Assert.assertEquals(responseGetTimeClockIDs.getStatus(), 200);
		JSONObject json = new JSONObject(responseGetTimeClockIDs.getBody());

		timesheetsID = json.getJSONArray("weekSummaries").getJSONObject(0).getJSONArray("dates").getJSONObject(0)
				.getJSONArray("timesheets").getJSONObject(0).get("id").toString();
		numberOfTimeEvents = json.getJSONArray("weekSummaries").getJSONObject(0).getJSONArray("dates").getJSONObject(0)
				.getJSONArray("timesheets").getJSONObject(0).getJSONArray("timeClockEvents").length();

		for (int i = 0; i < numberOfTimeEvents; i++)
			timeClockEventsIDS.add(json.getJSONArray("weekSummaries").getJSONObject(0).getJSONArray("dates")
					.getJSONObject(0).getJSONArray("timesheets").getJSONObject(0).getJSONArray("timeClockEvents")
					.getJSONObject(i).get("id").toString());
	}

	public void apiDeleteTimeEvents(String orgID, String workerID) throws Throwable {
		if (!timeClockEventsIDS.isEmpty()) {
			for (String timeEventID : timeClockEventsIDS) {
				HttpResponse<String> responseAbsenceDelete = apiObject.deleteDayTimesheets(bearerToken, aesoptoken,
						orgID, workerID, timesheetsID, timeEventID);
				Assert.assertEquals(responseAbsenceDelete.getStatus(), 204);
			}
		} else
			utils.log().info("No Absence Found");
	}
	
	public void apiCreateTimesheet(String orgID, String workerID, String timesheetDay) throws Throwable {
		HttpResponse<String> responseCreateTimesheet = apiObject.createTimesheet(bearerToken, aesoptoken, orgID, workerID, timesheetDay);
		Assert.assertEquals(responseCreateTimesheet.getBody(), 200);
		Assert.assertEquals(responseCreateTimesheet.getStatus(), 200);
	}
}
