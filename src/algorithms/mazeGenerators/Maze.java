package algorithms.mazeGenerators;

import java.util.ArrayList;

public class Maze {
    private int m_rowSize;
    private int m_colSize;
    private int[][] m_maze;
    Position m_start;
    Position m_end;

    public Maze(int rowSize,int colSize,Position start,Position end){
        //todo:if row or cols are below or eql to 0
        m_rowSize = rowSize;
        m_colSize = colSize;
        m_maze = new int[rowSize][colSize];
        m_start = start;
        m_end = end;

    }
    protected void addWall(int row,int col){
        m_maze[row][col] = 1;
    }
    protected  void breakWall(int row,int col){
        m_maze[row][col] = 0;
    }
    public int getColSize(){
        return m_colSize;
    }
    public int getRowSize(){

        return m_rowSize;
    }

    public Position getGoalPosition() {
        return m_end;
    }

    public Position getStartPosition() {
        return m_start;
    }
    public void print(){
        System.out.print("{");
        for (int i =0;i<m_rowSize;i++){
            for (int j = 0 ;j<m_colSize;j++){
                System.out.print(m_maze[i][j]);
                if(j!=m_colSize-1){
                    System.out.print(",");
                }
            }
            if(i==m_rowSize-1){
                System.out.printf("}");
            }
            System.out.println("");

        }


    }
    protected void makeAllWalls(){
        for (int i =0;i<m_rowSize;i++) {
            for (int j = 0; j < m_colSize; j++) {
                this.addWall(i,j);
            }
        }
    }
    protected boolean isPositionInRange(Position p){
        if (p.getColIndex()<0 || p.getRowIndex()<0 || p.getColIndex()>=m_colSize || p.getRowIndex()>=m_rowSize){
            return false;
        }
        return true;

    }
    protected boolean isPositionOnEdges(Position p){
        if (p.getColIndex()==m_colSize-1 || p.getColIndex()==0|| p.getRowIndex()==m_rowSize-1||p.getRowIndex()==0){
            return true;
        }
        return false;
    }
    protected ArrayList<Position> getAllNeighbors(Position p){
        ArrayList<Position> l = new ArrayList<Position>();
        if (p.getRowIndex()<m_rowSize-1) {
            l.add(new Position(p.getRowIndex() + 1,  p.getColIndex()));
        }
        if (p.getColIndex()<m_colSize-1) {
            l.add(new Position(p.getRowIndex(),  p.getColIndex() + 1));
        }
        if (p.getRowIndex()>0) {
            l.add(new Position(p.getRowIndex() - 1,  p.getColIndex()));
        }
        if (p.getColIndex()>0) {
            l.add(new Position(p.getRowIndex(),  p.getColIndex() - 1 ));
        }
        return l;
    }
}
