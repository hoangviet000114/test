package mrmathami.thegame.entity.store;

import javafx.event.EventHandler;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import mrmathami.thegame.Config;
import mrmathami.thegame.GameField;
import mrmathami.thegame.entity.AbstractEntity;
import mrmathami.thegame.entity.GameEntity;
import mrmathami.thegame.entity.UpdatableEntity;
import mrmathami.thegame.entity.tile.Mountain;
import mrmathami.thegame.entity.tile.Road;
import mrmathami.thegame.entity.tile.tower.AbstractTower;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public class Mouse extends AbstractEntity implements UpdatableEntity {
    private Scene scene;
    public StoreManager store;
    public boolean isDrawing;

    public Mouse(long createdTick, Scene scene, StoreManager store){
        super(createdTick, 0, 0, 1, 1);
        this.scene = scene;
        this.store = store;
        this.isDrawing = false;
        initMouseListener(store);
    }

    public final void initMouseListener(StoreManager store){
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (store.isSelectedTower == true){
                    store.isSelectedTower = false;
                    store.isSelectedPos = true;
                    store.mousePosXSelected = (long)mouseEvent.getSceneX() / Config.TILE_SIZE;
                    store.mousePosYSelected = (long)mouseEvent.getSceneY() / Config.TILE_SIZE;
                }
            }
        });
        scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setPosX((long)mouseEvent.getSceneX() / Config.TILE_SIZE);
                setPosY((long)mouseEvent.getSceneY() / Config.TILE_SIZE);
            }
        });
    }

    @Override
    public final void onUpdate(@Nonnull GameField field){
        if (store.isSelectedTower == true) {
            this.isDrawing = false;
            for (GameEntity entity : field.getEntities()){
                if ((entity instanceof Mountain) && entity.getPosX() == this.getPosX() && entity.getPosY() == this.getPosY()){
                    this.isDrawing = true;
                    break;
                }
            }
        }
        else
            this.isDrawing = false;
    }
}
