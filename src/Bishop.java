public class Bishop extends ChessPiece{
    public Bishop (String color){
        super (color);
    }

    @Override
    public String getColor(){
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (!super.checkBorder (line, column, toLine, toColumn)) return false; //Общая проверка границ
        if (Math.abs(toLine-line)!=Math.abs(toColumn-column)) return false; // Проверка правильности хода
        if (chessBoard.board [toLine][toColumn].getColor().equals(getColor())) return false; // Нельзя ходить, в конечной точке своя фигура стоит
        int lineMin = line<toLine?line:toLine;
        int lineMax = line>toLine?line:toLine;
        int columnMin = column<toColumn?column:toColumn;
        int step = (column<toColumn)^(line<toLine)?-1:1;
        for (int i=1;lineMin+i<lineMax;i++){
            if (chessBoard.board [lineMin+i][columnMin+step*i] != null) {return false;}
        }
        return true;

    }

    @Override
    public String getSymbol(){
        return "B";
    }
}

