package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Base {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public WebDriver initializeDriver (){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pasha\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }

    protected WebDriverWait getWait(){

        wait = new WebDriverWait(this.driver, 5);
        return wait;

    }

}
