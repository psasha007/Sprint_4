package additionaltes;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

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

    // Введите корректное имя
    public void verifyFieldName(String expected){
        WebElement actual = driver.findElement(locatorFieldName);
        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // метод проверяет сообщение об ошибке "Введите корректную фамилию"
    public void verifyFieldSurname(String expected){
        WebElement actual = driver.findElement(locatorFieldSurname);
        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // метод проверяет сообщение об ошибке "Введите корректный адрес"
    public void verifyFieldAdress(String adress, String expected) throws InterruptedException {
        sleep(500);
        driver.findElement(locatorFieldAdress).sendKeys(adress);
        sleep(500);
        WebElement actual = driver.findElement(locatorFieldAdressTextError);
        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // метод проверяет сообщение об ошибке "Выберите станцию"
    public void verifyFieldMetro(String expected){
        WebElement actual = driver.findElement(locatorFieldMetro);
        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // метод проверяет сообщение об ошибке "Введите корректный номер"
    public void verifyFieldNumberForCourier(String expected){
        WebElement actual = driver.findElement(locatorFieldNumberForCourier);
        Assert.assertEquals("Ошибка, текст не совпадает: ", expected, actual.getText());
    }

    // метод нажимает на верхнюю кнопку Заказать
    public void clickButtonNext(){
        driver.findElement(locatorButtonNext).click();
    }

    //
    public void clickHomePageUpButton(){
        driver.findElement(locatorUpButton).click();
    }

    // метод нажимает на нижнюю кнопку Заказать
    public void clickHomePageDownButton(){
        driver.findElement(locatorDownButton).click();
    }

    // метод осуществляет проверку
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
        sleep(3000);
    }
}
