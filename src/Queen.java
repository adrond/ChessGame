public class Queen extends ChessPiece{
    public Queen (String color){
        super (color);
    }

    @Override
    public String getColor(){
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (!super.checkBorder (line, column, toLine, toColumn)) return false;// Проверяем границы доски и наличие хода
        if ((chessBoard.board[toLine][toColumn] != null) && chessBoard.board [toLine][toColumn].getColor().equals(getColor())) return false; // на конечной точке стоит своя фигура ход не возможен
        if ((line==toLine)||(column==toColumn)){ // Ход Слоном
            return Rook.CanRookMove(chessBoard, line, column, toLine, toColumn);
        }
        if (Math.abs(toLine-line)==Math.abs(toColumn-column)) { // Ход Ладьей
            return Bishop.CanBishopMove(chessBoard, line, column, toLine, toColumn);
        }
       return false;
    }

    @Override
    public String getSymbol(){
        return "Q";
    }
}

