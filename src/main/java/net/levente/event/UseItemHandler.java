package net.levente.event;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.levente.item.ModItems;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class UseItemHandler implements UseItemCallback {

    // Constructor to register the event
    public UseItemHandler() {
        UseItemCallback.EVENT.register(this);
    }

    @Override
    public TypedActionResult<ItemStack> interact(PlayerEntity player, World world, Hand hand) {
        // Get the item stack in the player's hand
        ItemStack itemStack = player.getStackInHand(hand);

        // Get the item from the stack
        Item item = itemStack.getItem();

        // Check if the player is right-clicking in the air
        if (!world.isClient && player.raycast(5.0D, 0.0F, false).getType() == HitResult.Type.MISS) {
            // Check if the item matches ModItems.HEART
            if (item == ModItems.HEART) {
                // Inform the player
                player.sendMessage(Text.literal("You right-clicked in the air with the special item!"), true);

                // Increase player's max health
                double currentHealth = player.getMaxHealth();
                double newHealth = currentHealth + 2.0;
                setPlayerMaxHealth(player, newHealth);

                // Decrement the item stack by one
                itemStack.decrement(1);

                // If the stack is empty after decrement, remove it from the player's hand
                if (itemStack.isEmpty()) {
                    player.setStackInHand(hand, ItemStack.EMPTY);
                } else {
                    player.setStackInHand(hand, itemStack);
                }

                return TypedActionResult.success(itemStack);  // Return success with the modified stack
            }
        }

        return TypedActionResult.pass(itemStack);
    }

    public static void setPlayerMaxHealth(PlayerEntity player, double health) {
        // Get the max health attribute instance
        EntityAttributeInstance healthAttribute = player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);

        if (healthAttribute != null) {
            // Set the base value to the desired health
            healthAttribute.setBaseValue(health);

            // Heal the player to the new max health instantly
            player.setHealth((float) health);
        }
    }
}
