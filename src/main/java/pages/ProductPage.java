package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='filter-option__text' and text()='5-6 Yaş']")
    private WebElement ageOption1;

    @FindBy(xpath = "//span[text()='6 Yaş']")
    private WebElement ageOption2;

    @FindBy(xpath = "//span[@class='filter-option__text' and text()='6-7 Yaş']")
    private WebElement ageOption3;

    @FindBy(xpath = "//span[@class='color-filter-option__text' and text()='BEJ']")
    private WebElement beigeColorOption;

    @FindBy(xpath = "//span[text()='Sırala']")
    private WebElement sortButton;

    @FindBy(xpath = "//a[@role='button' and text()='En çok satanlar']")
    private WebElement bestSellersOption;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div[7]/div/div[2]/div[3]/a/div[2]/h5[2]")
    private WebElement productTitleLocator;

    public void selectFilters() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(ageOption1)).click();
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(ageOption2)).click();
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(ageOption3)).click();
        } catch (Exception e) {
            System.err.println("Filtre seçimi başarısız: " + e.getMessage());
        }
    }

    public void selectColor() {
        click(beigeColorOption);
    }

    public void sortByBestSellers() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            Thread.sleep(2000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, 0);", sortButton);
            WebElement sortButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Sırala']")));
            sortButton.click();

            WebElement bestSellersOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@role='button' and text()='En çok satanlar']")));
            bestSellersOption.click();
        } catch (Exception e) {
            System.err.println("Tıklama işlemi başarısız: " + e.getMessage());
        }
    }
    public void selectAge() throws InterruptedException {
        Thread.sleep(2000);
        WebElement ageButton = driver.findElement(By.xpath("//button[@data-label='10-11 Yaş']"));
        ageButton.click();
        Thread.sleep(2000);
    }


    public void clickOnProductTitle() {
        try {
            Thread.sleep(3000); // Geçici bekleme, gerekiyorsa kaldırın
            WebElement productTitle = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[7]/div/div[2]/div[3]/a/div[2]/h5[2]"));
            productTitle.click();
            System.out.println("Ürün başlığına tıklama başarılı.");
        } catch (Exception e) {
            System.err.println("Ürün başlığına tıklanamadı: " + e.getMessage());
        }
    }

    public void addToCart() throws InterruptedException {

        WebElement addToCartButton = driver.findElement(By.xpath("//button[@class='add-to-card']"));
        addToCartButton.click();
        Thread.sleep(2000); // Buton tıklamasından sonra bekleme süresi
    }
    public void addToFavorites() throws InterruptedException {
        WebElement kalpSimgesi = driver.findElement(By.xpath("//i[@class='fa fa-heart-o' and @aria-hidden='true']"));
        kalpSimgesi.click();
        Thread.sleep(2000); // Kalp simgesine tıklamanın etkisini görmek için bekleme
        System.out.println("Ürün favorilere eklendi.");
    }



}