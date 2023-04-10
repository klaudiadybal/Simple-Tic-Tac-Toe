public class Board {
    protected char [][] board = new char[3][3];

    public Board () {
        for (int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void showBoard() {
        System.out.println("---------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (j == 0) {
                    System.out.printf("| %s ", board[i][j]);
                } else if (j == 2) {
                    System.out.printf("%s |", board[i][j]);
                } else {
                    System.out.printf("%s ", board[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println("---------");
    }
}
