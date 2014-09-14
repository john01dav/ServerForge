package src.john01dav.serverforge.api.events;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import src.john01dav.serverforge.api.Player;
import src.john01dav.serverforge.events.CancellableEvent;

public class InteractEvent implements CancellableEvent{
    public static final int AIR_FACE = -1;
    public static final int TOP_FACE = 1;
    public static final int BOTTOM_FACE = 0;
    public static final int SIDE1_FACE = 2;
    public static final int SIDE2_FACE = 3;
    public static final int SIDE3_FACE = 4;
    public static final int SIDE4_FACE = 5;
    public static final int RIGHT_CLICK_BLOCK = 6;
    public static final int RIGHT_CLICK_AIR = 6;
    public static final int LEFT_CLICK_BLOCK = 6;
    private PlayerInteractEvent playerInteractEvent;
    private Player player;
    private int action;
    private boolean cancelled = false;

    public InteractEvent(PlayerInteractEvent playerInteractEvent){
        this.playerInteractEvent = playerInteractEvent;

        switch(playerInteractEvent.action){
            case RIGHT_CLICK_BLOCK:
                action = RIGHT_CLICK_BLOCK;
            break;
            case RIGHT_CLICK_AIR:
                action = RIGHT_CLICK_AIR;
            break;
            case LEFT_CLICK_BLOCK:
                action = LEFT_CLICK_BLOCK;
            break;
        }

        player = Player.get(playerInteractEvent.entityPlayer);
        setCancelled(playerInteractEvent.isCanceled());
    }

    public void setCancelled(boolean cancelled){
        this.cancelled = cancelled;
    }

    public boolean getCancelled(){
        return cancelled;
    }

    /**
     * Returns the X coordinate this event happens at
     * @return the X coordinate this event happens at
     */
    public int getX(){
        return playerInteractEvent.x;
    }

    /**
     * Returns the Y coordinate this event happens at
     * @return the Y coordinate this event happens at
     */
    public int getY(){
        return playerInteractEvent.y;
    }

    /**
     * Returns the Z coordinate this event happens at
     * @return the Z coordinate this event happens at
     */
    public int getZ(){
        return playerInteractEvent.z;
    }

    /**
     * Returns the face that is being clicked, refer to the integer constants on this class for more details
     * @return The face that is being clicked
     */
    public int getFace(){
        return playerInteractEvent.face;
    }

    /**
     * Returns whether or not an air block is being clicked
     * @return whether or not an air block is being clicked
     */
    public boolean isAir(){
        if(playerInteractEvent.useBlock == Event.Result.DEFAULT){
            return false;
        }else{
            return true;
        }
    }

    /**
     * Returns the action that was done to trigger this event, see the integer constants on this class for more details
     * @return the action that was done to trigger this event
     */
    public int getAction(){
        return action;
    }

    /**
     * Returns the player associated with this event
     * @return The player associated with this event
     */
    public Player getPlayer(){
        return player;
    }

}
