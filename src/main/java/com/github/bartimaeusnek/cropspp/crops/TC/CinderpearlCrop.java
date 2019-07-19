//package com.github.bartimaeusnek.cropspp.crops.TC;
//
//import com.github.bartimaeusnek.croploadcore.OreDict;
//import com.github.bartimaeusnek.cropspp.ConfigValues;
//import com.github.bartimaeusnek.cropspp.abstracts.BasicThaumcraftCrop;
//import ic2.api.crops.ICropTile;
//import net.minecraft.item.ItemStack;
//import net.minecraftforge.oredict.OreDictionary;
//
//import java.util.Collections;
//import java.util.List;
//
//public class CinderpearlCrop extends BasicThaumcraftCrop {
//
//    public CinderpearlCrop() {
//        super();
//        OreDict.BSget("crop" + this.name(), this);
//    }
//
//    @Override
//    public String name() {
//        return "Cinderpearl";
//    }
//
//    @Override
//    public String[] attributes() {
//        return new String[]{"Magic", "Blaze", "Nether"};
//    }
//
//    @Override
//    public String discoveredBy() {
//        return "bartimaeusnek and mitchej123";
//    }
//
//    @Override
//    public int growthDuration(ICropTile crop) {
//        int r;
//        if (ConfigValues.debug)
//            r = 1;
//        else if (crop.getCurrentSize() == 1)
//            r = 2250;
//        else if (crop.getCurrentSize() == 2 && (crop.isBlockBelow("blockBlaze") || !(OreDictionary.doesOreNameExist("blockBlaze"))))
//            r = 1750;
//        else
//            r = 250;
//        return r;
//    }
//
//    @Override
//    public boolean canGrow(ICropTile crop) {
//        boolean r = false;
//        if (ConfigValues.debug)
//            r = crop.getCurrentSize() < 3;
//        else if (crop.getCurrentSize() <= 1)
//            r = crop.getCurrentSize() <= 1;
//        else if (crop.getCurrentSize() == 2)
//            r = (crop.getCurrentSize() == 2 && (crop.isBlockBelow("blockBlaze") || !(OreDictionary.doesOreNameExist("blockBlaze"))));
//        return r;
//    }
//
//
//    @Override
//    public ItemStack getDisplayItem() {
//        return OreDict.ISget("crop" + this.name());
//    }
//
//    @Override
//    public ItemStack getGain(ICropTile crop) {
//        return OreDict.ISget("crop" + this.name());
//    }
//
//    @Override
//    public List<String> getCropInformation() {
//        return Collections.singletonList("Needs a block of Blaze below to fully mature.");
//    }
//
//}
