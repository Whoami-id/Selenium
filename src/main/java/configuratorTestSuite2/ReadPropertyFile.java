
package configuratorTestSuite2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

    private Properties properties;

    /**
     * Reads data from config.propertres
     *
     */

    public ReadPropertyFile() {
        final File file = new File(
                System.getProperty("user.dir") + "\\src\\main\\resources\\configData\\config.properties");
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(file));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (final IOException e) {
                System.out.println("Trouble reading from the file: " + e.getMessage());
            }

        } catch (final FileNotFoundException ex) {
            System.out.println("File can not be found" + ex.getMessage());

        }

    }

    /**
     * Gets URL from config.propeties
     *
     * @return URL
     */
    public String getUrl() {
        final String url = properties.getProperty("url");
        if (url == null) {
            System.err.println("URL not specified in the config.properties file.");
        }
        return url;
    }

    /**
     * Gets Entered Email config.propeties
     *
     * @return Email
     */
    public String getEmail() {
        final String email = properties.getProperty("email");
        if (email == null) {
            System.err.println("E-mail not specified in the config.properties file.");
        }
        return email;
    }

    /**
     * Gets Entered Password config.propeties
     *
     * @return Password
     */
    public String getPassword() {
        final String password = properties.getProperty("password");
        if (password == null) {
            System.err.println("Password not specified in the config.properties file.");
        }
        return password;
    }

    /**
     * Gets Entered Projectname fromconfig.propeties
     *
     * @return projectname
     */
    public String getProjectName() {
        final String projectName = properties.getProperty("projectName");
        if (projectName == null) {
            System.err.println("Project name not specified in the config.properties file.");
        }
        return projectName;
    }

    /**
     * Gets Postal code from config.propeties
     *
     * @return Postal code
     */
    public String getPostaCode() {
        final String postalCode = properties.getProperty("postalCode");
        if (postalCode == null) {
            System.err.println("Postalcode not specified in the config.properties file.");
        }
        return postalCode;
    }

    /**
     * Gets City form config.propeties
     *
     * @return City
     */
    public String getCity() {
        final String city = properties.getProperty("city");
        if (city == null) {
            System.err.println("City not specified in the config.properties file.");
        }
        return city;
    }

    /**
     * Gets Construction type from config.propeties
     *
     * @return Construction type
     */
    public String getconstructionType() {
        final String constructionType = properties.getProperty("constructionType");
        if (constructionType == null) {
            System.err.println("constructionType not specified in the config.properties file.");
        }
        return constructionType;
    }

    /**
     * Gets Startdate form config.propeties
     *
     * @return Startdate
     */
    public String getStartDate() {
        final String startDate = properties.getProperty("startDate");
        if (startDate == null) {
            System.err.println("StartDate not specified in the config.properties file.");
        }
        return startDate;
    }

    /**
     * Gets Name of Wall from config.propeties
     *
     * @return Wallname
     */
    public String getWallName20() {
        final String wallName = properties.getProperty("wallName20");
        if (wallName == null) {
            System.err.println("Wallname not specified in the config.properties file.");
        }
        return wallName;
    }

    /**
     * Gets Name of Wall from config.propeties
     *
     * @return Wall name
     */
    public String getWallName21() {
        final String wallName = properties.getProperty("wallName21");
        if (wallName == null) {
            System.err.println("Wallname not specified in the config.properties file.");
        }
        return wallName;
    }

    /**
     * Gets MasonryType from config.propeties
     *
     * @return MasonryType
     */
    public String getMasonryType() {
        final String masonryType = properties.getProperty("masonryType");
        if (masonryType == null) {
            System.err.println("MasonryType not specified in the config.properties file.");
        }
        return masonryType;
    }

    /**
     * Gets InstallationsType from config.propeties
     *
     * @return InstallationType
     */
    public String getInstallationType() {
        final String installationType = properties.getProperty("installationType");
        if (installationType == null) {
            System.err.println("InstallationType not specified in the config.properties file.");
        }
        return installationType;
    }

    /**
     * Gets Wall type form config.propeties
     *
     * @return Wall type
     */
    public String getWallTypeInside() {
        final String wallType = properties.getProperty("wallTypeInside");
        if (wallType == null) {
            System.err.println("WallType not specified in the config.properties file.");
        }
        return wallType;
    }

    /**
     * Gets Walltype form config.propeties
     *
     * @return Walltype
     */
    public String getWallTypeOuter() {
        final String wallType = properties.getProperty("wallTypeOuter");
        if (wallType == null) {
            System.err.println("WallType not specified in the config.properties file.");
        }
        return wallType;
    }

    /**
     * Gets WallThickness form config.propeties
     *
     * @return WallThickness
     */
    public String getWallThickness() {
        final String wallthickness = properties.getProperty("wallthickness");
        if (wallthickness == null) {
            System.err.println("WallThckness not specified in the config.properties file.");
        }
        return wallthickness;
    }

    /**
     * Gets WallUValue form config.propeties
     *
     * @return WallUValue
     */
    public String getWallUValue() {
        final String wallUValue = properties.getProperty("wallUValue");
        if (wallUValue == null) {
            System.err.println("WallThckness not specified in the config.properties file.");
        }
        return wallUValue;
    }

    /**
     * Gets FireResistancetype form config.propeties
     *
     * @return FireResistancetype
     */
    public String getFireResistanceType() {
        final String fireResistanceType = properties.getProperty("fireResistanceType");
        if (fireResistanceType == null) {
            System.err.println("FireResistanceType not specified in the config.properties file.");
        }
        return fireResistanceType;
    }

    /**
     * Gets Name of Window form config.propeties
     *
     * @return Window name
     */
    public String getWindowName() {
        final String windowName = properties.getProperty("windowName");
        if (windowName == null) {
            System.err.println("WindowName not specified in the config.properties file.");
        }
        return windowName;
    }

    /**
     * Gets Window type from config.propeties
     *
     * @return Window type
     */
    public String getWindowType() {
        final String windowType = properties.getProperty("windowType");
        if (windowType == null) {
            System.err.println("WindowType not specified in the config.properties file.");
        }
        return windowType;
    }

    /**
     * Gets WindowGlazingtype from config.propeties
     *
     * @return WindowGlazintype
     */
    public String getWindowGlazinType() {
        final String glazinType = properties.getProperty("glazinType");
        if (glazinType == null) {
            System.err.println("GlazinType not specified in the config.properties file.");
        }
        return glazinType;
    }

    /**
     * Gets WindowContact from config.propeties
     *
     * @return WindowContact
     */
    public String getWindowContactNo() {
        final String windowContactNo = properties.getProperty("windowContactNo");
        if (windowContactNo == null) {
            System.err.println("WindowContactNo not specified in the config.properties file.");
        }
        return windowContactNo;
    }

    /**
     * Gets WindowContact from config.propeties
     *
     * @return WindowContact
     */
    public String getWindowContactJa() {
        final String windowContactJa = properties.getProperty("windowContactJa");
        if (windowContactJa == null) {
            System.err.println("WindowContactJa not specified in the config.properties file.");
        }
        return windowContactJa;
    }

    /**
     * Gets WindowControltype form config.propeties
     *
     * @return WindowControltype
     */
    public String getWindowControlType() {
        final String windowControlType = properties.getProperty("windowControlType");
        if (windowControlType == null) {
            System.err.println("WindowContactJa not specified in the config.properties file.");
        }
        return windowControlType;
    }

    /**
     * Gets WindowOpeningDetectiontype from config.propeties
     *
     * @return WindowOpeningDetectiontype
     */
    public String getWindowOpenDetectionType() {
        final String windowOpenDetectioType = properties.getProperty("windowOpenDetectioType");
        if (windowOpenDetectioType == null) {
            System.err.println("WindowContactJa not specified in the config.properties file.");
        }
        return windowOpenDetectioType;
    }

    /**
     * Gets window width from config.propeties
     *
     * @return window width
     */
    public String getWindowWidth() {
        final String windowWidth = properties.getProperty("windowWidth");
        if (windowWidth == null) {
            System.err.println("Window width not specified in the config.properties file.");
        }
        return windowWidth;
    }

    /**
     * Gets window lenght from config.propeties
     *
     * @return window lenght
     */
    public String getWindowHeight() {
        final String windowHeight = properties.getProperty("windowHeight");
        if (windowHeight == null) {
            System.err.println("Window height not specified in the config.properties file.");
        }
        return windowHeight;
    }

    /**
     * Gets window u-value from config.propeties
     *
     * @return window u-value
     */
    public String getWindowUValue() {
        final String windowUValue = properties.getProperty("windowUValue");
        if (windowUValue == null) {
            System.err.println("Window u-value not specified in the config.properties file.");
        }
        return windowUValue;
    }

    /**
     * Gets BlindName from config.propeties
     *
     * @return BlindName
     */
    public String getBlindName() {
        final String blindName = properties.getProperty("blindName");
        if (blindName == null) {
            System.err.println("Blind Name not specified in the config.properties file.");
        }
        return blindName;
    }

    /**
     * Gets Shading type form config.propeties
     *
     * @return Shading type
     */
    public String getShadingType() {
        final String shadingType = properties.getProperty("shadingType");
        if (shadingType == null) {
            System.err.println("Shadingtype not specified in the config.properties file.");
        }
        return shadingType;
    }

    /**
     * Gets ShadingColor form config.propeties
     *
     * @return ShadingColor
     */
    public String getShadingColor() {
        final String shadingColor = properties.getProperty("shadingColor");
        if (shadingColor == null) {
            System.err.println("Shading color not specified in the config.properties file.");
        }
        return shadingColor;
    }

    /**
     * Gets Door name from config.propeties
     *
     * @return Door name
     */
    public String getDoorName() {
        final String doorName = properties.getProperty("doorName");
        if (doorName == null) {
            System.err.println("Door name not specified in the config.properties file.");
        }
        return doorName;
    }

    /**
     * Gets Doo rmaterial from config.propeties
     *
     * @return Door material
     */
    public String getDoorMaterial() {
        final String doorMaterial = properties.getProperty("doorMaterial");
        if (doorMaterial == null) {
            System.err.println("Door material not specified in the config.properties file.");
        }
        return doorMaterial;
    }

    /**
     * Gets DoorSecurtiy from config.propeties
     *
     * @return DoorSecurity
     */
    public String getDoorSecurity() {
        final String doorSecurity = properties.getProperty("doorSecurity");
        if (doorSecurity == null) {
            System.err.println("Door security not specified in the config.properties file.");
        }
        return doorSecurity;
    }

    /**
     * Gets Door type from config.propeties
     *
     * @return Door type
     */
    public String getDoorType() {
        final String doorType = properties.getProperty("doorType");
        if (doorType == null) {
            System.err.println("Door Type not specified in the config.properties file.");
        }
        return doorType;
    }

    /**
     * Gets Door category from config.propeties
     *
     * @return Door category
     */
    public String getDoorCategory() {
        final String doorCategory = properties.getProperty("doorCategory");
        if (doorCategory == null) {
            System.err.println("Door category not specified in the config.properties file.");
        }
        return doorCategory;
    }

    /**
     * Gets Door controltype from config.propeties
     *
     * @return Door controltype
     */
    public String getDoorControlType() {
        final String doorControlType = properties.getProperty("doorControlType");
        if (doorControlType == null) {
            System.err.println("Door controltype not specified in the config.properties file.");
        }
        return doorControlType;
    }

    /**
     * Gets Door lock from config.propeties
     *
     * @return Door lock
     */
    public String getDoorLockType() {
        final String doorLock = properties.getProperty("doorLock");
        if (doorLock == null) {
            System.err.println("Door locktype not specified in the config.properties file.");
        }
        return doorLock;
    }

    /**
     * Gets Door opening side type from config.propeties
     *
     * @return Door opening side type
     */
    public String getDoorOpeningSideType() {
        final String doorOpeningSideType = properties.getProperty("doorOpeningSideType");
        if (doorOpeningSideType == null) {
            System.err.println("Door opening side type not specified in the config.properties file.");
        }
        return doorOpeningSideType;
    }

    /**
     * Gets door width from config.propeties
     *
     * @return door width
     */
    public String getDoorWidth() {
        final String doorWidth = properties.getProperty("doorWidth");
        if (doorWidth == null) {
            System.err.println("Door width type not specified in the config.properties file.");
        }
        return doorWidth;
    }

    /**
     * Gets door height from config.propeties
     *
     * @return door height
     */
    public String getDoorHeight() {
        final String doorHeight = properties.getProperty("doorHeight");
        if (doorHeight == null) {
            System.err.println("Door height type not specified in the config.properties file.");
        }
        return doorHeight;
    }

    /**
     * Gets AccessControlname from config.propeties
     *
     * @return AccessControlname
     */
    public String getAccessControlName() {
        final String accessControlName = properties.getProperty("accessControlName");
        if (accessControlName == null) {
            System.err.println("Access control name not specified in the config.properties file.");
        }
        return accessControlName;
    }

    /**
     * Gets AccessControlCategory from config.propeties
     *
     * @return AccessControlCategory
     */
    public String getAccessControlCategory() {
        final String accessControlCategory = properties.getProperty("accessControlCategory");
        if (accessControlCategory == null) {
            System.err.println("Access control category not specified in the config.properties file.");
        }
        return accessControlCategory;
    }

    /**
     * Gets AccessControlUseArt from config.propeties
     *
     * @return AccessControlUseArt
     */
    public String getAccessControlUseArt() {
        final String accessControlUseArt = properties.getProperty("accessControlUseArt");
        if (accessControlUseArt == null) {
            System.err.println("Access control use art not specified in the config.properties file.");
        }
        return accessControlUseArt;
    }

    /**
     * Gets Heater name from config.propeties
     *
     * @return Heater name
     */
    public String getHeaterName() {
        final String heaterName = properties.getProperty("heaterName");
        if (heaterName == null) {
            System.err.println("Heater name not specified in the config.properties file.");
        }
        return heaterName;
    }

    /**
     * Gets Heater type from config.propeties
     *
     * @return Heater type
     */
    public String getHeaterType() {
        final String heaterType = properties.getProperty("heaterType");
        if (heaterType == null) {
            System.err.println("Heater Type not specified in the config.properties file.");
        }
        return heaterType;
    }

    /**
     * Gets Heater style from config.propeties
     *
     * @return Heater Style
     */
    public String getHeaterStyle() {
        final String heaterStyle = properties.getProperty("heaterStyle");
        if (heaterStyle == null) {
            System.err.println("Heater Style not specified in the config.properties file.");
        }
        return heaterStyle;
    }

    /**
     * Gets Heater ActuatorType from config.propeties
     *
     * @return Heater ActuatorType
     */
    public String getHeaterActuatorType() {
        final String heaterActuatorType = properties.getProperty("heaterActuatorType");
        if (heaterActuatorType == null) {
            System.err.println("Heater ActuatorType not specified in the config.properties file.");
        }
        return heaterActuatorType;
    }

    /**
     * Gets heater width from config.propeties
     *
     * @return Heater width
     */
    public String getHeaterWidth() {
        final String heaterWidth = properties.getProperty("heaterWidth");
        if (heaterWidth == null) {
            System.err.println("Heater width not specified in the config.properties file.");
        }
        return heaterWidth;
    }

    /**
     * Gets Heater depth from config.propeties
     *
     * @return Heater depth
     */
    public String getHeaterDepth() {
        final String heaterDepth = properties.getProperty("heaterDepth");
        if (heaterDepth == null) {
            System.err.println("Heater depth not specified in the config.properties file.");
        }
        return heaterDepth;
    }

    /**
     * Gets Heater height from config.propeties
     *
     * @return Heater height
     */
    public String getHeaterHeight() {
        final String heaterHeight = properties.getProperty("heaterHeight");
        if (heaterHeight == null) {
            System.err.println("Heater Height not specified in the config.properties file.");
        }
        return heaterHeight;
    }

    /**
     * Gets Heater unit price
     *
     * @return Heater unit price
     */
    public String getHeaterUnitPrice() {
        final String heaterUnitPrice = properties.getProperty("heaterUnitPrice");
        if (heaterUnitPrice == null) {
            System.err.println("Heater unit price not specified in the config.properties file.");
        }
        return heaterUnitPrice;
    }

    /**
     * Gets heater installations price
     *
     * @return Heater installations price
     */
    public String getHeaterInstallationsPrice() {
        final String heaterInstallationsPrice = properties.getProperty("heaterInstallationsPrice");
        if (heaterInstallationsPrice == null) {
            System.err.println("Heater installations price not specified in the config.properties file.");
        }
        return heaterInstallationsPrice;
    }

    /**
     * Gets Ventilation name from config.propeties
     *
     * @return Ventalition name
     */
    public String getVentilationName() {
        final String ventilationName = properties.getProperty("ventilationName");
        if (ventilationName == null) {
            System.err.println("Ventilation Name not specified in the config.properties file.");
        }
        return ventilationName;
    }

    /**
     * Gets Ventilation usage from config.propeties
     *
     * @return Ventilation usage
     */
    public String getVentilationUsage() {
        final String ventilationUsage = properties.getProperty("ventilationUsage");
        if (ventilationUsage == null) {
            System.err.println("Ventilation Usage not specified in the config.properties file.");
        }
        return ventilationUsage;
    }

    /**
     * Gets Ventilation System from config.propeties
     *
     * @return Ventilation system
     */
    public String getVentilationSystem() {
        final String ventilationSystem = properties.getProperty("ventilationSystem");
        if (ventilationSystem == null) {
            System.err.println("Ventilation System not specified in the config.properties file.");
        }
        return ventilationSystem;
    }

    /**
     * Gets Ventilation Manufacturer from config.propeties
     *
     * @return Ventilation Manufacturer
     */
    public String getVentilationManufacturer() {
        final String ventilationManufacturer = properties.getProperty("ventilationManufacturer");
        if (ventilationManufacturer == null) {
            System.err.println("Ventilation Manufacturer not specified in the config.properties file.");
        }
        return ventilationManufacturer;
    }

    /**
     * Gets Ventilation Model from config.propeties
     *
     * @return Ventilation Model
     */
    public String getVentilationModel() {
        final String ventilationModel = properties.getProperty("ventilationModel");
        if (ventilationModel == null) {
            System.err.println("Ventilation Model not specified in the config.properties file.");
        }
        return ventilationModel;
    }

    /**
     * Gets light name from config.propeties
     *
     * @return light name
     */
    public String getLightName() {
        final String lightName = properties.getProperty("lightName");
        if (lightName == null) {
            System.err.println("Light Name not specified in the config.properties file.");
        }
        return lightName;
    }

    /**
     * Gets Light function type from config.propeties
     *
     * @return functionType
     */
    public String getLightFunctionType() {
        final String lightFunctionType = properties.getProperty("lightFunctionType");
        if (lightFunctionType == null) {
            System.err.println("Lights Function Type not specified in the config.properties file.");
        }
        return lightFunctionType;
    }

    /**
     * Gets Light article number from config.propeties
     *
     * @return articleNumber
     */
    public String getLightArticleNumber() {
        final String lightArticleNumber = properties.getProperty("lightArticleNumber");
        if (lightArticleNumber == null) {
            System.err.println("Lights article number not specified in the config.properties file.");
        }
        return lightArticleNumber;
    }

    /**
     * Gets Light description text from config.propeties
     *
     * @return lightDescription
     */
    public String getLightDescriptionText() {
        final String lightDescriptionText = properties.getProperty("lightDescriptionText");
        if (lightDescriptionText == null) {
            System.err.println("Lights description text not specified in the config.properties file.");
        }
        return lightDescriptionText;
    }

    /**
     * Gets Light type from config.propeties
     *
     * @return lightType
     */
    public String getLightType() {
        final String lightType = properties.getProperty("lightType");
        if (lightType == null) {
            System.err.println("Lights Type not specified in the config.properties file.");
        }
        return lightType;
    }

    /**
     * Gets Light unit from config.propeties
     *
     * @return lightUnit
     */
    public String getLightUnit() {
        final String lightUnit = properties.getProperty("lightUnit");
        if (lightUnit == null) {
            System.err.println("Lights unit not specified in the config.properties file.");
        }
        return lightUnit;
    }

    /**
     * Gets light length from config.propeties
     *
     * @return light length
     */
    public String getLightLength() {
        final String lightLength = properties.getProperty("lightLength");
        if (lightLength == null) {
            System.err.println("Lights length not specified in the config.properties file.");
        }
        return lightLength;
    }

    /**
     * Gets light wide from config.propeties
     *
     * @return light wide
     */
    public String getLightWide() {
        final String lightWide = properties.getProperty("lightWide");
        if (lightWide == null) {
            System.err.println("Lights wide not specified in the config.properties file.");
        }
        return lightWide;
    }

    /**
     * Gets light unit price form config.propeties
     *
     * @return light unit price
     */
    public String getLightUnitPrice() {
        final String lightUnitPrice = properties.getProperty("lightUnitPrice");
        if (lightUnitPrice == null) {
            System.err.println("Lights wide not specified in the config.properties file.");
        }
        return lightUnitPrice;
    }

    /**
     * Gets light installations price
     *
     * @return light installations price
     */
    public String getLightInstallationsPrice() {
        final String lightInstallationsPrice = properties.getProperty("lightInstallationsPrice");
        if (lightInstallationsPrice == null) {
            System.err.println("Lights installations price not specified in the config.properties file.");
        }
        return lightInstallationsPrice;
    }

    /**
     * Gets electric name from from config.propeties
     *
     * @return electric name
     */
    public String getElectricName() {
        final String electricName = properties.getProperty("electricName");
        if (electricName == null) {
            System.err.println("Electric Name not specified in the config.properties file.");
        }
        return electricName;
    }

    /**
     * Gets electric Execution type from config.propeties
     *
     * @return electric Execution type
     */
    public String getElectricExecutionType() {
        final String electricsExecutionType = properties.getProperty("electricsExecutionType");
        if (electricsExecutionType == null) {
            System.err.println("Electrics Execution Type not specified in the config.properties file.");
        }
        return electricsExecutionType;
    }

    /**
     * Gets electric Orientation type from config.propeties
     *
     * @return electric orientation type
     */
    public String getElectricOrientationType() {
        final String electricsOrientationType = properties.getProperty("electricsOrientationType");
        if (electricsOrientationType == null) {
            System.err.println("Electrics Orientation Type not specified in the config.properties file.");
        }
        return electricsOrientationType;
    }

    /**
     * Gets electric Manufacturer from config.propeties
     *
     * @return electric manufacturer
     */
    public String getElectricManufacturer() {
        final String electricsManufacturer = properties.getProperty("electricsManufacturer");
        if (electricsManufacturer == null) {
            System.err.println("Electrics Manufacturer not specified in the config.properties file.");
        }
        return electricsManufacturer;
    }

    /**
     * Gets electric Farm Rage Type from config.propeties
     *
     * @return electric Farm Range Type
     */
    public String getElectricFrameRangeType() {
        final String electricsFrameRangeType = properties.getProperty("electricsFrameRangeType");
        if (electricsFrameRangeType == null) {
            System.err.println("Electrics Frame Range Type not specified in the config.properties file.");
        }
        return electricsFrameRangeType;
    }

    /**
     * Gets electric Farm model Type from config.propeties
     *
     * @return electric Farm model
     */
    public String getElectricFrameModelType() {
        final String electricsFrameModelType = properties.getProperty("electricsFrameModelType");
        if (electricsFrameModelType == null) {
            System.err.println("Electrics Frame Model Type not specified in the config.properties file.");
        }
        return electricsFrameModelType;
    }

    /**
     * Gets Socket Application from config.propeties
     *
     * @return Socket Application
     */
    public String getSocketApplication() {
        final String socketApplication = properties.getProperty("socketApplication");
        if (socketApplication == null) {
            System.err.println("SocketApplication not specified in the config.properties file.");
        }
        return socketApplication;
    }

    /**
     * Gets Socket one Execution from config.propeties
     *
     * @return Socket one Execution
     */
    public String getSocketOneExecution() {
        final String socktOneExecution = properties.getProperty("socktOneExecution");
        if (socktOneExecution == null) {
            System.err.println("Sockt One Execution not specified in the config.properties file.");
        }
        return socktOneExecution;
    }

    /**
     * Gets Socket Two Execution from config.propeties
     *
     * @return Socket Two Execution
     */
    public String getSocketTwoExecution() {
        final String socketTwoExecution = properties.getProperty("socketTwoExecution");
        if (socketTwoExecution == null) {
            System.err.println("Sockt Two Execution not specified in the config.properties file.");
        }
        return socketTwoExecution;
    }

    /**
     * Gets Socket Application Model from config.propeties
     *
     * @return Socket Application Model
     */
    public String getSocketApplicationModel() {
        final String socketApplicationModel = properties.getProperty("socketApplicationModel");
        if (socketApplicationModel == null) {
            System.err.println("Socket Application Model not specified in the config.properties file.");
        }
        return socketApplicationModel;
    }

    /**
     * Gets Socket Switchable from config.propeties
     *
     * @return Socket Switchable
     */
    public String getSocketSwitchable() {
        final String socketSwitchable = properties.getProperty("socketSwitchable");
        if (socketSwitchable == null) {
            System.err.println("Socket Switchable not specified in the config.properties file.");
        }
        return socketSwitchable;
    }

    /**
     * Gets Socket SeparatCircuite from config.propeties
     *
     * @return Socket SeparateCircuite
     */
    public String getSocketSeparateCircuit() {
        final String socketSeparateCircuit = properties.getProperty("socketSeparateCircuit");
        if (socketSeparateCircuit == null) {
            System.err.println("Socket SeparateCircuit not specified in the config.properties file.");
        }
        return socketSeparateCircuit;
    }

    /**
     * Gets Socket Connection from config.propeties
     *
     * @return Socket Connection
     */
    public String getSocketConnectionType() {
        final String socketConnectionType = properties.getProperty("socketConnectionType");
        if (socketConnectionType == null) {
            System.err.println("Socket Connection Type not specified in the config.properties file.");
        }
        return socketConnectionType;
    }

    /**
     * Gets Electricplus name from config.propeties
     *
     * @return Electricplus name
     */
    public String getElectricPlusName() {
        final String electricPlusName = properties.getProperty("electricPlusName");
        if (electricPlusName == null) {
            System.err.println("Electric Plus Name not specified in the config.properties file.");
        }
        return electricPlusName;
    }

    /**
     * Gets Electricplus Category from config.propeties
     *
     * @return Electricplus category
     */
    public String getElectricPlusCategroy() {
        final String electricPlusCategory = properties.getProperty("electricPlusCategory");
        if (electricPlusCategory == null) {
            System.err.println("Electric Plus Category not specified in the config.properties file.");
        }
        return electricPlusCategory;
    }

    /**
     * Gets Electricplus component from config.propeties
     *
     * @return Electricplus component
     */
    public String getElectricPlusComponent() {
        final String electricPlusComponent = properties.getProperty("electricPlusComponent");
        if (electricPlusComponent == null) {
            System.err.println("eElectric Plus Component not specified in the config.properties file.");
        }
        return electricPlusComponent;
    }

    /**
     * Gets Sensor name from config.propeties
     *
     * @return Sensor name
     */
    public String getSensorName() {
        final String sensorName = properties.getProperty("sensorName");
        if (sensorName == null) {
            System.err.println("Sensor Name not specified in the config.properties file.");
        }
        return sensorName;
    }

    /**
     * Gets Sensor Category from config.propeties
     *
     * @return Sensor category
     */
    public String getSensorCategory() {
        final String sensorCategory = properties.getProperty("sensorCategory");
        if (sensorCategory == null) {
            System.err.println("Sensor Categorye not specified in the config.properties file.");
        }
        return sensorCategory;
    }

    /**
     * Gets Sensor Connection from config.propeties
     *
     * @return Sensor connection
     */
    public String getSensorConnection() {
        final String sensorConnection = properties.getProperty("sensorConnection");
        if (sensorConnection == null) {
            System.err.println("Sensor Connection not specified in the config.properties file.");
        }
        return sensorConnection;
    }

    /**
     * Gets Sensor Mounting from config.propeties
     *
     * @return Sensor Mounting
     */
    public String getSensorMounting() {
        final String sensorMounting = properties.getProperty("sensorMounting");
        if (sensorMounting == null) {
            System.err.println("Sensor Mounting not specified in the config.properties file.");
        }
        return sensorMounting;
    }

    /**
     * Gets Sanitary Name from config.propeties
     *
     * @return Sanitary Name
     */
    public String getSanitaryName() {
        final String sanitaryName = properties.getProperty("sanitaryName");
        if (sanitaryName == null) {
            System.err.println("Sanitary Name not specified in the config.properties file.");
        }
        return sanitaryName;
    }

    /**
     * Get Sanitary variant from config.propeties
     *
     * @return Sanitary Variant
     */
    public String getSanitaryVariant() {
        final String sanitaryVariant = properties.getProperty("sanitaryVariant");
        if (sanitaryVariant == null) {
            System.err.println("Sanitary Variant not specified in the config.properties file.");
        }
        return sanitaryVariant;
    }

    /**
     * Gets Sanitary ArticleNr from config.propeties
     *
     * @return Sanitary ArticleNr
     */
    public String getSanitaryArticleNr() {
        final String sanitaryArticleNr = properties.getProperty("sanitaryArticleNr");
        if (sanitaryArticleNr == null) {
            System.err.println("Sanitary ArticleNr not specified in the config.properties file.");
        }
        return sanitaryArticleNr;
    }

    /**
     * Gets Sanitary Description from config.propeties
     *
     * @return Sanitary Description
     */
    public String getSanitaryDescription() {
        final String sanitaryDescription = properties.getProperty("sanitaryDescription");
        if (sanitaryDescription == null) {
            System.err.println("Sanitary Description not specified in the config.properties file.");
        }
        return sanitaryDescription;
    }

    /**
     * Gets Sanitary Type from config.propeties
     *
     * @return Sanitary type
     */
    public String getSanitaryType() {
        final String sanitaryType = properties.getProperty("sanitaryType");
        if (sanitaryType == null) {
            System.err.println("Sanitary Type not specified in the config.properties file.");
        }
        return sanitaryType;
    }

    /**
     * Gets Sanitary unit from config.propeties
     *
     * @return Sanitary unit
     */
    public String getSanitaryUnit() {
        final String sanitaryUnit = properties.getProperty("sanitaryUnit");
        if (sanitaryUnit == null) {
            System.err.println("Sanitary Unit not specified in the config.properties file.");
        }
        return sanitaryUnit;
    }

    /**
     * Gets sanitary unit price from config.propeties
     *
     * @return sanitary unit price
     */
    public String getSanitaryUnitPrice() {
        final String sanitaryUnitPrice = properties.getProperty("sanitaryUnitPrice");
        if (sanitaryUnitPrice == null) {
            System.err.println("Sanitary Unit price not specified in the config.properties file.");
        }
        return sanitaryUnitPrice;
    }

    /**
     * Gets sanitary installations price
     *
     * @return Sanitary installations price from config.propeties
     */
    public String getSanitaryInstallationsPrice() {
        final String sanitaryInstallationsPrice = properties.getProperty("sanitaryInstallationsPrice");
        if (sanitaryInstallationsPrice == null) {
            System.err.println("Sanitary installations price not specified in the config.properties file.");
        }
        return sanitaryInstallationsPrice;
    }

    /**
     * Gets download path from config.propeties
     *
     * @return download path
     */
    public String getDownloadPath() {
        final String downloadPath = properties.getProperty("downloadPath");
        if (downloadPath == null) {
            System.err.println("Download Path not specified in the config.properties file.");
        }
        return downloadPath;
    }

    /**
     * Gets File name from config.propeties
     *
     * @return File name
     */
    public String getFileName() {
        final String fileName = properties.getProperty("fileName");
        if (fileName == null) {
            System.err.println("File name not specified in the config.properties file.");
        }
        return fileName;
    }

    /**
     * Gets building type from config.propeties
     *
     * @return building type
     */
    public String getBuildingType() {
        final String buildingType = properties.getProperty("buildingType");
        if (buildingType == null) {
            System.err.println("Buildig type not specified in the config.properties file.");
        }
        return buildingType;
    }

    /**
     * Gets building net floor area from config.propeties
     *
     * @return building net floor area
     */
    public String getBuildigNetFloorArea() {
        final String netFoorArea = properties.getProperty("netFoorArea");
        if (netFoorArea == null) {
            System.err.println("Buildig net floor area not specified in the config.properties file.");
        }
        return netFoorArea;
    }

    /**
     * Gets building situation from config.propeties
     *
     * @return building situation
     */
    public String getBuildigSituation() {
        final String builidnSituation = properties.getProperty("builidnSituation");
        if (builidnSituation == null) {
            System.err.println("Buildig situation floor area not specified in the config.properties file.");
        }
        return builidnSituation;
    }

    /**
     * Gets building shape from config.propeties
     *
     * @return building shape
     */
    public String getBuildigShape() {
        final String buildingShape = properties.getProperty("buildingShape");
        if (buildingShape == null) {
            System.err.println("Buildig shape floor area not specified in the config.properties file.");
        }
        return buildingShape;
    }

    /**
     * Gets housing unit description from config.propeties
     *
     * @return housing unit description
     */
    public String getHousingUnitDescription() {
        final String housingUnitDescription = properties.getProperty("housingUnitDescription");
        if (housingUnitDescription == null) {
            System.err.println("Housing Unit Description not specified in the config.properties file.");
        }
        return housingUnitDescription;
    }

    /**
     * Gets housing net using area from config.propeties
     *
     * @return housing net using area
     */
    public String getHousingUnitNetUsingArea() {
        final String housingUnitNetUsingArea = properties.getProperty("housingUnitNetUsingArea");
        if (housingUnitNetUsingArea == null) {
            System.err.println("Housing Unit net area not specified in the config.properties file.");
        }
        return housingUnitNetUsingArea;
    }

    /**
     * Gets housing unit residents from config.propeties
     *
     * @return housing unit residents
     */
    public String getHousingUnitResidents() {
        final String housingUnitResidents = properties.getProperty("housingUnitResidents");
        if (housingUnitResidents == null) {
            System.err.println("Housing Unit residents not specified in the config.properties file.");
        }
        return housingUnitResidents;
    }

    /**
     * Gets cellar type from config.propeties
     *
     * @return cellar type
     */
    public String getCellarType() {
        final String cellarType = properties.getProperty("cellarType");
        if (cellarType == null) {
            System.err.println("Cellar Type not specified in the config.properties file.");
        }
        return cellarType;
    }

    /**
     * Gets cellar heating type from config.propeties
     *
     * @return heating type
     */
    public String getCellarHeatingType() {
        final String cellarHeatingType = properties.getProperty("cellarHeatingType");
        if (cellarHeatingType == null) {
            System.err.println("Cellar heating Type not specified in the config.properties file.");
        }
        return cellarHeatingType;
    }

    /**
     * Gets cellar base plate concrete type from config.propeties
     *
     * @return concrete type
     */
    public String getCellarBasePlateConcreteType() {
        final String cellarBasePlateConcreteType = properties.getProperty("cellarBasePlateConcreteType");
        if (cellarBasePlateConcreteType == null) {
            System.err.println("Cellar Base Plate ConcreteType not specified in the config.properties file.");
        }
        return cellarBasePlateConcreteType;
    }

    /**
     * Gets cellar insulation type from config.propeties
     *
     * @return insulation type
     */
    public String getCellarBasePlateInsulationType() {
        final String cellarBasePlateInsulationType = properties.getProperty("cellarBasePlateInsulationType");
        if (cellarBasePlateInsulationType == null) {
            System.err.println("Cellar Base Plate Insulation Type not specified in the config.properties file.");
        }
        return cellarBasePlateInsulationType;
    }

    /**
     * Gets cellar u value from config.propeties
     *
     * @return u value
     */
    public String getCellarUvalue() {
        final String cellarUValue = properties.getProperty("cellarUValue");
        if (cellarUValue == null) {
            System.err.println("Cellar U Value not specified in the config.properties file.");
        }
        return cellarUValue;
    }

    /**
     * Gets cellar net floor area from config.propeties
     *
     * @return floor area
     */
    public String getCellarNetFloorArea() {
        final String cellarNetFloorArea = properties.getProperty("cellarNetFloorArea");
        if (cellarNetFloorArea == null) {
            System.err.println("Cellar Net Floor Area not specified in the config.properties file.");
        }
        return cellarNetFloorArea;
    }

    /**
     * Gets cellar floor height from config.propeties
     *
     * @return floor height
     */
    public String getCellarFloorHeight() {
        final String cellarFloorHeight = properties.getProperty("cellarFloorHeight");
        if (cellarFloorHeight == null) {
            System.err.println("Cellar Floor Height not specified in the config.properties file.");
        }
        return cellarFloorHeight;
    }

    /**
     * Gets cellar thickness from config.propeties
     *
     * @return cellar thickness
     */
    public String getCellarBasePlateThickness() {
        final String cellarBasePlateThickness = properties.getProperty("cellarBasePlateThickness");
        if (cellarBasePlateThickness == null) {
            System.err.println("Cellar Base Plate Thickness not specified in the config.properties file.");
        }
        return cellarBasePlateThickness;
    }

    /**
     * Gets cellar insulation thickness from config.propeties
     *
     * @return insulation thickness
     */
    public String getCellarInsulationThickness() {
        final String cellarInsulationThickness = properties.getProperty("cellarInsulationThickness");
        if (cellarInsulationThickness == null) {
            System.err.println("Cellar Insulation Thickness not specified in the config.properties file.");
        }
        return cellarInsulationThickness;
    }

    /**
     * Gets spinner max value from from config.propeties
     *
     * @return max value
     */
    public String getSpinnerMaxValueToCheck() {
        final String spinnerMaxValue = properties.getProperty("spinnerMaxValueToCheck");
        if (spinnerMaxValue == null) {
            System.err.println("Spinner max value not specified in the config.properties file.");
        }
        return spinnerMaxValue;

    }

    /**
     * Gets spinner min value from from config.propeties
     *
     * @return min value
     */
    public String getSpinnerMinValueToCheck() {
        final String spinnerMinValue = properties.getProperty("spinnerMinValueToCheck");
        if (spinnerMinValue == null) {
            System.err.println("Spinner min value not specified in the config.properties file.");
        }
        return spinnerMinValue;
    }

    /**
     * Gets spinner max value from from config.propeties
     *
     * @return max value
     */
    public String getSpinnerMaxValue() {
        final String spinnerMaxValue = properties.getProperty("spinnerMaxValue");
        if (spinnerMaxValue == null) {
            System.err.println("Spinner max value not specified in the config.properties file.");
        }
        return spinnerMaxValue;

    }

    /**
     * Gets spinner min value from from config.propeties
     *
     * @return min value
     */
    public String getSpinnerMinValue() {
        final String spinnerMinValue = properties.getProperty("spinnerMinValue");
        if (spinnerMinValue == null) {
            System.err.println("Spinner min value not specified in the config.properties file.");
        }
        return spinnerMinValue;
    }

    /**
     * Gets floor height from config.properties
     *
     * @return floor height
     */
    public String getSpinnerFloorHeight() {
        final String spinnerFloorHeight = properties.getProperty("spinnerFloorHeight");
        if (spinnerFloorHeight == null) {
            System.err.println("Spinne floor height specified in the config.properties file.");
        }
        return spinnerFloorHeight;
    }

    /**
     * Gets roof shape from config.properties
     *
     * @return roof shape
     */
    public String getRoofShape() {
        final String roofShape = properties.getProperty("roofShape");
        if (roofShape == null) {
            System.err.println("Roof shape not specified in the config.properties file.");
        }
        return roofShape;
    }

    /**
     * Gets roof heating from config.properties
     *
     * @return roof heating
     */
    public String getRoofHeating() {
        final String roofHeating = properties.getProperty("roofHeating");
        if (roofHeating == null) {
            System.err.println("Roof heating not specified in the config.properties file.");
        }
        return roofHeating;
    }

    /**
     * Gets roof pitch from config.properties
     *
     * @return roof pitch
     */
    public String getRoofPitch() {
        final String roofPitch = properties.getProperty("roofPitch");
        if (roofPitch == null) {
            System.err.println("Roof pitch not specified in the config.properties file.");
        }
        return roofPitch;
    }

    /**
     * Gets roof height from config.properties
     *
     * @return roof height
     */
    public String getRoofHeight() {
        final String roofHeight = properties.getProperty("roofHeight");
        if (roofHeight == null) {
            System.err.println("Roof height not specified in the config.properties file.");
        }
        return roofHeight;
    }

    /**
     * Gets roof insulation type
     *
     * @return insulation type
     */
    public String getRoofInsulationType() {
        final String roofInsulationType = properties.getProperty("roofInsulationType");
        if (roofInsulationType == null) {
            System.err.println("Roof insulation type not specified in the config.properties file.");
        }
        return roofInsulationType;
    }

    /**
     * Gets roof u value from config.properties
     *
     * @return u value
     */
    public String getRoofUValue() {
        final String roofUValue = properties.getProperty("roofUValue");
        if (roofUValue == null) {
            System.err.println("Roof u value type not specified in the config.properties file.");
        }
        return roofUValue;
    }

    /**
     * Gets Air ventilation system from config.properties
     *
     * @return ventilation system
     */
    public String getAirVentilationSystem() {
        final String airventilationSystem = properties.getProperty("airventilationSystem");
        if (airventilationSystem == null) {
            System.err.println("Air ventilation system not specified in the config.properties file.");
        }
        return airventilationSystem;
    }

    /**
     * Gets pv plant type from config.properties
     *
     * @return pv plant type
     */
    public String getPvPlantType() {
        final String pvPlantType = properties.getProperty("pvPlantType");
        if (pvPlantType == null) {
            System.err.println("Pv Plant Typenot specified in the config.properties file.");
        }
        return pvPlantType;
    }

    /**
     * Gets pv module type from config.properties
     *
     * @return module type
     */
    public String getPvModuleType() {
        final String pvModuleType = properties.getProperty("pvModuleType");
        if (pvModuleType == null) {
            System.err.println("Pv Module Type not specified in the config.properties file.");
        }
        return pvModuleType;
    }

    /**
     * Gets pvManufacturer type from config.properties
     *
     * @return pv manufacturer
     */
    public String getPvManufacturer() {
        final String pvManufacturer = properties.getProperty("pvManufacturer");
        if (pvManufacturer == null) {
            System.err.println("Pv Manufacturer not specified in the config.properties file.");
        }
        return pvManufacturer;
    }

    /**
     * Gets pv count from config.properties
     *
     * @return count
     */
    public String getPvCount() {
        final String pvCount = properties.getProperty("pvCount");
        if (pvCount == null) {
            System.err.println("Pv count not specified in the config.properties file.");
        }
        return pvCount;
    }

    /**
     * pv model
     *
     * @return pv model from config.properties
     */
    public String getPvModel() {
        final String pvModel = properties.getProperty("pvModel");
        if (pvModel == null) {
            System.err.println("Pv model not specified in the config.properties file.");
        }
        return pvModel;
    }

    /**
     * Gets pv power from config.properties
     *
     * @return pv power
     */
    public String getPvPower() {
        final String pvPower = properties.getProperty("pvPower");
        if (pvPower == null) {
            System.err.println("Pv power not specified in the config.properties file.");
        }
        return pvPower;
    }

    /**
     * Gets output from config.properties
     *
     * @return output
     */
    public String getOutputWithPrice() {
        final String outputWithPirce = properties.getProperty("outputWithPirce");
        if (outputWithPirce == null) {
            System.err.println("Output With Pirce not specified in the config.properties file.");
        }
        return outputWithPirce;

    }

    /**
     * Gets output from config.properties
     *
     * @return output
     */
    public String getOutputWithoutPrice() {
        final String outputWithoutPrice = properties.getProperty("outputWithoutPrice");
        if (outputWithoutPrice == null) {
            System.err.println("Outpt Without Pirce not specified in the config.properties file.");
        }
        return outputWithoutPrice;
    }

    /**
     * Gets file name from m config.properties
     *
     * @return file name
     */
    public String getFileNameAutomationAndElectric() {
        final String fileNameAutomationAndElectric = properties.getProperty("fileNameAutomationAndElectric");
        if (fileNameAutomationAndElectric == null) {
            System.err.println("File Name Automation And Electric not specified in the config.properties file.");
        }
        return fileNameAutomationAndElectric;

    }

    /**
     * Gets file name from m config.properties
     *
     * @return file name
     */
    public String getFileNameAutomation() {
        final String fileNameAutomation = properties.getProperty("fileNameAutomation");
        if (fileNameAutomation == null) {
            System.err.println("File Name Automation  not specified in the config.properties file.");
        }
        return fileNameAutomation;

    }

    /**
     * Gets file name from config.properties
     *
     * @return file name
     */
    public String getFileNameElectric() {
        final String fileNameElectric = properties.getProperty("fileNameElectric");
        if (fileNameElectric == null) {
            System.err.println("File Name Electric  not specified in the config.properties file.");
        }
        return fileNameElectric;
    }

    /**
     * Gets Email from from config.properties
     *
     * @return Email
     */
    public String getEmailSender() {
        final String emailSender = properties.getProperty("emailSender");
        if (emailSender == null) {
            System.err.println("Email sender not specified in the config.properties file.");
        }
        return emailSender;
    }

    /**
     * Gets Password from from config.properties
     *
     * @return password
     */
    public String getPasswordSender() {
        final String emaiPassword = properties.getProperty("emaiPassword");
        if (emaiPassword == null) {
            System.err.println("Email password not specified in the config.properties file.");
        }
        return emaiPassword;
    }

    /**
     * Gets Email from from config.properties
     *
     * @return Email
     */
    public String getEmailRecipient() {
        final String emailRecipient = properties.getProperty("emailRecipient");
        if (emailRecipient == null) {
            System.err.println("Email not specified in the config.properties file.");
        }
        return emailRecipient;
    }

}
