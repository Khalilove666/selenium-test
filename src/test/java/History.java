import org.openqa.selenium.WebDriver;

public class History {
    private WebDriver driver;

    public void performHistoryTest() {
        try {
            // Navigate to Packages page
            driver.navigate().to("https://timberline.hu/packages");

            // Navigate to Packages about
            driver.navigate().to("https://timberline.hu/about");

            // Go back to Packages page
            driver.navigate().back();

            // Verify if we are on Packages page
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.equals("https://timberline.hu/packages")) {
                System.out.println("Go back in History test passed!");
            } else {
                throw new Exception("History test failed! Current URL: " + currentUrl);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred during Go back in History test: " + e.getMessage());
        }
    }
}