package algorithms.search;

public interface ISearchingAlgorithm
{
    /**
     * This method algorithms.search for a legal sequence of states from start state to goal state on domain.
     * @param domain is a searchable object on which we will run a algorithms.search
     * @return the solution - algorithms.search.Solution
     * @see Solution
     */
    Solution solve(ISearchable domain);


    /**
     * This method return the numbers of nodes that have been evaluated during the search.
     * @return int
     */
    int getNumberOfNodesEvaluated();


    /**
     * @return the name of the algorithm
     */
    String getName();
}
