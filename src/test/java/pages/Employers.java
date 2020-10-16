package pages;

import framework.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Employers extends Base {

    public static final String ILO = "Ilo";
    private WebElement changeEmployeePage;
    private WebElement checkEmployeePage;
    private WebElement priceTab;


    public Employers(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void switchToTheEmployeePage(){
        changeEmployeePage = driver.findElement(By.xpath("//a[@href][contains(., 'dla pracodawcy')]"));
        changeEmployeePage.click();
        // click price tab
        priceTab = driver.findElement(By.xpath("//div[@id='sub-navigation']//li/a[contains(., 'Cennik')]"));
        priceTab.click();

        //i need to return numbers of elements from "cennik"

        //----------1-------------------
        //List - Interface -> 1
        List<WebElement> totalPriceElements = driver.findElements(By.xpath("//div[@class='nfj-pricing-table']"));
        int priceElementCount = totalPriceElements.size();
        System.out.println("Ilość ofert na stronie NFJ: " + priceElementCount);

        //----------2--------------------
        //List - class

    }

    public boolean isNoFluffEmployee(){
        changeEmployeePage = driver.findElement(By.xpath("//a[@href][contains(., 'dla pracodawcy')]"));
        changeEmployeePage.click();
        // po wykorzystaniu switchToTheEmployeePage satrona ma inny xpath!! temu changeEmployeePage nie pracuje
        checkEmployeePage = driver.findElement(By.xpath("//button[contains(., 'Zamów Pakiet Ogłoszeń')]"));
        return checkEmployeePage.isDisplayed();
    }


}
