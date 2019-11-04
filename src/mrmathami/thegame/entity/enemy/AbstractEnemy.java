package mrmathami.thegame.entity.enemy;

import mrmathami.thegame.GameEntities;
import mrmathami.thegame.GameField;
import mrmathami.thegame.entity.*;
import mrmathami.thegame.entity.tile.Road;

import javax.annotation.Nonnull;
import java.util.Collection;

public abstract class AbstractEnemy extends AbstractEntity implements UpdatableEntity, EffectEntity, LivingEntity, DestroyListener {
	private static final double SQRT_2 = Math.sqrt(2.0) / 2.0;
	private static final double[][] DELTA_DIRECTION_ARRAY = {
			{0.0, -1.0}, {0.0, 1.0}, {-1.0, 0.0}, {1.0, 0.0},
			{-SQRT_2, -SQRT_2}, {SQRT_2, SQRT_2}, {SQRT_2, -SQRT_2}, {-SQRT_2, SQRT_2},
	};

	private long health;
	private long armor;
	private double speed;
	private long reward;
	private long deltaDirectionX;
	private long deltaDirectionY;

	protected AbstractEnemy(long createdTick, double posX, double posY, double size, long health, long armor, double speed, long reward) {
		super(createdTick, posX, posY, size, size);
		this.health = health;
		this.armor = armor;
		this.speed = speed;
		this.reward = reward;
	}

	private static double evaluateDistance(@Nonnull Collection<GameEntity> overlappableEntities,
			@Nonnull GameEntity sourceEntity, double posX, double posY, double width, double height) {
		double distance = 0.0;
		double sumArea = 0.0;
		for (GameEntity entity : GameEntities.getOverlappedEntities(overlappableEntities, posX, posY, width, height)) {
			if (sourceEntity != entity && GameEntities.isCollidable(sourceEntity.getClass(), entity.getClass())) return Double.NaN;
			if (entity instanceof Road) {
				final double entityPosX = entity.getPosX();
				final double entityPosY = entity.getPosY();
				final double area = (Math.min(posX + width, entityPosX + entity.getWidth()) - Math.max(posX, entityPosX))
						* (Math.min(posY + height, entityPosY + entity.getHeight()) - Math.max(posY, entityPosY));
				sumArea += area;
				distance += area * ((Road) entity).getDistance();
			}
		}
		return distance / sumArea;
	}

	@Override
	public final void onUpdate(@Nonnull GameField field) {
		final double enemyPosX = getPosX();
		final double enemyPosY = getPosY();
		final double enemyWidth = getWidth();
		final double enemyHeight = getHeight();
		final Collection<GameEntity> overlappableEntities = GameEntities.getOverlappedEntities(field.getEntities(),
				getPosX() - speed, getPosY() - speed, speed + getWidth() + speed, speed + getHeight() + speed);
		double minimumDistance = Double.MAX_VALUE;
		double newPosX = enemyPosX;
		double newPosY = enemyPosY;
		for (double realSpeed = speed * 0.125; realSpeed <= speed; realSpeed += realSpeed) {
			for (double[] deltaDirection : DELTA_DIRECTION_ARRAY) {
				final double currentPosX = enemyPosX + deltaDirection[0] * realSpeed;
				final double currentPosY = enemyPosY + deltaDirection[1] * realSpeed;
				final double currentDistance = evaluateDistance(overlappableEntities, this, currentPosX, currentPosY, enemyWidth, enemyHeight);
				if (currentDistance < minimumDistance) {
					minimumDistance = currentDistance;
					newPosX = currentPosX;
					newPosY = currentPosY;
				}
			}
		}

		setDeltaDirectionX(enemyPosX, newPosX);
		setDeltaDirectionY(enemyPosY, newPosY);
		setPosX(newPosX);
		setPosY(newPosY);
	}

	@Override
	public final void onDestroy(@Nonnull GameField field) {
		// TODO: reward
	}

	@Override
	public final boolean onEffect(@Nonnull GameField field, @Nonnull LivingEntity livingEntity) {
		// TODO: harm the target
		this.health = Long.MIN_VALUE;
		return false;
	}

	@Override
	public final long getHealth() {
		return health;
	}

	@Override
	public final void doEffect(long value) {
		if (health != Long.MIN_VALUE && (value < -armor || value > 0)) this.health += value;
	}

	@Override
	public final void doDestroy() {
		this.health = Long.MIN_VALUE;
	}

	@Override
	public final boolean isDestroyed() {
		return health <= 0L;
	}

	public final long getDeltaDirectionX() {
		return deltaDirectionX;
	}

	public final long getDeltaDirectionY() {
		return deltaDirectionY;
	}

	public final void setDeltaDirectionX(double posX, double newPosX) {
		if (newPosX - posX > 0)
			this.deltaDirectionX = 1;
		else if (newPosX - posX < 0)
			this.deltaDirectionX = -1;
		else
			this.deltaDirectionX = 0;
	}

	public final void setDeltaDirectionY(double posY, double newPosY) {
		if (newPosY - posY > 0)
			this.deltaDirectionY = 1;
		else if (newPosY - posY < 0)
			this.deltaDirectionY = -1;
		else
			this.deltaDirectionY = 0;
	}

	public final long getDirect(){
		if (this.getDeltaDirectionX() == -1 && this.getDeltaDirectionY() == -1)
			return 315;
		if (this.getDeltaDirectionX() == -1 && this.getDeltaDirectionY() == 0)
			return 270;
		if (this.getDeltaDirectionX() == -1 && this.getDeltaDirectionY() == 1)
			return 225;
		if (this.getDeltaDirectionX() == 0 && this.getDeltaDirectionY() == 1)
			return 180;
		if (this.getDeltaDirectionX() == 1 && this.getDeltaDirectionY() == 1)
			return 135;
		if (this.getDeltaDirectionX() == 1 && this.getDeltaDirectionY() == 0)
			return 90;
		if (this.getDeltaDirectionX() == 1 && this.getDeltaDirectionY() == -1)
			return 45;
		if (this.getDeltaDirectionX() == 0 && this.getDeltaDirectionY() == -1)
			return 0;
		return 0;
	}
}
