package ThroughCollection.Enums;

import java.util.Random;

public enum Surname {
    Алексеев, Иванов, Сергеев, Андреев, Геннадьев, Ильин, Петров, Сидоров, Глебов, Дмитриев, Витальев;

    public static String getRandomSurname() {
        Surname[] values = Surname.values();
        int lenght = values.length;
        int randIndex = new Random().nextInt(lenght);
        return String.valueOf(values[randIndex]);
    }
}