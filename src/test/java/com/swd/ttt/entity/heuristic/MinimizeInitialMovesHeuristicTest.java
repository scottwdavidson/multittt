package com.swd.ttt.entity.heuristic;

import com.swd.ttt.entity.play.MovePosition;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(DataProviderRunner.class)
public class MinimizeInitialMovesHeuristicTest {

    private static MinimizeInitialMovesHeuristic MINIMIZE_INITIAL_MOVES_HEURISTIC_SINGLETON = new MinimizeInitialMovesHeuristic();
    private final static Set<Integer> CORNERS_AND_CENTER = new HashSet<>(Arrays.asList(0, 2, 4, 6, 8));

    @Test
    @UseDataProvider("testMovesData")
    public void testMoves(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent, Set<Integer> expectedMoves) {

        Set<Integer> actualMoves = MINIMIZE_INITIAL_MOVES_HEURISTIC_SINGLETON.moves(tictactoeBoard, activePlayer, opponent);
        Assert.assertEquals(expectedMoves.size(), actualMoves.size());
        Assert.assertTrue(actualMoves.containsAll(expectedMoves));
        Assert.assertTrue(expectedMoves.containsAll(actualMoves));
    }

    @DataProvider
    public static Object[][] testMovesData() {

        TicTacToeBoard EMPTY = TicTacToeBoard.emptyTicTacToeBoard(0);

        TicTacToeBoard X_0 = TicTacToeBoard.emptyTicTacToeBoard(0);
        X_0 = TicTacToeBoard.applyMove(X_0, Player.X, MovePosition.newMovePosition(0,0), 10);

        TicTacToeBoard X_2_6 = TicTacToeBoard.emptyTicTacToeBoard(0);
        X_2_6 = TicTacToeBoard.applyMove(X_2_6, Player.X, MovePosition.newMovePosition(0,2), 10);
        X_2_6 = TicTacToeBoard.applyMove(X_2_6, Player.X, MovePosition.newMovePosition(0,6), 12);

        TicTacToeBoard O_0 = TicTacToeBoard.emptyTicTacToeBoard(0);
        O_0 = TicTacToeBoard.applyMove(O_0, Player.O, MovePosition.newMovePosition(0,8), 14);


        return new Object[][]{
                {EMPTY, Player.X, Player.O, CORNERS_AND_CENTER},
                {X_0, Player.X, Player.O, new HashSet<>(Arrays.asList(2,4,6,8))},
                {X_2_6, Player.X, Player.O, new HashSet<>()},
                {O_0, Player.O, Player.X, new HashSet<>(Arrays.asList(0,2,4,6))},

        };
    }

}