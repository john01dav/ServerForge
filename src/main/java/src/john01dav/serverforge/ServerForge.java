package src.john01dav.serverforge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import src.john01dav.serverforge.api.Player;
import src.john01dav.serverforge.api.ServerForgeCommand;
import src.john01dav.serverforge.events.EventManager;
import src.john01dav.serverforge.loader.PluginLoader;
import src.john01dav.serverforge.permissions.PermissionsManager;

import java.util.ArrayList;

@Mod(modid = "ServerForge", name = "ServerForge", version = ServerForge.VERSION)
public class ServerForge{
    public static final String VERSION = "PRE-ALPHA 0.0.1";

    private EventManager eventManager;
    private PermissionsManager permissionsManager;
    private PluginLoader pluginLoader;

    private FMLServerStartingEvent serverStartingEvent;

    @Mod.Instance("ServerForge")
    public static ServerForge instance;

    public static void info(String info){
        System.out.println("[SERVERFORGE INFO]: " + info);
    }

    public static void error(String error){
        System.out.println("[SERVERFORGE ERROR]: " + error);
    }

    @Mod.EventHandler
    public void serverStartingEvent(FMLServerStartingEvent e){
        info("Starting ServerForge...");
        this.serverStartingEvent = e;

        eventManager = new EventManager();
        eventManager.onServerStart();

        permissionsManager = new PermissionsManager();
        permissionsManager.onServerStart();

        pluginLoader = new PluginLoader();
        pluginLoader.onServerStart();

        this.serverStartingEvent = null;
        info("ServerForge started");
    }

    /**
     * Registers a command for use in the server, can only be called from onServerStart() or it's submethods
     * @param name The name of the command to add, to be used as the name to execute (ie. name = "example", to type in chat = "/example")
     * @param command The command object to register
     * @param aliases Array containing the aliases for this command
     */
    public void registerCommand(String name, ServerForgeCommand command, String[] aliases){
        CommandWrapper wrapper = new CommandWrapper(name, command, aliases);
        serverStartingEvent.registerServerCommand(wrapper);
    }

    /**
     * Registers a command for use in the server, can only be called from onServerStart() or it's submethods
     * @param name The name of the command to add, to be used as the name to execute (ie. name = "example", to type in chat = "/example")
     * @param command The command object to register
     */
    public void registerCommand(String name, ServerForgeCommand command){
        registerCommand(name, command, new String[0]);
    }

    /**
     * Returns the plugin loader (the class responsible for the loading and management of plugins)
     * @return the plugin loader
     */
    public PluginLoader getPluginLoader(){
        return pluginLoader;
    }

    /**
     * Returns the event manager (the class responsible for the registering and calling of events)
     * @return The event manager
     */
    public EventManager getEventManager(){
        return eventManager;
    }

    /**
     * Returns the permissions manager (the class responsible for the setting and getting of player's permissions)
     * @return the permissions manager
     */
    public PermissionsManager getPermissionsManager(){
        return permissionsManager;
    }

    /**
     * Returns the Minecraft version running this server
     * @return The Minecraft version running this server
     */
    public String getMinecraftVersion(){
        return MinecraftForge.MC_VERSION;
    }

    /**
     * Returns all online players
     * @return All online players
     */
    public ArrayList<Player> getOnlinePlayers(){
        ArrayList<Player> list = new ArrayList<Player>();

        for(World world : MinecraftServer.getServer().worldServers){
            for(Object o : world.playerEntities){
                EntityPlayerMP playerMP = ((EntityPlayerMP) o);
                Player player = Player.get(playerMP);
                list.add(player);
            }
        }

        return list;
    }

}
