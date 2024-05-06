package chapter_6.game_three_ships;

import java.util.*;

public class GameMain {

    public static void main(String[] args) {

        GameServices gameServices = new GameServices();

        int numberOfFields = 10;

        ArrayList<GameField> allGameField = gameServices.getNewGameField(numberOfFields);

        Map<Integer, Integer> userShips = new HashMap<>();

        int deck = 3; //количество палуб

        int numberOfShips = 3; //количество кораблей

        int threeDecksShips = Integer.parseInt(gameServices.getUserInput("Введите количество трехпалубных кораблей:"));

        ArrayList<Ship> allShips = new ArrayList<>();

        gameServices.createNewShip(numberOfFields, userShips, allShips, allGameField);


        int numOfGuesses = 0; //количество попыток


        //Ship theDotCom = new Ship(deck, locationShip); //класс, который хранит расположение кораблей и методы для игры
        boolean isAlive = true; //переменная продолжения игры

        while (isAlive) {
            String guess = gameServices.getUserInput("Введите число:");
            //    String result = gameServices.checkYourself(guess);
            String result = null;
            numOfGuesses++;

            if (result.equals("Потопил")) {
                isAlive = false;
                System.out.println("Вам потребовалось " + numOfGuesses + " попыток");

            }
        }

    }

}
