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
public class SingleDiagonalHeuristicTest {

    private static SingleDiagonalHeuristic SINGLE_DIAGONAL_HEURISTIC_SINGLETON =  SingleDiagonalHeuristic.newSingleDiagonalHeuristic();

    private static TicTacToeBoard X_0 = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard X_2 = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard X_4 = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard X_6 = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard X_8 = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard X_0_2 = TicTacToeBoard.emptyTicTacToeBoard();

    @BeforeClass
    public static void setUp() {

        {
            X_0.addMove(Player.X, 0);
            X_2.addMove(Player.X, 2);
            X_4.addMove(Player.X, 4);
            X_6.addMove(Player.X, 6);
            X_8.addMove(Player.X, 8);
        }
        {
            X_0_2.addMove(Player.X, 0);
            X_0_2.addMove(Player.X, 2);
        }
    }

    @Test
    @UseDataProvider("generateTestMovesData")
    public void testMoves(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent, List<Integer> expectedMoves){

        Set<Integer> actualMoves = SINGLE_DIAGONAL_HEURISTIC_SINGLETON.moves(tictactoeBoard,activePlayer,opponent);
        Assert.assertEquals(expectedMoves.size(),actualMoves.size());
        Assert.assertTrue(actualMoves.containsAll(expectedMoves));
        Assert.assertTrue(expectedMoves.containsAll(actualMoves));
    }

    @DataProvider
    public static Object[][] generateTestMovesData() {

        return new Object[][] {
                {X_0, Player.X, Player.O, Arrays.asList(0b000010000 , 0b100000000)} ,
                {X_2, Player.X, Player.O, Arrays.asList(0b001000000 , 0b000010000)} ,
                {X_4, Player.X, Player.O, Arrays.asList(0b000000001 , 0b100000000 , 0b000000100 , 0b001000000)} ,
                {X_6, Player.X, Player.O, Arrays.asList(0b000000100 , 0b000010000)} ,
                {X_8, Player.X, Player.O, Arrays.asList(0b000000001 , 0b000010000)} ,
                {X_0_2, Player.X, Player.O, Arrays.asList(0b000010000 , 0b001000000 , 0b100000000)}

        };
    }

}