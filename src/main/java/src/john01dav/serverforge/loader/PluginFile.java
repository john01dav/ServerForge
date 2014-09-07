package src.john01dav.serverforge.loader;
import java.io.*;
import java.net.URL;
import java.util.Properties;
import java.util.zip.*;

public class PluginFile{
    private File file;
    private URL url;
    private String mainClass;
    private Properties properties;

    public PluginFile(){}

    public PluginFile(File file){
        try {
            this.file = file;
            url = new URL("file://" + file.getAbsolutePath());

            ZipFile zipFile = new ZipFile(file.getAbsolutePath());
            ZipEntry entry = zipFile.getEntry("plugindata.txt");
            InputStream inputStream = zipFile.getInputStream(entry);
            properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
            zipFile.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public URL getURL(){
        return url;
    }

    public String getName(){
        return properties.getProperty("name");
    }

    public String getMainClass(){
        return properties.getProperty("mainClass");
    }

}
