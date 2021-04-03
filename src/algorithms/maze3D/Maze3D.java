package algorithms.maze3D;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

public class Maze3D {
    private int[][][] m_maze;
    private Position3D m_start;
    private Position3D m_end;
    private int m_rowSize,m_colSize,m_depthSize;
    public Maze3D(int[][][] maze, Position3D start, Position3D goal) {
        this.m_maze = maze;
        this.m_start = start;
        this.m_end = goal;
        this.m_rowSize = maze[0].length;
        this.m_colSize = maze[0][0].length;
        m_depthSize= maze.length;
    }

    public int[][][] getMap(){
        return m_maze;
    }

    public Position3D getStartPosition(){
        return m_start;
    }

    public Position3D getGoalPosition(){
        return m_end;
    }

    public int[][][] getMaze() { return m_maze;}

    public void print()
    {
        for (int k = 0; k < m_depthSize; k++)
        {
            System.out.println("{");
            for (int i = 0; i < m_colSize; i++)
            {
                System.out.printf("{");
                for (int j =0;j<m_rowSize;j++){
                    if (i == m_start.getRowIndex() && j == m_start.getColumnIndex() &&  k == m_start.getDepthIndex())
                        System.out.print("S");

                    else if (i == m_end.getRowIndex() && j == m_end.getColumnIndex() &&  k == m_end.getDepthIndex())
                        System.out.print("E");

                    else if (m_maze[k][i][j] == 0)
                        System.out.print("0");

                    else if(m_maze[k][i][j] == 1)
                        System.out.print("1");

                    if (j != m_colSize-1)
                        System.out.print(",");
                }
                System.out.println("}");


            }
            System.out.println("}");
        }
        System.out.println("}");
    }

}
