package com.swd.ttt.strategy.minmax;

import com.swd.ttt.entity.Turn;
import com.swd.ttt.entity.play.Board;
import com.swd.ttt.entity.play.MovePosition;
import com.swd.ttt.entity.play.Player;
import com.swd.ttt.entity.strategy.minmax.MinMaxNode;
import com.swd.ttt.entity.strategy.minmax.MinMaxNodeEvaluator;
import com.swd.ttt.entity.strategy.minmax.MinMaxStrategy;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(DataProviderRunner.class)
public class MinMaxNodeEvaluatorTest {

    private static MinMaxNodeEvaluator minMaxNodeEvaluator = new MinMaxNodeEvaluator();


    @Test
    @UseDataProvider("testChildEvaluationData")
    public void testChildEvaluation(MinMaxNode parent, MinMaxNode.MinMax minMax, List<MinMaxNode> expectedResultingChildMinMaxNodes) {
        MinMaxNode actualResultingChildMinMaxNode =  minMaxNodeEvaluator.childrenEvaluation(parent, minMax);
        Assert.assertTrue(expectedResultingChildMinMaxNodes.contains(actualResultingChildMinMaxNode));
    }

    @DataProvider
    public static Object[][] testChildEvaluationData() {

        // (1) Create parent node with 4 children nodes
        MinMaxNode parentNode1 = MinMaxNode.newRootMinMaxNode();
        MinMaxNode minMaxNodeChild101 = MinMaxNode.newMinMaxNode(
                parentNode1, MinMaxNode.MinMax.MAX, MovePosition.newMovePosition(4, 1), -4);
        MinMaxNode minMaxNodeChild102 = MinMaxNode.newMinMaxNode(
                parentNode1, MinMaxNode.MinMax.MAX, MovePosition.newMovePosition(4, 2), 3);
        MinMaxNode minMaxNodeChild103 = MinMaxNode.newMinMaxNode(
                parentNode1, MinMaxNode.MinMax.MAX, MovePosition.newMovePosition(4, 3), 10);
        MinMaxNode minMaxNodeChild104 = MinMaxNode.newMinMaxNode(
                parentNode1, MinMaxNode.MinMax.MAX, MovePosition.newMovePosition(4, 4), -10);

        // (2) Create parent node with 4 children nodes
        MinMaxNode parentNode2 = MinMaxNode.newRootMinMaxNode();
        MinMaxNode minMaxNodeChild201 = MinMaxNode.newMinMaxNode(
                parentNode2, MinMaxNode.MinMax.MIN, MovePosition.newMovePosition(4, 1), -4);
        MinMaxNode minMaxNodeChild202 = MinMaxNode.newMinMaxNode(
                parentNode2, MinMaxNode.MinMax.MIN, MovePosition.newMovePosition(4, 2), 3);
        MinMaxNode minMaxNodeChild203 = MinMaxNode.newMinMaxNode(
                parentNode2, MinMaxNode.MinMax.MIN, MovePosition.newMovePosition(4, 3), 10);
        MinMaxNode minMaxNodeChild204 = MinMaxNode.newMinMaxNode(
                parentNode2, MinMaxNode.MinMax.MIN, MovePosition.newMovePosition(4, 4), -4);


        return new Object[][]{
                {parentNode1, MinMaxNode.MinMax.MAX, Arrays.asList(minMaxNodeChild103)},
                {parentNode2, MinMaxNode.MinMax.MIN, Arrays.asList(minMaxNodeChild201, minMaxNodeChild204)}

        };
    }

}