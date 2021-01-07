
package net.superkid.testi.item;

import org.omg.CORBA.ObjectHolder;

import net.superkid.testi.procedures.EnchantedopgoldenapplefoodeatenProcedure;
import net.superkid.testi.itemgroup.NonameItemGroup;
import net.superkid.testi.TestiModElements;

import java.util.Map;
import java.util.HashMap;

@TestiModElements.ModElement.Tag
public class EnchantedopgoldenappleItem extends TestiModElements.ModElement {
	@ObjectHolder("testi:enchantedopgoldenapple")
	public static final Item block = null;
	public EnchantedopgoldenappleItem(TestiModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(NonameItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(4).saturation(0.3f).setAlwaysEdible().build()));
			setRegistryName("enchantedopgoldenapple");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				EnchantedopgoldenapplefoodeatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
