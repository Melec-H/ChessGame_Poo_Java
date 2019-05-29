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
public class Queen implements IMove{

    @Override
    public List<ChessPosition> getPossibleMoves(ChessPosition pos, ChessBoard board) {
        List listPosition = new ArrayList();
       
       //code of bishop.java
       for(int direction = 0; direction<=3; direction++){
            int dx = 1;
            int dy = 1;
            
            if(direction >= 2){
                dx = -1;
            }
            if(direction % 2 == 0){
                dy = -1;
            }
            
            for(int distance = 1; distance <= 7; distance++){
                ChessPosition nextPos = new ChessPosition(pos.x + dx*distance, pos.y + dy*distance);
                
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
    int posX = pos.x;
        int posY = pos.y;

        for(int i = 1; i <= 7; i++){
            
            ChessPosition pos1 = new ChessPosition(posX, posY +i);
            
            if(board.isPosInBoard(pos1) == false){
                break;
            }
            else{
                if(board.getPiece(pos1) == null){
                    listPosition.add(pos1);
                }
                else if(board.getPiece(pos1).getColor() != board.getPiece(pos).getColor()){
                    listPosition.add(pos1);
                    break;
                }else if(board.getPiece(pos1).getColor() == board.getPiece(pos).getColor()){
                    break;
                }   
            }
        }
        for(int i = 1; i <= 7; i++){
            
            ChessPosition pos2 = new ChessPosition(posX+i, posY);
            
            if(board.isPosInBoard(pos2) == false){
                break;
            }
            else{
                if(board.getPiece(pos2) == null){
                    listPosition.add(pos2);
                }
                else if(board.getPiece(pos2).getColor() != board.getPiece(pos).getColor()){
                    listPosition.add(pos2);
                    break;
                }else if(board.getPiece(pos2).getColor() == board.getPiece(pos).getColor()){
                    break;
                }
            }
        }
        for(int i = 1; i <= 7; i++){
            
            ChessPosition pos3 = new ChessPosition(posX-i, posY);
            
            if(board.isPosInBoard(pos3) == false){
                break;
            }
            else{
                if(board.getPiece(pos3) == null){
                    listPosition.add(pos3);
                }
                else if(board.getPiece(pos3).getColor() != board.getPiece(pos).getColor()){
                    listPosition.add(pos3);
                    break;
                }else if(board.getPiece(pos3).getColor() == board.getPiece(pos).getColor()){
                    break;
                }
            }
        }
        for(int i = 1; i <= 7; i++){
            
            ChessPosition pos4 = new ChessPosition(posX, posY-i);

            if(board.isPosInBoard(pos4) == false){
                break;
            }
            else{
                if(board.getPiece(pos4) == null){
                    listPosition.add(pos4);
                }
                else if(board.getPiece(pos4).getColor() != board.getPiece(pos).getColor()){
                    listPosition.add(pos4);
                    break;
                }else if(board.getPiece(pos4).getColor() == board.getPiece(pos).getColor()){
                    break;
                }
            }
        }
        return listPosition;
    }
    
}
