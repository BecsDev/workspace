package pageObject;

import framework.ConfigTest;
import org.openqa.selenium.By;

public class GooglePO extends ConfigTest {
    static By txtSearch = By.className("gLFyf");
    static By btnSearch = By.name("btnK");
    static By divResult = By.id("resultStats");

    public static void setTxtSearch (String sDirector, String sMovie){
        verifyElementExist(txtSearch,15);
        driver.findElement(txtSearch).clear();
        waitTime(100);
        driver.findElement(txtSearch).sendKeys(sDirector +" - "+sMovie);
        waitTime(300);
    }

    public static void clickBtnSearch (){
        verifyElementExist(btnSearch, 15);
        driver.findElement(btnSearch).click();
        waitTime(200);
    }

    public static String getResult(){
        verifyElementExist(divResult, 15);
        String sResult = driver.findElement(divResult).getText();
        waitTime(300);
        return sResult;
    }
}
