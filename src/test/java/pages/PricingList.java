package pages;

import framework.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class PricingList extends MainPage {

    //get - public
    //set - private

    private WebElement firstKeyElement;
    private WebElement secondKeyElement;
    private WebElement thirdKeyElement;
    private WebElement fourthKeyElement;

    private WebElement firstPriceElement;
    private WebElement secondPriceElement;
    private WebElement thirdPriceElement;
    private WebElement fourthPriceElement;

    private WebElement firstValueElement;
    private WebElement secondValueElement;
    private WebElement thirdValueElement;
    private WebElement fourthValueElement;

    public PricingList(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /*public PricingList (WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }*/

    public HashMap<String, String> getExpectedResults() {
        //Map - interface
        //HashMap - polimorph-object(realization)
        HashMap<String, String> res = new HashMap<>();
            res.put("Basic", "490 PLN");
            res.put("Standard", "690 PLN");
            res.put("Premium", "990 PLN");
            res.put("All-star", "1990 PLN");
        return res;
    }
    //this is expected results. What i want to compare with actual results on the page

    public String getFirstKey(){
        firstKeyElement = driver.findElement(By.xpath("//div[@class='title-box']//h3[contains(., 'Basic')]"));
        return firstKeyElement.getText();
    }

    public String getSecondKey(){
        //to do
        secondKeyElement = driver.findElement(By.xpath("//div[@class='title-box']//h3[contains(., 'Standard')]"));
        return secondKeyElement.getText();
    }

    public String getThirdKey(){
        //to do
        thirdKeyElement= driver.findElement(By.xpath("//div[@class='title-box']//h3[contains(., 'Premium')]"));
        return thirdKeyElement.getText();
    }

    public String getFourthKey(){
        //to do
        fourthKeyElement= driver.findElement(By.xpath("//div[@class='title-box']//h3[contains(., 'All-star')]"));
        return fourthKeyElement.getText();
    }

    public String getFirstPriceValue(){
        firstPriceElement = driver.findElement(By.xpath("//div[@class='nfj-pricing-table']//h4[contains(., '490')]"));
        String price = firstPriceElement.getText().replace("\n", " ");       //check for blanks
        // remove blank spaces -> .replaceAll("\\s+","")
        // .trim() --> space remove

        firstValueElement = driver.findElement(By.xpath("//div[@class='nfj-pricing-table']//h4[contains(., '490')]//span"));
        String value = firstValueElement.getText();
        return price;
    }

    public String getSecondPriceValue(){
        secondPriceElement = driver.findElement(By.xpath("//div[@class='nfj-pricing-table']//h4[contains(., '690')]"));
        String price = secondPriceElement.getText().replace("\n", " ");       //check for blanks
        // remove blank spaces -> .replaceAll("\\s+","")

        secondValueElement = driver.findElement(By.xpath("//div[@class='nfj-pricing-table']//h4[contains(., '690')]//span"));
        String value = secondValueElement.getText();
        return price;
    }
    public String getThirdPriceValue(){
        thirdPriceElement = driver.findElement(By.xpath("//div[@class='nfj-pricing-table']//h4[contains(., '990')]"));
        String price = thirdPriceElement.getText().replace("\n", " ");       //check for blanks
        // remove blank spaces -> .replaceAll("\\s+","")

        thirdValueElement = driver.findElement(By.xpath("//div[@class='nfj-pricing-table']//h4[contains(., '990')]//span"));
        String value = thirdValueElement.getText();
        return price;
    }
    public String getFourthPriceValue(){
        fourthPriceElement = driver.findElement(By.xpath("//div[@class='nfj-pricing-table']//h4[contains(., '1990')]"));
        String price = fourthPriceElement.getText().replace("\n", " ");       //check for blanks
        // remove blank spaces -> .replaceAll("\\s+","")

        fourthValueElement = driver.findElement(By.xpath("//div[@class='nfj-pricing-table']//h4[contains(., '1990')]//span"));
        String value = fourthValueElement.getText();
        return price;
    }

    private HashMap<String, String> actualResults (){
        HashMap<String, String> res = new HashMap<>();
        res.put(getFirstKey(), getFirstPriceValue());
        res.put(getSecondKey(), getSecondPriceValue());
        res.put(getThirdKey(), getThirdPriceValue());
        res.put(getFourthKey(), getFourthPriceValue());
        return res;
        //this method return a HashMap actual results
    }

    public void checkValueResult(){
        assertEquals(actualResults(), getExpectedResults());
    }


}
