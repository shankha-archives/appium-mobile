package com.frontline.report;


import com.frontline.config.ConfigFileManager;
import com.frontline.config.GetAppiumVariable;
import com.frontline.utils.CommandPrompt;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.io.FileUtils;

    public class ExtentManager {
        private static ConfigFileManager configFileManager;

        private static ExtentReports extent;

        private static String filePath = System.getProperty("user.dir") + "/target/ExtentReports.html";

        private static CommandPrompt commandPrompt = new CommandPrompt();

        private static String mongoHost;

        private static Integer mongoPort;

        public static synchronized ExtentReports getExtent() {
            if (extent == null)
                try {
                    configFileManager = ConfigFileManager.getInstance();
                    extent = new ExtentReports();
                    extent.attachReporter(new ExtentReporter[] { (ExtentReporter)getHtmlReporter() });
                    if (configFileManager.getProperty("REPORT_SERVER") != null && configFileManager
                            .getProperty("REPORT_SERVER").equalsIgnoreCase("true"))
                        extent.attachReporter(new ExtentReporter[] { (ExtentReporter)klovReporter() });
                    extent.setSystemInfo("Environment", configFileManager.getProperty("ENVIRONMENT"));
                    String appiumVersion = null;
                    try {
                        appiumVersion = commandPrompt.runCommand(GetAppiumVariable.nodePath + " " + GetAppiumVariable.appiumJsPath + " -v");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    extent.setSystemInfo("AppiumClient", "7.0.0");
                    extent.setSystemInfo("AppiumServer", appiumVersion.replace("\n", ""));
                    extent.setSystemInfo("Runner", configFileManager.getProperty("RUNNER"));
                    List<Status> statusHierarchy = Arrays.asList(new Status[] { Status.FATAL, Status.FAIL, Status.ERROR, Status.WARNING, Status.SKIP, Status.PASS, Status.DEBUG, Status.INFO });
                    extent.config().statusConfigurator().setStatusHierarchy(statusHierarchy);
                    return extent;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return extent;
        }

        private static ExtentHtmlReporter getHtmlReporter() {
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);
            URL inputUrl = null;
            try {
                inputUrl = Thread.currentThread().getContextClassLoader().getResource("extent.xml");
            } catch (Exception e) {
                e.printStackTrace();
            }
            File dest = new File(System.getProperty("user.dir") + "/target/extent.xml");
            try {
                FileUtils.copyURLToFile(inputUrl, dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/target/extent.xml");
            if (configFileManager.containsKey("HTMLREPORT_NAME") && configFileManager
                    .getProperty("HTMLREPORT_NAME") != null) {
                htmlReporter.config().setDocumentTitle(configFileManager.getProperty("HTMLREPORT_NAME"));
            } else {
                htmlReporter.config().setDocumentTitle("MobileAutomation");
            }
            if (configFileManager.containsKey("DOCUMENT_NAME") && configFileManager.getProperty("DOCUMENT_NAME") != null) {
                htmlReporter.config().setReportName(configFileManager.getProperty("DOCUMENT_NAME"));
            } else {
                htmlReporter.config().setReportName("MobileAutomation");
            }
            htmlReporter.config().setTheme(Theme.STANDARD);
            return htmlReporter;
        }

        private static ExtentKlovReporter klovReporter() {
            ExtentKlovReporter klov = new ExtentKlovReporter();
            if (isMongoPortHostProvided()) {
                klov.initMongoDbConnection(getMongoHost(), getMongoPort().intValue());
                String klovProjectName = configFileManager.getProperty("projectName");
                String klovReportName = configFileManager.getProperty("reportName");
                String projectname = klovProjectName;
                String reportname = klovReportName;
                if (klovProjectName == null || klovReportName == null) {
                    projectname = "MobileAutomation";
                    reportname = "MobileAutomation";
                }
                klov.setProjectName(projectname);
                klov.setReportName(reportname);
                klov.initMongoDbConnection("http://" + getMongoHost() + ":1337");
            }
            return klov;
        }

        public static synchronized void setSystemInfoInReport(String parameter, String value) {
            if (extent == null)
                getExtent();
            extent.setSystemInfo(parameter, value);
        }

        private static boolean isMongoPortHostProvided() {
            if (configFileManager.getProperty("MONGODB_SERVER") != null && configFileManager
                    .getProperty("MONGODB_PORT") != null) {
                setMongoHost(configFileManager.getProperty("MONGODB_SERVER"));
                setMongoPort(Integer.valueOf(Integer.parseInt(configFileManager.getProperty("MONGODB_PORT"))));
                return true;
            }
            setMongoHost("localhost");
            setMongoPort(Integer.valueOf(27017));
            return true;
        }

        private static String getMongoHost() {
            return mongoHost;
        }

        private static void setMongoHost(String mongo) {
            mongoHost = mongo;
        }

        private static Integer getMongoPort() {
            return mongoPort;
        }

        private static void setMongoPort(Integer port) {
            mongoPort = port;
        }
    }
