package mrmathami.thegame.entity.store;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import mrmathami.thegame.entity.tile.tower.MachineGunTower;
import mrmathami.thegame.entity.tile.tower.NormalTower;

public final class MachineGunTowerButton extends AbstractButton {
    MachineGunTowerButton(StoreManager store, long createdTick, double posX, double posY, double width, double height){
        super(createdTick, posX, posY, width, height,
                "-fx-background-color: transparent; -fx-background-image: url('file:E:/GITTTTTTT/test/IMG/Button/Press2.png');",
                "-fx-background-color: transparent; -fx-background-image: url('file:E:/GITTTTTTT/test/IMG/Button/2.png');");

        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                MachineGunTowerButton.super.setButtonPressedStyle();
                store.isSelectedTower = true;
                store.towerSelectedCode = 1;
            }
        });

        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                MachineGunTowerButton.super.setButtonReleasedStyle();
            }
        });
    }

    /*public final MachineGunTower getTower(long createdTick, long posX, long posY){
        return new MachineGunTower(createdTick, posX, posY);
    }*/
}
