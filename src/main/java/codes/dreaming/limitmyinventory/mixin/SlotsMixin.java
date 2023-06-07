package codes.dreaming.limitmyinventory.mixin;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import static codes.dreaming.limitmyinventory.LimitMyInventory.CONFIG;

@Mixin(Inventory.class)
public abstract class SlotsMixin implements Container {
    @Override
    public int getMaxStackSize() {
        return CONFIG.maxInventoryStackSize.get();
    }
}
