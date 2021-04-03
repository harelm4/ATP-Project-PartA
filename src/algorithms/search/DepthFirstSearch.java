
package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.*;

public class DepthFirstSearch extends ASearchingAlgorithm
{
    @Override
    public String getName() {return "Depth First Search";}

    /**
     * DFS scanto find path in a Searchable object
     * @param domain
     * @return
     */
    @Override
    public Solution solve(ISearchable domain) {
        Stack<AState> stack = new Stack<AState>();
        Hashtable<String,AState> visited = new Hashtable<String, AState>();
        //add the start node in the stack and mark as visited.
        visited.put(domain.getStartPosition().toString(),domain.getStartPosition());
        stack.push(domain.getStartPosition());
        AState cur=null;
        Random r = new Random();
        ArrayList<AState>  neighbors;
        AState tmp;
        while(!stack.isEmpty() ){
            // Take the node at the top of the stack.
            cur = stack.pop();
            if (cur.equals(domain.getGoalPosition())){
                break;
            }
            neighbors =domain.getAllSuccessors(cur);
            if (!visited.contains(cur)){
                visited.put(cur.toString(),cur);
            }
            for(AState a:neighbors){
                if (!visited.containsKey(a.toString())){
                    stack.push(a);
                    a.setCameFrom(cur);
                    visited.put(a.toString(),a);
                }

            }
            }


        ArrayList<AState> solPath = new ArrayList<AState>();
        while(!cur.equals(null)){
            solPath.add(cur);
            cur = cur.getCameFrom();
            if(cur == null){
                break;
            }
        }
        solPath.add(cur);
        Collections.reverse(solPath);
        visitedNodes=visited.size();
        return new Solution( solPath);


    }
}

