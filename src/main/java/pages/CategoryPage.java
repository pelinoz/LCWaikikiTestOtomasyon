package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategoryPage extends BasePage {

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='header__container']/header/div[3]/nav/ul/li[4]/a")
    private WebElement childrenAndBabyCategory;

    @FindBy(xpath = "//*[@id='header__container']/header/div[3]/nav/ul/li[4]/div/nav/ul/button[4]/span[2]")
    private WebElement girlsCategory;

    @FindBy(xpath = "//a[@href='/kiz-cocuk-dis-giyim-t-1010' and text()='Mont ve Kaban']")
    private WebElement montKabanLink;

    public void hoverChildrenAndBabyCategory() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            WebElement childrenAndBabyCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header__container']/header/div[3]/nav/ul/li[4]/a")));
            hoverOver(childrenAndBabyCategory);
        } catch (TimeoutException e) {
            System.err.println("Element bulunamadı: " + e.getMessage());
        }
    }


    public void hoverGirlsCategory() {
        hoverOver(girlsCategory);
    }

    public void selectMontKaban() {
        click(montKabanLink);
    }
}
