package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;
import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isProductDisplayedInCart(String productId) {
        By product = By.id("remove-" + productId);
        try {
            WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(product));
            return productElement.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
