package ThroughCollection.Enums;

import java.util.Random;

public enum Patronymic {

    Алексеевич, Иванович, Сергеевич, Андреевич, Геннадьевич, Ильич, Петрович, Сидорович, Глебович, Дмитриевич, Витальевич;

    public static String getRandomPatronymic() {
        Patronymic[] values = Patronymic.values();
        int lenght = values.length;
        int randIndex = new Random().nextInt(lenght);
        return String.valueOf(values[randIndex]);
    }
}
