package io.github.multiblock;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypeRegistry {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, "neutrino");
    public static final RegistryObject<TileEntityType<ObsidianAltarEntity>> obsidianAltarEntity = TILE_ENTITIES.register("obsidian_altar", () -> TileEntityType.Builder.create(ObsidianAltarEntity::new, BlockRegistry.obsidianAltar.get()).build(null));
}
