package algorithms.search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BreadthFirstSearch extends ASearchingAlgorithm
{

    @Override
    public String getName() {return "Breadth First Search";}

    /**
     * @param domain
     * @return
     * BFS implementation when the vertexes are the cells and there are edges between every cell to another if there is a path
     * between them
     */
    @Override
    public Solution solve(ISearchable domain) {
        ArrayDeque<AState> queue = new ArrayDeque<AState>();
        ArrayList<AState> discovered = new ArrayList<AState>();
        discovered.add(domain.getStartPosition());
        queue.add(domain.getStartPosition());
        AState cur=null;
        ArrayList<AState> neighbors = new ArrayList<AState>();
        while (!queue.isEmpty()){
            cur = queue.getFirst();
            if (cur == domain.getGoalPosition()){
                break;
            }
            for (AState n:
                 neighbors) {
                if(!discovered.contains(n)){
                    discovered.add(n);
                    queue.addLast(n);
                    n.setCameFrom(cur);
                }

            }

        }
        ArrayList<AState> solPath = new ArrayList<AState>();
        while(cur.getCameFrom()!=null){
            solPath.add(cur);
            cur =cur.getCameFrom();

        }
        return new Solution(solPath);

    }
}
