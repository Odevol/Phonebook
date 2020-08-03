package ThroughCollection.Enums;

import java.util.Random;

public enum Code {

    MTS, Tele2, Beeline, Megafon;

    public static String getRandomCode(){
        Code[] values = Code.values();
        int length = values.length;
        int randIndex = new Random().nextInt(length);
        String code;
        switch (String.valueOf(values[randIndex])) {
            case "MTS":
                code = "912";
            case "Tele2":
                code = "900";
            case "Beeline":
                code = "906";
            case "Megafon":
                code = "922";
                break;
            default:
                code = "3519";
        }
        return code;
    }
}
