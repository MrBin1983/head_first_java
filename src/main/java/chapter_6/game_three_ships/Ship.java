package chapter_6.game_three_ships;

import java.util.ArrayList;

public class Ship {

    private int deck;
    private ArrayList<GameField> initialLocation;

    ArrayList<String> realLocation;

    public Ship(int deck , ArrayList<GameField> initialLocation) {
        this.deck = deck;
        this.initialLocation = initialLocation;
    }

    public int getDeck() {
        return deck;
    }

    public ArrayList<GameField> getInitialLocation() {
        return initialLocation;
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

    @Override
    public String toString() {
        return String.valueOf(initialLocation);
    }
}
