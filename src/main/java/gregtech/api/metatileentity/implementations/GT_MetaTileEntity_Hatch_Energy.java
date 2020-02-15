package gregtech.api.metatileentity.implementations;

import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import static gregtech.api.enums.GT_Values.V;

public class GT_MetaTileEntity_Hatch_Energy extends GT_MetaTileEntity_Hatch {

    int mAmpers = 2;
    long mCapacity = 0;

    public GT_MetaTileEntity_Hatch_Energy(int aID, String aName, String aNameRegional, int aTier) {
        super(aID, aName, aNameRegional, aTier, 0, new String[]{"Energy Injector for Multiblocks", "Accepts up to " + EnumChatFormatting.YELLOW + "2" + EnumChatFormatting.GRAY + " Amp"});
    }

    public GT_MetaTileEntity_Hatch_Energy(String aName, int aTier, String aDescription, ITexture[][][] aTextures) {
        super(aName, aTier, 0, aDescription, aTextures);
    }

    public GT_MetaTileEntity_Hatch_Energy(String aName, int aTier, String[] aDescription, ITexture[][][] aTextures) {
        super(aName, aTier, 0, aDescription, aTextures);
    }

    public GT_MetaTileEntity_Hatch_Energy(int aID, String aName, String aNameRegional, int aTier, long aCapacity) {
        super(aID, aName, aNameRegional, aTier, 0, new String[]{"Energy Injector for Multiblocks", "Accepts up to " + EnumChatFormatting.YELLOW + "2" + EnumChatFormatting.GRAY + " Amp"});
        mCapacity = aCapacity;
    }

    public GT_MetaTileEntity_Hatch_Energy(String aName, int aTier, String aDescription, ITexture[][][] aTextures, long aCapacity) {
        super(aName, aTier, 0, aDescription, aTextures);
        mCapacity = aCapacity;
    }

    public GT_MetaTileEntity_Hatch_Energy(String aName, int aTier, String[] aDescription, ITexture[][][] aTextures, long aCapacity) {
        super(aName, aTier, 0, aDescription, aTextures);
        mCapacity = aCapacity;
    }

    public GT_MetaTileEntity_Hatch_Energy(int aID, String aName, String aNameRegional, int aTier, int aAmper) {
        super(aID, aName, aNameRegional, aTier, 0, new String[]{"Energy Injector for Multiblocks", "Accepts up to " + EnumChatFormatting.YELLOW + aAmper + EnumChatFormatting.GRAY + " Amp"});
        mAmpers = aAmper;
    }

    public GT_MetaTileEntity_Hatch_Energy(String aName, int aTier, String aDescription, ITexture[][][] aTextures, int aAmper) {
        super(aName, aTier, 0, aDescription, aTextures);
        mAmpers = aAmper;
    }

    public GT_MetaTileEntity_Hatch_Energy(String aName, int aTier, String[] aDescription, ITexture[][][] aTextures, int aAmper) {
        super(aName, aTier, 0, aDescription, aTextures);
        mAmpers = aAmper;
    }

    @Override
    public ITexture[] getTexturesActive(ITexture aBaseTexture) {
        return new ITexture[]{aBaseTexture, Textures.BlockIcons.OVERLAYS_ENERGY_IN_MULTI[mTier]};
    }

    @Override
    public ITexture[] getTexturesInactive(ITexture aBaseTexture) {
        return new ITexture[]{aBaseTexture, Textures.BlockIcons.OVERLAYS_ENERGY_IN_MULTI[mTier]};
    }

    @Override
    public boolean isSimpleMachine() {
        return true;
    }

    @Override
    public boolean isFacingValid(byte aFacing) {
        return true;
    }

    @Override
    public boolean isAccessAllowed(EntityPlayer aPlayer) {
        return true;
    }

    @Override
    public boolean isEnetInput() {
        return true;
    }

    @Override
    public boolean isInputFacing(byte aSide) {
        return aSide == getBaseMetaTileEntity().getFrontFacing();
    }

    @Override
    public boolean isValidSlot(int aIndex) {
        return false;
    }

    @Override
    public long getMinimumStoredEU() {
        return 512 * mAmpers;
    }

    @Override
    public long maxEUInput() {
        return V[mTier];
    }

    public long AmpInput(){
        return V[mTier] * mAmpers;
    }

    @Override
    public long maxEUStore() {
        return mCapacity == 0 ? 512L + V[mTier + 1] * 8L * mAmpers : mCapacity;
    }

    @Override
    public long maxAmperesIn() {
        return mAmpers;
    }

    @Override
    public MetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return mCapacity == 0
                ? new GT_MetaTileEntity_Hatch_Energy(mName, mTier, mDescriptionArray, mTextures, mAmpers)
                : new GT_MetaTileEntity_Hatch_Energy(mName, mTier, mDescriptionArray, mTextures, mCapacity);
    }

    @Override
    public boolean allowPullStack(IGregTechTileEntity aBaseMetaTileEntity, int aIndex, byte aSide, ItemStack aStack) {
        return false;
    }

    @Override
    public boolean allowPutStack(IGregTechTileEntity aBaseMetaTileEntity, int aIndex, byte aSide, ItemStack aStack) {
        return false;
    }
}