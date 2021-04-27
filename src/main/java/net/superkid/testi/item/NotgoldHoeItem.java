
package net.superkid.testi.item;

import net.superkid.testi.itemgroup.NonameItemGroup;
import net.superkid.testi.TestiModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

@TestiModElements.ModElement.Tag
public class NotgoldHoeItem extends TestiModElements.ModElement {
	@ObjectHolder("testi:notgold_hoe")
	public static final Item block = null;
	public NotgoldHoeItem(TestiModElements instance) {
		super(instance, 13);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 50;
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
		}, 0, -3f, new Item.Properties().group(NonameItemGroup.tab)) {
		}.setRegistryName("notgold_hoe"));
	}
}
