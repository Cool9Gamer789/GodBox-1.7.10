package net.Jack_Black12.box;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.Jack_Black12.box.item.ItemGodBox;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = GodBox.MODID, version = GodBox.VERSION)
public class GodBox
{
    public static final String MODID = "box";
    public static final String VERSION = "1.0";

    // Declare the item field
    public static ItemGodBox godboxItem;

    @EventHandler
    public void init(FMLPreInitializationEvent event) {
        // Register items in preInit phase
        godboxItem = new ItemGodBox();
        GameRegistry.registerItem(godboxItem, godboxItem.getUnlocalizedName());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // WORK HERE
    }
}
