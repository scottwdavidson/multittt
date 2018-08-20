package com.swd.ttt.tui;

import com.swd.ttt.entity.play.Player;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class PresentationTest {

    private final static String TTT_BOARD_PLAY_ROW_X_0_0 =      "  X |   |      ''      |   |      ''      |   |   ";
    private final static String TTT_BOARD_PLAY_ROW_X_0_1 =      "    | X |      ''      |   |      ''      |   |   ";
    private final static String TTT_BOARD_PLAY_ROW_X_0_2 =      "    |   | X    ''      |   |      ''      |   |   ";

    private final static String TTT_BOARD_PLAY_ROW_O_0_0 =      "  O |   |      ''      |   |      ''      |   |   ";
    private final static String TTT_BOARD_PLAY_ROW_O_0_1 =      "    | O |      ''      |   |      ''      |   |   ";
    private final static String TTT_BOARD_PLAY_ROW_O_0_2 =      "    |   | O    ''      |   |      ''      |   |   ";

    private final static String TTT_BOARD_PLAY_ROW_X_1_0 =      "    |   |      ''    X |   |      ''      |   |   ";
    private final static String TTT_BOARD_PLAY_ROW_X_1_1 =      "    |   |      ''      | X |      ''      |   |   ";
    private final static String TTT_BOARD_PLAY_ROW_X_1_2 =      "    |   |      ''      |   | X    ''      |   |   ";

    private final static String TTT_BOARD_PLAY_ROW_X_2_0 =      "    |   |      ''      |   |      ''    X |   |   ";
    private final static String TTT_BOARD_PLAY_ROW_X_2_1 =      "    |   |      ''      |   |      ''      | X |   ";
    private final static String TTT_BOARD_PLAY_ROW_X_2_2 =      "    |   |      ''      |   |      ''      |   | X ";


    @Test
    @UseDataProvider("testCalculatePlayPositionData")
    public void testCalculatePlayPosition(int relativeBoard, int relativePosition, int expectedPlayPosition){
        Assert.assertEquals(expectedPlayPosition, Presentation.calculatePlayPosition(relativeBoard, relativePosition));
    }

    @DataProvider
    public static Object[][] testCalculatePlayPositionData() {

        return new Object[][] {
                {0,0,2},
                {0,1,6},
                {0,2,10},
                {1,0,21},
                {1,1,25},
                {1,2,29},
                {2,0,40},
                {2,1,44},
                {2,2,48}
        };
    }

    @Test
    @UseDataProvider("testInsertPlayData")
    public void testInserPlay(String template, Player player, int relativeBoard, int relativePosition,  String expectedRow){
        Assert.assertEquals(expectedRow, Presentation.insertPlay(template, player, relativeBoard, relativePosition));
    }

    @DataProvider
    public static Object[][] testInsertPlayData() {

        return new Object[][] {
                {Presentation.TTT_BOARD_PLAY_ROW_TEMPLATE, Player.X, 0,0, TTT_BOARD_PLAY_ROW_X_0_0},
                {Presentation.TTT_BOARD_PLAY_ROW_TEMPLATE, Player.X, 0,1, TTT_BOARD_PLAY_ROW_X_0_1},
                {Presentation.TTT_BOARD_PLAY_ROW_TEMPLATE, Player.X, 0,2, TTT_BOARD_PLAY_ROW_X_0_2},
                {Presentation.TTT_BOARD_PLAY_ROW_TEMPLATE, Player.O, 0,0, TTT_BOARD_PLAY_ROW_O_0_0},
                {Presentation.TTT_BOARD_PLAY_ROW_TEMPLATE, Player.O, 0,1, TTT_BOARD_PLAY_ROW_O_0_1},
                {Presentation.TTT_BOARD_PLAY_ROW_TEMPLATE, Player.O, 0,2, TTT_BOARD_PLAY_ROW_O_0_2},
                {Presentation.TTT_BOARD_PLAY_ROW_TEMPLATE, Player.X, 1,0, TTT_BOARD_PLAY_ROW_X_1_0},
                {Presentation.TTT_BOARD_PLAY_ROW_TEMPLATE, Player.X, 1,1, TTT_BOARD_PLAY_ROW_X_1_1},
                {Presentation.TTT_BOARD_PLAY_ROW_TEMPLATE, Player.X, 1,2, TTT_BOARD_PLAY_ROW_X_1_2},
                {Presentation.TTT_BOARD_PLAY_ROW_TEMPLATE, Player.X, 2,0, TTT_BOARD_PLAY_ROW_X_2_0},
                {Presentation.TTT_BOARD_PLAY_ROW_TEMPLATE, Player.X, 2,1, TTT_BOARD_PLAY_ROW_X_2_1},
                {Presentation.TTT_BOARD_PLAY_ROW_TEMPLATE, Player.X, 2,2, TTT_BOARD_PLAY_ROW_X_2_2},


        };
    }



}
