/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess.ChessColor;
import fr.rphstudio.chess.interf.IChess.ChessPosition;
import fr.rphstudio.chess.interf.IChess.ChessType;
import java.util.List;

/**
 *
 * @author jisseaudamien
 */
public class Piece {
    
    private IMove iMove;
    private ChessType ChessType;
    private ChessColor ChessColor;
    
    public Piece(ChessColor color, ChessType type, IMove iMove){
        this.ChessColor = color;
        this.ChessType = type;
    }
    
    public ChessType getType(){
        return this.ChessType;
    }
    
    public ChessColor getColor(){
        return this.ChessColor;
    }
    
    public List<ChessPosition> getMoves(ChessPosition pos, ChessBoard board){
        
        return iMove.getPossibleMoves(pos, board);
        
    }
    
}
