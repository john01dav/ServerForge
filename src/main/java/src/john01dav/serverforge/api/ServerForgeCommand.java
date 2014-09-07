package src.john01dav.serverforge.api;

public interface ServerForgeCommand {

    /**
     * Called when a command is executed
     * @param sender An object representing the player, console, or command block that sent the command
     * @param args The arguments of the command
     */
    public void onCommand(CommandSender sender, String[] args);

}
