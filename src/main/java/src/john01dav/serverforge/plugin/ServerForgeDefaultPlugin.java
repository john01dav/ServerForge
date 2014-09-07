package src.john01dav.serverforge.plugin;
import src.john01dav.serverforge.ServerForge;
import src.john01dav.serverforge.api.ServerForgePlugin;
import src.john01dav.serverforge.properties.PropertiesFile;
import java.io.IOException;
import java.util.Properties;

public class ServerForgeDefaultPlugin extends ServerForgePlugin{
    private PropertiesFile propertiesFile;

    @Override
    public void onServerStart(){
        try {
            Properties defaultProperties = new Properties();
            defaultProperties.setProperty("enableVersion", String.valueOf(true));
            defaultProperties.setProperty("enablePlugins", String.valueOf(true));

            propertiesFile = new PropertiesFile(wrapper, "serverforgeplugin.properties", defaultProperties);

            if((Boolean.parseBoolean(propertiesFile.getProperties().getProperty("enableVersion")))){
                ServerForge.instance.registerCommand("version", new VersionCommand());
            }

            if((Boolean.parseBoolean(propertiesFile.getProperties().getProperty("enablePlugins")))){
                ServerForge.instance.registerCommand("plugins", new PluginsCommand());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onServerStop(){

    }

}
