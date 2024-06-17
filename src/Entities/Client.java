package Entities;

import Util.Gender;
import Util.MyDate;

import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

public class Client extends Entity {

    private String firstName;

    private Optional<String> middleName;

    private String surname;

    private Gender gender;

    private MyDate dateOfBirth;

    private final Map<String, BankCard> clientCards = new HashMap<>();

    public Client(String id, String firstName, String middleName, String surname, Gender gender, MyDate dateOfBirth) {
        super(id);
        this.firstName = firstName;
        this.middleName = Optional.ofNullable(middleName);
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Optional<String> getMiddleName() {
        return middleName;
    }

    public void setMiddleName(Optional<String> middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFullName() {
        if (middleName.isPresent()) return getSurname() + " " + getFirstName() + " " + getMiddleName().get();
        return getSurname() + " " + getFirstName();
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public MyDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(MyDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Map<String, BankCard> getClientCards() {
        return clientCards;
    }

    public void addCardToClientCards(BankCard bankCard) {
        this.clientCards.put(bankCard.getId(),bankCard);
    }

    public void removeCardToClientCards(BankCard bankCard) {
        if(!this.clientCards.isEmpty()) this.clientCards.remove(bankCard.getId());
    }

    @Override
    public String toString() {
        return this.getId() + "," + this.getFullName() + "," + this.getDateOfBirth();
    }
}
