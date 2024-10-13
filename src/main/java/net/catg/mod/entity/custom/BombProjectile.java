package net.catg.mod.entity.custom;

import net.catg.mod.entity.ModEntities;
import net.catg.mod.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class BombProjectile extends ThrownItemEntity {
    public BombProjectile(EntityType<? extends BombProjectile> entityType, World world) {
        super(entityType, world);
    }

    public BombProjectile(World world, LivingEntity owner) {
        super(ModEntities.BOMB_PROJECTILE, owner, world); // Изменено на ModEntities.BOMB_PROJECTILE
    }

    public BombProjectile(World world, double x, double y, double z) {
        super(ModEntities.BOMB_PROJECTILE, x, y, z, world); // Изменено на ModEntities.BOMB_PROJECTILE
    }

    protected Item getDefaultItem() {
        return ModItems.BOMB_PROJECTILE_ITEM; // Убедитесь, что этот предмет зарегистрирован
    }

    private ParticleEffect getParticleParameters() {
        ItemStack itemStack = this.getStack();
        return (ParticleEffect)(!itemStack.isEmpty() && !itemStack.isOf(this.getDefaultItem()) ?
                new ItemStackParticleEffect(ParticleTypes.ITEM, itemStack) : ParticleTypes.ITEM_SNOWBALL);
    }

    public void handleStatus(byte status) {
        if (status == 3) {
            ParticleEffect particleEffect = this.getParticleParameters();

            for (int i = 0; i < 8; ++i) {
                this.getWorld().addParticle(particleEffect, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
            }
        }
    }

    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        // Здесь вы можете добавить свою логику урона
        entity.damage(this.getDamageSources().thrown(this, this.getOwner()), 5.0F); // Урон 5.0
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            this.getWorld().sendEntityStatus(this, (byte)3);
            this.explode(); // Вызов взрыва при столкновении
        }
    }

    private void explode() {
        // Реализация взрыва
        if (!this.getWorld().isClient) { // Используем getWorld() вместо level
            this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 3.0F, World.ExplosionSourceType.BLOCK);
            this.discard(); // Удаляем сущность
        }
    }
}
