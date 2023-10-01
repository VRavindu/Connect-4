package lk.ijse.dep.service;

public class AiPlayer extends Player {
    public AiPlayer(Board newBoard) {
        super(newBoard);
    }

    @Override
    public void movePiece(int col) {

        do {
            col = (int) (Math.random() * 6);

        }while (!(col > -1 && col < 6) || !(board.isLegalMove(col)));


        if (board.isLegalMove(col)){
            board.updateMove(col, Piece.GREEN);
            board.getBoardUI().update(col, false);

            Winner win = board.findWinner();

            if (board.findWinner().getWinningPiece() == Piece.EMPTY){
                if (!board.existLegalMoves()){
                    board.getBoardUI().notifyWinner(win);
                }
            }else {
                board.getBoardUI().notifyWinner(win);
            }
        }
    }
}
