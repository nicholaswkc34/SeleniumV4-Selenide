package com.nicholas.manager;

import com.aventstack.extentreports.testng.listener.ExtentIReporterSuiteClassListenerAdapter;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;


import static com.codeborne.selenide.Selenide.*;

@Listeners({ExtentIReporterSuiteClassListenerAdapter.class})
public class GenericTestManager extends TestManager {

    @BeforeClass
    public void init() {
        springInitManager.init();
    }

    @BeforeMethod
    public void openPage() {
        //Configuration.browser = System.getProperty("browser");
        open("https:///www.phptravels.net");
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
        mailerManager.sendEmail();
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



 */

