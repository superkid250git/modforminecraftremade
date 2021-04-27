package net.superkid.testi.procedures;

import net.superkid.testi.entity.CbEntity;
import net.superkid.testi.TestiModElements;
import net.superkid.testi.TestiMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import java.util.Map;

@TestiModElements.ModElement.Tag
public class CutepigItIsStruckByLightningProcedure extends TestiModElements.ModElement {
	public CutepigItIsStruckByLightningProcedure(TestiModElements instance) {
		super(instance, 59);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TestiMod.LOGGER.warn("Failed to load dependency entity for procedure CutepigItIsStruckByLightning!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TestiMod.LOGGER.warn("Failed to load dependency x for procedure CutepigItIsStruckByLightning!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TestiMod.LOGGER.warn("Failed to load dependency y for procedure CutepigItIsStruckByLightning!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TestiMod.LOGGER.warn("Failed to load dependency z for procedure CutepigItIsStruckByLightning!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TestiMod.LOGGER.warn("Failed to load dependency world for procedure CutepigItIsStruckByLightning!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (!entity.world.isRemote())
			entity.remove();
		if (world instanceof ServerWorld) {
			Entity entityToSpawn = new CbEntity.CustomEntity(CbEntity.entity, (World) world);
			entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
			if (entityToSpawn instanceof MobEntity)
				((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
						SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
			world.addEntity(entityToSpawn);
		}
	}
}
