package gregtech.common.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ItemDebug extends Item {

    private static final ItemDebug DebugItem = new ItemDebug();

    private ItemDebug() {
        // I am a singleton
    }

    public static ItemDebug getInstance() {
        return DebugItem;
    }

    public void registerItem() {
        super.setHasSubtypes(false);
        final String unlocalizedName = "debug_item";
        super.setUnlocalizedName(unlocalizedName);
        super.setMaxStackSize(64);
        super.setTextureName("gregtech" + ":" + "Error");
        GameRegistry.registerItem(getInstance(), unlocalizedName);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b) {
        list.add("If this item shows up, you may report it to:");
        list.add("https://discord.gg/bMf2qvd");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
        player.swingItem();
        return item;
    }
}