package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();

            // Bildirim ve pop-up engelleme
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");

            // Otomasyon kontrolünü gizleme
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("--disable-infobars");

            // Gerçek bir tarayıcı gibi davranma (User-Agent değiştirme)
            options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");

            // WebDriver oluşturma
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
