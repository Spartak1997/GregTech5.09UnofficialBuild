package gregtech.api.interfaces;

import gregtech.api.enums.SubTag;
import net.minecraft.item.ItemStack;


public interface IProjectileItem {
    public boolean hasProjectile(SubTag aProjectileType, ItemStack aStack);
}