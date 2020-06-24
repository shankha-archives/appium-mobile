package com.frontline.manager;

import com.frontline.config.ConfigFileManager;
import com.frontline.config.Log;
import com.frontline.report.HtmlReporter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.testng.TestNG;
import org.testng.collections.Lists;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class MyTestExecutor {
    private final ConfigFileManager prop;

    public List<Class> testcases = (List)new ArrayList<>();

    public HtmlReporter reporter = new HtmlReporter();

    public ArrayList<String> items = new ArrayList<>();

    public MyTestExecutor() throws IOException {
        this.prop = ConfigFileManager.getInstance();
    }

    public boolean[] distributeTests(int deviceCount) {
        final boolean[] hasFailures = { false };
        try {
            PackageUtil.getClasses("output").stream().forEach(s -> {
                if (s.toString().contains("IT"))
                    Log.INFO("forEach: " + this.testcases.add((Class)s));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        ExecutorService[] executorService = { Executors.newFixedThreadPool(deviceCount) };
        for (Class testFile : this.testcases) {
            executorService[0].submit(new Runnable() {
                public void run() {
                    Log.INFO("Running test file: " + testFile.getName());
                    hasFailures[0] = MyTestExecutor.this.testRunnerTestNg(testFile);
                }
            });
        }
        executorService[0].shutdown();
        try {
            executorService[0].awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        deleteOutputDirectory();
        try {
            this.reporter.generateReports();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.INFO("ending");
        return hasFailures;
    }

    public boolean testRunnerTestNg(Class arg) {
        TestNG test = new TestNG();
        test.setTestClasses(new Class[] { arg });
        test.run();
        return test.hasFailure();
    }

    public boolean runMethodParallel() {
        TestNG testNG = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add(System.getProperty("user.dir") + "/target/parallel.xml");
        testNG.setTestSuites(suites);
        testNG.run();
        return testNG.hasFailure();
    }

    public List<XmlClass> writeXmlClass(List<String> testcases, Map<String, List<Method>> methods, List<XmlClass> xmlClasses) {
        for (String className : methods.keySet()) {
            if (className.contains("Test")) {
                if (testcases.size() == 0) {
                    xmlClasses.add(createClass(className));
                    continue;
                }
                for (String s : testcases) {
                    for (int j = 0; j < this.items.size(); j++) {
                        String testName = ((String)this.items.get(j)).concat("." + s).toString();
                        if (testName.equals(className))
                            xmlClasses.add(createClass(className));
                    }
                }
            }
        }
        return xmlClasses;
    }

    public void include(ArrayList<String> groupsInclude, String include) {
        if (this.prop.getProperty(include) != null) {
            Collections.addAll(groupsInclude, this.prop.getProperty(include).split("\\s*,\\s*"));
        } else if (System.getenv(include) != null) {
            Collections.addAll(groupsInclude, System.getenv(include).split("\\s*,\\s*"));
        }
    }

    private XmlClass createClass(String className) {
        XmlClass clazz = new XmlClass();
        clazz.setName(className);
        return clazz;
    }

    public Map<String, List<Method>> createTestsMap(Set<Method> methods) {
        Map<String, List<Method>> testsMap = new HashMap<>();
        methods.stream().forEach(method -> {
            List<Method> methodsList = (List<Method>)testsMap.get(method.getDeclaringClass().getPackage().getName() + "." + method.getDeclaringClass().getSimpleName());
            if (methodsList == null) {
                methodsList = new ArrayList<>();
                testsMap.put(method.getDeclaringClass().getPackage().getName() + "." + method.getDeclaringClass().getSimpleName(), methodsList);
            }
            methodsList.add(method);
        });
        return testsMap;
    }

    public void runTestCase(Class testCase) {
        Result result = JUnitCore.runClasses(new Class[] { testCase });
        for (Failure failure : result.getFailures())
            System.out.println(failure.toString());
    }

    public void deleteOutputDirectory() {
        File delete_output = new File(System.getProperty("user.dir") + "/src/test/java/output/");
        File[] files = delete_output.listFiles();
        for (File file : files)
            file.delete();
    }

    public XmlSuite constructXmlSuiteForParallelCucumber(int deviceCount, ArrayList<String> deviceSerail) {
        XmlSuite suite = new XmlSuite();
        suite.setName("TestNG Forum");
        suite.setThreadCount(deviceCount);
        suite.setParallel(XmlSuite.ParallelMode.TESTS);
        suite.setVerbose(Integer.valueOf(2));
        for (int i = 0; i < deviceCount; i++) {
            XmlTest test = new XmlTest(suite);
            test.setName("TestNG Test" + i);
            test.setPreserveOrder("false");
            test.addParameter("device", deviceSerail.get(i));
            test.setPackages(getPackages());
        }
        File file = new File(System.getProperty("user.dir") + "/target/parallel.xml");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file.getAbsoluteFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            bw.write(suite.toXml());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return suite;
    }

    public XmlSuite constructXmlSuiteDistributeCucumber(int deviceCount, ArrayList<String> deviceSerail) {
        XmlSuite suite = new XmlSuite();
        suite.setName("TestNG Forum");
        suite.setThreadCount(deviceCount);
        suite.setParallel(XmlSuite.ParallelMode.CLASSES);
        suite.setVerbose(Integer.valueOf(2));
        XmlTest test = new XmlTest(suite);
        test.setName("TestNG Test");
        test.addParameter("device", "");
        test.setPackages(getPackages());
        File file = new File(System.getProperty("user.dir") + "/target/parallel.xml");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file.getAbsoluteFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            bw.write(suite.toXml());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return suite;
    }

    public static List<XmlPackage> getPackages() {
        List<XmlPackage> allPackages = new ArrayList<>();
        XmlPackage eachPackage = new XmlPackage();
        eachPackage.setName("output");
        allPackages.add(eachPackage);
        return allPackages;
    }
}
