package mrmathami.thegame.drawer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import mrmathami.thegame.entity.GameEntity;

import javax.annotation.Nonnull;

public final class NormalBulletDrawer implements EntityDrawer {
	private final RadialGradient gradient = new RadialGradient(
			0.0,
			0.0,
			0.5,
			0.5,
			1.0,
			true,
			CycleMethod.NO_CYCLE,
			new Stop(0.0, Color.YELLOW),
			new Stop(0.5, Color.RED),
			new Stop(1.0, Color.WHITE)
	);

	private Image image;

	public NormalBulletDrawer(){
		image = new Image("file:C:\\Users\\dell\\Desktop\\Defence-Tower-master\\IMG\\Bullet\\1.png");
	}

	@Override
	public void draw(long tickCount, @Nonnull GraphicsContext graphicsContext, @Nonnull GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight, double zoom) {
		graphicsContext.setFill(gradient);
		graphicsContext.fillOval(screenPosX, screenPosY, screenWidth, screenHeight);
		graphicsContext.drawImage(image, screenPosX, screenPosY, screenWidth, screenHeight);
	}
}