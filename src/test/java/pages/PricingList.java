package pages;

import framework.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class PricingList extends Base {

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



    static final Map<String, String> expectedResults = new HashMap<>(){{
        expectedResults.put("Basic", "490 PLN");
        expectedResults.put("Standard", "690 PLN");
        expectedResults.put("Premium", "990 PLN");
        expectedResults.put("All-star", "1990 PLN");
    }};
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
        String price = firstPriceElement.getText().trim();       //check for blanks
        // remove blank spaces -> .replaceAll("\\s+","")
        // .trim() --> space remove

        firstValueElement = driver.findElement(By.xpath("//div[@class='nfj-pricing-table']//h4[contains(., '490')]//span"));
        String value = firstValueElement.getText().trim();
        return price + " " + value;
    }

    public String getSecondPriceValue(){
        secondPriceElement = driver.findElement(By.xpath("//div[@class='nfj-pricing-table']//h4[contains(., '690')]"));
        String price = secondPriceElement.getText().trim();       //check for blanks
        // remove blank spaces -> .replaceAll("\\s+","")

        secondValueElement = driver.findElement(By.xpath("//div[@class='nfj-pricing-table']//h4[contains(., '690')]//span"));
        String value = secondValueElement.getText().trim();
        return price + " " + value;
    }
    public String getThirdPriceValue(){
        thirdPriceElement = driver.findElement(By.xpath("//div[@class='nfj-pricing-table']//h4[contains(., '990')]"));
        String price = thirdPriceElement.getText().trim();       //check for blanks
        // remove blank spaces -> .replaceAll("\\s+","")

        thirdValueElement = driver.findElement(By.xpath("//div[@class='nfj-pricing-table']//h4[contains(., '990')]//span"));
        String value = thirdValueElement.getText().trim();
        return price + " " + value;
    }
    public String getFourthPriceValue(){
        fourthPriceElement = driver.findElement(By.xpath("//div[@class='nfj-pricing-table']//h4[contains(., '1990')]"));
        String price = fourthPriceElement.getText().trim();       //check for blanks
        // remove blank spaces -> .replaceAll("\\s+","")

        fourthValueElement = driver.findElement(By.xpath("//div[@class='nfj-pricing-table']//h4[contains(., '1990')]//span"));
        String value = fourthValueElement.getText().trim();
        return price + " " + value;
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
        assertEquals(actualResults(), expectedResults);
    }


}
