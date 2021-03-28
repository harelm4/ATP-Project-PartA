package algorithms.mazeGenerators;


import java.util.ArrayList;
import java.util.Random;

public class SimpleMazeGenerator extends AMazeGenerator {

    /**
     * @param rowSize
     * @param colSize
     * @return
     * generates a random walls maze
     */
    @Override
    public Maze generate(int rowSize, int colSize) {
        if(rowSize<=0 || colSize<=0 ){
            return null;
        }
        Position start = new Position(0,0);
        Position end = new Position(rowSize-1,colSize-1);
        Maze m = new Maze(rowSize,colSize,start,end);
        if(!m.isPositionOnEdges(start)||!m.isPositionOnEdges(end)){
            return null;
        }
        Random rand =new Random();
        ArrayList<Position> nnlist = new ArrayList<Position>();//temp neighbors neighbor list
        ArrayList<Position> mlist = new ArrayList<Position>();//list of visited cells
        ArrayList<Position> nlist = new ArrayList<Position>();//list of neighbors to choose from
        Random ran = new Random();
        m.makeAllWalls();
        m.breakWall(start.getRowIndex(),start.getColumnIndex());
        mlist.add(start);
        nlist= m.getRightDownNeighbors(start);
        Position neighbor;
        int i;
        while(!mlist.contains(end)&& nlist.size()!=0) {
            i = ran.nextInt(nlist.size());
            if (i<0){
                break;
            }
            neighbor = nlist.get(i);
            mlist.add(neighbor);
            m.breakWall(neighbor.getRowIndex(),neighbor.getColumnIndex());
            nlist = m.getRightDownNeighbors(neighbor);

        }

        return m;
    }
}
