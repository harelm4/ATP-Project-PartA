package algorithms.search;

import java.util.*;

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
        // 2      let Q be a queue
        // 3      label root as discovered
        // 4      Q.enqueue(root)
        ArrayDeque<AState> queue = new ArrayDeque<AState>();
        Hashtable<String,AState> discovered = new Hashtable<String,AState>();
        discovered.put((domain.getStartPosition()).toString(),domain.getStartPosition());
        queue.add(domain.getStartPosition());
        AState cur=null;
        ArrayList<AState> neighbors = new ArrayList<AState>();
        while (!queue.isEmpty()){
            //v := Q.dequeue()
            cur = queue.removeFirst();
            // 7          if v is the goal then
            // 8              return v
            if (cur.equals(domain.getGoalPosition())){
                break;
            }
            neighbors = domain.getAllSuccessors(cur);
            // 9          for all edges from v to w in G.adjacentEdges(v) do
            //10              if w is not labeled as discovered then
            //11                  label w as discovered
            //12                  Q.enqueue(w)
            for (AState n:
                 neighbors) {
                if(!discovered.containsKey(n.toString())){
                    discovered.put(n.toString(),n);
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
        solPath.add(cur);
        Collections.reverse(solPath);
        visitedNodes=discovered.size();
        return new Solution( solPath);

    }
}
