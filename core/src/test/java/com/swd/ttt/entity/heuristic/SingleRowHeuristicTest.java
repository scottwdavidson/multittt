package com.swd.ttt.entity.heuristic;

import com.swd.ttt.entity.play.Player;
import com.swd.ttt.entity.play.TicTacToeBoard;
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
public class SingleRowHeuristicTest {

    private static SingleRowHeuristic SINGLE_ROW_HEURISTIC_SINGLETON =  SingleRowHeuristic.newSingleRowHeuristic();

    private static TicTacToeBoard X_0 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_1 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_2 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_3 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_4 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_5 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_6 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_7 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_8 = TicTacToeBoard.emptyTicTacToeBoard(0);

    @BeforeClass
    public static void setUp() {

        {
            X_0.addMove(Player.X, 0, 10);
            X_1.addMove(Player.X, 1, 10);
            X_2.addMove(Player.X, 2, 10);
            X_3.addMove(Player.X, 3, 10);
            X_4.addMove(Player.X, 4, 10);
            X_5.addMove(Player.X, 5, 10);
            X_6.addMove(Player.X, 6, 10);
            X_7.addMove(Player.X, 7, 10);
            X_8.addMove(Player.X, 8, 10);
        }
    }

    @Test
    @UseDataProvider("generateTestMovesData")
    public void testMoves(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent, List<Integer> expectedMoves){

        Set<Integer> actualMoves = SINGLE_ROW_HEURISTIC_SINGLETON.moves(tictactoeBoard,activePlayer,opponent);
        Assert.assertTrue(actualMoves.containsAll(expectedMoves));
        Assert.assertTrue(expectedMoves.containsAll(actualMoves));
    }

    @DataProvider
    public static Object[][] generateTestMovesData() {

        return new Object[][] {
                {X_0, Player.X, Player.O, Arrays.asList(1 , 2)} ,
                {X_1, Player.X, Player.O, Arrays.asList(0 , 2)} ,
                {X_2, Player.X, Player.O, Arrays.asList(0 , 1)} ,

                {X_3, Player.X, Player.O, Arrays.asList(4 , 5)} ,
                {X_4, Player.X, Player.O, Arrays.asList(3 , 5)} ,
                {X_5, Player.X, Player.O, Arrays.asList(3 , 4)} ,

                {X_6, Player.X, Player.O, Arrays.asList(7 , 8)} ,
                {X_7, Player.X, Player.O, Arrays.asList(6 , 8)} ,
                {X_8, Player.X, Player.O, Arrays.asList(6 , 7)}

        };
    }

}