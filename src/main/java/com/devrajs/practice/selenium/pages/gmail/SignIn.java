package com.devrajs.practice.selenium.pages.gmail;

import com.devrajs.practice.selenium.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by devraj.singh on 12/25/15.
 */
public class SignIn {
    private static SignIn instance;
    WebDriver webDriver;

    private SignIn(WebDriver wb, String url)
    {
        try
        {
            webDriver=wb;
            webDriver.get(url);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static SignIn getInstance(WebDriver webDriver, String url)
    {
        if(instance==null) {
            instance = new SignIn(webDriver, url);
        }
        return instance;
    }

    public WebElement getUserId(boolean wait, boolean suppressException)
    {
        try {
            By by = By.id("Email");
            if (wait)
                WebUtil.waitForPresence(webDriver, by);
            return webDriver.findElement(by);
        }
        catch (Exception e)
        {
            if(!suppressException)
                e.printStackTrace();
            return null;
        }
    }
    public WebElement getNextButton(boolean wait, boolean suppressException)
    {
        try {
            By by = By.id("next");
            if (wait)
                WebUtil.waitForPresence(webDriver, by);
            return webDriver.findElement(by);
        }
        catch (Exception e)
        {
            if(!suppressException)
                e.printStackTrace();
            return null;
        }
    }
    public WebElement getPassword(boolean wait, boolean suppressException)
    {
        try {
            By by = By.id("Passwd");
            if (wait)
                WebUtil.waitForPresence(webDriver, by);
            return webDriver.findElement(by);
        }
        catch (Exception e)
        {
            if(!suppressException)
                e.printStackTrace();
            return null;
        }
    }
    public WebElement getLoginSubmit(boolean wait, boolean suppressException)
    {
        try {
            By by = By.id("signIn");
            if (wait)
                WebUtil.waitForPresence(webDriver, by);
            return webDriver.findElement(by);
        }
        catch (Exception e)
        {
            if(!suppressException)
                e.printStackTrace();
            return null;
        }
    }
    public WebElement getErrorMsgBody(boolean wait, boolean suppressException)
    {
        try
        {
            By by = By.id("errormsg_0_Passwd");
            if(wait)
                WebUtil.waitForPresence(webDriver,by);
            return webDriver.findElement(by);
        }
        catch (Exception e)
        {
            if(!suppressException)
                e.printStackTrace();
            return null;
        }
    }
}
