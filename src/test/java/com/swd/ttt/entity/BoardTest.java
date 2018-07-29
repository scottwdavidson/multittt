package com.swd.ttt.entity;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class BoardTest {


    @Test
    @UseDataProvider("boardData")
    public void testToString(Board board){
        System.out.println(board);

    }

    @DataProvider
    public static Object[][] boardData() {

//        // Note: all of this initialization is done here b/c if it's done in @BeforeClass the updated objects
//        // are not used here ( most likely due to static object initialization order )
//        {
//            X_0_1 = TicTacToeBoard.applyMove(X_0_1, Player.X, MovePosition.newMovePosition(0,0),0);
//            X_0_1 = TicTacToeBoard.applyMove(X_0_1, Player.X, MovePosition.newMovePosition(0,1),1);
//        }
//        {
//            X_2_5_O_7_8 = TicTacToeBoard.applyMove(X_2_5_O_7_8, Player.X, MovePosition.newMovePosition(1,2),3);
//            X_2_5_O_7_8 = TicTacToeBoard.applyMove(X_2_5_O_7_8, Player.X, MovePosition.newMovePosition(1,5),4);
//            X_2_5_O_7_8 = TicTacToeBoard.applyMove(X_2_5_O_7_8, Player.O, MovePosition.newMovePosition(1,7),5);
//            X_2_5_O_7_8 = TicTacToeBoard.applyMove(X_2_5_O_7_8, Player.O, MovePosition.newMovePosition(1,8),6);
//
//        }
//        {
//            X_4_8_O_0_3 = TicTacToeBoard.applyMove(X_4_8_O_0_3, Player.X, MovePosition.newMovePosition(1,4),7);
//            X_4_8_O_0_3 = TicTacToeBoard.applyMove(X_4_8_O_0_3, Player.X, MovePosition.newMovePosition(1,8),8);
//            X_4_8_O_0_3 = TicTacToeBoard.applyMove(X_4_8_O_0_3, Player.O, MovePosition.newMovePosition(1,0),9);
//            X_4_8_O_0_3 = TicTacToeBoard.applyMove(X_4_8_O_0_3, Player.O, MovePosition.newMovePosition(1,3),10);
//
//        }

        return new Object[][] {
                {Board.initialBoard(1000, Player.X, 4)}
        };
    }


}
