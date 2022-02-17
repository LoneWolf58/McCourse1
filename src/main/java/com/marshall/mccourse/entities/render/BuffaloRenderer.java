package com.marshall.mccourse.entites.render;

import com.marshall.mccourse.MCCourseMod;
import com.marshall.mccourse.entites.BuffaloEntity;
import com.marshall.mccourse.entites.model.BuffaloModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BuffaloRenderer extends MobRenderer<BuffaloEntity, BuffaloModel<BuffaloEntity>>
{
    protected static final ResourceLocation TEXTURE = new ResourceLocation(MCCourseMod.MOD_ID,
            "textures/entity/buffalo.png");

    public BuffaloRenderer(EntityRendererManager renderManagerIn)
    {
        super(renderManagerIn, new BuffaloModel<>(), 0.9f);
    }

    @Override
    public ResourceLocation getEntityTexture(BuffaloEntity entity)
    {
        return TEXTURE;
    }
}


