package algorithms.mazeGenerators;

public class Position {
    private int rowIndex;
    private int colIndex;
    public Position(int row,int col){
        rowIndex=row;
        colIndex=col;


    }

    public int getColIndex() {
        return colIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    @Override
    public String toString(){
        return "{"+rowIndex+","+colIndex+"}";
    }
    @Override
    public boolean equals(Object other){
        if (this.colIndex==((Position)other).getColIndex() && this.rowIndex==((Position)other).getRowIndex()){
            return true;
        }
        return false;
    }
}
