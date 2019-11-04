package mrmathami.thegame.drawer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import mrmathami.thegame.Config;
import mrmathami.thegame.entity.GameEntity;
import mrmathami.thegame.entity.store.Mouse;
import mrmathami.thegame.entity.store.StoreManager;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public final class MouseDrawer implements EntityDrawer {
    private ArrayList<Image> listImage = new ArrayList<Image>();

    public MouseDrawer(){
        listImage.add(new Image("file:C:\\Users\\dell\\Desktop\\Defence-Tower-master\\IMG\\Tower\\1.png"));
        listImage.add(new Image("file:C:\\Users\\dell\\Desktop\\Defence-Tower-master\\IMG\\Tower\\2.png"));
        listImage.add(new Image("file:C:\\Users\\dell\\Desktop\\Defence-Tower-master\\IMG\\Tower\\3.png"));
    }

    @Override
    public void draw(long tickCount, @Nonnull GraphicsContext graphicsContext, @Nonnull GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight, double zoom) {
        Mouse mouse = (Mouse) entity;
        graphicsContext.drawImage(listImage.get(mouse.store.towerSelectedCode), screenPosX, screenPosY, screenWidth, screenHeight);
    }
}
