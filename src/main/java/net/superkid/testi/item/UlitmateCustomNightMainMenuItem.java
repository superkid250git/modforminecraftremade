
package net.superkid.testi.item;

import org.omg.CORBA.ObjectHolder;

import net.superkid.testi.itemgroup.NonameItemGroup;
import net.superkid.testi.TestiModElements;

@TestiModElements.ModElement.Tag
public class UlitmateCustomNightMainMenuItem extends TestiModElements.ModElement {
	@ObjectHolder("testi:ulitmate_custom_night_main_menu")
	public static final Item block = null;
	public UlitmateCustomNightMainMenuItem(TestiModElements instance) {
		super(instance, 56);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, TestiModElements.sounds.get(new ResourceLocation("testi:fanf_ultimate_custom_night_main_menu_theme")),
					new Item.Properties().group(NonameItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("ulitmate_custom_night_main_menu");
		}
	}
}
