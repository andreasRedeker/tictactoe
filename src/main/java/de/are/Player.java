package de.are;

public class Player {
    public static final String PLAYER_X = "X";
    public static final String PLAYER_O = "O";
    private String symbol;

    public Player(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}