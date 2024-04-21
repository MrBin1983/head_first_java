package chapter_5.game_dot_com;

import java.util.ArrayList;

public class SimpleDotCom {

    ArrayList<String> locationCells;

    public SimpleDotCom(ArrayList<String> locationCells) {
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
