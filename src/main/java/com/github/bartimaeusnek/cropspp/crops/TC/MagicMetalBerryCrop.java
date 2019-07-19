//package com.github.bartimaeusnek.cropspp.crops.TC;
//
//import com.github.bartimaeusnek.cropspp.ConfigValues;
//import com.github.bartimaeusnek.cropspp.abstracts.BasicTinkerBerryCrop;
//import ic2.api.crops.ICropTile;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.EntityLivingBase;
//import net.minecraft.entity.item.EntityItem;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.DamageSource;
//import net.minecraftforge.oredict.OreDictionary;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class MagicMetalBerryCrop extends BasicTinkerBerryCrop {
//
//    public MagicMetalBerryCrop() {
//        super();
//    }
//
//    @Override
//    public String name() {
//        return "Magic Metal Berry";
//    }
//
//    @Override
//    public int tier() {
//        return 7;
//    }
//
//    @Override
//    protected String hasBlock() {
//        return "";
//    }
//
//    @Override
//    public boolean canGrow(ICropTile crop) {
//        boolean r;
//        if (ConfigValues.debug)
//            r = crop.getCurrentSize() < 4;
//        else
//            r = crop.getCurrentSize() < 1 || (crop.getCurrentSize() == 3 && (crop.isBlockBelow("blockThaumium") || crop.isBlockBelow("blockThauminite") || crop.isBlockBelow("blockIron") || crop.isBlockBelow("blockVoid"))) || (crop.getLightLevel() <= 10 && crop.getCurrentSize() < 3);
//        return r;
//    }
//
//    @Override
//    public boolean canBeHarvested(ICropTile crop) {
//        return crop.getCurrentSize() == 4;
//    }
//
//    @Override
//    public ItemStack getGain(ICropTile crop) {
//        if (crop.isBlockBelow("blockThaumium") || crop.isBlockBelow("blockIron")) {
//            return OreDictionary.getOres("nuggetThaumium").get(OreDictionary.getOres("nuggetThaumium").size() - 1);
//        }
//        else if ((crop.isBlockBelow("blockVoid") || ConfigValues.debug) && OreDictionary.getOres("nuggetVoid").size() != 0) {
//            return OreDictionary.getOres("nuggetVoid").get(OreDictionary.getOres("nuggetVoid").size() - 1);
//        }
//        else if ((crop.isBlockBelow("blockThauminite")) && OreDictionary.getOres("nuggetThauminite").size() != 0) {
//            return OreDictionary.getOres("nuggetThauminite").get(OreDictionary.getOres("nuggetThauminite").size() - 1);
//        }
//        else
//            return null;
//    }
//
//    @Override
//    public List<String> getCropInformation() {
//        return (List<String>) Arrays.asList(new String[]{"Needs a block of Thaumium, Iron, Thauminite or Void Below to fully mature.", "Drops the Magic-Metal that is underneath (Iron will drop Thaumium)", "Matures fastest with Thaumium under it.", "Needs a light level below or equal to 10 to fully mature."});
//    }
//
//    @Override
//    public int growthDuration(ICropTile crop) {
//        if (ConfigValues.debug)
//            return 1;
//        if (crop.getCurrentSize() == 2)
//            return 1200;
//        else if (crop.getCurrentSize() == 3 && (crop.isBlockBelow("blockThaumium")))
//            return 1800;
//        else if (crop.getCurrentSize() == 3 && (crop.isBlockBelow("blockVoid") || crop.isBlockBelow("blockThauminite") || crop.isBlockBelow("blockIron")))
//            return 3300;
//        else
//            return 500;
//    }
//
//    @Override
//    public String[] attributes() {
//        return new String[]{"OreBerry", "Magic", "Metal", "Thaumium", "Void"};
//    }
//
//    @Override
//    public boolean onEntityCollision(ICropTile crop, Entity entity) {
//        if (!(entity instanceof EntityItem))
//            entity.attackEntityFrom(DamageSource.magic, 1);
//        if (entity instanceof EntityLivingBase) {
//            return ((EntityLivingBase) entity).isSprinting();
//        }
//        return false;
//    }
//
//    @Override
//    public ItemStack getDisplayItem() {
//        return thaumcraft.api.ItemApi.getItem("itemResource", 17);
//    }
//
//}
