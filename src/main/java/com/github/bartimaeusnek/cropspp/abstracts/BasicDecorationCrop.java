package com.github.bartimaeusnek.cropspp.abstracts;

import com.github.bartimaeusnek.cropspp.ConfigValues;
import ic2.api.crops.ICropTile;

public abstract class BasicDecorationCrop extends BasicBerryCrop {

    public BasicDecorationCrop() {
        super();
    }

    @Override
    public int tier() {
        return 1;
    }

    @Override
    public int stat(int n) {
        switch (n) {
            case 0:
                return 0;   // not chemical
            case 1:
                return 0;   // not edible
            case 2:
                return 0;   // no defensive properties
            case 3:
                return 4;   // primarily decorative
            case 4:
                return 0;   // not particularly weed-like
            default:
                return 0;
        }
    }

    @Override
    public int growthDuration(ICropTile crop) {
        if (ConfigValues.debug)
            return 1;
        else
            return 225;
    }

    @Override
    public int getSizeAfterHarvest(ICropTile crop) {
        return 1;
    }
}
