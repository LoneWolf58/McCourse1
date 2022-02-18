package com.marshall.mccourse.entities;

import com.marshall.mccourse.MCCourseMod;
import com.marshall.mccourse.util.Registration;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

public class ModEntityTypes
{

    public static final RegistryObject<EntityType<com.marshall.mccourse.entities.BuffaloEntity>> BUFFALO = Registration.ENTITY_TYPES.register("buffalo",
            () -> EntityType.Builder.create(com.marshall.mccourse.entities.BuffaloEntity::new, EntityClassification.CREATURE)
                    .size(1.5f, 1.5f)
                    .build(new ResourceLocation(MCCourseMod.MOD_ID + "buffalo").toString()));

    public static void register() { }

}
