package com.swd.ttt.strategy.minmax;

import com.swd.ttt.entity.Turn;
import com.swd.ttt.entity.eval.WinEval;
import com.swd.ttt.entity.play.Board;
import com.swd.ttt.entity.play.MovePosition;
import com.swd.ttt.entity.play.Player;
import com.swd.ttt.entity.play.TicTacToeBoard;
import com.swd.ttt.entity.strategy.minmax.MinMaxNode;
import com.swd.ttt.entity.strategy.minmax.MinMaxStrategy;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(DataProviderRunner.class)
public class MinMaxStrategyTest {

    private static MinMaxStrategy minMaxStrategy = new MinMaxStrategy();


    @Test
    @UseDataProvider("testExecuteMoveData")
    public void testExecuteMove(Board board){

        Assert.assertNotNull( minMaxStrategy.executeMove(board) );

    }

    @DataProvider
    public static Object[][] testExecuteMoveData() {

        // Construct of series of moves
        //
        // The focus for the test is to almost fill TTT board #4 and have the next play there
        // to test the executeMove(...) method; here's what board #4 looks like:
        //
        //         | X | O
        //       ---------
        //       O | X | X
        //       ---------
        //         | O | X
        List<MovePosition> movePositions = new ArrayList<MovePosition>();
        movePositions.add(MovePosition.newMovePosition(4,4));  // X
        movePositions.add(MovePosition.newMovePosition(4,2));  // O
        movePositions.add(MovePosition.newMovePosition(2,0));
        movePositions.add(MovePosition.newMovePosition(0,6));
        movePositions.add(MovePosition.newMovePosition(6,1));
        movePositions.add(MovePosition.newMovePosition(1,4));
        movePositions.add(MovePosition.newMovePosition(4,5));  // X
        movePositions.add(MovePosition.newMovePosition(5,4));
        movePositions.add(MovePosition.newMovePosition(4,1));  // X
        movePositions.add(MovePosition.newMovePosition(1,7));
        movePositions.add(MovePosition.newMovePosition(7,4));
        movePositions.add(MovePosition.newMovePosition(4,3));  // O
        movePositions.add(MovePosition.newMovePosition(3,4));
        movePositions.add(MovePosition.newMovePosition(4,7));  // O
        movePositions.add(MovePosition.newMovePosition(7,6));
        movePositions.add(MovePosition.newMovePosition(6,4));
        movePositions.add(MovePosition.newMovePosition(4,8));  // X
        movePositions.add(MovePosition.newMovePosition(8,4));  // X


        // Instantiate a Board and execute a series of moves
        Board board = executeMultipleTurns(Board.initialBoard(1000, Player.X, 4),
                movePositions);

        return new Object[][] {
                {board}
        };
    }

    protected static Board executeMultipleTurns(Board board, List<MovePosition> movePositions){
        Turn turn = new Turn();
        for(MovePosition movePosition : movePositions){
            board = turn.executeTurn(board, movePosition);
        }
        return board;
    }

}