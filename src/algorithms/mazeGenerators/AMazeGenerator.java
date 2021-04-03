package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator
{
    public abstract Maze generate(int rowSize, int colSize);

    /**
     * @param rowSize
     * @param colSize
     * @return the duration of generating a maze
     */
    public long measureAlgorithmTimeMillis(int rowSize, int colSize){
        if(rowSize<=0 || colSize<=0 ){
            return 0;
        }
        long t = System.currentTimeMillis();
        generate(rowSize,colSize);
        return (System.currentTimeMillis() - t);
    }
}
