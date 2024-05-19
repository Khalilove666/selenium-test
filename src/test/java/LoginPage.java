import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By emailInput = By.xpath("//input[@type='email' and contains(@class, 't-input__field')]");
    private final By passwordInput = By.xpath("//input[@type='password' and contains(@class, 't-input__field')]");
    private final By submitButton = By.xpath("//button[contains(@class, 'login-page__fields__btn')]");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://timberline.hu/login");
    }

    public void setEmail(String email) {
        WebElement emailElement = waitAndReturnElement(emailInput);
        emailElement.click();
        emailElement.sendKeys(email);
    }

    public void setPassword(String password) {
        WebElement passwordElement = waitAndReturnElement(passwordInput);
        passwordElement.click();
        passwordElement.sendKeys(password);
    }

    public void clickSubmit() {
        WebElement submitElement = waitAndReturnElement(submitButton);
        submitElement.click();
    }

}