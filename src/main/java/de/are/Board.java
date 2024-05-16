package de.are;

import java.util.Arrays;

public class Board {
    private static final int SIZE = 3;
    private static final String EMPTY_FIELD = " ";
    private String[][] board;

    public Board() {
        board = new String[SIZE][SIZE];
        prepareBoard();
    }

    public void prepareBoard() {
        for (String[] row : board) {
            Arrays.fill(row, EMPTY_FIELD);
        }
    }

    public boolean isFieldEmpty(int row, int col) {
        return board[row][col].equals(EMPTY_FIELD);
    }

    public void setMove(int row, int col, String player) {
        board[row][col] = player;
    }

    public boolean isFull() {
        for (String[] row : board) {
            for (String field : row) {
                if (field.equals(EMPTY_FIELD)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " ");
    }

    public String checkWinner() {
        String[][] winPositions = {
                {board[0][0], board[0][1], board[0][2]},
                {board[1][0], board[1][1], board[1][2]},
                {board[2][0], board[2][1], board[2][2]},
                {board[0][0], board[1][0], board[2][0]},
                {board[0][1], board[1][1], board[2][1]},
                {board[0][2], board[1][2], board[2][2]},
                {board[0][0], board[1][1], board[2][2]},
                {board[0][2], board[1][1], board[2][0]}
        };

        for (String[] winPosition : winPositions) {
            String line = String.join("", winPosition);
            if (line.equals(Player.PLAYER_X + Player.PLAYER_X + Player.PLAYER_X)) {
                return Player.PLAYER_X;
            } else if (line.equals(Player.PLAYER_O + Player.PLAYER_O + Player.PLAYER_O)) {
                return Player.PLAYER_O;
            }
        }
        return null;
    }

    public String[][] getBoard() {
        return board;
    }
}