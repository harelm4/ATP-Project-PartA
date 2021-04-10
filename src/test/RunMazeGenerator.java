package test;

import algorithms.mazeGenerators.*;

public class RunMazeGenerator {
    public static void main(String[] args) {
//        testMazeGenerator(new EmptyMazeGenerator());
          testMazeGenerator(new SimpleMazeGenerator());
//          testMazeGenerator(new MyMazeGenerator());
    }

    private static void testMazeGenerator(IMazeGenerator mazeGenerator)
    {

        // generate another maze
        Maze maze = mazeGenerator.generate(20/*rows*/, 40/*columns*/);

        // prints the maze
//        maze.print();

        // prints the time it takes the algorithm to run
        System.out.println(String.format("Maze generation time(ms): %s", mazeGenerator.measureAlgorithmTimeMillis(1000/*rows*/, 1000/*columns*/)));

        // get the maze entrance
        Position startPosition = maze.getStartPosition();

        // print the start position
        System.out.println(String.format("Start Position: %s", startPosition)); // format "{row,column}"

        // prints the maze exit position
        System.out.println(String.format("Goal Position: %s", maze.getGoalPosition()));
    }
}