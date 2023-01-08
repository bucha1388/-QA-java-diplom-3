package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final String url_login = "https://stellarburgers.nomoreparties.site/login";

    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Открытие главной страницы
    public LoginPage openPage() {
        driver.get(url_login);
        return this;
    }

    //Кнопка Войти
    private final By buttonLogin = By.xpath(".//button[text()='Войти']");

    //Поле ввода имени
    private final By emailField = By.xpath(".//input[@name='name']");


    //Поле ввода пароля
    private final By passwordField = By.xpath(".//input[@name='Пароль']");


    //Клик по кнопке  Войти
    public void clickButtonLogin(){
        driver.findElement(buttonLogin).click();
    }

    //Ввод E-mail (передается из параметра)
    public LoginPage inputEmail(String name) {
        driver.findElement(emailField).sendKeys(name);
        return this;
    }

    //Ввод пароля (передается из параметра)
    public LoginPage inputToPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
}
