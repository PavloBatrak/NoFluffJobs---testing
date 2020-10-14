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

import pages.CompaniesProfile;
import pages.Employers;
import pages.MainPage;
import pages.MasretClass;

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

    @Test
    public void switchPageToTheCompany(){
        CompaniesProfile nfj = new CompaniesProfile(driver, wait);
        nfj.switchJobOffersPageToTheCompaniesPage();
        nfj.checkCompaniesFilter("Epam Systems");
    }

    /*@Test
    public void checkCompaniesFilters(){
        CompaniesProfile nfj = new CompaniesProfile(driver, wait);

    }*/

    @Test
    public void titleMasterClassOnThePage(){
        MasretClass nfj = new MasretClass(driver, wait);
        assertTrue(nfj.isMasterClassTitleApsent());
    }

    @Test
    public void changeEmployeeTab(){

    }

    @Test
    public void employeeLogoTest(){
        Employers nfj = new Employers(driver, wait);
        assertTrue(nfj.isNoFluffEmployee());
    }

    @AfterTest
    private void end() {
        driver.close();
    }

}
