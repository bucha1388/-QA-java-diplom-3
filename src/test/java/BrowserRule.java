import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserRule extends ExternalResource {

    private WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }

    @Override
    protected void before() throws  Throwable {

        //Настройка браузера

//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.setBinary("C:/Users/bucha/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
//        WebDriver driver = new ChromeDriver(options);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

//      WebDriverManager.firefoxdriver().setup();
 //     driver = new FirefoxDriver();

    }

    @Override
    //Закрытие окна браузера
    protected  void after(){
        driver.quit();
    }
}