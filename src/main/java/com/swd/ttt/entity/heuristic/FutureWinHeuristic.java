package com.swd.ttt.entity.heuristic;

import java.util.HashSet;
import java.util.Set;

import com.swd.ttt.entity.play.Player;
import com.swd.ttt.entity.play.TicTacToeBoard;

public class FutureWinHeuristic extends AbstractSingleHeuristic {

    private SingleRowHeuristic singleRowHeuristic = SingleRowHeuristic.newSingleRowHeuristic();
    private SingleColumnHeuristic singleColumnHeuristic = SingleColumnHeuristic.newSingleColumnHeuristic();
    private SingleDiagonalHeuristic singleDiagonalHeuristic = SingleDiagonalHeuristic.newSingleDiagonalHeuristic();

    public FutureWinHeuristic() {
        super(3);
    }

    @Override
    public Set<Integer> moves(TicTacToeBoard tictactoeBoard,
                              Player activePlayer, Player opponent) {

        // Get single row, column and diagonal and then intersect them
        Set<Integer> rowMoves = singleRowHeuristic.moves(tictactoeBoard, activePlayer, opponent));
        Set<Integer> columnMoves = singleColumnHeuristic.moves(tictactoeBoard, activePlayer, opponent));
        Set<Integer> diagonalMoves = singleDiagonalHeuristic.moves(tictactoeBoard, activePlayer, opponent));

        // Perform intersections
        Set<Integer> rowColmnIntersectionsMoves = new HashSet<>(rowMoves);
        rowColmnIntersectionsMoves.retainAll(columnMoves);

        Set<Integer> rowDiagonalIntersectionsMoves = new HashSet<>(rowMoves);
        rowDiagonalIntersectionsMoves.retainAll(diagonalMoves);

        Set<Integer> colDiagonalIntersectionsMoves = new HashSet<>(columnMoves);
        colDiagonalIntersectionsMoves.retainAll(diagonalMoves);

        Set<Integer> futureWinMoves = new HashSet<>(rowColmnIntersectionsMoves);
        futureWinMoves.addAll(rowDiagonalIntersectionsMoves);
        futureWinMoves.addAll(colDiagonalIntersectionsMoves);

        // Special case for center
        if (diagonalMoves.size() > 2 && diagonalMoves.contains(4)) {
            futureWinMoves.add(4);
        }

        return futureWinMoves;
    }

}
