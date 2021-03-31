package project.classes;

import java.util.Objects;

public class Card {
    private String CardNumber;
    private String ExpireDate;
    private int SecurityCode;

    //constructor fara parametrii
    public Card() {
        this.CardNumber = "";
        this.ExpireDate = "";
        this.SecurityCode = 0;
    }

    //constructor cu parametrii
    public Card(String cardNumber, String expireDate, int securityCode) {
        this.CardNumber = cardNumber;
        this.ExpireDate = expireDate;
        this.SecurityCode = securityCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return SecurityCode == card.SecurityCode && Objects.equals(CardNumber, card.CardNumber) && Objects.equals(ExpireDate, card.ExpireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CardNumber, ExpireDate, SecurityCode);
    }

    @Override
    public String toString() {
        return "{" + "Card Number: " + CardNumber +
                ", Expire Date: " + ExpireDate  +
                ", Security Code: " + SecurityCode +
                '}';
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public String getExpireDate() {
        return ExpireDate;
    }

    public void setExpireDate(String expireDate) {
        ExpireDate = expireDate;
    }

    public int getSecurityCode() {
        return SecurityCode;
    }

    public void setSecurityCode(int securityCode) {
        SecurityCode = securityCode;
    }
}
