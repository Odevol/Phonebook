package ThroughCollection.Enums;

import java.util.Random;

public enum Numbers {

    zero, one, two, three, four, five, six, eight, nine;

    public static String getRandomNum(){
        Numbers[] values = Numbers.values();
        int length = values.length;
        int randIndex = new Random().nextInt(length);
        return String.valueOf(randIndex);
    }
}
