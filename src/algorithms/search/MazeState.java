package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

public class MazeState extends AState{
    Position curPosition;

    /**
     * Constructor
     *
     * @param state    - the state represented by string
     * @param cost     -  cost to reach this state
     * @param cameFrom - patent state
     *
     *
     */
    public MazeState(String state, double cost, AState cameFrom) {
        super(state,cost,cameFrom);
        String Srow="",Scol="";
        int tmp=0;
        for (int i=0;i<=state.length();i++){
            if (state.indexOf(i) == ','){
                tmp=i;
                break;
            }
            if (state.indexOf(i) != '{'){
                Srow+= state.indexOf(i);
            }

        }
        for (int j=tmp+1;j<=state.length();j++){
            if (state.indexOf(j) == '}'){
                break;
            }
            Scol+= state.indexOf(j);

        }
        int row=Integer.parseInt(Srow),col=Integer.parseInt(Scol);
        curPosition = new Position(row,col);

    }

}
