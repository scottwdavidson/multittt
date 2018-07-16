package com.swd.ttt.entity;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class TicTacToeBoardTest {

    private static TicTacToeBoard X_TOP_ROW_FIRST_TWO = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard X_LAST_COLUMN_FIRST_TWO_O_BLOCK = TicTacToeBoard.emptyTicTacToeBoard();
    private static TicTacToeBoard O_FIRST_COLUMN_FIRST_TWO_BLOCK_X_DIAGONAL = TicTacToeBoard.emptyTicTacToeBoard();

    @Before
    public void setUp() {

        {
            X_TOP_ROW_FIRST_TWO.addMove(Player.X, 0);
            X_TOP_ROW_FIRST_TWO.addMove(Player.X, 1);
        }
        {
            X_LAST_COLUMN_FIRST_TWO_O_BLOCK.addMove(Player.X, 2);
            X_LAST_COLUMN_FIRST_TWO_O_BLOCK.addMove(Player.X, 5);
            X_LAST_COLUMN_FIRST_TWO_O_BLOCK.addMove(Player.O, 7);
            X_LAST_COLUMN_FIRST_TWO_O_BLOCK.addMove(Player.O, 8);
        }
        {
            O_FIRST_COLUMN_FIRST_TWO_BLOCK_X_DIAGONAL.addMove(Player.X, 4);
            O_FIRST_COLUMN_FIRST_TWO_BLOCK_X_DIAGONAL.addMove(Player.X, 8);
            O_FIRST_COLUMN_FIRST_TWO_BLOCK_X_DIAGONAL.addMove(Player.O, 0);
            O_FIRST_COLUMN_FIRST_TWO_BLOCK_X_DIAGONAL.addMove(Player.O, 3);
        }
    }

    @Test
    @UseDataProvider("generateRepresentationData")
    public void testGenerateRepresentation(TicTacToeBoard tictactoeBoard, Short expectedBoardXPresentation, Short expectedBoardOPresentation){

        Assert.assertEquals("Checking X Representation", tictactoeBoard.generateXRepresentation(), expectedBoardXPresentation);
        Assert.assertEquals("Checking Y Representation", tictactoeBoard.generateORepresentation(), expectedBoardOPresentation);

    }

    @DataProvider
    public static Object[][] generateRepresentationData() {

        return new Object[][] {
//                {X_TOP_ROW_FIRST_TWO, (short) 0b000000011, (short) 0b000000000},
//                {X_LAST_COLUMN_FIRST_TWO_O_BLOCK, 0b000100100, 0b110000000},
                {O_FIRST_COLUMN_FIRST_TWO_BLOCK_X_DIAGONAL, (short) 0b100010000, (short) 0b000001001}
        };
    }

}