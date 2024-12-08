package mod05_elementary_sorts.exercises;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IntersectionTest {

    @Test
    void testIntersection() {
        Intersection intersection = new Intersection();

        Point[] arrA = {
            new Point(7, 8), new Point(3, 3), new Point(8, 10),
            new Point(5, 5), new Point(1, 2), new Point(0, 0),
            new Point(6, 7), new Point(4, 4), new Point(2, 2)
        };

        Point[] arrB = {
            new Point(3, 5), new Point(2, 2), new Point(4, 6),
            new Point(5, 5), new Point(7, 8), new Point(1, 1),
            new Point(9, 11), new Point(2, 1), new Point(1, 3),
            new Point(1, 2), new Point(0, 2)
        };

        int result = intersection.count(arrA, arrB);
        assertThat(result).isEqualTo(4);
    }

    @Test
    void testEmptyArrays() {
        Intersection intersection = new Intersection();
        Point[] arrA = {};
        Point[] arrB = {};
        int result = intersection.count(arrA, arrB);
        assertThat(result).isZero();
    }

    @Test
    void testNoIntersection() {
        Intersection intersection = new Intersection();
        Point[] arrA = { new Point(1, 1), new Point(2, 2), new Point(3, 3) };
        Point[] arrB = { new Point(4, 4), new Point(5, 5), new Point(6, 6) };
        int result = intersection.count(arrA, arrB);
        assertThat(result).isZero();
    }

    @Test
    void testFullIntersection() {
        Intersection intersection = new Intersection();
        Point[] arrA = { new Point(1, 1), new Point(2, 2), new Point(3, 3) };
        Point[] arrB = { new Point(1, 1), new Point(2, 2), new Point(3, 3) };
        int result = intersection.count(arrA, arrB);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void testPartialIntersection() {
        Intersection intersection = new Intersection();
        Point[] arrA = { new Point(1, 1), new Point(2, 2), new Point(3, 3) };
        Point[] arrB = { new Point(2, 2), new Point(3, 3), new Point(4, 4) };
        int result = intersection.count(arrA, arrB);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void testSinglePointIntersection() {
        Intersection intersection = new Intersection();
        Point[] arrA = { new Point(1, 1) };
        Point[] arrB = { new Point(1, 1) };
        int result = intersection.count(arrA, arrB);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void testDisjointWithDifferentLengths() {
        Intersection intersection = new Intersection();
        Point[] arrA = { new Point(1, 1), new Point(2, 2) };
        Point[] arrB = { new Point(3, 3), new Point(4, 4), new Point(5, 5) };
        int result = intersection.count(arrA, arrB);
        assertThat(result).isZero();
    }

    @Test
    void testIntersectWithDifferentLengths() {
        Intersection intersection = new Intersection();
        Point[] arrA = { new Point(1, 1), new Point(2, 2), new Point(3, 3) };
        Point[] arrB = { new Point(2, 2), new Point(4, 4) };
        int result = intersection.count(arrA, arrB);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void testIntersectOutOfOrder() {
        Intersection intersection = new Intersection();
        Point[] arrA = { new Point(3, 3), new Point(1, 1), new Point(2, 2) };
        Point[] arrB = { new Point(2, 2), new Point(3, 3), new Point(1, 1) };
        int result = intersection.count(arrA, arrB);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void testIntersectOnEdgeCases() {
        Intersection intersection = new Intersection();
        Point[] arrA = { new Point(0, 0), new Point(1000000, 1000000) };
        Point[] arrB = { new Point(1000000, 1000000), new Point(-1000000, -1000000) };
        int result = intersection.count(arrA, arrB);
        assertThat(result).isEqualTo(1);
    }
}

