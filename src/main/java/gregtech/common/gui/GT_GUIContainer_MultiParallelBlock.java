package gregtech.common.gui;

import gregtech.api.gui.GT_Container_MultiMachine;
import gregtech.api.gui.GT_GUIContainerMetaTile_Machine;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_Hatch_Energy;
import gregtech.api.util.GT_LanguageManager;
import gregtech.api.util.GT_Utility;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
import java.util.Iterator;

import static gregtech.api.enums.GT_Values.RES_PATH_GUI;
import static gregtech.api.metatileentity.implementations.GT_MetaTileEntity_MultiBlockBase.isValidMetaTileEntity;


public class GT_GUIContainer_MultiParallelBlock extends GT_GUIContainerMetaTile_Machine {
    public String mNEI;
    String mName = "";
    private boolean  mWorkUpdate = false, mWorks = true;
    public int mEUt = 0;
    public ArrayList<GT_MetaTileEntity_Hatch_Energy> mEnergyHatches = new ArrayList();

    public GT_GUIContainer_MultiParallelBlock(InventoryPlayer aInventoryPlayer, IGregTechTileEntity aTileEntity, String aName, String aTextureFile, String aNEI) {
        super(new GT_Container_MultiMachine(aInventoryPlayer, aTileEntity, true), RES_PATH_GUI + "multimachines/" + (aTextureFile == null ? "MultiblockDisplay" : aTextureFile ));
        mName = aName;
        mNEI = aNEI;
    }


    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        fontRendererObj.drawString(mName, 10, 8, 16448255);
        fontRendererObj.drawString("NEI", 154, 67, 16448255);
        if (this.mContainer != null) {
            if (mContainer != null) {
                if ((((GT_Container_MultiMachine) mContainer).mDisplayErrorCode & 64) != 0) {
                    fontRendererObj.drawString(EnumChatFormatting.RED + "==================", 10+10+5, 30, 0);
                    fontRendererObj.drawString(EnumChatFormatting.RED + "Incomplete Structure", 10+10+5, 40, 0);
                    fontRendererObj.drawString(EnumChatFormatting.RED + "==================", 10+10+5, 50, 0);
                } else {
                    if ((((GT_Container_MultiMachine) this.mContainer).mDisplayErrorCode & 1) != 0) {
                        this.fontRendererObj.drawString(this.trans("132", EnumChatFormatting.WHITE +"Need" + EnumChatFormatting.RED +" Wrench"), 10, 20, 0);
                    }

                    if ((((GT_Container_MultiMachine) this.mContainer).mDisplayErrorCode & 2) != 0) {
                        this.fontRendererObj.drawString(this.trans("133", EnumChatFormatting.WHITE +"Need"+ EnumChatFormatting.RED +" Screwdriver"), 10, 29, 0);
                    }

                    if ((((GT_Container_MultiMachine) this.mContainer).mDisplayErrorCode & 4) != 0) {
                        this.fontRendererObj.drawString(this.trans("134", EnumChatFormatting.WHITE +"Need"+ EnumChatFormatting.RED +" SoftHammer"), 10, 38, 0);
                    }

                    if ((((GT_Container_MultiMachine) this.mContainer).mDisplayErrorCode & 8) != 0) {
                        this.fontRendererObj.drawString(this.trans("135", EnumChatFormatting.WHITE +"Need"+ EnumChatFormatting.RED +" Hammer"), 10, 47, 0);
                    }

                    if ((((GT_Container_MultiMachine) this.mContainer).mDisplayErrorCode & 16) != 0) {
                        this.fontRendererObj.drawString(this.trans("136", EnumChatFormatting.WHITE +"Need"+ EnumChatFormatting.RED +" Soldering"), 10, 56, 0);
                    }

                    if ((((GT_Container_MultiMachine) this.mContainer).mDisplayErrorCode & 32) != 0) {
                        this.fontRendererObj.drawString(this.trans("137", EnumChatFormatting.WHITE +"Need"+ EnumChatFormatting.RED +" Crowbar"), 10, 65, 0);
                    }

                }
            }

            if (((GT_Container_MultiMachine) mContainer).mDisplayErrorCode == 0) {
                if (((GT_Container_MultiMachine) mContainer).mActive == 0) {
                    fontRendererObj.drawString("Progress:"+EnumChatFormatting.RED+" not working", 10, 22, 16448255);
                } else {
                    double tScale = ( (double) this.mContainer.mProgressTime / (double) this.mContainer.mMaxProgressTime)*100;
                    if ((int)tScale > 0 && (int)tScale < 100) {
                        fontRendererObj.drawString("Progress: " +EnumChatFormatting.GREEN + GT_Utility.formatNumbers(this.mContainer.mProgressTime) +EnumChatFormatting.WHITE + " / " +EnumChatFormatting.YELLOW + GT_Utility.formatNumbers(this.mContainer.mMaxProgressTime) +EnumChatFormatting.WHITE + " sec", 10, 22, 16448255);
                        fontRendererObj.drawString(GT_Utility.formatNumbers((int) tScale) + "%", 71, 56, 16448255);
                    }
                }
            }
        }
    }





    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        super.drawGuiContainerBackgroundLayer(par1, par2, par3);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
        if (this.mContainer != null) {
            if (((GT_Container_MultiMachine) mContainer).mDisplayErrorCode == 0) {
                if (((GT_Container_MultiMachine) mContainer).mActive == 0) {
                    drawTexturedModalRect(x + 136, y + 9, 238, 0, 9, 9);

                } else
                    drawTexturedModalRect(x + 136, y + 9, 247, 0, 9, 9);
                double tScale = (double) this.mContainer.mProgressTime / (double) this.mContainer.mMaxProgressTime;
                drawTexturedModalRect(x + 22, y + 55, 0, 232, Math.min(113, (int) (tScale * 113)), 9);
                drawTexturedModalRect(x + 19, y + 52, 0, 241, 119, 15);
            }
        }
    }
    public long getMaxInputVoltage() {
        long rVoltage = 0L;
        Iterator var3 = this.mEnergyHatches.iterator();

        while(var3.hasNext()) {
            GT_MetaTileEntity_Hatch_Energy tHatch = (GT_MetaTileEntity_Hatch_Energy)var3.next();
            if (isValidMetaTileEntity(tHatch)) {
                rVoltage += tHatch.getBaseMetaTileEntity().getInputVoltage();
            }
        }

        return rVoltage;
    }

    public String trans(String aKey, String aEnglish) {
        return GT_LanguageManager.addStringLocalization("Interaction_DESCRIPTION_Index_" + aKey, aEnglish, false);
    }
}
