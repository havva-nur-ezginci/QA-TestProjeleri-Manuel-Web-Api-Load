package Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

public class BaseTest extends Data {
   public static WebDriver driver;
   public static Actions actions;
   public static JavascriptExecutor jse;
    public static WebDriver.Timeouts holdDriverWaitForSecond(int second){
        // sayfanın yuklenmesi veya webelement bulunması için süre verir.
       return driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    }
    // scroll down to an element in Selenium until it is visible
    public static void pageScrollDown(WebElement element){
        jse.executeScript("arguments[0].scrollIntoView();", element);
        holdDriverWaitForSecond(2);
    }
    public static void pageScrollUp(){
        jse.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
        holdDriverWaitForSecond(3);
    }
    public static void iconMove(WebElement webElement){
        pageScrollDown(webElement);
        actions.moveToElement(webElement).build().perform();
        holdDriverWaitForSecond(3);
    }
    @BeforeClass
    public static void beforeTest(){
        if (browser.equals("Edge")) {
            driver = new EdgeDriver();
        }
        else if (browser.equals("Firefox")){
            driver = new FirefoxDriver();
        }
        else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        actions = new Actions(driver);
        jse = (JavascriptExecutor)driver;
        holdDriverWaitForSecond(3);
    }

    @AfterClass
    public static void afterTest(){
        //driver.quit();
    }

}
