package algorithms.maze3D;

import algorithms.mazeGenerators.Position;
import algorithms.search.AState;
import algorithms.search.MazeState;

public class Maze3DState extends AState {

    Position3D curPosition;

    /**
     * Constructor
     *
     * @param curPosition - current position
     * @param cost - cost to reach this state
     * @param parent - patent state
     */
    public Maze3DState(Position3D curPosition, double cost, AState parent)
    {
        super(curPosition.toString(), cost, parent);
        this.curPosition = curPosition;
    }

    public Position3D getPosition() { return curPosition; }

    @Override
    public String toString() { return curPosition.toString(); }

    @Override
    public boolean equals(Object o) {
        if (o==null)return false;
        Maze3DState m = (Maze3DState) o;
        if ( m.getPosition().equals(curPosition)){
            return true;
        }
        return false;
    }
}
