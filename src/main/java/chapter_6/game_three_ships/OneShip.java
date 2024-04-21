package chapter_6.game_three_ships;

import java.util.ArrayList;

public class OneShip {

    ArrayList<String> locationCells;

    public OneShip(ArrayList<String> locationCells) {
        this.locationCells = locationCells;
    }

    public String checkYourself (String stringGuess) {
        String result = "Мимо";
        for (String cell : locationCells) {
            if (stringGuess.equals(cell)) {
                result = "Попал";
                locationCells.remove(stringGuess);
                break;
            }
        }

        if (locationCells.size() == 0) {
            result = "Потопил";
        }

        System.out.println(result);
        return result;
    }

}
