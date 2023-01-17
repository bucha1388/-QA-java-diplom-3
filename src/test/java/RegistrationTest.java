import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import pom.LoginPage;
import pom.MainPage;
import pom.RegisterPage;

import static org.hamcrest.CoreMatchers.is;
import static testdata.TestData.*;

public class RegistrationTest {

    // В @Rule вынесены параметры Before и After (включая настройку браузера)
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    @DisplayName("Check registration page. Positive test")
    @Description("Проверка процесса регистрации пользователя со всеми корректними данными")
    public void RegistrationWithRightData() {
        RegisterPage regPage = new RegisterPage(browserRule.getDriver());

        regPage
                .openPage()
                .inputName(NAME)
                .inputEmail(EMAIL)
                .inputToPassword(PASSWORD)
                .clickButtonRegister();

        LoginPage loginPage = new LoginPage(browserRule.getDriver());

        loginPage
                .inputEmail(EMAIL)
                .inputToPassword(PASSWORD)
                .waitLoginButton()
                .clickButtonLogin();

        MainPage mainPage = new MainPage(browserRule.getDriver());

        Assert.assertNotNull(mainPage.getButtonCreateOrder());
    }

    @Test
    @DisplayName("Check registration with wrong password")
    @Description("Проверка процесса регистрации пользователя с паролем меньше 5 символов")
    public void RegistrationWithWrongPassword() {

        RegisterPage regPage = new RegisterPage(browserRule.getDriver());

        regPage
                .openPage()
                .inputName(NAME)
                .inputEmail(EMAIL)
                .inputToPassword(WRONG_PASSWORD)
                .clickButtonRegister();

        MatcherAssert.assertThat(regPage.getErrorMessage(), is("Некорректный пароль"));

    }
}
