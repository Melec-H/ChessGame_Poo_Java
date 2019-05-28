/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessColor;
import fr.rphstudio.chess.interf.IChess.ChessPosition;
import fr.rphstudio.chess.interf.IChess.ChessType;

/**
 *
 * @author duhalgouetmelec
 */
public class ChessBoard {
    
         //variables
        private Piece[][] board;
        
        public ChessBoard(){
            
            ChessColor black = ChessColor.CLR_BLACK;
            ChessColor white = ChessColor.CLR_WHITE;

            ChessType rook = ChessType.TYP_ROOK;
            ChessType bishop = ChessType.TYP_BISHOP;
            ChessType knight = ChessType.TYP_KNIGHT;
            ChessType queen = ChessType.TYP_QUEEN;
            ChessType king = ChessType.TYP_KING;
            ChessType pawn = ChessType.TYP_PAWN;

            //coté blanc
            //tour
            this.board = new Piece[8][8];
            
            
            board[0][0] = new Piece(black, rook);
            
            
            
        }
        
        public Piece getPiece(ChessPosition pos){
                    
            return board[pos.x][pos.y];
        }       
        
}
