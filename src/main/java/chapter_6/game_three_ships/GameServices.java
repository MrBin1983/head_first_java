package chapter_6.game_three_ships;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

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


    public ArrayList<GameField> getNewGameField(int numberOfFields) {
        ArrayList<GameField> allGameField = new ArrayList<>();
        for (int i = 1; i < numberOfFields + 1; i++) {
            for (int j = 1; j < numberOfFields + 1; j++) {
                allGameField.add(new GameField(i, j));
            }
        }
        return allGameField;
    }

    public void createNewShip(int numberOfFields, Map<Integer, Integer> userShips, ArrayList<Ship> allShips, ArrayList<GameField> allGameField) {

        ArrayList<GameField> possibleLocationsHorizontal = new ArrayList<>();  //создаем массив возможных начальных клеток расположения корабля по горизонтали
        ArrayList<GameField> possibleLocationsVertical = new ArrayList<>(); //создаем массив возможных начальных клеток расположения корабля по вертикали

        for (GameField gf : allGameField) {
            GameField cloneGFHor = gf;
            GameField cloneGFVer = gf;
            possibleLocationsHorizontal.add(cloneGFHor);
            possibleLocationsVertical.add(cloneGFVer);
        }

        for (Map.Entry<Integer, Integer> ships : userShips.entrySet()) {

            Integer deck = ships.getKey();

            Integer numberOfShips = ships.getValue();

            for (int i = 0; i < numberOfShips; i++) {

                possibleLocationsHorizontal.removeIf(GameField::isOccupied); //удаляем из массива клетки с кораблями
                possibleLocationsVertical.removeIf(GameField::isOccupied); //удаляем из массива клетки с кораблями

                for (GameField loc : allGameField) { //удаляем из массивов клетки возле кораблей
                    if (loc.isNearShip()) {
                        possibleLocationsHorizontal.removeIf(
                                locHor -> locHor.getHorizontal() == loc.getHorizontal() &&
                                        locHor.getVertical() <= loc.getVertical() - deck + 1);
                    }
                }

                for (GameField loc : allGameField) { //удаляем из массивов клетки возле кораблей
                    if (loc.isNearShip()) {
                        possibleLocationsVertical.removeIf(
                                locHor -> locHor.getVertical() == loc.getVertical() &&
                                        locHor.getHorizontal() <= loc.getHorizontal() - deck + 1);

                    }
                }

                possibleLocationsHorizontal.removeIf(locHor -> locHor.getVertical() > numberOfFields - deck + 1); //удаляем из массивов клетки близкие к краю поля
                possibleLocationsVertical.removeIf(locVer -> locVer.getHorizontal() > numberOfFields - deck + 1); //удаляем из массивов клетки близкие к краю поля

                ArrayList<GameField> newShipLocation = new ArrayList<>();

                if (possibleLocationsHorizontal.isEmpty()) { //если невозможно расположение корабля по горизонтали

                    int randomVertical = (int) (Math.random() * possibleLocationsVertical.size()); //создаем начальную клетку расположения корабля по вертикали

                    newShipLocation.add(possibleLocationsVertical.get(randomVertical));

                    for (GameField gameField : allGameField) {
                        if (gameField.getVertical() == newShipLocation.get(0).getVertical() &&
                                newShipLocation.get(0).getHorizontal() < gameField.getHorizontal() &&
                                gameField.getHorizontal() < (newShipLocation.get(0).getHorizontal() + deck)) {
                            newShipLocation.add(gameField);
                            gameField.setOccupied(true);
                        }
                        if (gameField.getHorizontal() == newShipLocation.get(0).getHorizontal() &&
                                newShipLocation.get(0).getVertical() == gameField.getVertical()) {
                            gameField.setOccupied(true);
                        }
                    }
                } else if (possibleLocationsVertical.isEmpty()) { //если невозможно расположение корабля по вертикали

                    int randomHorizontal = (int) (Math.random() * possibleLocationsHorizontal.size()); //создаем начальную клетку расположения корабля по горизонтали

                    newShipLocation.add(possibleLocationsHorizontal.get(randomHorizontal));

                    for (GameField gameField : allGameField) {
                        if (gameField.getHorizontal() == newShipLocation.get(0).getHorizontal() &&
                                newShipLocation.get(0).getVertical() < gameField.getVertical() &&
                                gameField.getVertical() < (newShipLocation.get(0).getVertical() + deck)) {
                            newShipLocation.add(gameField);
                            gameField.setOccupied(true);
                        } else if (gameField.getHorizontal() == newShipLocation.get(0).getHorizontal() &&
                                newShipLocation.get(0).getVertical() == gameField.getVertical()) {
                            gameField.setOccupied(true);
                        }
                    }
                } else {

                    int randomDirection = (int) (Math.random() * 2);

                    if (randomDirection == 0) {

                        int randomHorizontal = (int) (Math.random() * possibleLocationsHorizontal.size()); //создаем начальную клетку расположения корабля по горизонтали

                        newShipLocation.add(possibleLocationsHorizontal.get(randomHorizontal));

                        for (GameField gameField : allGameField) {
                            if (gameField.getHorizontal() == newShipLocation.get(0).getHorizontal() &&
                                    newShipLocation.get(0).getVertical() < gameField.getVertical() &&
                                    gameField.getVertical() < (newShipLocation.get(0).getVertical() + deck)) {
                                newShipLocation.add(gameField);
                                gameField.setOccupied(true);
                            }
                            if (gameField.getHorizontal() == newShipLocation.get(0).getHorizontal() &&
                                    newShipLocation.get(0).getVertical() == gameField.getVertical()) {
                                gameField.setOccupied(true);
                            }
                        }

                    } else {

                        int randomVertical = (int) (Math.random() * possibleLocationsVertical.size()); //создаем начальную клетку расположения корабля по вертикали

                        newShipLocation.add(possibleLocationsVertical.get(randomVertical));

                        for (GameField gameField : allGameField) {
                            if (gameField.getVertical() == newShipLocation.get(0).getVertical() &&
                                    newShipLocation.get(0).getHorizontal() < gameField.getHorizontal() &&
                                    gameField.getHorizontal() < (newShipLocation.get(0).getHorizontal() + deck)) {
                                newShipLocation.add(gameField);
                                gameField.setOccupied(true);
                            }
                            if (gameField.getHorizontal() == newShipLocation.get(0).getHorizontal() &&
                                    newShipLocation.get(0).getVertical() == gameField.getVertical()) {
                                gameField.setOccupied(true);
                            }
                        }
                    }

                }

                allShips.add(new Ship(deck, newShipLocation));

                for (GameField gameField : allGameField) {
                    for (GameField shipLocation : newShipLocation) {
                        if (!gameField.isOccupied()) {
                            if ((gameField.getHorizontal() + 1 == shipLocation.getHorizontal() &&
                                    gameField.getVertical() + 1 == shipLocation.getVertical()) ||
                                    (gameField.getHorizontal() + 1 == shipLocation.getHorizontal() &&
                                            gameField.getVertical() == shipLocation.getVertical()) ||
                                    (gameField.getHorizontal() + 1 == shipLocation.getHorizontal() &&
                                            gameField.getVertical() - 1 == shipLocation.getVertical()) ||
                                    (gameField.getHorizontal() == shipLocation.getHorizontal() &&
                                            gameField.getVertical() + 1 == shipLocation.getVertical()) ||
                                    (gameField.getHorizontal() == shipLocation.getHorizontal() &&
                                            gameField.getVertical() - 1 == shipLocation.getVertical()) ||
                                    (gameField.getHorizontal() - 1 == shipLocation.getHorizontal() &&
                                            gameField.getVertical() + 1 == shipLocation.getVertical()) ||
                                    (gameField.getHorizontal() - 1 == shipLocation.getHorizontal() &&
                                            gameField.getVertical() - 1 == shipLocation.getVertical()) ||
                                    (gameField.getHorizontal() - 1 == shipLocation.getHorizontal() &&
                                            gameField.getVertical() == shipLocation.getVertical())
                            ) {
                                gameField.setNearShip(true);
                            }
                        }
                    }
                }

            }

        }

    }

}
