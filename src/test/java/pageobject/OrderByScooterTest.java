package pageobject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;
import org.junit.runners.Parameterized;

import static java.lang.Thread.sleep;

@RunWith(Parameterized.class)
// Класс заказ самоката
public class OrderByScooterTest {
    String nameDriver = "chrome";
    WebDriver driver;
    String baseUrl = "https://qa-scooter.praktikum-services.ru/";

    private final String userName;
    private final String surName;
    private final String adress;
    private final String nameMetro;
    private final String numbetForCourier;
    private final String date;
    private final String textForCourier;
    private final String verifyText;

    public OrderByScooterTest(
            String userName,
            String surName,
            String adress,
            String nameMetro,
            String numbetForCourier,
            String date,
            String textForCourier,
            String verifyText)
    {
        this.userName = userName;
        this.surName = surName;
        this.adress = adress;
        this.nameMetro = nameMetro;
        this.numbetForCourier = numbetForCourier;
        this.date = date;
        this.textForCourier = textForCourier;
        this.verifyText = verifyText;
    }

    @Parameterized.Parameters
    public static Object[] getSumData()
    {
        return new Object[][]
                { // передали тестовые данные
                        {"Иван", "Иванов", "Москва", "беляево", "+79155230012", "22.09.2022", "Позвонить за час", "Заказ оформлен"},
                        {"Василиса", "Иванова", "Москва", "коньково", "+79155230011", "23.09.2022", "Позвонить за 2 часа", "Заказ оформлен"},
                };
    }

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
    public void testClickUpButton() throws InterruptedException {

        DialogPageWhoIsTheScooterFor dialogPageWhoIs = new DialogPageWhoIsTheScooterFor(driver);
        DialogPageAboutRent dialogPageAboutRent = new DialogPageAboutRent(driver);

        sleep(1000);
        dialogPageWhoIs.clickHomePageUpButton();

        sleep(1000);
        dialogPageWhoIs.setWhoIs(userName, surName, adress, nameMetro, numbetForCourier);

        sleep(2000);
        dialogPageAboutRent.setAboutRent(date, textForCourier, verifyText);

        sleep(2000);
    }

    @Test
    public void testClickDownButton() throws InterruptedException {

        DialogPageWhoIsTheScooterFor dialogPageWhoIs = new DialogPageWhoIsTheScooterFor(driver);
        DialogPageAboutRent dialogPageAboutRent = new DialogPageAboutRent(driver);

        WebElement element = driver.findElement(By.cssSelector(".Button_Button__ra12g.Button_UltraBig__UU3Lp"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        sleep(1000);
        dialogPageWhoIs.clickHomePageDownButton();

        sleep(1000);
        dialogPageWhoIs.setWhoIs(userName, surName, adress, nameMetro, numbetForCourier);

        sleep(2000);
        dialogPageAboutRent.setAboutRent(date, textForCourier, verifyText);

        sleep(2000);
    }

    //
    @After
    public void after(){
        driver.quit();
    }
}
