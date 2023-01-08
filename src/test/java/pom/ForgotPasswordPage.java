package pom;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;


public class ForgotPasswordPage {
    private final String url_fp = "https://stellarburgers.nomoreparties.site/forgot-password";

    public WebDriver driver;
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    //Открытие главной страницы
    public ForgotPasswordPage openPage() {
        driver.get(url_fp);
        return this;
    }

//Кнопка Войти
    private final By buttonLogin = By.xpath(".//a[text()='Войти']");

//Клик по кнопке  Войти
    public void clickButtonLogin(){
        driver.findElement(buttonLogin).click();
    }

}
