package chapter_5.game_dot_com;

import java.util.ArrayList;

public class SimpleDotComGame {

    public static void main(String[] args) {

        int numOfGuesses = 0; //количество попыток
        GameHelper helper = new GameHelper(); //класс, который принимает значения, введенные игроком
        int randomNum = (int) ((Math.random() * 5) + 1); //создаем начальную клетку расположения корабля
        ArrayList<String> locations = new ArrayList<>(){{  //создаем массив клеток расположения корабля
            add(String.valueOf(randomNum));
            add(String.valueOf(randomNum+1));
            add(String.valueOf(randomNum+2));
        }
        };
        SimpleDotCom theDotCom = new SimpleDotCom(locations); //класс, который хранит расположение кораблей и методы для игры
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
