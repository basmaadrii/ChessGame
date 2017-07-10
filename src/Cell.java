/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Basma
 */
public class Cell {
    
    private final int i;
    private final int j;
    private Piece piece;
    
    public Cell(int i, int j){
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }    
    
    public Piece getPiece() {
        return this.piece;
    }
    
    public void setPiece (Piece piece) {
        this.piece = piece;
    }
    
    public void deletePiece() {
        this.piece = null;
    }
    
    public boolean isEmpty() {
        return this.piece == null;
    }
}
