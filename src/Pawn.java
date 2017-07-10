/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Basma
 */
public class Pawn extends Piece {
    
    private boolean firstMove;
    
    public Pawn(String name, Color color, Cell cell) {
        super(name, color, cell);
        firstMove = true;
    }

    @Override
    public boolean move(Cell c1, Cell c2, Board b) {
        int x1 = c1.getI();
        int x2 = c2.getI();
        int y1 = c1.getJ();
        int y2 = c2.getJ();
        
        if ( (x2 == (this.getColor() == Color.White ? x1 - 1 : x1 + 1)) && (y2 == y1 + 1 || y2 == y1 - 1) ) {
            if ((!c2.isEmpty() && c2.getPiece().getColor() == this.getColor()) || c2.isEmpty() ) return false;
            b.deletePiece(c2.getPiece());
            c2.deletePiece();
        }
        else if (y2 == y1 && x2 != x1) {
            if (!c2.isEmpty()) return false;
            if (this.firstMove && !(x2 == (this.getColor() == Color.White ? x1 - 1 : x1 + 1) 
                    || x2 == (this.getColor() == Color.White ? x1 - 2 : x1 + 2))) return false;
            if (!this.firstMove && !(x2 == (this.getColor() == Color.White ? x1 - 1 : x1 + 1))) return false;
        }
        else return false;
        
        if (this.firstMove) this.firstMove = false;
        
        if (this.getColor() == Color.White && c2.getI() == 0)
            c2.setPiece(new Queen ("wQ", Color.White, c2));
        else if (this.getColor() == Color.Black && c2.getI() == 7)
            c2.setPiece(new Queen ("bQ", Color.Black, c2));
        else
            c2.setPiece(c1.getPiece());
        
        c1.deletePiece();
        return true;
    }
        
}
