package game.utilities;

import java.io.*;
import java.util.Properties;

public class Config {

    Properties properties = new Properties();
    String fileName = "config.properties";

    public Config() {
        loadConfig();
    }

    private void loadConfig() {
        var path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + fileName;
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            properties.load(fileInputStream);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (InvalidClassException e) {
            System.out.println("InvalidClassException: " + e.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
    }

    public String getProperty(String name) {
        return properties.getProperty(name);
    }

}
