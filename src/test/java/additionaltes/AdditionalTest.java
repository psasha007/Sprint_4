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
        ErrorsForOrderFormFields testUrl = new ErrorsForOrderFormFields(driver);
        testUrl.isCheckUrlScooterLogoHomePage("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    // Проверить: если нажать на логотип Яндекса, в новом окне откроется главная страница Яндекса.
    public void verifyYandexLogoHomePageTest() throws InterruptedException {
        ErrorsForOrderFormFields testUrl = new ErrorsForOrderFormFields(driver);
        testUrl.isCheckYandexLogoHomePage("https://dzen.ru/?yredirect=true");
    }

    @Test
    //Проверить ошибки для всех полей формы заказа.
    public void verifyErrorsForOrderFormFieldsTest() throws InterruptedException {
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
    public void verifyWrongOrderNumberTest() throws InterruptedException {
        ErrorsForOrderFormFields testImageNotFound = new ErrorsForOrderFormFields(driver);
        testImageNotFound.isCheckWrongOrderNumber("3615589");
    }

    //
    @After
    public void after(){
        driver.quit();
    }
}
