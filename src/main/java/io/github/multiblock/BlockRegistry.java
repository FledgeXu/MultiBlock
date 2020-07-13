package io.github.multiblock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, "multiblock");
    public static final RegistryObject<Block> obsidianAltar = BLOCKS.register("obsidian_altar", () -> new ObsidianAltar(Block.Properties.create(Material.ROCK)));
}
