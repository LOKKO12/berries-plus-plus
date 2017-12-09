package lokko12.berriespp.crops.natura;

import ic2.api.crops.ICropTile;
import lokko12.berriespp.crops.BasicBerryCrop;
import ic2.api.crops.CropCard;
import mods.natura.common.NContent;
import net.minecraft.item.ItemStack;

public class BlueberryCrop extends BasicBerryCrop {

    public BlueberryCrop(int id, ItemStack item) {
        super();
    }

    public String name() {
        return "Blueberry";
    }
    
    public String[] attributes() {
        return new String[] {"Berry", "Food", "Tendrilly", "Blue"}; // Blue like CropTerraWart
    }

    public String discoveredBy() {
        return "Ancient cultures";
    }
    
    @Override
	public ItemStack getGain(ICropTile crop) {
		return new ItemStack(NContent.berryItem,3,1);
	}
}