package src.john01dav.serverforge.api.World;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockIndex {

    /**
     * Returns the instance of ServerForgeBlock class that represents the modId and name that are passed in. Use "minecraft" as the modId for vanilla blocks
     * @param modId modId of the mod that owns the block, "minecraft" for vanilla blocks
     * @param name the internal name of the block
     * @return the block specified by the parameters, or null of no such block is found
     */
    public static ServerForgeBlock getBlock(String modId, String name){
        return ServerForgeBlock.get(GameRegistry.findBlock(modId, name)); // ServerForgeBlock.get() returns null if a null block is passed in
    }

}
