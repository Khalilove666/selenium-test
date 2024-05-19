import org.openqa.selenium.*;

public class HomePage extends BasePage {
    private final By newsLetterEmail = By.xpath("//input[@type='email' and contains(@class, 't-input__field')]");
    private final By submitButton = By.xpath("//button[contains(@class,'footer__newsletter__submit-btn')]");

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver.get("https://timberline.hu");
    }

    public void setEmail(String email) {
        WebElement newsLetterEmailElement = waitAndReturnElement(newsLetterEmail);
        newsLetterEmailElement.click();
        newsLetterEmailElement.sendKeys(email);
    }

    public void clickSubmit() {
        WebElement submitElement = waitAndReturnElement(submitButton);
        submitElement.click();
    }

}