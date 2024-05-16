package de.are;

public class Statistics {
    private int winsX = 0;
    private int winsO = 0;

    public void incrementWin(String player) {
        if (player.equals(Player.PLAYER_X)) {
            winsX++;
        } else if (player.equals(Player.PLAYER_O)) {
            winsO++;
        }
    }

    public void printStats() {
        System.out.println("Stats:");
        System.out.println(Player.PLAYER_X + " wins: " + winsX);
        System.out.println(Player.PLAYER_O + " wins: " + winsO);
        System.out.println("Press enter to continue....");
    }

    public int getWinsX() {
        return this.winsX;
    }

    public int getWinsO() {
        return this.winsO;
    }
}