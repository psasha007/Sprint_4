package additionaltes;

import constants.Consts;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    // запуск WebDriver fireFox
    public WebDriver fireFox(WebDriver driver, String baseUrl){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Consts.TIME_OUT_IN_SECONDS, TimeUnit.SECONDS);
        driver.get(baseUrl);
        return driver;
    }

    // запуск WebDriver chrome
    public WebDriver chrome(WebDriver driver, String baseUrl){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Consts.TIME_OUT_IN_SECONDS, TimeUnit.SECONDS);
        driver.get(baseUrl);
        return driver;
    }

    // запуск WebDriver chrome c Options
    public WebDriver chromeOptions(WebDriver driver, String baseUrl){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get(baseUrl);
        return driver;
    }
}
