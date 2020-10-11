package pages;

import framework.Base;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends Base implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

        //ScreenShots

        WebDriver driver = null; // simple dummy driver

        String testMethodName = result.getMethod().getMethodName(); // this step automatically capture Failure test name
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (Exception e) {

        }  /*{

        }*/
        //to get access to fields of any class using TestNG Listeners
        // 1 - first I'm trying to access that test class -> getTestClass
        // 2 -  get in stands in that class -> getRealClass
        // 3 - in that class (getRealClass) I'm trying to retrieve the field get declared it field -> (driver)
        // 4 - access to the driver -> get(result.getInstance())
        try {
            getScreenShotsPath(testMethodName, driver);   // when capture, send argument to getScreenShotsPath
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
