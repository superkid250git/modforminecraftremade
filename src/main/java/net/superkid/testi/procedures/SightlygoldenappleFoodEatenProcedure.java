package net.superkid.testi.procedures;

import net.superkid.testi.TestiModElements;

import java.util.Map;

@TestiModElements.ModElement.Tag
public class SightlygoldenappleFoodEatenProcedure extends TestiModElements.ModElement {
	public SightlygoldenappleFoodEatenProcedure(TestiModElements instance) {
		super(instance, 20);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure SightlygoldenappleFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 5000, (int) 6));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 5000, (int) 3));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HASTE, (int) 5000, (int) 2));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, (int) 5000, (int) 2));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 5000, (int) 5));
	}
}
