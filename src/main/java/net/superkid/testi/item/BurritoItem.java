
package net.superkid.testi.item;

import org.omg.CORBA.ObjectHolder;

import net.superkid.testi.itemgroup.NonameItemGroup;
import net.superkid.testi.TestiModElements;

@TestiModElements.ModElement.Tag
public class BurritoItem extends TestiModElements.ModElement {
	@ObjectHolder("testi:burrito")
	public static final Item block = null;
	public BurritoItem(TestiModElements instance) {
		super(instance, 16);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(NonameItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(4).saturation(0.3f).build()));
			setRegistryName("burrito");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
