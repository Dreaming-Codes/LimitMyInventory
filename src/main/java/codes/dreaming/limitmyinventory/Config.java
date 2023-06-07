package codes.dreaming.limitmyinventory;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class Config {
    private final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public final ForgeConfigSpec.ConfigValue<Integer> maxInventoryStackSize = BUILDER.comment("Define the max stack size per slot of the player inventory (min 1, max 64)").defineInRange("maxInventoryStackSize", 1, 1, 64);

    public void register(ModLoadingContext context) {
        context.registerConfig(ModConfig.Type.COMMON, BUILDER.build());
    }
}
