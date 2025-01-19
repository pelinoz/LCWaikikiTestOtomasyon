package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Attachment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestUtils {

    private static WebDriver driver = Driver.getDriver();

    @Attachment(value = "Screenshot on Failure", type = "image/png")
    public static byte[] captureScreenshot(String screenshotName) {
        try {
            // Ekran görüntüsünü al
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File screenshotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

            // Ekran görüntüsünü proje dizinine kaydet
            Path screenshotPath = Paths.get(System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png");
            Files.createDirectories(screenshotPath.getParent());
            Files.copy(screenshotFile.toPath(), screenshotPath);

            // Ekran görüntüsünü Allure raporuna eklemek için byte[] döndür
            return Files.readAllBytes(screenshotPath);

        } catch (IOException e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
            return new byte[0];
        }
    }
}
