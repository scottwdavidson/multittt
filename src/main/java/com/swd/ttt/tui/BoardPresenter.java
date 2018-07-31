package com.swd.ttt.tui;

import com.swd.ttt.entity.play.Board;
import com.swd.ttt.entity.play.MovePosition;
import com.swd.ttt.entity.play.Player;
import com.swd.ttt.entity.play.TicTacToeBoard;

/**
 * Presents the board as part of the text user interface (TUI).
 */
public class BoardPresenter {

    final static String TTT_BOARD_PLAY_ROW_TEMPLATE = "    |   |      ''      |   |      ''      |   |   ";
    final static String TTT_BOARD_SEPARATOR_ROW_TEMPLATE = " ---|---|---   ''   ---|---|---   ''   ---|---|---";
    final static int BOARD_CHARACTER_OFFSET = 19;
    final static int BOARD_POSITION_INITIAL_CHARACTER_OFFSET = 2;
    final static int BOARD_POSITION_CHARACTER_OFFSET = 4;
    final static String NEW_LINE = "\n";

    final static String BOARD_METADATA_HEADER_HORIZONTAL = "--------------------------------------------------";
    final static String BOARD_METADATA_HEADER_VERTICAL = "|                                                |";

    public static String presentation(Board board) {

        StringBuilder builder = new StringBuilder();

        {
            builder.append(BOARD_METADATA_HEADER_HORIZONTAL).append(NEW_LINE);
            builder.append(BOARD_METADATA_HEADER_VERTICAL).append(NEW_LINE);
            builder.append(BOARD_METADATA_HEADER_VERTICAL).append(NEW_LINE);
            builder.append("| ID: ").append(board.getId()).append("  ");
            builder.append("| Move Number: ").append(board.getMoveNumber()).append(NEW_LINE);
            builder.append("| Active Player: ").append(board.getActivePlayer().name()).append("   ");
            builder.append("| Active TTT Board: ").append(board.getActiveTicTacToeBoardIndex()).append(NEW_LINE);
            builder.append("| Game State: ").append(board.getGameState()).append("   ");
            builder.append("| Winning Player: ").append(board.getWinningPlayer().name()).append(NEW_LINE);
            builder.append("| Score: ").append(board.getScore()).append(NEW_LINE);
            builder.append(BOARD_METADATA_HEADER_VERTICAL).append(NEW_LINE);
            builder.append(BOARD_METADATA_HEADER_VERTICAL).append(NEW_LINE);
            builder.append(BOARD_METADATA_HEADER_HORIZONTAL).append(NEW_LINE);
        }


        for(int sectionRowIndex = 0; sectionRowIndex < 3; sectionRowIndex++){

            int tttBoardIndex = sectionRowIndex * 3;
            boolean firstTime = true;
            for (int rowIndex = 0; rowIndex < 3; rowIndex++){

                if ( firstTime ){
                    firstTime = false;
                }
                else {
                    builder.append(TTT_BOARD_SEPARATOR_ROW_TEMPLATE).append(NEW_LINE);
                }

                String rowTemplate = TTT_BOARD_PLAY_ROW_TEMPLATE;

                for (int tableIndex = 0; tableIndex<3; tableIndex++){

                    for (int columnIndex = 0; columnIndex < 3; columnIndex++) {

                        // Is there a play that needs to be inserted ?
                        int relativeBoard = tableIndex;
                        int relativePosition = columnIndex;
                        int cellPosition = rowIndex*3+columnIndex;
                        Player player = board.getTttBoards()[sectionRowIndex*3 + tableIndex].getCells()[cellPosition].getPlayer();
//                        System.out.println(tableIndex + ":" + columnIndex + " --> " + player);
                        if ( player == Player.X ){
                            rowTemplate = insertPlay(rowTemplate,Player.X,relativeBoard,relativePosition);
                        }
                        else if ( player == Player.O ){
                            rowTemplate = insertPlay(rowTemplate,Player.O,relativeBoard,relativePosition);
                        }
                    }
                }
                builder.append(rowTemplate).append(NEW_LINE);
            }
            builder.append(NEW_LINE).append(NEW_LINE);
        }

        return builder.toString();
    }

    static String insertPlay(String boardPlayRowTemplate, Player player, int relativeBoard, int relativePosition) {

        int playPosition = calculatePlayPosition(relativeBoard, relativePosition);
//        System.out.println("relativeBoard = " + relativeBoard + " , relativePosition = " + relativePosition + " , playPosition = " + playPosition);
        return boardPlayRowTemplate.substring(0, playPosition) + player.name() + boardPlayRowTemplate.substring(playPosition+1);
    }

    static int calculatePlayPosition(int relativeBoard, int relativePosition) {
        return relativeBoard * BOARD_CHARACTER_OFFSET + (BOARD_POSITION_INITIAL_CHARACTER_OFFSET + relativePosition * BOARD_POSITION_CHARACTER_OFFSET);
    }

    public static void main(String[] args) {

        final int INITIAL_BOARD = 0;
        Board board = Board.initialBoard(1000, Player.X,INITIAL_BOARD);
        int moveNumber = 1;
        Player activePlayer = Player.X;
        Player opponent = activePlayer.opponent();
        MovePosition movePosition = null;

        {
            movePosition = MovePosition.newMovePosition(INITIAL_BOARD,4);
            TicTacToeBoard ticTacToeBoard = board.getTttBoards()[movePosition.getTicTacToeBoardIndex()];
            ticTacToeBoard = TicTacToeBoard.applyMove(ticTacToeBoard,activePlayer,movePosition, moveNumber);
            board = board.executeTurn(moveNumber, opponent, movePosition.getTicTacToeBoardIndex(), ticTacToeBoard, movePosition.getPosition());
            System.out.println("--- \n" + BoardPresenter.presentation(board));

            moveNumber++;
            activePlayer = activePlayer.opponent();
            opponent = opponent.opponent();
        }

        {
            movePosition = MovePosition.newMovePosition(movePosition.getPosition(),4);
            TicTacToeBoard ticTacToeBoard = board.getTttBoards()[movePosition.getTicTacToeBoardIndex()];
            ticTacToeBoard = TicTacToeBoard.applyMove(ticTacToeBoard,activePlayer,movePosition, moveNumber);
            board = board.executeTurn(moveNumber, opponent, movePosition.getTicTacToeBoardIndex(), ticTacToeBoard, movePosition.getPosition());
            System.out.println("--- \n" + BoardPresenter.presentation(board));

            moveNumber++;
            activePlayer = activePlayer.opponent();
            opponent = opponent.opponent();
        }


    }
}
