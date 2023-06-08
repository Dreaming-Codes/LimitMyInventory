package codes.dreaming.limitmyinventory;

import codes.dreaming.limitmyinventory.kubejs.KubeJSLimitMyInventoryPlugin;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TagsUpdatedEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;

@Mod(LimitMyInventory.MODID)
public class LimitMyInventory {
    public static final String MODID = "limitmyinventory";

    public static HashMap<String, Integer> maxInventoryStackSizes = new HashMap<>();

    public LimitMyInventory() {
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGHEST, this::serverReload);
    }

    public void serverReload(TagsUpdatedEvent event) {
        maxInventoryStackSizes.clear();
        KubeJSLimitMyInventoryPlugin.SET_INVENTORY_MAX_STACK_SIZE.post(KubeJSLimitMyInventoryPlugin.SetInventoryMaxStackSizeEventJS.INSTANCE);
    }
}
