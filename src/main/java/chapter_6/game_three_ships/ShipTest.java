package chapter_6.game_three_ships;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShipTest {

    public static void main(String[] args) {

        GameServices gameServices = new GameServices();

        int numberOfFields = 10;

        ArrayList<GameField> allGameField = gameServices.getNewGameField(numberOfFields);

        Map<Integer, Integer> userShips = new HashMap<>();

        userShips.put(1, 4);
        userShips.put(2, 3);
        userShips.put(3, 2);
        userShips.put(4, 1);

        ArrayList<Ship> allShips = new ArrayList<>();

        gameServices.createNewShip(numberOfFields, userShips, allShips, allGameField);

        System.out.println(allShips);

        System.out.println(allGameField);

        for (GameField gf: allGameField) {
            System.out.println("(" + gf.getHorizontal() + "-" + gf.getVertical() + "-" + gf.isOccupied() + "-" + gf.isNearShip() + ")");
        }
    }

}
