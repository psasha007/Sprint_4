package questionspage;

import constants.Consts;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageQuestions {
    // Веб драйвер
    private WebDriver driver;

    // Значение для локатора прокрутки
    private String locatorScroll = "arguments[0].scrollIntoView();";

    // Главная Страница - раздел "Вопросы о важном" - Локатор для "Сколько это стоит? И как оплатить?"
    private By howMuchDoesItCost = By.cssSelector("#accordion__heading-0");

    // Главная Страница - раздел "Вопросы о важном" - Локатор Текст для "Сколько это стоит? И как оплатить?"
    private By howMuchDoesItCostText = By.cssSelector("#accordion__panel-0");

    // Главная Страница - раздел "Вопросы о важном" - Локатор для "Хочу сразу несколько самокатов! Так можно?"
    private By iWantSeveralScooters = By.cssSelector("#accordion__heading-1");

    // Главная Страница - раздел "Вопросы о важном" - Локатор Текст для "Хочу сразу несколько самокатов! Так можно?"
    private By iWantSeveralScootersText = By.cssSelector("#accordion__panel-1");

    // Главная Страница - раздел "Вопросы о важном" - Локатор для "Как рассчитывается время аренды?"
    private By howIsTheRentalTimeCalculated = By.cssSelector("#accordion__heading-2");

    // Главная Страница - раздел "Вопросы о важном" - Локатор Текст для "Как рассчитывается время аренды?"
    private By howIsTheRentalTimeCalculatedText = By.cssSelector("#accordion__panel-2");

    // Главная Страница - раздел "Вопросы о важном" - Локатор для "Можно ли заказать самокат прямо на сегодня?"
    private By isItPossible = By.cssSelector("#accordion__heading-3");

    // Главная Страница - раздел "Вопросы о важном" - Локатор Текст для "Можно ли заказать самокат прямо на сегодня?"
    private By isItPossibleText =  By.cssSelector("#accordion__panel-3");

    // Главная Страница - раздел "Вопросы о важном" - Локатор для "Можно ли продлить заказ или вернуть самокат раньше?"
    private By canIExtendTheOrderOrReturn = By.cssSelector("#accordion__heading-4");

    // Главная Страница - раздел "Вопросы о важном" - Локатор Текст для "Можно ли продлить заказ или вернуть самокат раньше?"
    private By canIExtendTheOrderOrReturnText = By.cssSelector("#accordion__panel-4");

    // Главная Страница - раздел "Вопросы о важном" - Локатор для "Вы привозите зарядку вместе с самокатом?"
    private By doYouBringChargers = By.cssSelector("#accordion__heading-5");

    // Главная Страница - раздел "Вопросы о важном" - Локатор Текст для "Вы привозите зарядку вместе с самокатом?"
    private By doYouBringChargersText =  By.cssSelector("#accordion__panel-5");

    // Главная Страница - раздел "Вопросы о важном" - Локатор для "Можно ли отменить заказ?"
    private By canICancelAnOrder = By.cssSelector("#accordion__heading-6");

    // Главная Страница - раздел "Вопросы о важном" - Локатор Текст для "Можно ли отменить заказ?"
    private By canICancelAnOrderText = By.cssSelector("#accordion__panel-6");

    // Главная Страница - раздел "Вопросы о важном" - Локатор для "Я живу за МКАДом, привезёте?"
    private By iLiveOutsideTheMoscowRing = By.cssSelector("#accordion__heading-7");

    // Главная Страница - раздел "Вопросы о важном" - Локатор Текст для "Я живу за МКАДом, привезёте?"
    private By iLiveOutsideTheMoscowRingText = By.cssSelector("#accordion__panel-7");

    // Конструктор
    public HomePageQuestions(WebDriver driver){
        this.driver = driver;
    }

    // Метод осуществляет клик на вопрос "Сколько это стоит? И как оплатить?"
    public void clickToHowMuchDoesItCost(){
        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).
                until(ExpectedConditions.visibilityOfElementLocated(howMuchDoesItCost));

        driver.findElement(howMuchDoesItCost).click();
    }
    // Метод проверяет текст "Сутки — 400 рублей. Оплата курьеру — наличными или картой."
    public void checkTextHowMuchDoesItCost(String expected) {
        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).
                until(ExpectedConditions.visibilityOfElementLocated(howMuchDoesItCostText));

        WebElement actual = driver.findElement(howMuchDoesItCostText);

        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // Метод осуществляет клик на вопрос "Хочу сразу несколько самокатов! Так можно?"
    public void clickToIWantSeveralScooters(){
        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).
                until(ExpectedConditions.visibilityOfElementLocated(iWantSeveralScooters));

        driver.findElement(iWantSeveralScooters).click();
    }
    // Метод проверяет текст "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."
    public void checkTextIWantSeveralScooters(String expected){
        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).
                until(ExpectedConditions.visibilityOfElementLocated(iWantSeveralScootersText));

        WebElement actual = driver.findElement(iWantSeveralScootersText);

        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // Метод осуществляет клик на вопрос "Как рассчитывается время аренды?"
    public void clickToHowIsTheRentalTimeCalculated(){
        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).
                until(ExpectedConditions.visibilityOfElementLocated(howIsTheRentalTimeCalculated));

        driver.findElement(howIsTheRentalTimeCalculated).click();
    }
    // Метод проверяет текст "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."
    public void checkTextHowIsTheRentalTimeCalculated(String expected){
        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).
                until(ExpectedConditions.visibilityOfElementLocated(howIsTheRentalTimeCalculatedText));

        WebElement actual = driver.findElement(howIsTheRentalTimeCalculatedText);

        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // Метод осуществляет клик на вопрос "Можно ли заказать самокат прямо на сегодня?"
    public void clickToIsItPossibleToOrderAScooterRightForToday(){
        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).
                until(ExpectedConditions.visibilityOfElementLocated(isItPossible));

        driver.findElement(isItPossible).click();
    }
    // Метод проверяет текст "Только начиная с завтрашнего дня. Но скоро станем расторопнее."
    public void checkTextIsItPossibleToOrderAScooterRightForToday(String expected){
        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).
                until(ExpectedConditions.visibilityOfElementLocated(isItPossibleText));

        WebElement actual = driver.findElement(isItPossibleText);

        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // Метод осуществляет клик на вопрос "Можно ли продлить заказ или вернуть самокат раньше?"
    public void clickToCanIExtendTheOrderOrReturnTheScooterEarlier(){
        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).
                until(ExpectedConditions.visibilityOfElementLocated(canIExtendTheOrderOrReturn));

        driver.findElement(canIExtendTheOrderOrReturn).click();
    }

    // Метод проверяет текст "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."
    public void checkTextCanIExtendTheOrderOrReturnTheScooterEarlier(String expected){
        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).
                until(ExpectedConditions.visibilityOfElementLocated(canIExtendTheOrderOrReturnText));

        WebElement actual = driver.findElement(canIExtendTheOrderOrReturnText);

        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // Метод осуществляет клик на вопрос "Вы привозите зарядку вместе с самокатом?"
    public void clickToDoYouBringChargersWithTheScooter(){
        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).
                until(ExpectedConditions.visibilityOfElementLocated(doYouBringChargers));

        driver.findElement(doYouBringChargers).click();
    }
    // Метод проверяет текст "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."
    public void checkTextDoYouBringChargersWithTheScooter(String expected){

        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).
                until(ExpectedConditions.visibilityOfElementLocated(doYouBringChargersText));

        WebElement actual = driver.findElement(doYouBringChargersText);

        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // Метод осуществляет клик на вопрос "Можно ли отменить заказ?"
    public void clickToCanICancelAnOrder(){
        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).
                until(ExpectedConditions.visibilityOfElementLocated(canICancelAnOrder));

        driver.findElement(canICancelAnOrder).click();
    }
    // Метод проверяет текст "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."
    public void  checkTextCanICancelAnOrder(String expected){

        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).
                until(ExpectedConditions.visibilityOfElementLocated(canICancelAnOrderText));

        WebElement actual = driver.findElement(canICancelAnOrderText);

        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // Метод осуществляет клик на вопрос "Я живу за МКАДом, привезёте?"
    public void clickToILiveOutsideTheMoscowRingRoadWillYouBringIt(){
        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).
                until(ExpectedConditions.visibilityOfElementLocated(iLiveOutsideTheMoscowRing));

        driver.findElement(iLiveOutsideTheMoscowRing).click();
    }
    // Метод проверяет текст "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    public void checkTextILiveOutsideTheMoscowRingRoadWillYouBringIt(String expected){
        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).
                until(ExpectedConditions.visibilityOfElementLocated(iLiveOutsideTheMoscowRingText));

        WebElement actual = driver.findElement(iLiveOutsideTheMoscowRingText);

        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // Метод прокрутка до элемента на странице "Самокат на пару дней"
    public void scrollPageDown(){
        WebElement element = driver.findElement(iLiveOutsideTheMoscowRing);

        ((JavascriptExecutor)driver).executeScript(locatorScroll, element);
    }
}
