
package net.superkid.testi.block;

import org.omg.CORBA.ObjectHolder;

import net.superkid.testi.TestiModElements;

import net.minecraft.block.material.Material;

import java.util.List;
import java.util.Collections;

@TestiModElements.ModElement.Tag
public class FlowerstaueBlock extends TestiModElements.ModElement {
	@ObjectHolder("testi:flowerstaue")
	public static final Block block = null;
	public FlowerstaueBlock(TestiModElements instance) {
		super(instance, 52);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(null)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}
	public static class CustomBlock extends Block {
		public static final DirectionProperty FACING = DirectionalBlock.FACING;
		public CustomBlock() {
			super(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(1f, 10f).lightValue(0).notSolid());
			this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
			setRegistryName("flowerstaue");
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public boolean isEmissiveRendering(BlockState blockState) {
			return true;
		}

		@Override
		public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return false;
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
			Vec3d offset = state.getOffset(world, pos);
			switch ((Direction) state.get(FACING)) {
				case SOUTH :
				default :
					return VoxelShapes.create(1D, 0D, 1D, 0D, 2.1D, 0D).withOffset(offset.x, offset.y, offset.z);
				case NORTH :
					return VoxelShapes.create(0D, 0D, 0D, 1D, 2.1D, 1D).withOffset(offset.x, offset.y, offset.z);
				case WEST :
					return VoxelShapes.create(0D, 0D, 1D, 1D, 2.1D, 0D).withOffset(offset.x, offset.y, offset.z);
				case EAST :
					return VoxelShapes.create(1D, 0D, 0D, 0D, 2.1D, 1D).withOffset(offset.x, offset.y, offset.z);
				case UP :
					return VoxelShapes.create(0D, 1D, 0D, 1D, 0D, 2.1D).withOffset(offset.x, offset.y, offset.z);
				case DOWN :
					return VoxelShapes.create(0D, 0D, 1D, 1D, 1D, -1.1D).withOffset(offset.x, offset.y, offset.z);
			}
		}

		@Override
		protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
			builder.add(FACING);
		}

		public BlockState rotate(BlockState state, Rotation rot) {
			return state.with(FACING, rot.rotate(state.get(FACING)));
		}

		public BlockState mirror(BlockState state, Mirror mirrorIn) {
			return state.rotate(mirrorIn.toRotation(state.get(FACING)));
		}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			;
			return this.getDefaultState().with(FACING, context.getNearestLookingDirection().getOpposite());
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
