package com.github.bartimaeusnek.cropspp.crops.cpp;

import com.github.bartimaeusnek.croploadcore.MyRandom;
import com.github.bartimaeusnek.cropspp.ConfigValues;
import com.github.bartimaeusnek.cropspp.abstracts.BasicDecorationCrop;
import ic2.api.crops.ICropTile;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WaterlillyCrop extends BasicDecorationCrop {

    @Override
    public int tier() {
        return 2;
    }

    @Override
    public String name() {
        return "Waterlilly";
    }

    @Override
    public String discoveredBy() {
        return "moronwmachinegun";
    }

    @Override
    public int growthDuration(ICropTile crop) {
        int ret = 550;
        if (crop.isBlockBelow(Blocks.WATER) || crop.isBlockBelow(Blocks.FLOWING_WATER))
            ret = 225;
        if (ConfigValues.debug)
            ret = 1;
        return ret;
    }

    @Override
    public String[] attributes() {
        return new String[]{"Blue", "Water", "Green"};
    }

    @Override
    public ItemStack getGain(ICropTile crop) {
        ItemStack ret = getDisplayItem();
        if (MyRandom.intrandom(0, 10) > 8)
            ret = new ItemStack(Items.DYE, 2, 9);
        return ret;
    }

    @Override
    public ItemStack getDisplayItem() {
        return new ItemStack(Item.getItemById(111), 2);
    }
}
