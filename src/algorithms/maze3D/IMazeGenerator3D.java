package algorithms.maze3D;

public interface IMazeGenerator3D {
    /**
     * @param row -row size of the maze
     * @param column -column size of the maze
     * @param depth - -deph size of the maze
     * @return a 3D randomly generated maze
     */
    Maze3D generate(int row, int column,int depth);

    /**
     * @param depth
     * @param row
     * @param column
     * @return the duration of generating a maze
     */
    long measureAlgorithmTimeMillis(int depth, int row, int column);
}
