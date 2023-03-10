package chess.entities;

import board.entities.Board;
import board.entities.Piece;
import board.entities.Position;
import chess.enuns.Color;

public abstract class ChessPiece extends Piece{
    
    private Color color;
    private int moveCount;

    public ChessPiece(){}
    public ChessPiece(Board board, Color color){
        super(board);
        this.color = color;
    }
    public int getMoveCount() {
        return moveCount;
    }
    public Color getColor() {
        return color;
    }

    public ChessPosition getChessPosition(){
        return ChessPosition.fromPosition(position);
    }

    protected boolean isOpponent(Position position){
        ChessPiece piece = (ChessPiece) getBoard().piece(position);
        return piece != null && piece.color != color;
    }

    protected void increaseMove(){
        moveCount++;
    }
    
    protected void decreaseMove(){
        moveCount--;
    }
}
