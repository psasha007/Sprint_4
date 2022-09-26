package additionaltes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class AdditionalTest {
    String nameDriver = "chrome";
    WebDriver driver;
    String baseUrl = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void startUp() {
        switch (nameDriver) {
            case "firefox" :
                System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.get(baseUrl);
                break;
            case "chrome" :
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.get(baseUrl);
                break;
            case "chromeOptions" :
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
                driver = new ChromeDriver(options);
                driver.get(baseUrl);
                break;
        }
    }

    @Test
    // Проверить: если нажать на логотип «Самоката», попадёшь на главную страницу «Самоката».
    public void verifyScooterLogoHomePageTest(){
        driver.findElement(By.className("Header_LogoScooter__3lsAR")).click();
        String expected = "https://qa-scooter.praktikum-services.ru/";
        WebElement actual = driver.findElement(By.className("Home_Header__iJKdX"));
        Assert.assertEquals("Ошибка, url не совпадает: ", expected, driver.getCurrentUrl());
    }

    @Test
    // Проверить: если нажать на логотип Яндекса, в новом окне откроется главная страница Яндекса.
    public void verifyYandexLogoHomePageTest() throws InterruptedException {
        driver.findElement(By.cssSelector("#root > div > div > div.Header_Header__214zg > div.Header_Logo__23yGT > a.Header_LogoYandex__3TSOI")).click();
        sleep(3000);
        Set<String> s = driver.getWindowHandles();
        Iterator<String> I1= s.iterator();
        String child_window=I1.next();
        child_window=I1.next();
        driver.switchTo().window(child_window);
        String expected1 = "https://dzen.ru/?yredirect=true";
        Assert.assertEquals("Ошибка, url не совпадает: ", expected1, driver.getCurrentUrl());
    }

    @Test
    //Проверить ошибки для всех полей формы заказа.
    public void testVerifyErrorsForOrderFormFields() throws InterruptedException {
        ErrorsForOrderFormFields verifyWhoIs = new ErrorsForOrderFormFields(driver);
        verifyWhoIs.clickHomePageUpButton();
        verifyWhoIs.verifyTextErrors(
                "Введите корректное имя",
                "Введите корректную фамилию",
                "~!#",
                "Введите корректный адрес",
                "Выберите станцию",
                "Введите корректный номер"
                );
    }

    @Test
    // Проверить: если ввести неправильный номер заказа, попадёшь на страницу статуса заказа. На ней должно быть написано, что такого заказа нет.
    public void testVerifyWrongOrderNumber() throws InterruptedException {
        driver.findElement(By.className("Header_Link__1TAG7")).click();
        driver.findElement(By.xpath("//*[@placeholder=\"Введите номер заказа\"]")).sendKeys("3615589");
        sleep(1000);
        driver.findElement(By.cssSelector(".Button_Button__ra12g.Header_Button__28dPO")).click();

        WebElement actual = driver.findElement(By.xpath(".//img[@alt='Not found']"));
        sleep(1500);
        Assert.assertTrue(actual.isDisplayed());
    }

    //
    @After
    public void after(){
        driver.quit();
    }
}
