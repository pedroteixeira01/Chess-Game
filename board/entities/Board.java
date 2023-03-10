package board.entities;

import board.exceptions.BoardException;

public class Board{

    private int rows, columns;
    private Piece[][] pieces;

    public Board(){}
    public Board(int rows, int columns){
        if(rows < 1 || columns < 1){
            throw new BoardException("Error in board creation -> Rows and columns should be higher than 0");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }
    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column){
        if(!positionExists(row, column)){
            throw new BoardException("Error in position input -> Position " + row + "," + column + " is out of the range");
        }
        return pieces[row][column];
    }
    public Piece piece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Error in position input -> Position " + position + " is out of the range");
        }
        return pieces[position.getRow()][position.getColumn()];
    }
    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece(position)){
            throw new BoardException("Error placing the piece -> The position already have a piece");
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }
    public Piece removePiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Error in position input -> Position " + position + " is out of the range");
        }
        if(piece(position) == null){
            return null;
        }
        Piece piece = piece(position);
        piece.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return piece;
    }
    public boolean positionExists(int row, int column){
        return row < rows && row >= 0 && column < columns && column >= 0 ;
    }
    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }
    public boolean thereIsAPiece(int row, int column){
        if(pieces[row][column] == null){
            return true;
        }else{
            return false;
        }
    }
    public boolean thereIsAPiece(Position position){
        if(positionExists(position)){
            if(pieces[position.getRow()][position.getColumn()] == null){
                return false;
            }else{
                return true;
            }
        }else{
            throw new BoardException("Position " + position + " is out of the range");
        }
    }
}