package pro.vasudevan.suites.smoke;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pro.vasudevan.base.TestBase;
import pro.vasudevan.pages.HomePage;
import pro.vasudevan.testdataframework.interfaces.TestData;
import pro.vasudevan.testdataframework.util.CSVTestDataProvider;

import java.util.LinkedHashMap;

/*
Created By: Vasudevan Sampath

SmokeTests.java has all smoke tests
Uses custom @TestData annotation for data driven testing
*/
public class SmokeTests extends TestBase {

    private HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        homePage = new HomePage();
    }

    @Test(priority = 0)
    public void validateIfBagLinkIsDisplayedTest() {
        Assert.assertTrue(homePage.didBagExist(), "Bag link is not visible");
    }

    @Test(priority = 1)
    public void validateIfTopLevelResourcesAreDisplayedTest() {
        Assert.assertTrue(homePage.didTopLevelResourcesExist(), "Top Level resource count is incorrect");
    }

    @Test(priority = 2)
    public void validateIfGlobalNavLinksIsDisplayedTest() {
        Assert.assertTrue(homePage.didGlobalNavLinksExist(), "Global links count is incorrect");
    }

    @Test(priority = 3, dataProviderClass = CSVTestDataProvider.class, dataProvider = "TestDataProvider", enabled = false)
    @TestData(file = "topLevelResourceNames.csv")
    public void verifyTopLevelLinksTest(LinkedHashMap<String, String> linkedHashMap) {
        Assert.assertTrue(homePage.areTopLevelLinksAvailable(linkedHashMap), "Top Level resource links not matching with expected data");
    }

    @Test(priority = 4)
    public void verifyProductLinkCountTest() {
        Assert.assertTrue(homePage.didProductLinksExist(), "Product links count is incorrect");
    }

    @Test(priority = 5, dataProviderClass = CSVTestDataProvider.class, dataProvider = "TestDataProvider")
    @TestData(file = "productResourceNames.csv")
    public void verifyProductLinksTest(LinkedHashMap<String, String> linkedHashMap) {
        Assert.assertTrue(homePage.areProductLinksAvailable(linkedHashMap), "Product links not matching with expected data");
    }

    @Test(priority = 6)
    public void validateProductImageComparisonTest() throws Exception {
        Assert.assertTrue(homePage.areImagesIdentical(), "Images not matching");
    }
}
