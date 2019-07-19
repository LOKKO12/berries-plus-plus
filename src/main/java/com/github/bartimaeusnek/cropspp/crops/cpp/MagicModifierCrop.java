//package com.github.bartimaeusnek.cropspp.crops.cpp;
//
//import com.github.bartimaeusnek.cropspp.ConfigValues;
//import com.github.bartimaeusnek.cropspp.crops.TC.PrimordialPearlBerryCrop;
//import com.github.bartimaeusnek.cropspp.items.CppItems;
//import ic2.api.crops.ICropTile;
//import net.minecraft.item.ItemStack;
//import net.minecraftforge.oredict.OreDictionary;
//
//import java.util.Collections;
//import java.util.List;
//
//public class MagicModifierCrop extends PrimordialPearlBerryCrop {
//
//    public MagicModifierCrop() {
//        super();
//    }
//
//    @Override
//    public String name() {
//        return "Magical Nightshade";
//    }
//
//    @Override
//    public int tier() {
//        return 13;
//    }
//
//    @Override
//    public boolean canCross(ICropTile crop) {
//        return crop.getCurrentSize() == this.maxSize();
//    }
//
//    @Override
//    public ItemStack getSeeds(ICropTile crop) {
//        return crop.generateSeeds(crop.getCrop(), crop.getStatGrowth(), crop.getStatGain(), crop.getStatResistance(), crop.getScanLevel());
//    }
//
//    @Override
//    public List<String> getCropInformation() {
//        return Collections.singletonList("Needs a block of Ichorium below to fully mature.");
//    }
//
//    @Override
//    public int growthDuration(ICropTile crop) {
//        if (ConfigValues.debug)
//            return 1;
//        else {
//            return ConfigValues.PrimordialBerryGroth / 16;
//        }
//    }
//
//    @Override
//    public float dropGainChance() {
//        return (float) ((float) ((Math.pow(0.95, (float) tier())) * ConfigValues.BerryGain) * (ConfigValues.PrimordialBerryGain * 1.5));
//    }
//
//    @Override
//    public int getEmittedLight(ICropTile crop) {
//        if (crop.getCurrentSize() == 4)
//            return 4;
//        else return 0;
//    }
//
//    @Override
//    public boolean canGrow(ICropTile crop) {
//        boolean ret = false;
//        if (crop.getCurrentSize() < 3)
//            ret = true;
//        else if ((crop.getCurrentSize() == 3 && crop.isBlockBelow("blockIchorium")) || (crop.getCurrentSize() == 3 && !OreDictionary.doesOreNameExist("blockIchorium")))
//            ret = true;
//        return ret;
//    }
//
//    @Override
//    public byte getSizeAfterHarvest(ICropTile crop) {
//        return 1;
//    }
//
//    @Override
//    public ItemStack getDisplayItem() {
//            return new ItemStack(CppItems.Modifier, 1, 1);
//    }
//
//    @Override
//    public ItemStack getGain(ICropTile crop) {
//        return new ItemStack(CppItems.Modifier, 1, 1);
//    }
//
//    @Override
//    public String discoveredBy() {
//        return "bartimaeusnek";
//    }
//}
//
