import Entities.BankCard;
import Entities.Client;
import HomeWork5.HomeWorkFive;
import Util.Gender;
import Util.MyDate;

import java.math.BigDecimal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        hw5();

        MyDate myDate = new MyDate(2024, 6, 14);
        System.out.println(myDate);

        MyDate plusDate = myDate.plusDays(3);

        System.out.println(plusDate);

        System.out.println(plusDate.isAfter(myDate));

        Client vasya = new Client("1", "vasya", "vasya", "vasya", Gender.MALE, myDate);
        vasya.addCardToClientCards(new BankCard("1", vasya, new BigDecimal("1235456548965464"), plusDate));

        System.out.println(vasya);

        BankCard card = vasya.getClientCards().get("1");
        System.out.println(card.getExpirationDate());
    }

    public static void hw5() {
        HomeWorkFive.firstTask();
        HomeWorkFive.secondTask();
        HomeWorkFive.thirdTask();
        HomeWorkFive.forthTask();
        HomeWorkFive.fifthTask();
        HomeWorkFive.sixthTask();
        HomeWorkFive.seventhTask();
    }
}