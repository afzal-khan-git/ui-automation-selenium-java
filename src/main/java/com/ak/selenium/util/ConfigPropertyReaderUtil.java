package com.ak.selenium.util;

import org.testng.annotations.Optional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertyReaderUtil {
    /**
     * returns property value based on provided file path and key
     * @param key
     * @param filePathFromProjectDir
     * @return
     */
    public static String getPropertyValueByKey(String key, String filePathFromProjectDir){
        Properties properties = new Properties();
        String fullFilePath = System.getProperty("user.dir")+"/"+filePathFromProjectDir;
        try {
            FileInputStream inputStream = new FileInputStream(fullFilePath);
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(properties.getProperty(key) == null){
            throw new IllegalArgumentException("please provide a valid key");
        }
        return properties.getProperty(key);

    }

}
