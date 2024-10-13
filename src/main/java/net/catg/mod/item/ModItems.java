package net.catg.mod.item;

import net.catg.mod.Magical;
import net.catg.mod.item.custom.BombProjectileItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static Item EXPLODE_CRYSTAL = registerItem("explode_crystal", new Item(new Item.Settings()));
    public static Item EXPLODE_FRAGMENT = registerItem("explode_fragment", new Item(new Item.Settings()));
    public static Item BOMB_PROJECTILE_ITEM = registerItem("bomb_projectile_item", new BombProjectileItem(new Item.Settings()));
    private static Item registerItem(String name, Item item) {
        Magical.LOGGER.info("Registering item " + name);
        return Registry.register(Registries.ITEM, Identifier.of(Magical.MOD_ID, name), item);
    }
    public static void registerModItems() {
        Magical.LOGGER.info("Registering mod items for " + Magical.MOD_ID);

    }

}
