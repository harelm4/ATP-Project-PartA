package algorithms.mazeGenerators;

public interface IMazeGenerator {

    public Maze generate(int rowSize,int colSize);
    public long measureAlgorithmTimeMillis(int rowSize,int colSize);
}
