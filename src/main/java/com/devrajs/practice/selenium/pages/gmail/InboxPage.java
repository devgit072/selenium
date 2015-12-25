package com.devrajs.practice.selenium.pages.gmail;

import com.devrajs.practice.selenium.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by devraj.singh on 12/25/15.
 */
public class InboxPage {

    private static WebDriver webDriver;
    private static InboxPage instance;
    private InboxPage(WebDriver wb)
    {
        this.webDriver=wb;
    }
    public static InboxPage getInstance(WebDriver wb)
    {
        if(instance==null) {
            instance = new InboxPage(wb);
        }
        return instance;
    }
    public WebElement getInboxButton(boolean wait)
    {
        try {
            return null;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public WebElement getComposeButton(boolean wait)
    {
        try {
            By by = By.cssSelector("div[gh='cm']");
            if (wait)
                WebUtil.waitForPresence(webDriver, by);
            return webDriver.findElement(by);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public WebElement getToBody(boolean wait)
    {
        try
        {
            By by = By.className("vO");
            if(wait)
                WebUtil.waitForPresence(webDriver, by);
            return webDriver.findElement(by);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public WebElement getSubjectBody(WebDriver webDriver, boolean wait) {
        try {
            By by = By.className("aoT");
            if(wait)
                WebUtil.waitForPresence(webDriver,by);
            return webDriver.findElement(by);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public WebElement getMessageBody(WebDriver webDriver, boolean wait) {
        try
        {
            By by = By.cssSelector("div[aria-label='Message Body']");
            if(wait)
                WebUtil.waitForPresence(webDriver,by);
            return webDriver.findElement(by);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public WebElement getSendButton(WebDriver webDriver, boolean wait) {
        try
        {
            By by = By.cssSelector("div[aria-label*='Send']");
            if(wait)
                WebUtil.waitForPresence(webDriver, by);
            return webDriver.findElement(by);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public WebElement getProfileArea(WebDriver webDriver, boolean wait) {
        try
        {
            By by = By.cssSelector("span[class='gb_Wa gbii']");
            if(wait)
                WebUtil.waitForPresence(webDriver, by);
            return webDriver.findElement(by);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public WebElement getSignOutButton(WebDriver webDriver, boolean wait) {
        try
        {
            By by = By.cssSelector("a[id='gb_71']");
            if(wait)
                WebUtil.waitForPresence(webDriver,by);
            return webDriver.findElement(by);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
