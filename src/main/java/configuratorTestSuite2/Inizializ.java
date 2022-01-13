
package configuratorTestSuite2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import reporter.Email;

public class Inizializ {

    public static ReadPropertyFile propertyFile;
    public static ChromeOptions options;
    public static EdgeOptions edgeOption;
    public WebDriver driver;

    @BeforeSuite
    public void loadObjcts() {
        propertyFile = new ReadPropertyFile();
        options = new ChromeOptions();
        edgeOption = new EdgeOptions();
    }

    @Parameters("browser")
    @BeforeClass
    public void inizializ(final String browser) throws InterruptedException {
        if (browser.equalsIgnoreCase("chrome")) {
            final HashMap<String, Object> chromePref = new HashMap<>();
            chromePref.put("profile.default_content_settings.popups", 0);
            chromePref.put("download.default_directory", propertyFile.getDownloadPath());
            options.setExperimentalOption("prefs", chromePref);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            final Map<String, Object> edgePref = new HashMap<>();
            edgePref.put("download.default_directory", propertyFile.getDownloadPath());
            edgeOption.setExperimentalOption("prefs", edgePref);
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(edgeOption);
        }

        driver.manage().window().maximize();
        driver.get(propertyFile.getUrl());
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    @Parameters({ "pathChromePdf", "pathEdgePdf", "pathOperaPdf" })
    public void setEmail(final String pathChromePdf, final String pathEdgePdf, final String pathOperaPdf) {
        Email.sendEmail(propertyFile.getEmailRecipient(), pathChromePdf, pathEdgePdf, pathOperaPdf);
        driver.quit();
    }

}
