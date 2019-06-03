/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.ChessPosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author deruepaul
 */
public class King implements IMove{
    

    @Override
    public List<IChess.ChessPosition> getPossibleMoves(ChessPosition pos, ChessBoard board) {
        List listPosition = new ArrayList();
        
        ArrayList<Integer> kingX = new ArrayList<Integer>(Arrays.asList(1, 1, 0, -1, -1, -1, 0, 1));
        ArrayList<Integer> kingY = new ArrayList<Integer>(Arrays.asList(0, -1, -1, -1, 0, 1, 1, 1));
        
        //posTour
        
        ChessPosition posTourDroite = new ChessPosition(0, pos.y);
        
        ChessPosition posTourGauche = new ChessPosition(7, pos.y);
        
        
        for(int i = 0; i < 8; i++){
            
            int posX = pos.x + kingX.get(i);
            int posY = pos.y + kingY.get(i);
                    
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
        if(board.getPiece(pos).getHasMoved() == false && board.getPiece(posTourDroite).getHasMoved() == false){
            ChessPosition static1 = new ChessPosition(1, pos.y);
            ChessPosition static2 = new ChessPosition(2, pos.y);
            ChessPosition static3 = new ChessPosition(3, pos.y);
            
            ChessPosition static4 = new ChessPosition(4, pos.y);
            ChessPosition static5 = new ChessPosition(5, pos.y);
            ChessPosition static6 = new ChessPosition(6, pos.y);
            
            if(board.getPiece(static4) == null && board.getPiece(static5) == null && board.getPiece(static6) == null){
                ChessPosition roque1 = new ChessPosition(6, pos.y);
                listPosition.add(roque1);
            }
         
            if(board.getPiece(static1) == null && board.getPiece(static2) == null && board.getPiece(static3) == null){
                ChessPosition roque2 = new ChessPosition(1, pos.y);
                listPosition.add(roque2);
            }        
        }
        return listPosition;
    }
    
}
