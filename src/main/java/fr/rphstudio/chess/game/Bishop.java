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
        return listPosition;
    }
    
}
