package uitest;

import framework.Base;

import static org.testng.Assert.assertTrue;

import framework.IConstans;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.MainPage;

public class TestNFJ extends Base implements IConstans {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    private void setUp() {
        driver = initializeDriver();
        wait = getWait();
        driver.get("https://nofluffjobs.com/");
    }


    @Test
    private void mainTest() {
        MainPage nfj = new MainPage(driver, wait);
        assertTrue(nfj.isNoFluffJobs());
        nfj.changeLanguage(" English ");
        //nfj.changeCountry(" Hungary (HU) ");
        nfj.checkJobOffers(JOB_OFFERS);

    }

    @AfterTest
    private void end() {
        driver.close();
    }

}
