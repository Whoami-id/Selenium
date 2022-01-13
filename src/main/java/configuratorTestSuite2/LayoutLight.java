
package configuratorTestSuite2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LayoutLight extends Base {

    WebDriver driver;

    // Finds correct element
    @FindBy(xpath = "//li[@data-target='layout/lights']")
    private WebElement layoutLight;

    @FindBy(xpath = "//span[contains(@class,'lbl')and contains(text(),'Type30')]")
    private WebElement light;

    @FindBy(xpath = "(//*[name()='svg']//*[local-name()='polygon'])[1]")
    private WebElement withinTheRoom;

    private final By countOfLight = By
            .xpath("//*[name()='svg']//*[local-name()='g' and @class='lightParent signParent']");

    /**
     * Constructor the class
     *
     * @param driver
     */
    public LayoutLight(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Click on light icon
     */
    public void clickOnLightIcon() {
        click(layoutLight, 20);
    }

    /**
     * Drags and drops lights
     */
    public void dragAndDropToWithinTheRoomLight() {
        final WebElement src = dragAndDrop(light, 10);
        final WebElement dest = dragAndDrop(withinTheRoom, 10);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, dest, 0, 0, 810, 800);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, dest, 0, 0, 1100, 800);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, dest, 0, 0, 810, 1050);
        DragAndDropHTML5.html5_DragAndDrop(driver, src, dest, 0, 0, 1100, 1050);
    }

    /**
     * Checks count of lights after drag and drop
     *
     * @return count of lights
     */
    public int checkCountOfLightAfterDragAndDrop() {
        return getCountOfElements(countOfLight, 4);
    }

    /**
     * Checks count of light before drag and drop
     *
     * @return count of light
     */
    public int checkCountOfLightBeforeDragAndDrop() {
        return driver.findElements(countOfLight).size();
    }

}
