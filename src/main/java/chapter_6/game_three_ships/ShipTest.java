package chapter_6.game_three_ships;

import java.util.ArrayList;

public class ShipTest {

    public static void main(String[] args) {

        int deck = 3; //количество палуб

        GameHelper helper = new GameHelper(); //класс, который принимает значения, введенные игроком

        int randomVertical = (int) (Math.random() * (7 - deck)); //создаем начальную клетку расположения корабля по вертикали

        int randomHorizontal = (int) (Math.random() * (7 - deck)); //создаем начальную клетку расположения корабля по горизонтали

        ArrayList<String> locationShip = helper.getNewLocationShip(deck, randomVertical, randomHorizontal); //координаты первого корабля

        System.out.println(locationShip);

    }

}
