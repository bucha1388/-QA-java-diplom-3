import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import pom.MainPage;


public class ConstructorTabTest {

    // В @Rule вынесены параметры Before и After (включая настройку браузера)
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    @DisplayName("Check Tabs in Ingredients menu ")
    @Description("Проверка, что при клике по ингридиентам происходит переход на соответствующую вкладку. ТАК КАК ВАЖНА последовательность проверти табов, все проверки в одном тесте!!!")
    public void TabConstructorTest() {

        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage
                .openPage()
                .clickFillingsTab();


        Assert.assertTrue(mainPage.fillingsTab().getDomAttribute("class").contains("tab_type_current"));
        Assert.assertFalse(mainPage.saucesTab().getDomAttribute("class").contains("tab_type_current"));
        Assert.assertFalse(mainPage.breadsTab().getDomAttribute("class").contains("tab_type_current"));

        mainPage
               .clickBreadsTab();
//               .waitActiveTab();

        Assert.assertFalse(mainPage.fillingsTab().getDomAttribute("class").contains("tab_type_current"));
        Assert.assertFalse(mainPage.saucesTab().getDomAttribute("class").contains("tab_type_current"));
        Assert.assertTrue(mainPage.breadsTab().getDomAttribute("class").contains("tab_type_current"));

        mainPage
                .clickSaucesTab();
//                .waitActiveTab();

        Assert.assertFalse(mainPage.fillingsTab().getDomAttribute("class").contains("tab_type_current"));
        Assert.assertTrue(mainPage.saucesTab().getDomAttribute("class").contains("tab_type_current"));
        Assert.assertFalse(mainPage.breadsTab().getDomAttribute("class").contains("tab_type_current"));

    }
}
