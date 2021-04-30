package mobile.frontline.pages;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import mobile.Frontline.utils.TestDataManager;


import java.io.IOException;

public class ApiMethods {

	public TestDataManager testdata = new TestDataManager();
	BasePage common = new BasePage();

	public HttpResponse<String> generateAesopToken(String apiLoginID) throws UnirestException, IOException {
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest
				.post(testdata.read_property("testingData", "users", "BaseURL") + "/api/v1.0/Login")
				.header("Content-Type", "application/json")
				.body("{\n\"loginId\": \"" + testdata.read_property("testingData", "users", apiLoginID)
						+ "\",\n\"pin\": \"" + testdata.read_property("testingData", "users", "APIPin")
						+ "\",\n\"forceRefreshSession\": true\n}")
				.asString();
		return response;
	}

	public HttpResponse<String> getAbsenceFromDate(String token, String workerID, String absenceDay) throws Throwable {
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest
				.get(testdata.read_property("testingData", "users", "BaseURL") + "/api/v1.0/Workers/"
						+ testdata.read_property("testingData", "users", workerID) + "/AbsenceRequests")
				.queryString("startDate", common.nextWorkingDay(absenceDay, "MM/dd/yyyy"))
				.queryString("endDate", common.nextWorkingDay(absenceDay, "MM/dd/yyyy"))
				.header("Accept", "application/json").header("AesopToken", token).asString();
		return response;
	}

	public HttpResponse<String> deleteAbsenceFromConfirmationNumber(String confirmationNumber, String token)
			throws UnirestException {
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest
				.delete(testdata.read_property("testingData", "users", "BaseURL") + "/api/v1.0/AbsenceRequests/"
						+ confirmationNumber)
				.header("Accept", "application/json").header("AesopToken", token).asString();
		return response;
	}

	public HttpResponse<String> createEmployeeAbsence(String token, String workerID, String absenceDay, String schoolID, String reasonID)
			throws Throwable {
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest
				.post(testdata.read_property("testingData", "users", "BaseURL") + "/api/v1.0/AbsenceRequests")
				.header("Content-Type", "application/json").header("Accept", "application/json")
				.header("AesopToken", token)
				.body("{\"needSub\" : true, \"worker\":{  \"id\":"
						+ testdata.read_property("testingData", "users", workerID) + " }, \"absences\":[ { \"date\":\""
						+ common.nextWorkingDay(absenceDay, "MM/dd/yyyy") + "\", \"institution\":{ \"id\":"
						+ testdata.read_property("testingData", "users", schoolID)
						+ "   }, \"entitlement\":{ \"id\":"
						+ testdata.read_property("testingData", "users", reasonID)
						+ " }, \"shiftType\":1, \"absenceStartTime\":\"09:00 AM\", \"absenceEndTime\":\"03:00 PM\"  } ]}")
				.asString();
		return response;
	}

	public HttpResponse<String> generateBearerToken(String automationEmployee) throws Throwable {
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest.post("https://idgatewayawsstage.flqa.net/connect/token")
				.header("Accept", "application/json")
				.field("username", testdata.read_property("Account", "valid", automationEmployee))
				.field("password", testdata.read_property("Account", "valid", "FrontlinePassword"))
				.field("grant_type", "password").field("scope", "flapi.public flapi.introspection")
				.field("client_secret", "secret").field("client_id", "absMgmtTest").asString();
		return response;
	}

	public HttpResponse<String> getWeekTimesheet(String timesheetDay, String bearerToken, String aesopToken,
			String orgID, String workerID) throws Throwable {
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest
				.get(testdata.read_property("testingData", "users", "BFFBaseURL") + "/api/organizations/"
						+ testdata.read_property("testingData", "users", orgID)
						+ "/products/time-and-attendance/timesheets/summary")
				.queryString("startOfWorkWeek", common.nextWorkingDay(timesheetDay, "yyyy-MM-dd"))
				.queryString("numberOfWeeks", "1").queryString("includeDetails", "true")
				.queryString("identity", "2-" + testdata.read_property("testingData", "users", workerID))
				.header("authorization", "Bearer " + bearerToken).header("aesoptoken", aesopToken).asString();
		return response;
	}

