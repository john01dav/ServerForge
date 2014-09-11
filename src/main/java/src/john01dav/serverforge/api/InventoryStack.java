package src.john01dav.serverforge.api;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InventoryStack{
    protected ItemStack stack;

    public InventoryStack(ItemStack stack){
        this.stack = stack;
    }

    /**
     * Creates a new itemstack with the specified item id and data
     * @param itemID the item id to create this stack with
     * @param data the data to create this stack with
     */
    public InventoryStack(int itemID, byte data){
        this(new ItemStack(Item.getItemById(itemID), data));
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

    /**
     * Returns the internal name for this item
     * @return The internal name for this item
     */
    public String getInternalName(){
        return stack.getItem().getUnlocalizedName();
    }

    /**
     * Returns the maximum stack size of this item
     * @return the maximum stack size of this item
     */
    public int getMaxStackSize(){
        return stack.getMaxStackSize();
    }

    /**
     * Returns the maximum amount of damage this item can take
     * @return the maximum amount of damage this item can take
     */
    public int getMaxDamage(){
        return stack.getMaxDamage();
    }

    /**
     * Sets this item's current damage, set to 0 to repair set to getMaxDamage() to break
     * @param newDamage the damage value to set for this item
     */
    public void setDamage(int newDamage){
        stack.setItemDamage(newDamage);
    }

}
