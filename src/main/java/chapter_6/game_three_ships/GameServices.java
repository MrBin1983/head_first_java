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
//
//
//        return newShipLocation;
//
//    }

    public ArrayList<GameField> getNewGameField(int numberOfFields) {
        ArrayList<GameField> allGameField = new ArrayList<>();
        for (int i = 1; i < numberOfFields + 1; i++) {
            for (int j = 1; j < numberOfFields + 1; j++) {
                allGameField.add(new GameField(i, j));
            }
        }
        return allGameField;
    }

    public void createNewShip(int numberOfFields, int deck, ArrayList<Ship> allShips, ArrayList<GameField> allGameField) {

        ArrayList<GameField> possibleLocations = allGameField;  //создаем массив возможных начальных клеток расположения корабля

        possibleLocations.removeIf(GameField::isOccupied);

        ArrayList<GameField> possibleLocationsHorizontal = possibleLocations;
        ArrayList<GameField> possibleLocationsVertical = possibleLocations;


        for (GameField loc : possibleLocations) {
            if (loc.isNearShip()) {
                possibleLocationsHorizontal.removeIf(
                        locHor -> locHor.getVertical() == loc.getVertical() &&
                                locHor.getHorizontal() <= loc.getHorizontal() &&
                                locHor.getHorizontal() > loc.getHorizontal() - deck + 1);
                possibleLocationsVertical.removeIf(
                        locHor -> locHor.getHorizontal() == loc.getHorizontal() &&
                                locHor.getVertical() <= loc.getVertical() &&
                                locHor.getVertical() > loc.getVertical() - deck + 1);
            }
        }

        possibleLocationsHorizontal.removeIf(locHor -> locHor.getHorizontal() > numberOfFields - deck + 1);
        possibleLocationsVertical.removeIf(locVer -> locVer.getVertical() > numberOfFields - deck + 1);

        ArrayList<GameField> newShipLocation = new ArrayList<>();

        if (possibleLocationsHorizontal.isEmpty()) {

            int randomVertical = (int) (Math.random() * possibleLocationsVertical.size()); //создаем начальную клетку расположения корабля по вертикали

            for (int i = 0; i < deck; i++) {
                newShipLocation.add(possibleLocationsVertical.get(i + randomVertical));
            }
        } else if (possibleLocationsVertical.isEmpty()) {

            int randomHorizontal = (int) (Math.random() * possibleLocationsHorizontal.size()); //создаем начальную клетку расположения корабля по горизонтали

            for (int i = 0; i < deck; i++) {
                newShipLocation.add(possibleLocationsHorizontal.get(i + randomHorizontal));
            }
        } else {

            int randomDirection = (int) (Math.random() * 2);


            if (randomDirection == 0) {

                int randomHorizontal = (int) (Math.random() * possibleLocationsHorizontal.size()); //создаем начальную клетку расположения корабля по горизонтали

                for (int i = 0; i < deck; i++) {
                    newShipLocation.add(possibleLocationsHorizontal.get(i + randomHorizontal));
                }

            } else {

                int randomVertical = (int) (Math.random() * possibleLocationsVertical.size()); //создаем начальную клетку расположения корабля по вертикали

                for (int i = 0; i < deck; i++) {
                    newShipLocation.add(possibleLocationsVertical.get(i + randomVertical));
                }
            }

        }

        allShips.add(new Ship( deck, newShipLocation));

    }





}
