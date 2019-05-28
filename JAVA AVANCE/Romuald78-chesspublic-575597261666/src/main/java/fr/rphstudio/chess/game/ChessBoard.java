/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess.ChessColor;
import fr.rphstudio.chess.interf.IChess.ChessPosition;
import fr.rphstudio.chess.interf.IChess.ChessType;

/**
 *
 * @author jisseaudamien
 */
public class ChessBoard {
    
    private Piece[][] board;
    
    public ChessBoard(){
        ChessColor white = ChessColor.CLR_WHITE;
        ChessColor black = ChessColor.CLR_BLACK;

        ChessType rook = ChessType.TYP_ROOK;
        ChessType pawn = ChessType.TYP_PAWN;
        ChessType bishop = ChessType.TYP_BISHOP;
        ChessType queen = ChessType.TYP_QUEEN;
        ChessType king = ChessType.TYP_KING;
        ChessType knight = ChessType.TYP_KNIGHT;

        this.board = new Piece[8][8];
        
        for(int i = 0;i<8;i++){
            board[i][1] = new Piece(white, pawn);
            board[i][6] = new Piece(black, pawn);
            
            if(i == 0 || i == 7){
                board[i][0] = new Piece(white, rook);
                board[i][7] = new Piece(black, rook);
            }
            if(i == 1 || i == 6){
                board[i][0] = new Piece(white, knight);
                board[i][7] = new Piece(black, knight);
            }
            if(i == 2 || i == 5){
                board[i][0] = new Piece(white, bishop);
                board[i][7] = new Piece(black, bishop);
            }
            if(i == 3){
                board[i][0] = new Piece(white, king);
                board[i][7] = new Piece(black, king);
            }
            if(i == 4){
                board[i][0] = new Piece(white, queen);
                board[i][7] = new Piece(black, queen);
            }
        }
    }
    
    public Piece getPiece(ChessPosition pos){
        return board[pos.x][pos.y];
    }
}
