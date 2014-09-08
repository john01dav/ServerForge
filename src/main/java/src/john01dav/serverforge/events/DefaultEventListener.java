package src.john01dav.serverforge.events;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import src.john01dav.serverforge.ServerForge;
import src.john01dav.serverforge.api.Player;
import src.john01dav.serverforge.api.events.ChatEvent;
import src.john01dav.serverforge.api.events.CommandSendEvent;
import src.john01dav.serverforge.api.events.JoinWorldEvent;

public class DefaultEventListener{
    private EventManager eventManager;

    public DefaultEventListener(EventManager eventManager){
        ServerForge.info("Instantiating forge listener");
        this.eventManager = eventManager;
    }

    @SubscribeEvent
    public void serverChatEvent(ServerChatEvent e){
        ChatEvent event = new ChatEvent(e);

        eventManager.fireEvent(event);

        e.setCanceled(true);

        if(!event.getCancelled()){
            for (Player player : ServerForge.instance.getOnlinePlayers()) {
                player.sendMessage(event.getChatFormat());
            }
        }
    }

    @SubscribeEvent
    public void commandEvent(CommandEvent e){
        CommandSendEvent commandSendEvent = new CommandSendEvent(e);
        eventManager.fireEvent(e);
        e.setCanceled(commandSendEvent.getCancelled());
    }

    @SubscribeEvent
    public void entityJoinWorldEvent(EntityJoinWorldEvent e){
        JoinWorldEvent joinWorldEvent = new JoinWorldEvent(e);
        eventManager.fireEvent(joinWorldEvent);
    }

}
