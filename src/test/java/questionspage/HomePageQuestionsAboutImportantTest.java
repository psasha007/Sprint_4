package questionspage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import static java.lang.Thread.sleep;

// Класс для проверки текстов раздела главной страницы "Вопросы о важном"
public class HomePageQuestionsAboutImportantTest {
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
        // Прокрутка до элемента на странице "Самокат на пару дней"
        WebElement element = driver.findElement(By.cssSelector("#accordion__heading-7"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // HowMuchDoesItCostAndHowToPay - Сколько это стоит? И как оплатить?
    @Test
    public void isTextHowMuchDoesItCostAndHowToPay() throws InterruptedException {
        //new WebDriverWait(driver, 3);
        sleep(1000);
        driver.findElement(By.cssSelector("#accordion__heading-0")).click();

        sleep(1000);
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        WebElement actual = driver.findElement(By.cssSelector("#accordion__panel-0"));

        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // IWantSeveralScootersSoItIsPossible - Хочу сразу несколько самокатов! Так можно?
    @Test
    public void isTextIWantSeveralScootersSoItIsPossible() throws InterruptedException {
        sleep(1000);
        driver.findElement(By.cssSelector("#accordion__heading-1")).click();

        sleep(1000);
        String expected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        WebElement actual = driver.findElement(By.cssSelector("#accordion__panel-1"));

        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // HowIsTheRentalTimeCalculated - Как рассчитывается время аренды?
    @Test
    public void isTextHowIsTheRentalTimeCalculated() throws InterruptedException {
        sleep(1000);
        driver.findElement(By.cssSelector("#accordion__heading-2")).click();

        sleep(1000);
        String expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        WebElement actual = driver.findElement(By.cssSelector("#accordion__panel-2"));

        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // IsItPossibleToOrderAScooterRightForToday - Можно ли заказать самокат прямо на сегодня?
    @Test
    public void isTextIsItPossibleToOrderAScooterRightForToday() throws InterruptedException {
        sleep(1000);
        driver.findElement(By.cssSelector("#accordion__heading-3")).click();

        sleep(1000);
        String expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        WebElement actual = driver.findElement(By.cssSelector("#accordion__panel-3"));

        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // CanIExtendTheOrderOrReturnTheScooterEarlier - Можно ли продлить заказ или вернуть самокат раньше?
    @Test
    public void isTextCanIExtendTheOrderOrReturnTheScooterEarlier() throws InterruptedException {
        sleep(1000);
        driver.findElement(By.cssSelector("#accordion__heading-4")).click();

        sleep(1000);
        String expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        WebElement actual = driver.findElement(By.cssSelector("#accordion__panel-4"));

        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // DoYouBringChargersWithTheScooter - Вы привозите зарядку вместе с самокатом?
    @Test
    public void isTextDoYouBringChargersWithTheScooter() throws InterruptedException {
        sleep(1000);
        driver.findElement(By.cssSelector("#accordion__heading-5")).click();

        sleep(1000);
        String expected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        WebElement actual = driver.findElement(By.cssSelector("#accordion__panel-5"));

        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // CanICancelAnOrder - Можно ли отменить заказ?
    @Test
    public void isTextCanICancelAnOrder() throws InterruptedException {
        sleep(1000);
        driver.findElement(By.cssSelector("#accordion__heading-6")).click();

        sleep(1000);
        String expected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        WebElement actual = driver.findElement(By.cssSelector("#accordion__panel-6"));

        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // ILiveOutsideTheMoscowRingRoadWillYouBringIt - Я живу за МКАДом, привезёте?
    @Test
    public void isTextILiveOutsideTheMoscowRingRoadWillYouBringIt() throws InterruptedException {
        sleep(1000);
        driver.findElement(By.cssSelector("#accordion__heading-7")).click();

        sleep(1000);
        String expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        WebElement actual = driver.findElement(By.cssSelector("#accordion__panel-7"));

        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // Завершение работы драйвера
    @After
    public void after(){
        driver.quit();
    }
}
