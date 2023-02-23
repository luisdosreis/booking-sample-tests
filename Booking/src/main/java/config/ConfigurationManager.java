package config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;

public class ConfigurationManager {

    private static Properties prop = new Properties();

    public static void init(){

        try {

            String fileName = "run.properties";
            ClassLoader classLoader = ConfigurationManager.class.getClassLoader();

            URL res = Objects.requireNonNull(classLoader.getResource(fileName),
                    "Can't find configuration file app.config");

            InputStream is = new FileInputStream(res.getFile());
            prop.load(is);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        String p = prop.getProperty(key);
        return p;
    }
}

