package gregtech.common.tools;

import gregtech.api.enums.Textures;
import gregtech.api.interfaces.IIconContainer;

public class GT_Tool_Drill_EV
        extends GT_Tool_Drill_RangeBase {

    @Override
    int setToolDamagePerBlockBreak() {
        return 800;
    }

    @Override
    int setToolDamagePerDropConversion() {
        return 1600;
    }

    @Override
    int setToolDamagePerContainerCraft() {
        return 12800;
    }

    @Override
    int setToolDamagePerEntityAttack() {
        return 3200;
    }

    @Override
    int setBaseQuality() {
        return 1;
    }

    @Override
    float setBaseDamage() {
        return 3.5F;
    }

    @Override
    float setSpeedMultiplier() {
        return 12.0F;
    }

    @Override
    float setMaxDurabilityMultiplier() {
        return 8.0F;
    }

    @Override
    IIconContainer setIcon() {
        return Textures.ItemIcons.POWER_UNIT_EV;
    }

    @Override
    byte RangeWidthandDepth() {
        return 3; //7х7x7 (-3..3)
    }

    @Override
    byte RangeHeight() {
        return 5; //7х7x7 (-1..5)
    }

    @Override
    String setRange() {
        return "7x7x7";
    }

    @Override
    int setTier(){
        return 3;
    }
}