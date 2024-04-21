package chapter_6.game_three_ships;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper {

    public String getUserInput(String prompt) {

        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }

        return inputLine;
    }

    public ArrayList<String> getNewLocationShip(int deck, int randomVertical, int randomHorizontal) {

        int randomDirection = (int) (Math.random() * 2);

        ArrayList<String> newLocationShip = new ArrayList<>();

        if (randomDirection == 0) {

            for (int i = 0; i < deck; i++) {
                newLocationShip.add(String.valueOf((char)('A' + randomHorizontal + i)) + (randomVertical + 1));
            }

        } else {

            for (int i = 0; i < deck; i++) {
                newLocationShip.add(String.valueOf((char)('A' + randomHorizontal)) + (1 + i + randomVertical));
            }
        }

        return newLocationShip;
    }
}
