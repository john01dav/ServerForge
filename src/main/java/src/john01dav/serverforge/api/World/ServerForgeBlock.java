package src.john01dav.serverforge.api.World;
import net.minecraft.block.Block;
import java.util.concurrent.ConcurrentHashMap;

public class ServerForgeBlock {
    private static ConcurrentHashMap<String, ServerForgeBlock> blockIndex = new ConcurrentHashMap<String, ServerForgeBlock>();
    protected Block block;

    public static ServerForgeBlock get(Block block){
        String name = block.getUnlocalizedName();
        ServerForgeBlock oldBlock = blockIndex.get(name);
        if(oldBlock == null){
            ServerForgeBlock newBlock = new ServerForgeBlock(block);
            blockIndex.put(name, newBlock);
            return newBlock;
        }else{
            return oldBlock;
        }
    }

    private ServerForgeBlock(Block block){
        this.block = block;
    }

}
