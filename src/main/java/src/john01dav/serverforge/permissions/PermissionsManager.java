package src.john01dav.serverforge.permissions;
import net.minecraft.entity.player.EntityPlayerMP;
import src.john01dav.serverforge.api.Player;
import java.util.ArrayList;

public class PermissionsManager{
    private ArrayList<PermissionsHandler> handlerIndex;

    public void onServerStart(){
        handlerIndex = new ArrayList<PermissionsHandler>();
    }

    /**
     * Registers the specified permissionhandler in the system
     * @param permissionsHandler The permissionhandler to be registered
     */
    public void registerPermissionsHandler(PermissionsHandler permissionsHandler){
        handlerIndex.add(permissionsHandler);
    }

    //using entityplayermp to encourage use of the method in the src.john01dav.serverforge.api.Player class
    public boolean getPermission(EntityPlayerMP playerMP, String permission){
        Player player = Player.get(playerMP);

        for(PermissionsHandler handler : handlerIndex){
            if(handler.isPermissionSet(player, permission)){
                return handler.getPermission(player, permission);
            }
        }

        return false;
    }


}
