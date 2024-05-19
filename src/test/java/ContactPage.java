import org.openqa.selenium.*;

public class ContactPage extends BasePage {
    private final By contactName = By.xpath("//input[@class='t-input__field' and @placeholder='Név']");
    private final By contactEmail = By.xpath("//input[@class='t-input__field' and @placeholder='Email']");
    private final By contactDescription = By
            .xpath("//textarea[contains(@class, 'contact-page__textarea') and @placeholder='Beviteli szöveg']");
    private final By submitButton = By.xpath("//button[contains(@class, 'contact-page__btn')]");

    public ContactPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://timberline.hu/contact");
    }

    public void setName(String name) {
        WebElement contactNameElement = waitAndReturnElement(contactName);
        contactNameElement.click();
        contactNameElement.sendKeys(name);
    }

    public void setEmail(String email) {
        WebElement contactEmailElement = waitAndReturnElement(contactEmail);
        contactEmailElement.click();
        contactEmailElement.sendKeys(email);
    }

    public void setDescription(String description) {
        WebElement contactDescriptionElement = waitAndReturnElement(contactDescription);
        contactDescriptionElement.click();
        contactDescriptionElement.sendKeys(description);
    }

    public void clickSubmit() {
        WebElement submitButtonElement = waitAndReturnElement(submitButton);
        submitButtonElement.click();
    }

}