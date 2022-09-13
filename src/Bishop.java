public class Bishop extends ChessPiece{
    public Bishop (String color){
        super (color);
    }

    @Override
    public String getColor(){
        return color;
    }

    public static boolean CanBishopMove (ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        int lineMin = Math.min(line,toLine);
        int lineMax = Math.max(line,toLine);
        int columnMin = Math.min(column,toColumn);
        int columnMax = Math.max (column,toColumn);
        int step = (column<toColumn)^(line<toLine)?-1:1; // x и y меняются в одном направлении или в разных
        for (int i=1;lineMin+i<lineMax;i++){
            if (chessBoard.board [lineMin+i][(step<0?columnMax:columnMin)+step*i] != null) {return false;} // Проверяем, чтобы не перепрыгивали
        }
        return true;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (!super.checkBorder (line, column, toLine, toColumn)) return false; //Общая проверка границ
        if (Math.abs(toLine-line)!=Math.abs(toColumn-column)) return false; // Проверка правильности хода
        if ((chessBoard.board[toLine][toColumn] != null) && chessBoard.board [toLine][toColumn].getColor().equals(getColor())) return false; // Нельзя ходить, в конечной точке своя фигура стоит
        return CanBishopMove (chessBoard, line, column, toLine, toColumn);
    }

    @Override
    public String getSymbol(){
        return "B";
    }
}

