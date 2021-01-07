
package net.superkid.testi.entity;

import net.superkid.testi.TestiModElements;

@TestiModElements.ModElement.Tag
public class ZombiepiggirlEntity extends TestiModElements.ModElement {
	public static EntityType entity = null;
	public ZombiepiggirlEntity(TestiModElements instance) {
		super(instance, 59);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("zombiepiggirl")
						.setRegistryName("zombiepiggirl");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -65281, -3407668, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("zombiepiggirl_spawn_egg"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelpigzombie(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("testi:textures/zombie_pigman_girl.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
			enablePersistence();
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false));
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new SwimGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}
	}

	// Made with Blockbench 3.6.6
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelpigzombie extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer body;
		private final ModelRenderer leftArm;
		private final ModelRenderer rightArm;
		private final ModelRenderer leftLeg;
		private final ModelRenderer rightLeg;
		private final ModelRenderer hat;
		public Modelpigzombie() {
			textureWidth = 64;
			textureHeight = 64;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, true);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, true);
			leftArm = new ModelRenderer(this);
			leftArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
			leftArm.setTextureOffset(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			rightArm = new ModelRenderer(this);
			rightArm.setRotationPoint(5.0F, 2.0F, 0.0F);
			rightArm.setTextureOffset(40, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
			leftLeg = new ModelRenderer(this);
			leftLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
			leftLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			rightLeg = new ModelRenderer(this);
			rightLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
			rightLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
			hat = new ModelRenderer(this);
			hat.setRotationPoint(0.0F, 0.0F, 0.0F);
			hat.setTextureOffset(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, true);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			leftArm.render(matrixStack, buffer, packedLight, packedOverlay);
			rightArm.render(matrixStack, buffer, packedLight, packedOverlay);
			leftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			rightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			hat.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.rightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.rightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.leftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.hat.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.hat.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}
}
