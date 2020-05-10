package gregtech.common.tools;

import gregtech.api.enums.Textures;
import gregtech.api.interfaces.IIconContainer;

public class GT_Tool_Drill_MV
        extends GT_Tool_Drill_RangeBase {

    @Override
    int setToolDamagePerBlockBreak() {
        return 200;
    }

    @Override
    int setToolDamagePerDropConversion() {
        return 400;
    }

    @Override
    int setToolDamagePerContainerCraft() {
        return 3200;
    }

    @Override
    int setToolDamagePerEntityAttack() {
        return 800;
    }

    @Override
    int setBaseQuality() {
        return 1;
    }

    @Override
    float setBaseDamage() {
        return 2.5F;
    }

    @Override
    float setSpeedMultiplier() {
        return 6.0F;
    }

    @Override
    float setMaxDurabilityMultiplier() {
        return 2.0F;
    }

    @Override
    IIconContainer setIcon() {
        return Textures.ItemIcons.POWER_UNIT_MV;
    }

    @Override
    byte RangeWidthandDepth() {
        return 1; //3х3x3 (-1..1)
    }

    @Override
    byte RangeHeight() {
        return 1; //3х3x3 (-1..1)
    }

    @Override
    String setRange() {
        return "3x3x3";
    }

    @Override
    int setTier(){
        return 1;
    }
}
