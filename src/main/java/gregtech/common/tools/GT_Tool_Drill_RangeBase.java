package gregtech.common.tools;

import gregtech.GT_Mod;
import gregtech.api.GregTech_API;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.interfaces.IIconContainer;
import gregtech.api.items.GT_MetaGenerated_Tool;
import gregtech.common.items.behaviors.Behaviour_Drill;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;

import java.util.List;

import static gregtech.api.util.GT_Utility.ItemNBT.getDrillRangeMode;

abstract class GT_Tool_Drill_RangeBase
        extends GT_Tool_Drill_LV {

    private ThreadLocal<Object> sIsHarvesting = new ThreadLocal();

    public static MovingObjectPosition raytraceFromEntity(World world, Entity player, boolean wut, double range) {
        float f = 1.0F;
        float f1 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * f;
        float f2 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * f;
        double d0 = player.prevPosX + (player.posX - player.prevPosX) * f;
        double d1 = player.prevPosY + (player.posY - player.prevPosY) * f;
        if (!world.isRemote && player instanceof EntityPlayer)
            d1 += 1.62D;
        double d2 = player.prevPosZ + (player.posZ - player.prevPosZ) * f;
        Vec3 vec3 = Vec3.createVectorHelper(d0, d1, d2);
        float f3 = MathHelper.cos(-f2 * 0.017453292F - (float) Math.PI);
        float f4 = MathHelper.sin(-f2 * 0.017453292F - (float) Math.PI);
        float f5 = -MathHelper.cos(-f1 * 0.017453292F);
        float f6 = MathHelper.sin(-f1 * 0.017453292F);
        float f7 = f4 * f5;
        float f8 = f3 * f5;
        double d3 = range;
        Vec3 vec31 = vec3.addVector(f7 * d3, f6 * d3, f8 * d3);
        return world.rayTraceBlocks(vec3, vec31, wut);
    }

    public int getToolDamagePerBlockBreak() {
        return GT_Mod.gregtechproxy.mHardRock ? setToolDamagePerBlockBreak() / 2 : setToolDamagePerBlockBreak();
    }

    abstract int setToolDamagePerBlockBreak();

    public int getToolDamagePerDropConversion() {
        return setToolDamagePerDropConversion();
    }

    abstract int setToolDamagePerDropConversion();

    public int getToolDamagePerContainerCraft() {
        return setToolDamagePerContainerCraft();
    }

    abstract int setToolDamagePerContainerCraft();

    public int getToolDamagePerEntityAttack() {
        return setToolDamagePerEntityAttack();
    }

    abstract int setToolDamagePerEntityAttack();

    public int getBaseQuality() {
        return setBaseQuality();
    }

    abstract int setBaseQuality();

    public float getBaseDamage() {
        return setBaseDamage();
    }

    abstract float setBaseDamage();

    public float getSpeedMultiplier() {
        return setSpeedMultiplier();
    }

    abstract float setSpeedMultiplier();

    public float getMaxDurabilityMultiplier() {
        return setMaxDurabilityMultiplier();
    }

    abstract float setMaxDurabilityMultiplier();

    public IIconContainer getIcon(boolean aIsToolHead, ItemStack aStack) {
        return aIsToolHead ? GT_MetaGenerated_Tool.getPrimaryMaterial(aStack).mIconSet.mTextures[OrePrefixes.toolHeadDrill.mTextureIndex] : setIcon();
    }

    abstract IIconContainer setIcon();

    abstract byte RangeWidthandDepth();

    abstract byte RangeHeight();

    public String getCraftingSound() {
        return GregTech_API.sSoundList.get(Integer.valueOf(106));
    }

    public String getEntityHitSound() {
        return GregTech_API.sSoundList.get(Integer.valueOf(106));
    }

    public String getBreakingSound() {
        return GregTech_API.sSoundList.get(Integer.valueOf(106));
    }

    public String getMiningSound() {
        return GregTech_API.sSoundList.get(Integer.valueOf(106));
    }

    public boolean canBlock() {
        return false;
    }

    public boolean isCrowbar() {
        return false;
    }

    public boolean isMinableBlock(Block aBlock, byte aMetaData) {
        String tTool = aBlock.getHarvestTool(aMetaData);
        return aBlock.getHarvestLevel(aMetaData) != -1 && (tTool == null || tTool.isEmpty() || ((tTool.equals("pickaxe")) || (tTool.equals("shovel")))) || (aBlock.getMaterial() == Material.rock) || (aBlock.getMaterial() == Material.iron) || (aBlock.getMaterial() == Material.anvil) || (aBlock.getMaterial() == Material.sand) || (aBlock.getMaterial() == Material.grass) || (aBlock.getMaterial() == Material.ground) || (aBlock.getMaterial() == Material.snow) || (aBlock.getMaterial() == Material.clay) || (aBlock.getMaterial() == Material.glass);
    }

    public ItemStack getBrokenItem(ItemStack aStack) {
        return null;
    }

    public short[] getRGBa(boolean aIsToolHead, ItemStack aStack) {
        return aIsToolHead ? GT_MetaGenerated_Tool.getPrimaryMaterial(aStack).mRGBa : GT_MetaGenerated_Tool.getSecondaryMaterial(aStack).mRGBa;
    }

    public void onStatsAddedToTool(GT_MetaGenerated_Tool aItem, int aID) {
        aItem.addItemBehavior(aID, new Behaviour_Drill(setRange(), setTier()));
    }

    abstract String setRange();

    abstract int setTier();

    public void onToolCrafted(ItemStack aStack, EntityPlayer aPlayer) {
        super.onToolCrafted(aStack, aPlayer);
        aPlayer.triggerAchievement(AchievementList.buildPickaxe);
        aPlayer.triggerAchievement(AchievementList.buildBetterPickaxe);
        try {
            GT_Mod.achievements.issueAchievement(aPlayer, "driltime");
            GT_Mod.achievements.issueAchievement(aPlayer, "buildDrill");
        } catch (Exception e) {
        }
    }

    public IChatComponent getDeathMessage(EntityLivingBase aPlayer, EntityLivingBase aEntity) {
        return new ChatComponentText(EnumChatFormatting.RED + aEntity.getCommandSenderName() + EnumChatFormatting.WHITE + " got the Drill! (by " + EnumChatFormatting.GREEN + aPlayer.getCommandSenderName() + EnumChatFormatting.WHITE + ")");
    }

    public int convertBlockDrops(List<ItemStack> aDrops, ItemStack aStack, EntityPlayer aPlayer, Block aBlock, int aX, int aY, int aZ, byte aMetaData, int aFortune, boolean aSilkTouch, BlockEvent.HarvestDropsEvent aEvent) {
        int rConversions = 0;

        int mode = getDrillRangeMode(aStack);

        int WD = mode == 1 ? 1 : mode == 2 ? 2 : mode == 3 ? 3 : mode == 4 ? 4 : 0;
        int H = mode == 1 ? 1 : mode == 2 ? 3 : mode == 3 ? 5 : mode == 4 ? 7 : 0;

        //int debugWD = RangeWidthandDepth();
        //int debugH = RangeHeight();

        MovingObjectPosition raycast = raytraceFromEntity(aPlayer.worldObj, aPlayer, true, 10);
        if (raycast != null) {
            if ((this.sIsHarvesting.get() == null) && ((aPlayer instanceof EntityPlayerMP))) {
                this.sIsHarvesting.set(this);
                for (int i = -WD; i <= WD; i++) {
                    for (int j = mode == 0 ? 0 : -1; j <= H; j++) {
                        for (int k = -WD; k <= WD; k++) {

                            if (aEvent.world.getBlock(aX + i, aY + j, aZ + k) == Blocks.bedrock) {
                            } else {
                                if (((i != 0) || (j != 0) || (k != 0)) && (aStack.getItem().getDigSpeed(aStack,
                                        aPlayer.worldObj.getBlock(aX + i, aY + j, aZ + k),
                                        aPlayer.worldObj.getBlockMetadata(aX + i, aY + j, aZ + k)) > 0.0F) &&
                                        (((EntityPlayerMP) aPlayer).theItemInWorldManager.tryHarvestBlock(aX + i, aY + j, aZ + k))) {
                                    rConversions++;
                                }
                            }
                        }
                    }
                }
                this.sIsHarvesting.set(null);
            }
        }
        return rConversions;
    }

}
