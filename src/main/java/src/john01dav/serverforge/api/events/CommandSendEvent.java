package src.john01dav.serverforge.api.events;
import net.minecraftforge.event.CommandEvent;
import src.john01dav.serverforge.api.CommandSender;
import src.john01dav.serverforge.api.NativeCommandWrapper;
import src.john01dav.serverforge.api.ServerForgeCommand;
import src.john01dav.serverforge.events.CancellableEvent;

public class CommandSendEvent implements CancellableEvent{
    private CommandEvent commandEvent;
    private boolean cancelled = false;

    public CommandSendEvent(CommandEvent commandEvent){
        this.commandEvent = commandEvent;
        setCancelled(commandEvent.isCanceled());
    }

    /**
     * Returns the sender of this command
     * @return The sender of this command
     */
    public CommandSender getCommandSender(){
        return new CommandSender(commandEvent.sender);
    }

    /**
     * Returns the arguments of this command
     * @return The arguments of this command
     */
    public String[] getArgs(){
        return commandEvent.parameters;
    }

    /**
     * Returns the object representing this command
     * @return The object representing this command
     */
    public ServerForgeCommand getCommand(){
        return new NativeCommandWrapper(commandEvent.command);
    }

    public void setCancelled(boolean cancelled){
        this.cancelled = cancelled;
    }

    public boolean getCancelled(){
        return cancelled;
    }

}
