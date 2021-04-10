package algorithms.maze3D;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

public class Maze3D
{
    private int[][][] m_maze;
    private Position3D m_start;
    private Position3D m_end;
    private int m_rowSize, m_colSize, m_depthSize;

    public Maze3D(int[][][] maze, Position3D start, Position3D goal)
    {
        this.m_maze = maze; this.m_start = start; this.m_end = goal; this.m_rowSize = maze[0].length; this.m_colSize = maze[0][0].length; m_depthSize = maze.length;
    }

    public int[][][] getMap()
    {
        return m_maze;
    }

    public Position3D getStartPosition()
    {
        return m_start;
    }

    public Position3D getGoalPosition()
    {
        return m_end;
    }

    public int[][][] getMaze()
    {
        return m_maze;
    }

    public void print(){
        System.out.println("{");
        for(int depth = 0; depth < m_maze.length; depth++){
            for(int row = 0; row < m_maze[0].length; row++) {
                System.out.print("{ ");
                for (int col = 0; col < m_maze[0][0].length; col++) {
                    if (depth == m_start.getDepthIndex() && row == m_start.getRowIndex() && col == m_start.getColumnIndex()) // if the position is the start - mark with S
                        System.out.print("S ");
                    else {
                        if (depth == m_end.getDepthIndex() && row == m_end.getRowIndex() && col == m_end.getColumnIndex()) // if the position is the goal - mark with E
                            System.out.print("E ");
                        else
                            System.out.print(m_maze[depth][row][col] + " ");
                    }
                }
                System.out.println("}");
            }
            if(depth < m_maze.length - 1) {
                System.out.print("---");
                for (int i = 0; i < m_maze[0][0].length; i++)
                    System.out.print("--");
                System.out.println();
            }
        }
        System.out.println("}");
    }
}