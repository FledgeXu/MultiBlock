package io.github.multiblock;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, "multiblock");
    public static final RegistryObject<Item> obsidianAltar = ITEMS.register("obsidian_altar", () -> new BlockItem(BlockRegistry.obsidianAltar.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
}
