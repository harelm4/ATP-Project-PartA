package algorithms.maze3D;

import algorithms.mazeGenerators.Position;

public class Position3D {
    private int rowIndex;
    private int colIndex;
    private int depthIndex;


    /**
     * Constructor
     *
     * @param row - row index
     * @param col - column index
     */
    public Position3D(int row, int col,int dep)
    {
        rowIndex = row;
        colIndex = col;
        depthIndex=dep;
    }

    public int getColumnIndex() { return colIndex; }
    public int getRowIndex() { return rowIndex; }
    public int getDepthIndex() { return depthIndex; }

    /**
     * This function compare 2 positions
     * @param other
     * @return true if equals, false else
     */
    @Override
    public boolean equals(Object other) {
        return this.colIndex == ((Position3D) other).getColumnIndex() && this.rowIndex == ((Position3D) other).getRowIndex() && depthIndex==((Position3D)other).depthIndex;
    }

    @Override
    public String toString() { return "{" + rowIndex + "," + colIndex +","+depthIndex+ "}"; }





}
