package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FavoritesPage extends BasePage {

    public FavoritesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[@class='product-card__title']")
    private WebElement favoriteProductTitle;

    public void openFavorites() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement favoritesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='dropdown-label' and text()='Favorilerim']")));
        favoritesButton.click();
    }

    public void verifyFavoriteProduct(String expectedProductName) {
        WebElement favorites = driver.findElement(By.xpath("//h5[@class='product-card__title']"));
        System.out.println("Beklenen ürün adı: " + expectedProductName + ", Bulunan ürün adı: " + favorites.getText());
        assert favorites.getText().equals(expectedProductName) :
                "Beklenen ürün adı: " + expectedProductName + ", Ancak bulundu: " + favorites.getText();
    }
}