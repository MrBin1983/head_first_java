package chapter_6.game_three_ships;

import java.util.ArrayList;

public class ShipTest {

    public static void main(String[] args) {

        int deck = 3; //количество палуб

        GameServices helper = new GameServices(); //класс, который принимает значения, введенные игроком

        int randomVertical = (int) (Math.random() * (7 - deck)); //создаем начальную клетку расположения корабля по вертикали

        int randomHorizontal = (int) (Math.random() * (7 - deck)); //создаем начальную клетку расположения корабля по горизонтали



    }

}
