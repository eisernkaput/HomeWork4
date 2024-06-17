package Entities;

import Util.MyDate;

import java.math.BigDecimal;

public class BankCard extends Entity {

    private Client cardOwner;

    private BigDecimal cardNumber;

    private MyDate issueDate;

    public BankCard(String id, Client cardOwner, BigDecimal cardNumber, MyDate issueDate) {
        super(id);
        this.cardOwner = cardOwner;
        this.cardNumber = cardNumber;
        this.issueDate = issueDate;
    }

    public BigDecimal getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(BigDecimal cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Client getCardOwner() {
        return cardOwner;
    }

    public void setCardOwner(Client cardOwner) {
        this.cardOwner = cardOwner;
    }

    public MyDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(MyDate issueDate) {
        this.issueDate = issueDate;
    }

    public MyDate getExpirationDate() {
        return issueDate.plusYears(2);
    }

    public Boolean isCardExpired(MyDate todayDate) {
        return todayDate.isAfter(this.getExpirationDate());
    }
}
