package app;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import board.entities.Piece;
import chess.entities.ChessMatch;
import chess.entities.ChessPiece;
import chess.entities.ChessPosition;
import chess.enuns.Color;

public class Util {
    
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";
    private static final String ANSI_RED_BACKGROUND = "\u001B[41m";

    private static void printPiece(ChessPiece piece, boolean background){
        
        if(background){
            System.out.print(ANSI_RED_BACKGROUND);
        }
        if(piece == null){
            System.out.print(ANSI_CYAN + "-" + ANSI_RESET);
        }else{
            if(piece.getColor() == Color.WHITE){
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }else{
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }
    
    private static void printCapturedPieces(ChessMatch match){
        if(match.getCapturedPieces().size() > 0){
            List<Piece> white = match.getCapturedPieces().stream().filter(x -> ((ChessPiece) x).getColor() == Color.WHITE).collect(Collectors.toList());
            List<Piece> black = match.getCapturedPieces().stream().filter(x -> ((ChessPiece) x).getColor() == Color.BLACK).collect(Collectors.toList());
            if(match.getCurrentPlayer() == Color.BLACK){
                System.out.print(ANSI_WHITE);
                System.out.print("White captured pieces: ");
                System.out.println(Arrays.toString(white.toArray()));
                System.out.print(ANSI_RESET);
            }else{
                System.out.print(ANSI_YELLOW);
                System.out.print("Black captured pieces: ");
                System.out.println(Arrays.toString(black.toArray()));
                System.out.print(ANSI_RESET);
            }
        }
    }

    public static void printMatch(ChessMatch match){
        printPieces(match.getPieces());
        printCapturedPieces(match);
        System.out.println("\nTurn: " + match.getTurn());
        
        if(!match.isCheckMate()){
            System.out.println("Current player: " + match.getCurrentPlayer());
            if(match.isCheck()){
                System.out.println("You are in check !");
            }
        }else{
            System.out.println("Checkmate! Winner: " + match.getCurrentPlayer());
        }
    }
    
    public static void printPieces(ChessPiece[][] pieces){
        System.out.println();
        for(int i=0; i<pieces.length;i++){
            System.out.print(pieces.length-i + " |");
            for(int j=0;j<pieces.length;j++){
                printPiece(pieces[i][j], false);
            }
            System.out.println();
        }
        System.out.println("   ---------------");
        System.out.println("   a b c d e f g h");
    }

    public static void printPieces(ChessPiece[][] pieces, boolean[][] possibleMoves){
        System.out.println();
        for(int i=0; i<pieces.length;i++){
            System.out.print(pieces.length-i + " |");
            for(int j=0;j<pieces.length;j++){
                printPiece(pieces[i][j], possibleMoves[i][j]);
            }
            System.out.println();
        }
        System.out.println("   ---------------");
        System.out.println("   a b c d e f g h");
    }
    
    public static void clearConsole() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static ChessPosition readChessPosition(Scanner sc){
        try{
            String position = sc.nextLine();
            char column = position.charAt(0);
            int row = Integer.parseInt(position.substring(1));
            return new ChessPosition(column, row);
        }catch(RuntimeException e){
            throw new InputMismatchException("Error setting the position. Try another position");
        }
    }
}
