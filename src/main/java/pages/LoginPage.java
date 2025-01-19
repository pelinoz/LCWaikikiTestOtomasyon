package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "cookieseal-banner-reject")
    private WebElement cookieRejectButton;

    @FindBy(xpath = "//*[@id='header__container']/header/div[2]/div[3]/div/span/div/a/span")
    private WebElement loginHover;

    @FindBy(xpath = "//a[@class='cart-action__btn cart-action__btn--bg-blue']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id='login']/div/div[2]/div/div/div/form/div/div/input")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id='login']/div/div[2]/div/div/div/form/div/button")
    private WebElement emailSubmitButton;

    @FindBy(xpath = "//*[@id=\"login\"]/div/div[2]/div/div/div/form/div[2]/div/input")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"login\"]/div/div[2]/div/div/div/form/button")
    private WebElement passwordSubmitButton;

    public void rejectCookies() {
        click(cookieRejectButton);
    }

    public void hoverLogin() {
        hoverOver(loginHover);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public void enterEmail(String email) {
        sendKeys(emailInput, email);
        click(emailSubmitButton);
    }

    public void enterPassword(String password) {
        sendKeys(passwordInput, password);
        click(passwordSubmitButton);
    }
}