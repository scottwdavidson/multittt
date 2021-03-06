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
public class SingleRowColumnDiagnoalEvalTest {

    private static Eval eval = new SingleRowColumnDiagonalEval();
    private static TicTacToeBoard X_0_O_2 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_2_5_O_7_8 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_4_8_O_0_2_5_7 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_4_8_O_1_3 = TicTacToeBoard.emptyTicTacToeBoard(0);

    private static TicTacToeBoard X_0 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_1 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_2 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_3 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_4 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_5 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_6 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_7 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_8 = TicTacToeBoard.emptyTicTacToeBoard(0);

    private static TicTacToeBoard X_0_1_2 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_3_4_5 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_6_7_8 = TicTacToeBoard.emptyTicTacToeBoard(0);

    private static TicTacToeBoard X_0_3_6 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_1_4_7 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_2_5_8 = TicTacToeBoard.emptyTicTacToeBoard(0);

    private static TicTacToeBoard X_0_4_8 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_2_4_6 = TicTacToeBoard.emptyTicTacToeBoard(0);


    @Test
    @UseDataProvider("testEvaluationMatchesData")
    public void testEvaluationMatches(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent, boolean expectedEvaluationMatchesResult){

        Assert.assertEquals( expectedEvaluationMatchesResult, eval.evaluationMatches(tictactoeBoard,activePlayer,opponent) );

    }


