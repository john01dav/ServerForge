package src.john01dav.serverforge.api.entity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import src.john01dav.serverforge.api.Player;

public class EntityBase{
    private Entity entity;

    public EntityBase(Entity entity){
        this.entity = entity;
    }

    /**
     * Returns the player behind this entity, or null if this entity is not a player
     * @return The player behind this entity
     */
    public Player getPlayer(){
        if(entity instanceof EntityPlayer){
            EntityPlayer player = ((EntityPlayer) entity);
            return Player.get(player);
        }else{
            return null;
        }
    }

}
