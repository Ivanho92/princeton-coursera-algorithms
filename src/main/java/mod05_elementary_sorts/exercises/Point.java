package mod05_elementary_sorts.exercises;

import java.util.Objects;

public class Point implements Comparable<Point> {
    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Point that) {
        if (this.x < that.x) return -1;
        else if (this.x > that.x) return 1;
        else return this.y - that.y;
    }
}
