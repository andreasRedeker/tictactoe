package de.are;

/**
 * Tic Tac Toe game that can be played from the command line.
 * @author Andreas Redeker
 */
public class Game {
    private Board board;
    private Player currentPlayer;
    private Statistics statistics;
    private InputHandler inputHandler;
    private String lastWinner;
    private boolean running = true;

    public Game() {
        this.board = new Board();
        this.currentPlayer = new Player(Player.PLAYER_X);
        this.statistics = new Statistics();
        this.inputHandler = new InputHandler();
        this.lastWinner = null;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }

    public void run() {
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Press \"p\" for stats, \"e\" to close the game at any time.");

        while (running) {
            String winner = board.checkWinner();
            if (winner != null) {
                clearConsole();
                board.printBoard();
                System.out.println(winner + " won. Press enter to start a new round");
                statistics.incrementWin(winner);
                lastWinner = winner;
                if (inputHandler.getInput().isEmpty()) {
                    startNewGame();
                }
            } else if (board.isFull()) {
                clearConsole();
                board.printBoard();
                System.out.println("It's a tie. Press enter to start a new round");
                lastWinner = null;
                if (inputHandler.getInput().isEmpty()) {
                    startNewGame();
                }
            } else {
                promptPlayerMove();
            }
        }
    }

    public void promptPlayerMove() {
        String message = null;

        while (true) {
            clearConsole();
            board.printBoard();

            if (message != null) {
                System.out.println(message);
                message = null;
            }

            System.out.println(currentPlayer.getSymbol() + ": Please enter the position of your mark (Row:Column):");
            String input = inputHandler.getInput();

            switch (input) {
                case "p":
                    clearConsole();
                    statistics.printStats();
                    inputHandler.getInput();
                    break;
                case "e":
                    inputHandler.closeScanner();
                    System.exit(0); // exit game
                    break;
                default:
                    if (inputHandler.isValidFormat(input)) {
                        int[] move = inputHandler.formatInput(input);
                        if (board.isFieldEmpty(move[0], move[1])) {
                            board.setMove(move[0], move[1], currentPlayer.getSymbol());
                            switchPlayer();
                            return; // break out method to continue main game loop
                        } else {
                            message = "The selected field is already occupied. Try again.";
                        }
                    } else {
                        message = "The inserted field is not valid. Try again:";
                    }
                    break;
            }
        }
    }

    void switchPlayer() {
        currentPlayer.setSymbol(currentPlayer.getSymbol().equals(Player.PLAYER_X) ? Player.PLAYER_O : Player.PLAYER_X);
    }

    private void startNewGame() {
        board.prepareBoard();
        if (lastWinner == null || lastWinner.equals(Player.PLAYER_O)) {
            currentPlayer.setSymbol(Player.PLAYER_X);
        } else {
            currentPlayer.setSymbol(Player.PLAYER_O);
        }
    }

    /**
     * Clears the console screen by sending ANSI escape codes to the console.
     * \033[H moves the cursor to the top left corner of the screen.
     * \033[2J clears the entire screen and moves the cursor to the top left corner.
     * Note: This only works on environments that support ANSI escape codes, such as command line terminals.
     * It will not function properly in IDE consoles or graphical user interfaces.
     */
    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}