
package net.superkid.testi.item;

import org.omg.CORBA.ObjectHolder;

import net.superkid.testi.itemgroup.NonameItemGroup;
import net.superkid.testi.TestiModElements;

@TestiModElements.ModElement.Tag
public class JustbeatsItem extends TestiModElements.ModElement {
	@ObjectHolder("testi:justbeats")
	public static final Item block = null;
	public JustbeatsItem(TestiModElements instance) {
		super(instance, 18);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, TestiModElements.sounds.get(new ResourceLocation("testi:odd")),
					new Item.Properties().group(NonameItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("justbeats");
		}
	}
}
