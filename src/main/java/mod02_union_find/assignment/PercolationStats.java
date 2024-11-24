package mod02_union_find.assignment;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
// import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {

    private static final double CONFIDENCE_95 = 1.96;

    private final int trials;
    private final double[] percThresholds;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException();

        this.trials = trials;
        this.percThresholds = new double[trials];

        for (int i = 0; i < trials; i++) {
            Percolation perc = new Percolation(n);

            while (!perc.percolates()) {
                int row;
                int col;

                do {
                    row = StdRandom.uniformInt(1, n+1);
                    col = StdRandom.uniformInt(1, n+1);
                } while (perc.isOpen(row, col));

                perc.open(row, col);
            }

            percThresholds[i] = (double) perc.numberOfOpenSites() / (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(percThresholds);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(percThresholds);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - ((CONFIDENCE_95*stddev()) / Math.sqrt(trials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + ((CONFIDENCE_95*stddev()) / Math.sqrt(trials));
    }

    // ----------------------------------------------------------------------
    public static void main(String[] args) {
            int n = Integer.parseInt(args[0]);
            int trials = Integer.parseInt(args[1]);

            // Stopwatch watch = new Stopwatch();

            PercolationStats stats = new PercolationStats(n, trials);
            StdOut.println("mean = " + stats.mean());
            StdOut.println("stddev = " + stats.stddev());
            StdOut.println("95% confidence interval = [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");

            // StdOut.println(watch.elapsedTime());
    }
}
