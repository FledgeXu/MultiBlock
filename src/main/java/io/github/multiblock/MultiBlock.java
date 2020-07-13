package io.github.multiblock;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("multiblock")
public class MultiBlock {
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public MultiBlock() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        BlockRegistry.BLOCKS.register(modBus);
        ItemRegistry.ITEMS.register(modBus);
        TileEntityTypeRegistry.TILE_ENTITIES.register(modBus);
    }
}
