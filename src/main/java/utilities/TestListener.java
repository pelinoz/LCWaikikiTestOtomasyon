package utilities;

import io.qameta.allure.Attachment;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
        // Test başarısız olduğunda ekran görüntüsü ekle
        captureScreenshotOnFailure(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test suite started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test suite finished: " + context.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test failed within success percentage: " + result.getName());
    }

    @Attachment(value = "Screenshot on Failure", type = "image/png")
    public byte[] captureScreenshotOnFailure(String testName) {
        // TestUtils sınıfındaki metodu kullanarak ekran görüntüsü al
        return TestUtils.captureScreenshot(testName);
    }
}
