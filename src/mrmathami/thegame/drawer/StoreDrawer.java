package mrmathami.thegame.drawer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import mrmathami.thegame.Config;
import mrmathami.thegame.entity.GameEntity;

import javax.annotation.Nonnull;

public final class StoreDrawer implements EntityDrawer {
    private Image image;

    public StoreDrawer(){
        image = new Image("file:E:\\GITTTTTTT\\test\\IMG\\Mountain\\1.png");
    }

    @Override
    public void draw(long tickCount, @Nonnull GraphicsContext graphicsContext, @Nonnull GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight, double zoom) {
        //graphicsContext.drawImage(image, 0, 22 * Config.TILE_SIZE, screenWidth, screenHeight);
        graphicsContext.setFill(Color.LIGHTSKYBLUE);
        graphicsContext.fillRoundRect(screenPosX, screenPosY, screenWidth, screenHeight, 4, 4);
    }
}
