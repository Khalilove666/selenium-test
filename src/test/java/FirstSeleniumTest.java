import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.*;

import java.net.URL;
import java.net.MalformedURLException;

public class FirstSeleniumTest {
    public WebDriver driver;

    String email = "hmm@mmm.com";
    String password = "Hmmm12345!";

    String[] pageUrls = { "https://timberline.hu/knowledge-base", "https://timberline.hu/forum" };

    @Before
    public void setup() throws MalformedURLException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();

        String filePath = ".env";
        Map<String, String> envVars = EnvReader.readEnv(filePath);
        if (envVars.get("EMAIL").length() > 0) {
            this.email = envVars.get("EMAIL");
        }
        if (envVars.get("PASSWORD").length() > 0) {
            this.password = envVars.get("PASSWORD");
        }
    }

    @Test
    public void testHomePageNewsletter() {
        HomePage homePage = new HomePage(this.driver);
        homePage.setEmail(email);
        homePage.clickSubmit();
    }

    @Test
    public void testHistory() {
        History history = new History();
        history.performHistoryTest();
    }

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.setEmail(this.email);
        loginPage.setPassword(this.password);
        loginPage.clickSubmit();
    }

    @Test
    public void testContactPage() {
        ContactPage contactPage = new ContactPage(this.driver);
        contactPage.setName("Hmmm");
        contactPage.setEmail("hmm@mmm.com");
        contactPage.setDescription("Description text");
        contactPage.clickSubmit();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        System.out.println("Test Passed: Contact form sent!");
    }

    @Test
    public void testLogout() {
        AccountPage accountPage = new AccountPage(this.driver);
        accountPage.logoutSubmit();
    }

    @Test
    public void testMultiplePages() {
        for (String pageUrl : pageUrls) {
            try {
                this.driver.get(pageUrl);
                System.out.println("Successfully visited to page with url: " + pageUrl);
            } catch (Exception e) {
                System.out.println("Error occurred while visiting to page: " + pageUrl);
                e.printStackTrace();
            }
        }
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
