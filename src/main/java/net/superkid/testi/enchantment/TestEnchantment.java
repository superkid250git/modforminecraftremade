
package net.superkid.testi.enchantment;

import org.omg.CORBA.ObjectHolder;

import net.superkid.testi.TestiModElements;

@TestiModElements.ModElement.Tag
public class TestEnchantment extends TestiModElements.ModElement {
	@ObjectHolder("testi:test")
	public static final Enchantment enchantment = null;
	public TestEnchantment(TestiModElements instance) {
		super(instance, 31);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("test"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.VERY_RARE, EnchantmentType.ALL, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 10;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return false;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}
	}
}
