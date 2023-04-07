import java.util.Scanner;

public class Board {

    public static char[][] createBoard() {
        char [][] board = new char[3][5];
        char [][] filledArray = inputValidation();
        for (int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
               if (j == 0 || j == 4) {
                   board[i][j] = '|';
               }
               else {
                   board[i][j] = filledArray[i][j - 1];
               }
            }
        }
        return board;
    }

    public static void showBoard(char[][] board) {
        System.out.println("---------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.printf("%s ",board[i][j]);
            }
            System.out.println();
        }
        System.out.println("---------");
    }


    public static char[][] inputValidation() {
        Scanner scanner = new Scanner(System.in);
        char [] emptyArray = new char[9];
        String input = scanner.nextLine();
        if (input.length() != 9) {
            System.out.println("Error: Input must be 9 characters long.");
        } else {
            for (int i = 0; i < emptyArray.length; i++) {
                char nextChar = input.charAt(i);
                if(nextChar == 'X' || nextChar == 'O' || nextChar == '_') {
                    emptyArray[i] = nextChar;
                } else {
                    System.out.println("Error: You can enter only 'X', 'O', '_'");
                    break;
                }
            }
        }

        scanner.close();

        char[][] filledArray = new char[3][3];
        int counter = 0;
        for (int i = 0; i < filledArray.length; i++) {
            for (int j = 0; j < filledArray[i].length; j++) {
                filledArray[i][j] = emptyArray[counter];
                counter++;
            }
        }
        return filledArray;
    }


    public static void main(String[] args) {
        char[][] board = createBoard();
        showBoard(board);
    }


}
