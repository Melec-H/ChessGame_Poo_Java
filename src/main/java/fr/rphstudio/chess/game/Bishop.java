/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessPosition;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author deruepaul
 */
public class Bishop implements IMove{

    @Override
    public List<IChess.ChessPosition> getPossibleMoves(ChessPosition pos, ChessBoard board) {
        List listPosition = new ArrayList();
        
        for(int direction = 0; direction<3; direction++){
            int dx = 1;
            int dy = 1;
            
            if(direction >= 2){
                dx = -1;
            }
            if(direction % 2 == 0){
                dy = -1;
            }
            
            for(int distance = 1; distance < 7; distance++){
                ChessPosition nextPos = new ChessPosition(dx, dy);
                
                if(board.isPosInBoard(nextPos) == false){
                    break;
                            }
                else{
                    
                    if(board.getPiece(nextPos) == null){
                        listPosition.add(nextPos);
                    }
                    else if(board.getPiece(nextPos).getColor() != board.getPiece(pos).getColor()){
                        listPosition.add(nextPos);
                        break;
                    }
                    else if(board.getPiece(nextPos).getColor() == board.getPiece(pos).getColor()){
                        break;  
                    }
                }
            }
        }
        return listPosition;
    }
}
    
    
    
