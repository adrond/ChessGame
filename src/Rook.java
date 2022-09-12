public class Rook extends ChessPiece{
    public Rook (String color){
        super (color);
    }

    @Override
    public String getColor(){
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (!super.checkBorder (line, column, toLine, toColumn)) return false;
        if ((line==toLine)||(column==toColumn)) return true;
        else return false;
    }

    @Override
    public String getSymbol(){
        return "R";
    }
}

