//package com.github.bartimaeusnek.cropspp.items;
//
//import cpw.mods.fml.relauncher.Side;
//import cpw.mods.fml.relauncher.SideOnly;
//import ic2.core.crop.TileEntityCrop;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.nbt.NBTTagCompound;
//import net.minecraft.tileentity.TileEntity;
//import net.minecraft.world.World;
//import net.minecraftforge.fluids.FluidRegistry;
//import net.minecraftforge.fluids.FluidStack;
//import net.minecraftforge.fluids.IFluidContainerItem;
//
//import java.util.List;
//
//import static com.github.bartimaeusnek.cropspp.ConfigValues.debug;
//
//public class ItemBppWateringCan extends Item implements IFluidContainerItem {
//    private int content = 0;
//    private boolean nutrient = false;
//
//    public ItemBppWateringCan() {
//        super();
//        this.setUnlocalizedName("WateringCan");
//        this.setMaxStackSize(1);
//        this.setCreativeTab(CreativeTab.cpp);
//        this.setTextureName("bpp:itemWateringCan");
//        this.setMaxDamage(0);
//    }
//
//    public void writeToNBT(ItemStack stack) {
//        if (stack == null)
//            return;
//        if (stack.getTagCompound() == null)
//            stack.setTagCompound(new NBTTagCompound());
//        writeToNBT(stack.getTagCompound());
//    }
//
//    public void writeToNBT(NBTTagCompound tag) {
//        NBTTagCompound subtag = new NBTTagCompound();
//        subtag.setInteger("content", content);
//        subtag.setBoolean("nutrient", nutrient);
//        tag.setTag("Stats", subtag);
//    }
//
//    public void readFromToNBT(ItemStack stack) {
//        if (stack == null || stack.getTagCompound() == null)
//            return;
//        readFromToNBT(stack.getTagCompound());
//    }
//
//    public void readFromToNBT(NBTTagCompound tag) {
//        if (tag == null)
//            return;
//        NBTTagCompound subtag = tag.getCompoundTag("Stats");
//        this.content = subtag.getInteger("content");
//        this.nutrient = subtag.getBoolean("nutrient");
//    }
//
//    @Override
//    @SideOnly(Side.CLIENT)
//    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
//        list.add("Max Capacity:");
//        list.add(Integer.toString(getCapacity(null)));
//        list.add("Contains:");
//        list.add(Integer.toString(content));
//        list.add("IsNutrient:");
//        list.add(String.valueOf(nutrient));
//    }
//
//    @Override
//    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
//        if (world.isRemote)
//            return false;
//        readFromToNBT(stack);
//        if (content >= 144) {
//            TileEntity te = world.getTileEntity(x, y, z);
//            if (te instanceof TileEntityCrop) {
//                TileEntityCrop crop = (TileEntityCrop) te;
//                if (crop.getCrop() != null) {
//                    if (debug) {
//                        if (crop.getCurrentSize() < crop.getCrop().maxSize())
//                            crop.size++;
//                        if (nutrient)
//                            crop.applyFertilizer(true);
//                        crop.waterStorage += 144;
//                        content -= 144;
//                        crop.updateState();
//                        writeToNBT(stack);
//                        return true;
//                    } else {
//                        if (nutrient)
//                            crop.applyFertilizer(true);
//                        crop.waterStorage += 144;
//                        content -= 144;
//                        crop.updateState();
//                        writeToNBT(stack);
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public FluidStack getFluid(ItemStack container) {
//        return content == 0 ? null : nutrient ? FluidRegistry.getFluidStack("fluid.fertiliser", content) : new FluidStack(FluidRegistry.WATER, content);
//    }
//
//    @Override
//    public int getCapacity(ItemStack container) {
//        return 1440;
//    }
//
//    @Override
//    public int fill(ItemStack stack, FluidStack resource, boolean doFill) {
//        if (resource == null || resource.getFluid() == null)
//            return 0;
//
//        if (!nutrient || content == 0)
//            if ((resource.getFluid().equals(FluidRegistry.WATER) || resource.getFluid().equals(FluidRegistry.getFluidStack("fluid.fertiliser", content).getFluid()))) {
//                boolean fert = false;
//                if (FluidRegistry.getFluidStack("fluid.fertiliser", content) != null)
//                    if (resource.getFluid().equals(FluidRegistry.getFluidStack("fluid.fertiliser", content).getFluid()))
//                        fert = true;
//                int toFill = Math.min(resource.amount, (getCapacity(null) - content));
//                if (!doFill)
//                    return toFill;
//                else {
//                    nutrient = fert;
//                    content = toFill;
//                    writeToNBT(stack);
//                    return toFill;
//                }
//            }
//        return 0;
//    }
//
//    @Override
//    public FluidStack drain(ItemStack container, int maxDrain, boolean doDrain) {
//        return null;
//    }
//}
