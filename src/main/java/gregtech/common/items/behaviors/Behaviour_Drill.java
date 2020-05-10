package gregtech.common.items.behaviors;

import gregtech.api.items.GT_MetaBase_Item;
import gregtech.api.util.GT_LanguageManager;
import net.minecraft.item.ItemStack;

import java.util.List;

public class Behaviour_Drill
        extends Behaviour_None {
    private final String mRange;

    private final String mTooltip = GT_LanguageManager.addStringLocalization("gt.behaviour.drill", "Digs in the region");

    public Behaviour_Drill(String aRange) {
        this.mRange = aRange;
    }

    public List<String> getAdditionalToolTips(GT_MetaBase_Item aItem, List<String> aList, ItemStack aStack) {
        aList.add(this.mTooltip + ": " + this.mRange);
        return aList;
    }
}
