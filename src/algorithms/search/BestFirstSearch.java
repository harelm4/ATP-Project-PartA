package algorithms.search;

import java.util.*;

public class BestFirstSearch extends ASearchingAlgorithm
{
    @Override
    public String getName() {return "Best First Search";}

/**
 * pseudo code for BFS:
  Until PriorityQueue is empty
              u = PriorityQueue.DeleteMin
              If u is the goal
                 Exit
              Else
                 Foreach neighbor v of u
                    If v "Unvisited"
                        Mark v "Visited"
                        pq.insert(v)
                 Mark u "Examined"
    End procedure
    **/

    @Override
    public Solution solve(ISearchable domain) {
        //Create an empty PriorityQueue
        PriorityQueue<AState>  pq = new PriorityQueue<>(new Comparator<AState>() {
            @Override
            public int compare(AState o1, AState o2) {
                return (int)(((AState)o1).getCost()-((AState)o2).getCost());
            }
        });
        Hashtable<String,AState> visited = new Hashtable<String,AState>();
        pq.add(domain.getStartPosition());
        AState cur=null;
        ArrayList<AState> neighbors = new ArrayList<AState>();
        while (!pq.isEmpty()){

            cur =pq.poll();
            if (cur.equals(domain.getGoalPosition())){
                break;
            }
            neighbors=domain.getAllSuccessors(cur);
            for(AState a: neighbors){
                if(!visited.containsKey(a.toString())){
                    visited.put(a.toString(),a);
                    pq.add(a);
                    a.setCameFrom(cur);
                }

            }

            visited.put(cur.toString(),cur);

        }

        ArrayList<AState> solPath = new ArrayList<AState>();
        while(cur.getCameFrom()!=null){
            solPath.add(cur);
            cur =cur.getCameFrom();

        }
        solPath.add(cur);
        Collections.reverse(solPath);
        visitedNodes=visited.size();
        return new Solution( solPath);
    }
}