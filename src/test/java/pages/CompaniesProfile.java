package pages;

import framework.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompaniesProfile extends MainPage {

    private WebElement switchTab;
    private WebElement trueCompaniesPage;
    private WebElement companyNameFilter;
    private WebElement findCompanyToTheTest;
    private WebElement alphabetCompanyFilter;
    private WebElement applyButtonClick;


    public CompaniesProfile(WebDriver driver, WebDriverWait wait){ super(driver, wait); }

    public void switchJobOffersPageToTheCompaniesPage (){

        switchTab = driver.findElement(By.xpath("//a[contains(., ' profile firm ')]"));
        switchTab.click();
        trueCompaniesPage = driver.findElement
                (By.xpath("//h1[contains(., 'Wszystkie firmy')]"));
        wait.until(ExpectedConditions.visibilityOf(trueCompaniesPage));
    }

    public void checkCompaniesFilter (String companyTest){

        companyNameFilter = driver.findElement(By.xpath("//div[@class='filters']//span[contains(., 'Nazwa')]"));
        companyNameFilter.click();
        alphabetCompanyFilter = driver.findElement(By.xpath("//div[@class='popover-body']"));
        wait.until(ExpectedConditions.visibilityOf(alphabetCompanyFilter));
        findCompanyToTheTest = driver.findElement(By.xpath("//div[@class='popover-body']//button[contains(., 'E')]"));
        findCompanyToTheTest.click();
        applyButtonClick = driver.findElement(By.xpath("//div[@class='buttons']//div[1]//button[contains(., ' Zatwierdź ')]"));
        applyButtonClick.click();
    }


}
