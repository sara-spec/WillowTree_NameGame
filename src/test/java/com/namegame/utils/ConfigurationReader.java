package com.namegame.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {
    //created to be able to read configuration.properties file
    //used encapsulation OOP concept
    private static final Properties properties = new Properties();

    static {
        try (InputStream in = new FileInputStream("configuration.properties")) {
            properties.load(in);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load properties file");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
