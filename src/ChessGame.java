
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Basma 
 */
public class ChessGame {

    private static final Board board = new Board ();
    
    public static boolean move (int x1, int y1, int x2, int y2){
        Piece p = board.getCells()[x1][y1].getPiece();
        boolean moved = p.move(board.getCells()[x1][y1], board.getCells()[x2][y2], board);
        if (moved) board.printBoard();
        else System.out.println("invalid movement");
        return moved;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to  the Chess Game!");
        board.printBoard();
        String move;
        Color player = Color.White;
        boolean moved;
        while(true) {
            System.out.println("============");
            System.out.println(player + " Player:");
            System.out.println("============");
            move = input.nextLine();
            if ( move.length() != 5 || move.charAt(2) != ' ' 
                    || move.charAt(0) < 'A' || move.charAt(0) > 'H' 
                    || move.charAt(1) < '1' || move.charAt(1) > '8'
                    || move.charAt(3) < 'A' || move.charAt(3) > 'H' 
                    || move.charAt(4) < '1' || move.charAt(4) > '8') {
                System.out.println("Invalid Input");
                continue;
            }
            
            int x1 = 8 - (move.charAt(1) - 48);
            int x2 = 8 - (move.charAt(4) - 48);
            int y1 = move.charAt(0) - 65;
            int y2 = move.charAt(3) - 65;
            
            if (board.getCells()[x1][y1].isEmpty()) {
                System.out.println("invalid movement");
                continue;
            }
            else if (board.getCells()[x1][y1].getPiece().getColor() != player) {
                System.out.println("invalid movement");
                continue;
            }
            else    moved = move(x1, y1, x2, y2);
            
            if (!moved) continue;
            
            if (board.getWinner() == Color.White) {
                System.out.println("White player is winner.");
                System.exit(0);
            }
            else if (board.getWinner() == Color.Black) {
                System.out.println("Black player is winner.");
                System.exit(0);
            }
            
            if (player == Color.White)  player = Color.Black;
            else    player = Color.White;
            
        }
    }
    
}
