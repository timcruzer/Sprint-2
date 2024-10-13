package defaultPackage;

import javax.swing.*;

public class SOSGame {
    private int boardSize;
    private String gameMode;

    
    public void setBoardSize(int size) {
        if (size < 3) {
            throw new IllegalArgumentException("Board size must be at least 3x3.");
        }
        this.boardSize = size;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setGameMode(String mode) {
        if (!mode.equals("simple") && !mode.equals("general")) {
            throw new IllegalArgumentException("Invalid game mode. Choose 'simple' or 'general'.");
        }
        this.gameMode = mode;
    }

    public String getGameMode() {
        return gameMode;
    }

    public static void main(String[] args) {
        // create the initial dialog for board size and game mode
        String sizeInput = JOptionPane.showInputDialog("Enter board size (3 or greater):");
        int size = Integer.parseInt(sizeInput);

        String[] options = {"Simple", "General"};
        String gameMode = (String) JOptionPane.showInputDialog(null,
                "Choose game mode:", "Game Mode",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        // initialize the game
        SOSGame game = new SOSGame();
        game.setBoardSize(size);
        game.setGameMode(gameMode.toLowerCase());

        // launch the GUI
        SwingUtilities.invokeLater(() -> {
            SOSGameGUI gui = new SOSGameGUI();
            gui.createAndShowGUI();
        });
    }
}
