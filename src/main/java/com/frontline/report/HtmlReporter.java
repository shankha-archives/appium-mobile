package com.frontline.report;

import com.frontline.config.Log;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.velocity.exception.VelocityException;

public class HtmlReporter {
    public File reportOutputDirectory = new File(System.getProperty("user.dir") + "/target/");

    public List<String> list = new ArrayList<>();

    public void listFilesForFolder(File folder) {
        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else if (fileEntry.getName().endsWith(".json")) {
                Log.INFO("*******" + fileEntry.getName());
                this.list.add(this.reportOutputDirectory + "/" + fileEntry.getName());
            }
        }
    }

    public void generateReports() throws VelocityException, IOException {
        listFilesForFolder(this.reportOutputDirectory);
        String buildNumber = "1";
        String projectName = "cucumber-jvm";
        boolean runWithJenkins = false;
        Configuration configuration = new Configuration(this.reportOutputDirectory, projectName);
        configuration.setRunWithJenkins(runWithJenkins);
        configuration.setBuildNumber(buildNumber);
        ReportBuilder reportBuilder = new ReportBuilder(this.list, configuration);
        reportBuilder.generateReports();
    }
}
