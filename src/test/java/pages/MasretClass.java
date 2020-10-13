package pages;

import framework.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class MasretClass extends Base {

    private WebElement titleMasterClass;
    private WebElement changeMasterClassTab;

    public MasretClass(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isMasterClassTitleApsent(){
        changeMasterClassTab = driver.findElement(By.xpath("//a[@href='/masterclazz']"));
        changeMasterClassTab.click();
        System.out.println(driver.getTitle());
        Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ids.iterator();
        String parentTab = it.next();
        String childTab = it.next();
        driver.switchTo().window(childTab);
        System.out.println(driver.getTitle());
        titleMasterClass = driver.findElement(By.xpath("//h2[contains(., 'Masterclazz w liczbach')]"));
        return titleMasterClass.isDisplayed();
    }


}
