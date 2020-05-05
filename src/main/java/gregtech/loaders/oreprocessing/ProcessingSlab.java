package gregtech.loaders.oreprocessing;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

public class ProcessingSlab implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingSlab() {
        OrePrefixes.slab.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack) {

    }
}
