package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator {


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
        return m;

    }


}
