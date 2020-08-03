package ThroughCollection;

import ThroughCollection.Enums.Name;
import ThroughCollection.Enums.Numbers;
import ThroughCollection.Enums.Patronymic;
import ThroughCollection.Enums.Surname;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBookExample {
    public static void main(String[] args) {

        Set<PhoneUser> phoneBook = new HashSet<>();

        while (phoneBook.size() < 10000) {
            PhoneUser user = new PhoneUser();
            String surname = Surname.getRandomSurname();
            user.setSurname(surname);
            String name = Name.getRandomName();
            user.setName(name);
            String patronymic = Patronymic.getRandomPatronymic();
            user.setPatronymic(patronymic);
            String number = "+7 " + "9" + Numbers.getRandomNum() + Numbers.getRandomNum() + " " + Numbers.getRandomNum() + Numbers.getRandomNum() + Numbers.getRandomNum() + " " + Numbers.getRandomNum() + Numbers.getRandomNum() + " " + Numbers.getRandomNum() + Numbers.getRandomNum();
            user.setNumber(number);
            phoneBook.add(user);
        }
        phoneBook.forEach(phoneUser -> {
            phoneUser.setRandomContactList(phoneBook);
        });

//        System.out.println(phoneBook.size());
//        phoneBook.forEach(phoneUser -> {
//            System.out.println(phoneUser.getNumber() + " " + phoneUser.getName() + " " + phoneUser.getSurname() + " " + phoneUser.getContactList().size());
//            for(int i = 0; i < phoneUser.getContactList().size(); i++) {
//                System.out.println(phoneUser.getFromContactList(i).getNumber());
//            }});
//        System.out.println("--------------------");
        findMustPopularUser(phoneBook);
    }



    public static PhoneUser findMustPopularUser(Set<PhoneUser> phoneBook){
        Map<String, Integer> popularityUser = new HashMap<>();
        phoneBook.forEach(phoneUser -> {
            popularityUser.put(phoneUser.getNumber(), 0);
        });
        phoneBook.forEach(phoneUser -> {
            for(int i = 0; i < phoneUser.getContactList().size(); i++) {
                Integer value = popularityUser.get(phoneUser.getFromContactList(i).getNumber()) + 1;
                popularityUser.replace(phoneUser.getFromContactList(i).getNumber(), value);
            }
            });
        int maxValue = Integer.MIN_VALUE;

        for (int value : popularityUser.values()) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        int finalMaxValue = maxValue;
        phoneBook.forEach(phoneUser -> {
            popularityUser.forEach((key, value) -> {
                if(phoneUser.getNumber().equals(key) && value.equals(finalMaxValue)){
                    System.out.println(phoneUser + " количество контактов на данный объект " + value);
                }
            });
        });
        return null;
    }
}
