package algorithms.search;

import algorithms.maze3D.*;
import algorithms.mazeGenerators.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class BestFirstSearchTest
{
    private Maze maze;
    private Maze3D maze3D;
    private SearchableMaze searchableMaze;
    private EmptyMazeGenerator emptyMaze = new EmptyMazeGenerator();
    private SimpleMazeGenerator simpleMaze = new SimpleMazeGenerator();
    private MyMazeGenerator myMaze2D = new MyMazeGenerator();
    private MyMaze3DGenerator myMaze3D = new MyMaze3DGenerator();
    private ISearchingAlgorithm best ;

    @Test
    public void GetAlgorithmNameTest()
    {
        best = new BestFirstSearch();
        assertEquals("BestFirstSearch", best.getName());
    }

    @Test
    public void notNullTest()
    {
        assertNull(emptyMaze.generate(-2,4));
        assertNull(simpleMaze.generate(-10, -10));
        assertNull(myMaze2D.generate(0,0));
        assertNull(myMaze3D.generate(4,-9,10));
    }

    @Test
    public void mazeSizeTest()
    {
        maze = simpleMaze.generate(100, 200);
        searchableMaze = new SearchableMaze(maze);
        assertEquals(maze.getRowSize(), 100);
        assertEquals(maze.getColSize(), 200);
    }

    @Test
    public void getNumOfNodesEvaluatedTest()
    {
        best = new BestFirstSearch();
        best.solve(null);
        assertEquals(best.getNumberOfNodesEvaluated(), 0);
    }

    @Test
    public void solve2DMazeTest()
    {
        solve2DAssert(emptyMaze, 2, 2);
        solve2DAssert(emptyMaze, 60, 50);

        solve2DAssert(simpleMaze, 2,3);
        solve2DAssert(emptyMaze, 1000, 1000);
        solve2DAssert(simpleMaze, 3,2);
        solve2DAssert(simpleMaze, 67, 57);
        solve2DAssert(simpleMaze, 1000, 650);
        solve2DAssert(simpleMaze, 1000,1000);
        solve2DAssert(myMaze2D, 2, 2);
        solve2DAssert(myMaze2D, 2, 3);
        solve2DAssert(myMaze2D, 3, 2);
        solve2DAssert(myMaze2D, 6, 5);
        solve2DAssert(myMaze2D, 5, 6);
        solve2DAssert(myMaze2D, 111, 111);
        solve2DAssert(myMaze2D, 1000, 1000);

    }

    private void solve2DAssert(IMazeGenerator mazeGenerator, int row, int column)
    {
        best = new BestFirstSearch();
        maze = mazeGenerator.generate(row, column);
        searchableMaze = new SearchableMaze(maze);
        Solution solution = best.solve(searchableMaze);
        ArrayList<AState> solutionPath = solution.getSolutionPath();
        assert maze.getStartPosition().toString().equals(solutionPath.get(0).toString());
        assert maze.getGoalPosition().toString().equals( solutionPath.get(solutionPath.size()-1).toString());

    }

    // testing generate and start & goal positions are correct in the solution of empty Maze
    @Test
    public void solveEmptyMaze()
    {
        best = new BestFirstSearch();
        EmptyMazeGenerator myEmptyMaze = new EmptyMazeGenerator();
        Maze emptyMaze = myEmptyMaze.generate(1000,1000);
        searchableMaze = new SearchableMaze(emptyMaze);
        Solution solveEmptyMaze = best.solve(searchableMaze);
        ArrayList<AState> solution = solveEmptyMaze.getSolutionPath();
        Assertions.assertEquals(emptyMaze.getGoalPosition().toString(),solution.get(solution.size()-1).toString());
        Assertions.assertEquals(emptyMaze.getStartPosition().toString(),solution.get(0).toString());
    }

    // testing generate and start & goal positions are correct in the solution of simple Maze
    @Test
    public void solveSimpleMaze()
    {

        best = new BestFirstSearch();
        SimpleMazeGenerator mySimpleMaze = new SimpleMazeGenerator();
        Maze simpleMaze = mySimpleMaze.generate(1000,1000);
        searchableMaze = new SearchableMaze(simpleMaze);
        Solution solveEmptyMaze = best.solve(searchableMaze);
        ArrayList<AState> solution = solveEmptyMaze.getSolutionPath();
        Assertions.assertEquals(simpleMaze.getGoalPosition().toString(),solution.get(solution.size()-1).toString());
        Assertions.assertEquals(simpleMaze.getStartPosition().toString(),solution.get(0).toString());

    }

    // testing generate and start & goal positions are correct in the solution of my Maze
    @Test
    public void solveMyMaze()
    {
        best = new BestFirstSearch();
        MyMazeGenerator myMyMaze = new MyMazeGenerator();
        Maze myMaze = myMyMaze.generate(1000,1000);
        searchableMaze = new SearchableMaze(myMaze);
        Solution solveMaze = best.solve(searchableMaze);
        ArrayList<AState> solution = solveMaze.getSolutionPath();
        Assertions.assertEquals(myMaze.getGoalPosition().toString(),solution.get(solution.size()-1).toString());
        Assertions.assertEquals(myMaze.getStartPosition().toString(),solution.get(0).toString());
    }

    @Test
    void solveInMinute() {
        BestFirstSearch BFS = new BestFirstSearch();

        MyMazeGenerator myMaze = new MyMazeGenerator();
        Maze maze = myMaze.generate(1000, 1000);
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        long before = System.currentTimeMillis();
        BFS.solve(searchableMaze);
        long time = System.currentTimeMillis() - before;
        Assertions.assertTrue(time <= 60000);
    }


    @Test
    public void solving3DMazes() {
        solving3DAssert(2 ,2,2);
        solving3DAssert(2 ,3,2);
        solving3DAssert(3 ,3,3);
        solving3DAssert(57 ,61,4);
        solving3DAssert(2 ,61,41);
        solving3DAssert(100 ,100,100);
    }

    public void solving3DAssert(int dep ,int row,int col)
    {

        ISearchingAlgorithm best = new BestFirstSearch();
        IMaze3DGenerator IMaze3DGenerator = new MyMaze3DGenerator();
        Maze3D maze = IMaze3DGenerator.generate(dep, row, col);
        SearchableMaze3D sm = new SearchableMaze3D(maze);
        Solution s = best.solve(sm);
        AState blank = null;
        assert s != null;
        assert s.getSolutionPath().size() >= 1;
        assert s.getSolutionPath().contains(new Maze3DState(maze.getGoalPosition(), 0, blank));
    }
}