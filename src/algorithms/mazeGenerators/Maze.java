package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;

/**
 * The maze is represented as a 2D char array.
 * Zero ('0') - Pass
 * One ('1') - Wall
 * Start ('S') - The start position
 * End ('E') - The goal position
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
     *
     * @param rowSize - the number of rows
     * @param colSize - the number of columns
     */
    public Maze(int rowSize, int colSize)
    {
        m_rowSize = rowSize;
        m_colSize = colSize;
        m_maze = new int[rowSize][colSize];
        m_start = new Position(0, 0);
        m_end = new Position(rowSize - 1, colSize - 1);
    }

    public int getRowSize() { return m_rowSize; }

    public int getColSize() { return m_colSize; }

    public int[][] getMaze() { return m_maze; }

    public Position getStartPosition() { return m_start; }

    public Position getGoalPosition() { return m_end; }

    public void setRowSize(int rowSize) { this.m_rowSize = rowSize; }

    public void setColumnSize(int colSize) { this.m_colSize = colSize; }

    public void setMaze(int[][] maze) { this.m_maze = maze; }

    public void setRandomPosition()
    {
        Random random = new Random();
        int rowIndex = random.nextInt(m_rowSize);
        int colIndex;

        /* ----------- UP ----------- */
        if (rowIndex == 0)
        { colIndex = random.nextInt(m_colSize); }

        /* ---------- DOWN ---------- */
        else if (rowIndex == m_rowSize - 1) { colIndex = random.nextInt(m_colSize); }

        else
        {
            int r = random.nextInt(2);

            /* ---------- LEFT ---------- */
            if (r == 0) { colIndex = 0; }

            /* ---------- RIGHT ---------- */
            else { colIndex = m_colSize - 1; }
        }
        m_start = new Position(rowIndex, colIndex);

        while (m_start.getRowIndex() == rowIndex || m_start.getColumnIndex() == colIndex || m_maze[rowIndex][colIndex] == 1)
        {
            /* pick a random row */
            rowIndex = random.nextInt(m_rowSize);

            /* if the row is first or last - pick a random cell */
            if (rowIndex == 0 || rowIndex == m_rowSize - 1) { colIndex = random.nextInt(m_colSize); }

            /* else - pick col 0 or end col randomly */
            else { colIndex = ((int) (Math.round(Math.random())) * (m_colSize - 1)); }
        }
        m_end = new Position(rowIndex, colIndex);
    }

    //    private void setStartPosition()
    //    {
    //        Random random = new Random();
    //        int rowIndex = random.nextInt(m_rowSize);
    //        int colIndex;
    //
    //        /* ----------- UP ----------- */
    //        if (rowIndex == 0)
    //        { colIndex = random.nextInt(m_colSize); }
    //
    //        /* ---------- DOWN ---------- */
    //        else if (rowIndex == m_rowSize - 1) { colIndex = random.nextInt(m_colSize); }
    //
    //        else
    //        {
    //            int r = random.nextInt(2);
    //
    //            /* ---------- LEFT ---------- */
    //            if (r == 0) { colIndex = 0; }
    //
    //            /* ---------- RIGHT ---------- */
    //            else { colIndex = m_colSize - 1; }
    //        }
    //        m_start = new Position(rowIndex, colIndex);
    //    }
    //
    //    private void setGoalPosition()
    //    {
    //        Random random = new Random();
    //        int rowIndex = m_start.getRowIndex();
    //        int colIndex = m_start.getColumnIndex();
    //        while (m_start.getRowIndex() == rowIndex || m_start.getColumnIndex() == colIndex || m_maze[rowIndex][colIndex] == 1)
    //        {
    //            /* pick a random row */
    //            rowIndex = random.nextInt(m_rowSize);
    //
    //            /* if the row is first or last - pick a random cell */
    //            if (rowIndex == 0 || rowIndex == m_rowSize - 1) { colIndex = random.nextInt(m_colSize); }
    //
    //            /* else - pick col 0 or end col randomly */
    //            else { colIndex = ((int) (Math.round(Math.random())) * (m_colSize - 1)); }
    //        }
    //        m_end = new Position(rowIndex, colIndex);
    //    }

    protected void addWall(int row, int col) { m_maze[row][col] = 1; }

    protected void breakWall(int row, int col) { m_maze[row][col] = 0; }

    /**
     * make all cells in the maze '1'
     */
    protected void makeAllWalls()
    {
        for (int i = 0; i < m_rowSize; i++)
        {
            for (int j = 0; j < m_colSize; j++)
                this.addWall(i, j);
        }
    }

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
                System.out.print("{ ");
                for (int j = 0; j < m_colSize; j++)
                {
                    if (i == m_start.getRowIndex() && j == m_start.getColumnIndex()) { System.out.print("S"); }
                    else if (i == m_end.getRowIndex() && j == m_end.getColumnIndex()) { System.out.print("E"); }
                    else if (m_maze[i][j] == 0) { System.out.print("0"); }
                    else if (m_maze[i][j] == 1) { System.out.print("1"); }
                    System.out.print(" ");
                }
                System.out.println("}");
            }
        }
//    public void print()
//    {
//        System.out.print("╔");
//        for (int i = 0; i < m_colSize; i++)
//        {
//            System.out.print("═");
//        }
//        System.out.println("╗");
//        for (int i = 0; i < m_rowSize; i++)
//        {
//            System.out.print("║");
//            for (int j = 0; j < m_colSize; j++)
//            {
//                if (i == m_start.getRowIndex() && j == m_start.getColumnIndex()) { System.out.print("S"); }
//                else if (i == m_end.getRowIndex() && j == m_end.getColumnIndex()) { System.out.print("E"); }
//                else if (m_maze[i][j] == 0) { System.out.print(" "); }
//                else if (m_maze[i][j] == 1) { System.out.print("█"); }
//                System.out.print("");
//            }
//            System.out.println("║");
//        }
//        System.out.print("╚");
//        for (int i = 0; i < m_colSize; i++)
//        {
//            System.out.print("═");
//        }
//        System.out.println("╝");
//    }

    /**
     * This method checks if a position is on the edge of the maze
     * @param p - the position that wants to check
     * @return true if p on some edge; otherwise false
     */
    protected boolean isPositionOnEdges(Position p)
    {
        return p.getColumnIndex() != m_colSize - 1 && p.getColumnIndex() != 0 && p.getRowIndex() != m_rowSize - 1 && p.getRowIndex() != 0;
    }

    /**
     * rightDownNeighbor - a neighbor of p with has the value of 1 and located down or right in relation to p
     *
     * @param p - the position that checked
     * @return A list of the right or down neighbors of p
     */
    protected ArrayList<Position> getRightDownNeighbors(Position p)
    {
        ArrayList<Position> l = new ArrayList<>();

        if ((p.getRowIndex() < m_rowSize - 1) && (m_maze[p.getRowIndex() + 1][p.getColumnIndex()] == 1)) { l.add(new Position(p.getRowIndex() + 1, p.getColumnIndex())); }

        if (p.getColumnIndex() < m_colSize - 1 && m_maze[p.getRowIndex()][p.getColumnIndex() + 1] == 1) { l.add(new Position(p.getRowIndex(), p.getColumnIndex() + 1)); }

        return l;
    }
}