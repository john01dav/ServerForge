package src.john01dav.serverforge.api.events;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import src.john01dav.serverforge.api.entity.EntityBase;

public class JoinWorldEvent {
    private EntityJoinWorldEvent entityJoinWorldEvent;

    public JoinWorldEvent(EntityJoinWorldEvent entityJoinWorldEvent){
        this.entityJoinWorldEvent = entityJoinWorldEvent;
    }

    /**
     * Returns the entity whom is joining the world
     * @return The entity whom is joining the world
     */
    public EntityBase getEntity(){
        return new EntityBase(entityJoinWorldEvent.entity);
    }

}
