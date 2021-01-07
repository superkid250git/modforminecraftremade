
package net.superkid.testi.painting;

import net.superkid.testi.TestiModElements;

@TestiModElements.ModElement.Tag
public class Cute2Painting extends TestiModElements.ModElement {
	public Cute2Painting(TestiModElements instance) {
		super(instance, 58);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(16, 16).setRegistryName("cute_2"));
	}
}
