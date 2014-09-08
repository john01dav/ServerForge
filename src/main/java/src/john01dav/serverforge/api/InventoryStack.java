package src.john01dav.serverforge.api;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;

public class InventoryStack{
    private ItemStack stack;

    public InventoryStack(ItemStack stack){
        this.stack = stack;
    }

    public InventoryStack(EntityItem entity){
        this(entity.getEntityItem());
    }

    /**
     * Sets this stack's display name
     * @param displayName the new display name
     */
    public void setDisplayName(String displayName){
        stack.setStackDisplayName(displayName);
    }

    /**
     * Returns this stack's display name
     * @return This stack's display name
     */
    public String getDisplayname(){
        return stack.getDisplayName();
    }


}
