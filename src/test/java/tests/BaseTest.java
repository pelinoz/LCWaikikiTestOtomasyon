package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.Driver;

public abstract class BaseTest {

    @BeforeClass
    public void setUp() {
        Driver.getDriver().get("https://www.lcw.com");
    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}