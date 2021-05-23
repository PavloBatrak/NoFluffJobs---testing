package pages;

import framework.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Employers extends Base {

    private WebElement changeEmployeePage;
    private WebElement checkEmployeePage;
    private WebElement priceTab;
    private WebElement eventsTab;
    private WebElement clientsTab;
    private WebElement countPriceTabElements;
    private WebElement countClientsTabElements;
    private WebElement countEventsTabElements;


    public Employers(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void switchToTheEmployeePage() {
        changeEmployeePage = driver.findElement(By.xpath("//a[@href][contains(., 'dla pracodawcy')]"));
        changeEmployeePage.click();

        priceTab = driver.findElement(By.xpath("//div[@id='sub-navigation']//li/a[contains(., 'Cennik')]"));
        priceTab.click();
        //count number of elements on PRICE tab
        // webdriver.findElements(By.xpath("required_XPATH")).size();
        int countPriceTabElements = driver.findElements(By.cssSelector("body > div:nth-child(6) > div.nfj-page-content.rebranding-pricing-page.primary-variant > section.pricing-header > div.nfj-pricing-table > article.offer-box.position-relative")).size();
        /*List<WebElement> countPriceTabElements = driver.findElements(By.xpath("*"));
        System.out.println(countPriceTabElements);*/

        clientsTab = driver.findElement(By.xpath(""));
        clientsTab.click();
        // & count number of elements on CLIENTS tab
        int countClientsTabElements = driver.findElements(By.xpath("//div[@class=\"col-lg-4 mb-5\"]")).size();

        eventsTab = driver.findElement(By.xpath(""));
        eventsTab.click();
        // & count number of elements on EVENTS tab
        int countEventsTabElements = driver.findElements(By.xpath("//div[@style=\"opacity: 1;\"]")).size();


        //i need to return numbers of elements from "cennik"

        //----------1-------------------
        //List - Interface -> 1
        List<WebElement> totalPriceElements = driver.findElements(By.xpath("//div[@class='nfj-pricing-table']"));
        int priceElementCount = totalPriceElements.size();
        System.out.println("Ilość ofert na stronie NFJ: " + priceElementCount);

        //----------2--------------------
        //List - class

    }

    public boolean isNoFluffEmployee() {
        changeEmployeePage = driver.findElement(By.xpath("//a[@href][contains(., 'dla pracodawcy')]"));
        changeEmployeePage.click();
        // po wykorzystaniu switchToTheEmployeePage satrona ma inny xpath!! temu changeEmployeePage nie pracuje
        checkEmployeePage = driver.findElement(By.xpath("//button[contains(., 'Zamów Pakiet Ogłoszeń')]"));
        return checkEmployeePage.isDisplayed();
    }


}
