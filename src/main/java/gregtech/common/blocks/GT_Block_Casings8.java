package gregtech.common.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Textures;
import gregtech.api.objects.GT_CopiedBlockTexture;
import gregtech.api.util.GT_LanguageManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.Facing;
import net.minecraft.world.IBlockAccess;

public class GT_Block_Casings8
        extends GT_Block_Casings_Abstract {
    public GT_Block_Casings8() {
        super(GT_Item_Casings8.class, "gt.blockcasings8", GT_Material_Casings.INSTANCE);
        for (int i = 0; i < 16; i = (i + 1)) {
            Textures.BlockIcons.casingTexturePages[1][i+48] = new GT_CopiedBlockTexture(this, 6, i);
        }
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".0.name", "Chemically Inert Machine Casing");
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".1.name", "PTFE Pipe Casing");
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".2.name", "Pyrolyse Oven Casing");
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".3.name", "HSLA Machine Casing");
        //GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".4.name", "Plastic Casing");
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".5.name", "Coke Oven Brick");

        ItemList.Casing_Chemically_Inert.set(new ItemStack(this, 1, 0));
        ItemList.Casing_Pipe_Polytetrafluoroethylene.set(new ItemStack(this, 1, 1));
        ItemList.Casing_Pyrolyse.set(new ItemStack(this, 1, 2));
        ItemList.Casing_HSLA.set(new ItemStack(this, 1, 3));
        //ItemList.PlasticCasing.set(new ItemStack(this, 1, 4));
        ItemList.Casing_CokeOvenBrick.set(new ItemStack(this, 1, 5));

    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int aSide, int aMeta) {
        switch (aMeta) {
        case 0:
            return Textures.BlockIcons.MACHINE_CASING_CHEMICALLY_INERT.getIcon();
        case 1:
            return Textures.BlockIcons.MACHINE_CASING_PIPE_POLYTETRAFLUOROETHYLENE.getIcon();
        case 2:
            return Textures.BlockIcons.MACHINE_8V_SIDE.getIcon();
        case 3:
            return Textures.BlockIcons.MACHINE_CASING_HSLA.getIcon();
        case 4:
            //Do not overwrite!
            return Textures.BlockIcons.BLOCK_PLASCRETE.getIcon();
        case 5:
            return Textures.BlockIcons.BLOCK_COKE_OVEN_BRICK.getIcon();
        }
        return Textures.BlockIcons.MACHINE_CASING_ROBUST_TUNGSTENSTEEL.getIcon();
    }
}
