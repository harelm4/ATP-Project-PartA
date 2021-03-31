package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class MyMazeGenerator extends AMazeGenerator {


    @Override
    public Maze generate(int rowSize, int colSize) {
        return null;
    }

    /**
     * maze generator based on the iterative algorithm (DFS maze generator)
     */
/*    @Override
    public Maze generate(int rowSize, int colSize) {
        if(rowSize<=0 || colSize<=0 ){
            return null;
        }
        Position start = new Position(0,0);
        Position end = new Position(rowSize-1,colSize-1);
        Maze m = new Maze(rowSize,colSize,start,end);
        Stack<Position> stack = new Stack<Position>();
        m.makeAllWalls();
        ArrayList<Position> visited = new ArrayList<Position>();
        visited.add(start);
        stack.push(start);
        m.breakWall(0,0);
        ArrayList<Position> neighbors;
        Position cur,n = start;
        Random r = new Random();
        while (!stack.isEmpty() ){
            cur = stack.pop();
            neighbors = m.getAllNeighbors(cur);
            if (!neighbors.isEmpty() && !visited.containsAll(neighbors)){
                stack.push(cur);
                n =neighbors.get(r.nextInt(neighbors.size()));
                for (Position p:neighbors
                     ) {

                    visited.add(p);
                    stack.push(p);

                }
                m.breakWall(n.getRowIndex(),n.getColumnIndex());





            }
        }


        return m;
    }*/
}
