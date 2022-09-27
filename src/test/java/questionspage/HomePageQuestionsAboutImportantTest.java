package questionspage;

import additionaltes.BaseTest;
import constants.Consts;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;

// Класс для проверки текстов раздела главной страницы "Вопросы о важном"
public class HomePageQuestionsAboutImportantTest {
    WebDriver driver;

    @Before
    public void startWebDriver() {
        BaseTest webDriver = new BaseTest();
        driver = webDriver.chrome(driver, Consts.BASE_URL);
        HomePageQuestions scrollDown = new HomePageQuestions(driver);
        scrollDown.scrollPageDown();
    }

    // HowMuchDoesItCostAndHowToPay - Сколько это стоит? И как оплатить?
    @Test
    public void questionsHowMuchDoesItCostAndHowToPayTest() {
        String expectedText = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        HomePageQuestions questions = new HomePageQuestions(driver);
        // нажимаем на вопрос
        questions.clickToHowMuchDoesItCost();
        // проверяем текст вопроса
        questions.checkTextHowMuchDoesItCost(expectedText);
    }

    // IWantSeveralScootersSoItIsPossible - Хочу сразу несколько самокатов! Так можно?
    @Test
    public void questionsIWantSeveralScootersSoItIsPossibleTest() {
        String expectedText = "Пока что у нас так: один заказ — один самокат. Если хотите покататься" +
                " с друзьями, можете просто сделать несколько заказов — один за другим.";
        HomePageQuestions questions = new HomePageQuestions(driver);
        // нажимаем на вопрос
        questions.clickToIWantSeveralScooters();
        // проверяем текст вопроса
        questions.checkTextIWantSeveralScooters(expectedText);
    }

    // HowIsTheRentalTimeCalculated - Как рассчитывается время аренды?
    @Test
    public void questionsHowIsTheRentalTimeCalculatedTest() {
        String expectedText = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат" +
                " 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы" +
                " оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная" +
                " аренда закончится 9 мая в 20:30.";
        HomePageQuestions questions = new HomePageQuestions(driver);
        // нажимаем на вопрос
        questions.clickToHowIsTheRentalTimeCalculated();
        // проверяем текст вопроса
        questions.checkTextHowIsTheRentalTimeCalculated(expectedText);
    }

    // IsItPossibleToOrderAScooterRightForToday - Можно ли заказать самокат прямо на сегодня?
    @Test
    public void questionsIsItPossibleToOrderAScooterRightForTodayTest() {
        String expectedText = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        HomePageQuestions questions = new HomePageQuestions(driver);
        // нажимаем на вопрос
        questions.clickToIsItPossibleToOrderAScooterRightForToday();
        // проверяем текст вопроса
        questions.checkTextIsItPossibleToOrderAScooterRightForToday(expectedText);
    }

    // CanIExtendTheOrderOrReturnTheScooterEarlier - Можно ли продлить заказ или вернуть самокат раньше?
    @Test
    public void questionsCanIExtendTheOrderOrReturnTheScooterEarlierTest() {
        String expectedText = "Пока что нет! Но если что-то срочное — всегда можно" +
                " позвонить в поддержку по красивому номеру 1010.";
        HomePageQuestions questions = new HomePageQuestions(driver);
        // нажимаем на вопрос
        questions.clickToCanIExtendTheOrderOrReturnTheScooterEarlier();
        // проверяем текст вопроса
        questions.checkTextCanIExtendTheOrderOrReturnTheScooterEarlier(expectedText);
    }

    // DoYouBringChargersWithTheScooter - Вы привозите зарядку вместе с самокатом?
    @Test
    public void questionsDoYouBringChargersWithTheScooterTest() {
        String expectedText = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже" +
                " если будете кататься без передышек и во сне. Зарядка не понадобится.";
        HomePageQuestions questions = new HomePageQuestions(driver);

        // нажимаем на вопрос
        questions.clickToDoYouBringChargersWithTheScooter();
        // проверяем текст вопроса
        questions.checkTextDoYouBringChargersWithTheScooter(expectedText);
    }

    // CanICancelAnOrder - Можно ли отменить заказ?
    @Test
    public void questionsCanICancelAnOrderTest() {
        String expectedText = "Да, пока самокат не привезли. Штрафа не будет," +
                " объяснительной записки тоже не попросим. Все же свои.";
        HomePageQuestions questions = new HomePageQuestions(driver);

        // нажимаем на вопрос
        questions.clickToCanICancelAnOrder();
        // проверяем текст вопроса
        questions.checkTextCanICancelAnOrder(expectedText);
    }

    // ILiveOutsideTheMoscowRingRoadWillYouBringIt - Я живу за МКАДом, привезёте?
    @Test
    public void questionsILiveOutsideTheMoscowRingRoadWillYouBringItTest() {
        String expectedText = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        HomePageQuestions questions = new HomePageQuestions(driver);

        // нажимаем на вопрос
        questions.clickToILiveOutsideTheMoscowRingRoadWillYouBringIt();
        // проверяем текст вопроса
        questions.checkTextILiveOutsideTheMoscowRingRoadWillYouBringIt(expectedText);
    }

    // Завершение работы драйвера
    @After
    public void after(){
        driver.quit();
    }
}
