package src.john01dav.serverforge.api.events;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import src.john01dav.serverforge.api.Player;

public class PlayerDeathEvent {
    private PlayerDropsEvent playerDropsEvent;
    private boolean cancelled = false;

    public PlayerDeathEvent(PlayerDropsEvent playerDropsEvent){
        this.playerDropsEvent = playerDropsEvent;
        setCancelled(playerDropsEvent.isCanceled());
    }

    /**
     * Returns the player associated with this event
     * @return the player associated with this event
     */
    public Player getPlayer(){
        return Player.get(playerDropsEvent.entityPlayer);
    }

    public void setCancelled(boolean cancelled){
        this.cancelled = cancelled;
    }

    public boolean getCancelled(){
        return cancelled;
    }

}
