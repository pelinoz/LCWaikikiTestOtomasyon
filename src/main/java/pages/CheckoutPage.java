package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='https://www.lcw.com/checkout#adres' and text()='ÖDEME ADIMINA GEÇ']")
    private WebElement proceedToCheckoutLink;

    public void proceedToCheckout() {
        click(proceedToCheckoutLink);
    }

    public void completeCheckoutProcess() throws InterruptedException {
        Thread.sleep(3000);
        WebElement deliveryTypeElement = driver.findElement(By.xpath("//div[@class='deliveryTypeName']//div[contains(text(),'Adrese Teslimat')]"));
        deliveryTypeElement.click();
        Thread.sleep(3000);
        WebElement elementRadio = driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div[1]/div/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div/div/div[1]/label/span"));
        elementRadio.click();
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement paymentElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"paymentContainers\"]/div[1]/div/div[1]/label/span")));
        paymentElement.click();
        Thread.sleep(3000);

        WebElement cancelButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-cancel btn-bold btn-block']")));
        cancelButton.click();

        // Ana ekrana git
        driver.navigate().to("https://www.lcw.com/");
        System.out.println("Ana ekrana yönlendirildi.");
    }
}