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

import java.util.*;

@RunWith(DataProviderRunner.class)
public class SingleDiagonalHeuristicTest {


    private static SingleDiagonalHeuristic SINGLE_DIAGONAL_HEURISTIC_SINGLETON =  SingleDiagonalHeuristic.newSingleDiagonalHeuristic();

    private static TicTacToeBoard X_0 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_2 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_4 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_6 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_8 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_0_2 = TicTacToeBoard.emptyTicTacToeBoard(0);

    private static TicTacToeBoard X_0_O_4 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_0_O_8 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_0_O_4_O_8 = TicTacToeBoard.emptyTicTacToeBoard(0);



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
            X_0_2.addMove(Player.X, 0, 10);
            X_0_2.addMove(Player.X, 2, 10);
        }
        {
            X_0_O_4.addMove(Player.X, 0, 10);
            X_0_O_4.addMove(Player.O, 4, 10);

            X_0_O_8.addMove(Player.X, 0, 10);
            X_0_O_8.addMove(Player.O, 8, 10);

            X_0_O_4_O_8.addMove(Player.X, 0, 10);
            X_0_O_4_O_8.addMove(Player.O, 4, 10);
            X_0_O_4_O_8.addMove(Player.O, 8, 10);

        }
    }

    @Test
    @UseDataProvider("generateTestMovesData")
    public void testMoves(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent, Set<Integer> expectedMoves){

        Set<Integer> actualMoves = SINGLE_DIAGONAL_HEURISTIC_SINGLETON.moves(tictactoeBoard,activePlayer,opponent);
        Assert.assertEquals(expectedMoves.size(),actualMoves.size());
        Assert.assertTrue(actualMoves.containsAll(expectedMoves));
        Assert.assertTrue(expectedMoves.containsAll(actualMoves));
    }

    @DataProvider
    public static Object[][] generateTestMovesData() {

        System.out.println("Generating test moves data .... " + X_0_O_4);
        return new Object[][] {

                {X_0, Player.X, Player.O, new HashSet<>(Arrays.asList(4 , 8))} ,
                {X_2, Player.X, Player.O, new HashSet<>(Arrays.asList(4 , 6))} ,
                {X_4, Player.X, Player.O, new HashSet<>(Arrays.asList(0 , 2 , 6 , 8))} ,
                {X_6, Player.X, Player.O, new HashSet<>(Arrays.asList(2 , 4))} ,
                {X_8, Player.X, Player.O, new HashSet<>(Arrays.asList(0 , 4))} ,
                {X_0_2, Player.X, Player.O, new HashSet<>(Arrays.asList(4 , 6 , 8))},

                {X_0_O_4, Player.X, Player.O, new HashSet<>(Arrays.asList())},
                {X_0_O_8, Player.X, Player.O, new HashSet<>(Arrays.asList())},
                {X_0_O_4_O_8, Player.X, Player.O, new HashSet<>(Arrays.asList())}

        };
    }

}