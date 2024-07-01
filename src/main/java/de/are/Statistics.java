package de.are;

public class Statistics {
    private Player playerX;
    private Player playerO;

    public Statistics(Player playerX, Player playerO) {
        this.playerX = playerX;
        this.playerO = playerO;
    }

    public void printStats() {
        System.out.println("Stats:");
        System.out.println(Player.PLAYER_X + " wins: " + playerX.getWins());
        System.out.println(Player.PLAYER_O + " wins: " + playerO.getWins());
        System.out.println("Press enter to continue....");
    }
}