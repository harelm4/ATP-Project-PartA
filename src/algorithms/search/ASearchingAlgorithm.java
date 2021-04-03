package algorithms.search;

/**
 * An abstract class of algorithms.search algorithms that provides a common functions.
 *
 * @author Eden_Hai
 * @version 1.0
 * @since 29-03-2021
 */
public abstract class ASearchingAlgorithm implements ISearchingAlgorithm
{
    protected int visitedNodes; // how many nodes we are evaluated by the algorithm

    @Override
    public abstract Solution solve(ISearchable domain);

    @Override
    public int getNumberOfNodesEvaluated() {return this.visitedNodes;}
}
