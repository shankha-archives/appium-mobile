package com.frontline.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class Utility {
    private static Utility singleton = new Utility();

    public static Utility instance() {
        return singleton;
    }

    public MatrixResult readCSV(String resourceName) {
        try {
            LineNumberReader fileReader = null;
            if (System.getProperties().containsKey("maven.home")) {
                fileReader = new LineNumberReader(new FileReader(System.getProperty("user.dir") + File.separator + "testdata" + File.separator + resourceName));
            } else {
                InputStream inputStream = new FileInputStream(resourceName);
                fileReader = new LineNumberReader(new InputStreamReader(inputStream));
            }
            String[] columnNames = fileReader.readLine().split(",");
            List<String[]> elementList = (List)new ArrayList<>(20);
            String currentLine = null;
            while ((currentLine = fileReader.readLine()) != null)
                elementList.add(currentLine.split(","));
            return new MatrixResult(columnNames, elementList);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
