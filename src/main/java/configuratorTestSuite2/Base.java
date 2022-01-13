
package configuratorTestSuite2;

import java.io.File;
import java.time.Duration;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

    private final WebDriver driver;

    /**
     * Constructor the class
     *
     * @param driver
     */
    public Base(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks on a Button
     *
     * @param element
     * @param timeout
     */
    public void click(final WebElement element, final long timeout) {
        boolean click = true;
        WebElement webElement = null;
        while (click) {
            try {
                webElement = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
                        .pollingEvery(Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(element));
                final Actions builder = new Actions(driver);
                builder.moveToElement(webElement).click(webElement);
                builder.perform();
                // webElement.click();
                click = false;
            } catch (final ElementClickInterceptedException | StaleElementReferenceException
                    | NoSuchElementException ex) {
                click = true;
            }
        }

    }

    /**
     * Clicks on a Button
     *
     * @param by
     * @param timeout
     */
    public void click(final By by, final long timeout) {
        boolean click = true;
        WebElement webElement = null;

        while (click) {
            try {
                webElement = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
                        .pollingEvery(Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(by));
                final Actions builder = new Actions(driver);
                builder.moveToElement(webElement).click(webElement);
                builder.perform();
                // webElement.click();
                click = false;
            } catch (final ElementClickInterceptedException | StaleElementReferenceException
                    | NoSuchElementException ex) {
                click = true;
            }
        }
    }

    /**
     * Selects from drop down menu
     *
     * @param element
     * @param timeout
     * @param text
     */
    public void select(final WebElement element, final long timeout, final String text) {
        boolean staleElement = true;
        WebElement selectedElement = null;
        while (staleElement) {
            try {
                selectedElement = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
                        .pollingEvery(Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(element));
                final Select select = new Select(selectedElement);
                select.selectByVisibleText(text);
                staleElement = false;
            } catch (final StaleElementReferenceException | ElementNotInteractableException
                    | NoSuchElementException ex) {
                staleElement = true;
            }
        }

    }

    /**
     * Writes text
     *
     * @param element
     * @param timeout
     * @param text
     */
    public void typeForProjectPalaning(final WebElement element, final long timeout, final String text) {
        final WebElement selectedElement = new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.elementToBeClickable(element));
        selectedElement.click();
        selectedElement.sendKeys(Keys.chord(Keys.CONTROL + "a"), text);
        selectedElement.sendKeys(Keys.ENTER);
    }

    /**
     * Writes text
     *
     * @param element
     * @param timeout
     * @param text
     */
    public void type(final WebElement element, final long timeout, final String text) {
        boolean send = true;
        WebElement selectedElement = null;
        while (send) {
            try {
                selectedElement = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
                        .pollingEvery(Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(element));
                selectedElement.sendKeys(Keys.chord(Keys.CONTROL + "a"), text);
                // selectedElement.sendKeys(Keys.UP);
                // selectedElement.clear();
                // selectedElement.sendKeys(text);
                send = false;
            } catch (final NoSuchElementException | StaleElementReferenceException ex) {
                send = true;
            }
        }
    }

    /**
     * Gets value from input field
     *
     * @param element
     * @return
     */
    public String getValueFromInputField(final WebElement element) {
        final WebElement webElement = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(element));
        return webElement.getAttribute("value");
    }

    /**
     * Gets value from drop down menu
     *
     * @param element
     * @return
     */
    public String getValueFromDropDownMenu(final WebElement element) {
        boolean staleStatement = true;
        WebElement webElement = null;
        String text = null;
        final Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2));
        webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        while (staleStatement) {
            try {
                text = new Select(webElement).getFirstSelectedOption().getText().trim();
                staleStatement = false;
            } catch (StaleElementReferenceException | NoSuchElementException ex) {
                // text = new Select(webElement).getFirstSelectedOption().getText().trim();
                staleStatement = true;
            }
        }
        return text;
    }

    /**
     * Clicks on sinner
     *
     * @param element
     * @param n
     * @param timout
     */
    public void spinner(final WebElement element, final int n, final long timout) {
        final WebElement spinner = new WebDriverWait(driver, Duration.ofSeconds(timout))
                .until(ExpectedConditions.elementToBeClickable(element));
        IntStream.range(0, n).forEach(i -> {
            try {
                Thread.sleep(400);
                spinner.click();
            } catch (final InterruptedException ex) {
                ex.printStackTrace();
            }
        });

    }

    /**
     * Finds element
     *
     * @param element
     * @param timeout
     * @return WebElement
     */
    public WebElement dragAndDrop(final WebElement element, final long timeout) {
        boolean foundElement = true;
        WebElement webElement = null;
        while (foundElement) {
            try {
                webElement = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
                        .pollingEvery(Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(element));
                foundElement = false;
            } catch (final NoSuchElementException | StaleElementReferenceException ex) {
                foundElement = true;
            }
        }
        return webElement;
    }

    /**
     * Checks spinner max value
     *
     * @param element
     * @param maxValue
     * @param timeOut
     */
    public void spinnerMaxValue(final WebElement element, final String maxValue, final long timeOut) {
        final WebElement spinner = new WebDriverWait(driver, Duration.ofSeconds(timeOut))
                .until(ExpectedConditions.elementToBeClickable(element));
        spinner.sendKeys(Keys.chord(Keys.CONTROL + "a"), maxValue);
    }

    /**
     * Checks spinner min value
     *
     * @param element
     * @param maxValue
     * @param timeOut
     */
    public void spinnerMinValue(final WebElement element, final String minValue, final long timeOut) {
        final WebElement spinner = new WebDriverWait(driver, Duration.ofSeconds(timeOut))
                .until(ExpectedConditions.elementToBeClickable(element));
        spinner.sendKeys(Keys.chord(Keys.CONTROL + "a"), minValue);
    }

    /**
     * Checks if file size is bigger than 0
     *
     * @param downloadPath
     * @param fileName
     * @return
     */
    public boolean isFileDownloaded(final String downloadPath, final String fileName) {
        final File dir = new File(downloadPath + "\\" + fileName);
        if (!(dir.exists() & dir.length() / 1024 > 0)) {
            return false;
        }
        dir.delete();
        return true;
    }

    /**
     * Gets count of elements
     *
     * @param by
     * @param number
     * @return count of elements
     */
    public int getCountOfElements(final By by, final int number) {
        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(driver -> new WebDriverWait(driver, Duration.ofSeconds(30))
                        .until(ExpectedConditions.numberOfElementsToBe(by, number)))
                .size();
    }

}
