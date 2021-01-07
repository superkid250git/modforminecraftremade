
package net.superkid.testi.painting;

import net.superkid.testi.TestiModElements;

@TestiModElements.ModElement.Tag
public class NooPainting extends TestiModElements.ModElement {
	public NooPainting(TestiModElements instance) {
		super(instance, 58);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(32, 16).setRegistryName("noo"));
	}
}
