public class Main {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        gameEngine.showBoard();
        System.out.println("Enter coordinates to start: ");
        String gameStatus = gameEngine.gameStatus();
        while (gameStatus.equals("Game not finished")) {
            gameEngine.makeMove('X');
            gameEngine.showBoard();
            gameStatus = gameEngine.gameStatus();
            if (!gameStatus.equals("Game not finished")) {
                break;
            }
            gameEngine.makeMove('O');
            gameEngine.showBoard();
            gameStatus = gameEngine.gameStatus();
        }
        System.out.println(gameStatus);
    }
}
