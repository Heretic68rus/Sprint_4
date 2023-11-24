import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.HomePageObject;
import org.example.component.HomePageComponent;
import org.junit.After;
import org.junit.Assert;
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
public class HomePageComponentTest {
    private WebDriver driver;
    @Parameter
    public int index;
    @Parameter(1)
    public String expectedqQuestion;
    @Parameter(2)
    public String expectedAnswer;

    @Parameters
    public static Object[][] data() {
        return new Object[][]{{0, "Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."}, {1, "Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."}, {2, "Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."}, {3, "Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."}, {4, "Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."}, {5, "Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."}, {6, "Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."}, {7, "Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."}};
    }

    @Before
    public void setup() {
        switch (System.getProperty("browser")) {
            case "firefox":
                WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                this.driver = new ChromeDriver();// инициализация firefox
                break;
            case "chrome":
            default:
                WebDriverManager.firefoxdriver().setup();
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                this.driver = new FirefoxDriver();
        }
    }
    @Test
    public void homePageComponentTest() {
        this.driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageObject homePageObject = new HomePageObject(this.driver);
        HomePageComponent homePageComponent = homePageObject.getComponent(this.index);
        homePageComponent.openQuestion();
        Assert.assertEquals(this.expectedqQuestion, homePageComponent.getQuestion());
        Assert.assertEquals(this.expectedAnswer, homePageComponent.getAnswer());
    }
    @After
    public void teardown() {
        this.driver.quit();
    }
}
