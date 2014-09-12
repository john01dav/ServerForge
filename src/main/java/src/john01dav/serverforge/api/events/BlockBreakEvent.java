package src.john01dav.serverforge.api.events;
import net.minecraftforge.event.world.BlockEvent;
import src.john01dav.serverforge.events.CancellableEvent;

public class BlockBreakEvent implements CancellableEvent{
    private boolean cancelled = false;
    private BlockEvent.BreakEvent breakEvent;

    public BlockBreakEvent(BlockEvent.BreakEvent breakEvent){
        this.breakEvent = breakEvent;
        setCancelled(breakEvent.isCanceled());
    }

    /**
     * Returns the x coordinate of the block about to be broken
     * @return the x coordinate
     */
    public int getX(){
        return breakEvent.x;
    }

    /**
     * Returns the y coordinate of the block about to be broken
     * @return the y coordinate
     */
    public int getY(){
        return breakEvent.y;
    }

    /**
     * Returns the y coordinate of the block about to be broken
     * @return the y coordinate
     */
    public int getZ(){
        return breakEvent.z;
    }

    public void setCancelled(boolean cancelled){
        this.cancelled = cancelled;
    }

    public boolean getCancelled(){
        return cancelled;
    }


}
