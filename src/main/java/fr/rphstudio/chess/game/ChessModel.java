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

import static fr.rphstudio.chess.interf.IChess.ChessType.TYP_KING;

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
        
        //decrementation de remainingList
        if(piece1 != null){
           if(piece1.getColor() == CLR_BLACK){
             board.decrementeRemainingPieces(CLR_BLACK);
             board.addToRemovedList(piece1);
           }
           else if(piece1.getColor() == CLR_WHITE){
               // call remove nb white
             board.decrementeRemainingPieces(CLR_WHITE); 
             board.addToRemovedList(piece1);
           }
           else{
               throw new UnsupportedOperationException();
           }
        }

        if(piece0.getType() == TYP_KING){
            if(pos1.x - pos0.x <= -2){
                board.removePiece(pos0);
        //nik on fait des set et getter to get better
                board.setPiece(pos1, piece0);
                
                
                
                ChessPosition tour = new ChessPosition(0, pos0.y);
                Piece tourToRemove = board.getPiece(tour);
                ChessPosition tourNewPlace = new ChessPosition(2, pos0.y);
                board.removePiece(tour);
                board.setPiece(tourNewPlace,tourToRemove);
                
                
                
            }
            else if(pos1.x - pos0.x >= 2){
                board.removePiece(pos0);
        //nik on fait des set et getter to get better
                board.setPiece(pos1, piece0);
                
                ChessPosition tour = new ChessPosition(7, pos0.y);
                Piece tourToRemove = board.getPiece(tour);
                ChessPosition tourNewPlace = new ChessPosition(5, pos0.y);
                board.removePiece(tour);
                board.setPiece(tourNewPlace,tourToRemove);
                
            }
        }
        else{
            board.removePiece(pos0);
        //nik on fait des set et getter to get better
            board.setPiece(pos1, piece0);
        }
        
        board.removePiece(pos0);
        

        board.getPiece(pos1).setHasMoved();

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
        // On boucle sur toutes les cases
        for(int i = 0; i<8; i++){
            for(int j = 0; j<8; j++){
                ChessPosition pos = new ChessPosition(i, j);
                Piece piece0 = this.board.getPiece(pos);
                
                // On recherche la position du roi dont la couleur est définie
                if(piece0 != null && piece0.getType() == ChessType.TYP_KING && piece0.getColor() == color){
                    
                    // On boucle à nouveau sur toutes les cases
                    for(int k = 0; k<8; k++){
                        for(int l = 0; l<8; l++){
                            ChessPosition posEnemy = new ChessPosition(k, l);
                            Piece piece1 = this.board.getPiece(posEnemy);
                            
                            // On recherche les positions des pièces enemmies
                            if(piece1 != null && piece1.getColor() != piece0.getColor()){
                                
                                // On demande les déplacements des pièces enemmies
                                 List<ChessPosition> list = getPieceMoves(posEnemy);
                                
                                // On boucle sur toutes les positions
                                
                                for(int m = 0; m<list.size(); m++){
                                   if(pos == list.get(m)){
                                        // On vérifie si le roi est en danger
                                        return ChessKingState.KING_THREATEN;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        return ChessKingState.KING_SAFE;
    }

    @Override
    public List<ChessType> getRemovedPieces(ChessColor color) {
 
        return this.board.getRemovedList(color);
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
