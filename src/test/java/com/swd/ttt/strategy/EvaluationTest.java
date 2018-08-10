package com.swd.ttt.strategy;

import com.swd.ttt.entity.strategy.Evaluation;
import com.swd.ttt.entity.strategy.minmax.MinMaxNode;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(DataProviderRunner.class)
public class EvaluationTest {

    @Test
    @UseDataProvider("testPlusData")
    public void testPlus(Evaluation initialEvaluation, Evaluation updateEvaluation, Evaluation expectedEvaluation) {

        Evaluation result = initialEvaluation.plus(updateEvaluation);
        Assert.assertTrue(expectedEvaluation.compareTo(result) == 0);
    }

    @DataProvider
    public static Object[][] testPlusData() {

        Evaluation eval01 = new Evaluation();
        Evaluation update01 = new Evaluation();
        {
            eval01.plusWins(2);
            eval01.plusLosses(1);
            eval01.plusDraws(1);
            eval01.plusRelativeValues(17);
        }

        Evaluation eval02 = new Evaluation();
        Evaluation update02 = new Evaluation();
        Evaluation expected02 = new Evaluation();
        {
            eval02.plusWins(2);
            eval02.plusLosses(1);
            eval02.plusDraws(1);
            eval02.plusRelativeValues(17);

            update02.plusWins(1);
            update02.plusLosses(2);
            update02.plusDraws(1);

            expected02.plusWins(3);
            expected02.plusLosses(3);
            expected02.plusDraws(2);
            expected02.plusRelativeValues(17);
        }

        Evaluation eval03 = new Evaluation();
        Evaluation update03 = new Evaluation();
        Evaluation expected03 = new Evaluation();
        {
            eval03.plusWins(1);
            eval03.plusLosses(1);
            eval03.plusDraws(3);
            eval03.plusRelativeValues(22);

            update03.plusWins(1);
            update03.plusLosses(2);
            update03.plusDraws(0);
            update03.plusRelativeValues(13);

            expected03.plusWins(2);
            expected03.plusLosses(3);
            expected03.plusDraws(3);
            expected03.plusRelativeValues(35);
        }

        return new Object[][]{
                {eval01, update01, eval01},
                {eval02, update02, expected02},

        };
    }

}