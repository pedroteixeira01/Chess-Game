package chess.entities;

import board.entities.Position;
import chess.exceptions.ChessException;

public class ChessPosition {
    
    private char column;
    private int row;

    public ChessPosition(){}
    public ChessPosition(char column, int row){
        if(row < 1 || row > 8 || column < 'a' || column > 'h'){
            throw new ChessException("Error in board creation -> Rows should be higher than 0 and columns should be contained between a and h");
        }
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }
    public int getRow() {
        return row;
    }

    protected Position toPosition(){
        return new Position(8 - row, column - 'a');
    }
    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString(){
        return "" + column + row;
    }
}
