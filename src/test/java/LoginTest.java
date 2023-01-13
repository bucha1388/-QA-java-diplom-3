import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import pom.ForgotPasswordPage;
import pom.LoginPage;
import pom.MainPage;
import pom.RegisterPage;

import static testdata.TestData.*;


public class LoginTest {

    // В @Rule вынесены параметры Before и After (включая настройку браузера)
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    @DisplayName("Check login from main page")
    @Description("Проверка процесса логина с кнопки Войти на главной странице")
    public void LoginFromMainPage() {

        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage
                .openPage()
                .clickLogin();

        LoginPage loginPage = new LoginPage(browserRule.getDriver());

        loginPage
                .inputEmail(MAIN_EMAIL)
                .inputToPassword(MAIN_PASSWORD)
                .waitLoginButton()
                .clickButtonLogin();

        Assert.assertNotNull(mainPage.getButtonCreateOrder());
    }

    @Test
    @DisplayName("Check login from click profile")
    @Description("Проверка процесса логина через клик по кнопке Личный кабинет")

    public void LoginFromMainPageProfile() {


        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage
                .openPage()
                .clickProfile();

        LoginPage loginPage = new LoginPage(browserRule.getDriver());

        loginPage
                .inputEmail(MAIN_EMAIL)
                .inputToPassword(MAIN_PASSWORD)
                .waitLoginButton()
                .clickButtonLogin();

        Assert.assertNotNull(mainPage.getButtonCreateOrder());
    }

    @Test
    @DisplayName("Check login from registration page")
    @Description("Проверка процесса логина с кнопки Войти на транице регистрации")
    public void LoginFromRegistrationPage() {

        RegisterPage regPage = new RegisterPage(browserRule.getDriver());

        regPage
                .openPage()
                .clickLinkLogin();

        LoginPage loginPage = new LoginPage(browserRule.getDriver());

        loginPage
                .inputEmail(MAIN_EMAIL)
                .inputToPassword(MAIN_PASSWORD)
                .waitLoginButton()
                .clickButtonLogin();

        MainPage mainPage = new MainPage(browserRule.getDriver());

        Assert.assertNotNull(mainPage.getButtonCreateOrder());
    }

    @Test
    @DisplayName("Check login from forgot-password page")
    @Description("Проверка процесса логина с кнопки Войти на странице восстановления пароля")
    public void LoginFromForgotPage() {

        ForgotPasswordPage forgotPage = new ForgotPasswordPage(browserRule.getDriver());

        forgotPage
                .openPage()
                .clickButtonLogin();

        LoginPage loginPage = new LoginPage(browserRule.getDriver());

        loginPage
                .inputEmail(MAIN_EMAIL)
                .inputToPassword(MAIN_PASSWORD)
                .waitLoginButton()
                .clickButtonLogin();

        MainPage mainPage = new MainPage(browserRule.getDriver());

        Assert.assertNotNull(mainPage.getButtonCreateOrder());
    }

}
