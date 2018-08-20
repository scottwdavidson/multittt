package com.swd.ttt.entity.eval;

import com.swd.ttt.entity.play.MovePosition;
import com.swd.ttt.entity.play.Player;
import com.swd.ttt.entity.play.TicTacToeBoard;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class DrawEvalTest {

    private static DrawEval drawEval = new DrawEval();
    private static TicTacToeBoard X_0_4_5_6_O_2_3_7_8 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_1_2_3_8_6_O_0_4_5_7 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_1_4_7 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_0_1 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_2_5_O_7_8 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_1_2_3_8_O_0_5_7 = TicTacToeBoard.emptyTicTacToeBoard(0);





    @Test
    @UseDataProvider("testEvaluationMatchesData")
    public void testEvaluationMatches(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent, boolean expectedEvaluationMatchesResult){

        Assert.assertEquals( expectedEvaluationMatchesResult, drawEval.evaluationMatches(tictactoeBoard,activePlayer,opponent) );

    }


    @DataProvider
    public static Object[][] testEvaluationMatchesData() {

        // Note: all of this initialization is done here b/c if it's done in @BeforeClass the updated objects
        // are not used here ( most likely due to static object initialization order )
        {
        	X_0_4_5_6_O_2_3_7_8 = TicTacToeBoard.applyMove(X_0_4_5_6_O_2_3_7_8, Player.X, MovePosition.newMovePosition(0,0),0);
        	X_0_4_5_6_O_2_3_7_8 = TicTacToeBoard.applyMove(X_0_4_5_6_O_2_3_7_8, Player.X, MovePosition.newMovePosition(0,4),1);
        	X_0_4_5_6_O_2_3_7_8 = TicTacToeBoard.applyMove(X_0_4_5_6_O_2_3_7_8, Player.X, MovePosition.newMovePosition(0,5),2);
        	X_0_4_5_6_O_2_3_7_8 = TicTacToeBoard.applyMove(X_0_4_5_6_O_2_3_7_8, Player.X, MovePosition.newMovePosition(0,6),3);
        	X_0_4_5_6_O_2_3_7_8 = TicTacToeBoard.applyMove(X_0_4_5_6_O_2_3_7_8, Player.O, MovePosition.newMovePosition(0,2),4);
        	X_0_4_5_6_O_2_3_7_8 = TicTacToeBoard.applyMove(X_0_4_5_6_O_2_3_7_8, Player.O, MovePosition.newMovePosition(0,3),5);
        	X_0_4_5_6_O_2_3_7_8 = TicTacToeBoard.applyMove(X_0_4_5_6_O_2_3_7_8, Player.O, MovePosition.newMovePosition(0,7),6);
        	X_0_4_5_6_O_2_3_7_8 = TicTacToeBoard.applyMove(X_0_4_5_6_O_2_3_7_8, Player.O, MovePosition.newMovePosition(0,8),7);

        }
        
        X_1_2_3_8_6_O_0_4_5_7 = TicTacToeBoard.applyMove(X_1_2_3_8_6_O_0_4_5_7, Player.X, MovePosition.newMovePosition(0,1),0);
        X_1_2_3_8_6_O_0_4_5_7 = TicTacToeBoard.applyMove(X_1_2_3_8_6_O_0_4_5_7, Player.X, MovePosition.newMovePosition(0,2),1);
        X_1_2_3_8_6_O_0_4_5_7 = TicTacToeBoard.applyMove(X_1_2_3_8_6_O_0_4_5_7, Player.X, MovePosition.newMovePosition(0,3),2);
        X_1_2_3_8_6_O_0_4_5_7 = TicTacToeBoard.applyMove(X_1_2_3_8_6_O_0_4_5_7, Player.X, MovePosition.newMovePosition(0,8),3);
        X_1_2_3_8_6_O_0_4_5_7 = TicTacToeBoard.applyMove(X_1_2_3_8_6_O_0_4_5_7, Player.O, MovePosition.newMovePosition(0,0),4);
        X_1_2_3_8_6_O_0_4_5_7 = TicTacToeBoard.applyMove(X_1_2_3_8_6_O_0_4_5_7, Player.O, MovePosition.newMovePosition(0,4),5);
        X_1_2_3_8_6_O_0_4_5_7 = TicTacToeBoard.applyMove(X_1_2_3_8_6_O_0_4_5_7, Player.O, MovePosition.newMovePosition(0,5),6);
        X_1_2_3_8_6_O_0_4_5_7 = TicTacToeBoard.applyMove(X_1_2_3_8_6_O_0_4_5_7, Player.O, MovePosition.newMovePosition(0,7),7);
        X_1_2_3_8_6_O_0_4_5_7 = TicTacToeBoard.applyMove(X_1_2_3_8_6_O_0_4_5_7, Player.X, MovePosition.newMovePosition(0,6),3);


        X_1_4_7 = TicTacToeBoard.applyMove(X_1_4_7, Player.X, MovePosition.newMovePosition(0,1),0);
        X_1_4_7 = TicTacToeBoard.applyMove(X_1_4_7, Player.X, MovePosition.newMovePosition(0,4),1);
        X_1_4_7 = TicTacToeBoard.applyMove(X_1_4_7, Player.X, MovePosition.newMovePosition(0,7),2);
        
        X_0_1 = TicTacToeBoard.applyMove(X_0_1, Player.X, MovePosition.newMovePosition(0,0),0);
        X_0_1 = TicTacToeBoard.applyMove(X_0_1, Player.X, MovePosition.newMovePosition(0,1),1);
        
        X_2_5_O_7_8 = TicTacToeBoard.applyMove(X_2_5_O_7_8, Player.X, MovePosition.newMovePosition(1,2),3);
        X_2_5_O_7_8 = TicTacToeBoard.applyMove(X_2_5_O_7_8, Player.X, MovePosition.newMovePosition(1,5),4);
        X_2_5_O_7_8 = TicTacToeBoard.applyMove(X_2_5_O_7_8, Player.O, MovePosition.newMovePosition(1,7),5);
        X_2_5_O_7_8 = TicTacToeBoard.applyMove(X_2_5_O_7_8, Player.O, MovePosition.newMovePosition(1,8),6);
        
        X_1_2_3_8_O_0_5_7 = TicTacToeBoard.applyMove(X_1_2_3_8_O_0_5_7, Player.X, MovePosition.newMovePosition(0,1),0);
        X_1_2_3_8_O_0_5_7 = TicTacToeBoard.applyMove(X_1_2_3_8_O_0_5_7, Player.X, MovePosition.newMovePosition(0,2),1);
        X_1_2_3_8_O_0_5_7 = TicTacToeBoard.applyMove(X_1_2_3_8_O_0_5_7, Player.X, MovePosition.newMovePosition(0,3),2);
        X_1_2_3_8_O_0_5_7 = TicTacToeBoard.applyMove(X_1_2_3_8_O_0_5_7, Player.X, MovePosition.newMovePosition(0,8),3);
        X_1_2_3_8_O_0_5_7 = TicTacToeBoard.applyMove(X_1_2_3_8_O_0_5_7, Player.O, MovePosition.newMovePosition(0,4),5);
        X_1_2_3_8_O_0_5_7 = TicTacToeBoard.applyMove(X_1_2_3_8_O_0_5_7, Player.O, MovePosition.newMovePosition(0,5),6);
        X_1_2_3_8_O_0_5_7 = TicTacToeBoard.applyMove(X_1_2_3_8_O_0_5_7, Player.O, MovePosition.newMovePosition(0,7),7);

        return new Object[][] {
                {X_0_4_5_6_O_2_3_7_8, Player.X, Player.O, false},
                {X_1_2_3_8_6_O_0_4_5_7, Player.X, Player.O, true},
                {X_1_4_7, Player.X, Player.O, false},
                {X_0_1, Player.X, Player.O, false},
                {X_2_5_O_7_8, Player.X, Player.O, false},
                {X_1_2_3_8_O_0_5_7, Player.X, Player.O, false},

        };
    }

}