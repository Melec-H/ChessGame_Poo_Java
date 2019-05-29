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
public class Pawn implements IMove{

    @Override
    public List<IChess.ChessPosition> getPossibleMoves(ChessPosition pos, ChessBoard board) {
        List listPosition = new ArrayList();
        
        int posX = pos.x;
        int diagRight = pos.x+1;
        int diagLeft = pos.x-1;
        
        if(board.getPiece(pos).getColor() == IChess.ChessColor.CLR_WHITE){
        
        int posY = pos.y+1;
        
        ChessPosition posI = new ChessPosition(posX, posY);
        ChessPosition posJ = new ChessPosition(posX, posY+1);
        ChessPosition posK = new ChessPosition(diagRight, posY);
        ChessPosition posL = new ChessPosition(diagLeft, posY);
        
        //Temps qu'on est dans le tableau
        if(posX >= 0 && posX <= 7 && posY >= 0 && posY <=7){
            
            //-------MOUVEMENTS DE BASE-------
            //Lors du premier déplacement d'un pion
            if(pos.y == 1){
                if(board.getPiece(posI) == null && board.getPiece(posJ) == null){
                    listPosition.add(posI);
                    listPosition.add(posJ);
                }
                else if(board.getPiece(posI) == null){
                    listPosition.add(posI);
                }
            }
            //Prochains mouvements : 1 par 1
            else if(board.getPiece(posI) == null){
            listPosition.add(posI);
            }
            
            //-------MOUVEMENTS DIAGONALES-------
            if(diagRight >= 0 && diagRight <= 7 && posY >= 0 && posY <=7){
                if(board.getPiece(posK) != null && board.getPiece(posK).getColor() != board.getPiece(pos).getColor()){
                    listPosition.add(posK);
                }
            }
            if(diagLeft >= 0 && diagLeft <= 7 && posY >= 0 && posY <=7){
                if(board.getPiece(posL) != null && board.getPiece(posL).getColor() != board.getPiece(pos).getColor()){
                    listPosition.add(posL);
                }
            }
        }
        }
        else if(board.getPiece(pos).getColor() == IChess.ChessColor.CLR_BLACK){
        
        int posY = pos.y-1;
        
        ChessPosition posI = new ChessPosition(posX, posY);
        ChessPosition posJ = new ChessPosition(posX, posY-1);
        ChessPosition posK = new ChessPosition(diagRight, posY);
        ChessPosition posL = new ChessPosition(diagLeft, posY);
        
        //Temps qu'on est dans le tableau
        if(posX >= 0 && posX <= 7 && posY >= 0 && posY <=7){
            
            //-------MOUVEMENTS DE BASE-------
            //Lors du premier déplacement d'un pion
            if(pos.y == 6){
                if(board.getPiece(posI) == null && board.getPiece(posJ) == null){
                    listPosition.add(posI);
                    listPosition.add(posJ);
                }
                else if(board.getPiece(posI) == null){
                    listPosition.add(posI);
                }
            }
            //Prochains mouvements : 1 par 1
            else if(board.getPiece(posI) == null){
            listPosition.add(posI);
            }
            
            //-------MOUVEMENTS DIAGONALES-------
            if(diagRight >= 0 && diagRight <= 7 && posY >= 0 && posY <=7){
                if(board.getPiece(posK) != null && board.getPiece(posK).getColor() != board.getPiece(pos).getColor()){
                    listPosition.add(posK);
                }
            }
            if(diagLeft >= 0 && diagLeft <= 7 && posY >= 0 && posY <=7){
                if(board.getPiece(posL) != null && board.getPiece(posL).getColor() != board.getPiece(pos).getColor()){
                    listPosition.add(posL);
                }
            }
        }
        }
        return listPosition;
    }    
}