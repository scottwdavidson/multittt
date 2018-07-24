package com.swd.ttt.entity;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.SortedMap;

@RunWith(DataProviderRunner.class)
public class AutomatonTest {

    private static TicTacToeBoard X_TOP_ROW_FIRST_TWO = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard X_LAST_COLUMN_FIRST_TWO_O_BLOCK = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard O_FIRST_COLUMN_FIRST_TWO_BLOCK_X_DIAGONAL = TicTacToeBoard.emptyTicTacToeBoard();

    @BeforeClass
    public static void setUp() {

        {
            X_TOP_ROW_FIRST_TWO.addMove(Player.X, 0, 10);
            X_TOP_ROW_FIRST_TWO.addMove(Player.X, 1, 10);
        }
        {
            X_LAST_COLUMN_FIRST_TWO_O_BLOCK.addMove(Player.X, 2, 10);
            X_LAST_COLUMN_FIRST_TWO_O_BLOCK.addMove(Player.X, 5, 10);
            X_LAST_COLUMN_FIRST_TWO_O_BLOCK.addMove(Player.O, 7, 10);
            X_LAST_COLUMN_FIRST_TWO_O_BLOCK.addMove(Player.O, 8, 10);
        }
        {
            O_FIRST_COLUMN_FIRST_TWO_BLOCK_X_DIAGONAL.addMove(Player.X, 4, 10);
            O_FIRST_COLUMN_FIRST_TWO_BLOCK_X_DIAGONAL.addMove(Player.X, 8, 10);
            O_FIRST_COLUMN_FIRST_TWO_BLOCK_X_DIAGONAL.addMove(Player.O, 0, 10);
            O_FIRST_COLUMN_FIRST_TWO_BLOCK_X_DIAGONAL.addMove(Player.O, 3, 10);
        }
    }

    @Test
    @UseDataProvider("generateRepresentationData")
    public void testEvaluateSecondaryOpponentMoves(Board board, int activeTicTacToeBoard,
                                                   List<Integer> moves, SortedMap<Integer, Automaton.EvaluatedMove> expectedEvaluation){


    }

    @DataProvider
    public static Object[][] generateRepresentationData() {

        return new Object[][] {
                {X_TOP_ROW_FIRST_TWO, (short) 0b000000011, (short) 0b000000000},
                {X_LAST_COLUMN_FIRST_TWO_O_BLOCK, (short) 0b000100100, (short) 0b110000000},
                {O_FIRST_COLUMN_FIRST_TWO_BLOCK_X_DIAGONAL, (short) 0b100010000, (short) 0b000001001}
        };
    }

}