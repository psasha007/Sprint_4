package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

// Класс Диалога на странице "Для кого самокат"
public class DialogPageWhoIsTheScooterFor {

    // Веб драйвер
    private WebDriver driver;

    // Конструктор
    public DialogPageWhoIsTheScooterFor(WebDriver driver){
        this.driver = driver;
    }

    // Локатор на Главной странице - Кнопка «Заказать» верхняя
    private By locatorUpButton = By.className("Button_Button__ra12g");

    // Локатор на Главной странице - Кнопка «Заказать» нижняя
    private By locatorDownButton = By.cssSelector(".Button_Button__ra12g.Button_UltraBig__UU3Lp");

    // Страница Для кого самокат - Локатор для поля "Имя"
    private By locatorFieldName = By.xpath("//*[@placeholder=\"* Имя\"]");

    // Страница Для кого самокат - Локатор для поля "Фамилия"
    private By locatorFieldSurname = By.xpath("//*[@placeholder=\"* Фамилия\"]");

    // Страница Для кого самокат - Локатор для поля "Адрес: куда привезти заказ"
    private By locatorFieldAdress = By.xpath("//*[@placeholder=\"* Адрес: куда привезти заказ\"]");

    // Страница Для кого самокат - Локатор для выпадающего списка "Станция метро"
    private By locatorFieldMetro = By.xpath("//*[@placeholder=\"* Станция метро\"]");

    // Страница Для кого самокат - Локатор для поля "Телефон: на него позвонит курьер"
    private By locatorFieldNumberForCourier = By.xpath("//*[@placeholder=\"* Телефон: на него позвонит курьер\"]");

    // Локатор для Кнопки "Далее"
    private By locatorButtonNext = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    // Метод заполняет поле Имя
    public void setFieldName(String username) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(locatorFieldName));
        driver.findElement(locatorFieldName).sendKeys(username);
    }

    // Метод заполняет поле Фамилия
    public void setFieldSurname(String userSurname) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(locatorFieldSurname));
        driver.findElement(locatorFieldSurname).sendKeys(userSurname);
    }

    // Метод заполняет поле Адрес
    public void setFieldAdress(String adress) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(locatorFieldAdress));
        driver.findElement(locatorFieldAdress).sendKeys(adress);
    }

    // Метод заполняет поле Станция метро
    public void setFieldMetro(String nameMetro) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(locatorFieldMetro));
        driver.findElement(locatorFieldMetro).click();
        driver.findElement(locatorFieldMetro).sendKeys(nameMetro);
        driver.findElement(locatorFieldMetro).sendKeys(Keys.UP);
        driver.findElement(locatorFieldMetro).sendKeys(Keys.ENTER);
    }

    // Метод заполняет поле номер для курьера
    public void setFieldNumberForCourier(String numberForCourier) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(locatorFieldNumberForCourier));
        driver.findElement(locatorFieldNumberForCourier).sendKeys(numberForCourier);
    }

    // Метод жмакает по кнопке Далее
    public void clickButtonNext(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(locatorButtonNext));
        driver.findElement(locatorButtonNext).click();
    }

    // Заполнение формы "Для кого самокат"
    public void setFieldsWhoIs(String username, String userSurname, String adress, String nameMetro, String numberForCourier) throws InterruptedException {
        setFieldName(username);
        setFieldSurname(userSurname);
        setFieldAdress(adress);
        setFieldMetro(nameMetro);
        setFieldNumberForCourier(numberForCourier);
        clickButtonNext();
    }

    // Метод жмакает по кнопке сверху Заказать
    public void clickHomePageUpButton(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(locatorUpButton));
        driver.findElement(locatorUpButton).click();
    }

    // Метод жмакает по кнопке снизу Заказать
    public void clickHomePageDownButton(){
        //WebElement element = driver.findElement(By.cssSelector(".Button_Button__ra12g.Button_UltraBig__UU3Lp"));
        WebElement element = driver.findElement(locatorDownButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(locatorDownButton));
        driver.findElement(locatorDownButton).click();
    }
}
