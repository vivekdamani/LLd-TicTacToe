public class PlayGame {
    public static void main(String[] args) {
        Player player1 = new Player("Lakshya", 'O');
        Player player2 = new Player("Nishant", 'X');
        int boardSize = 3;
        char[][] board = new char[boardSize][boardSize];
        GameBoard gameBoard = new GameBoard(boardSize, player1, player2, board);
        gameBoard.start();
    }
}
