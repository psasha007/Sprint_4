package pageobject;

import additionaltes.BaseTest;
import constants.Consts;
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
        driver = webDriver.chrome(driver, Consts.BASE_URL);
    }

    // Проверка заказа самоката по кнопке вверху
    @Test
    public void testClickUpButton() throws InterruptedException {
        DialogPageWhoIsTheScooterFor dialogPageWhoIs = new DialogPageWhoIsTheScooterFor(driver);
        DialogPageAboutRent dialogPageAboutRent = new DialogPageAboutRent(driver);

        // Клик на верхнюю кнопку Заказать
        dialogPageWhoIs.clickHomePageUpButton();

        // Заполняем данные на странице Для кого самокат
        // вводим значение в поле Имя
        dialogPageWhoIs.setFieldName(userName);

        // вводим значение в поле Фамилия
        dialogPageWhoIs.setFieldSurname(surName);

        // вводим значение в поле Адрес
        dialogPageWhoIs.setFieldAdress(adress);

        // выбираем из выпадающего списка станцию метро
        dialogPageWhoIs.setFieldMetro(nameMetro);

        // вводим значение в поле Номер телефона для курьера
        dialogPageWhoIs.setFieldNumberForCourier(numbetForCourier);

        // нажимаем на кнопку далее
        dialogPageWhoIs.clickButtonNext();

        // Заполняем данные на странице Про аренду
        // вводим дату
        dialogPageAboutRent.setFieldWhenToBring(date);

        // вводим значение срока арены
        dialogPageAboutRent.setFieldRentalPeriod();

        // Отмечаем цвет самоката Черный
        dialogPageAboutRent.setCheckBoxBlack();

        // Отмечаем цвет самоката Серый
        dialogPageAboutRent.setCheckBoxGray();

        // вводим значение в поле комментарий для курьера
        dialogPageAboutRent.setFieldTextForCourier(textForCourier);

        // нажимаем на кнопку Заказать
        dialogPageAboutRent.clickButtonOrder();

        // подтверждаем заказ
        dialogPageAboutRent.clickButtonDoYouWantToPlaceAnOrder();

        // проверяем что заказ создан
        dialogPageAboutRent.isOrderIsProcessed(verifyText);
    }

    // Проверка заказа самоката по кнопке внизу
    @Test
    public void testClickDownButton() throws InterruptedException {

        DialogPageWhoIsTheScooterFor dialogPageWhoIs = new DialogPageWhoIsTheScooterFor(driver);
        DialogPageAboutRent dialogPageAboutRent = new DialogPageAboutRent(driver);

        // Клик на нижнюю кнопку Заказать
        dialogPageWhoIs.clickHomePageDownButton();

        // Заполняем данные на странице Для кого самокат
        // вводим значение в поле Имя
        dialogPageWhoIs.setFieldName(userName);

        // вводим значение в поле Фамилия
        dialogPageWhoIs.setFieldSurname(surName);

        // вводим значение в поле Адрес
        dialogPageWhoIs.setFieldAdress(adress);

        // выбираем из выпадающего списка станцию метро
        dialogPageWhoIs.setFieldMetro(nameMetro);

        // вводим значение в поле Номер телефона для курьера
        dialogPageWhoIs.setFieldNumberForCourier(numbetForCourier);

        // нажимаем на кнопку далее
        dialogPageWhoIs.clickButtonNext();

        // Заполняем данные на странице Про аренду

        // вводим дату
        dialogPageAboutRent.setFieldWhenToBring(date);

        // вводим значение срока арены
        dialogPageAboutRent.setFieldRentalPeriod();

        // Отмечаем цвет самоката Черный
        dialogPageAboutRent.setCheckBoxBlack();

        // Отмечаем цвет самоката Серый
        dialogPageAboutRent.setCheckBoxGray();

        // вводим значение в поле комментарий для курьера
        dialogPageAboutRent.setFieldTextForCourier(textForCourier);

        // нажимаем на кнопку Заказать
        dialogPageAboutRent.clickButtonOrder();

        // подтверждаем заказ
        dialogPageAboutRent.clickButtonDoYouWantToPlaceAnOrder();

        // проверяем что заказ создан
        dialogPageAboutRent.isOrderIsProcessed(verifyText);
    }

    //
    @After
    public void after(){
        driver.quit();
    }
}
