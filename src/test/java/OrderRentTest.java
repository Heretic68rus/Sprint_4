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
    @Parameter
    public String browserType;
    private WebDriver driver;

    public OrderRentTest() {
    }

    @Parameters
    public static Object[][] browser() {
        return new Object[][]{{"chrome"}, {"firefox"}};
    }

    @Before
    public void setup() {
        if (this.browserType.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            this.driver = new ChromeDriver();
        } else if (this.browserType.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            this.driver = new FirefoxDriver();
        }

    }

    @Test
    public void testUpButton() {
        this.driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageObject homePageObject = new HomePageObject(this.driver);
        homePageObject.clickorderButtonUpOnHomePage();
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

    @Test
    public void testDownButton() {
        this.driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageObject homePageObject = new HomePageObject(this.driver);
        homePageObject.clickorderButtonDownOnHomePage();
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