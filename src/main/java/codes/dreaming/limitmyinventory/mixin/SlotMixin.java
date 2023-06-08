package codes.dreaming.limitmyinventory.mixin;

import codes.dreaming.limitmyinventory.LimitMyInventory;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashMap;
import java.util.Objects;

@Mixin(Slot.class)
public class SlotMixin {
    @Shadow
    @Final
    public Container container;

    @Inject(at = @At("HEAD"), method = "getMaxStackSize(Lnet/minecraft/world/item/ItemStack;)I", cancellable = true)
    private void getMaxStackSize(ItemStack stack, CallbackInfoReturnable<Integer> cir) {
        if(this.container instanceof Inventory) {
            Integer limit = LimitMyInventory.maxInventoryStackSizes.get(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(stack.getItem())).toString());

            if(limit != null) {
                cir.setReturnValue(limit);
            }
        }
    }
}
