
package configuratorTestSuite2;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DragAndDropHTML5 {

    public enum Position {

        TopLeft,
        Top,
        TopRight,
        Left,
        Center,
        Right,
        BottomLeft,
        Bottom,
        BottomRight
    }

    public static int getX(final Position pos, final int width) {
        if (Position.TopLeft.equals(pos) || Position.Left.equals(pos) || Position.BottomLeft.equals(pos)) {
            return 1;
        } else if (Position.Top.equals(pos) || Position.Center.equals(pos) || Position.Bottom.equals(pos)) {
            return width / 2;
        } else if (Position.TopRight.equals(pos) || Position.Right.equals(pos) || Position.BottomRight.equals(pos)) {
            return width - 1;
        } else {
            return 0;
        }
    }

    static int getY(final Position pos, final int height) {
        if (Position.TopLeft.equals(pos) || Position.Top.equals(pos) || Position.TopRight.equals(pos)) {
            return 1;
        } else if (Position.Left.equals(pos) || Position.Center.equals(pos) || Position.Right.equals(pos)) {
            return height / 2;
        } else if (Position.BottomLeft.equals(pos) || Position.Bottom.equals(pos) || Position.BottomRight.equals(pos)) {
            return height - 1;
        } else {
            return 0;
        }
    }

    private static String javaScriptEventSimulator = "" +
    /* Creates a drag event */
            "function createDragEvent(eventName, options)\r\n" + "{\r\n"
            + "var event = document.createEvent('HTMLEvents');\r\n" + "event.initEvent('DragEvent', true, true);\r\n" +
            // " var event = document.createEvent(\"DragEvent\");\r\n" +
            "   var screenX = window.screenX + options.clientX;\r\n"
            + "   var screenY = window.screenY + options.clientY;\r\n" + "   var clientX = options.clientX;\r\n"
            + "   var clientY = options.clientY;\r\n" + "   var dataTransfer = {\r\n"
            + "       data: options.dragData == null ? {} : options.dragData,\r\n"
            + "       setData: function(eventName, val){\r\n" + "           if (typeof val === 'string') {\r\n"
            + "               this.data[eventName] = val;\r\n" + "           }\r\n" + "       },\r\n"
            + "       getData: function(eventName){\r\n" + "           return this.data[eventName];\r\n"
            + "       },\r\n" + "       clearData: function(){\r\n" + "           return this.data = {};\r\n"
            + "       },\r\n" + "       setDragImage: function(dragElement, x, y) {}\r\n" + "   };\r\n"
            + "   var eventInitialized=false;\r\n" + "   if (event != null && event.initDragEvent) {\r\n"
            + "       try {\r\n"
            + "           event.initDragEvent(eventName, true, true, window, 0, screenX, screenY, clientX, clientY, false, false, false, false, 0, null, dataTransfer);\r\n"
            + "           event.initialized=true;\r\n" + "       } catch(err) {\r\n" + "           // no-op\r\n"
            + "       }\r\n" + "   }\r\n" + "   if (!eventInitialized) {\r\n"
            + "       event = document.createEvent(\"CustomEvent\");\r\n"
            + "       event.initCustomEvent(eventName, true, true, null);\r\n" + "       event.view = window;\r\n"
            + "       event.detail = 0;\r\n" + "       event.screenX = screenX;\r\n"
            + "       event.screenY = screenY;\r\n" + "       event.clientX = clientX;\r\n"
            + "       event.clientY = clientY;\r\n" + "       event.ctrlKey = false;\r\n"
            + "       event.altKey = false;\r\n" + "       event.shiftKey = false;\r\n"
            + "       event.metaKey = false;\r\n" + "       event.button = 0;\r\n"
            + "       event.relatedTarget = null;\r\n" + "       event.dataTransfer = dataTransfer;\r\n" + "   }\r\n"
            + "   return event;\r\n" + "}\r\n" +

            /* Creates a mouse event */
            "function createMouseEvent(eventName, options)\r\n" + "{\r\n"
            + "   var event = document.createEvent(\"MouseEvent\");\r\n"
            + "   var screenX = window.screenX + options.clientX;\r\n"
            + "   var screenY = window.screenY + options.clientY;\r\n" + "   var clientX = options.clientX;\r\n"
            + "   var clientY = options.clientY;\r\n" + "   if (event != null && event.initMouseEvent) {\r\n"
            + "       event.initMouseEvent(eventName, true, true, window, 0, screenX, screenY, clientX, clientY, false, false, false, false, 0, null);\r\n"
            + "   } else {\r\n" + "       event = document.createEvent(\"CustomEvent\");\r\n"
            + "       event.initCustomEvent(eventName, true, true, null);\r\n" + "       event.view = window;\r\n"
            + "       event.detail = 0;\r\n" + "       event.screenX = screenX;\r\n"
            + "       event.screenY = screenY;\r\n" + "       event.clientX = clientX;\r\n"
            + "       event.clientY = clientY;\r\n" + "       event.ctrlKey = false;\r\n"
            + "       event.altKey = false;\r\n" + "       event.shiftKey = false;\r\n"
            + "       event.metaKey = false;\r\n" + "       event.button = 0;\r\n"
            + "       event.relatedTarget = null;\r\n" + "   }\r\n" + "   return event;\r\n" + "}\r\n" +

            /* Runs the events */
            "function dispatchEvent(webElement, eventName, event)\r\n" + "{\r\n"
            + "   if (webElement.dispatchEvent) {\r\n" + "       webElement.dispatchEvent(event);\r\n"
            + "   } else if (webElement.fireEvent) {\r\n" + "       webElement.fireEvent(\"on\"+eventName, event);\r\n"
            + "   }\r\n" + "}\r\n" +

            /* Simulates an individual event */
            "function simulateEventCall(element, eventName, dragStartEvent, options) {\r\n" + "   var event = null;\r\n"
            + "   if (eventName.indexOf(\"mouse\") > -1) {\r\n"
            + "       event = createMouseEvent(eventName, options);\r\n" + "   } else {\r\n"
            + "       event = createDragEvent(eventName, options);\r\n" + "   }\r\n"
            + "   if (dragStartEvent != null) {\r\n" + "       event.dataTransfer = dragStartEvent.dataTransfer;\r\n"
            + "   }\r\n" + "   dispatchEvent(element, eventName, event);\r\n" + "   return event;\r\n" + "}\r\n";

    /**
     * Simulates an individual events
     */
    private static String simulateEvent = javaScriptEventSimulator
            + "function simulateEvent(element, eventName, clientX, clientY, dragData) {\r\n"
            + "   return simulateEventCall(element, eventName, null, {clientX: clientX, clientY: clientY, dragData: dragData});\r\n"
            + "}\r\n" +

            "var event = simulateEvent(arguments[0], arguments[1], arguments[2], arguments[3], arguments[4]);\r\n"
            + "if (event.dataTransfer != null) {\r\n" + "   return event.dataTransfer.data;\r\n" + "}\r\n";

    /**
     * Simulates drag and drop
     */
    private static String simulateHTML5DragAndDrop = javaScriptEventSimulator
            + "function simulateHTML5DragAndDrop(dragFrom, dragTo, dragFromX, dragFromY, dragToX, dragToY) {\r\n"
            + "   var mouseDownEvent = simulateEventCall(dragFrom, \"mousedown\", null, {clientX: dragFromX, clientY: dragFromY});\r\n"
            + "   var dragStartEvent = simulateEventCall(dragFrom, \"dragstart\", null, {clientX: dragFromX, clientY: dragFromY});\r\n"
            + "   var dragEnterEvent = simulateEventCall(dragTo,   \"dragenter\", dragStartEvent, {clientX: dragToX, clientY: dragToY});\r\n"
            + "   var dragOverEvent  = simulateEventCall(dragTo,   \"dragover\",  dragStartEvent, {clientX: dragToX, clientY: dragToY});\r\n"
            + "   var dropEvent      = simulateEventCall(dragTo,   \"drop\",      dragStartEvent, {clientX: dragToX, clientY: dragToY});\r\n"
            + "   var dragEndEvent   = simulateEventCall(dragFrom, \"dragend\",   dragStartEvent, {clientX: dragToX, clientY: dragToY});\r\n"
            + "}\r\n"
            + "simulateHTML5DragAndDrop(arguments[0], arguments[1], arguments[2], arguments[3], arguments[4], arguments[5]);\r\n";

    /**
     * Calls a drag event
     *
     * @param driver
     *     The WebDriver to execute on
     * @param dragFrom
     *     The WebElement to simulate on
     * @param eventName
     *     The event name to call
     * @param clientX
     *     The mouse click X position on the screen
     * @param clientY
     *     The mouse click Y position on the screen
     * @param data
     *     The data transfer data
     * @return The updated data transfer data
     */
    public static Object html5_simulateEvent(final WebDriver driver, final WebElement dragFrom, final String eventName,
            final int clientX, final int clientY, final Object data) {
        return ((JavascriptExecutor) driver).executeScript(simulateEvent, dragFrom, eventName, clientX, clientY, data);
    }

    /**
     * Calls a drag event
     *
     * @param driver
     *     The WebDriver to execute on
     * @param dragFrom
     *     The WebElement to simulate on
     * @param eventName
     *     The event name to call
     * @param mousePosition
     *     The mouse click area in the element
     * @param data
     *     The data transfer data
     * @return The updated data transfer data
     */
    public static Object html5_simulateEvent(final WebDriver driver, final WebElement dragFrom, final String eventName,
            final Position mousePosition, final Object data) {
        final Point fromLocation = dragFrom.getLocation();
        final Dimension fromSize = dragFrom.getSize();

        // Get Client X and Client Y locations
        final int clientX = fromLocation.getX() + (fromSize == null ? 0 : getX(mousePosition, fromSize.getWidth()));
        final int clientY = fromLocation.getY() + (fromSize == null ? 0 : getY(mousePosition, fromSize.getHeight()));
        return html5_simulateEvent(driver, dragFrom, eventName, clientX, clientY, data);
    }

    /**
     * Drags and drops a web element from source to target
     *
     * @param driver
     *     The WebDriver to execute on
     * @param dragFrom
     *     The WebElement to drag from
     * @param dragTo
     *     The WebElement to drag to
     * @param dragFromX
     *     The position to click relative to the top-left-corner of the
     *     client
     * @param dragFromY
     *     The position to click relative to the top-left-corner of the
     *     client
     * @param dragToX
     *     The position to release relative to the top-left-corner of the
     *     client
     * @param dragToY
     *     The position to release relative to the top-left-corner of the
     *     client
     */
    public static void html5_DragAndDrop(final WebDriver driver, final WebElement dragFrom, final WebElement dragTo,
            final int dragFromX, final int dragFromY, final int dragToX, final int dragToY) {
        ((JavascriptExecutor) driver).executeScript(simulateHTML5DragAndDrop, dragFrom, dragTo, dragFromX, dragFromY,
                dragToX, dragToY);
    }

    /**
     * Drags and drops a web element from source to target
     *
     * @param drivers
     *     The WebDriver to execute on
     * @param dragFrom
     *     The WebElement to drag from
     * @param dragTo
     *     The WebElement to drag to
     * @param dragFromPosition
     *     The place to click on the dragFrom
     * @param dragToPosition
     *     The place to release on the dragTo
     */
    public static void html5_DragAndDrop(final WebDriver driver, final WebElement dragFrom, final WebElement dragTo,
            final Position dragFromPosition, final Position dragToPosition) {
        final Point fromLocation = dragFrom.getLocation();
        final Point toLocation = dragTo.getLocation();
        final Dimension fromSize = dragFrom.getSize();
        final Dimension toSize = dragTo.getSize();

        // Get Client X and Client Y locations
        final int dragFromX = fromLocation.getX()
                + (fromSize == null ? 0 : getX(dragFromPosition, fromSize.getWidth()));
        final int dragFromY = fromLocation.getY()
                + (fromSize == null ? 0 : getY(dragFromPosition, fromSize.getHeight()));
        final int dragToX = toLocation.getX() + (toSize == null ? 0 : getX(dragToPosition, toSize.getWidth()));
        final int dragToY = toLocation.getY() + (toSize == null ? 0 : getY(dragToPosition, toSize.getHeight()));
        html5_DragAndDrop(driver, dragFrom, dragTo, dragFromX, dragFromY, dragToX, dragToY);
    }

    // Cross-Window Drag And Drop Example

    public static void dragToWindow(final WebDriver dragFromDriver, final WebElement dragFromElement,
            final WebDriver dragToDriver) {
        // Drag start
        html5_simulateEvent(dragFromDriver, dragFromElement, "mousedown", Position.Center, null);
        Object dragData = html5_simulateEvent(dragFromDriver, dragFromElement, "dragstart", Position.Center, null);
        dragData = html5_simulateEvent(dragFromDriver, dragFromElement, "dragenter", Position.Center, dragData);
        dragData = html5_simulateEvent(dragFromDriver, dragFromElement, "dragleave", Position.Left, dragData);
        dragData = html5_simulateEvent(dragFromDriver, dragFromDriver.findElement(By.tagName("body")), "dragleave",
                Position.Left, dragData);

        // Drag to other window
        html5_simulateEvent(dragToDriver, dragToDriver.findElement(By.tagName("body")), "dragenter", Position.Right,
                null);
        final WebElement dropOverlay = dragToDriver.findElement(By.className("DropOverlay"));
        html5_simulateEvent(dragToDriver, dropOverlay, "dragenter", Position.Right, null);
        html5_simulateEvent(dragToDriver, dropOverlay, "dragover", Position.Center, null);
        dragData = html5_simulateEvent(dragToDriver, dropOverlay, "drop", Position.Center, dragData);
        html5_simulateEvent(dragFromDriver, dragFromElement, "dragend", Position.Center, dragData);
    }

}
