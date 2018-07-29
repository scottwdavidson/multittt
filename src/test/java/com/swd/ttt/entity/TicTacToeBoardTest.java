package com.swd.ttt.entity;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class TicTacToeBoardTest {

    private static TicTacToeBoard X_0_1 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_2_5_O_7_8 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_4_8_O_0_3 = TicTacToeBoard.emptyTicTacToeBoard(0);

    private static TicTacToeBoard X_0_1_2 = TicTacToeBoard.emptyTicTacToeBoard(3);
    private static TicTacToeBoard O_0_4_8 = TicTacToeBoard.emptyTicTacToeBoard(4);

    @Test
    @UseDataProvider("generateRepresentationData")
    public void testGenerateRepresentation(TicTacToeBoard tictactoeBoard, Short expectedBoardXPresentation, Short expectedBoardOPresentation){

        Assert.assertEquals("Checking X Representation", expectedBoardXPresentation, tictactoeBoard.generatePlayerRepresentation(Player.X));
        Assert.assertEquals("Checking O Representation", expectedBoardOPresentation, tictactoeBoard.generatePlayerRepresentation(Player.O));

    }

    @Test
    @UseDataProvider("generateUpdateGameStateData")
    public void testGenerateUpdatedGameState(TicTacToeBoard tictactoeBoard, GameState expectedGameState, Player expectedWinningPlayer){

        Assert.assertEquals("Checking Game State", expectedGameState, tictactoeBoard.getGameState());
        Assert.assertEquals("Checking Winning Player", expectedWinningPlayer, tictactoeBoard.getWinningPlayer());

    }


    @DataProvider
    public static Object[][] generateRepresentationData() {

        // Note: all of this initialization is done here b/c if it's done in @BeforeClass the updated objects
        // are not used here ( most likely due to static object initialization order )
        {
            X_0_1 = TicTacToeBoard.applyMove(X_0_1, Player.X, MovePosition.newMovePosition(0,0),0);
            X_0_1 = TicTacToeBoard.applyMove(X_0_1, Player.X, MovePosition.newMovePosition(0,1),1);
        }
        {
            X_2_5_O_7_8 = TicTacToeBoard.applyMove(X_2_5_O_7_8, Player.X, MovePosition.newMovePosition(1,2),3);
            X_2_5_O_7_8 = TicTacToeBoard.applyMove(X_2_5_O_7_8, Player.X, MovePosition.newMovePosition(1,5),4);
            X_2_5_O_7_8 = TicTacToeBoard.applyMove(X_2_5_O_7_8, Player.O, MovePosition.newMovePosition(1,7),5);
            X_2_5_O_7_8 = TicTacToeBoard.applyMove(X_2_5_O_7_8, Player.O, MovePosition.newMovePosition(1,8),6);

        }
        {
            X_4_8_O_0_3 = TicTacToeBoard.applyMove(X_4_8_O_0_3, Player.X, MovePosition.newMovePosition(1,4),7);
            X_4_8_O_0_3 = TicTacToeBoard.applyMove(X_4_8_O_0_3, Player.X, MovePosition.newMovePosition(1,8),8);
            X_4_8_O_0_3 = TicTacToeBoard.applyMove(X_4_8_O_0_3, Player.O, MovePosition.newMovePosition(1,0),9);
            X_4_8_O_0_3 = TicTacToeBoard.applyMove(X_4_8_O_0_3, Player.O, MovePosition.newMovePosition(1,3),10);

        }

        return new Object[][] {
                {X_0_1, (short) 0b000000011, (short) 0b000000000},
                {X_2_5_O_7_8, (short) 0b000100100, (short) 0b110000000},
                {X_4_8_O_0_3, (short) 0b100010000, (short) 0b000001001}
        };
    }

    @DataProvider
    public static Object[][] generateUpdateGameStateData() {

        // Note: all of this initialization is done here b/c if it's done in @BeforeClass the updated objects
        // are not used here ( most likely due to static object initialization order )
        {
            X_0_1_2 = TicTacToeBoard.applyMove(X_0_1_2, Player.X, MovePosition.newMovePosition(3,0),0);
            X_0_1_2 = TicTacToeBoard.applyMove(X_0_1_2, Player.X, MovePosition.newMovePosition(3,1),1);
            X_0_1_2 = TicTacToeBoard.applyMove(X_0_1_2, Player.X, MovePosition.newMovePosition(3,2),2);
            X_0_1_2 = TicTacToeBoard.updateGameState(X_0_1_2,GameState.Closed, Player.X);
        }

        {
            O_0_4_8 = TicTacToeBoard.applyMove(O_0_4_8, Player.X, MovePosition.newMovePosition(4,0),0);
            O_0_4_8 = TicTacToeBoard.applyMove(O_0_4_8, Player.X, MovePosition.newMovePosition(4,4),1);
            O_0_4_8 = TicTacToeBoard.applyMove(O_0_4_8, Player.X, MovePosition.newMovePosition(4,8),2);
            O_0_4_8 = TicTacToeBoard.updateGameState(O_0_4_8,GameState.Closed, Player.O);
        }

        return new Object[][] {
                {X_0_1_2, GameState.Closed, Player.X},
                {O_0_4_8, GameState.Closed, Player.O}
        };
    }

}