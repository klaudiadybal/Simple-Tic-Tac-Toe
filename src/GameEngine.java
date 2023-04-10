import java.util.InputMismatchException;
import java.util.Scanner;

public class GameEngine extends Board {
    private static final Scanner scanner = new Scanner(System.in);

    public GameEngine () {
        super();
    }

    public String gameStatus () {
        String returnGameStatus;
        if(!isFinished()) {
            returnGameStatus = findWinner('X');
            if (returnGameStatus.equals("Draw")) {
                returnGameStatus = findWinner('O');
            }
            if (returnGameStatus.equals("Draw")) {
                returnGameStatus = "Game not finished";
            }
        } else {
            returnGameStatus = findWinner('X').equals("Draw") ? findWinner('O') : findWinner('X');
        }

        return returnGameStatus;
    }


    public boolean isFinished() {
        boolean returnGameStatus = true;
        for (char[] chars : board) {
            for (char i : chars) {
                if (i == ' ') {
                    returnGameStatus = false;
                    break;
                }
            }
        }
        return returnGameStatus;
    }

    public String findWinner (char symbol) {

        String returnGameStatus = "";
        String message = String.format("%c wins", symbol);

        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            returnGameStatus = message;
        } else if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            returnGameStatus = message;
        } else {
            for (int i = 0; i < board.length; i++) {
                if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                    returnGameStatus = message;
                    break;
                } else if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                    returnGameStatus = message;
                    break;
                } else {
                    returnGameStatus = "Draw";
                }
            }
        }

        return returnGameStatus;
    }

    public void makeMove(char symbol){
        int x;
        int y;
        while (true) {

            try {
                x = scanner.nextInt();
                y = scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
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
