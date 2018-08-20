package com.swd.ttt.entity.eval;

import com.swd.ttt.entity.play.Player;
import com.swd.ttt.entity.play.TicTacToeBoard;

public class DrawEval implements Eval {

	public boolean evaluationMatches(TicTacToeBoard tictactoeBoard,	Player activePlayer, Player opponent) {		
		
		//check to make sure no players have won first
		WinEval winEval = new WinEval();
		if(winEval.evaluationMatches(tictactoeBoard, activePlayer, opponent) || winEval.evaluationMatches(tictactoeBoard, opponent, activePlayer)){
			return false;
		}
		
		//check if all spots on tttboard have been played on
		for(int i=0; i<tictactoeBoard.getCells().length; i++){
			if(tictactoeBoard.getCells()[i].getPlayer() == Player.None){
				return false;
			}
		}
		return true;
	}

}
