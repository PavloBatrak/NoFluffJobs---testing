package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;

public class PricingList3 extends MainPage {

    public PricingList3(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public static final String KEY_ELEMENT = "//div[@class='title-box']//h3[contains(., '%s')]";
    public static final String PRICE_ELEMENT = "//div[@class='nfj-pricing-table']//h4[contains(., '%s')]";


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

    public String getKey(String key) {
        return driver.findElement(By.xpath(String.format(KEY_ELEMENT, key))).getText();
    }

    public String getPrice(String price) {
        return driver.findElement(By.xpath(String.format(PRICE_ELEMENT, price))).getText().replace("\n", " ");
    }


    private HashMap<String, String> actualResults() {
        return new HashMap<>() {{
            put(getKey("Basic"), getPrice("490"));
            put(getKey("Standard"), getPrice("690"));
            put(getKey("Premium"), getPrice("990"));
            put(getKey("All-star"), getPrice("1990"));

        }};
        //this method return a HashMap actual results
    }

    public void checkValueResult() {
        assertEquals(actualResults(), getExpectedResults());
    }


}
