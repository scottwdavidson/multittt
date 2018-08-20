package com.swd.ttt.entity.eval;

/**
 * Helper class which provides masking functions.
 */
public class MaskHelper {

    /**
     * Returns <tt>true</tt> if the provided mask applied to the player representation leads to the provided
     * expected mask representation.
     */
    // TODO should probably move this to be available by Heuristics too ( since eval is dependent on heuristic anyway
    public static boolean mask(short playerRepresentation, short mask, short expectedMaskedPlayerRepresentation){
        int maskedPlayerRepresentation = playerRepresentation & mask;
        return (short) maskedPlayerRepresentation == expectedMaskedPlayerRepresentation;
    }

}
