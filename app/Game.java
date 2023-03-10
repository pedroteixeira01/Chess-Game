package app;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.entities.ChessMatch;
import chess.entities.ChessPosition;
import chess.exceptions.ChessException;

public class Game {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        
        while(!chessMatch.isCheckMate()){
            try{
                Util.clearConsole();
                Util.printMatch(chessMatch);
                System.out.print("\nEnter the source position: ");
                ChessPosition so = Util.readChessPosition(sc);
                boolean[][] pieceMoves = chessMatch.possibleMoves(so);
                Util.clearConsole();
                Util.printPieces(chessMatch.getPieces(), pieceMoves);
                System.out.print("\nEnter the target position: ");
                ChessPosition tg = Util.readChessPosition(sc);
                chessMatch.performChessMove(so, tg);

                if (chessMatch.getPromoted() != null) {
					System.out.print("Enter piece for promotion (B/N/R/Q): ");
					String type = sc.nextLine().toUpperCase();
					while (!type.equals("B") && !type.equals("N") && !type.equals("R") & !type.equals("Q")) {
						System.out.print("Invalid value! Enter piece for promotion (B/N/R/Q): ");
						type = sc.nextLine().toUpperCase();
					}
					chessMatch.replacePromotedPiece(type);
				}

            }catch(ChessException e){
                System.out.println("\n"+e.getMessage());
                System.out.println("Press enter to continue.");
                sc.nextLine();

            }catch(InputMismatchException e){
                System.out.println("\n"+e.getMessage());
                System.out.println("Press enter to continue.");
                sc.nextLine();
            }
        }
    }
}