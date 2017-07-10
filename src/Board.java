
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Basma
 */
public final class Board {
    
    private final Cell[][] cells;
    private final Piece[] pieces;
    private final ArrayList<Piece> deletedWhite;
    private final ArrayList<Piece> deletedBlack;
    private Color winner;
    
    public Board() {
        this.cells = new Cell[8][8];
        this.pieces = new Piece[32];
        this.deletedWhite = new ArrayList();
        this.deletedBlack = new ArrayList();
        initializeBoard();
        initializePieces();
        winner = null;
    }
    
    public void initializeBoard() {
        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 8; j++)
                this.cells[i][j] = new Cell(i, j);
    }
    
    public void initializePieces() {
        this.pieces[0] = new Rook ("bR", Color.Black, this.getCells()[0][0]);
        this.pieces[7] = new Rook ("bR", Color.Black, this.getCells()[0][7]);
        this.pieces[1] = new Knight ("bN", Color.Black, this.getCells()[0][1]);
        this.pieces[6] = new Knight ("bN", Color.Black, this.getCells()[0][6]);
        this.pieces[2] = new Bishop ("bB", Color.Black, this.getCells()[0][2]);
        this.pieces[5] = new Bishop ("bB", Color.Black, this.getCells()[0][5]);
        this.pieces[3] = new Queen ("bQ", Color.Black, this.getCells()[0][3]);
        this.pieces[4] = new King ("bK", Color.Black, this.getCells()[0][4]);
        
        for (int i = 0; i < 8; i++) {
            this.pieces[8 + i] = new Pawn ("bP", Color.Black, this.getCells()[1][i]);
        }
        
        for (int i = 0; i < 8; i++) {
            this.pieces[16 + i] = new Pawn ("wP", Color.White, this.getCells()[6][i]);
        }
        
        this.pieces[24] = new Rook ("wR", Color.White, this.getCells()[7][0]);
        this.pieces[31] = new Rook ("wR", Color.White, this.getCells()[7][7]);
        this.pieces[25] = new Knight ("wN", Color.White, this.getCells()[7][1]);
        this.pieces[30] = new Knight ("wN", Color.White, this.getCells()[7][6]);
        this.pieces[26] = new Bishop ("wB", Color.White, this.getCells()[7][2]);
        this.pieces[29] = new Bishop ("wB", Color.White, this.getCells()[7][5]);
        this.pieces[27] = new Queen ("wQ", Color.White, this.getCells()[7][3]);
        this.pieces[28] = new King ("wK", Color.White, this.getCells()[7][4]);
    }
    
    public void printBoard() {
        System.out.print(" ");
        for (int i = 0; i < 8; i++) {
            System.out.print(" " + ((char) (65 + i)) + " ");
        }
        System.out.println("");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < 8; j++) {
                if (this.getCells()[i][j].isEmpty()) {
                    if (i % 2 == 0) {
                        if (j % 2 == 0) {
                            System.out.print("..");
                        } else {
                            System.out.print("**");
                        }
                    } else {
                        if (j % 2 == 0) {
                            System.out.print("**");
                        } else {
                            System.out.print("..");
                        }
                    }
                } else {
                    System.out.print(this.getCells()[i][j].getPiece().getName());
                }
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
    
    public void deletePiece(Piece piece) {
        for (int i = 0; i < 32; i++){
            if (this.getPieces()[i] == piece) {
                this.pieces[i] = null;
                if (piece.getColor() == Color.White) {
                    this.deletedWhite.add(piece);
                    if (piece instanceof King)
                        this.winner = Color.Black;
                }
                else {
                    this.deletedBlack.add(piece);
                    if (piece instanceof King)
                        this.winner = Color.White;
                }
                break;
            }
        }
    }
    
    public void printDeleted() {
        for (int i = 0; i < this.deletedWhite.size(); i++)
            System.out.print(this.deletedWhite.get(i).getName() + " ");
        System.out.println("");
        for (int i = 0; i < this.deletedBlack.size(); i++)
            System.out.print(this.deletedBlack.get(i).getName() + " ");
        System.out.println("");
    }

    public Cell[][] getCells() {
        return cells;
    }
    
    public Piece[] getPieces() {
        return pieces;
    }
    
    public Color getWinner() {
        return this.winner;
    }
}
