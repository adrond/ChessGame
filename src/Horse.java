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
        if (!super.checkBorder (line, column, toLine, toColumn)) return false; // Проверяем границы и наличие хода
        if (Math.abs (toLine-line)*Math.abs (toColumn-column)==2) return true; // Проверяем ход буквой Г
        return false;

    }

    @Override
    public String getSymbol(){
        return "H";
    }
}

