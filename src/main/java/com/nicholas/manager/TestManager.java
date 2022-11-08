package com.nicholas.manager;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.aventstack.extentreports.testng.listener.commons.ExtentTestCommons;
import com.nicholas.pages.LoginPages;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class TestManager {

    protected DAOManager daoManager;
    protected MFAManager mfaManager;
    protected UICompareManager uiCompareManager;
    protected CryptoManager cryptoManager;
    protected SpringInitManager springInitManager;
    protected MailerManager mailerManager;
    protected ExtentManager extentManager;
    protected CaptchaManager captchaManager;
    protected PropertiesManager propertiesManager;
    protected BrokenLinkChecker brokenLinkChecker;

    protected ExtentTest extentTest;

    // ==========================================================================
    @Autowired
    protected LoginPages loginPages;

    public TestManager() {
        daoManager = new DAOManager();
        mfaManager = new MFAManager();
        mailerManager = new MailerManager();
        extentManager = new ExtentManager();
        //uiCompareManager = new UICompareManager();
        cryptoManager = CryptoManager.getInstance(System.getProperty("user.dir") + "\\credential\\salt.txt");
        springInitManager = new SpringInitManager();
        captchaManager = new CaptchaManager();
        propertiesManager = PropertiesManager.createInstance();
        brokenLinkChecker = new BrokenLinkChecker();
    }





}
