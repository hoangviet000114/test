package mrmathami.thegame.drawer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import mrmathami.thegame.entity.GameEntity;

import javax.annotation.Nonnull;

public final class NormalTowerDrawer implements EntityDrawer {
	private Image image;

	public NormalTowerDrawer(){
		image = new Image("file:E:\\GITTTTTTT\\test\\IMG\\Tower\\1.png");
	}

	@Override
	public void draw(long tickCount, @Nonnull GraphicsContext graphicsContext, @Nonnull GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight, double zoom) {
		//graphicsContext.setFill(Color.RED);
		//graphicsContext.fillOval(screenPosX, screenPosY, screenWidth, screenHeight);
		graphicsContext.drawImage(image, screenPosX, screenPosY, screenWidth, screenHeight);
	}
}
