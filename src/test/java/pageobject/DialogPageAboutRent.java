package pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

// Класс Диалога на странице "Про аренду"
public class DialogPageAboutRent {

    // Веб драйвер
    private WebDriver driver;

    // Конструктор
    public DialogPageAboutRent(WebDriver driver){
        this.driver = driver;
    }

    // Страница Про аренду - Локатор для поля * Когда привезти самокат
    private By fieldWhenToBring = By.xpath("//*[@placeholder=\"* Когда привезти самокат\"]");

    // Страница Про аренду - Локатор для поля * Срок аренды для клика
    private By rentalPeriod = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Form__17u6u > div.Dropdown-root > div > div.Dropdown-placeholder");

    // Страница Про аренду - Локатор для поля * Срок аренды для выбора дня
    private By rentalPeriodDay = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Form__17u6u > div.Dropdown-root.is-open > div.Dropdown-menu > div:nth-child(2)");

    // Страница Про аренду - Локатор для чек-бокса Цвет самоката black
    private By black = By.id("black");
    
    // Страница Про аренду - Локатор для чек-бокса Цвет самоката grey
    private By grey = By.id("grey");

    // Страница Про аренду - Локатор для поля Комментарий для курьера
    private By fieldTextForCourier = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Form__17u6u > div.Input_InputContainer__3NykH > input");

    // Страница Про аренду - Локатор для Кнопки Заказать
    private By clickButtonOrder = By.cssSelector("button.Button_Middle__1CSJM:nth-child(2)");

    // Страница Про аренду - Локатор для подтверждения заказа "Да"
    private By doYouWantToPlaceAnOrder = By.cssSelector("div.Order_Buttons__1xGrp:nth-child(2) > button:nth-child(2)");

    // Страница Про аренду - Локатор для проверки текста "Заказ оформлен"
    private By orderIsProcessed = By.cssSelector(".Order_ModalHeader__3FDaJ");

    // Метод заполняем поле Когда привезти самокат
    public void setFieldWhenToBring(String date) {
        driver.findElement(fieldWhenToBring).sendKeys(date);
        driver.findElement(fieldWhenToBring).sendKeys(Keys.ENTER);
    }

    // Метод кликаем по выпадающему списку Срок аренды
    public void setFieldRentalPeriod() {
        driver.findElement(rentalPeriod).click();
        driver.findElement(rentalPeriodDay).click();
    }

    // Метод отмечаем чек-бокс black
    public void setCheakBoxBlack() {
        driver.findElement(black).click();
    }

    // Метод отмечаем чек-бокс grey
    public void setCheakBoxGray() {
        driver.findElement(grey).click();
    }

    // Метод заполняем поле Комментарий для курьера
    public void setFieldTextForCourier(String text) {
        driver.findElement(fieldTextForCourier).sendKeys(text);
    }

    // Метод кликаем по Заказать
    public void clickButtonOrder(){
        driver.findElement(clickButtonOrder).click();
    }

    // Метод подтверждаем заказ
    public void clickButtonDoYouWantToPlaceAnOrder(){
        driver.findElement(doYouWantToPlaceAnOrder).click();
    }

    // Метод проверки сообщения о заказе
    public void isOrderIsProcessed(String expected) {
        WebElement actual = driver.findElement(orderIsProcessed);
        Assert.assertTrue(actual.getText().contains(expected));
    }

    // Заполнение формы "Про аренду"
    public void setAboutRent(String date, String textForCourier, String text) throws InterruptedException {
        setFieldWhenToBring(date);
        setFieldRentalPeriod();
        setCheakBoxBlack();
        setCheakBoxGray();
        setFieldTextForCourier(textForCourier);
        sleep(300);
        clickButtonOrder();
        sleep(300);
        clickButtonDoYouWantToPlaceAnOrder();
        sleep(1000);
        isOrderIsProcessed(text);
    }
}
