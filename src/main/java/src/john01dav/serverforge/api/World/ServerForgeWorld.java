package src.john01dav.serverforge.api.World;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import java.util.concurrent.ConcurrentHashMap;

public class ServerForgeWorld{
    private static ConcurrentHashMap<Integer, ServerForgeWorld> worldIndex = new ConcurrentHashMap<Integer, ServerForgeWorld>();
    private World world;

    /**
     * Returns the world for the specified dimension ID
     * @param dimId the dimension ID to query
     * @return the queried world
     */
    public static ServerForgeWorld get(int dimId){
        ServerForgeWorld serverForgeWorld = worldIndex.get(dimId);

        if(serverForgeWorld == null){
            World world = MinecraftServer.getServer().worldServerForDimension(dimId);
            serverForgeWorld = new ServerForgeWorld(world);
            worldIndex.put(dimId, serverForgeWorld);
        }

        return serverForgeWorld;
    }

    private ServerForgeWorld(World world){
        this.world = world;
    }

    /**
     * Returns the instance representing the type of the block at the specified coordinates
     * @param x the x coordinate
     * @param y the y coordinate
     * @param z the z coordinate
     * @return The Block instance representing the block at the specified coordinates
     */
    public ServerForgeBlock getBlockTypeAt(int x, int y, int z){
        return ServerForgeBlock.get(world.getBlock(x, y, z));
    }

    /**
     * Sets the block type at the specified location
     * @param x the x coordinate
     * @param y the y coordinate
     * @param z the z coordinate
     * @param type The type to set at the specified coordinates
     */
    public void setBlockAt(int x, int y, int z, ServerForgeBlock type){
        world.setBlock(x, y, z, type.block);
    }

}
