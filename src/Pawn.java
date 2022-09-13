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
        if (!super.checkBorder (line, column, toLine, toColumn)) return false; // Выходим за границы
        if ((Math.abs(toLine-line)*Math.abs(toColumn-column)==1) && ((chessBoard.board[toLine][toColumn] != null) && !chessBoard.board [toLine][toColumn].getColor().equals(getColor()))) {
            return true; // Кушать по диагонали можем
        }
        if (!(column==toColumn)) return false; // не можем сменить колонку
        if ((chessBoard.board[toLine][toColumn] != null) && chessBoard.board [toLine][toColumn].getColor().equals(getColor())) return false; // на конечной точке стоит своя фигура ход не возможен
        if (color.equals("White")){
            if (line==1&&(toLine==2||toLine==3)) {// Идем с первой клетки, возможны варианты (1 или 2 клетки хода)
                if (toLine==3){
                    if (chessBoard.board[2][toColumn] != null) return false; // не можем перепрыгиывать
                }
                return true;
            }
            else if ((toLine-line)==1) {return true;}
            else return false;
        } else
        {
            if (line==6&&(toLine==5||toLine==4)) {
                if (toLine==4){
                    if (chessBoard.board[5][toColumn] != null) return false; // не можем перепрыгиывать
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

