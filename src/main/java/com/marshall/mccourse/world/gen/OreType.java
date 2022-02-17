package com.marshall.mccourse.world.gen;

import com.marshall.mccourse.block.ModBlocks;
import net.minecraft.block.Block;

public enum OreType {
    COPPER(ModBlocks.COPPER_ORE.get(),8,25, 50),
    COPPER_BLOCK(ModBlocks.COPPER_BLOCK.get(),10,10, 60);

    private final Block block;
    private final int maxVeinSize;
    private final int minHeight;
    private final int maxHeight;

    OreType(Block block, int maxVeinSize, int minHeight, int maxHeight) {
        this.block = block;
        this.maxVeinSize = maxVeinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    public Block getResource() {
        return block;
    }

    public int getMaxVeinSize() {
        return maxVeinSize;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public static OreType get(Block block) {
        for (OreType ore : values()) {
            if (block == ore.block) {
                return ore;
            }
        }
        return null;
    }
}


