package pages;

import framework.Base;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class MainPage extends Base {

    //public boolean pageLogo;
    private WebElement pageLogo;
    private WebElement languageElement;
    private WebElement languageArea;
    private WebElement concreteLanguage;
    private WebElement trueLanguage;

    private WebElement countryElement;
    private WebElement countryArea;
    private WebElement concreteCountry;
    private WebElement trueCountry;

    private WebElement searchJobField;
    private WebElement buttonSearch;

    public MainPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isNoFluffJobs(){
        pageLogo = driver.findElement(By.xpath("//a[@class='p-0 navbar-brand']"));
        return pageLogo.isDisplayed();
    }

    public void changeLanguage(String pickLanguage){
        languageElement = driver.findElement
                (By.xpath("//nav[@class='navbar fixed-top navbar-expand-lg navbar-light']//ul[2]//li[4]"));
        languageElement.click();
        languageArea = driver.findElement
                (By.xpath("//div[@class='language-picker show dropdown']"));
        wait.until(ExpectedConditions.visibilityOf(languageArea));
        // ExpectedConditions has visibilityOf
        concreteLanguage = driver.findElement
                (By.xpath("//div[@class='language-picker show dropdown']/ul/li[2]"));
        concreteLanguage.click();
        trueLanguage = driver.findElement
                (By.xpath("//div[@class='container']//span[contains(., 'Technology')]"));
        wait.until(ExpectedConditions.visibilityOf(trueLanguage));
    }

    public void changeCountry(String newCountry){
        countryElement = driver.findElement
                (By.xpath("//nav[@class='navbar fixed-top navbar-expand-lg navbar-light']//ul[2]//li[5]"));
        countryElement.click();
        countryArea = driver.findElement
                (By.xpath("//div[@class='region-picker show dropdown']"));
        wait.until(ExpectedConditions.visibilityOf(countryArea));
        concreteCountry = driver.findElement
                (By.xpath("//div[@class='region-picker show dropdown']/ul/li[2]"));
        concreteCountry.click();
        trueCountry = driver.findElement
                (By.xpath("//div[@class='container']//span[contains(., 'Helyszín')]"));
        wait.until(ExpectedConditions.visibilityOf(trueCountry));
    }

    public void checkJobOffers (List<String> list){

        List<String> results = new ArrayList<String>();
        buttonSearch = driver.findElement
                (By.xpath("//button[@class='btn btn-search']"));
        searchJobField = driver.findElement
                (By.xpath("//div[@class='ng-select-container']"));
        //[class~='ng-select-container']
        wait.until(ExpectedConditions.visibilityOf(searchJobField));
        searchJobField.sendKeys("testing");
        //wait.until(ExpectedConditions.textToBePresentInElement(searchJobField, "testing"));
        //searchJobField.sendKeys(Keys.ENTER);
        buttonSearch.click();

        List<WebElement> jobElements = driver.findElements
                (By.xpath("//div[@class='mt-5']//a/@href"));

        for (int i = 0; i < jobElements.size(); i++) {
            results.add(jobElements.get(i).getText());
        }
        Collections.sort(list);
        Collections.sort(results);

        assertEquals(results, list);

    }

}
