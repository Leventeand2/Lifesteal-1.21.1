package net.levente.item.custom;

import net.levente.util.PlayerMaxHealthUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class Heart extends Item {
    public Heart(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {

            double currentHealth = user.getMaxHealth();
            double newHealth = currentHealth + 2.0;
            PlayerMaxHealthUtil.setPlayerMaxHealth(user, newHealth);

            user.getStackInHand(hand).decrement(1);
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.PASS;
        }
    }


}
