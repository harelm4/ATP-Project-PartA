package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;

/**
 * A class that generates a simple maze
 *
 * @author Eden_Hai
 * @version 2.0
 * @since 07-04-2021
 */
public class SimpleMazeGenerator extends AMazeGenerator
{
    @Override
    public Maze generate(int rowSize, int colSize)
    {
        if (rowSize < 2 || colSize < 2) { return null; }

        /* Create a maze with no walls */
        Maze simpleMaze = new Maze(rowSize, colSize);

        Random random = new Random();
//
////        for (int j = 0; j<rowSize/2; j++) {
//        for (int i = 0; i < rowSize; i++)
//        {
//            simpleMaze.addWall(i, random.nextInt(colSize));
//        }
////    }
//
//        return simpleMaze;
        Position start = simpleMaze.getStartPosition();
        Position goal = simpleMaze.getGoalPosition();

        if (simpleMaze.isPositionOnEdges(start) || simpleMaze.isPositionOnEdges(goal)) { return null; }

        Random rand = new Random();

        /* Start with a grid full of walls */
        simpleMaze.makeAllWalls();
        simpleMaze.breakWall(start.getRowIndex(), start.getColumnIndex());

        ArrayList<Position> visitedCells = new ArrayList<>(); // list of visited cells
        visitedCells.add(start);
        ArrayList<Position> neighborsList = simpleMaze.getRightDownNeighbors(start); // list of neighbors to choose from
        Position neighbor;
        int i;
        while (!visitedCells.contains(goal) && neighborsList.size() != 0)
        {
            i = rand.nextInt(neighborsList.size());
            neighbor = neighborsList.get(i);
            visitedCells.add(neighbor);
            simpleMaze.breakWall(neighbor.getRowIndex(), neighbor.getColumnIndex());
            neighborsList = simpleMaze.getRightDownNeighbors(neighbor);

        }
        return randomZeros(goal, simpleMaze);
    }

    private Maze randomZeros(Position end, Maze m)
    {
        Random r  = new Random();
        for(int i=0 ; i<end.getRowIndex()*end.getColumnIndex();i++){
            m.breakWall(r.nextInt(end.getRowIndex()),r.nextInt(end.getColumnIndex()));
        }
        return m;
    }
}
