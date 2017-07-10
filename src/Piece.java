/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Basma
 */
public abstract class Piece {
    
    private final String name;
    private final Color color;
    private Cell cell;
        
    public Piece (String name, Color color, Cell cell) {
        this.name = name;
        this.color = color;
        this.cell = cell;
        this.cell.setPiece(this);
    }
    
    public abstract boolean move(Cell c1, Cell c2, Board b);
    
    public String getName() {
        return this.name;
    }

    public Color getColor() {
        return color;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
    
}
