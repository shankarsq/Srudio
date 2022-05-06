package studio.automate.test.app.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class LoadPropUtils {
public static Properties prop =null;

    
    public static void loadProperty(String propFileLocaton) {
        try (InputStream input = new FileInputStream(propFileLocaton)) {

            prop = new Properties();

            // load a properties file
            prop.load(input);
            System.out.println("LoadPropUtils:::Loaded property file ::::"+prop.getProperty("app.email.host"));
            // get the property value and print it out
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Properties getProperties() {
        return prop;
    }
    
    public static String getPropValue(String propertyKey){
        return prop.getProperty(propertyKey);
    }

}
