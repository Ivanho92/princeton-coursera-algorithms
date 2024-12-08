package mod05_elementary_sorts.exercises;

public class DutchNationalFlag {
    public static final int RED = 0;
    public static final int WHITE = 1;
    public static final int BLUE = 2;

    private final int n;
    private final int[] buckets;

    private int callsColor = 0;
    private int callsSwap = 0;


    public DutchNationalFlag(int[] buckets) {
        this.n = buckets.length;
        this.buckets = buckets;
    }

    public void sort() {
        int current = 0;
        int low = 0;
        int high = n - 1;

        while (current <= high) {
            switch (color(current)) {
                case RED:
                    swap(current, low);
                    low++;
                    current++;
                    break;
                case WHITE:
                    current++;
                    break;
                case BLUE:
                    swap(current, high);
                    high--;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    private void swap(int i, int j) {
        callsSwap++;

        int temp = buckets[i];
        buckets[i] = buckets[j];
        buckets[j] = temp;
    }

    private int color(int i) {
        callsColor++;

        return buckets[i];
    }

    public int callsColor() {
        return callsColor;
    }

    public int callsSwap() {
        return callsSwap;
    }
}
