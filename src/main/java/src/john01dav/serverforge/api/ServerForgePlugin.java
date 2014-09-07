package src.john01dav.serverforge.api;
import src.john01dav.serverforge.loader.PluginWrapper;

public abstract class ServerForgePlugin{
    public PluginWrapper wrapper;

    /**
     * Called when the server loads
     */
    public abstract void onServerStart();

    /**
     * Called when the server unloads
     */
    public abstract void onServerStop();

}
