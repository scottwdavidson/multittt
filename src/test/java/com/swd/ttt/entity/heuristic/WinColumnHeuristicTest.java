package com.swd.ttt.entity.heuristic;

import com.swd.ttt.entity.Player;
import com.swd.ttt.entity.TicTacToeBoard;
import com.swd.ttt.entity.heuristic.WinColumnHeuristic;
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
public class WinColumnHeuristicTest {

    private static WinColumnHeuristic WIN_COLUMN_HEURISTIC_SINGLETON =  new WinColumnHeuristic();

    private static TicTacToeBoard EMPTY = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_O_3 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_4_7 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard X_2_8_O_5 = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard RIGHT2COLUMNSWIN = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard THREEWINS = TicTacToeBoard.emptyTicTacToeBoard(0);
    private static TicTacToeBoard TWOBLOCKEDWINS = TicTacToeBoard.emptyTicTacToeBoard(0);




    @BeforeClass
    public static void setUp() {
    	X_O_3.addMove(Player.X, 0, 1);
    	X_O_3.addMove(Player.X, 3, 2);
    	
    	X_4_7.addMove(Player.X, 4, 1);
    	X_4_7.addMove(Player.X, 7, 2);
    	
    	X_2_8_O_5.addMove(Player.X, 2, 1);
    	X_2_8_O_5.addMove(Player.X, 8, 1);
    	X_2_8_O_5.addMove(Player.O, 5, 1);

    	RIGHT2COLUMNSWIN.addMove(Player.X, 1, 1);
    	RIGHT2COLUMNSWIN.addMove(Player.X, 2, 1);
    	RIGHT2COLUMNSWIN.addMove(Player.X, 4, 1);
    	RIGHT2COLUMNSWIN.addMove(Player.X, 5, 1);
    	
    	THREEWINS.addMove(Player.X, 0, 1);
    	THREEWINS.addMove(Player.X, 6, 1);
    	THREEWINS.addMove(Player.X, 4, 1);
    	THREEWINS.addMove(Player.X, 7, 1);
    	THREEWINS.addMove(Player.X, 2, 1);
    	THREEWINS.addMove(Player.X, 5, 1);
    	
    	TWOBLOCKEDWINS.addMove(Player.X, 0, 1);
    	TWOBLOCKEDWINS.addMove(Player.X, 3, 1);
    	TWOBLOCKEDWINS.addMove(Player.X, 1, 1);
    	TWOBLOCKEDWINS.addMove(Player.X, 7, 1);
    	TWOBLOCKEDWINS.addMove(Player.O, 6, 1);
    	TWOBLOCKEDWINS.addMove(Player.O, 4, 1);


    	
    	
    }

    @Test
    @UseDataProvider("generateTestMovesData")
    public void testMoves(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent, List<Integer> expectedMoves){

        Set<Integer> actualMoves = WIN_COLUMN_HEURISTIC_SINGLETON.moves(tictactoeBoard,activePlayer,opponent);
        Assert.assertEquals(expectedMoves.size(),actualMoves.size());
        Assert.assertTrue(actualMoves.containsAll(expectedMoves));
        Assert.assertTrue(expectedMoves.containsAll(actualMoves));
    }

    @DataProvider
    public static Object[][] generateTestMovesData() {

        return new Object[][] {
        		
                {EMPTY, Player.X, Player.O, Arrays.asList()},
                {X_O_3, Player.X, Player.O, Arrays.asList(6)},
                {X_4_7, Player.X, Player.O, Arrays.asList(1)},
                {X_2_8_O_5, Player.X, Player.O, Arrays.asList()},
                {RIGHT2COLUMNSWIN, Player.X, Player.O, Arrays.asList(7, 8)},
                {THREEWINS, Player.X, Player.O, Arrays.asList(1, 3, 8)},
                {TWOBLOCKEDWINS, Player.X, Player.O, Arrays.asList()}

        };
    }

}