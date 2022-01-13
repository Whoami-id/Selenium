
package configuratorTestSuite2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LayoutOverView extends Base {

    WebDriver driver;
    /** Finds correct element */
    @FindBy(xpath = "//li[@data-target='layout/overview']")
    private WebElement layoutOverView;

    @FindBy(xpath = "//span[contains(text(),'Pdf 1:50')]")
    private WebElement pdfButton;

    /**
     * Constructor the class
     *
     * @param driver
     */
    public LayoutOverView(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on overview icon
     */
    public void clickOnOverViewIcon() {
        super.click(layoutOverView, 30);
    }

    /**
     * Clicks on PDF button
     */
    public void clickOnPDFButton() {
        click(pdfButton, 30);
    }

    /**
     * Checks if file size is bigger than 0
     *
     * @param downloadPath
     * @param fileName
     * @return
     */
    public boolean checkIfFileIsDownloaded(final String downloadPath, final String fileName) {
        if (isFileDownloaded(downloadPath, fileName) == false) {
            return false;
        }
        return true;
    }

}
