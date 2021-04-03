package algorithms.maze3D;

public abstract class AMaze3DGenerator implements IMazeGenerator3D{

    /**
     * @param row
     * @param column
     * @param depth
     * @return the duration of generating a maze
     */
    @Override
    public long measureAlgorithmTimeMillis( int row, int column,int depth) {

        if(row<=0 || column<=0 || depth<=0 ){
            return 0;
        }
        long t = System.currentTimeMillis();
        generate(row,column,depth);
        return (System.currentTimeMillis() - t);
    }
}
