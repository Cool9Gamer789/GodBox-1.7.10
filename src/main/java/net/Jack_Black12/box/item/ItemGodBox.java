package net.Jack_Black12.box.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGodBox extends Item {
    public ItemGodBox() {
        // Start the parent class
        super();

        // Set the UnlocalizedName
        this.setUnlocalizedName("godbox");

        // Set the texture name
        this.setTextureName("box:motherbox");

        // Set the item inside the creative tab in tools
        this.setCreativeTab(CreativeTabs.tabTools);

        // Make it so you can only hold 1 godbox
        this.setMaxStackSize(1);
    }
    @Override
    public ItemStack onItemRightClick (ItemStack stack, World world, EntityPlayer player) {
        // Check if on server side
        if (!world.isRemote) {
            // First item in hotbar
            ItemStack firstHotbarItem = player.inventory.mainInventory[0];

            // If the first item is not nothing or the Godbox
            if (firstHotbarItem != null && firstHotbarItem.getItem() != this) {
                // Get the max stack size for this item type
                int maxStackSize = firstHotbarItem.getItem().getItemStackLimit();

                // Loop through player's main inventory (slots 0-35)
                // Slots 0-8: Hotbar
                // Slots 9-35: Main inventory grid
                for (int i = 0; i < player.inventory.mainInventory.length; i++) {
                    // Check if the slot is empty
                    if (player.inventory.mainInventory[i] == null) {
                        // Create a copy of the first item in hotbar
                        ItemStack firstItemCopy = firstHotbarItem.copy();

                        // Set the stack to max
                        firstItemCopy.stackSize = maxStackSize;

                        // Place the copied item (with the stack) in the empty slot
                        player.inventory.mainInventory[i] = firstItemCopy;
                    }
                }
                // Send the update to client side
                player.inventoryContainer.detectAndSendChanges();
            }
        }
        // Return the godbox stack unchanged
        return stack;
    }
}
