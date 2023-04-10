import java.util.Arrays;

public class Board {
    protected char [][] board = new char[3][3];

    public Board () {
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }
    }

    public void showBoard() {
        System.out.println("---------");
        for (char[] chars : board) {
            for (int j = 0; j < chars.length; j++) {
                if (j == 0) {
                    System.out.printf("| %s ", chars[j]);
                } else if (j == 2) {
                    System.out.printf("%s |", chars[j]);
                } else {
                    System.out.printf("%s ", chars[j]);
                }
            }
            System.out.println();
        }
        System.out.println("---------");
    }
}
