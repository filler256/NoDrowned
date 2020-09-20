package com.filler.nodrowned.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.DrownedEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import java.util.Random;

@Mixin(DrownedEntity.class)
public class NoDrowned {
	@Inject(method = "canSpawn", at = @At("HEAD"), cancellable = true)
	private static void canSpawn(EntityType type, ServerWorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random, CallbackInfoReturnable<Boolean> info) {
		if (type.equals(EntityType.DROWNED)) {
			info.setReturnValue(false);
		}
	}
}
