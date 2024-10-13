package net.catg.mod.entity;

import net.catg.mod.Magical;
import net.catg.mod.entity.custom.BombProjectile; // Импортируем класс бомбы
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder; // Импортируем билдера для сущностей
import net.minecraft.entity.EntityDimensions; // Импортируем класс для размеров сущностей
import net.minecraft.entity.EntityType; // Импортируем класс для типа сущности
import net.minecraft.entity.SpawnGroup; // Импортируем класс для групп спавна
import net.minecraft.registry.Registries; // Импортируем реестр сущностей
import net.minecraft.registry.Registry; // Импортируем реестр
import net.minecraft.util.Identifier; // Импортируем класс идентификаторов

public class ModEntities {
    // Создаем и инициализируем сущность BombProjectile
    public static final EntityType<BombProjectile> BOMB_PROJECTILE = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(Magical.MOD_ID, "packed_snowball"),
            FabricEntityTypeBuilder.<BombProjectile>create(SpawnGroup.MISC, BombProjectile::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
                    .trackRangeBlocks(4).trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
                    .build() // VERY IMPORTANT DONT DELETE FOR THE LOVE OF GOD PSLSSSSSS
    );
}
