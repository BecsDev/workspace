package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ConfigTest {
    public static WebDriver driver;

    /**
     * Create a Protected static WebDriver Object.
     *
     * @param browserNumber 2 - Chrome &nbsp; - Windows S.O ONLY - REMOVED
     *                      <p>
     *                      1 - Internet Explorer - Windows S.O ONLY (of course) - REMOVED
     *                      <p>
     * @return A static object to ConfigTest.driver protected var.
     * @author Bruno Correia
     */

    public static WebDriver setUpDriver() {
        try {
            System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            options.setExperimentalOption("useAutomationExtension", false);
            options.setExperimentalOption("prefs", prefs);
            //options.addArguments("headless");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            //PageFactory.initElements(driver,this);
            waitPageLoad(120);
        } catch (Exception e) {
            e.getStackTrace();
            e.getMessage();
        }
        return driver;
    }

    /**
     * Configura o tempo maximo de espera do carregamento da pagina.
     *
     * @param seconds &nbsp; Tempo de espera do carregamento da pagina em segundos.
     * @author Bruno Correia
     */
    private static void waitPageLoad(int seconds) {
        driver.manage().timeouts()
                .pageLoadTimeout(seconds, TimeUnit.SECONDS);
    }

    /**
     * Configura o tempo maximo de espera de carregamento do elemento que compõe a página.
     *
     * @param seconds &nbsp; Tempo de espera do carregamento do elemento da pagina.
     * @author Bruno Correia
     */

    private static void waitElementLoad(int seconds) {
        driver.manage().timeouts()
                .implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static void openBrowser(String sURL){
        driver.get(sURL);
        waitTime(500);
    }

    /**
     * Finaliza browser
     *
     * @param seconds &nbsp; Fecha o browser
     * @author Bruno Correia
     */
    public static void closeBrowser() {
        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }

    public static void waitTime(int iTempMilli) {
        try {
            Thread.sleep(iTempMilli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean verifyElementExist(By sObj, int iTimeSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, iTimeSeconds);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(sObj));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
