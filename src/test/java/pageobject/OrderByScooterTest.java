package pageobject;

import additionaltes.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
// Класс заказ самоката
public class OrderByScooterTest {
    WebDriver driver;
    String baseUrl = "https://qa-scooter.praktikum-services.ru/";

    private final String userName;
    private final String surName;
    private final String adress;
    private final String nameMetro;
    private final String numbetForCourier;
    private final String date;
    private final String textForCourier;
    private final String verifyText;

    public OrderByScooterTest(
            String userName,
            String surName,
            String adress,
            String nameMetro,
            String numbetForCourier,
            String date,
            String textForCourier,
            String verifyText)
    {
        this.userName = userName;
        this.surName = surName;
        this.adress = adress;
        this.nameMetro = nameMetro;
        this.numbetForCourier = numbetForCourier;
        this.date = date;
        this.textForCourier = textForCourier;
        this.verifyText = verifyText;
    }

    @Parameterized.Parameters
    public static Object[] getSumData()
    {
        return new Object[][]
                { // передали тестовые данные
                        {"Иван", "Иванов", "Москва", "беляево", "+79155230012", "22.09.2022", "Позвонить за час", "Заказ оформлен"},
                        {"Василиса", "Иванова", "Москва", "коньково", "+79155230011", "23.09.2022", "Позвонить за 2 часа", "Заказ оформлен"},
                };
    }

    @Before
    public void startWebDriver() {
        BaseTest webDriver = new BaseTest();
        driver = webDriver.chrome(driver, baseUrl);
    }

    // Проверка заказа самоката по кнопке вверху
    @Test
    public void testClickUpButton() throws InterruptedException {

        DialogPageWhoIsTheScooterFor dialogPageWhoIs = new DialogPageWhoIsTheScooterFor(driver);
        DialogPageAboutRent dialogPageAboutRent = new DialogPageAboutRent(driver);
        dialogPageWhoIs.clickHomePageUpButton();
        dialogPageWhoIs.setFieldsWhoIs(userName, surName, adress, nameMetro, numbetForCourier);
        dialogPageAboutRent.setFieldsAboutRent(date, textForCourier, verifyText);
    }

    // Проверка заказа самоката по кнопке внизу
    @Test
    public void testClickDownButton() throws InterruptedException {

        DialogPageWhoIsTheScooterFor dialogPageWhoIs = new DialogPageWhoIsTheScooterFor(driver);
        DialogPageAboutRent dialogPageAboutRent = new DialogPageAboutRent(driver);

        dialogPageWhoIs.clickHomePageDownButton();
        dialogPageWhoIs.setFieldsWhoIs(userName, surName, adress, nameMetro, numbetForCourier);
        dialogPageAboutRent.setFieldsAboutRent(date, textForCourier, verifyText);
    }

    //
    @After
    public void after(){
        driver.quit();
    }
}
