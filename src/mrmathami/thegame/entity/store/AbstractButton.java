package mrmathami.thegame.entity.store;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import mrmathami.thegame.Config;
import mrmathami.thegame.entity.tile.tower.AbstractTower;

public abstract class AbstractButton<V extends AbstractTower> extends Button {
    private final String PRESS_STYLE;
    private final String FREE_STYLE;

    protected AbstractButton(long createdTick, double posX, double posY, double width, double height, String pressStyle, String releaseStyle){
        PRESS_STYLE = pressStyle;
        FREE_STYLE = releaseStyle;

        setPrefWidth(width);
        setPrefHeight(height);
        setStyle(FREE_STYLE);
        setLayoutX(posX * Config.TILE_SIZE);
        setLayoutY(posY * Config.TILE_SIZE);
        initiallizeButtonListeners();
    }

    public final void setButtonPressedStyle(){
        setStyle(PRESS_STYLE);
        setPrefHeight(getPrefHeight() - 4);
        setLayoutY(getLayoutY() + 4);
    }

    protected final void setButtonReleasedStyle(){
        setStyle(FREE_STYLE);
        setPrefHeight(getPrefHeight() + 4);
        setLayoutY(getLayoutY() - 4);
    }

    private final void initiallizeButtonListeners(){
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setEffect(new DropShadow());
            }
        });

        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setEffect(null);
            }
        });
    }

    //protected abstract V getTower(long createdTick, long posX, long posY);
}
