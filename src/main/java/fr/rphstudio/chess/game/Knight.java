/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess.ChessPosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author deruepaul
 */
public class Knight implements IMove{
    
    
    
    @Override
    public List<ChessPosition> getPossibleMoves(ChessPosition pos, ChessBoard board) {
        
        ArrayList<Integer> cavaX = new ArrayList<Integer>(Arrays.asList(2,1,-1,-2,-2,-1,1,2));
        ArrayList<Integer> cavaY = new ArrayList<Integer>(Arrays.asList(1,2,2,1,-1,-2,-2,-1));
        
        List listPosition = new ArrayList();
         
        for(int i = 0; i < 8; i++){
            
            int posX = pos.x + cavaX.get(i);
            int posY = pos.y + cavaY.get(i);
                    
            ChessPosition posI = new ChessPosition(posX , posY);

            
            if(board.isPosInBoard(posI) == true){
                if(board.getPiece(posI) == null){
                    listPosition.add(posI);
                }    
                else if(board.getPiece(posI).getColor() != board.getPiece(pos).getColor()){
                    listPosition.add(posI);
                }
            }
        }
        
        return listPosition;
    }
}