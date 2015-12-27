package com.devrajs.practice.selenium;

import entity.Browser;
import entity.exception.BrowserNotSupportedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by devraj.singh on 12/25/15.
 */
public class WebUtil {

    static private final long WAIT_TIME=8;
    static private final long TIMEOUT=5;
    public static WebDriver getWebdriver(Browser browser) throws BrowserNotSupportedException {
        WebDriver webDriver;
        if(browser==Browser.Firefox)
            webDriver = new FirefoxDriver();
        else if(browser==Browser.Chrome) {
            String chromedriver = WebUtil.class.getClassLoader().getResource("chromedriver").getPath();
            System.setProperty("webdriver.chrome.driver",chromedriver);
            webDriver = new ChromeDriver();
        }
        else
            throw new BrowserNotSupportedException(browser.name() + " not supported!!");
        return webDriver;
    }
    public static WebDriver getWebdriver(Browser browser,String url) throws BrowserNotSupportedException {
        WebDriver webDriver = getWebdriver(browser);
        webDriver.get(url);
        return webDriver;
    }

    public static void implicitWait(WebDriver webDriver)
    {
        webDriver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
    }

    public static void waitForPresence(WebDriver webDriver, By by) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, TIMEOUT);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public static void maximizeWindow(WebDriver webDriver)
    {
        webDriver.manage().window().maximize();
    }
}
