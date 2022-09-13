public class Rook extends ChessPiece{
    public Rook (String color){
        super (color);
    }

    @Override
    public String getColor(){
        return color;
    }

    public static boolean CanRookMove (ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (column==toColumn) {// ���� �� ��������
            for (int i = Math.min (line,toLine)+1; i<Math.max (line,toLine);i++){
                if (chessBoard.board[i][toColumn] != null) return false; // ������������� �� �����
            }
        }
        else{ // ���� �� ��������
            for (int i = Math.min(column,toColumn); i<Math.max(column,toColumn);i++){
                if (chessBoard.board[toLine][i] != null) return false; // ������������� �� �����
            }
        }
        return true;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (!super.checkBorder (line, column, toLine, toColumn)) return false; // ��������� ������� ����� � ������� ����
        if (!((line==toLine)||(column==toColumn))) return false; // ��������� ������������ ���� �����
        if ((chessBoard.board[toLine][toColumn] != null) && chessBoard.board [toLine][toColumn].getColor().equals(getColor())) return false; // �� �������� ����� ����� ���� ������ ��� �� ��������
        return CanRookMove (chessBoard, line, column, toLine, toColumn);
    }

    @Override
    public String getSymbol(){
        return "R";
    }
}

