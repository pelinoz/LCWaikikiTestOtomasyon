package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.LoginPage;
import pages.ProductPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.FavoritesPage;
import utilities.Driver;
import utilities.TestListener;

@Listeners(TestListener.class)
public class FullFlowTest extends BaseTest {

    LoginPage loginPage = new LoginPage(Driver.getDriver());
    CategoryPage categoryPage = new CategoryPage(Driver.getDriver());
    ProductPage productPage = new ProductPage(Driver.getDriver());
    CartPage cartPage = new CartPage(Driver.getDriver());
    CheckoutPage checkoutPage = new CheckoutPage(Driver.getDriver());
    FavoritesPage favoritesPage = new FavoritesPage(Driver.getDriver());

    @Test
    @Description("Full flow test from login to checkout")
    public void fullFlowTest() throws InterruptedException {
        rejectCookies();
        performLogin();
        navigateToCategory();
        selectProductAndVerifyCart();
        proceedToCheckout();
        verifyFavorites();
    }

    @Step("Reject cookies on the homepage to ensure a clean slate for testing")
    public void rejectCookies() {
        loginPage.rejectCookies();
    }

    @Step("Log in to the application with valid user credentials")
    public void performLogin() throws InterruptedException {
        loginPage.hoverLogin();
        loginPage.clickLoginButton();
        Thread.sleep(2000);
        loginPage.enterEmail("pelinoztest@outlook.com");
        Thread.sleep(2000);
        loginPage.enterPassword("atf7*P6ML7P8Nr9");
    }

    @Step("Navigate to the desired category by interacting with the category menu")
    public void navigateToCategory() throws InterruptedException {
        Thread.sleep(2000);
        categoryPage.hoverChildrenAndBabyCategory();
        Thread.sleep(1000);
        categoryPage.hoverGirlsCategory();
        Thread.sleep(1000);
        categoryPage.selectMontKaban();
    }

    @Step("Select a product, add it to the cart, and verify the cart details")
    public void selectProductAndVerifyCart() throws InterruptedException {
        productPage.selectFilters();
        Thread.sleep(1000);
        productPage.selectColor();
        Thread.sleep(2000);
        productPage.sortByBestSellers();
        Thread.sleep(2000);
        productPage.clickOnProductTitle();
        Thread.sleep(2000);
        productPage.selectAge();
        productPage.addToCart();
        cartPage.openCart();
        Thread.sleep(2000);
        cartPage.verifyProductDetails("Mont", "Koyu Bej");
        cartPage.verifyCartDetails("1", "EXPECTED_PRICE");
        productPage.addToFavorites();
    }

    @Step("Proceed through the checkout process and complete the order")
    public void proceedToCheckout() throws InterruptedException {
        checkoutPage.proceedToCheckout();
        Thread.sleep(2000);
        checkoutPage.completeCheckoutProcess();
    }

    @Step("Verify that the favorite products section contains the added product")
    public void verifyFavorites() {
        favoritesPage.openFavorites();
        favoritesPage.verifyFavoriteProduct("Kapüşonlu Kız Çocuk Mont");
    }

    @AfterClass
    public void tearDown() {
        if (Driver.getDriver() != null) {
            Driver.getDriver().quit();
            System.out.println("Driver kapatıldı.");
        }
    }

}
