package tictactoe;

/**
 * Tic-Tac-Toe state variables.
 */
public class State
{
    private int gameState = Constants.STANDBY;
    private int whoseMove = Constants.X;
    private String xName = "";
    private String oName = "";
    private int[][] board = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE];

    public int getGameState() {
        return this.gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public int getWhoseMove() {
        return this.whoseMove;
    }

    public void setWhoseMove(int whoseMove) {
        this.whoseMove = whoseMove;
    }

    public String getXName() {
        return this.xName;
    }

    public void setXName(String xName) {
        this.xName = xName;
    }

    public String getOName() {
        return this.oName;
    }

    public void setOName(String oName) {
        this.oName = oName;
    }

    public int getBoardCell(int row, int col) {
        return this.board[row][col];
    }

    public void setBoardCell(int row, int col, int value) {
        this.board[row][col] = value;
    }

    public boolean isWinner() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            // Check rows
            if (board[i][0] == whoseMove && board[i][1] == whoseMove && board[i][2] == whoseMove) {
                return true;
            }
            // Check columns
            if (board[0][i] == whoseMove && board[1][i] == whoseMove && board[2][i] == whoseMove) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == whoseMove && board[1][1] == whoseMove && board[2][2] == whoseMove) ||
        (board[0][2] == whoseMove && board[1][1] == whoseMove && board[2][0] == whoseMove)) {
            return true;
        }

        return false;
    }

    public boolean isTie() {
        // Check if all spaces on the board are filled
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                if (board[i][j] == Constants.BLANK) {
                    return false; // There's an empty space, game is not a tie
                }
            }
        }

        // If no empty spaces are found, the game is a tie
        return true;
    }

    public State() {
        board = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
        // Initialize other variables as needed
    }

    // Other methods in the State class

    public void clearBoard() {
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                board[i][j] = Constants.BLANK;
            }
        }
    }

    // Getter and setter methods
}

