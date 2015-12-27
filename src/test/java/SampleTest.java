import com.devrajs.practice.selenium.WebUtil;
import com.devrajs.practice.selenium.pages.gmail.InboxPage;
import entity.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.devrajs.practice.selenium.pages.gmail.SignIn;

/**
 * Created by devraj.singh on 12/25/15.
 */


public class SampleTest {
    static final long DEFAULT_TIMEOUT=20;

    @BeforeClass
    void initClass()
    {
    }
    @AfterClass
    void finish()
    {
    }
    @Test
    public void testLogin()
    {
        WebDriver webDriver = new FirefoxDriver();
        try {
            WebUtil.maximizeWindow(webDriver);
            WebDriverWait webDriverWait = new WebDriverWait(webDriver,DEFAULT_TIMEOUT);
            //open browser
            SignIn signIn = new SignIn(webDriver,"http://www.gmail.com");
            //enter userId and password
            WebElement userId = signIn.getUserId(true, false);
            userId.sendKeys("seleneeum89");
            signIn.getNextButton(false, false).click();
            WebElement password = signIn.getPassword(true, false);
            password.sendKeys("selenium654");
            WebElement submitButton = signIn.getLoginSubmit(true, false);
            submitButton.click();
            //verify inbox field present
            InboxPage inboxPage = new InboxPage(webDriver);
            WebElement composeButton = inboxPage.getComposeButton(true);
            Assert.assertNotNull(composeButton, "Compose button not found");
            webDriver.quit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail(e.getMessage());
            webDriver.quit();
        }
        finally {
            webDriver.quit();
        }
    }

    @Test
    public void testLoginWithWrongUserId()
    {
        WebDriver webDriver = new FirefoxDriver();
        try {
            WebUtil.maximizeWindow(webDriver);
            WebDriverWait webDriverWait = new WebDriverWait(webDriver,DEFAULT_TIMEOUT);
            //open browser
            SignIn signIn = new SignIn(webDriver,"http://www.gmail.com");
            //enter userId and password
            WebElement userId = signIn.getUserId(true, false);
            userId.sendKeys("gghhah76678671wghjgjghjhajdev098");
            WebElement password = signIn.getPassword(true, true);
            Assert.assertNull(password, "password text area present");
            webDriver.quit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail(e.getMessage());
            webDriver.quit();
        }
        finally {
            webDriver.quit();
        }
    }

    @Test
    public void testWithWrongPassword()
    {
        WebDriver webDriver = new FirefoxDriver();
        try {
            //webDriver = WebUtil.getWebdriver(Browser.Firefox);
            WebUtil.maximizeWindow(webDriver);
            WebDriverWait webDriverWait = new WebDriverWait(webDriver,DEFAULT_TIMEOUT);
            //open browser
            SignIn signIn = new SignIn(webDriver,"http://www.gmail.com");
            //enter userId and password
            WebElement userId = signIn.getUserId(true, false);
            userId.sendKeys("seleneeum89");
            signIn.getNextButton(false, false).click();
            WebElement password = signIn.getPassword(true, false);
            //enter wrong password
            password.sendKeys("selenium654122");
            WebElement submitButton = signIn.getLoginSubmit(true, false);
            submitButton.click();
            WebElement errorMsg = signIn.getErrorMsgBody(true, false);
            Assert.assertNotNull(errorMsg,"Error message not present");
            Assert.assertEquals(errorMsg.getText().trim(), "The email and password you entered don't match.");
            //verify inbox field present
            webDriver.quit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail(e.getMessage());
            webDriver.quit();
        }
        finally {
            webDriver.quit();
        }
    }

    @Test
    public void testComposeMessage()
    {
        WebDriver webDriver = new FirefoxDriver();
        try {
            //webDriver = WebUtil.getWebdriver(Browser.Firefox);
            WebUtil.maximizeWindow(webDriver);
            WebDriverWait webDriverWait = new WebDriverWait(webDriver,DEFAULT_TIMEOUT);
            //open browser
            SignIn signIn = new SignIn(webDriver,"http://www.gmail.com");
            //enter userId and password
            WebElement userId = signIn.getUserId(true, false);
            userId.sendKeys("seleneeum89");
            signIn.getNextButton(false, false).click();
            WebElement password = signIn.getPassword(true, false);
            password.sendKeys("selenium654");
            WebElement submitButton = signIn.getLoginSubmit(true, false);
            submitButton.click();
            //verify inbox field present
            InboxPage inboxPage = new InboxPage(webDriver);
            WebElement composeButton = inboxPage.getComposeButton(true);
            composeButton.click();
            WebElement toBody = inboxPage.getToBody(true);
            toBody.sendKeys("seleneeum89@gmail.com");
            WebElement subjectBody = inboxPage.getSubjectBody(webDriver, true);
            subjectBody.sendKeys("Selenium Test");
            WebElement messageBody = inboxPage.getMessageBody(webDriver,true);
            messageBody.clear();
            messageBody.sendKeys("Hello dear...this is selenium...so be carefull...I'm learning it");
            WebElement sendButton = inboxPage.getSendButton(webDriver, true);
            sendButton.click();
            webDriver.quit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail(e.getMessage());
            webDriver.quit();
        }
        finally {
            webDriver.quit();
        }
    }

    @Test
    public void loginAndLogout()
    {
        WebDriver webDriver = new FirefoxDriver();
        try {
            //webDriver = WebUtil.getWebdriver(Browser.Firefox);
            WebUtil.maximizeWindow(webDriver);
            WebDriverWait webDriverWait = new WebDriverWait(webDriver,DEFAULT_TIMEOUT);
            //open browser
            SignIn signIn = new SignIn(webDriver,"http://www.gmail.com");
            //enter userId and password
            WebElement userId = signIn.getUserId(true, false);
            userId.sendKeys("seleneeum89");
            signIn.getNextButton(false, false).click();
            WebElement password = signIn.getPassword(true, false);
            password.sendKeys("selenium654");
            WebElement submitButton = signIn.getLoginSubmit(true, false);
            submitButton.click();
            //verify inbox field present
            InboxPage inboxPage = new InboxPage(webDriver);
            WebElement profileArea = inboxPage.getProfileArea(webDriver, true);
            profileArea.click();
            WebElement signOutButton = inboxPage.getSignOutButton(webDriver, true);
            signOutButton.click();
            //verify signIn button is present
            submitButton = signIn.getLoginSubmit(true, false);
            Assert.assertNotNull(submitButton, "Login submit button is not present");
            webDriver.quit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail(e.getMessage());
            webDriver.quit();
        }
        finally {
            webDriver.quit();
        }
    }

    public static void main(String[] args)
    {
        SampleTest sampleTest = new SampleTest();
        sampleTest.testComposeMessage();
    }
}
