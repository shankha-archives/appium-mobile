package mobile.Frontline.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigFileManager {
    public static Map<String, String> configFileMap = new HashMap();
    private static Properties prop = new Properties();
    private static ConfigFileManager instance;

    private ConfigFileManager(String configFile) throws IOException {
        FileInputStream inputStream = new FileInputStream(configFile);
        prop.load(inputStream);
    }

    public static ConfigFileManager getInstance() throws IOException {
        if (instance == null) {
            String configFile = "src/main/resources/config.properties";
            try {
                if (System.getenv().containsKey("CONFIG_FILE")) {
                    configFile = System.getenv().get("CONFIG_FILE");
                    System.out.println("Using config file from " + configFile);
                }
                instance = new ConfigFileManager(configFile);
                Enumeration keys = prop.propertyNames();
                while (keys.hasMoreElements()) {
                    String key = (String) keys.nextElement();
                    configFileMap.put(key, prop.getProperty(key));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public String getProperty(String object) {
        return configFileMap.get(object);
    }

    public String getProperty(String key,String value) {
        return configFileMap.getOrDefault(key,value);
    }
    public boolean containsKey(String key) {
        return prop.containsKey(key);
    }
    
    public String getReportConfigPath(){
    	String reportConfigPath = "/Frontline/target/src/main/resources/extent-config.xml";
    	if(reportConfigPath!= null) return reportConfigPath;
    	else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
    }
}
