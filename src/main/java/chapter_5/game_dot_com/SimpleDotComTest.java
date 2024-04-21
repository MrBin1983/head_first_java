package chapter_5.game_dot_com;

import java.util.ArrayList;

public class SimpleDotComTest {

    public static void main(String[] args) {
        ArrayList<String> locations = new ArrayList<>(){{
            add("2");
            add("3");
            add("4");
        }
        };
        SimpleDotCom dot = new SimpleDotCom(locations);
        String userGuess = "2";
        dot.checkYourself(userGuess);
    }

}
