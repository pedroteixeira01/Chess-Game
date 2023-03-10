package chess.entities.pieces;

import board.entities.Board;
import board.entities.Position;
import chess.entities.ChessPiece;
import chess.enuns.Color;

public class Bishop extends ChessPiece{

    public Bishop() {
        super();
    }
    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() + 1);
        }
        if(getBoard().positionExists(p) && isOpponent(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() + 1);
        }
        if(getBoard().positionExists(p) && isOpponent(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() - 1);
        }
        if(getBoard().positionExists(p) && isOpponent(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() - 1);
        }
        if(getBoard().positionExists(p) && isOpponent(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    } 

    @Override
    public String toString(){
        return "B";
    }
}