package mrmathami.thegame.drawer;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import mrmathami.thegame.entity.GameEntity;
import mrmathami.thegame.entity.enemy.NormalEnemy;
import mrmathami.thegame.entity.enemy.TankerEnemy;

import javax.annotation.Nonnull;

public final class TankerEnemyDrawer implements EntityDrawer {
	private Image image;

	public TankerEnemyDrawer(){
		image = new Image("file:C:\\Users\\dell\\Desktop\\TD for test\\Defence-Tower-alots\\IMG\\Enemy\\2.png");
	}

	@Override
	public void draw(long tickCount, @Nonnull GraphicsContext graphicsContext, @Nonnull GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight, double zoom) {
		//graphicsContext.setFill(Color.VIOLET);
		//graphicsContext.fillRoundRect(screenPosX, screenPosY, screenWidth, screenHeight, 4, 4);
		SnapshotParameters params = new SnapshotParameters();
		params.setFill(Color.TRANSPARENT);

		ImageView iv = new ImageView(image);
		TankerEnemy enemy = (TankerEnemy) entity;
		iv.setRotate(enemy.getDirect());
		Image base = iv.snapshot(params, null);
		graphicsContext.drawImage(base, screenPosX, screenPosY, screenWidth, screenHeight);
	}
}