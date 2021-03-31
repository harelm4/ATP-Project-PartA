
package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm
{
    @Override
    public String getName() {return "Depth First Search";}

    @Override
    public Solution solve(ISearchable domain) {
        Stack<AState> stack = new Stack<AState>();
        ArrayList<AState> visited = new ArrayList<AState>();
        visited.add(domain.getStartPosition());
        stack.push(domain.getStartPosition());
        AState cur=null;
        Random r = new Random();
        ArrayList<AState>  neighbors;
        AState tmp;
        while(!stack.isEmpty() ){
            cur = stack.pop();
            if (cur == domain.getGoalPosition()){
                break;
            }
            neighbors =domain.getAllSuccessors(cur);
            if (!neighbors.isEmpty() && !visited.containsAll(neighbors)){
                stack.push(cur);
                tmp =neighbors.get(r.nextInt(neighbors.size()));
                for (AState s:neighbors) {
                    if(!s.equals(tmp)){
                        visited.add(s);
                        stack.push(s);
                        s.setCameFrom(cur);
                    }

                }
                tmp.setCameFrom(cur);
                visited.add(tmp);
                stack.push(tmp);

            }

        }
        ArrayList<AState> solPath = new ArrayList<AState>();
        while(cur.getCameFrom() != null){
            solPath.add(cur);
            cur = cur.getCameFrom();
        }
        solPath.add(cur);
        return new Solution(solPath);

    }
}

