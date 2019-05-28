/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author deruepaul
 */
public class King implements IMove{

    @Override
    public List<IChess.ChessPosition> getPossibleMoves() {
        List listPosition = new ArrayList();
        return listPosition;
    }
    
}
