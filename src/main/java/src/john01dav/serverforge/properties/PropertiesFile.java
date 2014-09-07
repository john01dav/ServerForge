package src.john01dav.serverforge.properties;
import src.john01dav.serverforge.ServerForge;
import src.john01dav.serverforge.loader.PluginWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
    private PluginWrapper wrapper;
    private Properties properties;
    private Properties defaultProperties;
    private String name;
    private String comment;
    private File file;

    public PropertiesFile(PluginWrapper wrapper, String name, Properties defaultProperties) throws IOException{
        this.wrapper = wrapper;
        this.name = name;
        this.defaultProperties = defaultProperties;

        file = new File(wrapper.getPluginFolder(), name);

        refreshProperties();
    }

    /**
     * Sets the comment to be placed above the properties in the properties file
     * @param comment The comment to be placed
     */
    public void setComment(String comment){
        this.comment = comment;
    }

    /**
     * Returns the comment for this properties file, see setComment(String) for more details
     * @return The comment
     */
    public String getComment(){
        return comment;
    }

    /**
     * Reloads the properties from the disk, disregarding what is currently loaded
     */
    public void refreshProperties() throws IOException{
        if(!file.exists()) {
            properties = defaultProperties;
            saveProperties();
        }

        FileInputStream fileInputStream = new FileInputStream(file);
        properties = new Properties();
        properties.load(fileInputStream);
        fileInputStream.close();
    }

    /**
     * Saves the properties to the disk, overwriting whatever may already be there
     */
    public void saveProperties() throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        properties.store(fileOutputStream, comment);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    public Properties getProperties(){
        return properties;
    }

}
