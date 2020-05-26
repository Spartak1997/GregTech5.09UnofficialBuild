package gregtech.common.items.behaviors;

import gregtech.api.items.GT_MetaBase_Item;
import gregtech.api.util.GT_LanguageManager;
import gregtech.api.util.GT_Utility;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

import static gregtech.api.util.GT_Utility.ItemNBT.*;
import static gregtech.api.util.GT_Utility.ItemNBT.setDrillRangeMode;

public class Behaviour_Drill
        extends Behaviour_None {
    private final String mRange;
    private int mTier;

    private final String mTooltip = GT_LanguageManager.addStringLocalization("gt.behaviour.drill", "Digs in the region");

    public Behaviour_Drill(String aRange, int aTier) {
        this.mRange = aRange;
        this.mTier = aTier;
    }

    public boolean onItemUseFirst(GT_MetaBase_Item aItem, ItemStack aStack, EntityPlayer aPlayer, World aWorld, int aX, int aY, int aZ, int aSide, float hitX, float hitY, float hitZ) {
        if (aWorld.isRemote) {
            return false;
        } else {
            if (aPlayer.isSneaking()) {
                int toolMode = getDrillRangeMode(aStack);
                ++toolMode;
                if (toolMode > mTier) {
                    toolMode = 0;
                }

                setDrillRangeMode(aStack, toolMode);
                if (toolMode == 0) {
                    GT_Utility.sendChatToPlayer(aPlayer, EnumChatFormatting.YELLOW + GT_LanguageManager.addStringLocalization("gt.behaviour.drillmode0", "Normal mode"));
                }
                if (toolMode == 1) {
                    GT_Utility.sendChatToPlayer(aPlayer, EnumChatFormatting.GREEN + GT_LanguageManager.addStringLocalization("gt.behaviour.drillmode1", "Range mode: 3x3"));
                }
                if (toolMode == 2) {
                    GT_Utility.sendChatToPlayer(aPlayer, EnumChatFormatting.GREEN + GT_LanguageManager.addStringLocalization("gt.behaviour.drillmode2", "Range mode: 5x5"));
                }
                if (toolMode == 3) {
                    GT_Utility.sendChatToPlayer(aPlayer, EnumChatFormatting.GREEN + GT_LanguageManager.addStringLocalization("gt.behaviour.drillmode3", "Range mode: 7x7"));
                }
                if (toolMode == 4) {
                    GT_Utility.sendChatToPlayer(aPlayer, EnumChatFormatting.GREEN + GT_LanguageManager.addStringLocalization("gt.behaviour.drillmode4", "Range mode: 9x9"));
                }
            }
            return true;
        }
    }

    public boolean onItemRightClick(GT_MetaBase_Item aItem, ItemStack aStack, EntityPlayer aPlayer, World aWorld, int aX, int aY, int aZ, int aSide, float hitX, float hitY, float hitZ) {
        if (aWorld.isRemote) {
            return false;
        } else {
            if (aPlayer.isSneaking()) {
                int toolMode = getDrillRangeMode(aStack);
                ++toolMode;
                if (toolMode > mTier) {
                    toolMode = 0;
                }

                setDrillRangeMode(aStack, toolMode);

                if (toolMode == 0) {
                    GT_Utility.sendChatToPlayer(aPlayer, EnumChatFormatting.YELLOW + GT_LanguageManager.addStringLocalization("gt.behaviour.drillmode0", "Normal mode"));
                }
                if (toolMode == 1) {
                    GT_Utility.sendChatToPlayer(aPlayer, EnumChatFormatting.GREEN + GT_LanguageManager.addStringLocalization("gt.behaviour.drillmode1", "Range mode: 3x3"));
                }
                if (toolMode == 2) {
                    GT_Utility.sendChatToPlayer(aPlayer, EnumChatFormatting.GREEN + GT_LanguageManager.addStringLocalization("gt.behaviour.drillmode2", "Range mode: 5x5"));
                }
                if (toolMode == 3) {
                    GT_Utility.sendChatToPlayer(aPlayer, EnumChatFormatting.GREEN + GT_LanguageManager.addStringLocalization("gt.behaviour.drillmode3", "Range mode: 7x7"));
                }
                if (toolMode == 4) {
                    GT_Utility.sendChatToPlayer(aPlayer, EnumChatFormatting.GREEN + GT_LanguageManager.addStringLocalization("gt.behaviour.drillmode4", "Range mode: 9x9"));
                }
            }
            return true;
        }
    }

    public List<String> getAdditionalToolTips(GT_MetaBase_Item aItem, List<String> aList, ItemStack aStack) {
        int mode = getDrillRangeMode(aStack);
        aList.add(EnumChatFormatting.WHITE + GT_LanguageManager.addStringLocalization("gt.behaviour.drillmode", "Mode") + ": " +EnumChatFormatting.GREEN+ (mode == 1? "3x3x3": mode == 2? "5x5x5": mode == 3? "7x7x7": mode == 4? "9x9x9": GT_LanguageManager.addStringLocalization("gt.behaviour.drillnormal", "Normal")));
        aList.add(this.mTooltip + ": " + this.mRange);
        aList.add(GT_LanguageManager.addStringLocalization("gt.behaviour.drill1", "Shift + Right click on the block to change the mode"));
        return aList;
    }
}
