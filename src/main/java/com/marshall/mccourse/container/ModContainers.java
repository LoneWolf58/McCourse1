package com.marshall.mccourse.container;

import com.marshall.mccourse.container.ElectrifierContainer;
import com.marshall.mccourse.util.Registration;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class ModContainers
{
    public static final RegistryObject<ContainerType<ElectrifierContainer>> ELECTRIFIER_CONTAINER
            = Registration.CONTAINERS.register("electrifier_container",
            () -> IForgeContainerType.create((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World world = inv.player.getEntityWorld();
                return new ElectrifierContainer(windowId, world, pos, inv, inv.player);
            }));

    public static void register() { }

}



