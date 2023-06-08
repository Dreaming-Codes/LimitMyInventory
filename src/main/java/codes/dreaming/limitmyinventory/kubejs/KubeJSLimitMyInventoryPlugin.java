package codes.dreaming.limitmyinventory.kubejs;

import codes.dreaming.limitmyinventory.LimitMyInventory;
import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.event.EventHandler;
import dev.latvian.mods.kubejs.event.EventJS;

public class KubeJSLimitMyInventoryPlugin extends KubeJSPlugin {
    public static EventGroup GROUP = EventGroup.of("LimitMyInventoryEvents");
    public static EventHandler SET_INVENTORY_MAX_STACK_SIZE = GROUP.server("setInventoryMaxStackSize", () -> SetInventoryMaxStackSizeEventJS.class);

    @Override
    public void registerEvents() {
        System.out.println("Registering LimitMyInventory events");
        GROUP.register();
    }

    public static class SetInventoryMaxStackSizeEventJS extends EventJS {
        public static SetInventoryMaxStackSizeEventJS INSTANCE = new SetInventoryMaxStackSizeEventJS();

        public void setInventoryMaxStackSize(String str, int maxStackSize) {
            if(maxStackSize < 1) throw new IllegalArgumentException("Max stack size must be greater than 0");
            if(maxStackSize > 64) throw new IllegalArgumentException("Max stack size must be less than 65");

            if(maxStackSize == 64) {
                LimitMyInventory.maxInventoryStackSizes.remove(str);
            } else {
                LimitMyInventory.maxInventoryStackSizes.put(str, maxStackSize);
            }

        }
    }
}
