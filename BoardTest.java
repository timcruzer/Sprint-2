package defaultPackage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class BoardTest {
	 private SOSGame game;

	    @BeforeEach
	    public void setUp() {
	        game = new SOSGame();
	    }
	    
	    @Test
	    public void testChooseBoardSize() {
	        SOSGame game = new SOSGame(); // Assuming SOSGame is your main game class
	        int boardSize = 5;
	        game.setBoardSize(boardSize); // Replace with your method that sets the board size

	        assertEquals(5, game.getBoardSize(), "Board size should be 5");
	    }
	    
	    @Test
	    public void testChooseGameMode() {
	        SOSGame game = new SOSGame();
	        String gameMode = "general";
	        game.setGameMode(gameMode); // Replace with your method that sets the game mode

	        assertEquals("general", game.getGameMode(), "Game mode should be set to General");
	    }

	    @Test
	    public void testSetValidBoardSize() {
	        game.setBoardSize(5);
	        assertEquals(5, game.getBoardSize(), "Board size should be set correctly.");
	    }

	    @Test
	    public void testSetInvalidBoardSize() {
	        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
	            game.setBoardSize(2);
	        });
	        assertEquals("Board size must be at least 3x3.", exception.getMessage());
	    }

	    @Test
	    public void testSetValidGameMode() {
	        game.setGameMode("simple");
	        assertEquals("simple", game.getGameMode(), "Game mode should be set to 'simple'.");

	        game.setGameMode("general");
	        assertEquals("general", game.getGameMode(), "Game mode should be set to 'general'.");
	    }

	    @Test
	    public void testSetInvalidGameMode() {
	        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
	            game.setGameMode("invalid");
	        });
	        assertEquals("Invalid game mode. Choose 'simple' or 'general'.", exception.getMessage());
	    }
    @Test
    void testMakeMove() {
        Board board = new Board(3);
        boolean moveMade = board.makeMove(0, 0, 'S');
        assertTrue(moveMade, "The move should be made successfully.");
        assertEquals('S', board.getCell(0, 0), "The cell should contain 'S'.");
    }

    @Test
    void testCheckSOS() {
        Board board = new Board(3);
        board.makeMove(0, 0, 'S');
        board.makeMove(0, 1, 'O');
        boolean sosFormed = board.makeMove(0, 2, 'S');
        assertTrue(sosFormed, "SOS should be formed horizontally.");
        assertEquals(1, board.getBlueScore(), "Blue player should have 1 point.");
    }
        
    

}    
