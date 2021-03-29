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
        for (int i =0;i<m_rowSize;i++){
            for (int j = 0 ;j<m_colSize;j++){
                System.out.print(m_maze[i][j]);
                if(j!=m_colSize-1){
                    System.out.print(",");
                }
            }
            System.out.println("");

        }


    }

    /**
     * make all cells in the maze 1
     */
    protected void makeAllWalls(){
        for (int i =0;i<m_rowSize;i++) {
            for (int j = 0; j < m_colSize; j++) {
                this.addWall(i,j);
            }
        }
    }

    /**
     * @param p
     * @return
     * checks if p is a valid position within the maze
     */
    protected boolean isPositionInRange(Position p){
        if (p.getColumnIndex()<0 || p.getRowIndex()<0 || p.getColumnIndex()>=m_colSize || p.getRowIndex()>=m_rowSize){
            return false;
        }
        return true;

    }

    /**
     * @param p
     * @return
     * checks if p is a position on the edge of the maze
     */
    protected boolean isPositionOnEdges(Position p){
        if (p.getColumnIndex()==m_colSize-1 || p.getColumnIndex()==0|| p.getRowIndex()==m_rowSize-1||p.getRowIndex()==0){
            return true;
        }
        return false;
    }

    /**
     * rightDownNeighbor - a neighbor of p with has the value of 1 and located down or right in relation to p
     * @param p
     * @return a list
     *
     */
    protected ArrayList<Position> getRightDownNeighbors(Position p){

        ArrayList<Position> l = new ArrayList<Position>();
        if ((p.getRowIndex()<m_rowSize-1 ) && (m_maze[p.getRowIndex() + 1][ p.getColumnIndex()] == 1) ) {
            l.add(new Position(p.getRowIndex() + 1,  p.getColumnIndex()));
        }
        if (p.getColumnIndex()<m_colSize-1&& m_maze[p.getRowIndex()][ p.getColumnIndex()+1]==1) {
            l.add(new Position(p.getRowIndex(),  p.getColumnIndex() + 1));
        }
        return l;
    }

    /**
     * return a list of the neighbors of p eitch has the value of 1
     * @param p
     * @return
     */
    protected ArrayList<Position> getAllNeighbors(Position p){

        ArrayList<Position> l = new ArrayList<Position>();
        if ((p.getRowIndex()<m_rowSize-1 ) && (m_maze[p.getRowIndex() + 1][ p.getColumnIndex()] == 1) ) {
            l.add(new Position(p.getRowIndex() + 1,  p.getColumnIndex()));
        }
        if (p.getColumnIndex()<m_colSize-1&& m_maze[p.getRowIndex()][ p.getColumnIndex()+1]==1) {
            l.add(new Position(p.getRowIndex(),  p.getColumnIndex() + 1));
        }
        if ((p.getRowIndex()>0 )&& p.getColumnIndex()<m_colSize-1 && p.getRowIndex()<m_rowSize-1 && (m_maze[p.getRowIndex() - 1][ p.getColumnIndex()] == 1) ) {
            l.add(new Position(p.getRowIndex() -1,  p.getColumnIndex()));
        }
        if (p.getColumnIndex()>0 && p.getColumnIndex()<m_colSize-1 && p.getRowIndex()<m_rowSize-1 && m_maze[p.getRowIndex()][ p.getColumnIndex()-1]==1) {
            l.add(new Position(p.getRowIndex(),  p.getColumnIndex() -1));
        }
        return l;
    }

}
