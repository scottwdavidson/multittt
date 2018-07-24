package com.swd.ttt.entity.heuristic;

import com.swd.ttt.entity.Player;
import com.swd.ttt.entity.TicTacToeBoard;
import com.swd.ttt.entity.heuristic.BlockWinColumnHeuristic;
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
public class BlockWinColumnHeuristicTest {

    private static BlockWinColumnHeuristic BLOCK_WIN_COLUMN_HEURISTIC_SINGLETON =  new BlockWinColumnHeuristic();

    private static TicTacToeBoard EMPTY = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard O_0_3 = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard O_4_7 = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard O_2_8_X_5 = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard RIGHT2COLUMNSWIN = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard THREEWINS = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard TWOBLOCKEDWINS = TicTacToeBoard.emptyTicTacToeBoard();




    @BeforeClass
    public static void setUp() {
    	O_0_3.addMove(Player.O, 0, 1);
    	O_0_3.addMove(Player.O, 3, 2);
    	
    	O_4_7.addMove(Player.O, 4, 1);
    	O_4_7.addMove(Player.O, 7, 2);
    	
    	O_2_8_X_5.addMove(Player.O, 2, 1);
    	O_2_8_X_5.addMove(Player.O, 8, 1);
    	O_2_8_X_5.addMove(Player.X, 5, 1);

    	RIGHT2COLUMNSWIN.addMove(Player.O, 1, 1);
    	RIGHT2COLUMNSWIN.addMove(Player.O, 2, 1);
    	RIGHT2COLUMNSWIN.addMove(Player.O, 4, 1);
    	RIGHT2COLUMNSWIN.addMove(Player.O, 5, 1);
    	
    	THREEWINS.addMove(Player.O, 0, 1);
    	THREEWINS.addMove(Player.O, 6, 1);
    	THREEWINS.addMove(Player.O, 4, 1);
    	THREEWINS.addMove(Player.O, 7, 1);
    	THREEWINS.addMove(Player.O, 2, 1);
    	THREEWINS.addMove(Player.O, 5, 1);
    	
    	TWOBLOCKEDWINS.addMove(Player.O, 0, 1);
    	TWOBLOCKEDWINS.addMove(Player.O, 3, 1);
    	TWOBLOCKEDWINS.addMove(Player.O, 1, 1);
    	TWOBLOCKEDWINS.addMove(Player.O, 7, 1);
    	TWOBLOCKEDWINS.addMove(Player.X, 6, 1);
    	TWOBLOCKEDWINS.addMove(Player.X, 4, 1);


    	
    	
    }

    @Test
    @UseDataProvider("generateTestMovesData")
    public void testMoves(TicTacToeBoard tictactoeBoard, Player activePlayer, Player opponent, List<Integer> expectedMoves){

        Set<Integer> actualMoves = BLOCK_WIN_COLUMN_HEURISTIC_SINGLETON.moves(tictactoeBoard,activePlayer,opponent);
        Assert.assertEquals(expectedMoves.size(),actualMoves.size());
        Assert.assertTrue(actualMoves.containsAll(expectedMoves));
        Assert.assertTrue(expectedMoves.containsAll(actualMoves));
    }

    @DataProvider
    public static Object[][] generateTestMovesData() {

        return new Object[][] {
        		
                {EMPTY, Player.X, Player.O, Arrays.asList()},
                {O_0_3, Player.X, Player.O, Arrays.asList(6)},
                {O_4_7, Player.X, Player.O, Arrays.asList(1)},
                {O_2_8_X_5, Player.X, Player.O, Arrays.asList()},
                {RIGHT2COLUMNSWIN, Player.X, Player.O, Arrays.asList(7, 8)},
                {THREEWINS, Player.X, Player.O, Arrays.asList(1, 3, 8)},
                {TWOBLOCKEDWINS, Player.X, Player.O, Arrays.asList()}

        };
    }

}