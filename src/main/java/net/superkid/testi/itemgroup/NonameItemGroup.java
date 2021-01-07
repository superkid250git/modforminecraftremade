
package net.superkid.testi.itemgroup;

import net.superkid.testi.item.SightlygoldenappleItem;
import net.superkid.testi.TestiModElements;

@TestiModElements.ModElement.Tag
public class NonameItemGroup extends TestiModElements.ModElement {
	public NonameItemGroup(TestiModElements instance) {
		super(instance, 21);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabnoname") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(SightlygoldenappleItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
