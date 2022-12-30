package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    public ForgotPasswordPage clickButtonLogin(){
        driver.findElement(buttonLogin).click();
        return this;
    }

}
