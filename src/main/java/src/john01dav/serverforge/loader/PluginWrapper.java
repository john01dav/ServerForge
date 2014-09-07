package src.john01dav.serverforge.loader;
import src.john01dav.serverforge.ServerForge;
import src.john01dav.serverforge.api.*;

import java.io.File;

public class PluginWrapper {
    private ServerForgePlugin serverForgeMod;
    private String name;
    private File pluginFolder;

    public PluginWrapper(ServerForgePlugin serverForgeMod, String name){
        this.serverForgeMod = serverForgeMod;
        serverForgeMod.wrapper = this;
        this.name = name;

        //make sure that the plugins folder exists as a folder
        pluginFolder = new File(ServerForge.instance.getPluginLoader().getPluginsFolder(), name);

        if(!pluginFolder.exists()){
            pluginFolder.mkdir();
        }
    }

    public ServerForgePlugin getPlugin(){
        return serverForgeMod;
    }
    public String getName(){
        return name;
    }

    public File getPluginFolder(){
        return pluginFolder;
    }

}