package src.john01dav.serverforge.plugin;
import src.john01dav.serverforge.ServerForge;
import src.john01dav.serverforge.api.CommandSender;
import src.john01dav.serverforge.api.ServerForgeCommand;
import src.john01dav.serverforge.loader.PluginWrapper;

import java.util.ArrayList;

public class PluginsCommand implements ServerForgeCommand{

    @Override
    public void onCommand(CommandSender sender, String[] args){
        ArrayList<PluginWrapper> plugins = ServerForge.instance.getPluginLoader().getPlugins();

        sender.sendMessage("Plugins (" + plugins.size() + ")");
        for(PluginWrapper w : plugins){
            sender.sendMessage(" " + w.getName());
        }
    }
}
