package gregtech.common.tools;

import gregtech.api.enums.Textures;
import gregtech.api.interfaces.IIconContainer;

public class GT_Tool_Drill_HV
        extends GT_Tool_Drill_RangeBase {

    @Override
    int setToolDamagePerBlockBreak() {
        return 400;
    }

    @Override
    int setToolDamagePerDropConversion() {
        return 800;
    }

    @Override
    int setToolDamagePerContainerCraft() {
        return 6400;
    }

    @Override
    int setToolDamagePerEntityAttack() {
        return 1600;
    }

    @Override
    int setBaseQuality() {
        return 1;
    }

    @Override
    float setBaseDamage() {
        return 3.0F;
    }

    @Override
    float setSpeedMultiplier() {
        return 9.0F;
    }

    @Override
    float setMaxDurabilityMultiplier() {
        return 4.0F;
    }

    @Override
    IIconContainer setIcon() {
        return Textures.ItemIcons.POWER_UNIT_HV;
    }

    @Override
    byte RangeWidthandDepth() {
        return 2; //5х5x5 (-2..2)
    }

    @Override
    byte RangeHeight() {
        return 3; //5х5x5 (-1..3)
    }

    @Override
    String setRange() {
        return "5x5x5";
    }

    @Override
    int setTier(){
        return 2;
    }
}
