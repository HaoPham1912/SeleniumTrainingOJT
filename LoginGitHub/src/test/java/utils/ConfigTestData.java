package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ConfigTestData {

    private Properties properties;
    private final String filePath = "src\\test\\resources\\configuation.properties";

    public ConfigTestData(){
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            properties = new Properties();
            try {
                properties.load(bufferedReader);
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("configuration.properties not found at " + filePath);
        }
    }
    public String getDriverPath(){
        String driverPath = properties.getProperty("driverPath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the configuration.properties file.");
    }

    public String getWebUrl(){
        String webUrl = properties.getProperty("webUrl");
        if(webUrl!= null) return webUrl;
        else throw new RuntimeException("webUrl not specified in the configuration.properties file.");
    }

    public String getUsername(){
        String username = properties.getProperty("username");
        if(username!= null) return username;
        else throw new RuntimeException("username not specified in the configuration.properties file.");
    }

    public String getPassword(){
        String password = properties.getProperty("password");
        if(password!= null) return password;
        else throw new RuntimeException("password not specified in the configuration.properties file.");
    }
}
