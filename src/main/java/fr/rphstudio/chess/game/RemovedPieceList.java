/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess.ChessColor;
import static fr.rphstudio.chess.interf.IChess.ChessColor.CLR_BLACK;
import fr.rphstudio.chess.interf.IChess.ChessType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author deruepaul
 */
public class RemovedPieceList {
    
    private List<ChessType> whitepiece;
    private List<ChessType> blackpiece;
    
    public RemovedPieceList(){
        this.blackpiece = new ArrayList<>();
        this.whitepiece = new ArrayList<>();
    }
    
    public List<ChessType> getRemovedPiece(ChessColor color){
        if(color == ChessColor.CLR_BLACK){
            return this.blackpiece;
        }else{
            return this.whitepiece;
        }
    }
    
    public void setRemovedPiece(Piece removedPiece){
        if(removedPiece.getColor() == CLR_BLACK){
            this.blackpiece.add(removedPiece.getType());
        }else{
            this.whitepiece.add(removedPiece.getType());
        }
    }
    
    
}
