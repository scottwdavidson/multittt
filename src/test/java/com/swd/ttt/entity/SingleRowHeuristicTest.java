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
public class SingleRowHeuristicTest {

    private static SingleRowHeuristic SINGLE_ROW_HEURISTIC_SINGLETON =  SingleRowHeuristic.newSingleRowHeuristic();

    private static TicTacToeBoard X_0 = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard X_1 = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard X_2 = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard X_3 = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard X_4 = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard X_5 = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard X_6 = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard X_7 = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard X_8 = TicTacToeBoard.emptyTicTacToeBoard();

    @BeforeClass
    public static void setUp() {

        {
            X_0.addMove(Player.X, 0);
            X_1.addMove(Player.X, 1);
            X_2.addMove(Player.X, 2);
            X_3.addMove(Player.X, 3);
            X_4.addMove(Player.X, 4);
            X_5.addMove(Player.X, 5);
            X_6.addMove(Player.X, 6);
            X_7.addMove(Player.X, 7);
            X_8.addMove(Player.X, 8);
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
                {X_0, Player.X, Player.O, Arrays.asList(0b000000010 , 0b000000100)} ,
                {X_1, Player.X, Player.O, Arrays.asList(0b000000001 , 0b000000100)} ,
                {X_2, Player.X, Player.O, Arrays.asList(0b000000001 , 0b000000010)} ,

                {X_3, Player.X, Player.O, Arrays.asList(0b000010000 , 0b000100000)} ,
                {X_4, Player.X, Player.O, Arrays.asList(0b000001000 , 0b000100000)} ,
                {X_5, Player.X, Player.O, Arrays.asList(0b000001000 , 0b000010000)} ,

                {X_6, Player.X, Player.O, Arrays.asList(0b010000000 , 0b100000000)} ,
                {X_7, Player.X, Player.O, Arrays.asList(0b001000000 , 0b100000000)} ,
                {X_8, Player.X, Player.O, Arrays.asList(0b010000000 , 0b001000000)}

        };
    }

}