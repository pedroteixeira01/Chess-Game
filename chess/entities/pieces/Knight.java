package chess.entities.pieces;

import board.entities.Board;
import board.entities.Position;
import chess.entities.ChessPiece;
import chess.enuns.Color;

public class Knight extends ChessPiece{

    public Knight(){
        super();
    }
    public Knight(Board board, Color color){
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        p.setValues(position.getRow() - 2, position.getColumn() + 1);
        if(getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isOpponent(p))){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow() - 2, position.getColumn() - 1);
        if(getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isOpponent(p))){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow() + 2, position.getColumn() + 1);
        if(getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isOpponent(p))){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow() + 2, position.getColumn() - 1);
        if(getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isOpponent(p))){
            mat[p.getRow()][p.getColumn()] = true;
        }
        
        p.setValues(position.getRow() + 1, position.getColumn() - 2);
        if(getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isOpponent(p))){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow() - 1, position.getColumn() - 2);
        if(getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isOpponent(p))){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow() - 1, position.getColumn() + 2);
        if(getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isOpponent(p))){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow() + 1, position.getColumn() + 2);
        if(getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isOpponent(p))){
            mat[p.getRow()][p.getColumn()] = true;
        }
        
        return mat;
    }

    @Override
    public String toString(){
        return "N";
    }
}