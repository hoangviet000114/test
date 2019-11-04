package mrmathami.thegame.entity.store;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import mrmathami.thegame.Config;
import mrmathami.thegame.GameField;
import mrmathami.thegame.entity.AbstractEntity;
import mrmathami.thegame.entity.GameEntity;
import mrmathami.thegame.entity.UpdatableEntity;
import mrmathami.thegame.entity.tile.Road;
import mrmathami.thegame.entity.tile.tower.AbstractTower;
import mrmathami.thegame.entity.tile.tower.MachineGunTower;
import mrmathami.thegame.entity.tile.tower.NormalTower;
import mrmathami.thegame.entity.tile.tower.SniperTower;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public final class StoreManager extends AbstractEntity implements UpdatableEntity {
    private NormalTowerButton normalTowerButton;
    private MachineGunTowerButton machineGunTowerButton;
    private SniperTowerButton sniperTowerButton;
    //private final Scene scene;
    public final Mouse mouse;

    public boolean isSelectedTower = false;
    public boolean isSelectedPos = false;
    public int towerSelectedCode;
    public long mousePosXSelected;
    public long mousePosYSelected;

    public StoreManager(AnchorPane pane, Scene scene, long createdTick, double posX, double posY, double width, double height) {
        super(createdTick, posX, posY, width, height);
        mouse = new Mouse(createdTick, scene, this);
        //this.scene = scene;
        normalTowerButton = new NormalTowerButton(this, createdTick, super.getPosX() + 1, super.getPosY() + 1, 128, 100);
        machineGunTowerButton = new MachineGunTowerButton(this, createdTick, super.getPosX() + 6, super.getPosY() + 1, 128, 100);
        sniperTowerButton = new SniperTowerButton(this, createdTick, super.getPosX() + 11, super.getPosY() + 1, 128, 100);

        pane.getChildren().add(normalTowerButton);
        pane.getChildren().add(machineGunTowerButton);
        pane.getChildren().add(sniperTowerButton);
    }

    @Override
    public final void onUpdate(@Nonnull GameField field){
        mouse.onUpdate(field);
        if (isSelectedPos == true){
            isSelectedPos = false;
            boolean canSpawn = true;

            for (GameEntity entity : field.getEntities()){
                if ((entity instanceof Road || entity instanceof AbstractTower) &&
                        entity.getPosX() == mousePosXSelected && entity.getPosY() == mousePosYSelected){
                    canSpawn = false;
                    break;
                }
            }
            if (canSpawn) field.doSpawn(this.doSpawn(field.getTickCount(), mousePosXSelected, mousePosYSelected));
        }
    }

    protected final AbstractTower doSpawn(long createdTick, long posX, long posY){
        if (towerSelectedCode == 0) return new NormalTower(createdTick, posX, posY);
        if (towerSelectedCode == 1) return new MachineGunTower(createdTick, posX, posY);
        if (towerSelectedCode == 2) return new SniperTower(createdTick, posX, posY);
        return null;
    }
}
