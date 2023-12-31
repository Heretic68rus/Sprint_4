import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.AboutRentPageObject;
import org.example.HomePageObject;
import org.example.OrderPageObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class OrderRentTest {

    private WebDriver driver;
    @Parameter
    public String buttonLocation;

    @Parameters
    public static Object[][] data() {
        return new Object[][]{{"Up"}, {"Down"}};
    }
    @Before
    public void setup() {
        switch (System.getProperty("browser")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                this.driver = new ChromeDriver();
                break;
            case "firefox":
            default:
                WebDriverManager.firefoxdriver().setup();
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                this.driver = new FirefoxDriver();
        }
    }

    @Test
    public void testButton() {
        this.driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageObject homePageObject = new HomePageObject(this.driver);
        homePageObject.clickorderButtonOnHomePage(buttonLocation);
        homePageObject.waitForLoadHeaderOrderPage();
        OrderPageObject orderPageObject = new OrderPageObject(this.driver);
        orderPageObject.fillNameFieldOrderPage("Иван");
        orderPageObject.fillFamilyNameFieldOrderPage("Иванов");
        orderPageObject.fillAddressFieldOrderPage("ул.Пушкина, д.1");
        orderPageObject.fillMetroFieldOrderPage("Сокольники");
        orderPageObject.fillPhoneFieldOrderPage("89998886655");
        orderPageObject.clickFurtherButtonOrderPage();
        orderPageObject.waitForLoadHeaderAboutRentPage();
        AboutRentPageObject aboutRentPageObject = new AboutRentPageObject(this.driver);
        aboutRentPageObject.fillDateFieldAboutRentPage("20.12.2023");
        aboutRentPageObject.clickRentalPeriodFieldAboutRentPage();
        aboutRentPageObject.clickTwoDaysChoiseAboutRentPage();
        aboutRentPageObject.clickOrderButtonAboutRentPage();
        aboutRentPageObject.clickYesOrderButtonAboutRentPage();
        aboutRentPageObject.waitForLoadHeaderOrderPlaced();

    }
    @After
    public void teardown() {
        this.driver.quit();
    }
}