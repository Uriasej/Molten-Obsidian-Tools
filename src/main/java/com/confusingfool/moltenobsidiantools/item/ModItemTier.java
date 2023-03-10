package com.confusingfool.moltenobsidiantools.item;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;
import java.util.stream.Stream;

public enum ModItemTier implements IItemTier
{
    MOLTEN(3, 1900, 9.4F, 3.5F, 3, () -> Ingredient.fromValues((Stream<? extends Ingredient.IItemList>) ModItems.MOLTEN_OBSIDIAN.get())),

    REINFORCED(4, 3000, 11F, 4.0F, 20, () -> Ingredient.fromValues((Stream<? extends Ingredient.IItemList>) ModItems.REINFORCED_MOLTEN_OBSIDIAN.get()));


    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyValue<Ingredient> repairIngredient;

    ModItemTier(int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new LazyValue<>(repairIngredient);
    }

    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return damage;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }
}
