
package net.superkid.testi.painting;

import net.superkid.testi.TestiModElements;

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
