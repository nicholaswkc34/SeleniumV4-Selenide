package com.nicholas.manager;

import com.aventstack.extentreports.testng.listener.ExtentIReporterSuiteClassListenerAdapter;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;


import static com.codeborne.selenide.Selenide.*;

@Listeners({ExtentIReporterSuiteClassListenerAdapter.class})
public class GenericTestManager extends TestManager {

    @BeforeSuite
    public void init() {
        springInitManager.init();
    }

    @BeforeMethod
    public void openPage() {
        //Configuration.browser = System.getProperty("browser");
        //Configuration.headless = true;
        Configuration.timeout = 10000;
        open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterMethod
    public void cleanup() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        executeJavaScript("sessionStorage.clear();");
    }

    @AfterSuite
    public void tearDown() {
        // Write to html file
        extentManager.getExtentReports().flush();
        //set Email Report to stakeholder
        //mailerManager.sendEmail();
    }



    // setup In individual test
    //uiCompareManager.setup(WebDriverRunner.getWebDriver(), "Chrome-Php-Travels");

    @Test
    public void testLogin() {
        extentTest = extentManager.getExtentReports().createTest("Test 1");
        //$("asdasd").setValue("asdasd");


    }
}

/*
mvn dependency:tree or gradle dependencies

https://github.com/soydivision/Selenide-quick-FAQ

https://www.jrebel.com/blog/using-selenide-for-ui-acceptance-testing

Jira Integration
https://www.browserstack.com/guide/how-to-integrate-jira-with-selenium

https://bitbucket.org/atlassian/jira-rest-java-client/src/master/


back()
forward()
switchTo().Frame();
switchTo().defaultContent();
switchTo().window(1);
switchT0().alert();
alert.accept();
alert.dismiss();


closeWindow();
closeWebDriver();
Thread.sleep(3000);
WebDriverRunner.clearBrowserCache();
WebDriverRunner.url();
WebDriverRunner.getBrowserDownloadFolder();

Basic Auth
Using overload open();

Select HTML or Finding Selenide Elements
https://www.youtube.com/watch?v=DWD-2OJ4F4Q

actions().moveToElement().build().perform();

Drag and Drop
actions().clickAndHold(sourceElement).moveToElement(targetElement).release().build.perform();
actions().dragAndDrop().build().perform();

Right Click
actions().contextClick();


Configuration.timeout = 8000;


 */

