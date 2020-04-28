package ru.ibs.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.Assert;

public class TestProperties {

    private final Properties properties = new Properties();

    private static TestProperties INSTANCE = null;

    private TestProperties() {
        try {
            properties.load(new FileInputStream(new File("./src/main/resources/linux_application.properties")));
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Не найден файл с настройками!");
        }
    }

    public static TestProperties getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TestProperties();
        }
        return INSTANCE;
    }

    public Properties getProperties() {
        return properties;
    }

}
