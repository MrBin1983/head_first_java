package chapter_6.game_three_ships;

import java.util.ArrayList;

public class ShipsGame {

    public static void main(String[] args) {

        int deck = 3; //количество палуб

        GameHelper helper = new GameHelper(); //класс, который принимает значения, введенные игроком

        int threeDecksShips = Integer.parseInt(helper.getUserInput("Введите количество трехпалубных кораблей:"));

        int randomVertical = (int) (Math.random() * (7 - deck)); //создаем начальную клетку расположения корабля

        int randomHorizontal = (int) (Math.random() * (7 - deck)); //создаем начальную клетку расположения корабля по горизонтали

        ArrayList<String> locationShip = helper.getNewLocationShip(deck, randomVertical, randomHorizontal); //координаты первого корабля

        ArrayList<ArrayList<String>> possibleLocations = new ArrayList<>();  //создаем массив возможных начальных клеток расположения корабля

        int numOfGuesses = 0; //количество попыток


        Ship theDotCom = new Ship(deck, locationShip); //класс, который хранит расположение кораблей и методы для игры
        boolean isAlive = true; //переменная продолжения игры

        while (isAlive) {
            String guess = helper.getUserInput("Введите число:");
            String result = theDotCom.checkYourself(guess);
            numOfGuesses++;

            if (result.equals("Потопил")) {
                isAlive = false;
                System.out.println("Вам потребовалось " + numOfGuesses + " попыток");

            }
        }

    }

}
