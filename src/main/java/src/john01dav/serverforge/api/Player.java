package src.john01dav.serverforge.api;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import java.util.UUID;

public class Player{
    private EntityPlayer entityPlayer;

    public Player(EntityPlayer entityPlayer){
        this.entityPlayer = entityPlayer;
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

}
