package uitest;

import framework.Base;

import static org.testng.Assert.assertTrue;

import framework.IConstans;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public void mainTestLogo() {
        MainPage nfj = new MainPage(driver, wait);
        assertTrue(nfj.isNoFluffJobs());
    }

    @Test
    public void changePageLanguage(){
        MainPage nfj = new MainPage(driver, wait);
        nfj.changeLanguage(" English ");
    }

    @Test
    public void changeLocalization(){
        MainPage nfj = new MainPage(driver, wait);
        //nfj.changeCountry(" Hungary (HU) ");
    }

    @Test
    public void checkJobOffersOnThePage(){
        MainPage nfj = new MainPage(driver, wait);
        nfj.checkJobOffers(JOB_OFFERS);
    }

    @Test
    public void checkMap(){
        //to do
    }

    @Test
    public void checkFilters(){
        //to do
    }

    @AfterTest
    private void end() {
        driver.close();
    }

}
