package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {

    private final String urlLogin = "https://stellarburgers.nomoreparties.site/account/profile";

    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    //Открытие страницы Профиля
    public ProfilePage openPage() {
        driver.get(urlLogin);
        return this;
    }

    //Логотип
    private final By logo = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");

    //Кнопка Выйти
    private final By buttonExit = By.xpath(".//button[text()='Выход']");

    public By getProfileText() {
        return profileText;
    }

    //Кнопка Профиль
    private final By profileText = By.xpath(".//a[text()='Профиль']");


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

    public ProfilePage waitExitButton(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonExit));
        return this;
    }

}
