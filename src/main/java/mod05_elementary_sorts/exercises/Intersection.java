package mod05_elementary_sorts.exercises;

import mod05_elementary_sorts.sandbox.Shell;
import mod05_elementary_sorts.sandbox.SortAlgorithm;

public class Intersection {

    SortAlgorithm shell = new Shell();

    public int count(Point[] a, Point[] b) {
        shell.sort(a);
        shell.sort(b);

        int last = 0;
        int count = 0;

        for (Point point : a) {
            for (int i = last; i < b.length; i++) {
                if (point.equals(b[i])) {
                    count++;
                    last = i+1;
                    break;
                } else if (point.x < b[i].x) {
                    last = i;
                    break;
                }
            }
        }

        return count;
    }
}
