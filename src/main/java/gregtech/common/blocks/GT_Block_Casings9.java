package gregtech.common.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Textures;
import gregtech.api.objects.GT_CopiedBlockTexture;
import gregtech.api.util.GT_LanguageManager;
import gregtech.api.util.GT_Utility;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class GT_Block_Casings9
        extends GT_Block_Casings_Abstract {
    public GT_Block_Casings9() {
        super(GT_Item_Casings9.class, "gt.blockcasings9", GT_Material_Casings.INSTANCE);
        GT_Utility.addTexturePage((byte) 2);
        for (int i = 0; i < 16; i = (byte) (i + 1)) {
            Textures.BlockIcons.casingTexturePages[2][i] = new GT_CopiedBlockTexture(this, 6, i);
        }
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".0.name", "Cleanroom Glass");

        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".15.name", "Solid Frame Casing");

        ItemList.Cleanroom_Glass.set(new ItemStack(this, 1, 0));

        ItemList.Solid_Frame_Box.set(new ItemStack(this, 1, 15));

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
            return Textures.BlockIcons.BLOCK_PLASCRETE_GLASS.getIcon();
        case 15:
            return Textures.BlockIcons.BLOCK_SOLID_FRAME_BOX.getIcon();
        }
        return Textures.BlockIcons.BLOCK_PLASCRETE_GLASS.getIcon();
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess aWorld, int aX, int aY, int aZ, int aSide)
    {
        Block block = aWorld.getBlock(aX, aY, aZ);

        if (this == Blocks.glass || this instanceof GT_Block_Casings9)
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
