package mrmathami.thegame.drawer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import mrmathami.thegame.entity.GameEntity;
import mrmathami.thegame.entity.enemy.NormalEnemy;
import mrmathami.thegame.entity.tile.spawner.NormalSpawner;

import javax.annotation.Nonnull;

public final class NormalEnemyDrawer implements EntityDrawer {
	private Image image;

	public NormalEnemyDrawer(){
		image = new Image("file:E:\\GITTTTTTT\\test\\IMG\\Enemy\\1.png");
	}

	@Override
	public void draw(long tickCount, @Nonnull GraphicsContext graphicsContext, @Nonnull GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight, double zoom) {
		graphicsContext.setFill(Color.DARKMAGENTA);
		graphicsContext.fillRoundRect(screenPosX, screenPosY, screenWidth, screenHeight, 4, 4);
		graphicsContext.drawImage(image, screenPosX, screenPosY, screenWidth, screenHeight);
	}
}
