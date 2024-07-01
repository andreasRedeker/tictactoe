package de.are;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private Board board;
    private Game game;

    @BeforeEach
    public void setup() {
        board = new Board();
        game = new Game();
    }

    // User Story 1: Empty board when the game starts
    @Test
    public void testBoardIsEmptyAtStart() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                assertTrue(board.isFieldEmpty(row, col));
            }
        }
    }

    // User Story 2: Player makes a move on the board
    @Test
    public void testPlayerMove() {
        board.setMove(0, 0, Player.PLAYER_X);
        assertFalse(board.isFieldEmpty(0, 0));
        assertEquals(board.getBoard()[0][0], Player.PLAYER_X);
    }

    // User Story 3: Check winner and full board
    @Test
    public void testCheckWinner() {
        board.setMove(0, 0, Player.PLAYER_X);
        board.setMove(0, 1, Player.PLAYER_X);
        board.setMove(0, 2, Player.PLAYER_X);
        assertEquals(Player.PLAYER_X, board.checkWinner());
    }

    @Test
    public void testBoardIsFull() {
        board.setMove(0, 0, Player.PLAYER_X);
        board.setMove(0, 1, Player.PLAYER_O);
        board.setMove(0, 2, Player.PLAYER_X);
        board.setMove(1, 0, Player.PLAYER_O);
        board.setMove(1, 1, Player.PLAYER_X);
        board.setMove(1, 2, Player.PLAYER_O);
        board.setMove(2, 0, Player.PLAYER_O);
        board.setMove(2, 1, Player.PLAYER_X);
        board.setMove(2, 2, Player.PLAYER_O);
        assertTrue(board.isFull());
        assertNull(board.checkWinner());  // It's a tie
    }

    @Test
    public void testWinner() {
        board.setMove(0, 0, Player.PLAYER_X);
        board.setMove(0, 1, Player.PLAYER_O);
        board.setMove(0, 2, Player.PLAYER_O);
        board.setMove(1, 0, Player.PLAYER_X);
        board.setMove(1, 1, Player.PLAYER_X);
        board.setMove(1, 2, Player.PLAYER_O);
        board.setMove(2, 0, Player.PLAYER_X);
        board.setMove(2, 1, Player.PLAYER_X);
        board.setMove(2, 2, Player.PLAYER_O);
        assertTrue(board.isFull());
        assertEquals(Player.PLAYER_X, board.checkWinner());
    }

    // Switch turns between "X" and "O"
    @Test
    public void testSwitchPlayer() {
        Player currentPlayer = new Player(Player.PLAYER_X);
        assertEquals(Player.PLAYER_X, currentPlayer.getSymbol());
        currentPlayer.setSymbol(Player.PLAYER_O);
        assertEquals(Player.PLAYER_O, currentPlayer.getSymbol());
    }
}