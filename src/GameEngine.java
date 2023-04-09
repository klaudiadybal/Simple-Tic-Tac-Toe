import java.util.InputMismatchException;
import java.util.Scanner;

public class GameEngine {
    private static final Scanner scanner = new Scanner(System.in);
    private Board gameGrid;


    public GameEngine (Board gameGrid) {
        this.gameGrid = gameGrid;
    }

    public String gameStatus () {
        String returnGameStatus = null;
        if(!isFinished()) {
            if(isImpossible()) {
                returnGameStatus = "Impossible";
            } else {
                if ((findWinner('X').equals("X wins")) && (findWinner('O').equals("O wins"))) {
                    returnGameStatus = "Draw";
                } else {
                    returnGameStatus = findWinner('X');
                    if (returnGameStatus == "Draw") {
                        returnGameStatus = findWinner( 'O');
                    }
                    if (returnGameStatus == "Draw") {
                        returnGameStatus = "Game not finished";
                    }
                }
            }
        } else {
            if (isImpossible()) {
                returnGameStatus = "Impossible";
            } else {
                returnGameStatus = findWinner('X');
                if (returnGameStatus == "Draw") {
                    returnGameStatus = findWinner('O');
                }
            }
        }

        return returnGameStatus;
    }

    public boolean isFinished() {
        boolean returnGameStatus = true;
        for (int i = 0; i < gameGrid.board.length; i++) {
            for (int j = 0; j < gameGrid.board[i].length; j++) {
                if (gameGrid.board[i][j] == ' ') {
                    returnGameStatus = false;
                }
            }
        }
        return returnGameStatus;
    }

    public boolean isImpossible() {
        boolean returnGameStatus = false;
        int sumX = 0;
        int sumO = 0;
        for (int i = 0; i < gameGrid.board.length; i++) {
            for(int j = 0; j < gameGrid.board[i].length; j++) {
                if(gameGrid.board[i][j] == 'X') {
                    sumX++;
                } else if (gameGrid.board[i][j] == 'O') {
                    sumO++;
                }
            }
        }

        if (sumX > sumO + 1 || sumO > sumX + 1) {
            returnGameStatus = true;
//        } else if ((findWinner(board, 'X').equals("X wins")) && (findWinner(board,'O').equals("O wins"))){
//            returnGameStatus = true;
        }

        return returnGameStatus;
    }


    public String findWinner (char symbol) {
        String returnGameStatus = "";

        if (gameGrid.board[0][0] == symbol && gameGrid.board[0][1] == symbol && gameGrid.board[0][2] == symbol) {
            returnGameStatus = String.format("%c wins", symbol);
        } else if (gameGrid.board[1][0] == symbol && gameGrid.board[1][1] == symbol && gameGrid.board[1][2] == symbol) {
            returnGameStatus = String.format("%c wins", symbol);
        } else if (gameGrid.board[2][0] == symbol && gameGrid.board[2][1] == symbol && gameGrid.board[2][2] == symbol) {
            returnGameStatus = String.format("%c wins", symbol);
        } else if (gameGrid.board[0][0] == symbol && gameGrid.board[1][1] == symbol && gameGrid.board[2][2] == symbol) {
            returnGameStatus = String.format("%c wins", symbol);
        } else if (gameGrid.board[0][2] == symbol && gameGrid.board[1][1] == symbol && gameGrid.board[2][0] == symbol) {
            returnGameStatus = String.format("%c wins", symbol);
        } else if (gameGrid.board[0][0] == symbol && gameGrid.board[1][0] == symbol && gameGrid.board[2][0] == symbol) {
            returnGameStatus = String.format("%c wins", symbol);
        } else if (gameGrid.board[0][1] == symbol && gameGrid.board[1][1] == symbol && gameGrid.board[2][1] == symbol) {
            returnGameStatus = String.format("%c wins", symbol);
        } else if (gameGrid.board[0][2] == symbol && gameGrid.board[1][2] == symbol && gameGrid.board[2][2] == symbol) {
            returnGameStatus = String.format("%c wins", symbol);
        } else {
            returnGameStatus = "Draw";
        }

        return returnGameStatus;
    }

    public void makeMove(char symbol){
        int x = 0;
        int y = 0;
        while (true) {

            try {
                x = scanner.nextInt();
                y = scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine(); // consumes invalid output
                continue;
            }

            try {
                if (gameGrid.board[x - 1][y - 1] == 'X' || gameGrid.board[x - 1][y - 1] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");
            }


        }

        gameGrid.board[x - 1][y - 1] =  symbol;

    }

    public void showGrid() {
        System.out.println("---------");
        for (int i = 0; i < gameGrid.board.length; i++) {
            for (int j = 0; j < gameGrid.board[i].length; j++) {
                if (j == 0) {
                    System.out.printf("| %s ", gameGrid.board[i][j]);
                } else if (j == 2) {
                    System.out.printf("%s |", gameGrid.board[i][j]);
                } else {
                    System.out.printf("%s ", gameGrid.board[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println("---------");
    }
}
