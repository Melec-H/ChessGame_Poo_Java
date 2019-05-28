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
        
        for(int i = 0; i < 8; i++){
            
        ChessPosition posI = new ChessPosition(cavaX.get(i), cavaY.get(i));
        
        }
        
        List listPosition = new ArrayList();
        ChessPosition pos1 = new ChessPosition(6,2);
        listPosition.add(pos1);
        return listPosition;
        
    }
    
}
