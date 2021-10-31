package models;

import org.bson.types.ObjectId;

public class Currency {
    private String symbol;
    private String name;
    private int value;
    private ObjectId userID;


    public Currency() {
    }

    public Currency(String symbol, String name, int value, ObjectId userID) {
        this.symbol = symbol;
        this.name = name;
        this.value = value;
        this.userID = userID;
    }

    public Currency(String symbol, String name, int value) {
        this.symbol = symbol;
        this.name = name;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ObjectId getUserID() {
        return userID;
    }

    public void setUserID(ObjectId userID) {
        this.userID = userID;
    }
}
