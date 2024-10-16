package pro.vasudevan.base;

import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pro.vasudevan.automation.unifiedtestframework.base.ElementBase;

import static pro.vasudevan.automation.unifiedtestframework.config.IWebDriverConfig.*;

/*
Created By: Vasudevan Sampath

TestBase.java initializes Selenium driver object and initializes object repo
 */
public class TestBase extends ElementBase {

    @BeforeSuite(alwaysRun = true)
    public void initSuite() throws Exception {
        initObjectRepo();
    }

    @BeforeTest(alwaysRun = true)
    public void initTest(ITestContext testContext) throws InterruptedException {
        initDriver(testContext);
    }

    @AfterTest(alwaysRun = true)
    public void cleanup() {
        tearDown();
    }
}
