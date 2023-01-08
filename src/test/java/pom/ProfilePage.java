package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    private final String url_login = "https://stellarburgers.nomoreparties.site/account/profile";

    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    //Открытие главной страницы
    public ProfilePage openPage() {
        driver.get(url_login);
        return this;
    }

    //Логотип
    private final By logo = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");

    //Кнопка Выйти
    private final By buttonExit = By.xpath(".//button[text()='Выход']");


    //Кнопка конструктор
    private final By constructorLink = By.xpath(".//a[@class='AppHeader_header__link__3D_hX']");


    //Клик по кнопке  Выйти
    public void clickButtonLogout(){
        driver.findElement(buttonExit).click();
    }

    //Клик по логотипу
    public void clickLogo(){
        driver.findElement(logo).click();
    }

    //Клик по вкладке конструктор
    public void clickConstructor(){
        driver.findElement(constructorLink).click();
    }

}
