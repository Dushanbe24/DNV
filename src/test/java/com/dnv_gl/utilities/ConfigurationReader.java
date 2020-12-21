package com.dnv_gl.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    // * reads the properties file "configuration.properties"
    private static Properties properties;

    static{

        String path = "configuration.properties";

        try {
            FileInputStream inputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(inputStream);

            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String get(String key){ return  properties.getProperty(key);

    }
}
