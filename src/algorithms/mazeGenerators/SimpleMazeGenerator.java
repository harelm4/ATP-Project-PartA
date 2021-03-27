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
        ArrayList<Position> wlist = new ArrayList<Position>();
        ArrayList<Position> mlist = new ArrayList<Position>();
        ArrayList<Position> nlist = new ArrayList<Position>();
        Position neighbor;
        Random ran = new Random();
        m.makeAllWalls();
        m.breakWall(start.getRowIndex(),start.getColIndex());
        mlist.add(start);
        wlist= m.getAllNeighbors(start);
        neighbor = wlist.get( ran.nextInt(wlist.size()) );

        while(!neighbor.equals(m.getGoalPosition())){

            m.breakWall(neighbor.getRowIndex(),neighbor.getColIndex());
            mlist.add(neighbor);
            wlist.removeAll(wlist);
            wlist=m.getAllNeighbors(neighbor);
            for (Position p:nlist){
                if(!mlist.contains(p)){
                    wlist.add(p);
                }
            }

            neighbor = wlist.get( ran.nextInt(wlist.size()) );

//            if (!mlist.contains(neighbor)){
//                m.breakWall(neighbor.getRowIndex(),neighbor.getColIndex());
//                mlist.add(neighbor);
//                nlist=m.getAllNeighbors(neighbor);
//
//            }
//            else{
//                wlist.remove(neighbor);
//            }

        }
        return m;
    }
}
