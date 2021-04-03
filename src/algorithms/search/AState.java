package algorithms.search;

/**
 * An abstract class representing a state in a searchable problem.
 *
 * @author Eden_Hai
 * @version 1.0
 * @since 29-03-2021
 */
public abstract class AState
{
    //should be protected because its an abstract class
    protected String state;
    protected double cost;
    private AState cameFrom;

    /**
     * Constructor
     * @param state - the state represented by string
     * @param cost -  cost to reach this state
     * @param cameFrom - patent state
     */
    public AState(String state, double cost, AState cameFrom)
    {
        this.state = state;
        this.cost = cost;
        this.cameFrom = cameFrom;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public AState getCameFrom() {
        return cameFrom;
    }

    public void setCameFrom(AState cameFrom) {
        this.cameFrom = cameFrom;
    }

    public abstract boolean equals(Object o);
}
