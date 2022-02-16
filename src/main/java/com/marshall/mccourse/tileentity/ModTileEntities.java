package com.marshall.mccourse.tileentity;

import com.marshall.mccourse.block.Electrifier;
import com.marshall.mccourse.block.ModBlocks;
import com.marshall.mccourse.util.Registration;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

public class ModTileEntities
{

   public static final RegistryObject<TileEntityType<ElectrifierTile>> ELECTRIFIER_TILE_ENTITY
           = Registration.TILE_ENTITY_TYPES.register("electrifier.tile.entity", () -> TileEntityType.Builder.create(
           () -> new ElectrifierTile(), ModBlocks.ELECTRIFIER.get()).build(null));

   public static void register() { }
}
