package src.john01dav.serverforge.permissions;
import src.john01dav.serverforge.api.Player;

public interface PermissionsHandler{

    /**
     * Returns whether or not this permission handler has a setting for the specified permission on the specified player
     * @param player The player tp be looked up
     * @param permission The permission tp be looked up
     * @return whether or not this permission is set
     */
    public boolean isPermissionSet(Player player, String permission);

    /**
     * Returns the value of the permission for the specified player
     * @param player The player tp be looked up
     * @param permission The permission tp be looked up
     * @return
     */
    public boolean getPermission(Player player, String permission);

}
