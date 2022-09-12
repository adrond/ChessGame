public class Horse extends ChessPiece{
    public Horse (String color){
        super (color);
    }

    @Override
    public String getColor(){
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (!super.checkBorder (line, column, toLine, toColumn)) return false;

        int xDiff = Math.abs (toLine-line);
        int yDiff = Math.abs (toColumn-column);
        if (yDiff*xDiff==2) return true;
        else return false;

    }

    @Override
    public String getSymbol(){
        return "H";
    }
}

