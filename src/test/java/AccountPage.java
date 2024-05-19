import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class AccountPage extends BasePage {
    private final By logoutButton = By.xpath("//div[contains(@class, 'header__logout-btn')]");
    private final By confirmLogoutButton = By.xpath("//button[contains(@class, 'header__logout-modal__btn')]");

    public AccountPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://timberline.hu/registry/account-info");
    }

    public void logoutSubmit() {
        WebElement logoutElement = waitAndReturnElement(logoutButton);
        logoutElement.click();

        WebElement confirmLogoutElement = wait
                .until(ExpectedConditions.visibilityOfElementLocated(confirmLogoutButton));
        confirmLogoutElement.click();

        // Verify successful logout by checking the page title
        wait.until(ExpectedConditions.titleContains("Bejelentkezés - TimberLine"));

        String pageTitle = driver.getTitle();
        if (pageTitle.contains("Bejelentkezés - TimberLine")) {
            System.out.println("Logout test passed!");
        } else {
            System.out.println("Logout test failed!");
        }
    }
}