# Multi-TicTacToe Service
## Welcome
Welcome to the Multi-TicTacToe (or multittt) service repository. This repository holds the business logic to support the play of Multi Tic Tac Toe, an automaton (automated player) w/ plugin Strategies and a web service API (to allow managed game play through a web app player). There's also a CLI ( command line ) player version provided for those w/ Java installed. 

## The Game of Tic Tac Toe
The game of tic tac toe is very simple with limited strategies which often lead to a draw ( sometimes called a *cat's game* ) for players with a small amount of knowledge of the game ( typically 5 yr olds can't be beat unless you distract them with candy ). To win one must simply secure three (3) consecutive cells in a vertical column, horizontal row or on the diagonal of the 3 x 3 board as depicted below: 

```  
 x |   |          o |   |         o |   | x
 - - - - -        - - - - -       - - - - - 
 x | o |          x | x | x       o | x | 
 - - - - -        - - - - -       - - - - - 
 x | o | o        o |   | o       x |   | o
 ```
 
 ## Expanding to Multi Tic Tac Toe
 To provide a more challenging game ( both from a technical software solution as well as for the players themselves ), we've adapted the simple game of tic tac toe and expanded the board to include nine (9) _separate but connected_ tic tac toe boards and adapted the rule play slightly in terms of which specific board is played on. 

### The Board
 First, here's the starting game board for our version of Multi Tic Tac Toe:
 
 ```  
 
   |   |            |   |           |   |  
 - - - - -        - - - - -       - - - - - 
   |   |            |   |           |   | 
 - - - - -        - - - - -       - - - - - 
   |   |            |   |           |   | 
 
 
   |   |            |   |           |   |  
 - - - - -        - - - - -       - - - - - 
   |   |            |   |           |   | 
 - - - - -        - - - - -       - - - - - 
   |   |            |   |           |   | 
 
 
   |   |            |   |           |   |  
 - - - - -        - - - - -       - - - - - 
   |   |            |   |           |   | 
 - - - - -        - - - - -       - - - - - 
   |   |            |   |           |   | 
 
 
 ```
 
### The Rules
* __To Win__: the player who wins the most individual tic tac toe boards is the winner. Draws (or Cat's Game) boards give no points while each winning board gives 1 point. 
* __To Win an individual tic tac toe board__: the first player to record 3 consecutive plays in a vertical column, a horizontal row or diagonal ( as depicted above ). 
* __Which board to play on__: The first play can be on any board. (In our software implementation, we'll randomly pick a board to start on to simply the front end initially). All subsequent plays are dictated by the previously played in __cell__, that is, if player __X__ plays in the __center__ of any board, player __O__ must play next in the __center__ tic tac toe board. Similarly, if player __O__ then plays in the upper left cell, player __X__ is now required to play in the upper left tic tac toe board. To illustrate, please see an example play depiction below: 



 
 Table Move Positions:
 
 ```
 
 0 | 1 | 2       
 - - - - -       
 3 | 4 | 5        
 - - - - -       
 6 | 7 | 8     
 
 ```
 
 Example Game Play ( 6 moves ): 
 
 
 ```
 
|-------------------------------------|
| Play No.| Player | Board | Position |
|---------|--------|-------|----------|
|    1    |    X   |   4   |    0     |
|    2    |    O   |   0   |    2     |
|    3    |    X   |   2   |    8     |
|    4    |    O   |   8   |    2     |
|    5    |    X   |   2   |    2     |
|    6    |    O   |   2   |    5     |
|-------------------------------------|

```

Example Game Play ( board ):

```

   |   | o (2)      |   |           |   | x (5)
 - - - - -        - - - - -       - - - - - 
   |   |            |   |           |   | o (6)
 - - - - -        - - - - -       - - - - - 
   |   |            |   |           |   | x (3)
 
 
   |   |      (1) x |   |           |   |  
 - - - - -        - - - - -       - - - - - 
   |   |            |   |           |   | 
 - - - - -        - - - - -       - - - - - 
   |   |            |   |           |   | 
 
 
   |   |            |   |           |   | o (4) 
 - - - - -        - - - - -       - - - - - 
   |   |            |   |           |   | 
 - - - - -        - - - - -       - - - - - 
   |   |            |   |           |   | 


```


### The Rules (a few more)
* __Which board to play on if specified board is already won or full?__: in the situation when the previous play position directs you to a board which has already been won __or__ is completely full ( __draw__ ), then you simply go to the next higher board ( to the right ). If the last board is won or full, then go to the first board. 
* __Can a player elect to not play?__: each player *must* play every turn. If the active board has only 1 position to play on, the that position must be played on.
