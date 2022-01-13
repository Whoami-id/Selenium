
package configuratorTestSuite1;

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
     * Gets Postalcode from config.propeties
     *
     * @return Postalcode
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
     * Gets Constructiontype from config.propeties
     *
     * @return Constructiontype
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
    public String getWallName() {
        final String wallName = properties.getProperty("wallName20");
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
     * Gets Walltype form config.propeties
     *
     * @return Walltype
     */
    public String getWallType() {
        final String wallType = properties.getProperty("wallType");
        if (wallType == null) {
            System.err.println("WallType not specified in the config.properties file.");
        }
        return wallType;
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
     * @return Windowname
     */
    public String getWindowName() {
        final String windowName = properties.getProperty("windowName");
        if (windowName == null) {
            System.err.println("WindowName not specified in the config.properties file.");
        }
        return windowName;
    }

    /**
     * Gets Windowtype from config.propeties
     *
     * @return Windowtype
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
     * Gets Shadingtype form config.propeties
     *
     * @return Shadingtype
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
     * Gets Doorname from config.propeties
     *
     * @return Doorname
     */
    public String getDoorName() {
        final String doorName = properties.getProperty("doorName");
        if (doorName == null) {
            System.err.println("Door name not specified in the config.properties file.");
        }
        return doorName;
    }

    /**
     * Gets Doormaterial from config.propeties
     *
     * @return Doormaterial
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
     * Gets Doortype from config.propeties
     *
     * @return Doortype
     */
    public String getDoorType() {
        final String doorType = properties.getProperty("doorType");
        if (doorType == null) {
            System.err.println("Door Type not specified in the config.properties file.");
        }
        return doorType;
    }

    /**
     * Gets Doorcategory from config.propeties
     *
     * @return Doorcategory
     */
    public String getDoorCategory() {
        final String doorCategory = properties.getProperty("doorCategory");
        if (doorCategory == null) {
            System.err.println("Door category not specified in the config.properties file.");
        }
        return doorCategory;
    }

    /**
     * Gets Doorcontroltype from config.propeties
     *
     * @return Doorcontroltype
     */
    public String getDoorControlType() {
        final String doorControlType = properties.getProperty("doorControlType");
        if (doorControlType == null) {
            System.err.println("Door controltype not specified in the config.properties file.");
        }
        return doorControlType;
    }

    /**
     * Gets Doorlock from config.propeties
     *
     * @return Doorlock
     */
    public String getDoorLockType() {
        final String doorLock = properties.getProperty("doorLock");
        if (doorLock == null) {
            System.err.println("Door locktype not specified in the config.properties file.");
        }
        return doorLock;
    }

    /**
     * Gets Dooropeningsidetype from config.propeties
     *
     * @return Dooropeningsidetype
     */
    public String getDoorOpeningSideType() {
        final String doorOpeningSideType = properties.getProperty("doorOpeningSideType");
        if (doorOpeningSideType == null) {
            System.err.println("Door opening side type not specified in the config.properties file.");
        }
        return doorOpeningSideType;
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
     * Gets Socket Three Execution from config.propeties
     *
     * @return Socket Three Execution
     */
    public String getSocketThreeExecution() {
        final String socketThreExecution = properties.getProperty("socketThreExecution");
        if (socketThreExecution == null) {
            System.err.println("Sockt Three Execution not specified in the config.properties file.");
        }
        return socketThreExecution;
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

}
