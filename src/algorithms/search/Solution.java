package algorithms.search;

import java.util.ArrayList;

/**
 *  This class defines result of a algorithms.search in a way
 *  that we can save and go over the states that bring us to the goal state.
 *  A legal sequence of states from start state to goal state.
 *
 * @author Eden_Hai
 * @version 1.0
 * @since 29-03-2021
 */
public class Solution
{
    private ArrayList<AState> path;

    public Solution(ArrayList<AState> path) { this.path = path; }

    public ArrayList<AState> getSolutionPath() {return this.path == null ? new ArrayList<AState>() : this.path;}
}
