//package com.github.bartimaeusnek.cropspp.crops.BoP;
//
//import biomesoplenty.api.content.BOPCBlocks;
//import com.github.bartimaeusnek.cropspp.abstracts.BasicDecorationCrop;
//import ic2.api.crops.ICropTile;
//import net.minecraft.init.Blocks;
//import net.minecraft.item.ItemStack;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class GlowflowerCrop extends BasicDecorationCrop {
//
//    public GlowflowerCrop() {
//        super();
//    }
//
//    @Override
//    public ItemStack getDisplayItem() {
//        return new ItemStack(BOPCBlocks.flowers, 1, 3);
//    }
//
//    @Override
//    public int tier() {
//        return super.tier() + 2;
//    }
//
//    @Override
//    public String name() {
//        return "Glowflower";
//    }
//
//    @Override
//    public String[] attributes() {
//        return new String[]{"Nether", "Light", "Shiny"};
//    }
//
//    @Override
//    public boolean canGrow(ICropTile crop) {
//        return crop.getCurrentSize() < 3;
//    }
//
//    @Override
//    public int getEmittedLight(ICropTile crop) {
//        if (crop.getCurrentSize() == 3)
//            return 7;
//        else return 0;
//    }
//
//    @Override
//    public List<String> getCropInformation() {
//        return Arrays.asList("Needs a block of Glowstone below to incrase yield","Emits light when fully grown.");
//    }
//
//
//    @Override
//    public ItemStack getGain(ICropTile crop) {
//        if (crop.isBlockBelow(Blocks.GLOWSTONE))
//            return new ItemStack(BOPCBlocks.flowers, 2, 3);
//        else
//            return new ItemStack(BOPCBlocks.flowers, 1, 3);
//    }
//
//}
