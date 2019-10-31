package mrmathami.thegame.entity.store;

import javafx.scene.control.Button;
import mrmathami.thegame.entity.AbstractEntity;

public class StoreManager extends AbstractEntity {
    private final Button normalButton;

    public StoreManager(long createdTick, double posX, double posY, double width, double height) {
        super(createdTick, posX, posY, width, height);
        normalButton = new Button("Ahihi");

    }
}
