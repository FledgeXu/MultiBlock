package io.github.multiblock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Objects;

public class ObsidianAltar extends Block {
    private static VoxelShape shape;

    {
        VoxelShape base = Block.makeCuboidShape(0, 0, 0, 16, 8, 16);
        shape = VoxelShapes.or(base);
    }

    public ObsidianAltar(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return shape;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new ObsidianAltarEntity();
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote && handIn == Hand.MAIN_HAND) {
            ObsidianAltarEntity tileEntity = (ObsidianAltarEntity) Objects.requireNonNull(worldIn.getTileEntity(pos));
            if (player.getItemStackFromSlot(EquipmentSlotType.MAINHAND).isEmpty()) {
                player.setItemStackToSlot(EquipmentSlotType.MAINHAND, tileEntity.pushItemStack());
            } else if (tileEntity.getItemStack().isEmpty()) {
                ItemStack putItem = player.getItemStackFromSlot(EquipmentSlotType.MAINHAND).copy();
                putItem.setCount(1);
                tileEntity.popItemStack(putItem);
                player.getItemStackFromSlot(EquipmentSlotType.MAINHAND).shrink(1);
            }
            if (player.getItemStackFromSlot(EquipmentSlotType.MAINHAND).getItem() == Items.STICK) {
                tileEntity.evolve();
            }
        }
        return ActionResultType.SUCCESS;
    }
}
