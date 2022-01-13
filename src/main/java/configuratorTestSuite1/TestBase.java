
package configuratorTestSuite1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestBase extends Inizializ {
    final String date = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
    public static String projectName;

    /**
     * Goes to HomePage Configurator
     *
     * @throws InterruptedException
     */
    @Test(priority = 1, description = "fist test")
    public void gotoHomapage() throws InterruptedException {
        final Homepage homepage = PageFactory.initElements(driver, Homepage.class);
        homepage.clickConfigurationButton();
        final String ulr = driver.getCurrentUrl();
        softAssert.assertEquals(ulr, propertyFile.getUrl(), "Url is false please verify it!");
    }

    /**
     * Logs in Configurator
     */
    @Test(priority = 2, description = "second test")
    public void loginToConfigurator() {
        final Login login = PageFactory.initElements(driver, Login.class);
        login.loginWithYourAccount();

    }

    /**
     * Adding a new Project
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 3, description = "third test")
    public void addingNewProject() {
        final AddNewProjectButton addNewProject = PageFactory.initElements(driver, AddNewProjectButton.class);
        addNewProject.clickOnAddNewProject();
    }

    /**
     * Plans Project
     *
     * @throws InterruptedException
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 4, description = "fourth test")
    public void planingProject() throws InterruptedException {
        final ProjectPlaning projectPlaning = PageFactory.initElements(driver, ProjectPlaning.class);

        projectPlaning.createAProject();
        projectPlaning.goBackToProjectPlaning();
        // verify the values
        projectName = projectPlaning.getEnteredProjectName();
        softAssert.assertEquals(projectName, propertyFile.getProjectName() + date);
        softAssert.assertEquals(projectPlaning.getEnteredPostalCode(), propertyFile.getPostaCode());
        softAssert.assertEquals(projectPlaning.getEnteredCity(), propertyFile.getCity());
        softAssert.assertEquals(projectPlaning.getSelectedConstructionType(), propertyFile.getconstructionType());
        softAssert.assertEquals(projectPlaning.getEnteredStartDate(), propertyFile.getStartDate());
        projectPlaning.clickOnPlusSymbol();
    }

    /**
     * Create Wall
     *
     * @throws InterruptedException
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 5, description = "fifth test")
    public void creatingWall() throws InterruptedException {
        final CreateWall createWall = PageFactory.initElements(driver, CreateWall.class);
        createWall.clickOnCreateWallType();
        createWall.clickOnCreatedWall();
        // Saves default values
        final String defaultName = createWall.getValueFromInputFieldWallName();
        final String defaultMasonryType = createWall.getValueFromSelectMasonryType();
        final String defaultInstallationsType = createWall.getValueFromSelectInstallationType();
        final String defaultWallType = createWall.getValueFromSelectWallType();
        final String defaultFireResistanceType = createWall.getValueFromSelecteFireResistanceType();
        // Create Wall an abort changes
        createWall.createWallAndAbortIt();
        Thread.sleep(2000);
        createWall.clickOnCreatedWall();
        Thread.sleep(2000);
        // verify the values
        softAssert.assertEquals(createWall.getValueFromInputFieldWallName(), defaultName);
        softAssert.assertEquals(createWall.getValueFromSelectMasonryType(), defaultMasonryType);
        softAssert.assertEquals(createWall.getValueFromSelectInstallationType(), defaultInstallationsType);
        softAssert.assertEquals(createWall.getValueFromSelectWallType(), defaultWallType);
        softAssert.assertEquals(createWall.getValueFromSelecteFireResistanceType(), defaultFireResistanceType);
        // Creates Wall and save changes
        createWall.createWallAndSaveIt();
        Thread.sleep(2000);
        createWall.clickOnCreatedWall();
        // Verify the values
        softAssert.assertEquals(createWall.getValueFromInputFieldWallName(), propertyFile.getWallName());
        softAssert.assertEquals(createWall.getValueFromSelectMasonryType(), propertyFile.getMasonryType());
        softAssert.assertEquals(createWall.getValueFromSelectInstallationType(), propertyFile.getInstallationType());
        softAssert.assertEquals(createWall.getValueFromSelectWallType(), propertyFile.getWallType());
        softAssert.assertEquals(createWall.getValueFromSelecteFireResistanceType(),
                propertyFile.getFireResistanceType());
        Thread.sleep(2000);
        // delete Created Window
        // createWall.clickOndeleteWall();
    }

    /**
     * Creates Window
     *
     * @throws InterruptedException
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 6, description = "sixth test")
    public void creatingWindow() throws InterruptedException {
        final CreateWindow createWindow = PageFactory.initElements(driver, CreateWindow.class);
        createWindow.clickOnWindowIcon();
        createWindow.clickOnCreateWindowType();
        createWindow.clickOnCreatedWindow();
        // Saves default values
        final String defaultName = createWindow.getValueFromInputFieldWindowName();
        final String defaultWindowOpeningType = createWindow.getValueFeomSelecteWindowOpeningType();
        final String defaultGlazingType = createWindow.getValueFromSelecteGlazingType();
        final String defaultWindowContact = createWindow.getValueFromSelecteWindowContactNo();
        final String defaultWindowControlType = createWindow.getValueFromSelecteWindowControlType();
        Thread.sleep(2000);
        // Creates Window and abort Changes
        createWindow.createWindowAndAbort();
        Thread.sleep(2000);
        createWindow.clickOnCreatedWindow();
        // Verify the values
        softAssert.assertEquals(createWindow.getValueFromInputFieldWindowName(), defaultName);
        softAssert.assertEquals(createWindow.getValueFeomSelecteWindowOpeningType(), defaultWindowOpeningType);
        softAssert.assertEquals(createWindow.getValueFromSelecteGlazingType(), defaultGlazingType);
        softAssert.assertEquals(createWindow.getValueFromSelecteWindowContactNo(), defaultWindowContact);
        softAssert.assertEquals(createWindow.getValueFromSelecteWindowControlType(), defaultWindowControlType);
        // Creates a Window and save changes
        createWindow.createWindowAndSave();
        Thread.sleep(2000);
        createWindow.clickOnCreatedWindow();
        // Verify the Values
        softAssert.assertEquals(createWindow.getValueFromInputFieldWindowName(), propertyFile.getWindowName());
        softAssert.assertEquals(createWindow.getValueFeomSelecteWindowOpeningType(), propertyFile.getWindowType());
        softAssert.assertEquals(createWindow.getValueFromSelecteGlazingType(), propertyFile.getWindowGlazinType());
        softAssert.assertEquals(createWindow.getValueFromSelecteWindowContactNo(), propertyFile.getWindowContactNo());
        softAssert.assertEquals(createWindow.getValueFromSelecteWindowControlType(),
                propertyFile.getWindowControlType());
        Thread.sleep(2000);
        // Deletes created Window
        createWindow.clickOndeleteWall();
        Thread.sleep(2000);

    }

    /**
     * Creates Blind
     *
     * @throws InterruptedException
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 7, description = "seventh test")
    public void createBlind() throws InterruptedException {
        final CreateBlinds createBlind = PageFactory.initElements(driver, CreateBlinds.class);
        createBlind.clickOnBlindIcon();
        Thread.sleep(2000);
        createBlind.clickOnCreateNewType();
        Thread.sleep(2000);
        createBlind.clickOnCreatedBlind();
        Thread.sleep(2000);
        // Saves default values
        final String defaultName = createBlind.getValueFromInputFieldBlindsName();
        final String defalutShadinType = createBlind.getValeuFromSelectShadingType();
        final String defaultColor = createBlind.getValueFromSelectColor();
        Thread.sleep(2000);
        // Creates Blind and abort Changes
        createBlind.createBlindAndAbortChanges();
        Thread.sleep(2000);

        createBlind.clickOnCreatedBlind();
        Thread.sleep(2000);
        // Verify the values
        softAssert.assertEquals(createBlind.getValueFromInputFieldBlindsName(), defaultName);
        softAssert.assertEquals(createBlind.getValeuFromSelectShadingType(), defalutShadinType);
        softAssert.assertEquals(createBlind.getValueFromSelectColor(), defaultColor);
        Thread.sleep(2000);
        // Creates a Blind and save changes
        createBlind.createBlindAndSaveChanges();
        Thread.sleep(2000);

        createBlind.clickOnCreatedBlind();
        Thread.sleep(2000);
        // Verify the Values
        softAssert.assertEquals(createBlind.getValueFromInputFieldBlindsName(), propertyFile.getBlindName());
        softAssert.assertEquals(createBlind.getValeuFromSelectShadingType(), propertyFile.getShadingType());
        softAssert.assertEquals(createBlind.getValueFromSelectColor(), propertyFile.getShadingColor());
        Thread.sleep(2000);

        createBlind.clickOnDeleteBlind();
        Thread.sleep(2000);

    }

    /**
     * Creates Door
     *
     * @throws InterruptedException
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 8, description = "eighth test")
    public void createDoor() throws InterruptedException {
        final CreateDoor createDoor = PageFactory.initElements(driver, CreateDoor.class);
        createDoor.clickOnDoorIcon();
        Thread.sleep(2000);

        createDoor.clickOnCreateDoorType();
        Thread.sleep(2000);

        createDoor.clickOnCreatedDoor();
        // Saves default values
        final String defaultDoorName = createDoor.getValueFromInputFieldDoorName();
        final String defaultDoorMaterialType = createDoor.getValueFromSelectDoorMaterialType();
        final String defaultDoorSecurityType = createDoor.getValueFromSelecteDoorSecurityType();
        final String defaultDoorOpeningType = createDoor.getValueFromSelectDoorOpeningType();
        final String defaultDoorCategory = createDoor.getValueFormSelectDoorCatergory();
        final String defaultDoorControlType = createDoor.getValueFromSelectDoorControlType();
        final String defaultDoorLockType = createDoor.getValueFromSelectDoorLookType();
        final String defaultDoorOpeningSideType = createDoor.getValueFromSelectDoorOpeningSideType();
        Thread.sleep(2000);
        // Creates Door and abort Changes
        createDoor.clickOnAbortChanges();
        Thread.sleep(2000);

        createDoor.clickOnCreatedDoor();
        Thread.sleep(2000);
        // Verify the Values
        softAssert.assertEquals(createDoor.getValueFromInputFieldDoorName(), defaultDoorName);
        softAssert.assertEquals(createDoor.getValueFromSelectDoorMaterialType(), defaultDoorMaterialType);
        softAssert.assertEquals(createDoor.getValueFromSelecteDoorSecurityType(), defaultDoorSecurityType);
        softAssert.assertEquals(createDoor.getValueFromSelectDoorOpeningType(), defaultDoorOpeningType);
        softAssert.assertEquals(createDoor.getValueFormSelectDoorCatergory(), defaultDoorCategory);
        softAssert.assertEquals(createDoor.getValueFromSelectDoorControlType(), defaultDoorControlType);
        softAssert.assertEquals(createDoor.getValueFromSelectDoorLookType(), defaultDoorLockType);
        softAssert.assertEquals(createDoor.getValueFromSelectDoorOpeningSideType(), defaultDoorOpeningSideType);
        Thread.sleep(2000);
        // Creates a Blind and save changes
        createDoor.createDoorAndSave();
        Thread.sleep(2000);

        createDoor.clickOnCreatedDoor();
        Thread.sleep(2000);
        // Verify the Values
        softAssert.assertEquals(createDoor.getValueFromInputFieldDoorName(), propertyFile.getDoorName());
        softAssert.assertEquals(createDoor.getValueFromSelectDoorMaterialType(), propertyFile.getDoorMaterial());
        softAssert.assertEquals(createDoor.getValueFromSelecteDoorSecurityType(), propertyFile.getDoorSecurity());
        softAssert.assertEquals(createDoor.getValueFromSelectDoorOpeningType(), propertyFile.getDoorType());
        softAssert.assertEquals(createDoor.getValueFormSelectDoorCatergory(), propertyFile.getDoorCategory());
        softAssert.assertEquals(createDoor.getValueFromSelectDoorControlType(), propertyFile.getDoorControlType());
        softAssert.assertEquals(createDoor.getValueFromSelectDoorLookType(), propertyFile.getDoorLockType());
        softAssert.assertEquals(createDoor.getValueFromSelectDoorOpeningSideType(),
                propertyFile.getDoorOpeningSideType());
        Thread.sleep(2000);
        createDoor.clickOnDelete();
    }

    /**
     * Creates AccessControl
     *
     * @throws InterruptedException
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 9, description = "ninth test")
    public void createAccessControl() throws InterruptedException {

        final CreateAccessControl accessControl = PageFactory.initElements(driver, CreateAccessControl.class);

        accessControl.clickOnAccessControlIcon();
        Thread.sleep(2000);
        accessControl.clickOnCreateNewType();
        Thread.sleep(2000);
        accessControl.clickOnCreatedAccessControl();
        Thread.sleep(2000);
        // Saves default values
        final String defaultName = accessControl.getValueFromInputFieldName();
        final String defaultCategory = accessControl.getValueFromSelectAccessControlCategory();
        final String defaultUseArt = accessControl.getValueFromSelectAccessControlUseArt();
        Thread.sleep(2000);
        // Creates AccessControl and abort
        accessControl.createAccessControlAndAbort();
        accessControl.clickOnCreatedAccessControl();
        Thread.sleep(2000);
        // Verify the Values
        softAssert.assertEquals(accessControl.getValueFromInputFieldName(), defaultName);
        softAssert.assertEquals(accessControl.getValueFromSelectAccessControlCategory(), defaultCategory);
        softAssert.assertEquals(accessControl.getValueFromSelectAccessControlUseArt(), defaultUseArt);
        Thread.sleep(2000);
        // Creates AccessControl and save
        accessControl.createAccessControlAndSave();
        Thread.sleep(2000);
        // Verify the Values
        accessControl.clickOnCreatedAccessControl();
        softAssert.assertEquals(accessControl.getValueFromInputFieldName(), propertyFile.getAccessControlName());
        softAssert.assertEquals(accessControl.getValueFromSelectAccessControlCategory(),
                propertyFile.getAccessControlCategory());
        softAssert.assertEquals(accessControl.getValueFromSelectAccessControlUseArt(),
                propertyFile.getAccessControlUseArt());
        Thread.sleep(2000);
        // deletes created Type
        accessControl.clickOnDelete();
    }

    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 10, description = "tenth test")
    public void createHeater() throws InterruptedException {

        final CreateHeater createHeater = PageFactory.initElements(driver, CreateHeater.class);
        createHeater.clickOnHeaterIcon();
        Thread.sleep(2000);
        createHeater.clickOnCreateNewType();
        Thread.sleep(2000);
        createHeater.clickOnCreatedType();
        Thread.sleep(2000);
        // Saves default values
        final String defaultHeaterName = createHeater.getValueFromInpuFieldHeaterName();
        final String defaultHeaterType = createHeater.getValueFromSelectHeaterType();
        final String defaultHeaterStyle = createHeater.getValueFromSelectHeaterStyle();
        final String defaultHeaterActuator = createHeater.getValueFromSelecHeaterActuatorType();
        // Creates Heater and abort
        createHeater.createHeaterAndAbort();
        Thread.sleep(2000);
        createHeater.clickOnCreatedType();
        // Verify the Values
        softAssert.assertEquals(createHeater.getValueFromInpuFieldHeaterName(), defaultHeaterName);
        softAssert.assertEquals(createHeater.getValueFromSelectHeaterType(), defaultHeaterType);
        softAssert.assertEquals(createHeater.getValueFromSelectHeaterStyle(), defaultHeaterStyle);
        softAssert.assertEquals(createHeater.getValueFromSelecHeaterActuatorType(), defaultHeaterActuator);
        Thread.sleep(2000);
        // Creates Heater and save
        createHeater.createHeaterAndSave();
        Thread.sleep(2000);
        createHeater.clickOnCreatedType();
        // Verify the Values
        softAssert.assertEquals(createHeater.getValueFromInpuFieldHeaterName(), propertyFile.getHeaterName());
        softAssert.assertEquals(createHeater.getValueFromSelectHeaterType(), propertyFile.getHeaterType());
        softAssert.assertEquals(createHeater.getValueFromSelectHeaterStyle(), propertyFile.getHeaterStyle());
        softAssert.assertEquals(createHeater.getValueFromSelecHeaterActuatorType(),
                propertyFile.getHeaterActuatorType());
        Thread.sleep(2000);
        createHeater.clickOnDelete();

    }

    /**
     * Creates Ventilation
     *
     * @throws InterruptedException
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 11, description = "eleventh test")
    public void createVentilation() throws InterruptedException {
        final CreateVentilation createVentilation = PageFactory.initElements(driver, CreateVentilation.class);
        createVentilation.clickOnVentilationIcon();
        Thread.sleep(2000);
        createVentilation.clickOnCreateNewType();
        Thread.sleep(2000);
        createVentilation.clickOnCreatedVentilation();
        Thread.sleep(2000);
        // Saves default values
        final String name = createVentilation.getValueFromInputFieldVentilationName();
        final String usageType = createVentilation.getValueFromSelectVentilationUsageType();
        final String systemType = createVentilation.getValueFromSelectVentilationSystem();
        final String manufacturer = createVentilation.getValueFromSelectVentilationManufacturer();
        final String model = createVentilation.getValueFromSelectVentilationModel();
        // Creates Ventilation and abort
        createVentilation.createVentilationAndAboirtChanges();
        Thread.sleep(2000);
        createVentilation.clickOnCreatedVentilation();
        // Verify the Values
        softAssert.assertEquals(createVentilation.getValueFromInputFieldVentilationName(), name);
        softAssert.assertEquals(createVentilation.getValueFromSelectVentilationUsageType(), usageType);
        softAssert.assertEquals(createVentilation.getValueFromSelectVentilationSystem(), systemType);
        softAssert.assertEquals(createVentilation.getValueFromSelectVentilationManufacturer(), manufacturer);
        softAssert.assertEquals(createVentilation.getValueFromSelectVentilationModel(), model);
        Thread.sleep(2000);
        // Creates Ventilation and save
        createVentilation.createVentilationAndSaveChanges();
        Thread.sleep(2000);
        createVentilation.clickOnCreatedVentilation();
        // Verify the Values
        softAssert.assertEquals(createVentilation.getValueFromInputFieldVentilationName(),
                propertyFile.getVentilationName());
        softAssert.assertEquals(createVentilation.getValueFromSelectVentilationUsageType(),
                propertyFile.getVentilationUsage());
        softAssert.assertEquals(createVentilation.getValueFromSelectVentilationSystem(),
                propertyFile.getVentilationSystem());
        softAssert.assertEquals(createVentilation.getValueFromSelectVentilationManufacturer(),
                propertyFile.getVentilationManufacturer());
        softAssert.assertEquals(createVentilation.getValueFromSelectVentilationModel(),
                propertyFile.getVentilationModel());
        Thread.sleep(2000);
        createVentilation.clickOnDelete();

    }

    /**
     * Creates Light
     *
     * @throws InterruptedException
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 12, description = "twelfth test")
    public void createLight() throws InterruptedException {

        final CreateLight createLight = PageFactory.initElements(driver, CreateLight.class);
        createLight.clickOnLightIcon();
        Thread.sleep(2000);
        createLight.clickOnCreateNewType();
        Thread.sleep(2000);
        createLight.clickOnCreatedLight();
        Thread.sleep(2000);
        // Saves default values
        final String name = createLight.getValueFromInputFieldLightName();
        final String functionType = createLight.getValueFromSelectLightFunctionType();
        final String articleNr = createLight.getValueFromInputFieldLightArticleNumber();
        final String description = createLight.getValueFromInputFieldLightDescriptionText();
        final String type = createLight.getValueFromSelectLightType();
        final String unit = createLight.getValueFromInputFieldLightUnit();
        Thread.sleep(2000);
        // Creates Light and abort
        createLight.createLightAndAbort();
        Thread.sleep(2000);
        createLight.clickOnCreatedLight();
        // Verify the Values
        softAssert.assertEquals(createLight.getValueFromInputFieldLightName(), name);
        softAssert.assertEquals(createLight.getValueFromSelectLightFunctionType(), functionType);
        softAssert.assertEquals(createLight.getValueFromInputFieldLightArticleNumber(), articleNr);
        softAssert.assertEquals(createLight.getValueFromInputFieldLightDescriptionText(), description);
        softAssert.assertEquals(createLight.getValueFromSelectLightType(), type);
        softAssert.assertEquals(createLight.getValueFromInputFieldLightUnit(), unit);
        Thread.sleep(2000);
        // Creates Light and save
        createLight.createLightAndSave();
        Thread.sleep(2000);
        createLight.clickOnCreatedLight();
        // Saves default values
        softAssert.assertEquals(createLight.getValueFromInputFieldLightName(), propertyFile.getLightName());
        softAssert.assertEquals(createLight.getValueFromSelectLightFunctionType(), propertyFile.getLightFunctionType());
        softAssert.assertEquals(createLight.getValueFromInputFieldLightArticleNumber(),
                propertyFile.getLightArticleNumber());
        softAssert.assertEquals(createLight.getValueFromInputFieldLightDescriptionText(),
                propertyFile.getLightDescriptionText());
        softAssert.assertEquals(createLight.getValueFromSelectLightType(), propertyFile.getLightType());
        softAssert.assertEquals(createLight.getValueFromInputFieldLightUnit(), propertyFile.getLightUnit());
        Thread.sleep(2000);
        createLight.clickOnDelete();
    }

    // /**
    // * Creates electric
    // *
    // * @throws InterruptedException
    // */
    // @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 13, description = "thirteen test")
    // public void createElectric() throws InterruptedException {
    // final CreateElectric createElectric = PageFactory.initElements(driver, CreateElectric.class);
    // createElectric.clickOnElectricIcon();
    // Thread.sleep(2000);
    // createElectric.clickOnCreateNewType();
    //
    // Thread.sleep(2000);
    // createElectric.clickOnCreatedElectric();
    // // Save default value
    // final String electricName = createElectric.getValueFormInputFieldName();
    // final String executionType = createElectric.getValueFromSelectExecutionType();
    // final String OrientationType = createElectric.getValueFromSelectOrientationType();
    // final String Manufacturer = createElectric.getValueFromSelectManufacturer();
    // final String FramRangeType = createElectric.getValueFromSelectFramRangeType();
    // final String FramModelType = createElectric.getValueFromSelectFramModelType();
    //
    // Thread.sleep(2000);
    // // Create electric and abort
    // createElectric.createElectricAndAbort();
    // Thread.sleep(2000);
    //
    // createElectric.clickOnCreatedElectric();
    // // Verify the value
    // softAssert.assertEquals(createElectric.getValueFormInputFieldName(), electricName);
    // softAssert.assertEquals(createElectric.getValueFromSelectExecutionType(), executionType);
    // softAssert.assertEquals(createElectric.getValueFromSelectOrientationType(), OrientationType);
    // softAssert.assertEquals(createElectric.getValueFromSelectManufacturer(), Manufacturer);
    // softAssert.assertEquals(createElectric.getValueFromSelectFramRangeType(), FramRangeType);
    // softAssert.assertEquals(createElectric.getValueFromSelectFramModelType(), FramModelType);
    // Thread.sleep(2000);
    //
    // createElectric.createElectricAndSave();
    // Thread.sleep(2000);
    //
    // createElectric.clickOnCreatedElectric();
    // Thread.sleep(2000);
    // // Verify the value
    // softAssert.assertEquals(createElectric.getValueFormInputFieldName(), propertyFile.getElectricName());
    // softAssert.assertEquals(createElectric.getValueFromSelectExecutionType(),
    // propertyFile.getElectricExecutionType());
    // softAssert.assertEquals(createElectric.getValueFromSelectOrientationType(),
    // propertyFile.getElectricOrientationType());
    // softAssert.assertEquals(createElectric.getValueFromSelectManufacturer(),
    // propertyFile.getElectricManufacturer());
    // softAssert.assertEquals(createElectric.getValueFromSelectFramRangeType(),
    // propertyFile.getElectricFrameRangeType());
    // softAssert.assertEquals(createElectric.getValueFromSelectFramModelType(),
    // propertyFile.getElectricFrameModelType());
    // // Click on icon one
    // Thread.sleep(2000);
    // createElectric.clickOnemptyIconOne();
    // // Save default values
    // final String application = createElectric.getValueFromSelectApplication();
    // final String execution = createElectric.getValueFromSelectSocketOneExecution();
    // final String model = createElectric.getValueFromSelectApplicationModel();
    // // final String switchable = createElectric.getValueFromSelectSwitchable();
    // // final String separateCircuite = createElectric.getValueFromSelectSeparateCircuit();
    // // final String connection = createElectric.getValueFromSelectConnection();
    // Thread.sleep(2000);
    // createElectric.createSocketOneAndAbort();
    // Thread.sleep(2000);
    // createElectric.clickOnemptyIconOne();
    //
    // // Verify the value
    // softAssert.assertEquals(createElectric.getValueFromSelectApplication(), application);
    // softAssert.assertEquals(createElectric.getValueFromSelectSocketOneExecution(), execution);
    // softAssert.assertEquals(createElectric.getValueFromSelectApplicationModel(), model);
    // // softAssert.assertEquals(createElectric.getValueFromSelectSwitchable(), switchable);
    // // softAssert.assertEquals(createElectric.getValueFromSelectSeparateCircuit(), separateCircuite);
    // // softAssert.assertEquals(createElectric.getValueFromSelectConnection(), connection);
    // Thread.sleep(2000);
    // createElectric.createSocketOneAndSave();
    // Thread.sleep(2000);
    // createElectric.clickOnemptyIconOne();
    //
    // softAssert.assertEquals(createElectric.getValueFromSelectApplication(), propertyFile.getSocketApplication());
    // softAssert.assertEquals(createElectric.getValueFromSelectSocketOneExecution(),
    // propertyFile.getSocketOneExecution());
    // softAssert.assertEquals(createElectric.getValueFromSelectApplicationModel(),
    // propertyFile.getSocketApplicationModel());
    // softAssert.assertEquals(createElectric.getValueFromSelectSwitchable(), propertyFile.getSocketSwitchable());
    // softAssert.assertEquals(createElectric.getValueFromSelectSeparateCircuit(),
    // propertyFile.getSocketSeparateCircuit());
    // softAssert.assertEquals(createElectric.getValueFromSelectConnection(), propertyFile.getSocketConnectionType());
    // Thread.sleep(2000);
    // createElectric.clickOnDelete();
    //
    // }

    /**
     * Creates Sensor
     *
     * @throws InterruptedException
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 13, description = "thirteen test")
    public void createElectricPlus() throws InterruptedException {
        final CreateElectricPlus electricPlus = PageFactory.initElements(driver, CreateElectricPlus.class);

        electricPlus.clickOnElectricPlusIcon();
        Thread.sleep(2000);
        electricPlus.clickOnCreateNewType();
        Thread.sleep(2000);
        electricPlus.clickOnCreatedType();
        Thread.sleep(2000);
        // Save default value
        final String electricPlusName = electricPlus.getValueFromInputFieldElectricPlusName();
        final String electricPlusCategory = electricPlus.getValueFromSelectElectricPlusCategory();
        final String electricPlusComponent = electricPlus.getValueFromSelectElectricPlusComponent();

        electricPlus.createElectricPlusAndAbort();
        Thread.sleep(2000);
        electricPlus.clickOnCreatedType();
        // Verify values
        Thread.sleep(2000);
        softAssert.assertEquals(electricPlus.getValueFromInputFieldElectricPlusName(), electricPlusName);
        softAssert.assertEquals(electricPlus.getValueFromSelectElectricPlusCategory(), electricPlusCategory);
        softAssert.assertEquals(electricPlus.getValueFromSelectElectricPlusComponent(), electricPlusComponent);

        electricPlus.createElectricPlusAndSave();
        Thread.sleep(2000);
        electricPlus.clickOnCreatedType();
        // Verify values
        softAssert.assertEquals(electricPlus.getValueFromInputFieldElectricPlusName(),
                propertyFile.getElectricPlusName());
        softAssert.assertEquals(electricPlus.getValueFromSelectElectricPlusCategory(),
                propertyFile.getElectricPlusCategroy());
        softAssert.assertEquals(electricPlus.getValueFromSelectElectricPlusComponent(),
                propertyFile.getElectricPlusComponent());
        Thread.sleep(2000);
        electricPlus.clickOnDelete();
    }

    /**
     * Creates Sensor
     *
     * @throws InterruptedException
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 14, description = "fourteen test")
    public void createSensor() throws InterruptedException {
        final CreateSensor sensor = PageFactory.initElements(driver, CreateSensor.class);
        sensor.clickOnSensorIcon();
        Thread.sleep(2000);
        sensor.clickOnCreateNewType();
        Thread.sleep(2000);
        sensor.clickOnCreatedType();
        Thread.sleep(2000);
        // Save default values
        final String sensorName = sensor.getValueFromInputFieldSensorName();
        final String sensorCategory = sensor.getValueFromSelectSensorCategory();
        final String sensorConnection = sensor.getValueFromSelectSensorConnection();
        final String sensorMounting = sensor.getValueFromSelectSensorMountingType();

        sensor.createSensorAndAbort();
        Thread.sleep(2000);

        sensor.clickOnCreatedType();
        Thread.sleep(2000);
        // Verify values
        softAssert.assertEquals(sensor.getValueFromInputFieldSensorName(), sensorName);
        softAssert.assertEquals(sensor.getValueFromSelectSensorCategory(), sensorCategory);
        softAssert.assertEquals(sensor.getValueFromSelectSensorConnection(), sensorConnection);
        softAssert.assertEquals(sensor.getValueFromSelectSensorMountingType(), sensorMounting);

        sensor.createSensorAndSave();
        Thread.sleep(2000);
        sensor.clickOnCreatedType();
        Thread.sleep(2000);
        // Verify Values
        softAssert.assertEquals(sensor.getValueFromInputFieldSensorName(), propertyFile.getSensorName());
        softAssert.assertEquals(sensor.getValueFromSelectSensorCategory(), propertyFile.getSensorCategory());
        softAssert.assertEquals(sensor.getValueFromSelectSensorConnection(), propertyFile.getSensorConnection());
        softAssert.assertEquals(sensor.getValueFromSelectSensorMountingType(), propertyFile.getSensorMounting());
        Thread.sleep(2000);
        sensor.clickOnDelete();
    }

    /**
     * Creates Sanitary
     *
     * @throws InterruptedException
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 15, description = "fiveteenth test")
    public void createSanitary() throws InterruptedException {
        final CreateSanitary createSanitary = PageFactory.initElements(driver, CreateSanitary.class);
        Thread.sleep(2000);
        createSanitary.clickOnSensorIcon();
        Thread.sleep(2000);
        createSanitary.clickOnCreateNewType();
        Thread.sleep(2000);
        createSanitary.clickOnCreatedType();
        Thread.sleep(2000);
        // Save default values
        final String name = createSanitary.getValueFromInputFieldName();
        final String variant = createSanitary.getValueFromSelectSanitaryVarinat();
        final String articleNr = createSanitary.getValueFromInputFieldArticleNr();
        final String description = createSanitary.getValueFromInputFieldDescription();
        final String type = createSanitary.getValueFromSelectSanitaryType();
        final String unit = createSanitary.getValueFromInputFieldUnit();

        createSanitary.createSanitaryAndAbor();
        Thread.sleep(2000);

        createSanitary.clickOnCreatedType();
        Thread.sleep(2000);
        // Verify values
        softAssert.assertEquals(createSanitary.getValueFromInputFieldName(), name);
        softAssert.assertEquals(createSanitary.getValueFromSelectSanitaryVarinat(), variant);
        softAssert.assertEquals(createSanitary.getValueFromInputFieldArticleNr(), articleNr);
        softAssert.assertEquals(createSanitary.getValueFromInputFieldDescription(), description);
        softAssert.assertEquals(createSanitary.getValueFromSelectSanitaryType(), type);
        softAssert.assertEquals(createSanitary.getValueFromInputFieldUnit(), unit);
        Thread.sleep(2000);
        createSanitary.createSanitaryAndSave();
        Thread.sleep(2000);
        createSanitary.clickOnCreatedType();
        Thread.sleep(2000);
        // Verify Values
        softAssert.assertEquals(createSanitary.getValueFromInputFieldName(), propertyFile.getSanitaryName());
        softAssert.assertEquals(createSanitary.getValueFromSelectSanitaryVarinat(), propertyFile.getSanitaryVariant());
        softAssert.assertEquals(createSanitary.getValueFromInputFieldArticleNr(), propertyFile.getSanitaryArticleNr());
        softAssert.assertEquals(createSanitary.getValueFromInputFieldDescription(),
                propertyFile.getSanitaryDescription());
        softAssert.assertEquals(createSanitary.getValueFromSelectSanitaryType(), propertyFile.getSanitaryType());
        softAssert.assertEquals(createSanitary.getValueFromInputFieldUnit(), propertyFile.getSanitaryUnit());

        createSanitary.clickOnDelete();
        Thread.sleep(2000);
    }

    /**
     * delete the created Project
     *
     * @throws InterruptedException
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 16, description = "sixteenth test")
    public void deletingNewProject() throws InterruptedException {

        final DeleteProject deleteProject = PageFactory.initElements(driver, DeleteProject.class);

        deleteProject.goToAccount();

        final int projectCountBeforeDeleting = deleteProject.getProjectCount();

        deleteProject.deleteCreatedProject();
        final int projectCountAfterDeleting = deleteProject.getProjectCount();
        // Verify values
        softAssert.assertTrue(projectCountBeforeDeleting - 1 == projectCountAfterDeleting);

        System.out.println(projectCountBeforeDeleting);
        System.out.println(projectCountAfterDeleting);

        // list of projects names
        final List<WebElement> list = deleteProject.getProjectsName();
        list.forEach(name -> {
            if (name.getText().toString().equals(projectName)) {
                softAssert.assertTrue(false);
            } else if (list.isEmpty()) {
                return;
            }
            softAssert.assertTrue(true);
        });
    }

    /**
     * Catches Errors
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 17, description = "seventeenth test")
    public void assertionError() {
        softAssert.assertAll();
    }

}
