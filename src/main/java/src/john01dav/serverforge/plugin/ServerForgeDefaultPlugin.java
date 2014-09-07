package src.john01dav.serverforge.plugin;
import src.john01dav.serverforge.ServerForge;
import src.john01dav.serverforge.api.ServerForgePlugin;

public class ServerForgeDefaultPlugin extends ServerForgePlugin{

    @Override
    public void onServerStart(){
        ServerForge.instance.registerCommand("version", new VersionCommand());
        ServerForge.instance.registerCommand("plugins", new PluginsCommand());
    }

    @Override
    public void onServerStop(){

    }

}
