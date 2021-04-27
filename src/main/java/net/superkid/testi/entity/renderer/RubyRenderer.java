package net.superkid.testi.entity.renderer;

import net.superkid.testi.entity.RubyEntity;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.model.GhastModel;
import net.minecraft.client.renderer.entity.MobRenderer;

@OnlyIn(Dist.CLIENT)
public class RubyRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(RubyEntity.entity,
					renderManager -> new MobRenderer(renderManager, new GhastModel(), 0.5f) {
						@Override
						public ResourceLocation getEntityTexture(Entity entity) {
							return new ResourceLocation("testi:textures/better_ghast_girl.png");
						}
					});
		}
	}
}
