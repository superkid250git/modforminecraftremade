
package net.superkid.testi.item;

import org.omg.CORBA.ObjectHolder;

import net.superkid.testi.itemgroup.NonameItemGroup;
import net.superkid.testi.TestiModElements;

@TestiModElements.ModElement.Tag
public class NotgoldSwordItem extends TestiModElements.ModElement {
	@ObjectHolder("testi:notgold_sword")
	public static final Item block = null;
	public NotgoldSwordItem(TestiModElements instance) {
		super(instance, 11);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 102;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 0f;
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
		}, 3, -3f, new Item.Properties().group(NonameItemGroup.tab)) {
		}.setRegistryName("notgold_sword"));
	}
}
