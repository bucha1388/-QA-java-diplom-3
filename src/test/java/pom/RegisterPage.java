package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private final String url_register = "https://stellarburgers.nomoreparties.site/register";

    public WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //Открытие главной страницы
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
}
