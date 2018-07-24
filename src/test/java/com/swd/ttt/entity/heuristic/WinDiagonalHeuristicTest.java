package com.swd.ttt.entity.heuristic;

import com.swd.ttt.entity.Heuristic;
import com.swd.ttt.entity.Player;
import com.swd.ttt.entity.TicTacToeBoard;
import com.swd.ttt.entity.heuristic.WinDiagonalHeuristic;
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
public class WinDiagonalHeuristicTest {

    private static Heuristic WIN_DIAGONAL_HEURISTIC_SINGLETON =  new WinDiagonalHeuristic();

    private static TicTacToeBoard X_0_4 = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard X_0_8 = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard X_4_8 = TicTacToeBoard.emptyTicTacToeBoard();

    private static TicTacToeBoard X_2_4 = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard X_2_6 = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard X_4_6 = TicTacToeBoard.emptyTicTacToeBoard();

    private static TicTacToeBoard X_0_2_4 = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard X_0_2_6_8 = TicTacToeBoard.emptyTicTacToeBoard();

    private static TicTacToeBoard EMPTY = TicTacToeBoard.emptyTicTacToeBoard();


//    private static TicTacToeBoard X_1_2 = TicTacToeBoard.emptyTicTacToeBoard();
//    private static TicTacToeBoard X_3_5 = TicTacToeBoard.emptyTicTacToeBoard();
//    private static TicTacToeBoard X_3_5_O_4 = TicTacToeBoard.emptyTicTacToeBoard();
//    private static TicTacToeBoard X_7_8 = TicTacToeBoard.emptyTicTacToeBoard();
//    private static TicTacToeBoard X_4 = TicTacToeBoard.emptyTicTacToeBoard();
//    private static TicTacToeBoard BOTTOM2ROWWINS = TicTacToeBoard.emptyTicTacToeBoard();
//    private static TicTacToeBoard THREEWINS = TicTacToeBoard.emptyTicTacToeBoard();


    @BeforeClass
    public static void setUp() {

    	X_0_4.addMove(Player.X, 0,10);
    	X_0_4.addMove(Player.X, 4,10);

        X_0_8.addMove(Player.X, 0,10);
        X_0_8.addMove(Player.X, 8,10);

        X_4_8.addMove(Player.X, 4,10);
        X_4_8.addMove(Player.X, 8,10);

        X_2_4.addMove(Player.X, 2,10);
        X_2_4.addMove(Player.X, 4,10);

        X_2_6.addMove(Player.X, 2,10);
        X_2_6.addMove(Player.X, 6,10);

        X_4_6.addMove(Player.X, 4,10);
        X_4_6.addMove(Player.X, 6,10);

        X_0_2_4.addMove(Player.X, 0,10);
        X_0_2_4.addMove(Player.X, 2,10);
        X_0_2_4.addMove(Player.X, 4,10);

        X_0_2_6_8.addMove(Player.X, 0,10);
        X_0_2_6_8.addMove(Player.X, 2,10);
        X_0_2_6_8.addMove(Player.X, 6,10);
        X_0_2_6_8.addMove(Player.X, 8,10);

//    	X_3_5.addMove(Player.X, 3,1);
//    	X_3_5.addMove(Player.X, 5,1);
//    	X_3_5.addMove(Player.O, 2,1);
//    	X_3_5.addMove(Player.O, 7,1);
//
//    	X_3_5_O_4	= TicTacToeBoard.prototypeTicTacToeBoard(X_3_5);
//    	X_3_5_O_4.addMove(Player.O, 4,1);
//
//    	X_7_8.addMove(Player.X, 7,1);
//    	X_7_8.addMove(Player.X, 8,1);
//
//    	X_4.addMove(Player.X, 4,1);
//    	X_4.addMove(Player.O, 2,1);
//    	X_4.addMove(Player.O, 8,1);
//
//    	BOTTOM2ROWWINS.addMove(Player.X, 3,1);
//    	BOTTOM2ROWWINS.addMove(Player.X, 4,1);
//    	BOTTOM2ROWWINS.addMove(Player.X, 7,1);
//    	BOTTOM2ROWWINS.addMove(Player.X, 8,1);
//
//    	THREEWINS.addMove(Player.X, 0,1);
//    	THREEWINS.addMove(Player.X, 2,1);
//    	THREEWINS.addMove(Player.X, 4,1);
//    	THREEWINS.addMove(Player.X, 5,1);
//    	THREEWINS.addMove(Player.X, 6,1);
//    	THREEWINS.addMove(Player.X, 7,1);
    }

    @Test
    @UseDataProvider("generateTestMovesData")
    public void testMoves(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent, List<Integer> expectedMoves){

        Set<Integer> actualMoves = WIN_DIAGONAL_HEURISTIC_SINGLETON.moves(tictactoeBoard,activePlayer,opponent);
        Assert.assertEquals(expectedMoves.size(),actualMoves.size());
        Assert.assertTrue(actualMoves.containsAll(expectedMoves));
        Assert.assertTrue(expectedMoves.containsAll(actualMoves));
    }

    @DataProvider
    public static Object[][] generateTestMovesData() {

        return new Object[][] {

                {X_0_4, Player.X, Player.O, Arrays.asList(8)},
                {X_0_8, Player.X, Player.O, Arrays.asList(4)},
                {X_4_8, Player.X, Player.O, Arrays.asList(0)},

                {X_2_4, Player.X, Player.O, Arrays.asList(6)},
                {X_2_6, Player.X, Player.O, Arrays.asList(4)},
                {X_4_6, Player.X, Player.O, Arrays.asList(2)},

                {X_0_2_4, Player.X, Player.O, Arrays.asList(6,8)},
                {X_0_2_6_8, Player.X, Player.O, Arrays.asList(4)},

                {EMPTY, Player.X, Player.O, Arrays.asList()},

//                {X_3_5, Player.X, Player.O, Arrays.asList(4)},
//                {X_3_5_O_4, Player.X, Player.O, Arrays.asList()},
//                {X_7_8, Player.X, Player.O, Arrays.asList(6)},
//                {X_4, Player.X, Player.O, Arrays.asList()},
//                {BOTTOM2ROWWINS, Player.X, Player.O, Arrays.asList(5, 6)},
//                {THREEWINS, Player.X, Player.O, Arrays.asList(1, 3, 8)}
        };
    }

}