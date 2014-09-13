package src.john01dav.serverforge.api;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.WorldSettings;
import src.john01dav.serverforge.ServerForge;

import java.util.HashMap;
import java.util.UUID;

public class Player{
    private static HashMap<UUID, Player> playerEntities = new HashMap<UUID, Player>();
    private EntityPlayer entityPlayer;
    private InventoryBase inventory;

    public enum GameMode{
        SURVIVAL,
        CREATIVE,
        ADVENTURE
    }

    private Player(EntityPlayer entityPlayer){
        this.entityPlayer = entityPlayer;
        inventory = new InventoryBase(this.entityPlayer.inventory);
    }

    public static Player get(EntityPlayer player){
        Player c = playerEntities.get(player.getUniqueID());
        if(c == null){
            Player np = new Player(player);
            playerEntities.put(player.getUniqueID(), np);
            return np;
        }else{
            return c;
        }
    }

    /**
     * Returns the name of this player
     * @return The name of this player
     */
    public String getName(){
        return entityPlayer.getCommandSenderName();
    }

    /**
     * Returns the Mojang Specified UUID of this player, or a hash of their name if the server is in offline mode
     * @return The player's UUID
     */
    public UUID getUUID(){
        return entityPlayer.getUniqueID();
    }

    /**
     * Teleports the player to the specified location
     * @param x The x coordinate of the location to teleport the player to
     * @param y The y coordinate of the location to teleport the player to
     * @param z The z coordinate of the location to teleport the player to
     */
    public void teleport(double x, double y, double z){
        entityPlayer.setPosition(x, y, z);
        EntityPlayerMP mpPlayer = ((EntityPlayerMP) entityPlayer);
        mpPlayer.playerNetServerHandler.setPlayerLocation(x, y, z, mpPlayer.cameraYaw, mpPlayer.cameraPitch);
    }

    /**
     * Sets the yaw and pitch of the player's camera
     * @param yaw The yaw to set for this player
     * @param pitch The pitch to set for this player
     */
    public void setCameraAngles(float yaw, float pitch){
        EntityPlayerMP mpPlayer = ((EntityPlayerMP) entityPlayer);
        mpPlayer.playerNetServerHandler.setPlayerLocation(mpPlayer.posX, mpPlayer.posY, mpPlayer.posZ, yaw, pitch);
    }

    /**
     * Sends the message passed into this method to the player's chat box
     * @param message The message to send to the player
     */
    public void sendMessage(String message){
        entityPlayer.addChatMessage(new ChatComponentText(message));
    }

    /**
     * Returns the value for the permission of this player
     * @param permission the permission to lookup
     * @return the value of the permission
     */
    public boolean getPermission(String permission) {
        return ServerForge.instance.getPermissionsManager().getPermission(((EntityPlayerMP) entityPlayer), permission);
    }

    public InventoryBase getInventory(){
        return inventory;
    }

    /**
     * Sets this player's current gamemode
     * @param mode the new gamemode
     */
    public void setGameMode(GameMode mode){
        EntityPlayerMP mpPlayer = ((EntityPlayerMP) entityPlayer);
        switch(mode){
            case SURVIVAL:
                mpPlayer.setGameType(WorldSettings.GameType.SURVIVAL);
            break;
            case CREATIVE:
                mpPlayer.setGameType(WorldSettings.GameType.CREATIVE);
            break;
            case ADVENTURE:
                mpPlayer.setGameType(WorldSettings.GameType.ADVENTURE);
            break;
        }
    }

}
