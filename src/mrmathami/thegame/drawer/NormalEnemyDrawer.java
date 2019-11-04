package mrmathami.thegame.drawer;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import mrmathami.thegame.entity.AbstractEntity;
import mrmathami.thegame.entity.GameEntity;
import mrmathami.thegame.entity.enemy.AbstractEnemy;
import mrmathami.thegame.entity.enemy.NormalEnemy;
import mrmathami.thegame.entity.tile.spawner.NormalSpawner;

import javax.annotation.Nonnull;

public final class NormalEnemyDrawer implements EntityDrawer {
	Image image;

	public NormalEnemyDrawer(){
		image = new Image("file:C:\\Users\\dell\\Desktop\\TD for test\\Defence-Tower-alots\\IMG\\Enemy\\1.png");
	}

	@Override
	public void draw(long tickCount, @Nonnull GraphicsContext graphicsContext, @Nonnull GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight, double zoom) {
		//graphicsContext.setFill(Color.DARKMAGENTA);
		//graphicsContext.fillRoundRect(screenPosX, screenPosY, screenWidth, screenHeight, 4, 4);
		SnapshotParameters params = new SnapshotParameters();
		params.setFill(Color.TRANSPARENT);

		ImageView iv = new ImageView(image);
		NormalEnemy enemy = (NormalEnemy)entity;
		iv.setRotate(enemy.getDirect());
		Image base = iv.snapshot(params, null);
		graphicsContext.drawImage(base, screenPosX, screenPosY, screenWidth, screenHeight);
	}
}