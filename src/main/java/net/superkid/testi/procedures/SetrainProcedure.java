package net.superkid.testi.procedures;

import net.superkid.testi.TestiModElements;

import java.util.Map;

@TestiModElements.ModElement.Tag
public class SetrainProcedure extends TestiModElements.ModElement {
	public SetrainProcedure(TestiModElements instance) {
		super(instance, 60);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure Setrain!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure Setrain!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure Setrain!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure Setrain!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getWorld().isThundering()) || (world.getWorld().isRaining()))) {
			if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
				world.getWorld().getServer().getCommandManager().handleCommand(new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO,
						(ServerWorld) world, 4, "", new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
						"weather rain");
			}
		} else {
			if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
				world.getWorld().getServer().getCommandManager().handleCommand(new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO,
						(ServerWorld) world, 4, "", new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
						"weather clear");
			}
		}
	}
}
