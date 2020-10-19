package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;

public class PricingList2 extends MainPage {

    //get - public
    //set - private


    public PricingList2(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getFirstKeyElement() {
        return driver.findElement(By.xpath("//div[@class='title-box']//h3[contains(., 'Basic')]"));
    }

    public WebElement getSecondKeyElement() {
        return driver.findElement(By.xpath("//div[@class='title-box']//h3[contains(., 'Standard')]"));
    }

    public WebElement getThirdKeyElement() {
        return driver.findElement(By.xpath("//div[@class='title-box']//h3[contains(., 'Premium')]"));
    }

    public WebElement getFourthKeyElement() {
        return driver.findElement(By.xpath("//div[@class='title-box']//h3[contains(., 'All-star')]"));
    }

    public WebElement getFirstPriceElement() {
        return driver.findElement(By.xpath("//div[@class='nfj-pricing-table']//h4[contains(., '490')]"));
    }

    public WebElement getSecondPriceElement() {
        return driver.findElement(By.xpath("//div[@class='nfj-pricing-table']//h4[contains(., '690')]"));
    }

    public WebElement getThirdPriceElement() {
        return driver.findElement(By.xpath("//div[@class='nfj-pricing-table']//h4[contains(., '990')]"));
    }

    public WebElement getFourthPriceElement() {
        return driver.findElement(By.xpath("//div[@class='nfj-pricing-table']//h4[contains(., '1990')]"));
    }

    public HashMap<String, String> getExpectedResults() {
        //Map - interface
        //HashMap - polimorph-object(realization)
        return new HashMap<>() {{
            put("Basic", "490 PLN");
            put("Standard", "690 PLN");
            put("Premium", "990 PLN");
            put("All-star", "1990 PLN");
        }};
    }
    //this is expected results. What i want to compare with actual results on the page

    public String getFirstKey() {
        return getFirstKeyElement().getText();
    }

    public String getSecondKey() {
        return getSecondKeyElement().getText();
    }

    public String getThirdKey() {
        return getThirdKeyElement().getText();
    }

    public String getFourthKey() {
        return getFourthKeyElement().getText();
    }

    public String getFirstPriceValue() {
        //String price = getFirstPriceElement.getText().replace("\n", " ");       //check for blanks
        // remove blank spaces -> .replaceAll("\\s+","")
        // .trim() --> space remove
        return getFirstPriceElement().getText().replace("\n", " ");
    }

    public String getSecondPriceValue() {
        return getSecondPriceElement().getText().replace("\n", " ");
    }

    public String getThirdPriceValue() {
       return getThirdPriceElement().getText().replace("\n", " ");
    }

    public String getFourthPriceValue() {
       return getFourthPriceElement().getText().replace("\n", " ");
    }

    private HashMap<String, String> actualResults() {
        return new HashMap<>() {{
            put(getFirstKey(), getFirstPriceValue());
            put(getSecondKey(), getSecondPriceValue());
            put(getThirdKey(), getThirdPriceValue());
            put(getFourthKey(), getFourthPriceValue());
        }};
        //this method return a HashMap actual results
    }

    public void checkValueResult() {
        assertEquals(actualResults(), getExpectedResults());
    }


}
