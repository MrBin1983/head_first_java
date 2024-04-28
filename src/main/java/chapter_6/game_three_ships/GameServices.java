package chapter_6.game_three_ships;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameServices {

    public String getUserInput(String prompt) {

        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }

        return inputLine;
    }

//    public ArrayList<GameField> getNewShipLocation(int deck, ArrayList<GameField> gameField, ArrayList<Ship> allShips) {
//
//
//
//        int randomDirection = (int) (Math.random() * 2);
//
//        ArrayList<GameField> newShipLocation = new ArrayList<>();
//
//        if (randomDirection == 0) {
//
//            for (int i = 0; i < deck; i++) {
//
//                int randomHorizontal = (int) (Math.random() * (7 - deck)); //создаем начальную клетку расположения корабля по горизонтали
//
//                int randomVertical = (int) (Math.random() * (7 - deck)); //создаем начальную клетку расположения корабля
//
//                //            newLocationShip.add(String.valueOf((char)('A' + randomHorizontal + i)) + (randomVertical + 1));
//            }
//
//        } else {
//
//            for (int i = 0; i < deck; i++) {
//                //            newLocationShip.add(String.valueOf((char)('A' + randomHorizontal)) + (1 + i + randomVertical));
//            }
//        }
//
//        return newShipLocation;
//
//    }

    public ArrayList<GameField> getNewGameField(int numberOfFields) {
        ArrayList<GameField> allGameField = new ArrayList<>();
        for (int i = 1; i < numberOfFields + 1; i++) {
            for (int j = 1; j < numberOfFields + 1; j++) {
                allGameField.add(new GameField(i,j));
            }
        }
        return allGameField;
    }

    public ArrayList<Ship> createNewShip(int deck, ArrayList<Ship> allShips, ArrayList<GameField> allGameField) {

        ArrayList<GameField> shipLocation = new ArrayList<>();

        Ship ship = new Ship(deck, shipLocation);

        allShips.add(ship);
        return allShips;
    }


}
