package src.john01dav.serverforge.loader;
import src.john01dav.serverforge.api.*;

public class PluginWrapper {
    private ServerForgePlugin serverForgeMod;
    private String name;

    public PluginWrapper(ServerForgePlugin serverForgeMod, String name){
        this.serverForgeMod = serverForgeMod;
        serverForgeMod.wrapper = this;
        this.name = name;
    }

    public ServerForgePlugin getPlugin(){
        return serverForgeMod;
    }
    public String getName(){
        return name;
    }

}
