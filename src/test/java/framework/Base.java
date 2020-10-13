package framework;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Base {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public WebDriver initializeDriver (){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pasha\\Downloads\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }

    protected WebDriverWait getWait(){

        wait = new WebDriverWait(this.driver, 5);
        return wait;

    }

    public void getScreenShotsPath(String testCaseName, WebDriver driver ) throws IOException {        // <-- This method is expect 1 test case name
        TakesScreenshot ts = (TakesScreenshot) driver;  // this variable is response to take a screenshots
        File source = ts.getScreenshotAs(OutputType.FILE);  // 1) file where screenshots is capture
        // 2) This file exist in Selenium, but not in LocalMachine systems
        String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + " .png" ;   // destination path where screenshot is store
        FileUtils.copyFile(source, new File(destinationFile)); // copy file from source to my local system

    }

}
