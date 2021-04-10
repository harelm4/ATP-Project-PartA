package algorithms.mazeGenerators;

/**
 * This class responsible to generate an instance of a maze
 *
 * @author Eden_Hai
 * @version 1.0
 * @since 29-03-2021
 */
public abstract class AMazeGenerator implements IMazeGenerator
{
    @Override
    public abstract Maze generate(int rowSize, int colSize);

    @Override
    public long measureAlgorithmTimeMillis(int rowSize, int colSize)
    {
        if (rowSize < 2 || colSize < 2) { return 0; }

        long before = System.currentTimeMillis();
        generate(rowSize, colSize);
        long after = System.currentTimeMillis();
        long result = after - before;
        return result;
    }
}
