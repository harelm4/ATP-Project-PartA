package algorithms.mazeGenerators;

public class Position {
    private int rowIndex;
    private int colIndex;
    public Position(int row,int col){
        rowIndex=row;
        colIndex=col;


    }

    public int getColumnIndex() {
        return colIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    @Override
    public String toString(){
        return "{"+rowIndex+","+colIndex+"}";
    }

    /**
     * @param other
     * @return
     * compare 2 positions
     */
    @Override
    public boolean equals(Object other){
        if (this.colIndex==((Position)other).getColumnIndex() && this.rowIndex==((Position)other).getRowIndex()){
            return true;
        }
        return false;
    }
}
