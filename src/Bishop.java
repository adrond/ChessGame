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
        int step = (column<toColumn)^(line<toLine)?-1:1; // x � y �������� � ����� ����������� ��� � ������
        for (int i=1;lineMin+i<lineMax;i++){
            if (chessBoard.board [lineMin+i][(step<0?columnMax:columnMin)+step*i] != null) {return false;} // ���������, ����� �� �������������
        }
        return true;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (!super.checkBorder (line, column, toLine, toColumn)) return false; //����� �������� ������
        if (Math.abs(toLine-line)!=Math.abs(toColumn-column)) return false; // �������� ������������ ����
        if ((chessBoard.board[toLine][toColumn] != null) && chessBoard.board [toLine][toColumn].getColor().equals(getColor())) return false; // ������ ������, � �������� ����� ���� ������ �����
        return CanBishopMove (chessBoard, line, column, toLine, toColumn);
    }

    @Override
    public String getSymbol(){
        return "B";
    }
}

