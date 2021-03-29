package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState
{
    Position curPosition;

    /**
     * Constructor
     *
     * @param curPosition - current position
     * @param cost - cost to reach this state
     * @param parent - patent state
     */
    public MazeState(Position curPosition, double cost, AState parent)
    {
        super(curPosition.toString(), cost, parent);
        this.curPosition = curPosition;
    }

    public Position getPosition() { return curPosition; }

    @Override
    public String toString() { return curPosition.toString(); }
}
