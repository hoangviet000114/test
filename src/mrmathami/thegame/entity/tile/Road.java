package mrmathami.thegame.entity.tile;

public final class Road extends AbstractTile {
	private double distance = Double.NaN;
	public int imageCode;

	public Road(long createdTick, long posX, long posY, int imageCode) {
		super(createdTick, posX, posY, 1L, 1L);
		this.imageCode = imageCode;
	}

	public final double getDistance() {
		return distance;
	}

	public final void setDistance(double distance) {
		this.distance = distance;
	}
}
