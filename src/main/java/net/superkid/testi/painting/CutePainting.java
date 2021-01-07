
package net.superkid.testi.painting;

import net.superkid.testi.TestiModElements;

@TestiModElements.ModElement.Tag
public class CutePainting extends TestiModElements.ModElement {
	public CutePainting(TestiModElements instance) {
		super(instance, 58);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(32, 32).setRegistryName("cute"));
	}
}
