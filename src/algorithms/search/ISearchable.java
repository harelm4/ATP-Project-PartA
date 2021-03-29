package algorithms.search;

import java.util.ArrayList;

public interface ISearchable
{
    /**
     * This method return the initial situation from which we want to begin to search.
     *
     * @return algorithms.search.AState
     */
    AState getStartPosition();


    /**
     * This method return the goal situation we want to reach.
     *
     * @return algorithms.search.AState
     */
    AState getGoalPosition();


    /**
     * This method return a list of legal states that can be reached from the current state.
     * @param state is the current state.
     * @return ArrayList<algorithms.search.AState>
     */
    ArrayList<AState> getAllPossibleStates(AState state);
}
