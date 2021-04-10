package test;

import algorithms.maze3D.IMazeGenerator3D;
import algorithms.maze3D.Maze3D;
import algorithms.maze3D.MyMaze3DGenerator;
import algorithms.maze3D.SearchableMaze3D;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;
import algorithms.search.*;

import java.util.ArrayList;

public class RunSearchOnMaze3D {
    public static void main(String[] args) {
        IMazeGenerator3D mg = new MyMaze3DGenerator();
       // Maze3D maze = mg.generate(7,7,3);
       // Maze maze = new Maze(new int[][] {{0,0,0,0,0,0,0},{0,1,1,1,1,1,1},{0,0,0,0,0,1,0},{1,1,0,1,1,1,0},{0,0,0,0,0,1,0},{1,1,0,1,1,1,0},{0,0,0,0,0,0,0}},new Position(0,0), new Position(6,6));
        //maze.print();

        Maze3D maze;
        for(int i=0 ; i<20;i++){
            maze = mg.generate(100,100,100);
            SearchableMaze3D searchableMaze = new SearchableMaze3D(maze);
//        solveProblem(searchableMaze, new BreadthFirstSearch());
//        solveProblem(searchableMaze, new DepthFirstSearch());
            solveProblem(searchableMaze, new BestFirstSearch());
        }

    }

    private static void solveProblem(ISearchable domain, ISearchingAlgorithm searcher)
    {
        //Solve a searching problem with a searcher
        Solution solution = searcher.solve(domain);
        System.out.println(String.format("'%s' algorithm - nodes evaluated: %s", searcher.getName(), searcher.getNumberOfNodesEvaluated()));

        //Printing Solution Path
        System.out.println("Solution path:");
        ArrayList<AState> solutionPath = solution.getSolutionPath();
        for (int i = 0; i < solutionPath.size(); i++) {
            System.out.println(String.format("%s.%s", i, solutionPath.get(i)));
        }
    }

}
