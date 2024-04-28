package chapter_6.game_three_ships;

public class GameField {

    private final int horizontal;
    private final int vertical;
    private boolean hit = false;
    private boolean occupied = false;
    private boolean nearShip = false;

    public GameField(int horizontal, int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isNearShip() {
        return nearShip;
    }

    public void setNearShip(boolean nearShip) {
        this.nearShip = nearShip;
    }

    @Override
    public String toString() {
        return "{" + getHorizontal() +
                "," + getVertical() +
                "}";
    }
}
