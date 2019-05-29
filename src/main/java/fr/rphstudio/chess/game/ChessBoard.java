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
    private RemainingPieces remainingPieces;
    
    public ChessBoard(RemainingPieces compteur){
        ChessColor white = ChessColor.CLR_WHITE;
        ChessColor black = ChessColor.CLR_BLACK;

        ChessType rook = ChessType.TYP_ROOK;
        ChessType pawn = ChessType.TYP_PAWN;
        ChessType bishop = ChessType.TYP_BISHOP;
        ChessType queen = ChessType.TYP_QUEEN;
        ChessType king = ChessType.TYP_KING;
        ChessType knight = ChessType.TYP_KNIGHT;
        
        IMove kingInterface = new King();
        IMove queenInterface = new Queen();
        IMove bishopInterface = new Bishop();
        IMove knightInterface = new Knight();
        IMove rookInterface = new Rook();
        IMove pawnInterface = new Pawn();
        
        this.board = new Piece[8][8];
        this.remainingPieces = new RemainingPieces();
        
        for(int i = 0;i<8;i++){
            board[i][1] = new Piece(white, pawn, pawnInterface);
            board[i][6] = new Piece(black, pawn, pawnInterface);
            
            if(i == 0 || i == 7){
                board[i][0] = new Piece(white, rook, rookInterface);
                board[i][7] = new Piece(black, rook, rookInterface);
            }
            if(i == 1 || i == 6){
                board[i][0] = new Piece(white, knight, knightInterface);
                board[i][7] = new Piece(black, knight, knightInterface);
            }
            if(i == 2 || i == 5){
                board[i][0] = new Piece(white, bishop, bishopInterface);
                board[i][7] = new Piece(black, bishop, bishopInterface);
            }
            if(i == 3){
                board[i][0] = new Piece(white, king, kingInterface);
                board[i][7] = new Piece(black, king, kingInterface);
            }
            if(i == 4){
                board[i][0] = new Piece(white, queen, queenInterface);
                board[i][7] = new Piece(black, queen, queenInterface);
            }
        }
    }
    //remainingpieces
    public int getRemainingPieces(ChessColor color){
        return this.remainingPieces.getRemainingPieces(color);
    }
    
    public void decrementeRemainingPieces(ChessColor color){
        this.remainingPieces.decrementeRemainingPieces(color);
    }
    
    public Piece getPiece(ChessPosition pos){
        return board[pos.x][pos.y];
    }
    
    public void setPiece(ChessPosition pos, Piece piece){
       
        board[pos.x][pos.y] = piece;
    }
    public void removePiece(ChessPosition pos){
        board[pos.x][pos.y] = null;
    }
    public boolean isPosInBoard(ChessPosition pos){
        if(pos.x >= 0 && pos.x <= 7 && pos.y >= 0 && pos.y <=7){
            return true;
        }
        else{
            return false;
        } 
    }
}
