package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;
    private final int rows = 5;
    private final int cols = 5;
    private final int numMines = 5;

    @BeforeEach
    public void setUp() {
        board = new Board(rows, cols, numMines);
    }

    @Test
    public void testInitialState() {
        assertEquals("?", board.getCell(0, 0), "All cells should be marked with '?' at start");
    }

    @Test
    public void testRevealCell() {
        board.revealCell(0, 0);
        assertNotEquals("?", board.getCell(0, 0), "Cell (0, 0) should not remain '?' after being revealed.");
    }

    @Test
    public void testRevealAlreadyRevealedCell() {
        board.revealCell(1, 1);
        String firstReveal = board.getCell(1, 1);

        board.revealCell(1, 1);
        String secondReveal = board.getCell(1, 1);

        assertEquals(firstReveal, secondReveal, "Revealing an already opened cell should not change.");
    }
    @Test
    public void testCheckFlag() {
        board.flagCell(0, 0);
        assertEquals("F", board.getCell(0, 0), "Cells display value should be F ");
    }


}