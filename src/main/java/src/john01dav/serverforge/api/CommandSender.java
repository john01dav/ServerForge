package src.john01dav.serverforge.api;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class CommandSender {
    private ICommandSender forgeSender;

    public CommandSender(ICommandSender forgeSender){
        this.forgeSender = forgeSender;
    }

    /**
     * Sends a message to this commandsender
     * @param message The message to send
     */
    public void sendMessage(String message){
        forgeSender.addChatMessage(new ChatComponentText(message));
    }

    /**
     * Returns the name of the commandsender, "RCon" for a console
     * @return The name of this commandsender
     */
    public String getName(){
        return forgeSender.getCommandSenderName();
    }

    /**
     * Returns the player that sent this command, or null if it was not a player
     * @return The player who sent this command
     */
    public Player getPlayer(){
        if(forgeSender instanceof EntityPlayer){
            EntityPlayer entity = ((EntityPlayer) forgeSender);
            return new Player(entity);
        }else{
            return null;
        }
    }

}
