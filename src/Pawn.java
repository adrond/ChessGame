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
        if (!super.checkBorder (line, column, toLine, toColumn)) return false;
        if (!(column==toColumn)) return false;
        if (color.equals("White")){
            if (line==1&&(toLine==2||toLine==3)) {return true;}
            else if ((toLine-line)==1) {return true;}
            else return false;
        } else
        {
            if (line==6&&(toLine==5||toLine==4)) {return true;}
            else if ((line-toLine)==1) {return true;}
            else return false;
        }

    }

    @Override
    public String getSymbol(){
        return "P";
    }
}

