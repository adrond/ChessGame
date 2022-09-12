public abstract class ChessPiece {
    public String color;
    public boolean check;

    public ChessPiece(String color) {
        this.color = color;
    }

    public abstract String getColor();

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();

    public boolean checkBorder(int line, int column, int toLine, int toColumn) {
        if ((toLine < 0 || toLine > 7) ||
            (toColumn < 0 || toColumn > 7) ||
            (toLine == line && toColumn == column)) return false;
        return true;
    }
    public boolean checkBorder(int line, int column){
        if ((line<0 || line>7) ||
           (column<0 || column>7)) return false;
        return true;
    }

}
