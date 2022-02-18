package com.marshall.mccourse;

import com.marshall.mccourse.block.ModBlocks;
import com.marshall.mccourse.block.ModFluids;
import com.marshall.mccourse.container.ModContainers;
import com.marshall.mccourse.entities.BuffaloEntity;
import com.marshall.mccourse.entities.ModEntityTypes;
import com.marshall.mccourse.events.ModEvents;
import com.marshall.mccourse.item.ModItems;
import com.marshall.mccourse.setup.ClientProxy;
import com.marshall.mccourse.setup.IProxy;
import com.marshall.mccourse.setup.ServerProxy;
import com.marshall.mccourse.tileentity.ModTileEntities;
import com.marshall.mccourse.util.Config;
import com.marshall.mccourse.util.Registration;
import com.marshall.mccourse.world.biome.ModBiomes;
import com.marshall.mccourse.world.biome.ModSurfaceBuilders;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MCCourseMod.MOD_ID)
public class MCCourseMod
{
    public static final String MOD_ID = "mccourse";

    public static final ItemGroup COURSE_TAB = new ItemGroup("courseTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.COPPER_WIRE.get());
        }
    };

    public static IProxy proxy;

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public MCCourseMod()
    {

        proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        registerModAdditions();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        registerConfigs();

        proxy.init();


        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.BUFFALO.get(), BuffaloEntity.setCustomAttribute().create());
        });

        loadConfigs();
    }

    private void registerConfigs()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);
    }

    private void loadConfigs()
    {
        Config.loadConfigFile(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("mccourse-client.toml").toString());
        Config.loadConfigFile(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("mccourse-server.toml").toString());
    }

    private void registerModAdditions()
    {
        // Inits the registration of additions
        Registration.init();

        //registers items, blocks, etc, added by mod
        ModItems.register();
        ModBlocks.register();
        ModFluids.register();
        ModBiomes.register();

        ModSurfaceBuilders.register();
        ModTileEntities.register();

        ModContainers.register();
        ModEntityTypes.register();



        //registers mod events
        MinecraftForge.EVENT_BUS.register(new ModEvents());
    }




}
