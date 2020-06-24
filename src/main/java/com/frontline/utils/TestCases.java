package com.frontline.utils;

import java.util.List;

public class TestCases {
    private String testCase;

    List<Testmethods> testMethod;

    public String getTestCase() {
        return this.testCase;
    }

    public void setTestCase(String testCase) {
        this.testCase = testCase;
    }

    public List<Testmethods> getTestMethod() {
        return this.testMethod;
    }

    public void setTestMethod(List<Testmethods> testMethod) {
        this.testMethod = testMethod;
    }
}
