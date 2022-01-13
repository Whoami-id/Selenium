
package configuratorTestSuite2;

import java.awt.AWTException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import reporter.PDFReporter;

@Listeners(PDFReporter.class)
public class TestBase extends Inizializ {
    final String date = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
    public static String projectName;

    /**
     * Goes to HomePage configurator
     *
     * @throws InterruptedException
     */
    @Test(priority = 1, description = "fist test")
    public void gotoHomapage() throws InterruptedException {
        final Homepage homepage = PageFactory.initElements(driver, Homepage.class);
        final SoftAssert softAssert = new SoftAssert();
        homepage.clickConfigurationButton();
        final String ulr = driver.getCurrentUrl();
        softAssert.assertEquals(ulr, propertyFile.getUrl());
        softAssert.assertAll();
    }

    /**
     * Logs in Configurator
     *
     * @throws InterruptedException
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
        final SoftAssert softAssert = new SoftAssert();
        projectPlaning.createAProject();
        projectPlaning.clickOnPlusSymbol();
        Thread.sleep(2000);
        projectPlaning.goBackToProjectPlaning();
        /** verify the values */
        softAssert.assertEquals(projectPlaning.getEnteredProjectName(), propertyFile.getProjectName() + date);
        softAssert.assertEquals(projectPlaning.getEnteredPostalCode(), propertyFile.getPostaCode());
        softAssert.assertEquals(projectPlaning.getEnteredCity(), propertyFile.getCity());
        softAssert.assertEquals(projectPlaning.getSelectedConstructionType(), propertyFile.getconstructionType());
        softAssert.assertEquals(projectPlaning.formateDate().toString(), propertyFile.getStartDate());
        projectPlaning.clickOnPlusSymbol();
        softAssert.assertAll();
    }

    /**
     * Create Wall
     *
     * @throws InterruptedException
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 5, description = "fifth test")
    public void creatingWall() throws InterruptedException {
        final CreateWall createWall = PageFactory.initElements(driver, CreateWall.class);
        final SoftAssert softAssert = new SoftAssert();
        createWall.clickOnCreateWallType();
        createWall.clickOnCreatedInsideWall();
        /** Saves default values */
        final String defaultName = createWall.getValueFromInputFieldInsideWallName();
        final String defaultMasonryType = createWall.getValueFromSelectMasonryInsideWallType();
        final String defaultInstallationsType = createWall.getValueFromSelectInstallationInsideWallType();
        final String defaultWallType = createWall.getValueFromSelectInsideWallType();
        final String defaultWallThickness = createWall.getValueFromSpinnerForWallThicknessInsideWall();
        final String defaultFireResistanceType = createWall.getValueFromSelecteFireResistanceInsideWallType();
        createWall.createInsideWallAndAbortIt();
        createWall.clickOnCreatedInsideWall();
        /** verify the values */
        softAssert.assertEquals(createWall.getValueFromInputFieldInsideWallName(), defaultName);
        softAssert.assertEquals(createWall.getValueFromSelectMasonryInsideWallType(), defaultMasonryType);
        softAssert.assertEquals(createWall.getValueFromSelectInstallationInsideWallType(), defaultInstallationsType);
        softAssert.assertEquals(createWall.getValueFromSelectInsideWallType(), defaultWallType);
        softAssert.assertEquals(createWall.getValueFromSpinnerForWallThicknessInsideWall(), defaultWallThickness);
        softAssert.assertEquals(createWall.getValueFromSelecteFireResistanceInsideWallType(),
                defaultFireResistanceType);
        createWall.createInsideWallAndSaveIt();
        createWall.clickOnCreatedInsideWall();
        /** Verify the values */
        softAssert.assertEquals(createWall.getValueFromInputFieldInsideWallName(), propertyFile.getWallName20());
        softAssert.assertEquals(createWall.getValueFromSelectMasonryInsideWallType(), propertyFile.getMasonryType());
        softAssert.assertEquals(createWall.getValueFromSelectInstallationInsideWallType(),
                propertyFile.getInstallationType());
        softAssert.assertEquals(createWall.getValueFromSelectInsideWallType(), propertyFile.getWallTypeInside());
        softAssert.assertEquals(createWall.getValueFromSpinnerForWallThicknessInsideWall(),
                propertyFile.getWallThickness());
        softAssert.assertEquals(createWall.getValueFromSelecteFireResistanceInsideWallType(),
                propertyFile.getFireResistanceType());
        /* checks max value from spinner */
        createWall.checkMaxValueForSpinner();
        softAssert.assertEquals(createWall.getValueFromSpinnerForWallThicknessInsideWall(),
                propertyFile.getSpinnerMaxValue());
        /** Checks min value from spinner */
        createWall.checkMinValueForSpinner();
        softAssert.assertEquals(createWall.getValueFromSpinnerForWallThicknessInsideWall(),
                propertyFile.getSpinnerMinValue());
        /** creates outerWall and abort changes */
        createWall.clickOnCreateWallType();
        Thread.sleep(2000);
        createWall.clickOnCreatedOuterWall();
        final String defaultWallUvalue = createWall.getValueFromSpinnerForWallUValueOutsideWall();
        createWall.createOuterWallAndAbortIt();
        createWall.clickOnCreatedOuterWall();
        /** verify the values */
        softAssert.assertEquals(createWall.getValueFromInputFieldOuterWallName(), defaultName);
        softAssert.assertEquals(createWall.getValueFromSelectMasonryOuterWallType(), defaultMasonryType);
        softAssert.assertEquals(createWall.getValueFromSelectInstallationOuterWallType(), defaultInstallationsType);
        softAssert.assertEquals(createWall.getValueFromSelectOuterWallType(), defaultWallType);
        softAssert.assertEquals(createWall.getValueFromSpinnerForWallThicknessOutsideWall(), defaultWallThickness);
        softAssert.assertEquals(createWall.getValueFromSpinnerForWallUValueOutsideWall(), defaultWallUvalue);
        softAssert.assertEquals(createWall.getValueFromSelecteFireResistanceOuterWallType(), defaultFireResistanceType);
        createWall.createOuterWallAndSaveIt();
        createWall.clickOnCreatedOuterWall();
        softAssert.assertEquals(createWall.getValueFromInputFieldOuterWallName(), propertyFile.getWallName21());
        softAssert.assertEquals(createWall.getValueFromSelectMasonryOuterWallType(), propertyFile.getMasonryType());
        softAssert.assertEquals(createWall.getValueFromSelectInstallationOuterWallType(),
                propertyFile.getInstallationType());
        softAssert.assertEquals(createWall.getValueFromSelectOuterWallType(), propertyFile.getWallTypeOuter());
        softAssert.assertEquals(createWall.getValueFromSpinnerForWallThicknessOutsideWall(),
                propertyFile.getWallThickness());
        softAssert.assertEquals(createWall.getValueFromSpinnerForWallUValueOutsideWall(), propertyFile.getWallUValue());
        softAssert.assertEquals(createWall.getValueFromSelecteFireResistanceOuterWallType(),
                propertyFile.getFireResistanceType());
        softAssert.assertAll();
    }

    /**
     * Creates Window
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 6, description = "sixth test")
    public void creatingWindow() {
        final CreateWindow createWindow = PageFactory.initElements(driver, CreateWindow.class);
        final SoftAssert softAssert = new SoftAssert();
        createWindow.clickOnWindowIcon();
        createWindow.clickOnCreateWindowType();
        createWindow.clickOnCreatedWindow();
        /** Saves default values */
        final String defaultName = createWindow.getValueFromInputFieldWindowName();
        final String defaultWindowOpeningType = createWindow.getValueFeomSelecteWindowOpeningType();
        final String defaultGlazingType = createWindow.getValueFromSelecteGlazingType();
        final String defaultWindowContact = createWindow.getValueFromSelecteWindowContactNo();
        final String defaultWindowControlType = createWindow.getValueFromSelecteWindowControlType();
        final String defalutWindowWidth = createWindow.getValueFromSpinnerWidth();
        final String defaultWindowHeight = createWindow.getValueFromSpinnerHeight();
        final String defaultWindowUValue = createWindow.getValueFromSpinnerUValue();
        createWindow.createWindowAndAbort();
        createWindow.clickOnCreatedWindow();
        softAssert.assertEquals(createWindow.getValueFromInputFieldWindowName(), defaultName);
        softAssert.assertEquals(createWindow.getValueFeomSelecteWindowOpeningType(), defaultWindowOpeningType);
        softAssert.assertEquals(createWindow.getValueFromSpinnerWidth(), defalutWindowWidth);
        softAssert.assertEquals(createWindow.getValueFromSpinnerHeight(), defaultWindowHeight);
        softAssert.assertEquals(createWindow.getValueFromSelecteGlazingType(), defaultGlazingType);
        softAssert.assertEquals(createWindow.getValueFromSelecteWindowContactNo(), defaultWindowContact);
        softAssert.assertEquals(createWindow.getValueFromSelecteWindowControlType(), defaultWindowControlType);
        softAssert.assertEquals(createWindow.getValueFromSpinnerUValue(), defaultWindowUValue);
        createWindow.createWindowAndSave();
        createWindow.clickOnCreatedWindow();
        /** Verify the Values */
        softAssert.assertEquals(createWindow.getValueFromInputFieldWindowName(), propertyFile.getWindowName());
        softAssert.assertEquals(createWindow.getValueFeomSelecteWindowOpeningType(), propertyFile.getWindowType());
        softAssert.assertEquals(createWindow.getValueFromSpinnerWidth(), propertyFile.getWindowWidth());
        softAssert.assertEquals(createWindow.getValueFromSpinnerHeight(), propertyFile.getWindowHeight());
        softAssert.assertEquals(createWindow.getValueFromSelecteGlazingType(), propertyFile.getWindowGlazinType());
        softAssert.assertEquals(createWindow.getValueFromSelecteWindowContactNo(), propertyFile.getWindowContactNo());
        softAssert.assertEquals(createWindow.getValueFromSelecteWindowControlType(),
                propertyFile.getWindowControlType());
        softAssert.assertEquals(createWindow.getValueFromSpinnerUValue(), propertyFile.getWindowUValue());
        softAssert.assertAll();
    }

    /**
     * Creates Blind
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 7, description = "seventh test")
    public void createBlind() {
        final CreateBlinds createBlind = PageFactory.initElements(driver, CreateBlinds.class);
        final SoftAssert softAssert = new SoftAssert();
        createBlind.clickOnBlindIcon();
        createBlind.clickOnCreateNewType();
        createBlind.clickOnCreatedBlind();
        /** Saves default values */
        final String defaultName = createBlind.getValueFromInputFieldBlindsName();
        final String defalutShadinType = createBlind.getValeuFromSelectShadingType();
        final String defaultColor = createBlind.getValueFromSelectColor();
        createBlind.createBlindAndAbortChanges();
        createBlind.clickOnCreatedBlind();
        softAssert.assertEquals(createBlind.getValueFromInputFieldBlindsName(), defaultName);
        softAssert.assertEquals(createBlind.getValeuFromSelectShadingType(), defalutShadinType);
        softAssert.assertEquals(createBlind.getValueFromSelectColor(), defaultColor);
        createBlind.createBlindAndSaveChanges();
        createBlind.clickOnCreatedBlind();
        /** Verify the Values */
        softAssert.assertEquals(createBlind.getValueFromInputFieldBlindsName(), propertyFile.getBlindName());
        softAssert.assertEquals(createBlind.getValeuFromSelectShadingType(), propertyFile.getShadingType());
        softAssert.assertEquals(createBlind.getValueFromSelectColor(), propertyFile.getShadingColor());
        softAssert.assertAll();
    }

    /**
     * Creates Door
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 8, description = "eighth test")
    public void createDoor() {
        final CreateDoor createDoor = PageFactory.initElements(driver, CreateDoor.class);
        final SoftAssert softAssert = new SoftAssert();
        createDoor.clickOnDoorIcon();
        createDoor.clickOnCreateDoorType();
        createDoor.clickOnCreatedDoor();
        /** Saves default values */
        final String defaultDoorName = createDoor.getValueFromInputFieldDoorName();
        final String defaultDoorWidth = createDoor.getValueFromSpinnerWidth();
        final String defaultDoorHeight = createDoor.getValueFromSpinnerHeight();
        final String defaultDoorMaterialType = createDoor.getValueFromSelectDoorMaterialType();
        final String defaultDoorSecurityType = createDoor.getValueFromSelecteDoorSecurityType();
        final String defaultDoorOpeningType = createDoor.getValueFromSelectDoorOpeningType();
        final String defaultDoorCategory = createDoor.getValueFormSelectDoorCatergory();
        final String defaultDoorControlType = createDoor.getValueFromSelectDoorControlType();
        final String defaultDoorLockType = createDoor.getValueFromSelectDoorLookType();
        final String defaultDoorOpeningSideType = createDoor.getValueFromSelectDoorOpeningSideType();
        createDoor.createDoorAndAbort();
        createDoor.clickOnCreatedDoor();
        /** Verify the Values */
        softAssert.assertEquals(createDoor.getValueFromInputFieldDoorName(), defaultDoorName);
        softAssert.assertEquals(createDoor.getValueFromSpinnerWidth(), defaultDoorWidth);
        softAssert.assertEquals(createDoor.getValueFromSpinnerHeight(), defaultDoorHeight);
        softAssert.assertEquals(createDoor.getValueFromSelectDoorMaterialType(), defaultDoorMaterialType);
        softAssert.assertEquals(createDoor.getValueFromSelecteDoorSecurityType(), defaultDoorSecurityType);
        softAssert.assertEquals(createDoor.getValueFromSelectDoorOpeningType(), defaultDoorOpeningType);
        softAssert.assertEquals(createDoor.getValueFormSelectDoorCatergory(), defaultDoorCategory);
        softAssert.assertEquals(createDoor.getValueFromSelectDoorControlType(), defaultDoorControlType);
        softAssert.assertEquals(createDoor.getValueFromSelectDoorLookType(), defaultDoorLockType);
        softAssert.assertEquals(createDoor.getValueFromSelectDoorOpeningSideType(), defaultDoorOpeningSideType);
        createDoor.createDoorAndSave();
        createDoor.clickOnCreatedDoor();
        /** Verify the Values */
        softAssert.assertEquals(createDoor.getValueFromInputFieldDoorName(), propertyFile.getDoorName());
        softAssert.assertEquals(createDoor.getValueFromSpinnerWidth(), propertyFile.getDoorWidth());
        softAssert.assertEquals(createDoor.getValueFromSpinnerHeight(), propertyFile.getDoorHeight());
        softAssert.assertEquals(createDoor.getValueFromSelectDoorMaterialType(), propertyFile.getDoorMaterial());
        softAssert.assertEquals(createDoor.getValueFromSelecteDoorSecurityType(), propertyFile.getDoorSecurity());
        softAssert.assertEquals(createDoor.getValueFromSelectDoorOpeningType(), propertyFile.getDoorType());
        softAssert.assertEquals(createDoor.getValueFormSelectDoorCatergory(), propertyFile.getDoorCategory());
        softAssert.assertEquals(createDoor.getValueFromSelectDoorControlType(), propertyFile.getDoorControlType());
        softAssert.assertEquals(createDoor.getValueFromSelectDoorLookType(), propertyFile.getDoorLockType());
        softAssert.assertEquals(createDoor.getValueFromSelectDoorOpeningSideType(),
                propertyFile.getDoorOpeningSideType());
        softAssert.assertAll();
    }

    /**
     * Creates AccessControl
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 9, description = "ninth test")
    public void createAccessControl() {
        final CreateAccessControl createAccessControl = PageFactory.initElements(driver, CreateAccessControl.class);
        final SoftAssert softAssert = new SoftAssert();
        createAccessControl.clickOnAccessControlIcon();
        createAccessControl.clickOnCreateNewType();
        createAccessControl.clickOnCreatedAccessControl();
        /** Saves default values */
        final String defaultName = createAccessControl.getValueFromInputFieldName();
        final String defaultCategory = createAccessControl.getValueFromSelectAccessControlCategory();
        final String defaultUseArt = createAccessControl.getValueFromSelectAccessControlUseArt();
        softAssert.assertEquals(createAccessControl.getValueFromInputFieldName(), defaultName);
        softAssert.assertEquals(createAccessControl.getValueFromSelectAccessControlCategory(), defaultCategory);
        softAssert.assertEquals(createAccessControl.getValueFromSelectAccessControlUseArt(), defaultUseArt);
        createAccessControl.createAccessControlAndAbort();
        createAccessControl.clickOnCreatedAccessControl();
        createAccessControl.createAccessControlAndSave();
        /** Verify the Values */
        createAccessControl.clickOnCreatedAccessControl();
        softAssert.assertEquals(createAccessControl.getValueFromInputFieldName(), propertyFile.getAccessControlName());
        softAssert.assertEquals(createAccessControl.getValueFromSelectAccessControlCategory(),
                propertyFile.getAccessControlCategory());
        softAssert.assertEquals(createAccessControl.getValueFromSelectAccessControlUseArt(),
                propertyFile.getAccessControlUseArt());
        softAssert.assertAll();
    }

    /**
     * Creates Heater
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 10, description = "tenth test")
    public void createHeater() {
        final CreateHeater createHeater = PageFactory.initElements(driver, CreateHeater.class);
        final SoftAssert softAssert = new SoftAssert();
        createHeater.clickOnHeaterIcon();
        createHeater.clickOnCreateNewType();
        createHeater.clickOnCreatedType();
        /** Saves default values */
        final String defaultHeaterName = createHeater.getValueFromInpuFieldHeaterName();
        final String defaultHeaterType = createHeater.getValueFromSelectHeaterType();
        final String defaultHeaterStyle = createHeater.getValueFromSelectHeaterStyle();
        final String defaultHeaterActuator = createHeater.getValueFromSelecHeaterActuatorType();
        final String defaultHeaterWidth = createHeater.getValueFromSpinnerWidth();
        final String defaultHeaterDepth = createHeater.getValueFromSpinnerDepth();
        final String defaultHeaterHeight = createHeater.getValueFromSpinnerHeight();
        final String defaultHeaterUnitPrice = createHeater.getValueFromSpinnerUnitPrice();
        final String defaultHeaterInstallationsPrice = createHeater.getValueFromSpinnerInstallationsPrice();
        createHeater.createHeaterAndAbort();
        createHeater.clickOnCreatedType();
        /** Verify the Values */
        softAssert.assertEquals(createHeater.getValueFromInpuFieldHeaterName(), defaultHeaterName);
        softAssert.assertEquals(createHeater.getValueFromSelectHeaterStyle(), defaultHeaterStyle);
        softAssert.assertEquals(createHeater.getValueFromSelectHeaterType(), defaultHeaterType);
        softAssert.assertEquals(createHeater.getValueFromSpinnerWidth(), defaultHeaterWidth);
        softAssert.assertEquals(createHeater.getValueFromSpinnerDepth(), defaultHeaterDepth);
        softAssert.assertEquals(createHeater.getValueFromSpinnerHeight(), defaultHeaterHeight);
        softAssert.assertEquals(createHeater.getValueFromSelecHeaterActuatorType(), defaultHeaterActuator);
        softAssert.assertEquals(createHeater.getValueFromSpinnerUnitPrice(), defaultHeaterUnitPrice);
        softAssert.assertEquals(createHeater.getValueFromSpinnerInstallationsPrice(), defaultHeaterInstallationsPrice);
        createHeater.createHeaterAndSave();
        createHeater.clickOnCreatedType();
        /** Verify the Values */
        softAssert.assertEquals(createHeater.getValueFromInpuFieldHeaterName(), propertyFile.getHeaterName());
        softAssert.assertEquals(createHeater.getValueFromSelectHeaterStyle(), propertyFile.getHeaterStyle());
        softAssert.assertEquals(createHeater.getValueFromSelectHeaterType(), propertyFile.getHeaterType());
        softAssert.assertEquals(createHeater.getValueFromSpinnerWidth(), propertyFile.getHeaterWidth());
        softAssert.assertEquals(createHeater.getValueFromSpinnerDepth(), propertyFile.getHeaterDepth());
        softAssert.assertEquals(createHeater.getValueFromSpinnerHeight(), propertyFile.getHeaterHeight());
        softAssert.assertEquals(createHeater.getValueFromSelecHeaterActuatorType(),
                propertyFile.getHeaterActuatorType());
        softAssert.assertEquals(createHeater.getValueFromSpinnerUnitPrice(), propertyFile.getHeaterUnitPrice());
        softAssert.assertEquals(createHeater.getValueFromSpinnerInstallationsPrice(),
                propertyFile.getHeaterInstallationsPrice());
        softAssert.assertAll();
    }

    /**
     * Creates Ventilation
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 11, description = "eleventh test")
    public void createVentilation() {
        final CreateVentilation createVentilation = PageFactory.initElements(driver, CreateVentilation.class);
        final SoftAssert softAssert = new SoftAssert();
        createVentilation.clickOnVentilationIcon();
        createVentilation.clickOnCreateNewType();
        createVentilation.clickOnCreatedVentilation();
        /** Saves default values */
        final String name = createVentilation.getValueFromInputFieldVentilationName();
        final String usageType = createVentilation.getValueFromSelectVentilationUsageType();
        final String systemType = createVentilation.getValueFromSelectVentilationSystem();
        final String manufacturer = createVentilation.getValueFromSelectVentilationManufacturer();
        final String model = createVentilation.getValueFromSelectVentilationModel();
        createVentilation.createVentilationAndAboirtChanges();
        createVentilation.clickOnCreatedVentilation();
        /** Verify the Values */
        softAssert.assertEquals(createVentilation.getValueFromInputFieldVentilationName(), name);
        softAssert.assertEquals(createVentilation.getValueFromSelectVentilationUsageType(), usageType);
        softAssert.assertEquals(createVentilation.getValueFromSelectVentilationSystem(), systemType);
        softAssert.assertEquals(createVentilation.getValueFromSelectVentilationManufacturer(), manufacturer);
        softAssert.assertEquals(createVentilation.getValueFromSelectVentilationModel(), model);
        createVentilation.createVentilationAndSaveChanges();
        createVentilation.clickOnCreatedVentilation();
        /** Verify the Values */
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
        softAssert.assertAll();
    }

    /**
     * Creates Light
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 12, description = "twelfth test")
    public void createLight() {
        final CreateLight createLight = PageFactory.initElements(driver, CreateLight.class);
        final SoftAssert softAssert = new SoftAssert();
        createLight.clickOnLightIcon();
        createLight.clickOnCreateNewType();
        createLight.clickOnCreatedLight();
        /** Saves default values */
        final String name = createLight.getValueFromInputFieldLightName();
        final String functionType = createLight.getValueFromSelectLightFunctionType();
        final String articleNr = createLight.getValueFromInputFieldLightArticleNumber();
        final String description = createLight.getValueFromInputFieldLightDescriptionText();
        final String type = createLight.getValueFromSelectLightType();
        final String unit = createLight.getValueFromInputFieldLightUnit();
        final String length = createLight.getValueFromSpinnerLength();
        final String wide = createLight.getValueFromSpinnerWidth();
        final String unitPrice = createLight.getValueFromSpinnerUnitPrice();
        final String installationsPrice = createLight.getValueFromSpinnerInstallationsPrice();
        createLight.createLightAndAbort();
        createLight.clickOnCreatedLight();
        /** Verify the Values */
        softAssert.assertEquals(createLight.getValueFromInputFieldLightName(), name);
        softAssert.assertEquals(createLight.getValueFromSelectLightFunctionType(), functionType);
        softAssert.assertEquals(createLight.getValueFromInputFieldLightArticleNumber(), articleNr);
        softAssert.assertEquals(createLight.getValueFromSpinnerLength(), length);
        softAssert.assertEquals(createLight.getValueFromSpinnerWidth(), wide);
        softAssert.assertEquals(createLight.getValueFromInputFieldLightDescriptionText(), description);
        softAssert.assertEquals(createLight.getValueFromSelectLightType(), type);
        softAssert.assertEquals(createLight.getValueFromInputFieldLightUnit(), unit);
        softAssert.assertEquals(createLight.getValueFromSpinnerUnitPrice(), unitPrice);
        softAssert.assertEquals(createLight.getValueFromSpinnerInstallationsPrice(), installationsPrice);
        createLight.createLightAndSave();
        createLight.clickOnCreatedLight();
        /** Saves default values */
        softAssert.assertEquals(createLight.getValueFromInputFieldLightName(), propertyFile.getLightName());
        softAssert.assertEquals(createLight.getValueFromSelectLightFunctionType(), propertyFile.getLightFunctionType());
        softAssert.assertEquals(createLight.getValueFromInputFieldLightArticleNumber(),
                propertyFile.getLightArticleNumber());
        softAssert.assertEquals(createLight.getValueFromSpinnerLength(), propertyFile.getLightLength());
        softAssert.assertEquals(createLight.getValueFromSpinnerWidth(), propertyFile.getLightWide());
        softAssert.assertEquals(createLight.getValueFromInputFieldLightDescriptionText(),
                propertyFile.getLightDescriptionText());
        softAssert.assertEquals(createLight.getValueFromSelectLightType(), propertyFile.getLightType());
        softAssert.assertEquals(createLight.getValueFromInputFieldLightUnit(), propertyFile.getLightUnit());
        softAssert.assertEquals(createLight.getValueFromSpinnerUnitPrice(), propertyFile.getLightUnitPrice());
        softAssert.assertEquals(createLight.getValueFromSpinnerInstallationsPrice(),
                propertyFile.getLightInstallationsPrice());
        softAssert.assertAll();
    }

    /**
     * Creates electric
     *
     * @throws InterruptedException
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 13, description = "thirteen test")
    public void createElectric() throws InterruptedException {
        final CreateElectric createElectric = PageFactory.initElements(driver, CreateElectric.class);
        final SoftAssert softAssert = new SoftAssert();
        createElectric.waitUntilPageIsLoaded();
        createElectric.clickOnElectricIcon();
        createElectric.clickOnCreateNewType();
        createElectric.clickOnCreatedElectric();
        /** Save default value */
        final String electricName = createElectric.getValueFormInputFieldName();
        final String executionType = createElectric.getValueFromSelectExecutionType();
        final String OrientationType = createElectric.getValueFromSelectOrientationType();
        final String Manufacturer = createElectric.getValueFromSelectManufacturer();
        final String FramRangeType = createElectric.getValueFromSelectFramRangeType();
        final String FramModelType = createElectric.getValueFromSelectFramModelType();
        createElectric.createElectricAndAbort();
        createElectric.clickOnCreatedElectric();
        /** Verify the value */
        softAssert.assertEquals(createElectric.getValueFormInputFieldName(), electricName);
        softAssert.assertEquals(createElectric.getValueFromSelectExecutionType(), executionType);
        softAssert.assertEquals(createElectric.getValueFromSelectOrientationType(), OrientationType);
        softAssert.assertEquals(createElectric.getValueFromSelectManufacturer(), Manufacturer);
        softAssert.assertEquals(createElectric.getValueFromSelectFramRangeType(), FramRangeType);
        softAssert.assertEquals(createElectric.getValueFromSelectFramModelType(), FramModelType);
        createElectric.createElectricAndSave();
        createElectric.clickOnCreatedElectric();
        /** Verify the value */
        softAssert.assertEquals(createElectric.getValueFormInputFieldName(), propertyFile.getElectricName());
        softAssert.assertEquals(createElectric.getValueFromSelectExecutionType(),
                propertyFile.getElectricExecutionType());
        softAssert.assertEquals(createElectric.getValueFromSelectOrientationType(),
                propertyFile.getElectricOrientationType());
        softAssert.assertEquals(createElectric.getValueFromSelectManufacturer(),
                propertyFile.getElectricManufacturer());
        softAssert.assertEquals(createElectric.getValueFromSelectFramRangeType(),
                propertyFile.getElectricFrameRangeType());
        softAssert.assertEquals(createElectric.getValueFromSelectFramModelType(),
                propertyFile.getElectricFrameModelType());
        // Thread.sleep(2000);
        createElectric.clickOnemptyIconOne();
        /** Save default values */
        final String application = createElectric.getValueFromSelectApplication();
        final String execution = createElectric.getValueFromSelectSocketOneExecution();
        final String model = createElectric.getValueFromSelectApplicationModel();
        createElectric.createSocketOneAndAbort();
        createElectric.clickOnemptyIconOne();
        /** Verify the values */
        softAssert.assertEquals(createElectric.getValueFromSelectApplication(), application);
        softAssert.assertEquals(createElectric.getValueFromSelectSocketOneExecution(), execution);
        softAssert.assertEquals(createElectric.getValueFromSelectApplicationModel(), model);
        createElectric.createSocketOneAndSave();
        createElectric.clickOnemptyIconOne();
        softAssert.assertEquals(createElectric.getValueFromSelectApplication(), propertyFile.getSocketApplication());
        softAssert.assertEquals(createElectric.getValueFromSelectSocketOneExecution(),
                propertyFile.getSocketOneExecution());
        softAssert.assertEquals(createElectric.getValueFromSelectApplicationModel(),
                propertyFile.getSocketApplicationModel());
        softAssert.assertEquals(createElectric.getValueFromSelectSwitchable(), propertyFile.getSocketSwitchable());
        softAssert.assertEquals(createElectric.getValueFromSelectSeparateCircuit(),
                propertyFile.getSocketSeparateCircuit());
        softAssert.assertEquals(createElectric.getValueFromSelectConnection(), propertyFile.getSocketConnectionType());
        createElectric.clickOnemptyIconTwo();
        Thread.sleep(2000);
        createElectric.createSocketTwoAndAbort();
        createElectric.clickOnemptyIconTwo();
        softAssert.assertEquals(createElectric.getValueFromSelectApplication(), application);
        softAssert.assertEquals(createElectric.getValueFromSelectSocketTwoExecution(), execution);
        softAssert.assertEquals(createElectric.getValueFromSelectApplicationModel(), model);
        createElectric.createSocketTwoAndSave();
        createElectric.clickOnemptyIconTwo();
        softAssert.assertEquals(createElectric.getValueFromSelectApplication(), propertyFile.getSocketApplication());
        softAssert.assertEquals(createElectric.getValueFromSelectSocketTwoExecution(),
                propertyFile.getSocketTwoExecution());
        softAssert.assertEquals(createElectric.getValueFromSelectApplicationModel(),
                propertyFile.getSocketApplicationModel());
        softAssert.assertEquals(createElectric.getValueFromSelectSwitchable(), propertyFile.getSocketSwitchable());
        softAssert.assertEquals(createElectric.getValueFromSelectSeparateCircuit(),
                propertyFile.getSocketSeparateCircuit());
        softAssert.assertEquals(createElectric.getValueFromSelectConnection(), propertyFile.getSocketConnectionType());
        createElectric.clickOnemptyIconThree();
        /** Verify the value */
        Thread.sleep(2000);
        createElectric.createSocketTwoAndAbort();
        createElectric.clickOnemptyIconThree();
        softAssert.assertEquals(createElectric.getValueFromSelectApplication(), application);
        softAssert.assertEquals(createElectric.getValueFromSelectSocketTwoExecution(), execution);
        softAssert.assertEquals(createElectric.getValueFromSelectApplicationModel(), model);
        createElectric.createSocketTwoAndSave();
        createElectric.clickOnemptyIconThree();
        softAssert.assertEquals(createElectric.getValueFromSelectApplication(), propertyFile.getSocketApplication());
        softAssert.assertEquals(createElectric.getValueFromSelectSocketTwoExecution(),
                propertyFile.getSocketTwoExecution());
        softAssert.assertEquals(createElectric.getValueFromSelectApplicationModel(),
                propertyFile.getSocketApplicationModel());
        softAssert.assertEquals(createElectric.getValueFromSelectSwitchable(), propertyFile.getSocketSwitchable());
        softAssert.assertEquals(createElectric.getValueFromSelectSeparateCircuit(),
                propertyFile.getSocketSeparateCircuit());
        softAssert.assertEquals(createElectric.getValueFromSelectConnection(), propertyFile.getSocketConnectionType());
        softAssert.assertAll();
    }

    /**
     * Creates Sensor
     *
     * @throws InterruptedException
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 14, description = "fourteen test")
    public void createElectricPlus() {
        final CreateElectricPlus createElectricPlus = PageFactory.initElements(driver, CreateElectricPlus.class);
        final SoftAssert softAssert = new SoftAssert();
        createElectricPlus.clickOnElectricPlusIcon();
        createElectricPlus.clickOnCreateNewType();
        createElectricPlus.clickOnCreatedType();
        /** Save default value */
        final String electricPlusName = createElectricPlus.getValueFromInputFieldElectricPlusName();
        final String electricPlusCategory = createElectricPlus.getValueFromSelectElectricPlusCategory();
        final String electricPlusComponent = createElectricPlus.getValueFromSelectElectricPlusComponent();
        softAssert.assertEquals(createElectricPlus.getValueFromInputFieldElectricPlusName(), electricPlusName);
        softAssert.assertEquals(createElectricPlus.getValueFromSelectElectricPlusCategory(), electricPlusCategory);
        softAssert.assertEquals(createElectricPlus.getValueFromSelectElectricPlusComponent(), electricPlusComponent);
        createElectricPlus.createElectricPlusAndAbort();
        createElectricPlus.clickOnCreatedType();
        createElectricPlus.createElectricPlusAndSave();
        createElectricPlus.clickOnCreatedType();
        /** Verify values */
        softAssert.assertEquals(createElectricPlus.getValueFromInputFieldElectricPlusName(),
                propertyFile.getElectricPlusName());
        softAssert.assertEquals(createElectricPlus.getValueFromSelectElectricPlusCategory(),
                propertyFile.getElectricPlusCategroy());
        softAssert.assertEquals(createElectricPlus.getValueFromSelectElectricPlusComponent(),
                propertyFile.getElectricPlusComponent());
        softAssert.assertAll();
    }

    /**
     * Creates Sensor
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 15, description = "fiveteenth test")
    public void createSensor() {
        final CreateSensor createSensor = PageFactory.initElements(driver, CreateSensor.class);
        final SoftAssert softAssert = new SoftAssert();
        createSensor.clickOnSensorIcon();
        createSensor.clickOnCreateNewType();
        createSensor.clickOnCreatedType();
        /** Save default values */
        final String sensorName = createSensor.getValueFromInputFieldSensorName();
        final String sensorCategory = createSensor.getValueFromSelectSensorCategory();
        final String sensorConnection = createSensor.getValueFromSelectSensorConnection();
        final String sensorMounting = createSensor.getValueFromSelectSensorMountingType();
        createSensor.createSensorAndAbort();
        createSensor.clickOnCreatedType();
        /** Verify values */
        softAssert.assertEquals(createSensor.getValueFromInputFieldSensorName(), sensorName);
        softAssert.assertEquals(createSensor.getValueFromSelectSensorCategory(), sensorCategory);
        softAssert.assertEquals(createSensor.getValueFromSelectSensorConnection(), sensorConnection);
        softAssert.assertEquals(createSensor.getValueFromSelectSensorMountingType(), sensorMounting);
        createSensor.createSensorAndSave();
        createSensor.clickOnCreatedType();
        /** Verify Values */
        softAssert.assertEquals(createSensor.getValueFromInputFieldSensorName(), propertyFile.getSensorName());
        softAssert.assertEquals(createSensor.getValueFromSelectSensorCategory(), propertyFile.getSensorCategory());
        softAssert.assertEquals(createSensor.getValueFromSelectSensorConnection(), propertyFile.getSensorConnection());
        softAssert.assertEquals(createSensor.getValueFromSelectSensorMountingType(), propertyFile.getSensorMounting());
        softAssert.assertAll();
    }

    /**
     * Creates Sanitary
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 16, description = "sixteenth test")
    public void createSanitary() {
        final CreateSanitary createSanitary = PageFactory.initElements(driver, CreateSanitary.class);
        final SoftAssert softAssert = new SoftAssert();
        createSanitary.clickOnSensorIcon();
        createSanitary.clickOnCreateNewType();
        createSanitary.clickOnCreatedType();
        /** Save default values */
        final String name = createSanitary.getValueFromInputFieldName();
        final String variant = createSanitary.getValueFromSelectSanitaryVarinat();
        final String articleNr = createSanitary.getValueFromInputFieldArticleNr();
        final String description = createSanitary.getValueFromInputFieldDescription();
        final String type = createSanitary.getValueFromSelectSanitaryType();
        final String unit = createSanitary.getValueFromInputFieldUnit();
        final String unitPirce = createSanitary.getValueFromSpinnerSanitaryUnitPrice();
        final String installationsPrice = createSanitary.getValueFromSpinnerSanitaryInstallationsPrice();
        createSanitary.createSanitaryAndAbor();
        createSanitary.clickOnCreatedType();
        /** Verify values */
        softAssert.assertEquals(createSanitary.getValueFromInputFieldName(), name);
        softAssert.assertEquals(createSanitary.getValueFromSelectSanitaryType(), type);
        softAssert.assertEquals(createSanitary.getValueFromSelectSanitaryVarinat(), variant);
        softAssert.assertEquals(createSanitary.getValueFromInputFieldArticleNr(), articleNr);
        softAssert.assertEquals(createSanitary.getValueFromInputFieldDescription(), description);
        softAssert.assertEquals(createSanitary.getValueFromInputFieldUnit(), unit);
        softAssert.assertEquals(createSanitary.getValueFromSpinnerSanitaryUnitPrice(), unitPirce);
        softAssert.assertEquals(createSanitary.getValueFromSpinnerSanitaryInstallationsPrice(), installationsPrice);
        createSanitary.createSanitaryAndSave();
        createSanitary.clickOnCreatedType();
        /** Verify Values */

        softAssert.assertEquals(createSanitary.getValueFromInputFieldName(), propertyFile.getSanitaryName());
        softAssert.assertEquals(createSanitary.getValueFromSelectSanitaryVarinat(), propertyFile.getSanitaryVariant());
        softAssert.assertEquals(createSanitary.getValueFromSelectSanitaryType(), propertyFile.getSanitaryType());
        softAssert.assertEquals(createSanitary.getValueFromInputFieldArticleNr(), propertyFile.getSanitaryArticleNr());
        softAssert.assertEquals(createSanitary.getValueFromInputFieldDescription(),
                propertyFile.getSanitaryDescription());
        softAssert.assertEquals(createSanitary.getValueFromInputFieldUnit(), propertyFile.getSanitaryUnit());
        softAssert.assertEquals(createSanitary.getValueFromSpinnerSanitaryUnitPrice(),
                propertyFile.getSanitaryUnitPrice());
        softAssert.assertEquals(createSanitary.getValueFromSpinnerSanitaryInstallationsPrice(),
                propertyFile.getSanitaryInstallationsPrice());
        softAssert.assertAll();
    }

    /**
     * Creates Layout
     *
     * @throws InterruptedException
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 17, description = "seventeenth test")
    public void createLayout() {
        final Layout layout = PageFactory.initElements(driver, Layout.class);
        final SoftAssert softAssert = new SoftAssert();
        layout.clickOnLayoutIcon();
        layout.clickOnLayoutDrawIcon();
        layout.dragAndDropNewRoom();
        final int countOfRooms = layout.CheckIfRoomHasBeenDraggedAndDropped();
        boolean flag = false;
        if (countOfRooms == 1) {
            flag = true;
            softAssert.assertTrue(flag);
        } else {
            softAssert.assertTrue(flag);
        }
        softAssert.assertAll();
    }

    /**
     * Creates Layout wall
     *
     * @throws InterruptedException
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 18, description = "eightteenth test")
    public void DaragAndDropWall() throws InterruptedException {
        final LayoutWall layoutWall = PageFactory.initElements(driver, LayoutWall.class);
        final SoftAssert softAssert = new SoftAssert();
        layoutWall.clickOnWallIcon();
        final int countOfWallBeforDragAndDrop = layoutWall.checkCountOfWallBeforeDragAndDrop();
        Thread.sleep(2000);
        layoutWall.dragAndDropRoomsUpperSideInsideWall();
        Thread.sleep(2000);
        layoutWall.dragAndDropRoomsRightSideInsideWall();
        Thread.sleep(2000);
        layoutWall.dragAndDropRoomsLowerSideInsideWall();
        Thread.sleep(2000);
        layoutWall.dragAndDropRoomsLeftSideInsideWall();
        Thread.sleep(2000);
        final int countOfWallAfterDragAndDrop = layoutWall.checkCountOfWallAfterDragAndDrop();
        boolean flag = false;
        if (countOfWallBeforDragAndDrop < countOfWallAfterDragAndDrop & countOfWallAfterDragAndDrop == 4) {
            flag = true;
            softAssert.assertTrue(flag);
        } else {
            softAssert.assertTrue(flag);
        }
        softAssert.assertAll();

    }

    /**
     * Creates Layout window
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 19, description = "nineteenth test")
    public void DragAndDropWindow() {
        final LayoutWindow layoutWindow = PageFactory.initElements(driver, LayoutWindow.class);
        final SoftAssert softAssert = new SoftAssert();
        layoutWindow.clickOnWindowIcon();
        final int countOfWindowBeforeDragAndDrop = layoutWindow.checkCoutnOfWindowBeforeDragAndDrop();
        layoutWindow.dragAndDropRoomsUpperSideWindow();
        layoutWindow.dragAndDropRoomsRightSideWindow();
        layoutWindow.dragAndDropRoomsLowerSideWindow();
        layoutWindow.dragAndDropRoomsLeftSideWindow();
        boolean flag = false;
        if (countOfWindowBeforeDragAndDrop < layoutWindow.CheckCountOfWindowAfterDragAndDrop()
                & layoutWindow.CheckCountOfWindowAfterDragAndDrop() == 8) {
            flag = true;
            softAssert.assertTrue(flag);
        } else {
            softAssert.assertTrue(flag);
        }
        softAssert.assertAll();
    }

    /**
     * Creates layout blind
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 20, description = "twentieth test")
    public void dragAndDropBlind() {
        final LayoutBlind layoutBlind = PageFactory.initElements(driver, LayoutBlind.class);
        final SoftAssert softAssert = new SoftAssert();
        final int countOfBlindBeforeDragAndDrop = layoutBlind.checkCoutnOfBlindBeforeDragAndDrop();
        layoutBlind.dragAndDroptBlindToWindow();
        boolean flag = false;
        if (countOfBlindBeforeDragAndDrop < layoutBlind.CheckCountOfBlindAfterDragAndDrop()
                & layoutBlind.CheckCountOfBlindAfterDragAndDrop() == 8) {
            flag = true;
            softAssert.assertTrue(flag);
        } else {
            softAssert.assertTrue(flag);
        }
        softAssert.assertAll();
    }

    /**
     * Creates layout Door
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 21, description = "twenty first test")
    public void dragAndDropDoor() {
        final LayoutDoor layoutDoor = PageFactory.initElements(driver, LayoutDoor.class);
        final SoftAssert softAssert = new SoftAssert();
        layoutDoor.clickOnDoorIcon();
        final int countOfDoorBeforeDragAndDrop = layoutDoor.checkCountOfDoorBeforeDragAndDrop();
        layoutDoor.dragAndDropRoomsUpperSideDoor();
        layoutDoor.dragAndDropRoomsLeftSideDoor();
        boolean flag = false;
        if (countOfDoorBeforeDragAndDrop < layoutDoor.checkCountOfDoorAfterDragAndDrop()
                & layoutDoor.checkCountOfDoorAfterDragAndDrop() == 2) {
            flag = true;
            softAssert.assertTrue(flag);
        } else {
            softAssert.assertTrue(flag);
        }
        softAssert.assertAll();
    }

    /**
     * Creates layout accessControl
     *
     * @throws AWTException
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 22, description = "twenty second test")
    public void dragAndDropAccessContol() throws AWTException {
        final LayoutAccessControl layoutAccessControl = PageFactory.initElements(driver, LayoutAccessControl.class);
        final SoftAssert softAssert = new SoftAssert();
        layoutAccessControl.clickOnAccessControlIcon();
        final int countOfAccessControlBeforeDragAndDrop = layoutAccessControl
                .checkCountOfAccessControlBeforeDragAndDrop();
        layoutAccessControl.dragAndDropRoomsRightSideAccessControl();
        layoutAccessControl.dragAndDropRoomsLeftSideAccessControl();
        boolean flag = false;
        if (countOfAccessControlBeforeDragAndDrop <= layoutAccessControl.checkCountOfAccessControlAfterDragAndDrop()
                & layoutAccessControl.checkCountOfAccessControlAfterDragAndDrop() == 2) {
            flag = true;
            softAssert.assertTrue(flag);
        } else {
            softAssert.assertTrue(flag);
        }
        softAssert.assertAll();

    }

    /**
     * Creates layout heater
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 23, description = "twenty third test")
    public void dragAndDropHeater() {
        final LayoutHeater layoutHeater = PageFactory.initElements(driver, LayoutHeater.class);
        final SoftAssert softAssert = new SoftAssert();
        layoutHeater.clickOnHeaterIcon();
        layoutHeater.dragAndDropRoomsRightSideHeater();
        layoutHeater.dragAndDropRoomsLowerSideHeater();

        softAssert.assertAll();
    }

    /**
     * Creates layout Light
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 24, description = "twenty fourth test")
    public void dragAndDropLight() {
        final LayoutLight layoutLight = PageFactory.initElements(driver, LayoutLight.class);
        final SoftAssert softAssert = new SoftAssert();
        layoutLight.clickOnLightIcon();
        final int countOfLightBeforeDragAndDrop = layoutLight.checkCountOfLightBeforeDragAndDrop();
        layoutLight.dragAndDropToWithinTheRoomLight();
        boolean flag = false;
        if (countOfLightBeforeDragAndDrop < layoutLight.checkCountOfLightAfterDragAndDrop()
                & layoutLight.checkCountOfLightAfterDragAndDrop() == 4) {
            flag = true;
            softAssert.assertTrue(flag);
        } else {
            softAssert.assertTrue(flag);
        }
        softAssert.assertAll();
    }

    /**
     * Creates layout Electric
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 25, description = "twenty fifth test")
    public void dragAndDropElectric() {
        final LayoutElectric layoutElectric = PageFactory.initElements(driver, LayoutElectric.class);
        final SoftAssert softAssert = new SoftAssert();
        layoutElectric.clickOnElectricIcon();
        final int countOfElectricBeforeDragAndDrop = layoutElectric.checkCountOfElectricBeforeDragAndDrop();
        layoutElectric.dragAndDropRoomsRightSideElectric();
        layoutElectric.dragAndDropRoomsLowerSideElectric();
        layoutElectric.dragAndDropRoomsLeftSideElectric();
        layoutElectric.dragAndDropRoomsUpperSideElectric();
        boolean flag = false;
        if (countOfElectricBeforeDragAndDrop < layoutElectric.checkCountOfElectricAferDragAndDrop()
                & layoutElectric.checkCountOfElectricAferDragAndDrop() == 4) {
            flag = true;
            softAssert.assertTrue(flag);
        } else {
            softAssert.assertTrue(flag);
        }
        softAssert.assertAll();
    }

    /**
     * Creates layout ElectricPlus
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 26, description = "twenty sixth test")
    public void dragAndDropElectricPlus() {
        final LayoutElectricPlus layoutElectricPlus = PageFactory.initElements(driver, LayoutElectricPlus.class);
        final SoftAssert softAssert = new SoftAssert();
        layoutElectricPlus.clickOnElectricPlusIcon();
        final int countOfElectricPlusBeforeDragAndDrop = layoutElectricPlus.checkCountOfElectricPlusBeforeDragAndDrop();
        layoutElectricPlus.dragAndDropRoomsRightSideElectricPlus();
        layoutElectricPlus.dragAndDropRoomsLowerSideElectricPlus();
        boolean flag = false;
        if (countOfElectricPlusBeforeDragAndDrop < layoutElectricPlus.checkCountOfElectricPlusAfterDragAndDrop()
                & layoutElectricPlus.checkCountOfElectricPlusAfterDragAndDrop() == 2) {
            flag = true;
            softAssert.assertTrue(flag);
        } else {
            softAssert.assertTrue(flag);
        }
        softAssert.assertAll();
    }

    /**
     * Creates layout sensor
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 27, description = "twenty seventh test")
    public void dragAndDropSensor() {
        final LayoutSensor layoutSensor = PageFactory.initElements(driver, LayoutSensor.class);
        final SoftAssert softAssert = new SoftAssert();
        layoutSensor.clickOnSensorIcon();
        final int countOfSensorBeforeDragAndDrop = layoutSensor.checkCountOfSensorBeforeDragAndDrop();
        layoutSensor.DragAndDropToWithinRoomSensor();
        boolean flag = false;
        if (countOfSensorBeforeDragAndDrop < layoutSensor.checkCountOfSensorAfterDragAndDrop()
                & layoutSensor.checkCountOfSensorAfterDragAndDrop() == 2) {
            flag = true;
            softAssert.assertTrue(flag);
        } else {
            softAssert.assertTrue(flag);
        }
        softAssert.assertAll();
    }

    /**
     * Creates PDF
     *
     * @throws InterruptedException
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 28, description = "twenty eightth test")
    public void createPDF() throws InterruptedException {
        final LayoutOverView layoutOverView = PageFactory.initElements(driver, LayoutOverView.class);
        final SoftAssert softAssert = new SoftAssert();
        layoutOverView.clickOnOverViewIcon();
        layoutOverView.clickOnPDFButton();
        /** Verify values */
        Thread.sleep(4000);
        final boolean fileSize = layoutOverView.checkIfFileIsDownloaded(propertyFile.getDownloadPath(),
                propertyFile.getFileName());
        softAssert.assertTrue(fileSize);
        softAssert.assertAll();

    }

    /**
     * Planing building
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 29, description = "twenty nineth test")
    public void adjustBuilding() {
        final Building building = PageFactory.initElements(driver, Building.class);
        final SoftAssert softAssert = new SoftAssert();
        building.clickOnBuildingPlaningIcon();
        building.selectBuildingType();
        building.clickOnSpinnerNetFloorAreaUPButto();
        building.selectBuildingSituation();
        building.selectBuildingShape();
        building.clickOnHousingUnitIcon();
        building.clickOnBuildingIcon();
        /** Verify values */
        softAssert.assertEquals(building.getValueFromSelcteBuildingType(), propertyFile.getBuildingType());
        softAssert.assertEquals(building.getValueFromSpinnerNetFloorArea(), propertyFile.getBuildigNetFloorArea());
        softAssert.assertEquals(building.getValueFromSelectBuildindSituation(), propertyFile.getBuildigSituation());
        softAssert.assertEquals(building.getValueFromSelectBuildingShape(), propertyFile.getBuildigShape());
        softAssert.assertAll();
    }

    /**
     * Planing housing unit
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 30, description = "thirtieth test")
    public void housingUnit() {
        final HousingUnit housingUnit = PageFactory.initElements(driver, HousingUnit.class);
        final SoftAssert softAssert = new SoftAssert();
        housingUnit.clickOnHousingUnitIcon();
        housingUnit.clickOnCreatedType();
        /** Saves default values */
        final String description = housingUnit.getValueFromInputFieldDescription();
        final String netUsingArea = housingUnit.getValueFromInputFieldSpinnerNetUsingArea();
        final String residents = housingUnit.getValueFromInputFieldSpinnerResidents();
        housingUnit.planingHousingUnitAndAbort();
        housingUnit.clickOnCreatedType();
        /** Verify values */
        softAssert.assertEquals(housingUnit.getValueFromInputFieldDescription(), description);
        softAssert.assertEquals(housingUnit.getValueFromInputFieldSpinnerNetUsingArea(), netUsingArea);
        softAssert.assertEquals(housingUnit.getValueFromInputFieldSpinnerResidents(), residents);
        housingUnit.planingHousingUnitAndSave();
        housingUnit.clickOnCreatedType();
        softAssert.assertEquals(housingUnit.getValueFromInputFieldDescription(),
                propertyFile.getHousingUnitDescription());
        softAssert.assertEquals(housingUnit.getValueFromInputFieldSpinnerNetUsingArea(),
                propertyFile.getHousingUnitNetUsingArea());
        softAssert.assertEquals(housingUnit.getValueFromInputFieldSpinnerResidents(),
                propertyFile.getHousingUnitResidents());
        softAssert.assertAll();
    }

    /**
     * Planing cellar
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 31, description = "thirty first test")
    public void planingCellar() {
        final Cellar cellar = PageFactory.initElements(driver, Cellar.class);
        final SoftAssert softAssert = new SoftAssert();
        cellar.clickOnCellarIcon();
        cellar.planingCellar();
        cellar.clickOnFloorIcon();
        cellar.clickOnCellarIcon();
        /** Verify values */
        softAssert.assertEquals(cellar.getValueFromSelctCellarType(), propertyFile.getCellarType());
        softAssert.assertEquals(cellar.getValueFromSelctCellarHeatingType(), propertyFile.getCellarHeatingType());
        softAssert.assertEquals(cellar.getValueFromSelectBasePlateConcreteType(),
                propertyFile.getCellarBasePlateConcreteType());
        softAssert.assertEquals(cellar.getValueFromSelectBasePlateInsulationType(),
                propertyFile.getCellarBasePlateInsulationType());
        softAssert.assertEquals(cellar.getValueFromSpinnerUValue(), propertyFile.getCellarUvalue());
        softAssert.assertEquals(cellar.getValueFromSpinnerNetFloorArea(), propertyFile.getCellarNetFloorArea());
        softAssert.assertEquals(cellar.getValueFromSpinnerFloorHeight(), propertyFile.getCellarFloorHeight());
        softAssert.assertEquals(cellar.getValueFromSpinnerBasePlateThickness(),
                propertyFile.getCellarBasePlateThickness());
        softAssert.assertEquals(cellar.getValueFromSinnerInsulationThickness(),
                propertyFile.getCellarInsulationThickness());
        softAssert.assertAll();
    }

    /**
     * Planing floors
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 32, description = "thirty second test")
    public void buildingPlaningFloor() {
        final Floor floor = PageFactory.initElements(driver, Floor.class);
        final SoftAssert softAssert = new SoftAssert();
        floor.clickOnFloorIcon();
        floor.clickOnCreatedEG();
        final String floorHeight = floor.getValueFromSpinnerFloorHeightEG();
        floor.clickOnSpinnerFloorHeightUpButton();
        floor.clickOnAbort();
        floor.clickOnCreatedEG();
        /** Verify values */
        softAssert.assertEquals(floor.getValueFromSpinnerFloorHeightEG(), floorHeight);
        floor.clickOnSpinnerFloorHeightUpButton();
        floor.clickOnSave();
        floor.clickOnCreatedEG();
        /** Verify values */
        softAssert.assertEquals(floor.getValueFromSpinnerFloorHeightEG(), propertyFile.getSpinnerFloorHeight());
        floor.clickOnCopy();
        floor.clickOnFirstOG();
        /** Verify values */
        softAssert.assertEquals(floor.getValueFromSpinnerFloorHeightFirstOG(), propertyFile.getSpinnerFloorHeight());
        final int countOfFloorBeforeDeleting = floor.getCountOfFloorBeforeDeleting();
        floor.clickOnDeleteFirstOG();
        floor.clickOnConfrimDelete();
        /** Verify values */
        final int countOfFloorAfterDeleting = floor.getCountOfFloorAfterDeleting();
        softAssert.assertEquals(countOfFloorBeforeDeleting - 1, countOfFloorAfterDeleting);
        softAssert.assertAll();
    }

    /**
     * Planing roof
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 33, description = "thirty third test")
    public void buildingPlaningRoof() {
        final Roof roof = PageFactory.initElements(driver, Roof.class);
        final SoftAssert softAssert = new SoftAssert();
        roof.clickOnRoofIcon();
        roof.planingRoof();
        roof.clickOnAirIcon();
        roof.clickOnRoofIcon();
        /** Verify values */
        softAssert.assertEquals(roof.getValueFromSelectRoofShape(), propertyFile.getRoofShape());
        softAssert.assertEquals(roof.getValueFromSelectRoofHeating(), propertyFile.getRoofHeating());
        softAssert.assertEquals(roof.getValueFromSpinnerRoofPitch(), propertyFile.getRoofPitch());
        softAssert.assertEquals(roof.getValueFromSpinnerRoofHeight(), propertyFile.getRoofHeight());
        softAssert.assertEquals(roof.getValueFromSelectRoofInsulationType(), propertyFile.getRoofInsulationType());
        softAssert.assertEquals(roof.getValueFromSpinnerUValue(), propertyFile.getRoofUValue());
        softAssert.assertAll();
    }

    /**
     * Planing air condition
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 34, description = "thirty fourth test")
    public void buildingPlaningAirCondition() {
        final AirConditioning airConditioning = PageFactory.initElements(driver, AirConditioning.class);
        final SoftAssert softAssert = new SoftAssert();
        airConditioning.clickOnAirConditioningIcon();
        airConditioning.SelectVentilationSystem();
        airConditioning.clickOnConfirm();
        airConditioning.clickOnPhotovoltaicIcon();
        airConditioning.clickOnAirConditioningIcon();
        /** Verify values */
        softAssert.assertEquals(airConditioning.getValueFromSelectVentilationSystem(),
                propertyFile.getAirVentilationSystem());
        softAssert.assertAll();
    }

    /**
     * Planing pv
     *
     * @throws InterruptedException
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 35, description = "thirty fiveth test")
    public void buildingPlaningPv() throws InterruptedException {
        final Photovoltaic pv = PageFactory.initElements(driver, Photovoltaic.class);
        final SoftAssert softAssert = new SoftAssert();
        pv.clickOnPhotovoltaicIcon();
        Thread.sleep(2000);
        pv.selectPvPlantType();
        pv.clickOnConfrim();
        pv.clickOnAddNewPv();
        pv.clickOnNewPv();
        /** Saves default values */
        final String pvModule = pv.getValueFromSelectPvModuleType();
        final String pvManufacturer = pv.getValueFromSelectManufacturer();
        final String pvCount = pv.getValueFromSpinnerCount();
        final String pvModel = pv.getValueFromSelectPvModel();
        final String pvPower = pv.getValueFromPvPower();
        pv.planingPvAndAbort();
        pv.clickOnNewPv();
        /** Verify values */
        softAssert.assertEquals(pv.getValueFromSelectPvModuleType(), pvModule);
        softAssert.assertEquals(pv.getValueFromSelectManufacturer(), pvManufacturer);
        softAssert.assertEquals(pv.getValueFromSpinnerCount(), pvCount);
        softAssert.assertEquals(pv.getValueFromSelectPvModel(), pvModel);
        softAssert.assertEquals(pv.getValueFromPvPower(), pvPower);
        pv.planingPvAndSave();
        /** Verify values */
        pv.clickOnNewPv();
        // Thread.sleep(2000);
        softAssert.assertEquals(pv.getValueFromSelectPvPlantType(), propertyFile.getPvPlantType());
        softAssert.assertEquals(pv.getValueFromSelectManufacturer(), propertyFile.getPvManufacturer());
        softAssert.assertEquals(pv.getValueFromSelectPvModuleType(), propertyFile.getPvModuleType());
        softAssert.assertEquals(pv.getValueFromSpinnerCount(), propertyFile.getPvCount());
        softAssert.assertEquals(pv.getValueFromSelectPvModel(), propertyFile.getPvModel());
        softAssert.assertEquals(pv.getValueFromPvPower(), propertyFile.getPvPower());
        softAssert.assertAll();
    }

    /**
     * Download file xml data
     *
     * @throws InterruptedException
     *
     *
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 36, description = "thirty sixth test")
    public void Dokument() throws InterruptedException {
        final Dokuments dokuments = PageFactory.initElements(driver, Dokuments.class);
        final SoftAssert softAssert = new SoftAssert();
        dokuments.clickOnDokumentIcon();
        dokuments.createAutomationAndElectric();
        dokuments.createAutomation();
        dokuments.createElectric();
        /** Verify values */
        Thread.sleep(3000);
        softAssert.assertTrue(dokuments.checkIfFileIsDownloaded(propertyFile.getDownloadPath(),
                propertyFile.getFileNameAutomationAndElectric()));
        softAssert.assertTrue(dokuments.checkIfFileIsDownloaded(propertyFile.getDownloadPath(),
                propertyFile.getFileNameAutomation()));
        softAssert.assertTrue(
                dokuments.checkIfFileIsDownloaded(propertyFile.getDownloadPath(), propertyFile.getFileNameElectric()));
        softAssert.assertAll();
    }

    /**
     * delete the created Project
     *
     * @throws InterruptedException
     */
    @Test(dependsOnMethods = { "loginToConfigurator" }, priority = 37, description = "thirty seventh test")
    public void deletingNewProject() throws InterruptedException {
        final DeleteProject deleteProject = PageFactory.initElements(driver, DeleteProject.class);
        final SoftAssert softAssert = new SoftAssert();
        deleteProject.goToAccount();
        Thread.sleep(2000);
        final int projectCountBeforeDeleting = deleteProject.getProjectCountBeforeDeleting();
        deleteProject.deleteCreatedProject();
        final int projectCountAfterDeleting = deleteProject.getProjectCountAfterDeleting();
        /** Verify values */
        softAssert.assertTrue(projectCountBeforeDeleting - 1 == projectCountAfterDeleting);
        /** list of projects names */
        final List<WebElement> list = deleteProject.getProjectsName();
        list.forEach(name -> {
            if (name.getText().toString().equals(projectName)) {
                softAssert.assertTrue(false);
            } else if (list.isEmpty()) {
                return;
            }
            softAssert.assertTrue(true);
        });
        softAssert.assertAll();
    }
}
