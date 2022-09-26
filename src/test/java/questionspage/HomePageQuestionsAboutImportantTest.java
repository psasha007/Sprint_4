package questionspage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

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
    public void isTextHowMuchDoesItCostAndHowToPayTest() throws InterruptedException {
        HomePageQuestions Questions = new HomePageQuestions(driver);
        Questions.isCheckHowMuchDoesItCostText("Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
    }

    // IWantSeveralScootersSoItIsPossible - Хочу сразу несколько самокатов! Так можно?
    @Test
    public void isTextIWantSeveralScootersSoItIsPossibleTest() throws InterruptedException {
        HomePageQuestions Questions = new HomePageQuestions(driver);
        Questions.isCheckIWantSeveralScootersText("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");
    }

    // HowIsTheRentalTimeCalculated - Как рассчитывается время аренды?
    @Test
    public void isTextHowIsTheRentalTimeCalculatedTest() throws InterruptedException {
        HomePageQuestions Questions = new HomePageQuestions(driver);
        Questions.isCheckHowIsTheRentalTimeCalculatedText("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");

    }

    // IsItPossibleToOrderAScooterRightForToday - Можно ли заказать самокат прямо на сегодня?
    @Test
    public void isTextIsItPossibleToOrderAScooterRightForTodayTest() throws InterruptedException {
        HomePageQuestions Questions = new HomePageQuestions(driver);
        Questions.isCheckIsItPossibleToOrderAScooterRightForTodayText("Только начиная с завтрашнего дня. Но скоро станем расторопнее.");
    }

    // CanIExtendTheOrderOrReturnTheScooterEarlier - Можно ли продлить заказ или вернуть самокат раньше?
    @Test
    public void isTextCanIExtendTheOrderOrReturnTheScooterEarlierTest() throws InterruptedException {
        HomePageQuestions Questions = new HomePageQuestions(driver);
        Questions.isCheckCanIExtendTheOrderOrReturnTheScooterEarlierText("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");
    }

    // DoYouBringChargersWithTheScooter - Вы привозите зарядку вместе с самокатом?
    @Test
    public void isTextDoYouBringChargersWithTheScooterTest() throws InterruptedException {
        HomePageQuestions Questions = new HomePageQuestions(driver);
        Questions.isCheckDoYouBringChargersWithTheScooterText("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");
    }

    // CanICancelAnOrder - Можно ли отменить заказ?
    @Test
    public void isTextCanICancelAnOrderTest() throws InterruptedException {
        HomePageQuestions Questions = new HomePageQuestions(driver);
        Questions.isCheckCanICancelAnOrder("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
    }

    // ILiveOutsideTheMoscowRingRoadWillYouBringIt - Я живу за МКАДом, привезёте?
    @Test
    public void isTextILiveOutsideTheMoscowRingRoadWillYouBringItTest() throws InterruptedException {
        HomePageQuestions Questions = new HomePageQuestions(driver);
        Questions.isCheckILiveOutsideTheMoscowRingRoadWillYouBringIt("Да, обязательно. Всем самокатов! И Москве, и Московской области.");
    }

    // Завершение работы драйвера
    @After
    public void after(){
        driver.quit();
    }
}
