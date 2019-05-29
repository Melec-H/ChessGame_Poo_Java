/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess.ChessColor;

/**
 *
 * @author duhalgouetmelec
 */
public class RemainingPieces {
    int whitePiecesRemaining;
    int blackPiecesRemaining;
    
    RemainingPieces(){
        this.whitePiecesRemaining = 16;
        this.blackPiecesRemaining = 16;
    }
    
    public int getRemainingPieces(ChessColor color){
        if(color == ChessColor.CLR_WHITE){
            return this.whitePiecesRemaining;
        }
        else{
            return this.blackPiecesRemaining;
        }
    }
    public void decrementeRemainingPieces(ChessColor color){
        if(color == ChessColor.CLR_BLACK){
            this.blackPiecesRemaining -= 1;
        }
        else{
            this.whitePiecesRemaining -=1;
        }
    }
}
