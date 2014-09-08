package src.john01dav.serverforge.api.events;
import net.minecraftforge.event.ServerChatEvent;
import src.john01dav.serverforge.api.Player;
import src.john01dav.serverforge.events.CancellableEvent;

public class ChatEvent implements CancellableEvent{
    private ServerChatEvent serverChatEvent;
    private boolean cancelled = false;
    private String chatFormat = "%player%: %message%";
    private String message;
    private Player player;

    public ChatEvent(ServerChatEvent serverChatEvent){
        this.serverChatEvent = serverChatEvent;
        message = serverChatEvent.message;
        player = Player.get(serverChatEvent.player);
    }

    /**
     * Returns the player assiciated with this event
     * @return
     */
    private Player getPlayer(){
        return player;
    }

    /**
     * Returns this message as it will appear in chat (ie. including the <player>)
     * @return this message as it will appear in chat (ie. including the <player>)
     */
    public String getChatFormat(){
        return (chatFormat.replace("%player%", getPlayer().getName()).replace("%message%", message));
    }

    /**
     * Sets the message to be sent
     * @param message The message to be sent
     */
    public void setMessage(String message){
        this.message = message;
    }

    /**
     * Returns the message to be sent
     * @return The message to be sent
     */
    public String getMessage(){
        return message;
    }

    /**
     * Sets the chat format using the %player% and %message% parameters, for example:
     *   <%player%> %messsage
     * is the default chat format.
     * @param chatFormat
     */
    public void setChatFormat(String chatFormat){
        this.chatFormat = chatFormat;
    }

    @Override
    public void setCancelled(boolean cancelled){
        this.cancelled = cancelled;
    }

    @Override
    public boolean getCancelled(){
        return cancelled;
    }
}
