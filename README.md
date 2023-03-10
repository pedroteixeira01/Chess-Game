# Really simple Chess game

A simple chess game implemented fully in java language that follows all the rules of the real chess.

## How to play

After start the game process the player will see the board with pieces already in initial positions, the count of the turn in the match, the current player color and, if have a captured piece, a list of captured pieces of each color. Like the real chess, white pieces will make the first movement:


8 |R N B Q K B N R <br>
7 |P P P P P P P P <br>
6 |- - - - - - - - <br>
5 |- - - - - - - - <br>
4 |- - - - - - - - <br>
3 |- - - - - - - - <br>
2 |P P P P P P P P <br>
1 |R N B Q K B N R <br>
   --------------- <br>
   a b c d e f g h

Turn: 1<br>
Current player: WHITE


First the player should choose the piece with the board coordinate(columns first after rows), for example: 
> Enter the source position: a2

After selecting the piece using the coordinates the board will mark in red color the possible new positions of the chosen piece.

We will use the same logic for moving pieces:
> Enter the target position: a3

The objectives are the same as real chess, enjoy and have fun !

