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
        for (int i = 0; i < 5; i = (i + 1)) {
            Textures.BlockIcons.casingTexturePages[1][i+48] = new GT_CopiedBlockTexture(this, 6, i);
        }
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".0.name", "Chemically Inert Machine Casing");
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".1.name", "PTFE Pipe Casing");
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".2.name", "Pyrolyse Oven Casing");
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".3.name", "Glass Casing");
        //GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".4.name", "Plastic Casing");

        ItemList.Casing_Chemically_Inert.set(new ItemStack(this, 1, 0));
        ItemList.Casing_Pipe_Polytetrafluoroethylene.set(new ItemStack(this, 1, 1));
        ItemList.Casing_Pyrolyse.set(new ItemStack(this, 1, 2));
        ItemList.GlassCasing1.set(new ItemStack(this, 1, 3));
        //ItemList.PlasticCasing.set(new ItemStack(this, 1, 4));

        setLightOpacity(0);
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
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
            return Textures.BlockIcons.BLOCK_PLASCRETE_GLASS.getIcon();
        case 4:
            //Do not overwrite!
            return Textures.BlockIcons.BLOCK_PLASCRETE.getIcon();
        }
        return Textures.BlockIcons.MACHINE_CASING_ROBUST_TUNGSTENSTEEL.getIcon();
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess aWorld, int aX, int aY, int aZ, int aSide)
    {
        Block block = aWorld.getBlock(aX, aY, aZ);

        if (this == Blocks.glass || this instanceof GT_Block_Casings8)
        {
            if (aWorld.getBlockMetadata(aX, aY, aZ) != aWorld.getBlockMetadata(aX - Facing.offsetsXForSide[aSide], aY - Facing.offsetsYForSide[aSide], aZ - Facing.offsetsZForSide[aSide]))
            {
                return true;
            }
            if(aWorld.getBlockMetadata(aX, aY, aZ)==0)
                return true;

            if (block == this)
            {
                return false;
            }
        }

        return false;
    }

    @Override
    public int getRenderBlockPass() {
        return 0;
    }

}
