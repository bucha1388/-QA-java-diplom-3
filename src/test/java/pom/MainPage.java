package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final String url_login = "https://stellarburgers.nomoreparties.site";

    public WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Открытие главной страницы
    public MainPage openPage() {
        driver.get(url_login);
        return this;
    }

    //Логотип
    private final By logo = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");

    //нопка Личный кабинет
    private final By profileLink = By.xpath(".//p[text()='Личный Кабинет']//parent::a");

    //кнопка войти в аккаунт
    private final By buttonLogin = By.xpath(".//button[text()='Войти в аккаунт']");

    public By getButtonCreateOrder() {
        return buttonCreateOrder;
    }

    //кнопка оформить заказ для залогиненного пользователя
    private final By buttonCreateOrder = By.xpath(".//button[text()='Оформить заказ']");


    //Вкладка Булки
    private final By breadsTab = By.xpath(".//span[text()='Булки']//parent::div");

    //ыбранная вкладка
    private final By activeTab = By.xpath(".//div[contains(@class, 'tab_type_current')]");



    //Вкладка Соусы
    private final By saucesTab = By.xpath(".//span[text()='Соусы']//parent::div");

    //Вкладка Начинки
    private final By fillingsTab = By.xpath(".//span[text()='Начинки']//parent::div");


    // геттер для получения элемента текста
    public By getH1Text() {
        return h1Text;
    }

    //Заголовок Собери бургер
    private final By h1Text = By.xpath(".//h1[text()='Соберите бургер']");


    //Клик по вкладке Булки
    public MainPage clickBreadsTab(){
        driver.findElement(breadsTab).click();
        return this;
    }

    //Ожидание загрузки активного таба
    public MainPage waitActiveTab(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(activeTab));
        return this;
    }

    //Клик по вкладке Соусы
    public MainPage clickSaucesTab(){
        driver.findElement(saucesTab).click();
        return this;
    }

    //Клик по вкладке Начинки
    public MainPage clickFillingsTab(){
        driver.findElement(fillingsTab).click();
        return this;
    }

    //Веб элемент вкладки Начинки
    public WebElement fillingsTab(){
      return driver.findElement(fillingsTab);
    }

    //Веб элемент вкладки Булки
    public WebElement breadsTab(){
        return driver.findElement(breadsTab);
    }

    //Веб элемент вкладки Соусы
    public WebElement saucesTab(){
        return driver.findElement(saucesTab);
    }


    //Клик на войти в аккаунт
    public void clickLogin(){
        driver.findElement(buttonLogin).click();
    }


    //Клик на Личный кабинет
    public void clickProfile(){
        driver.findElement(profileLink).click();
    }


    //Клик по логотипу
    public void clickLogo(){
        driver.findElement(logo).click();
    }


}
