public class Pawn extends ChessPiece{
    public Pawn (String color){
        super (color);
    }

    @Override
    public String getColor(){
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (!super.checkBorder (line, column, toLine, toColumn)) return false; // ������� �� �������
        if ((Math.abs(toLine-line)*Math.abs(toColumn-column)==1) && ((chessBoard.board[toLine][toColumn] != null) && !chessBoard.board [toLine][toColumn].getColor().equals(getColor()))) {
            return true; // ������ �� ��������� �����
        }
        if (!(column==toColumn)) return false; // �� ����� ������� �������
        if ((chessBoard.board[toLine][toColumn] != null) && chessBoard.board [toLine][toColumn].getColor().equals(getColor())) return false; // �� �������� ����� ����� ���� ������ ��� �� ��������
        if (color.equals("White")){
            if (line==1&&(toLine==2||toLine==3)) {// ���� � ������ ������, �������� �������� (1 ��� 2 ������ ����)
                if (toLine==3){
                    if (chessBoard.board[2][toColumn] != null) return false; // �� ����� ��������������
                }
                return true;
            }
            else if ((toLine-line)==1) {return true;}
            else return false;
        } else
        {
            if (line==6&&(toLine==5||toLine==4)) {
                if (toLine==4){
                    if (chessBoard.board[5][toColumn] != null) return false; // �� ����� ��������������
                }
                return true;
            }
            else if ((line-toLine)==1) {return true;}
            else return false;
        }

    }

    @Override
    public String getSymbol(){
        return "P";
    }
}

