package questionspage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageQuestions {
    // Веб драйвер
    private WebDriver driver;

    // Конструктор
    public HomePageQuestions(WebDriver driver){
        this.driver = driver;
    }

    // Главная Страница - раздел "Вопросы о важном" - Локатор для "Сколько это стоит? И как оплатить?"
    private By howMuchDoesItCost = By.cssSelector("#accordion__heading-0");
    private By howMuchDoesItCostText = By.cssSelector("#accordion__panel-0");
    // Метод проверяет текст "Сутки — 400 рублей. Оплата курьеру — наличными или картой."
    public void isCheckHowMuchDoesItCostText(String expected) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(howMuchDoesItCost));
        driver.findElement(howMuchDoesItCost).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(howMuchDoesItCostText));
        WebElement actual = driver.findElement(howMuchDoesItCostText);

        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // Главная Страница - раздел "Вопросы о важном" - Локатор для "Хочу сразу несколько самокатов! Так можно?"
    private By iWantSeveralScooters = By.cssSelector("#accordion__heading-1");
    private By iWantSeveralScootersText = By.cssSelector("#accordion__panel-1");
    // Метод проверяет текст "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."
    public void isCheckIWantSeveralScootersText(String expected){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(iWantSeveralScooters));
        driver.findElement(iWantSeveralScooters).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(iWantSeveralScootersText));
        WebElement actual = driver.findElement(iWantSeveralScootersText);
        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // Главная Страница - раздел "Вопросы о важном" - Локатор для "Как рассчитывается время аренды?"
    private By howIsTheRentalTimeCalculated = By.cssSelector("#accordion__heading-2");
    private By howIsTheRentalTimeCalculatedText = By.cssSelector("#accordion__panel-2");
    // Метод проверяет текст "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."
    public void isCheckHowIsTheRentalTimeCalculatedText(String expected){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(howIsTheRentalTimeCalculated));
        driver.findElement(howIsTheRentalTimeCalculated).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(howIsTheRentalTimeCalculatedText));
        WebElement actual = driver.findElement(howIsTheRentalTimeCalculatedText);

        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // Главная Страница - раздел "Вопросы о важном" - Локатор для "Можно ли заказать самокат прямо на сегодня?"
    private By isItPossible = By.cssSelector("#accordion__heading-3");
    private By isItPossibleText =  By.cssSelector("#accordion__panel-3");
    // Метод проверяет текст "Только начиная с завтрашнего дня. Но скоро станем расторопнее."
    public void isCheckIsItPossibleToOrderAScooterRightForTodayText(String expected){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(isItPossible));
        driver.findElement(isItPossible).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(isItPossibleText));
        WebElement actual = driver.findElement(isItPossibleText);

        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // Главная Страница - раздел "Вопросы о важном" - Локатор для "Можно ли продлить заказ или вернуть самокат раньше?"
    private By canIExtendTheOrderOrReturn = By.cssSelector("#accordion__heading-4");
    private By canIExtendTheOrderOrReturnText = By.cssSelector("#accordion__panel-4");
    // Метод проверяет текст "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."
    public void isCheckCanIExtendTheOrderOrReturnTheScooterEarlierText(String expected){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(canIExtendTheOrderOrReturn));
        driver.findElement(canIExtendTheOrderOrReturn).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(canIExtendTheOrderOrReturnText));
        WebElement actual = driver.findElement(canIExtendTheOrderOrReturnText);

        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // Главная Страница - раздел "Вопросы о важном" - Локатор для "Вы привозите зарядку вместе с самокатом?"
    private By doYouBringChargers = By.cssSelector("#accordion__heading-5");
    private By doYouBringChargersText =  By.cssSelector("#accordion__panel-5");

    // Метод проверяет текст "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."
    public void isCheckDoYouBringChargersWithTheScooterText(String expected){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(doYouBringChargers));
        driver.findElement(doYouBringChargers).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(doYouBringChargersText));
        WebElement actual = driver.findElement(doYouBringChargersText);

        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // Главная Страница - раздел "Вопросы о важном" - Локатор для "Можно ли отменить заказ?"
    private By canICancelAnOrder = By.cssSelector("#accordion__heading-6");
    private By canICancelAnOrderText = By.cssSelector("#accordion__panel-6");

    // Метод проверяет текст "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."
    public void  isCheckCanICancelAnOrder(String expected){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(canICancelAnOrder));
        driver.findElement(canICancelAnOrder).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(canICancelAnOrderText));
        WebElement actual = driver.findElement(canICancelAnOrderText);

        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // Главная Страница - раздел "Вопросы о важном" - Локатор для "Я живу за МКАДом, привезёте?"
    private By iLiveOutsideTheMoscowRing = By.cssSelector("#accordion__heading-7");
    private By iLiveOutsideTheMoscowRingText = By.cssSelector("#accordion__panel-7");

    // Метод проверяет текст "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    public void isCheckILiveOutsideTheMoscowRingRoadWillYouBringIt(String expected){

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(iLiveOutsideTheMoscowRing));
        driver.findElement(iLiveOutsideTheMoscowRing).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(iLiveOutsideTheMoscowRingText));
        WebElement actual = driver.findElement(iLiveOutsideTheMoscowRingText);

        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }
}
