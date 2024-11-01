package steps;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import static org.testng.Assert.assertTrue;

public class LoginSteps extends BaseTest {

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        setUp(); // Ensure driver is initialized
    }

    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials() {
        // Login is already handled by BaseTest
    }

    @Then("the user should be redirected to the homepage")
    public void theUserShouldBeRedirectedToTheHomepage() {
        assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }

    @Then("the user verifies they are on the products page")
    public void theUserVerifiesTheyAreOnTheProductsPage() {
        assertTrue(driver.findElement(By.className("title")).getText().contains("Products"));
    }

    @When("the user adds {string} and {string} to the cart")
    public void theUserAddsProductsToTheCart(String firstProduct, String secondProduct) {
        productsPage.addProductToCart(firstProduct);
        productsPage.addProductToCart(secondProduct);
    }

    @Then("the user verifies the products are successfully added to the cart")
    public void theUserVerifiesTheProductsAreSuccessfullyAddedToTheCart() {
        boolean productsAdded = productsPage.isProductAddedToCart(2);
        assertTrue(productsAdded, "Products not added to cart as expected.");
    }

    @When("the user removes {string} and {string} from the cart")
    public void theUserRemovesProductsFromTheCart(String thirdProduct, String fourthProduct) {
        productsPage.removeProductFromCart(thirdProduct);
        productsPage.removeProductFromCart(fourthProduct);
    }

    @Then("the user verifies the products are successfully removed from the cart")
    public void theUserVerifiesTheProductsAreSuccessfullyRemovedFromTheCart() {
        boolean isCartEmpty = productsPage.isCartEmpty();
        assertTrue(isCartEmpty, "Cart is not empty as expected.");
    }

    @When("the user adds {string} and {string} to the cart again")
    public void theUserAddsAdditionalProductsToTheCart(String thirdProduct, String fourthProduct) {
        productsPage.addProductToCart(thirdProduct);
        productsPage.addProductToCart(fourthProduct);
    }

    @Then("the user verifies the additional products are successfully added to the cart")
    public void theUserVerifiesTheAdditionalProductsAreSuccessfullyAddedToTheCart() {
        boolean productsAdded = productsPage.isProductAddedToCart(2); // Проверка за добавените нови продукти
        assertTrue(productsAdded, "Additional products not added to cart as expected.");
    }

    @When("the user goes to the cart")
    public void theUserGoesToTheCart() {
        productsPage.goToCart();
    }

    @Then("the user verifies the products {string} and {string} are displayed in the cart")
    public void theUserVerifiesTheProductsAreDisplayedInTheCart(String firstProduct, String secondProduct) {
        boolean isFirstProductDisplayed = cartPage.isProductDisplayedInCart(firstProduct);
        boolean isSecondProductDisplayed = cartPage.isProductDisplayedInCart(secondProduct);
        assertTrue(isFirstProductDisplayed, firstProduct + " is not displayed in the cart");
        assertTrue(isSecondProductDisplayed, secondProduct + " is not displayed in the cart");
    }

}
