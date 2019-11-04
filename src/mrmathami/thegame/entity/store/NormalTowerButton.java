package mrmathami.thegame.entity.store;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import mrmathami.thegame.entity.tile.tower.NormalTower;

public final class NormalTowerButton extends AbstractButton {
    NormalTowerButton(StoreManager store, long createdTick, double posX, double posY, double width, double height){
        super(createdTick, posX, posY, width, height,
                "-fx-background-color: transparent; -fx-background-image: url('file:E:/GITTTTTTT/test/IMG/Button/Press1.png');",
                "-fx-background-color: transparent; -fx-background-image: url('file:E:/GITTTTTTT/test/IMG/Button/1.png');");
        //"-fx-background-color: transparent; -fx-background-image: url('file:C:/Users/dell/Desktop/Defence-Tower-master/IMG/Tower');"
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                NormalTowerButton.super.setButtonPressedStyle();
                store.isSelectedTower = true;
                store.towerSelectedCode = 0;
            }
        });

        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                NormalTowerButton.super.setButtonReleasedStyle();
            }
        });
    }

    /*public final NormalTower getTower(long createdTick, long posX, long posY){
        return new NormalTower(createdTick, posX, posY);
    }*/
}
