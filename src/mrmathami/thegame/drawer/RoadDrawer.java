package mrmathami.thegame.drawer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import mrmathami.thegame.entity.GameEntity;
import mrmathami.thegame.entity.tile.Road;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public final class RoadDrawer implements EntityDrawer {
	//private Image image;
	private ArrayList<Image> images = new ArrayList<Image>();

	public RoadDrawer(){
		//image = new Image("file:E:\\GITTTTTTT\\test\\IMG\\Road\\1.png");
		images.add(new Image("file:E:\\GITTTTTTT\\test\\IMG\\Road\\1.png") );
		for (int i = 1; i <= 13; i++) {
			images.add(new Image("file:E:\\GITTTTTTT\\test\\IMG\\Road\\" + String.valueOf(i) + ".png") );
		}
	}

	@Override
	public void draw(long tickCount, @Nonnull GraphicsContext graphicsContext, @Nonnull GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight, double zoom) {
		//graphicsContext.setFill(Color.LIGHTGREEN);
		//graphicsContext.fillRect(screenPosX, screenPosY, screenWidth, screenHeight);
		//if (entity instanceof Road) {
		//	graphicsContext.setFill(Color.BLACK);
		//	graphicsContext.fillText(String.format("%2.2f", ((Road) entity).getDistance()), screenPosX, screenPosY + screenHeight / 2);
		//}
		Road road = (Road) entity;
		graphicsContext.drawImage(images.get(road.imageCode), screenPosX, screenPosY, screenWidth, screenHeight);
	}
}
