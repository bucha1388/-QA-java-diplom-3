import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import pom.LoginPage;
import pom.MainPage;
import pom.ProfilePage;
import pom.RegisterPage;

import static org.hamcrest.CoreMatchers.is;
import static testdata.TestData.*;
import static testdata.TestData.WRONG_PASSWORD;

public class LinksTest {


    // В @Rule вынесены параметры Before и After (включая настройку браузера)
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    @DisplayName("Check link to profile without login")
    @Description("Проверка перехода на страницу Личного кабинета для незалогиненого пользователя")
    public void LinkToProfileWithoutLogin() {

        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage
                .openPage()
                .clickProfile();

        LoginPage loginPage = new LoginPage(browserRule.getDriver());

        MatcherAssert.assertThat(loginPage.getTextH2(), is("Вход"));
    }
    @Test
    @DisplayName("Check link to profile with login")
    @Description("Проверка перехода на страницу Личного кабинета для залогиненого пользователя")
    public void LinkToProfileWithLogin() {

        LoginPage loginPage = new LoginPage(browserRule.getDriver());

        loginPage
                .fullLogin(MAIN_EMAIL, MAIN_PASSWORD);

        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage
                .clickProfile();

        ProfilePage profilePage = new ProfilePage(browserRule.getDriver());

        Assert.assertNotNull(profilePage.getProfileText());
    }

    @Test
    @DisplayName("Check link from profile to logo click")
    @Description("Проверка перехода на главную из Личного кабинета через клик по лого")
    public void LinkToMainFromProfileLogo() {

        LoginPage loginPage = new LoginPage(browserRule.getDriver());

        loginPage
                .fullLogin(MAIN_EMAIL, MAIN_PASSWORD);

        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage
                .clickProfile();

        ProfilePage profilePage = new ProfilePage(browserRule.getDriver());

        profilePage
                .clickLogo();

        Assert.assertNotNull(mainPage.getH1Text());
    }

    @Test
    @DisplayName("Check link from profile to constructor click")
    @Description("Проверка перехода на главную из Личного кабинета через клик по аголовку Конструктор")
    public void LinkToMainFromProfileConstructor() {

        LoginPage loginPage = new LoginPage(browserRule.getDriver());

        loginPage
                .fullLogin(MAIN_EMAIL, MAIN_PASSWORD);

        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage
                .clickProfile();

        ProfilePage profilePage = new ProfilePage(browserRule.getDriver());

        profilePage
                .clickConstructor();

        Assert.assertNotNull(mainPage.getH1Text());
    }

    @Test
    @DisplayName("Check exit account")
    @Description("Проверка действий по клику на заголовок Выход")
    public void ExitFromAccount() {

        LoginPage loginPage = new LoginPage(browserRule.getDriver());

        loginPage
                .fullLogin(MAIN_EMAIL, MAIN_PASSWORD);

        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage
                .clickProfile();

        ProfilePage profilePage = new ProfilePage(browserRule.getDriver());

        profilePage
                .waitExitButton()
                .clickButtonLogout();


        Assert.assertNotNull(loginPage.getTextH2());
    }

}

