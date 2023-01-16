package pom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static testdata.TestData.MAIN_EMAIL;
import static testdata.TestData.MAIN_PASSWORD;

public class LoginPage {


    private final String urlLogin = "https://stellarburgers.nomoreparties.site/login";

    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Открытие страницы регистрации
    public LoginPage openPage() {
        driver.get(urlLogin);
        return this;
    }


    //Кнопка Войти
    private final By buttonLogin = By.xpath(".//button[text()='Войти']");

    //Поле ввода имени
    private final By emailField = By.xpath(".//input[@name='name']");


    //Поле ввода пароля
    private final By passwordField = By.xpath(".//input[@name='Пароль']");

    //Заголовок Вход
    private final By h2Header = By.xpath(".//div/h2");



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

    //Ожидание загрузки кнопки Войти
    public LoginPage waitLoginButton(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
        return this;
    }

    //Ожидание поля ввода емэйла
    public LoginPage waitEmailField(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(emailField));
        return this;
    }

    //Получение Заголовка H2 (Вход)
    public String getTextH2(){
        return driver.findElement(h2Header).getText();
    }

    //Полный процесс логина
    public void fullLogin(String email, String password) {
        driver.get(urlLogin);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        waitLoginButton();
        driver.findElement(buttonLogin).click();
    }
}
