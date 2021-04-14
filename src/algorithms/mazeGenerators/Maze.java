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
    private int[][] m_maze;
    private int m_rowSize;
    private int m_colSize;
    Position m_start;
    Position m_goal;

    public Maze(int rowSize, int colSize)
    {
        m_rowSize = rowSize;
        m_colSize = colSize;
        m_maze = new int[rowSize][colSize];
        m_start = new Position(0, 0);
        m_goal = new Position(rowSize - 1, colSize - 1);
    }

    public int getRowSize() { return m_rowSize; }

    public int getColSize() { return m_colSize; }

    public Position getStartPosition() { return m_start; }

    public Position getGoalPosition() { return m_goal; }

    public int[][] getMaze() { return m_maze; }

    public void setStartPosition(Position startPosition) { this.m_start = startPosition; }

    public void setGoalPosition(Position goalPosition) { this.m_goal = goalPosition; }

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
        m_goal = new Position(rowIndex, colIndex);
    }

    /**
     * This method returns the value of the cell in the maze
     * @param position - the position to get value from
     * @return The value in position
     */
    public int getValueInCell(Position position)
    {
        if (position.getRowIndex() < m_rowSize && position.getColumnIndex() < m_colSize)
            return m_maze[position.getRowIndex()][position.getColumnIndex()];
        return -1;
    }

    protected void addWall(int row, int col) { m_maze[row][col] = 1; }

    protected void breakWall(int row, int col) { m_maze[row][col] = 0; }

    /** make all cells in the maze '1' */
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
        for (int row = 0; row < m_rowSize; row++)
        {
            System.out.print("{ ");
            for (int col = 0; col < m_colSize; col++)
            {
                /* if the position is the start - mark with S */
                if (row == m_start.getRowIndex() && col == m_start.getColumnIndex()) { System.out.print("S "); }

                else
                {
                    /* if the position is the goal - mark with E */
                    if (row == m_goal.getRowIndex() && col == m_goal.getColumnIndex()) { System.out.print("E "); }

                    else { System.out.print(m_maze[row][col] + " "); }
                }
            }
            System.out.println("}");
        }
    }
        /**
         * This method checks if a position is on the edge of the maze
         * @param p - the position that wants to check
         * @return true if p on some edge; otherwise false
         */
        protected boolean isPositionOnEdges (Position p)
        {
            return p.getColumnIndex() != m_colSize - 1 && p.getColumnIndex() != 0 && p.getRowIndex() != m_rowSize - 1 && p.getRowIndex() != 0;
        }


    }