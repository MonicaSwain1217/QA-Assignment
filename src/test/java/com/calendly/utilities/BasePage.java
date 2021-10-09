package com.calendly.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public static ChromeOptions options = new ChromeOptions();
    public static WebDriver driver;
    public static Properties properties;

    public static String baseURL = "";
    public static String _environment;
    public static final String defaultEnv = "codepen";

    public BasePage() {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream("src/main/java/tictactoe/config/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void initialization(String env) {
        _environment = env;
        options.addArguments("enable-automation");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--disable-gpu");
////        String browserName = properties.getProperty("browser");
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
        baseURL =  properties.getProperty("codePenURL");

    }
}