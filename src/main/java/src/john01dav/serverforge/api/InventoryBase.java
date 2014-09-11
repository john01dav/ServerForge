package src.john01dav.serverforge.api;
import net.minecraft.inventory.IInventory;

public class InventoryBase{
    private IInventory inventory;

    public InventoryBase(IInventory inventory){
        this.inventory = inventory;

    }

    /**
     * Sets the item at the specified slot
     * @param x the slot
     * @param stack the itemS
     */
    public void setItemAt(int x, InventoryStack stack){
        inventory.setInventorySlotContents(x, stack.stack);
    }

    /**
     * returns the item at the specified slots
     * @param x the slot to query
     * @return the item at x
     */
    public InventoryStack getItemAt(int x){
        return new InventoryStack(inventory.getStackInSlot(x));
    }

}
