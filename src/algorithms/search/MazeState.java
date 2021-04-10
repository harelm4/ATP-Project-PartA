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
    public MazeState(Position curPosition, int cost, AState parent)
    {
        super(cost, parent);
        this.curPosition = curPosition;
    }

    public Position getPosition() { return curPosition; }

    public void setPosition(Position curPosition) { this.curPosition = curPosition;}

    @Override
    public String toString() { return curPosition.toString(); }

    /**
     * Compare between two mazeStates based on the position
     * @param o - the other mazeState to check equality with
     * @return true if equals; otherwise false
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MazeState mazeState = (MazeState) o;
        return mazeState.getPosition().equals(curPosition);
    }
}
