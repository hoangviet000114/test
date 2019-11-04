package mrmathami.thegame.entity.store;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import mrmathami.thegame.entity.tile.tower.NormalTower;

public final class SniperTowerButton extends AbstractButton {
    SniperTowerButton(StoreManager store, long createdTick, double posX, double posY, double width, double height){
        super(createdTick, posX, posY, width, height,
                "-fx-background-color: transparent; -fx-background-image: url('file:E:/GITTTTTTT/test/IMG/Button/Press3.png');",
                "-fx-background-color: transparent; -fx-background-image: url('file:E:/GITTTTTTT/test/IMG/Button/3.png');");

        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                SniperTowerButton.super.setButtonPressedStyle();
                store.isSelectedTower = true;
                store.towerSelectedCode = 2;
            }
        });

        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                SniperTowerButton.super.setButtonReleasedStyle();
            }
        });
    }

    /*public final NormalTower getTower(long createdTick, long posX, long posY){
        return new NormalTower(createdTick, posX, posY);
    }*/
}
