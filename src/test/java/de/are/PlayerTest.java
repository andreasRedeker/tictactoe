package de.are;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void testGetAndSetSymbol() {
        Player player = new Player(Player.PLAYER_X);
        assertEquals(Player.PLAYER_X, player.getSymbol());

        player.setSymbol(Player.PLAYER_O);
        assertEquals(Player.PLAYER_O, player.getSymbol());
    }
}