    @DataProvider
    public static Object[][] testEvaluationMatchesData() {

        // Note: all of this initialization is done here b/c if it's done in @BeforeClass the updated objects
        // are not used here ( most likely due to static object initialization order )
        {
            X_0_O_2 = TicTacToeBoard.applyMove(X_0_O_2, Player.X, MovePosition.newMovePosition(0,0),0);
            X_0_O_2 = TicTacToeBoard.applyMove(X_0_O_2, Player.O, MovePosition.newMovePosition(0,2),1);
        }
        {
            X_2_5_O_7_8 = TicTacToeBoard.applyMove(X_2_5_O_7_8, Player.X, MovePosition.newMovePosition(1,2),3);
            X_2_5_O_7_8 = TicTacToeBoard.applyMove(X_2_5_O_7_8, Player.X, MovePosition.newMovePosition(1,5),4);
            X_2_5_O_7_8 = TicTacToeBoard.applyMove(X_2_5_O_7_8, Player.O, MovePosition.newMovePosition(1,7),5);
            X_2_5_O_7_8 = TicTacToeBoard.applyMove(X_2_5_O_7_8, Player.O, MovePosition.newMovePosition(1,8),6);

        }
        {
            X_4_8_O_0_2_5_7 = TicTacToeBoard.applyMove(X_4_8_O_0_2_5_7, Player.X, MovePosition.newMovePosition(1,4),7);
            X_4_8_O_0_2_5_7 = TicTacToeBoard.applyMove(X_4_8_O_0_2_5_7, Player.X, MovePosition.newMovePosition(1,8),8);
            X_4_8_O_0_2_5_7 = TicTacToeBoard.applyMove(X_4_8_O_0_2_5_7, Player.O, MovePosition.newMovePosition(1,0),9);
            X_4_8_O_0_2_5_7 = TicTacToeBoard.applyMove(X_4_8_O_0_2_5_7, Player.O, MovePosition.newMovePosition(1,2),10);
            X_4_8_O_0_2_5_7 = TicTacToeBoard.applyMove(X_4_8_O_0_2_5_7, Player.O, MovePosition.newMovePosition(1,5),10);
            X_4_8_O_0_2_5_7 = TicTacToeBoard.applyMove(X_4_8_O_0_2_5_7, Player.O, MovePosition.newMovePosition(1,7),10);

        }
        {
            X_4_8_O_1_3 = TicTacToeBoard.applyMove(X_4_8_O_1_3, Player.X, MovePosition.newMovePosition(1,4),7);
            X_4_8_O_1_3 = TicTacToeBoard.applyMove(X_4_8_O_1_3, Player.X, MovePosition.newMovePosition(1,8),8);
            X_4_8_O_1_3 = TicTacToeBoard.applyMove(X_4_8_O_1_3, Player.O, MovePosition.newMovePosition(1,1),9);
            X_4_8_O_1_3 = TicTacToeBoard.applyMove(X_4_8_O_1_3, Player.O, MovePosition.newMovePosition(1,3),10);

        }

        {
            X_0 = TicTacToeBoard.applyMove(X_0, Player.X, MovePosition.newMovePosition(0,0),0);
            X_1 = TicTacToeBoard.applyMove(X_1, Player.X, MovePosition.newMovePosition(0,1),0);
            X_2 = TicTacToeBoard.applyMove(X_2, Player.X, MovePosition.newMovePosition(0,2),0);
            X_3 = TicTacToeBoard.applyMove(X_3, Player.X, MovePosition.newMovePosition(0,3),0);
            X_4 = TicTacToeBoard.applyMove(X_4, Player.X, MovePosition.newMovePosition(0,4),0);
            X_5 = TicTacToeBoard.applyMove(X_5, Player.X, MovePosition.newMovePosition(0,5),0);
            X_6 = TicTacToeBoard.applyMove(X_6, Player.X, MovePosition.newMovePosition(0,6),0);
            X_7 = TicTacToeBoard.applyMove(X_7, Player.X, MovePosition.newMovePosition(0,7),0);
            X_8 = TicTacToeBoard.applyMove(X_8, Player.X, MovePosition.newMovePosition(0,8),0);
        }


        {
            X_0_1_2 = TicTacToeBoard.applyMove(X_0_1_2, Player.X, MovePosition.newMovePosition(0,0),0);
            X_0_1_2 = TicTacToeBoard.applyMove(X_0_1_2, Player.X, MovePosition.newMovePosition(0,1),1);
            X_0_1_2 = TicTacToeBoard.applyMove(X_0_1_2, Player.X, MovePosition.newMovePosition(0,2),2);
        }

        {
            X_3_4_5 = TicTacToeBoard.applyMove(X_3_4_5, Player.X, MovePosition.newMovePosition(0,3),0);
            X_3_4_5 = TicTacToeBoard.applyMove(X_3_4_5, Player.X, MovePosition.newMovePosition(0,4),1);
            X_3_4_5 = TicTacToeBoard.applyMove(X_3_4_5, Player.X, MovePosition.newMovePosition(0,5),2);
        }

        {
            X_6_7_8 = TicTacToeBoard.applyMove(X_6_7_8, Player.X, MovePosition.newMovePosition(0,6),0);
            X_6_7_8 = TicTacToeBoard.applyMove(X_6_7_8, Player.X, MovePosition.newMovePosition(0,7),1);
            X_6_7_8 = TicTacToeBoard.applyMove(X_6_7_8, Player.X, MovePosition.newMovePosition(0,8),2);
        }

        {
            X_0_3_6 = TicTacToeBoard.applyMove(X_0_3_6, Player.X, MovePosition.newMovePosition(0,6),0);
            X_0_3_6 = TicTacToeBoard.applyMove(X_0_3_6, Player.X, MovePosition.newMovePosition(0,3),1);
            X_0_3_6 = TicTacToeBoard.applyMove(X_0_3_6, Player.X, MovePosition.newMovePosition(0,6),2);
        }

        {
            X_1_4_7 = TicTacToeBoard.applyMove(X_1_4_7, Player.X, MovePosition.newMovePosition(0,1),0);
            X_1_4_7 = TicTacToeBoard.applyMove(X_1_4_7, Player.X, MovePosition.newMovePosition(0,4),1);
            X_1_4_7 = TicTacToeBoard.applyMove(X_1_4_7, Player.X, MovePosition.newMovePosition(0,7),2);
        }

        {
            X_2_5_8 = TicTacToeBoard.applyMove(X_2_5_8, Player.X, MovePosition.newMovePosition(0,2),0);
            X_2_5_8 = TicTacToeBoard.applyMove(X_2_5_8, Player.X, MovePosition.newMovePosition(0,5),1);
            X_2_5_8 = TicTacToeBoard.applyMove(X_2_5_8, Player.X, MovePosition.newMovePosition(0,8),2);
        }

        {
            X_0_4_8 = TicTacToeBoard.applyMove(X_0_4_8, Player.X, MovePosition.newMovePosition(0,0),0);
            X_0_4_8 = TicTacToeBoard.applyMove(X_0_4_8, Player.X, MovePosition.newMovePosition(0,4),1);
            X_0_4_8 = TicTacToeBoard.applyMove(X_0_4_8, Player.X, MovePosition.newMovePosition(0,8),2);
        }

        {
            X_2_4_6 = TicTacToeBoard.applyMove(X_2_4_6, Player.X, MovePosition.newMovePosition(0,2),0);
            X_2_4_6 = TicTacToeBoard.applyMove(X_2_4_6, Player.X, MovePosition.newMovePosition(0,4),1);
            X_2_4_6 = TicTacToeBoard.applyMove(X_2_4_6, Player.X, MovePosition.newMovePosition(0,6),2);
        }

        return new Object[][] {
                {X_0_O_2, Player.X, Player.O, true},
                {X_2_5_O_7_8, Player.X, Player.O, true},
                {X_4_8_O_0_2_5_7, Player.X, Player.O, false},
                {X_4_8_O_1_3, Player.X, Player.O, true},

                {X_0, Player.X, Player.O, true},
                {X_1, Player.X, Player.O, true},
                {X_2, Player.X, Player.O, true},
                {X_3, Player.X, Player.O, true},
                {X_4, Player.X, Player.O, true},
                {X_5, Player.X, Player.O, true},
                {X_6, Player.X, Player.O, true},
                {X_7, Player.X, Player.O, true},
                {X_8, Player.X, Player.O, true},

        };
    }

}