/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Basma
 */
public class Queen extends Piece {

    public Queen(String name, Color color, Cell cell) {
        super(name, color, cell);
    }

    @Override
    public boolean move(Cell c1, Cell c2, Board b) {
        int x1 = c1.getI();
        int x2 = c2.getI();
        int y1 = c1.getJ();
        int y2 = c2.getJ();
        
        if ( !((x2 == x1 && y2 != y1) || (y2 == y1 && x2 != x1) || (Math.abs(x2 - x1) == Math.abs(y2 - y1))) ) return false;
        
        if ((x2 == x1 && y2 != y1) || (y2 == y1 && x2 != x1)) {
            if (x2 == x1 && y2 > y1) {
                for (int i = y1 + 1; i < y2; i++)
                    if (!b.getCells()[x1][i].isEmpty()) return false;
            }
            else if (x2 == x1 && y2 < y1){
                for (int i = y2 + 1; i < y1; i++)
                    if (!b.getCells()[x1][i].isEmpty()) return false;
            }
            else if (y2 == y1 && x2 > x1) {
                for (int i = x1 + 1; i < x2; i++)
                    if (!b.getCells()[i][y1].isEmpty()) return false;
            }
            else if (y2 == y1 && x2 < x1) {
                for (int i = x2 + 1; i < x1; i++)
                    if (!b.getCells()[i][y1].isEmpty()) return false;
            }
        } 
        else if (Math.abs(x2 - x1) == Math.abs(y2 - y1)) {
            if (x2 == x1 && y2 > y1) {
                for (int i = y1 + 1; i < y2; i++)
                    if (!b.getCells()[x1][i].isEmpty()) return false;
            }
            else if (x2 == x1 && y2 < y1){
                for (int i = y2 + 1; i < y1; i++)
                    if (!b.getCells()[x1][i].isEmpty()) return false;
            }
            else if (y2 == y1 && x2 > x1) {
                for (int i = x1 + 1; i < x2; i++)
                    if (!b.getCells()[i][y1].isEmpty()) return false;
            }
            else if (y2 == y1 && x2 < x1) {
                for (int i = x2 + 1; i < x1; i++)
                    if (!b.getCells()[i][y1].isEmpty()) return false;
            }
        }
        
        if (!c2.isEmpty()){
            if (c2.getPiece().getColor() == this.getColor()) return false;
            b.deletePiece(c2.getPiece());
            c2.deletePiece();
        } 
        c2.setPiece(c1.getPiece());
        c1.deletePiece();
        return true;
    }
    
}
