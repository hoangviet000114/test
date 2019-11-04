package mrmathami.thegame.drawer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import mrmathami.thegame.drawer.EntityDrawer;
import mrmathami.thegame.entity.GameEntity;

import javax.annotation.Nonnull;
import java.io.InputStream;

public final class MountainDrawer implements EntityDrawer {
	Image image;

	public MountainDrawer(){
		image = new Image("file:C:\\Users\\dell\\Desktop\\Defence-Tower-master\\IMG\\Mountain\\1.png");
	}

	@Override
	public void draw(long tickCount, @Nonnull GraphicsContext graphicsContext, @Nonnull GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight, double zoom) {
		graphicsContext.drawImage(image, screenPosX, screenPosY, screenWidth, screenHeight);
	}
}