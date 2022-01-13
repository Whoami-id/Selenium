
package configuratorTestSuite1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Inizializ {
    public static WebDriver driver;
    public static SoftAssert softAssert;
    public static ReadPropertyFile propertyFile;
    // public static ChromeOptions options;

    @BeforeSuite
    public void inizializ() {
        softAssert = new SoftAssert();
        propertyFile = new ReadPropertyFile();
        // options = new ChromeOptions();
        // options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        // options.addArguments("lang=de");
        WebDriverManager.chromedriver().setup();

        // ChromeDriver driver = new ChromeDriver(options);
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(propertyFile.getUrl());

    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        // Thread.sleep(4000);
        Inizializ.driver.quit();

    }

}
