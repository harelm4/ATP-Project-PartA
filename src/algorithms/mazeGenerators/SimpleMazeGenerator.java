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
        ArrayList<Position> list = new ArrayList<Position>();
        Position neighbor;

        m.makeAllWalls();
        m.breakWall(start.getRowIndex(),start.getColIndex());
        list.add(start);
        boolean isEnd=false;
        while (!isEnd){
            neighbor=list.get(rand.nextInt(list.size())).getRandomNeighbor();
            if(m.isPositionInRange(neighbor)){
                m.breakWall(neighbor.getRowIndex(),neighbor.getColIndex());
                list.add(neighbor);
            }
            if(neighbor.getRowIndex()==end.getRowIndex() && neighbor.getColIndex()==neighbor.getColIndex()){
                isEnd=true;
            }

        }







    }
}
