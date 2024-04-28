package chapter_6.game_three_ships;

import java.util.ArrayList;

public class ShipTest {

    public static void main(String[] args) {

        GameServices gameServices = new GameServices();

        int numberOfFields = 10;

        ArrayList<GameField> allGameField = gameServices.getNewGameField(numberOfFields);

        int deck = 3; //количество палуб

        ArrayList<Ship> allShips = new ArrayList<>();

        gameServices.createNewShip(numberOfFields, deck, allShips, allGameField);

        System.out.println(allShips);

        System.out.println(allGameField);
    }

}
