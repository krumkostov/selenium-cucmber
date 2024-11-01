package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductsPage {
    WebDriver driver;
    WebDriverWait wait;

    By cartBadge = By.className("shopping_cart_badge");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart(String productId) {
        By addButton = By.id("add-to-cart-" + productId);
        WebElement productButton = driver.findElement(addButton);
        productButton.click();
    }

    public boolean isProductAddedToCart(int expectedCount) {
        WebElement badge = driver.findElement(cartBadge);
        String badgeText = badge.getText();
        return badgeText.equals(String.valueOf(expectedCount));
    }

    public void removeProductFromCart(String productId) {
        By removeButton = By.id("remove-" + productId);
        WebElement productButton = driver.findElement(removeButton);
        productButton.click();
    }

    public boolean isCartEmpty() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[data-test='shopping-cart-badge']")));
    }

    public void goToCart() {
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("shopping_cart_container")));
        cartButton.click();
    }

}
