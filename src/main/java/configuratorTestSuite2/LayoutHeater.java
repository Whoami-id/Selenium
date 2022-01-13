
package configuratorTestSuite2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LayoutHeater extends Base {

    WebDriver driver;

    // Finds correct element
    @FindBy(xpath = "//li[@data-target='layout/heaters']")
    private WebElement layoutHeater;

    @FindBy(xpath = "//span[contains(@class,'lbl')and contains(text(),'type23')]")
    private WebElement heater;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='polygon'])[13]")
    private WebElement roomsRightSide;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='polygon'])[14]")
    private WebElement roomsLowerSide;

    /**
     * Constructor the class
     *
     * @param driver
     */
    public LayoutHeater(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on heater icon
     */
    public void clickOnHeaterIcon() {
        click(layoutHeater, 20);
    }

    /**
     * Drags and drops heater to rooms right side
     */
    public void dragAndDropRoomsRightSideHeater() {
        final WebElement src = dragAndDrop(heater, 20);
        final WebElement rightSide = dragAndDrop(roomsRightSide, 20);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, rightSide, 0, 0, 1175, 680);
    }

    /**
     * Drags and drops heater to rooms lower side
     */
    public void dragAndDropRoomsLowerSideHeater() {
        final WebElement src = dragAndDrop(heater, 20);
        final WebElement lowerSide = dragAndDrop(roomsLowerSide, 20);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, lowerSide, 0, 0, 0, 0);
    }

}
