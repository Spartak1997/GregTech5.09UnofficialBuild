package gregtech.common.tools;

import gregtech.api.enums.Textures;
import gregtech.api.interfaces.IIconContainer;

public class GT_Tool_Drill_IV
        extends GT_Tool_Drill_RangeBase {

    @Override
    int setToolDamagePerBlockBreak() {
        return 25600;
    }

    @Override
    int setToolDamagePerDropConversion() {
        return 25600;
    }

    @Override
    int setToolDamagePerContainerCraft() {
        return 204800;
    }

    @Override
    int setToolDamagePerEntityAttack() {
        return 51200;
    }

    @Override
    int setBaseQuality() {
        return 1;
    }

    @Override
    float setBaseDamage() {
        return 4.0F;
    }

    @Override
    float setSpeedMultiplier() {
        return 15.0F;
    }

    @Override
    float setMaxDurabilityMultiplier() {
        return 16.0F;
    }

    @Override
    IIconContainer setIcon() {
        return Textures.ItemIcons.POWER_UNIT_IV;
    }

    @Override
    byte RangeWidthandDepth() {
        return 4; //9x9x9 (-4..4)
    }

    @Override
    byte RangeHeight() {
        return 7; //9x9x9 (-1..7)
    }

    @Override
    String setRange() {
        return "9x9x9";
    }
}
