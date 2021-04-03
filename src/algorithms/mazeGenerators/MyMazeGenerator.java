package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;


/**
 * This algorithm is a randomized version of Prim's algorithm.
 *
 * 1. Start with a grid full of walls.
 * 2. Pick a cell, mark it as part of the maze. Add the walls of the cell to the wall list.
 * 3. While there are walls in the list:
 *      3.1. Pick a random wall from the list. If only one of the two cells that the wall divides is visited, then:
 *          3.2.1. Make the wall a passage and mark the unvisited cell as part of the maze.
 *          3.2.2. Add the neighboring walls of the cell to the wall list.
 *      3.2. Remove the wall from the list.
 */

public class MyMazeGenerator extends AMazeGenerator
{
    private ArrayList<Position> wallsOfTheCell;

    @Override
    public Maze generate(int rowSize, int colSize)
    {
        int[][] maze = new int[rowSize][colSize];

        // Start with a grid full of walls
        makeAllWalls(maze, rowSize, colSize);

        Position start = setStartPosition(maze, rowSize, colSize);
        wallsOfTheCell = new ArrayList<>();
        wallsOfTheCell.add(start);
        Position current;
        int count;

        while (!wallsOfTheCell.isEmpty())
        {
            current = wallsOfTheCell.remove((int) (Math.random() * wallsOfTheCell.size()));
            count = checkNumberOfVisitedNeighbors(maze, current);

            if (count <= 1)
            {
                maze[current.getRowIndex()][current.getColumnIndex()] = 0;

                addValidAdjacentCells(maze, 0, current.getRowIndex(), current.getRowIndex() - 1, current.getColumnIndex());
                addValidAdjacentCells(maze, 0, current.getColumnIndex(), current.getRowIndex(), current.getColumnIndex() - 1);
                addValidAdjacentCells(maze, current.getRowIndex() + 1, maze.length, current.getRowIndex() + 1, current.getColumnIndex());
                addValidAdjacentCells(maze, current.getColumnIndex() + 1, maze[0].length, current.getRowIndex(), current.getColumnIndex() + 1);
            }
        }

        Position goal = setGoalPosition(maze, start);
        Maze myMaze = new Maze(maze, start, goal);
        return myMaze;
    }

    private void makeAllWalls(int[][] maze, int row, int col)
    {
        for (int i = 0; i < maze.length; i++)
        {
            for (int j = 0; j < maze[i].length; j++)
                maze[i][j] = 1;
        }
    }

    private Position setStartPosition(int[][] maze, int row, int col)
    {
        Random random = new Random();
        int rowIndex = random.nextInt(row);
        int colIndex;

        if (rowIndex == 0 || rowIndex == maze.length - 1)
            colIndex = random.nextInt(maze[0].length);

        else
            colIndex = ((int) Math.round(Math.random())) * (maze[0].length - 1);

        maze[rowIndex][colIndex] = 0;

        Position start = new Position(rowIndex, colIndex);
        return start;
    }

    private Position setGoalPosition(int[][] maze, Position start)
    {
        Random r = new Random();
        int rowIndex = start.getRowIndex();
        int colIndex = start.getColumnIndex();
        while (start.getRowIndex() == rowIndex || start.getColumnIndex() == colIndex || maze[rowIndex][colIndex] == 1)
        {
            //pick a random row
            rowIndex = r.nextInt(maze.length);
            //if the row is first or last-pick a random cell
            //else-pick col 0 or end col randomly
            if (rowIndex == 0 || rowIndex == maze.length - 1)
            {
                colIndex = r.nextInt(maze[0].length);
            } else
            {
                colIndex = ((int) (Math.round(Math.random())) * (maze[0].length - 1));
            }
        }
        maze[rowIndex][colIndex] = 0;
        Position goal = new Position(rowIndex,colIndex);
        return goal;
    }
    /**
     returns the number of neighbors that has the value of 0 and in the valid range of the maze

     */
    private int checkNumberOfVisitedNeighbors(int[][] maze, Position current)
    {
        int numOfValidNeighbors = 0;
        if (current.getRowIndex()-1 >= 0 && maze[current.getRowIndex()-1][current.getColumnIndex()] == 0)
            numOfValidNeighbors++;
        if (current.getRowIndex()+1 < maze.length && maze[current.getRowIndex()+1][current.getColumnIndex()] == 0)
            numOfValidNeighbors++;
        if (current.getColumnIndex()-1 >= 0 && maze[current.getRowIndex()][current.getColumnIndex()-1] == 0)
            numOfValidNeighbors++;
        if (current.getColumnIndex()+1 < maze[0].length && maze[current.getRowIndex()][current.getColumnIndex()+1] == 0)
            numOfValidNeighbors++;
        return numOfValidNeighbors;
    }

    /**
     * @param maze
     * @param pos
     * @param limit
     * @param row
     * @param col
     *
     *
     * addValidAdjacentCells(maze, 0, current.getRowIndex(), current.getRowIndex() - 1, current.getColumnIndex());
     */
    private void addValidAdjacentCells(int[][] maze, int pos, int limit, int row, int col)
    {
        if (pos < limit && maze[row][col] == 1)
        {
            Position position = new Position(row, col);
            wallsOfTheCell.add(position);
        }
    }
}
