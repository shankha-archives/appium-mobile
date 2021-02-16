package mobile.frontline.pages;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import mobile.Frontline.utils.TestDataManager;

import java.util.ArrayList;

import org.junit.Assert;

public class ApiMethods {

	public TestDataManager testdata = new TestDataManager();
	SmokeMethods smokePage = new SmokeMethods();

	public HttpResponse<String> generateAesopToken(String apiLoginID) throws UnirestException {
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
				.queryString("startDate", smokePage.nextWorkingDay(absenceDay, "MM/dd/yyyy"))
				.queryString("endDate", smokePage.nextWorkingDay(absenceDay, "MM/dd/yyyy"))
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

	public HttpResponse<String> createEmployeeAbsence(String token, String workerID, String absenceDay)
			throws Throwable {
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest
				.post(testdata.read_property("testingData", "users", "BaseURL") + "/api/v1.0/AbsenceRequests")
				.header("Content-Type", "application/json").header("Accept", "application/json")
				.header("AesopToken", token)
				.body("{\"needSub\" : true, \"worker\":{  \"id\":"
						+ testdata.read_property("testingData", "users", workerID) + " }, \"absences\":[ { \"date\":\""
						+ smokePage.nextWorkingDay(absenceDay, "MM/dd/yyyy") + "\", \"institution\":{ \"id\":"
						+ testdata.read_property("testingData", "users", "APISchoolID")
						+ "   }, \"entitlement\":{ \"id\":"
						+ testdata.read_property("testingData", "users", "APIReasonID")
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
				.queryString("startOfWorkWeek", smokePage.nextWorkingDay(timesheetDay, "yyyy-MM-dd"))
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
			String timesheetDay) throws Throwable {
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest
				.post(testdata.read_property("testingData", "users", "BFFBaseURL")
						+ "/api/organizations/654527/products/time-and-attendance/timesheets")
				.queryString("identity", "2-" + testdata.read_property("testingData", "users", workerID))
				.header("aesoptoken", aesopToken).header("authorization", "Bearer " + bearerToken)
				.header("Content-Type", "application/json")
				.body("[{\"date\": \"" + smokePage.nextWorkingDay(timesheetDay, "yyyy-MM-dd")
						+ "\",\"locationId\": 363692,\"shiftTypeId\": 248822,\"timeClockEvents\":  [{  \"clockIn\": \""
						+ smokePage.nextWorkingDay(timesheetDay, "yyyy-MM-dd") + "T" + smokePage.currentDate("HH:mm:ss")
						+ "\",  \"clockOut\": \"" + smokePage.nextWorkingDay(timesheetDay, "yyyy-MM-dd") + "T"
						+ smokePage.currentDate("HH:mm:ss") + "\", \"eventTypeId\": 18305  }]}]")
				.asString();

		return response;
	}
}
