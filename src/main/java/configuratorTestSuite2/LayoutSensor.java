
package configuratorTestSuite2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LayoutSensor extends Base {

    WebDriver driver;

    /** Finds correct element */
    @FindBy(xpath = "//li[@data-target='layout/sensors']")
    private WebElement layoutSensor;

    @FindBy(xpath = "//span[contains(@class,'lbl')and contains(text(),'Type92')]")
    private WebElement sensor;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='polygon'])[1]")
    private WebElement withinTheRoom;

    private final By countOfSensor = By
            .xpath("//*[name()='svg']//*[local-name()='g' and @class='sensorParent signParent']");

    /**
     * Constructor the class
     *
     * @param driver
     */
    public LayoutSensor(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Clicks on sensor icon
     */
    public void clickOnSensorIcon() {
        click(layoutSensor, 30);
    }

    /**
     * Drags and drop sensor
     */
    public void DragAndDropToWithinRoomSensor() {
        final WebElement src = dragAndDrop(sensor, 10);
        final WebElement dest = dragAndDrop(withinTheRoom, 10);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, dest, 0, 0, 850, 900);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, dest, 0, 0, 1050, 920);
    }

    /**
     * Checks count of sensor after drag and drop
     *
     * @return count of sensor
     */
    public int checkCountOfSensorAfterDragAndDrop() {
        return getCountOfElements(countOfSensor, 2);
    }

    /**
     * Checks count of sensor before drag and drop
     *
     * @return count of sensor
     */
    public int checkCountOfSensorBeforeDragAndDrop() {
        return driver.findElements(countOfSensor).size();
    }

}
