package week2_Percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private enum Site { BLOCKED, OPEN }

    private final Site[][] grid;
    private final WeightedQuickUnionUF uf;
    private final WeightedQuickUnionUF ufNoBottom;

    private final int virtualStartRoot;
    private final int virtualEndRoot;

    private int numberOfOpenSites = 0;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException();

        uf = new WeightedQuickUnionUF(n * n + 2);
        ufNoBottom = new WeightedQuickUnionUF(n * n + 2);

        virtualStartRoot = n * n;
        virtualEndRoot = n * n + 1;

        grid = new Site[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = Site.BLOCKED;
            }
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (isOpen(row, col))
            return;

        grid[row - 1][col - 1] = Site.OPEN;
        numberOfOpenSites++;

        connectToNeighbors(row, col);
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (!isWithinBounds(row, col))
            throw new IllegalArgumentException();

        return grid[row - 1][col - 1] == Site.OPEN;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (!isWithinBounds(row, col))
            throw new IllegalArgumentException();

        return ufNoBottom.find(xyTo1D(row, col)) == ufNoBottom.find(virtualStartRoot);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.find(virtualStartRoot) == uf.find(virtualEndRoot);
    }

    // region Private methods
    private int xyTo1D(int row, int col) {
        return ((row - 1) * grid.length) + (col - 1);
    }

    private void connectToNeighbors(int row, int col) {
        if (row == 1) connectToVirtualTop(row, col);
        if (row == grid.length) connectToVirtualBottom(row, col);

        connectIfOpen(row, col, row - 1, col); //  Top
        connectIfOpen(row, col, row + 1, col); //  Bottom
        connectIfOpen(row, col, row, col - 1); //  Left
        connectIfOpen(row, col, row, col + 1); //  Right
    }

    private void connectToVirtualTop(int row, int col) {
        uf.union(xyTo1D(row, col), virtualStartRoot);
        ufNoBottom.union(xyTo1D(row, col), virtualStartRoot);
    }

    private void connectToVirtualBottom(int row, int col) {
        uf.union(xyTo1D(row, col), virtualEndRoot);
    }

    private void connectIfOpen(
        int row,
        int col,
        int neighborRow,
        int neighborCol
    ) {
        if (isWithinBounds(neighborRow, neighborCol) &&
            grid[neighborRow - 1][neighborCol - 1] != Site.BLOCKED
        ) {
            uf.union(xyTo1D(row, col), xyTo1D(neighborRow, neighborCol));
            ufNoBottom.union(xyTo1D(row, col), xyTo1D(neighborRow, neighborCol));
        }
    }

    private boolean isWithinBounds(int row, int col) {
        return row > 0 && row <= grid.length && col > 0 && col <= grid.length;
    }
    // endregion
}
