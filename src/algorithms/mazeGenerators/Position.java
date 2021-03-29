package algorithms.mazeGenerators;

public class Position
{
    private int rowIndex;
    private int colIndex;

    /**
     * Constructor
     *
     * @param row - row index
     * @param col - column index
     */
    public Position(int row, int col)
    {
        rowIndex = row;
        colIndex = col;
    }

    public int getColumnIndex() { return colIndex; }

    public int getRowIndex() { return rowIndex; }

    /**
     * This function compare 2 positions
     * @param other
     * @return true if equals, false else
     */
    @Override
    public boolean equals(Object other) {
        return this.colIndex == ((Position) other).getColumnIndex() && this.rowIndex == ((Position) other).getRowIndex();
    }

    @Override
    public String toString() { return "{" + rowIndex + "," + colIndex + "}"; }
}
