package com.swd.ttt.entity.strategy.minmax;

import java.util.Random;

/**
 * Helper class which evaluates a MinMaxNode per the general MinMax strategy.
 */
public class MinMaxNodeEvaluator {

    private final Random RANDOM = new Random(99991);

    public MinMaxNode childrenEvaluation(MinMaxNode parent, MinMaxNode.MinMax minMax) {

        // Determine whether to get MAX or MIN
        if (minMax == MinMaxNode.MinMax.MAX) {
            return maxEvaluation(parent);
        } else {
            return minEvaluation(parent);
        }
    }

    /**
     * Find and return the maximum value of the children nodes
     */
    protected MinMaxNode maxEvaluation(MinMaxNode parent) {
        int randomStartIndex = RANDOM.nextInt(parent.getChildren().size());
        MinMaxNode maxValue = parent.getChildren().get(randomStartIndex);
        for (MinMaxNode child : parent.getChildren()) {
            if (child.getBoardEvaluation() > maxValue.getBoardEvaluation()) {
                maxValue = child;
            }
        }
        return maxValue;
    }

    /**
     * Find and return the minimum value of the children nodes
     */
    protected MinMaxNode minEvaluation(MinMaxNode parent) {
        int randomStartIndex = RANDOM.nextInt(parent.getChildren().size());
        MinMaxNode minValue = parent.getChildren().get(randomStartIndex);
        for (MinMaxNode child : parent.getChildren()) {
            if (child.getBoardEvaluation() < minValue.getBoardEvaluation()) {
                minValue = child;
            }
        }

        return minValue;
    }


}
