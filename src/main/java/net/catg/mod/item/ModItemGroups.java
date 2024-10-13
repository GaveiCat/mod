package net.catg.mod.item;

import net.catg.mod.Magical;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup GUN_AND_BOMBS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Magical.MOD_ID, "gun_and_bombs"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.EXPLODE_CRYSTAL))
                    .displayName(Text.translatable("itemgroup.magical.gun_and_bombs"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.EXPLODE_CRYSTAL);
                        entries.add(ModItems.EXPLODE_FRAGMENT);
                        entries.add(ModItems.BOMB_PROJECTILE_ITEM);
                    })).build());

    public static void registerItemGroups() {
        Magical.LOGGER.info("Registering item groups for " + Magical.MOD_ID);
    }
}
