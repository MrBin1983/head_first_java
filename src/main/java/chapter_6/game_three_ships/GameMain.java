package chapter_6.game_three_ships;

import java.util.ArrayList;

public class GameMain {

    public static void main(String[] args) {

        GameServices gameServices = new GameServices();

        int numberOfFields = 10;



        ArrayList<GameField> allGameField = gameServices.getNewGameField(numberOfFields);

        int deck = 3; //количество палуб



        int threeDecksShips = Integer.parseInt(gameServices.getUserInput("Введите количество трехпалубных кораблей:"));

        ArrayList<Ship> firstShip = new ArrayList<>();

        ArrayList<Ship> allShips = gameServices.createNewShip(deck, firstShip, allGameField);

                ArrayList<ArrayList<String>> possibleLocations = new ArrayList<>();  //создаем массив возможных начальных клеток расположения корабля

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
