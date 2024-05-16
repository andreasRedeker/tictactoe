package de.are;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StatisticsTest {

    private Statistics statistics;

    @BeforeEach
    public void setUp() {
        statistics = new Statistics();
    }

    @Test
    public void testIncrementWin() {
        assertEquals(0, statistics.getWinsX());
        assertEquals(0, statistics.getWinsO());

        statistics.incrementWin(Player.PLAYER_X);
        assertEquals(1, statistics.getWinsX());
        assertEquals(0, statistics.getWinsO());

        statistics.incrementWin(Player.PLAYER_O);
        assertEquals(1, statistics.getWinsX());
        assertEquals(1, statistics.getWinsO());

        statistics.incrementWin(Player.PLAYER_X);
        assertEquals(2, statistics.getWinsX());
        assertEquals(1, statistics.getWinsO());
    }
}