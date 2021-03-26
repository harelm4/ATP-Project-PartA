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
    protected Position getRandomNeighbor(){
        double randNum = Math.random();
        if (randNum<0.25){
            return new Position(rowIndex+1,colIndex);
        }
        if (randNum>=0.25 && randNum<0.5){
            return new Position(rowIndex,colIndex+1);
        }
        if (randNum>=0.5 && randNum<0.75){
            return new Position(rowIndex-1,colIndex);
        }
        if (randNum>=0.75){
            return new Position(rowIndex,colIndex-1);
        }
        return null;
    }
}
