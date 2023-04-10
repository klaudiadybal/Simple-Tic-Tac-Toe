import java.util.InputMismatchException;
import java.util.Scanner;

public class GameEngine extends Board {
    private static final Scanner scanner = new Scanner(System.in);

    public GameEngine () {
        super();
    }

    public String gameStatus () {
        String returnGameStatus = null;
        if(!isFinished()) {
            if (isImpossible()) {
                returnGameStatus = "Impossible";
            } else {
                if ((findWinner('X').equals("X wins")) && (findWinner('O').equals("O wins"))) {
                    returnGameStatus = "Draw";
                } else {
                returnGameStatus = findWinner('X');
                if (returnGameStatus == "Draw") {
                    returnGameStatus = findWinner('O');
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
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
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
        for (int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 'X') {
                    sumX++;
                } else if (board[i][j] == 'O') {
                    sumO++;
                }
            }
        }

        if (sumX > sumO + 1 || sumO > sumX + 1) {
            returnGameStatus = true;

        }
        return returnGameStatus;
    }


    public String findWinner (char symbol) {

        String returnGameStatus = "";
        String message = String.format("%c wins", symbol);

        for (int i = 0; i < board.length; i++){
            if(board[i][0] == symbol && board[i][1] == symbol && board [i][2] == symbol) {
                returnGameStatus = message;
                break;
            } else if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                returnGameStatus = message;
                break;
            } else if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
                returnGameStatus = message;
                break;
            } else if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
                returnGameStatus = message;
                break;
            } else {
                returnGameStatus = "Draw";
            }
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
                if (board[x - 1][y - 1] == 'X' || board[x - 1][y - 1] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");
            }
        }

        board[x - 1][y - 1] =  symbol;
    }
}
