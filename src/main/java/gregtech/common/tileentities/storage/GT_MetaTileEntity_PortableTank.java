package gregtech.common.tileentities.storage;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_BasicTank;
import gregtech.api.objects.GT_RenderedTexture;
import gregtech.api.util.GT_Utility;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidHandler;

public class GT_MetaTileEntity_PortableTank extends GT_MetaTileEntity_BasicTank {

	public boolean OutputFluid = false;

	public GT_MetaTileEntity_PortableTank(final int aID, final String aName, final String aNameRegional, final int aTier) {
		super(aID, aName, aNameRegional, aTier, 3, "Stores " + ((int) (Math.pow(2, aTier) * 32000)) + "L of fluid");
	}

	public GT_MetaTileEntity_PortableTank(final String aName, final int aTier, final String aDescription, final ITexture[][][] aTextures) {
		super(aName, aTier, 3, "Stores " + ((int) (Math.pow(2, aTier) * 32000)) + "L of fluid", aTextures);
	}
	@Override
	public MetaTileEntity newMetaEntity(final IGregTechTileEntity aTileEntity) {
		return new GT_MetaTileEntity_PortableTank(this.mName, this.mTier, this.mDescription, this.mTextures);
	}

	@Override
	public ITexture[][][] getTextureSet(ITexture[] aTextures) {
		return new ITexture[0][0][0];
	}

	@Override
	public ITexture[] getTexture(IGregTechTileEntity aBaseMetaTileEntity, byte aSide, byte aFacing, byte aColorIndex, boolean aActive, boolean aRedstone) {
		return aSide != aFacing
				? aSide == 1
				? new ITexture[]{Textures.BlockIcons.MACHINE_CASINGS[mTier][aColorIndex + 1], new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_STANK)}
				: new ITexture[]{Textures.BlockIcons.MACHINE_CASINGS[mTier][aColorIndex + 1], new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_SIDE_POTIONBREWER)}
				: aActive
				? getTexturesActive(Textures.BlockIcons.MACHINE_CASINGS[mTier][aColorIndex + 1])
				: getTexturesInactive(Textures.BlockIcons.MACHINE_CASINGS[mTier][aColorIndex + 1]);
	}

	public ITexture[] getTexturesActive(ITexture aBaseTexture) {
		return new ITexture[]{aBaseTexture, new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_PIPE_OUT)};
	}

	public ITexture[] getTexturesInactive(ITexture aBaseTexture) {
		return new ITexture[]{aBaseTexture, new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_PIPE_OUT)};
	}

	@Override
	public String[] getDescription() {
		return new String[] { this.mDescription, "Portable Tank", EnumChatFormatting.GREEN +"SHIFT + Screwdriver" +EnumChatFormatting.RESET+ " for on/off mode auto output fluid"};
	}

	public void onPostTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
		super.onPostTick(aBaseMetaTileEntity, aTick);
		if (this.getBaseMetaTileEntity().isServerSide()) {
			IFluidHandler tTileEntity = aBaseMetaTileEntity.getITankContainerAtSide(aBaseMetaTileEntity.getFrontFacing());
			if (tTileEntity != null) {

				if (this.OutputFluid) {
					for (boolean temp = true; temp && mFluid != null; ) {
						temp = false;
						FluidStack tDrained = aBaseMetaTileEntity.drain(ForgeDirection.getOrientation(aBaseMetaTileEntity.getFrontFacing()), Math.max(1, mFluid.amount), false);
						if (tDrained != null) {
							int tFilledAmount = tTileEntity.fill(ForgeDirection.getOrientation(aBaseMetaTileEntity.getBackFacing()), tDrained, false);
							if (tFilledAmount > 0) {
								temp = true;
								tTileEntity.fill(ForgeDirection.getOrientation(aBaseMetaTileEntity.getBackFacing()), aBaseMetaTileEntity.drain(ForgeDirection.getOrientation(aBaseMetaTileEntity.getFrontFacing()), tFilledAmount, true), true);
							}
						}
					}
				}
			}
		}
	}

	public void saveNBTData(NBTTagCompound aNBT) {
		super.saveNBTData(aNBT);
		aNBT.setBoolean("OutputFluid", this.OutputFluid);	}

	public void loadNBTData(NBTTagCompound aNBT) {
		super.loadNBTData(aNBT);
		this.OutputFluid = aNBT.getBoolean("OutputFluid");	}

	public void onScrewdriverRightClick(byte aSide, EntityPlayer aPlayer, float aX, float aY, float aZ) {
		super.onScrewdriverRightClick(aSide, aPlayer, aX, aY, aZ);
		this.OutputFluid = !OutputFluid;
		if (aPlayer.isSneaking()) {
			if (!this.OutputFluid) {
				GT_Utility.sendChatToPlayer(aPlayer, "Fluid Output Disabled");
			} else {
				GT_Utility.sendChatToPlayer(aPlayer, "Fluid Output Enabled");
			}
		}
	}

	@Override
	public boolean allowPullStack(IGregTechTileEntity aBaseMetaTileEntity, int aIndex, byte aSide, ItemStack aStack) {
		return aSide == aBaseMetaTileEntity.getFrontFacing() && aIndex == 1;
	}

	@Override
	public boolean allowPutStack(IGregTechTileEntity aBaseMetaTileEntity, int aIndex, byte aSide, ItemStack aStack) {
		return aSide == aBaseMetaTileEntity.getFrontFacing() && aIndex == 0;
	}

	@Override
	public boolean isSimpleMachine() {
		return true;
	}

	@Override
	public boolean isFacingValid(final byte aFacing) {
		return true;
	}

	@Override
	public boolean isAccessAllowed(final EntityPlayer aPlayer) {
		return true;
	}

	@Override
	public final byte getUpdateData() {
		return 0x00;
	}

	@Override
	public boolean doesFillContainers() {
		return true;
	}

	@Override
	public boolean doesEmptyContainers() {
		return true;
	}

	@Override
	public boolean canTankBeFilled() {
		return true;
	}

	@Override
	public boolean canTankBeEmptied() {
		return true;
	}

	@Override
	public String[] getInfoData() {

		if (this.mFluid == null) {
			return new String[]{
					GT_Values.VOLTAGE_NAMES[this.mTier]+" Fluid Tank",
					"Stored Fluid:",
					"No Fluid",
					Integer.toString(0) + "L",
					Integer.toString(this.getCapacity()) + "L"};
		}
		return new String[]{
				GT_Values.VOLTAGE_NAMES[this.mTier]+" Fluid Tank",
				"Stored Fluid:",
				this.mFluid.getLocalizedName(),
				Integer.toString(this.mFluid.amount) + "L",
				Integer.toString(this.getCapacity()) + "L"};
	}

	@Override
	public int getCapacity() {
		return (int) (Math.pow(2, this.mTier) * 32000);
	}

	@Override
	public int getTankPressure() {
		return 100;
	}

	@Override
	public boolean onRightclick(final IGregTechTileEntity aBaseMetaTileEntity, final EntityPlayer aPlayer) {
		if (aBaseMetaTileEntity.isClientSide()){
			//setVars(); 	
			return true;
		}
		aBaseMetaTileEntity.openGUI(aPlayer);
		return true;
	}

	@Override
	public boolean displaysItemStack() {
		return true;
	}

	@Override
	public boolean displaysStackSize() {
		return false;
	}

	@Override
	public void setItemNBT(NBTTagCompound aNBT) {
		if (mFluid != null) {
			aNBT.setTag("mFluid", mFluid.writeToNBT(new NBTTagCompound()));
		}
	}

}