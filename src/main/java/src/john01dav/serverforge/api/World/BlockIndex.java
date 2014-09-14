package src.john01dav.serverforge.api.World;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockIndex {

    public static ServerForgeBlock getBlock(String modId, String name){
        return ServerForgeBlock.get(GameRegistry.findBlock(modId, name));
    }

}
