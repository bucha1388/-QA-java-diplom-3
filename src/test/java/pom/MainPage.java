package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    private final By profileLink = By.xpath(".//a[@class='AppHeader_header__link__3D_hX']");

    //кнопка войти в аккаунт
    private final By buttonLogin = By.xpath(".//button[text()='Войти в аккаунт']");


    //Вкладка Булки
    private final By breadsTab = By.xpath(".//span[text()='Булки']//parent::div");

    //Вкладка Соусы
    private final By saucesTab = By.xpath(".//span[text()='Соусы']//parent::div");

    //Вкладка Начинки
    private final By fillingsTab = By.xpath(".//span[text()='Начинки']//parent::div");


    //Клик по вкладке Булки
    public MainPage clickBreadsTab(){
        driver.findElement(breadsTab).click();
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
