package algorithms.maze3D;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;
import algorithms.search.AState;
import algorithms.search.ISearchable;
import algorithms.search.MazeState;

import java.util.ArrayList;

public class SearchableMaze3D implements ISearchable {
    private Maze3D maze;

    /**
     * Constructor
     *
     * @param maze
     */
    public SearchableMaze3D(Maze3D maze) { this.maze = maze; }

    @Override
    public AState getStartPosition() { return maze.getStartPosition() == null ? null : new Maze3DState(maze.getStartPosition(), 0, null); }

    @Override
    public AState getGoalPosition() { return maze.getGoalPosition() == null ? null : new Maze3DState(maze.getGoalPosition(), 0, null); }

    /**
     * returns a list of all neighbors that curState can reach (0s)
     */
    @Override
    public ArrayList<AState> getAllSuccessors(AState curState)
    {
        if (!(curState instanceof Maze3DState)) return null;

        Maze3DState state = (Maze3DState) curState;
        ArrayList<AState> allPossibleState = new ArrayList<>();
        int row = state.getPosition().getRowIndex();
        int col = state.getPosition().getColumnIndex();
        int dep =state.getPosition().getDepthIndex();
        boolean up,right_up,right,right_down,down,left_down,left,left_up,in,out;
         up = isMoveValid(row - 1, col,dep);
        if (up) { allPossibleState.add(new Maze3DState(new Position3D(row - 1, col,dep), curState.getCost() + 10, curState)); }

        right_up = isMoveValid(row - 1, col + 1,dep);
        if (right_up) { allPossibleState.add(new Maze3DState(new Position3D(row - 1, col + 1,dep), curState.getCost() + 15, curState)); }

        right = isMoveValid(row, col + 1,dep);
        if (right) { allPossibleState.add(new Maze3DState(new Position3D(row, col + 1,dep), curState.getCost() + 10, curState)); }

        right_down = isMoveValid(row + 1, col + 1,dep);
        if (right_down) { allPossibleState.add(new Maze3DState(new Position3D(row + 1, col + 1,dep), curState.getCost() + 15, curState)); }

        down = isMoveValid(row + 1, col,dep);
        if (down) { allPossibleState.add(new Maze3DState(new Position3D(row + 1, col,dep), curState.getCost() + 10, curState)); }

        left_down = isMoveValid(row + 1, col - 1,dep);
        if (left_down) { allPossibleState.add(new Maze3DState(new Position3D(row + 1, col - 1,dep), curState.getCost() + 15, curState)); }

        left = isMoveValid(row, col - 1,dep);
        if (left) { allPossibleState.add(new Maze3DState(new Position3D(row, col - 1,dep), curState.getCost() + 10, curState)); }

        left_up = isMoveValid(row - 1, col - 1,dep);
        if (left_up) { allPossibleState.add(new Maze3DState(new Position3D(row - 1, col - 1,dep), curState.getCost() + 15, curState)); }


        in = isMoveValid(row, col - 1,dep+1);
        if (in) { allPossibleState.add(new Maze3DState(new Position3D(row, col ,dep+1), curState.getCost() + 10, curState)); }

        out = isMoveValid(row - 1, col - 1,dep-1);
        if (out) { allPossibleState.add(new Maze3DState(new Position3D(row , col ,dep-1), curState.getCost() + 10, curState)); }


        return allPossibleState;
    }

    /**
     *
     * @param row
     * @param col
     * @param dep
     * @return true if there is a 0 in this position
     */
    private boolean isMoveValid(int row, int col,int dep)
    {
        try { return maze.getMaze()[row][col][dep] == 0; }
        catch (Exception e) { return false; }
    }






}
