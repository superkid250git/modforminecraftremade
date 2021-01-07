
package net.superkid.testi.item;

import org.omg.CORBA.ObjectHolder;

import net.superkid.testi.itemgroup.NonameItemGroup;
import net.superkid.testi.TestiModElements;

@TestiModElements.ModElement.Tag
public class NotgoldAxeItem extends TestiModElements.ModElement {
	@ObjectHolder("testi:notgold_axe")
	public static final Item block = null;
	public NotgoldAxeItem(TestiModElements instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 150;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(NgoldingotItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(NonameItemGroup.tab)) {
		}.setRegistryName("notgold_axe"));
	}
}
