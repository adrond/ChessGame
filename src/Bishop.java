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
        if (!super.checkBorder (line, column, toLine, toColumn)) return false;
        if (Math.abs(toLine-line)==Math.abs(toColumn-column)) {return true;}
        else return false;

    }

    @Override
    public String getSymbol(){
        return "B";
    }
}

