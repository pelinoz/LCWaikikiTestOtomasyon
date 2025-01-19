package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='dropdown-label' and text()='Sepetim']")
    private WebElement cartLabel;

    @FindBy(xpath = "//span[@class='rd-cart-item-code']")
    private WebElement productName;

    @FindBy(xpath = "//strong[text()='Koyu Bej']")
    private WebElement productColor;

    public void verifyProductDetails(String expectedName, String expectedColor) {
        assert productName.getText().equals(expectedName);
        assert productColor.getText().equals(expectedColor);
    }
    public void verifyCartDetails(String expectedQuantity, String expectedPrice) {
        // Ürün adedini kontrol et
        WebElement urunAdedi = driver.findElement(By.xpath("//input[@class='item-quantity-input ignored']"));
        assert urunAdedi.getAttribute("value").equals(expectedQuantity) : "Ürün adedi beklenen ile eşleşmiyor.";

        // Ürün fiyatını al
        WebElement urunTutari = driver.findElement(By.xpath("//span[@class='rd-cart-item-price mb-15']"));
        String urunTutariText = urunTutari.getText().replace(" TL", "").replace(",", ".");

        // Ödeme tutarını al
        WebElement odenenTutar = driver.findElement(By.xpath("//span[@class='total-grand-box-amount']"));
        String odenenTutarText = odenenTutar.getText().replace(" TL", "").replace(",", ".");

        // Tutarların eşleşip eşleşmediğini kontrol et
        assert urunTutariText.equals(odenenTutarText) : "Ürün fiyatı ve ödenen tutar eşleşmiyor.";

        System.out.println("Ürün adedi, fiyatı ve toplam ödeme tutarı doğrulandı.");
    }


    public void openCart() {
        click(cartLabel);
    }
}