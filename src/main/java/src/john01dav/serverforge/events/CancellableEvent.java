package src.john01dav.serverforge.events;

public interface CancellableEvent {

    public void setCancelled(boolean cancelled);
    public boolean getCancelled();

}