	public HttpResponse<String> deleteDayTimesheets(String bearerToken, String aesopToken, String orgID,
			String workerID, String timesheetID, String timeEventID) throws Throwable {
		HttpResponse<String> response = null;
		Unirest.setTimeouts(0, 0);
		response = Unirest
				.delete(testdata.read_property("testingData", "users", "BFFBaseURL") + "/api/organizations/"
						+ testdata.read_property("testingData", "users", orgID)
						+ "/products/time-and-attendance/timesheets/" + timesheetID + "/clock-events/" + timeEventID)
				.queryString("identity", "2-" + testdata.read_property("testingData", "users", workerID))
				.header("authorization", "Bearer " + bearerToken).header("aesoptoken", aesopToken).asString();
		return response;
	}

	public HttpResponse<String> createTimesheet(String bearerToken, String aesopToken, String orgID, String workerID,
			String timesheetDay, String locationID, String shiftID, String eventID) throws Throwable {
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest
				.post(testdata.read_property("testingData", "users", "BFFBaseURL")
						+ "/api/organizations/"+testdata.read_property("testingData", "users", orgID)+"/products/time-and-attendance/timesheets")
				.queryString("identity", "2-" + testdata.read_property("testingData", "users", workerID))
				.header("aesoptoken", aesopToken).header("authorization", "Bearer " + bearerToken)
				.header("Content-Type", "application/json")
				.body("[{\"date\": \"" + common.nextWorkingDay(timesheetDay, "yyyy-MM-dd")
						+ "\",\"locationId\": "+testdata.read_property("testingData", "users", locationID)+",\"shiftTypeId\": "+testdata.read_property("testingData", "users", shiftID)+",\"timeClockEvents\":  [{  \"clockIn\": \""
						+ common.nextWorkingDay(timesheetDay, "yyyy-MM-dd") + "T" + common.currentDate("HH:mm:ss")
						+ "\",  \"clockOut\": \"" + common.nextWorkingDay(timesheetDay, "yyyy-MM-dd") + "T"
						+ common.currentDate("HH:mm:ss") + "\", \"eventTypeId\": "+testdata.read_property("testingData", "users", eventID)+"  }]}]")
				.asString();

		return response;
	}

	public HttpResponse<String> acceptJobinSubstitute( String  confirmationNumber, String bearerToken, String orgID) throws Throwable {
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest.post("https://aesopapistage.flqa.net/api/v1.0/Substitutes/AcceptJob")
				.queryString("vacancyId", confirmationNumber)
				.queryString("tenantId",testdata.read_property("testingData", "users", orgID))
				.header("Accept", "application/json")
				.header("Authorization", "Bearer "+bearerToken)
				.asString();
		return response;
	}

	public HttpResponse<String> undoSubmittedTimesheets(String bearerToken, String aesopToken, String orgID, String workerID, String bodyString ) throws UnirestException {
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest.put(testdata.read_property("testingData", "users", "BFFBaseURL")
				+"/api/organizations/"+testdata.read_property("testingData", "users", orgID)+"/products/time-and-attendance/timesheets/reset")
				.queryString("identity", "2-" + testdata.read_property("testingData", "users", workerID))
				.header("Content-Type", "application/json")
				.header("Authorization", "Bearer "+bearerToken)
				.header("aesoptoken", aesopToken)
				.body(bodyString)
				.asString();
		return response;
	}

	public HttpResponse<String> passTestResult(String sessionID) throws UnirestException {
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest.put("https://api-cloud.browserstack.com/app-automate/sessions/"+sessionID+".json")
				.header("Content-Type", "application/json")
				.header("Authorization", "Basic c2hpdmFuaWdvZWwyOm1xSHFCc3laVW5lNFV3QlRpcDdG")
				.body("{\"status\":\"passed\", \"reason\":\"Test Case has Passed\"}")
				.asString();
		return response;
	}

	public HttpResponse<String> failTestResult(String sessionID) throws UnirestException {
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest.put("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionID + ".json")
				.header("Content-Type", "application/json")
				.header("Authorization", "Basic c2hpdmFuaWdvZWwyOm1xSHFCc3laVW5lNFV3QlRpcDdG")
				.body("{\"status\":\"failed\", \"reason\":\"Element not found on the login page\"}")
				.asString();
		return response;
	}
}
