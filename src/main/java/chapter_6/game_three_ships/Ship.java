package chapter_6.game_three_ships;

import java.util.ArrayList;

public class Ship {

    int deck;
    ArrayList<String> initialLocation;

    ArrayList<String> realLocation;

    public Ship(int deck , ArrayList<String> initialLocation) {
        this.deck = deck;
        this.initialLocation = initialLocation;
    }

    public String checkYourself (String stringGuess) {
        String result = "Мимо";
        for (String cell : realLocation) {
            if (stringGuess.equals(cell)) {
                result = "Попал";
                realLocation.remove(stringGuess);
                break;
            }
        }

        if (realLocation.size() == 0) {
            result = "Потопил";
        }

        System.out.println(result);
        return result;
    }

}
