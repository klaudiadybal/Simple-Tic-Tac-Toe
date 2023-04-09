public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        GameEngine gameEngine = new GameEngine(board);
        gameEngine.showGrid();
        String gameStatus = gameEngine.gameStatus();
        while (gameStatus == "Game not finished") {
            gameEngine.makeMove('X');
            gameEngine.showGrid();
            gameStatus = gameEngine.gameStatus();
            if (gameStatus != "Game not finished") {
                break;
            }
            gameEngine.makeMove('O');
            gameEngine.showGrid();
            gameStatus = gameEngine.gameStatus();
        }
        System.out.println(gameStatus);
    }
}
