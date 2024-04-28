package chapter_6.game_three_ships;

public class GameField {

    int horizontal;
    int vertical;
    boolean hit = false;
    boolean occupied = false;
    boolean nearShip = true;

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
}
