package algorithms.mazeGenerators;

import java.util.ArrayList;

/**
 *    The maze is represented as a 2D char array.
 *     Zero ('0') - Pass
 *     One ('1') - Wall
 *     Start ('S') - The starting position
 *     End ('E') - The "Goal" position
 *
 * @author Eden_Hai
 * @version 1.0
 * @since 31-03-2021
 */
public class Maze
{
    private int m_rowSize;
    private int m_colSize;
    private int[][] m_maze;
    Position m_start;
    Position m_end;

    /**
     * Constructor
     * @param rowSize - the number of rows
     * @param colSize - the number of columns
     * @param start   - the start position of maze
     * @param end     - the goal position of maze
     */
    public Maze(int rowSize,int colSize,Position start,Position end)
    {
        m_rowSize = rowSize;
        m_colSize = colSize;
        m_maze = new int[rowSize][colSize];
        m_start = start;
        m_end = end;
    }

    public Maze(int[][] maze, Position start, Position goal) {
        this.m_maze = maze;
        this.m_start = start;
        this.m_end = goal;
        this.m_rowSize = maze.length;
        this.m_colSize = maze[0].length;
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

    public int getRowSize(){ return m_rowSize; }

    public int[][] getMaze() { return m_maze;}

    /**
     * This method return the start of the maze
     *
     * @return Position
     */
    public Position getStartPosition() { return m_start; }


    /**
     * This method return the goal of the maze
     *
     * @return Position
     */
    public Position getGoalPosition() { return m_end; }


    /**
     * This method print the maze where:
     * pass mark with "0"
     * wall mark with "1"
     * start mark with "S"
     * goal mark with "E"
     */
    public void print()
    {
        for (int i = 0; i < m_rowSize; i++)
        {
            for (int j = 0; j < m_colSize; j++)
            {
                if (i == m_start.getRowIndex() && j == m_start.getColumnIndex())
                    System.out.print("S");

                else if (i == m_end.getRowIndex() && j == m_end.getColumnIndex())
                    System.out.print("E");

                else if (m_maze[i][j] == 0)
                    System.out.print("0");

                else if(m_maze[i][j] == 1)
                    System.out.print("1");

                if (j != getColSize()-1)
                    System.out.print(",");
            }
            System.out.println();
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
     * checks if p is a valid position within the maze
     * @param p
     * @return
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



}