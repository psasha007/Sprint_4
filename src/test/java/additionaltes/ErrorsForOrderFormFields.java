package additionaltes;

import constants.Consts;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

// Класс на странице "Для кого самокат" для проверки сообщений
public class ErrorsForOrderFormFields {

    // Веб драйвер
    private WebDriver driver;

    // Конструктор
    public ErrorsForOrderFormFields(WebDriver driver){
        this.driver = driver;
    }

    // Локатор на Главной странице - Кнопка «Заказать» верхняя
    private By locatorUpButton = By.className("Button_Button__ra12g");

    // Локатор на Главной странице - Кнопка «Заказать» нижняя
    private By locatorDownButton = By.cssSelector(".Button_Button__ra12g.Button_UltraBig__UU3Lp");

    // Страница Для кого самокат - Локатор для поля "Имя" - error - Введите корректное имя
    private By locatorFieldName = By.cssSelector("div.Order_Form__17u6u > div:nth-child(1) > div");

    // Страница Для кого самокат - Локатор для поля "Фамилия" - error - Введите корректную фамилию
    private By locatorFieldSurname = By.cssSelector("div.Order_Form__17u6u > div:nth-child(2) > div");

    // Страница Для кого самокат - Локатор для поля "Адрес: куда привезти заказ"
    private By locatorFieldAdress = By.xpath("//*[@placeholder=\"* Адрес: куда привезти заказ\"]");
    // - error - Введите корректный адрес
    private By locatorFieldAdressTextError = By.cssSelector("div.Order_Form__17u6u > div:nth-child(3) > div");

    // Страница Для кого самокат - Локатор для выпадающего списка "Станция метро" - error - Выберите станцию
    private By locatorFieldMetro = By.cssSelector("div.Order_Form__17u6u > div.Order_UnderError__1VSDB > div.Order_MetroError__1BtZb");

    // Страница Для кого самокат - Локатор для поля "Телефон: на него позвонит курьер" - error - Введите корректный номер
    private By locatorFieldNumberForCourier = By.cssSelector("div.Order_Form__17u6u > div:nth-child(5) > div");

    // Локатор для Кнопки "Далее"
    private By locatorButtonNext = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    // ScooterLogoHomePage
    // Локатор на Главной странице - Иконка «Самокат»
    private By locatorScooterLogoHomePage = By.className("Header_LogoScooter__3lsAR");

    // YandexLogoHomePage
    // Локатор на Главной странице - Иконка "Яндекс"
    private By locatorYandexLogoHomePage = By.cssSelector("#root > div > div > div.Header_Header__214zg > div.Header_Logo__23yGT > a.Header_LogoYandex__3TSOI");

    // Локатор на Главной странице - "Яндекс"
    private By locatorDzen = By.cssSelector(".dzen-top-controls-desktop__buttonText-3_");

    // WrongOrderNumber
    // Локатор на Главной странице - Кнопка "Статус заказа"
    private By locatorOrderStatus = By.className("Header_Link__1TAG7");
    // Локатор поля для ввода номера заказа
    private By locatorFieldOrderStatus = By.xpath("//*[@placeholder=\"Введите номер заказа\"]");
    // Локатор Кнопка "Go"
    private By locatorButtonGo = By.cssSelector(".Button_Button__ra12g.Header_Button__28dPO");
    // Локатор image not found
    private By locatorImageNotFound = By.xpath(".//img[@alt='Not found']");

    // метод проверяет сообщение об ошибке "Введите корректное имя"
    public void verifyFieldName(String expected){
        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(locatorFieldName));
        WebElement actual = driver.findElement(locatorFieldName);
        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // метод проверяет сообщение об ошибке "Введите корректную фамилию"
    public void verifyFieldSurname(String expected){
        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(locatorFieldSurname));
        WebElement actual = driver.findElement(locatorFieldSurname);
        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // метод проверяет сообщение об ошибке "Введите корректный адрес"
    public void verifyFieldAdress(String adress, String expected) throws InterruptedException {
        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(locatorFieldAdress));
        driver.findElement(locatorFieldAdress).sendKeys(adress);
        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(locatorFieldAdressTextError));
        WebElement actual = driver.findElement(locatorFieldAdressTextError);
        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // метод проверяет сообщение об ошибке "Выберите станцию"
    public void verifyFieldMetro(String expected){
        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(locatorFieldMetro));
        WebElement actual = driver.findElement(locatorFieldMetro);
        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // метод проверяет сообщение об ошибке "Введите корректный номер"
    public void verifyFieldNumberForCourier(String expected){
        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(locatorFieldNumberForCourier));
        WebElement actual = driver.findElement(locatorFieldNumberForCourier);
        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // метод нажимает на верхнюю кнопку Заказать
    public void clickButtonNext(){
        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(locatorButtonNext));
        driver.findElement(locatorButtonNext).click();
    }

    // метод нажимает на верхнюю  кнопку Заказать
    public void clickHomePageUpButton(){
        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(locatorUpButton));
        driver.findElement(locatorUpButton).click();
    }

    // метод нажимает на нижнюю кнопку Заказать
    public void clickHomePageDownButton(){
        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(locatorDownButton));
        driver.findElement(locatorDownButton).click();
    }

    // метод осуществляет проверку сообщений об ошибках для полей
    public void verifyTextErrors(
            String nameTextErrors,
            String surnameTextErrors,
            String adress, String adressTextErrors,
            String metroTextErrors,
            String numberForCourierTextErrors) throws InterruptedException {

        clickButtonNext();
        verifyFieldName(nameTextErrors);
        verifyFieldSurname(surnameTextErrors);
        verifyFieldAdress(adress, adressTextErrors);
        verifyFieldMetro(metroTextErrors);
        verifyFieldNumberForCourier(numberForCourierTextErrors);
    }

    // Метод проверка url HomePage
    public void isCheckUrlScooterLogoHomePage(String expected){
        driver.findElement(locatorScooterLogoHomePage).click();
        Assert.assertEquals("Ошибка, url не совпадает: ", expected, driver.getCurrentUrl());
    }

    // Метод проверка url Yandex.ru
    public void isCheckYandexLogoHomePage(String expected) throws InterruptedException {
        driver.findElement(locatorYandexLogoHomePage).click();
        Set<String> s = driver.getWindowHandles();
        Iterator<String> I1= s.iterator();
        String child_window=I1.next();
        child_window=I1.next();
        driver.switchTo().window(child_window);
        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).
                until(ExpectedConditions.visibilityOfElementLocated(locatorDzen));

        Assert.assertEquals("Ошибка, url не совпадает: ", expected, driver.getCurrentUrl());
    }

    // Метод проверяет "что такого заказа нет"
    public void isCheckWrongOrderNumber(String numberOrder) throws InterruptedException {
        driver.findElement(locatorOrderStatus).click();
        driver.findElement(locatorFieldOrderStatus).sendKeys(numberOrder);
        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).
                until(ExpectedConditions.visibilityOfElementLocated(locatorButtonGo));

        driver.findElement(locatorButtonGo).click();

        new WebDriverWait(driver, Consts.TIME_OUT_IN_SECONDS).
                until(ExpectedConditions.visibilityOfElementLocated(locatorImageNotFound));

        WebElement actual = driver.findElement(locatorImageNotFound);
        Assert.assertTrue("Expected image not found", actual.isDisplayed());
    }
}
