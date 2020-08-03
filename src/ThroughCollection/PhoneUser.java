package ThroughCollection;

import java.util.*;

public class PhoneUser {
    private String surname;
    private String name;
    private String patronymic;
    private String number;
    ArrayList<PhoneUser> contactList = new ArrayList<>();

    public PhoneUser(){}

    public PhoneUser getFromContactList(int index) {
        return contactList.get(index);
    }

    public void addToContactList(PhoneUser contact) {
        contactList.add(contact);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneUser phoneUser = (PhoneUser) o;
        return Objects.equals(number, phoneUser.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public void setRandomContactList (Set<PhoneUser> phoneUserSet){
        phoneUserSet.forEach(phoneUserAdded -> {
                if (!this.equals(phoneUserAdded)) {
                    int i = new Random().nextInt(1000);
                    if (i == 9) {
                        this.addToContactList(phoneUserAdded);}
                }
            });
    }

    public ArrayList<PhoneUser> getContactList() {
        return contactList;
    }

    @Override
    public String toString() {
        return "PhoneUser{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}

