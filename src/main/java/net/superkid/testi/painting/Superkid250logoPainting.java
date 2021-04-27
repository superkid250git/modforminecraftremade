
package net.superkid.testi.painting;

import net.superkid.testi.TestiModElements;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.entity.item.PaintingType;

@TestiModElements.ModElement.Tag
public class Superkid250logoPainting extends TestiModElements.ModElement {
	public Superkid250logoPainting(TestiModElements instance) {
		super(instance, 57);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(16, 16).setRegistryName("superkid_250logo"));
	}
}
