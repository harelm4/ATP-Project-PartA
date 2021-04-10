package algorithms.search;

import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BestFirstSearchTest
{
    @Test
    public void MazeSizeTest()
    {
        IMazeGenerator iMazeGenerator = new MyMazeGenerator();
        Maze maze = iMazeGenerator.generate(10,10);
        assertEquals(maze.getRowSize(), 10);
    }

    @Test
    public void NullTest()
    {
        ISearchingAlgorithm best = new BestFirstSearch();
        assertNull(best.solve(null));
    }

    @Test
    public void GetNameTest()
    {
        ISearchingAlgorithm best = new BestFirstSearch();
        assertEquals("BestFirstSearch", best.getName());
    }


}