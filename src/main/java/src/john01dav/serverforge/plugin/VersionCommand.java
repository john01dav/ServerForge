package src.john01dav.serverforge.plugin;
import src.john01dav.serverforge.ServerForge;
import src.john01dav.serverforge.api.CommandSender;
import src.john01dav.serverforge.api.ServerForgeCommand;

public class VersionCommand implements ServerForgeCommand{

    @Override
    public void onCommand(CommandSender sender, String[] args) {
        sender.sendMessage("This server is running ServerForge " + ServerForge.VERSION + " running on Minecraft " + ServerForge.instance.getMinecraftVersion());
    }
}
