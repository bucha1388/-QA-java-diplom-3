package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private final String url_register = "https://stellarburgers.nomoreparties.site/register";

    public WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //Открытие страницы регистрации
    public RegisterPage openPage() {
        driver.get(url_register);
        return this;
    }

    //Кнопка Войти
    private final By buttonRegister = By.xpath(".//button[text()='Зарегистрироваться']");

    //Поле ввода имени
    private final By nameField = By.xpath(".//label[text()='Имя']/following-sibling::input");

    //Поле ввода имени
    private final By emailField = By.xpath(".//label[text()='Email']/following-sibling::input");


    //Поле ввода пароля
    private final By passwordField = By.xpath(".//label[text()='Пароль']/following-sibling::input");

    //Строка сообщения об ошибке
    private final By errorMessage = By.xpath(".//p[contains(@class,'input__error')]");

    private final By loginButton = By.xpath(".//a[text()='Войти']");


    //Клик по кнопке  Зарегистрироваться
    public void clickButtonRegister(){
        driver.findElement(buttonRegister).click();
    }

    //Ввод имени (передается из параметра)
    public RegisterPage inputName(String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    //Ввод E-mail (передается из параметра)
    public RegisterPage inputEmail(String name) {
        driver.findElement(emailField).sendKeys(name);
        return this;
    }

    //Ввод имени (передается из параметра)
    public RegisterPage inputToPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    //Получение текста в сообщении об ошибке
    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }

    //Клик по ссылке Войти
    public void clickLinkLogin(){
        driver.findElement(loginButton).click();
    }
}
