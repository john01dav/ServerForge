package src.john01dav.serverforge.events;
import net.minecraftforge.common.MinecraftForge;
import src.john01dav.serverforge.ServerForge;

import java.util.ArrayList;

public class EventManager{
    private ArrayList<EventListenerWrapper> listeners;

    public void onServerStart(){
        ServerForge.info("Starting events");
        listeners = new ArrayList<EventListenerWrapper>();
        ServerForge.info("Starting forge listener");
        DefaultEventListener defaultEventListener = new DefaultEventListener(this);
        MinecraftForge.EVENT_BUS.register(defaultEventListener);
    }

    /**
     * Registers an event listener to have it's methods called when an event is fired
     * @param listener The listener to register
     */
    public void registerEventListener(EventListener listener){
        EventListenerWrapper wrapper = new EventListenerWrapper(listener);
        listeners.add(wrapper);
    }

    /**
     * Fires an event
     * @param o The event to fire
     */
    public void fireEvent(Object o){
        for(EventListenerWrapper wrapper : listeners){
            wrapper.callEvent(o);
        }
    }

}
