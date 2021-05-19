package mobile.frontline.pages;

import java.util.ArrayList;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.exceptions.UnirestException;
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
	public static String confirmationNumber ;
	String aesoptoken, bearerToken, timesheetsID;

	public void apiTokenGeneration(String apiLoginID) throws Throwable {
		HttpResponse<String> responseGenerateTokenAPI = apiObject.generateAesopToken(apiLoginID);
		Assert.assertEquals(printPrettyResponse(responseGenerateTokenAPI.getBody()), responseGenerateTokenAPI.getStatus(), 200);
		JSONObject json = new JSONObject(responseGenerateTokenAPI.getBody());
		aesoptoken = json.getJSONObject("data").get("token").toString();
		utils.log().info("Aesop Token : " + printPrettyResponse(responseGenerateTokenAPI.getBody()));
		ExtentCucumberAdapter.addTestStepLog("Aesop Token : " + printPrettyResponse(responseGenerateTokenAPI.getBody()));
	}

	public String printPrettyResponse(String response){
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(String.valueOf(response));
		return gson.toJson(je);
	}

	public void apiGetConfirmationIds(String workerID, String absenceDay) throws Throwable {
		confirmationNumbers.clear();
		HttpResponse<String> responseGetAbsenceConfirmationNumberAPI = apiObject.getAbsenceFromDate(aesoptoken,
				workerID, absenceDay);
		Assert.assertEquals(printPrettyResponse(responseGetAbsenceConfirmationNumberAPI.getBody()), responseGetAbsenceConfirmationNumberAPI.getStatus(), 200);
		JSONObject json = new JSONObject(responseGetAbsenceConfirmationNumberAPI.getBody());

		numberOfAbsence = json.getJSONArray("data").length();

		for (int i = 0; i < numberOfAbsence; i++)
			confirmationNumbers.add(json.getJSONArray("data").getJSONObject(i).get("id").toString());
		utils.log().info("Confirmation ids of absences" + printPrettyResponse(responseGetAbsenceConfirmationNumberAPI.getBody()));
		ExtentCucumberAdapter.addTestStepLog("Confirmation ids of absences" + printPrettyResponse(responseGetAbsenceConfirmationNumberAPI.getBody()));
	}

	public void apiDeleteAbsence() throws Throwable {
		if (!confirmationNumbers.isEmpty()) {
			for (String confNumber : confirmationNumbers) {
				HttpResponse<String> responseAbsenceDelete = apiObject.deleteAbsenceFromConfirmationNumber(confNumber,
						aesoptoken);
				Assert.assertEquals(printPrettyResponse(responseAbsenceDelete.getBody()),responseAbsenceDelete.getStatus(), 200);
				utils.log().info("Delete absences" + printPrettyResponse(responseAbsenceDelete.getBody()));
				ExtentCucumberAdapter.addTestStepLog("Delete absences" + printPrettyResponse(responseAbsenceDelete.getBody()));
			}
		} else
			utils.log().info("No Absence Found");
		ExtentCucumberAdapter.addTestStepLog("No Absence Found");

	}

	public void apiCreateAbsence(String workerID, String absenceDay, String schoolID, String reasonID) throws Throwable {
		HttpResponse<String> responseCreateAbsence = apiObject.createEmployeeAbsence(aesoptoken, workerID, absenceDay, schoolID, reasonID);
		Assert.assertEquals(printPrettyResponse(responseCreateAbsence.getBody()),responseCreateAbsence.getStatus(), 201);
		JSONObject json = new JSONObject(responseCreateAbsence.getBody());
		confirmationNumber = json.getJSONObject("data").get("absrId").toString();
		utils.log().info("Create absences" + printPrettyResponse(responseCreateAbsence.getBody()));
		ExtentCucumberAdapter.addTestStepLog("Create absences" + printPrettyResponse(responseCreateAbsence.getBody()));
	}

	public void apiBearerTokenGeneration(String automationEmployee) throws Throwable {
		HttpResponse<String> responseGenerateBearerTokenAPI = apiObject.generateBearerToken(automationEmployee);
		Assert.assertEquals(printPrettyResponse(responseGenerateBearerTokenAPI.getBody()),responseGenerateBearerTokenAPI.getStatus(), 200);
		JSONObject json = new JSONObject(responseGenerateBearerTokenAPI.getBody());
		bearerToken = json.get("access_token").toString();
		utils.log().info("Bearer Token" + printPrettyResponse(responseGenerateBearerTokenAPI.getBody()));
		ExtentCucumberAdapter.addTestStepLog("Bearer Token" + printPrettyResponse(responseGenerateBearerTokenAPI.getBody()));
	}

	public void apiCreateTimesheet(String orgID, String workerID, String timesheetDay, String locationID, String shiftID, String eventID) throws Throwable {
		HttpResponse<String> responseCreateTimesheet = apiObject.createTimesheet(bearerToken, aesoptoken, orgID,
				workerID, timesheetDay, locationID, shiftID, eventID);
		Assert.assertEquals(printPrettyResponse(responseCreateTimesheet.getBody()),responseCreateTimesheet.getStatus(), 200);
		utils.log().info("Create timesheet" + printPrettyResponse(responseCreateTimesheet.getBody()));
		ExtentCucumberAdapter.addTestStepLog("Create timesheet" + printPrettyResponse(responseCreateTimesheet.getBody()));
	}

	public void apiAcceptSubstituteJob(String orgID, String confirmationNumber) throws Throwable {
		HttpResponse<String> responseAcceptSubstituteJob =apiObject.acceptJobinSubstitute(orgID, bearerToken, confirmationNumber);
		Assert.assertEquals(printPrettyResponse(responseAcceptSubstituteJob.getBody()),responseAcceptSubstituteJob.getStatus(), 200);
		utils.log().info("Accept substitute job" + printPrettyResponse(responseAcceptSubstituteJob.getBody()));
		ExtentCucumberAdapter.addTestStepLog("Accept substitute job" + printPrettyResponse(responseAcceptSubstituteJob.getBody()));
	}
	public void apiUndoSubmittedTimesheets(String timesheetDay,String orgID, String workerID) throws Throwable {
		HttpResponse<String> responseGetTimeClockIDs = apiObject.getWeekTimesheet(timesheetDay, bearerToken, aesoptoken,
				orgID, workerID);
		Assert.assertEquals(printPrettyResponse(responseGetTimeClockIDs.getBody()),responseGetTimeClockIDs.getStatus(), 200);
		JSONObject json = new JSONObject(printPrettyResponse(responseGetTimeClockIDs.getBody()));
		JSONObject json1 = json.getJSONArray("weekSummaries").getJSONObject(0).getJSONArray("dates").getJSONObject(0);
		if (!json.getJSONArray("weekSummaries").getJSONObject(0).getJSONArray("dates").getJSONObject(0)
				.getJSONArray("timesheets").isEmpty()) {
			json1.remove("minutesPerRole");
			json1.remove("date");
			json1.remove("status");
			json1.getJSONArray("timesheets").getJSONObject(0).remove("isPayrollLocked");
			json1.getJSONArray("timesheets").getJSONObject(0).remove("leaveEvents");
			json1.getJSONArray("timesheets").getJSONObject(0).remove("status");
			json1.getJSONArray("timesheets").getJSONObject(0).remove("totalPaidScheduledTimeInMinutes");
			json1.getJSONArray("timesheets").getJSONObject(0).remove("totalScheduledTimeInMinutes");
			json1.remove("totalPaidScheduledTimeInMinutes");
			json1.remove("totalPaidTimeInMinutes");
			json1.remove("totalScheduledTimeInMinutes");
			utils.log().info(json1);
			ExtentCucumberAdapter.addTestStepLog(json1.toString());

			HttpResponse<String> responseUndoTimesheet = apiObject.undoSubmittedTimesheets(bearerToken, aesoptoken, orgID, workerID, json1.toString());
			Assert.assertEquals(printPrettyResponse(responseUndoTimesheet.getBody()), responseUndoTimesheet.getStatus(), 204);
		}
		else {
			utils.log().info("There is no timesheet in the day");
			ExtentCucumberAdapter.addTestStepLog("There is no timesheet in the day");
		}
	}


	public void apiGetTimesheetsForWeek(String timesheetDay, String orgID, String workerID) throws Throwable {
		HttpResponse<String> responseGetTimeClockIDs = apiObject.getWeekTimesheet(timesheetDay, bearerToken, aesoptoken,
				orgID, workerID);
		Assert.assertEquals(printPrettyResponse(responseGetTimeClockIDs.getBody()),responseGetTimeClockIDs.getStatus(), 200);
		JSONObject json = new JSONObject(responseGetTimeClockIDs.getBody());
		if (!json.getJSONArray("weekSummaries").getJSONObject(0).getJSONArray("dates").getJSONObject(0)
				.getJSONArray("timesheets").isEmpty()) {
			timesheetsID = json.getJSONArray("weekSummaries").getJSONObject(0).getJSONArray("dates").getJSONObject(0)
					.getJSONArray("timesheets").getJSONObject(0).get("id").toString();
			numberOfTimeEvents = json.getJSONArray("weekSummaries").getJSONObject(0).getJSONArray("dates")
					.getJSONObject(0).getJSONArray("timesheets").getJSONObject(0).getJSONArray("timeClockEvents")
					.length();
			for (int i = 0; i < numberOfTimeEvents; i++)
				timeClockEventsIDS.add(json.getJSONArray("weekSummaries").getJSONObject(0).getJSONArray("dates")
						.getJSONObject(0).getJSONArray("timesheets").getJSONObject(0).getJSONArray("timeClockEvents")
						.getJSONObject(i).get("id").toString());
		}
		utils.log().info("Get All timesheet details" + printPrettyResponse(responseGetTimeClockIDs.getBody()));
		ExtentCucumberAdapter.addTestStepLog("Get All timesheet details" + printPrettyResponse(responseGetTimeClockIDs.getBody()));
	}

	public void apiDeleteTimeEvents(String orgID, String workerID) throws Throwable {
		if (!timeClockEventsIDS.isEmpty()) {
			for (String timeEventID : timeClockEventsIDS) {
				HttpResponse<String> responseAbsenceDelete = apiObject.deleteDayTimesheets(bearerToken, aesoptoken,
						orgID, workerID, timesheetsID, timeEventID);
				Assert.assertEquals(printPrettyResponse(responseAbsenceDelete.getBody()),responseAbsenceDelete.getStatus(), 204);
				utils.log().info("Delete timesheet" + printPrettyResponse(responseAbsenceDelete.getBody()));
				ExtentCucumberAdapter.addTestStepLog("Delete timesheet" + printPrettyResponse(responseAbsenceDelete.getBody()));
			}
		} else {
			utils.log().info("No Timesheet Found");
			ExtentCucumberAdapter.addTestStepLog("No Timesheet Found");
		}
	}

	public void apiPassStatusUpdate(String sessionID) throws UnirestException {
		HttpResponse<String> responsePassStatusUpdate = apiObject.passTestResult(sessionID);
		Assert.assertEquals(printPrettyResponse(responsePassStatusUpdate.getBody()),responsePassStatusUpdate.getStatus(), 200);
		utils.log().info("Pass result update:" + printPrettyResponse(responsePassStatusUpdate.getBody()));
		ExtentCucumberAdapter.addTestStepLog("Pass result update:" + printPrettyResponse(responsePassStatusUpdate.getBody()));
	}

	public void apiFailStatusUpdate(String sessionID) throws UnirestException {
		HttpResponse<String> responseFailStatusUpdate = apiObject.failTestResult(sessionID);
		Assert.assertEquals(printPrettyResponse(responseFailStatusUpdate.getBody()),responseFailStatusUpdate.getStatus(), 200);
		utils.log().info("Pass result update:" + printPrettyResponse(responseFailStatusUpdate.getBody()));
		ExtentCucumberAdapter.addTestStepLog("Pass result update:" + printPrettyResponse(responseFailStatusUpdate.getBody()));
	}

	public void apiCreateMultidayAbsence(String workerID, String schoolID, String reasonID, String absenceDay) throws Exception {
		HttpResponse<String> responseCreateMultidayAbsence = apiObject.createMultiDayAbsence(bearerToken, aesoptoken,workerID,schoolID,reasonID, absenceDay);
		Assert.assertEquals(printPrettyResponse(responseCreateMultidayAbsence.getBody()),responseCreateMultidayAbsence.getStatus(), 200);
		utils.log().info("Multi day create absence:" + printPrettyResponse(responseCreateMultidayAbsence.getBody()));
		ExtentCucumberAdapter.addTestStepLog("Multi day create absence:" + printPrettyResponse(responseCreateMultidayAbsence.getBody()));
	}
}
