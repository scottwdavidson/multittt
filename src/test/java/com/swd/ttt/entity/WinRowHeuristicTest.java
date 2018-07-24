package com.swd.ttt.entity;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@RunWith(DataProviderRunner.class)
public class WinRowHeuristicTest {

    private static WinRowHeuristic WIN_ROW_HEURISTIC_SINGLETON =  new WinRowHeuristic();

    private static TicTacToeBoard X_0 = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard X_2 = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard X_4 = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard X_6 = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard X_8 = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard X_0_1 = TicTacToeBoard.emptyTicTacToeBoard();

    @BeforeClass
    public static void setUp() {

        {
            X_0.addMove(Player.X, 0, 10);
            X_2.addMove(Player.X, 2, 10);
            X_4.addMove(Player.X, 4, 10);
            X_6.addMove(Player.X, 6, 10);
            X_8.addMove(Player.X, 8, 10);
        }
        {
            X_0_1.addMove(Player.X, 0, 10);
            X_0_1.addMove(Player.X, 1, 10);
        }
    }

    @Test
    @UseDataProvider("generateTestMovesData")
    public void testMoves(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent, List<Integer> expectedMoves){

        Set<Integer> actualMoves = WIN_ROW_HEURISTIC_SINGLETON.moves(tictactoeBoard,activePlayer,opponent);
        Assert.assertEquals(expectedMoves.size(),actualMoves.size());
        Assert.assertTrue(actualMoves.containsAll(expectedMoves));
        Assert.assertTrue(expectedMoves.containsAll(actualMoves));
    }

    @DataProvider
    public static Object[][] generateTestMovesData() {

        return new Object[][] {
        		
                {X_0_1, Player.X, Player.O, Arrays.asList(2)}

        };
    }

}