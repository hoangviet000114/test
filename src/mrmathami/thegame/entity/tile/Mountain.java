package mrmathami.thegame.entity.tile;

import javafx.scene.image.Image;
import mrmathami.thegame.entity.AbstractEntity;
import mrmathami.thegame.entity.GameEntity;

import java.io.InputStream;

public final class Mountain extends AbstractEntity {
	public Mountain(long createdTick, long posX, long posY) {
		super(createdTick, posX, posY, 1L, 1L);
	}
}
