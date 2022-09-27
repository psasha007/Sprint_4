package additionaltes;

import constants.Consts;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;

public class AdditionalTest {
    WebDriver driver;

    @Before
    public void startWebDriver() {
        BaseTest webDriver = new BaseTest();
        driver = webDriver.chrome(driver, Consts.BASE_URL);
    }

    @Test
    // Проверить: если нажать на логотип «Самоката», попадёшь на главную страницу «Самоката».
    public void verifyScooterLogoHomePageTest(){
        ErrorsForOrderFormFields testUrl = new ErrorsForOrderFormFields(driver);
        testUrl.isCheckUrlScooterLogoHomePage(Consts.BASE_URL);
    }

    @Test
    // Проверить: если нажать на логотип Яндекса, в новом окне откроется главная страница Яндекса.
    public void verifyYandexLogoHomePageTest() throws InterruptedException {
        ErrorsForOrderFormFields testUrl = new ErrorsForOrderFormFields(driver);
        testUrl.isCheckYandexLogoHomePage("https://dzen.ru/?yredirect=true");
    }

    @Test
    //Проверить ошибки для всех полей формы заказа.
    public void verifyErrorsForOrderFormFieldsTest() throws InterruptedException {
        ErrorsForOrderFormFields verifyWhoIs = new ErrorsForOrderFormFields(driver);
        verifyWhoIs.clickHomePageUpButton();
        verifyWhoIs.verifyTextErrors(
                "Введите корректное имя",
                "Введите корректную фамилию",
                "~!#",
                "Введите корректный адрес",
                "Выберите станцию",
                "Введите корректный номер"
                );
    }

    @Test
    // Проверить: если ввести неправильный номер заказа, попадёшь на страницу статуса заказа. На ней должно быть написано, что такого заказа нет.
    public void verifyWrongOrderNumberTest() throws InterruptedException {
        ErrorsForOrderFormFields testImageNotFound = new ErrorsForOrderFormFields(driver);
        testImageNotFound.isCheckWrongOrderNumber("3615589");
    }

    //
    @After
    public void after(){
        driver.quit();
    }
}
