/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.EmptyCellException;
import fr.rphstudio.chess.interf.IChess;
import static fr.rphstudio.chess.interf.IChess.ChessColor.CLR_BLACK;
import static fr.rphstudio.chess.interf.IChess.ChessColor.CLR_WHITE;
import static fr.rphstudio.chess.interf.IChess.ChessType.TYP_PAWN;
import fr.rphstudio.chess.interf.OutOfBoardException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jisseaudamien
 */
public class ChessModel implements IChess{
    
    private ChessBoard board;
    
    private ChessModel(){
        
    }
    
    public static ChessModel instance = null;
    
    public static ChessModel getInstance(){
        if(instance == null){
            instance = new ChessModel();
        }
        return instance;
    }

    @Override
    public void reinit() {
        // initialisation du plateau de jeu
        RemainingPieces compteur = new RemainingPieces();
        this.board = new ChessBoard(compteur);
    }

    @Override
    public ChessType getPieceType(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        // obtenir le type de pièce à une position donnée
        Piece piece = this.board.getPiece(p);
        if(piece != null){
            return piece.getType();
        }
        else{
            throw new EmptyCellException();
        }
    }

    @Override
    public ChessColor getPieceColor(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        // obtenir la couleur de la pièce à une position donnée
        Piece piece = this.board.getPiece(p);
        if(piece != null){
            return piece.getColor();
        }
        else{
            throw new EmptyCellException();
        }
    }

    @Override
    public int getNbRemainingPieces(ChessColor color) {
        return this.board.getRemainingPieces(color);
        
    }

    @Override
    public List<ChessPosition> getPieceMoves(ChessPosition p) {
        Piece piece = this.board.getPiece(p);
        if(piece != null){
            return piece.getMoves(p, board);
        }
        return new ArrayList<>();
    }

    @Override
    public void movePiece(ChessPosition pos0, ChessPosition pos1) {
        
        Piece piece0 = this.board.getPiece(pos0);
        Piece piece1 = this.board.getPiece(pos1);
        Piece whiteQueen = new Piece(ChessColor.CLR_WHITE, ChessType.TYP_QUEEN, new Queen());
        Piece blackQueen = new Piece(ChessColor.CLR_BLACK, ChessType.TYP_QUEEN, new Queen());
        
        if(piece1 != null){
           if(piece1.getColor() == CLR_BLACK){
             board.decrementeRemainingPieces(CLR_BLACK);
           }
           else if(piece1.getColor() == CLR_WHITE){
               // call remove nb white
             board.decrementeRemainingPieces(CLR_WHITE);  
           }
           else{
               throw new UnsupportedOperationException();
           }
        }
        
        board.removePiece(pos0);
        
        if(piece0.getType() == TYP_PAWN && piece0.getColor() == CLR_WHITE && pos0.y == 6){
            board.setPiece(pos1, whiteQueen);
        }
        else if(piece0.getType() == TYP_PAWN && piece0.getColor() == CLR_BLACK && pos0.y == 1){
            board.setPiece(pos1, blackQueen);
        }
        else{
            board.setPiece(pos1, piece0);
        }
        
        //  board.move(p0,p1);
        
    }

    @Override
    public ChessKingState getKingState(ChessColor color) {
        return ChessKingState.KING_SAFE;
    }

    @Override
    public List<ChessType> getRemovedPieces(ChessColor color) {
        return new ArrayList<>();    
    }

    @Override
    public boolean undoLastMove() {
        return true;
    }

    @Override
    public long getPlayerDuration(ChessColor color, boolean isPlaying) {
        return 26;
    }
    
}
