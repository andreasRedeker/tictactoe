package de.are;

public class Player {
    public static final String PLAYER_X = "X";
    public static final String PLAYER_O = "O";

    private String symbol;
    private int wins;

    public Player(String symbol) {
        this.symbol = symbol;
        this.wins = 0;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getWins() {
        return wins;
    }

    public void incrementWins() {
        this.wins++;
    }
}