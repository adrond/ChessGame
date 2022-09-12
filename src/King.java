public class King extends ChessPiece{
    public King (String color){
        super (color);
    }

    @Override
    public String getColor(){
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (!super.checkBorder (line, column, toLine, toColumn)) return false;
        if ((Math.abs(toLine-line)<2)&&(Math.abs(toColumn-column)<2)) return true;
        else return false;
    }

    @Override
    public String getSymbol(){
        return "K";
    }
    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        if (!super.checkBorder (line, column)) return false;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (chessBoard.board[i][j] != null) {
                    if (!chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

