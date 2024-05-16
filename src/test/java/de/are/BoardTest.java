package de.are;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testPrepareBoard() {
        board.prepareBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(board.isFieldEmpty(i, j), "Board preparation failed, field is not empty.");
            }
        }
    }

    @Test
    public void testIsFieldEmpty() {
        assertTrue(board.isFieldEmpty(0, 0), "Field should be empty at start.");
        board.setMove(0, 0, Player.PLAYER_X);
        assertFalse(board.isFieldEmpty(0, 0), "Field should not be empty after setting a move.");
    }

    @Test
    public void testSetMove() {
        board.setMove(1, 1, Player.PLAYER_X);
        assertFalse(board.isFieldEmpty(1, 1), "Field should be occupied after setting a move.");
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            board.setMove(3, 3, Player.PLAYER_O);
        });
    }

    @Test
    public void testIsFull() {
        assertFalse(board.isFull(), "Board should not be full initially.");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.setMove(i, j, Player.PLAYER_X);
            }
        }
        assertTrue(board.isFull(), "Board should be full after filling all fields.");
    }

    @Test
    public void testCheckWinner() {
        // No winner initially
        assertNull(board.checkWinner(), "There should be no winner initially.");

        // Set a horizontal win for PLAYER_X
        board.setMove(0, 0, Player.PLAYER_X);
        board.setMove(0, 1, Player.PLAYER_X);
        board.setMove(0, 2, Player.PLAYER_X);
        assertEquals(Player.PLAYER_X, board.checkWinner(), "X should be the winner.");

        board.prepareBoard();

        // Set a vertical win for PLAYER_O
        board.setMove(0, 1, Player.PLAYER_O);
        board.setMove(1, 1, Player.PLAYER_O);
        board.setMove(2, 1, Player.PLAYER_O);
        assertEquals(Player.PLAYER_O, board.checkWinner(), "O should be the winner.");

        board.prepareBoard();

        // Set a diagonal win for PLAYER_X
        board.setMove(0, 0, Player.PLAYER_X);
        board.setMove(1, 1, Player.PLAYER_X);
        board.setMove(2, 2, Player.PLAYER_X);
        assertEquals(Player.PLAYER_X, board.checkWinner(), "X should be the winner.");
    }
}