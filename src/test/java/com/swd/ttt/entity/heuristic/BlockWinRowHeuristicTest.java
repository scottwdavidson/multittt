package com.swd.ttt.entity.heuristic;

import com.swd.ttt.entity.Player;
import com.swd.ttt.entity.TicTacToeBoard;
import com.swd.ttt.entity.heuristic.BlockWinRowHeuristic;
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
public class BlockWinRowHeuristicTest {

    private static BlockWinRowHeuristic BLOCK_WIN_ROW_HEURISTIC_SINGLETON =  new BlockWinRowHeuristic();

    private static TicTacToeBoard X_0_1 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_0_2 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_1_2 = TicTacToeBoard.emptyTicTacToeBoard(0);

    private static TicTacToeBoard X_3_4 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_3_5 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_4_5 = TicTacToeBoard.emptyTicTacToeBoard(0);

    private static TicTacToeBoard X_6_7 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_6_8 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_7_8 = TicTacToeBoard.emptyTicTacToeBoard(0);

    private static TicTacToeBoard X_1_2_6_7 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_0_2_7_8 = TicTacToeBoard.emptyTicTacToeBoard(0);


    @BeforeClass
    public static void setUp() {

        X_0_1.addMove(Player.O, 0,10);
        X_0_1.addMove(Player.O, 1,10);

        X_0_2.addMove(Player.O, 0,10);
        X_0_2.addMove(Player.O, 2,10);

        X_1_2.addMove(Player.O, 1,10);
    	X_1_2.addMove(Player.O, 2,10);

        X_3_4.addMove(Player.O, 3,10);
        X_3_4.addMove(Player.O, 4,10);

        X_3_5.addMove(Player.O, 3,10);
        X_3_5.addMove(Player.O, 5,10);

        X_4_5.addMove(Player.O, 4,10);
        X_4_5.addMove(Player.O, 5,10);

        X_6_7.addMove(Player.O, 6,10);
        X_6_7.addMove(Player.O, 7,10);

        X_6_8.addMove(Player.O, 6,10);
        X_6_8.addMove(Player.O, 8,10);

        X_7_8.addMove(Player.O, 7,10);
        X_7_8.addMove(Player.O, 8,10);

        X_1_2_6_7.addMove(Player.O, 1,10);
        X_1_2_6_7.addMove(Player.O, 2,10);
        X_1_2_6_7.addMove(Player.O, 6,10);
        X_1_2_6_7.addMove(Player.O, 7,10);


        X_0_2_7_8.addMove(Player.O, 0,10);
        X_0_2_7_8.addMove(Player.O, 2,10);
        X_0_2_7_8.addMove(Player.O, 7,10);
        X_0_2_7_8.addMove(Player.O, 8,10);

    }

    @Test
    @UseDataProvider("generateTestMovesData")
    public void testMoves(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent, List<Integer> expectedMoves){

        Set<Integer> actualMoves = BLOCK_WIN_ROW_HEURISTIC_SINGLETON.moves(tictactoeBoard,activePlayer,opponent);
        Assert.assertEquals(expectedMoves.size(),actualMoves.size());
        Assert.assertTrue(actualMoves.containsAll(expectedMoves));
        Assert.assertTrue(expectedMoves.containsAll(actualMoves));
    }

    @DataProvider
    public static Object[][] generateTestMovesData() {

        return new Object[][] {

                {X_0_1, Player.X, Player.O, Arrays.asList(2)},
                {X_0_2, Player.X, Player.O, Arrays.asList(1)},
                {X_1_2, Player.X, Player.O, Arrays.asList(0)},
                {X_3_4, Player.X, Player.O, Arrays.asList(5)},
                {X_3_5, Player.X, Player.O, Arrays.asList(4)},
                {X_4_5, Player.X, Player.O, Arrays.asList(3)},
                {X_6_7, Player.X, Player.O, Arrays.asList(8)},
                {X_6_8, Player.X, Player.O, Arrays.asList(7)},
                {X_7_8, Player.X, Player.O, Arrays.asList(6)},
                {X_1_2_6_7, Player.X, Player.O, Arrays.asList(0,8)},
                {X_0_2_7_8, Player.X, Player.O, Arrays.asList(1,6)},


//                {EMPTY, Player.X, Player.O, Arrays.asList()},
//                {X_3_5, Player.X, Player.O, Arrays.asList(4)},
//                {X_3_5_O_4, Player.X, Player.O, Arrays.asList()},
//                {X_7_8, Player.X, Player.O, Arrays.asList(6)},
//                {X_4, Player.X, Player.O, Arrays.asList()},
//                {BOTTOM2ROWWINS, Player.X, Player.O, Arrays.asList(5, 6)},
//                {THREEWINS, Player.X, Player.O, Arrays.asList(1, 3, 8)}
        };
    }

}