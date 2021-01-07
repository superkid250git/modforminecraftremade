
package net.superkid.testi.item;

import org.omg.CORBA.ObjectHolder;

import net.superkid.testi.TestiModElements;

@TestiModElements.ModElement.Tag
public class RainbowdiamondItem extends TestiModElements.ModElement {
	@ObjectHolder("testi:rainbowdiamond")
	public static final Item block = null;
	public RainbowdiamondItem(TestiModElements instance) {
		super(instance, 49);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(null).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("rainbowdiamond");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
