package codes.dreaming.limitmyinventory;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;

@Mod(LimitMyInventory.MODID)
public class LimitMyInventory {
    public static final String MODID = "limitmyinventory";
    public static final Config CONFIG = new Config();

    public LimitMyInventory() {
        CONFIG.register(ModLoadingContext.get());
    }
}
