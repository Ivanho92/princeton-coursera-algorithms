package week3_Queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<T> implements Iterable<T> {

    // construct an empty deque
    public Deque() {}

    // is the deque empty?
    public boolean isEmpty() {
        return true;
    }

    // return the number of items on the deque
    public int size() {
        return 0;
    }

    // add the item to the front
    public void addFirst(T item) {
        if (item == null)
            throw new IllegalArgumentException("Cannot add null item");

    }

    // add the item to the back
    public void addLast(T item) {
        if (item == null)
            throw new IllegalArgumentException("Cannot add null item");


    }

    // remove and return the item from the front
    public T removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException("Cannot remove from empty deque");

        return null;
    }

    // remove and return the item from the back
    public T removeLast() {
        if (isEmpty())
            throw new NoSuchElementException("Cannot remove from empty deque");

        return null;
    }

    // return an iterator over items in order from front to back
    public Iterator<T> iterator() {
        // Throw a java.util.NoSuchElementException if the client calls the
        // next() method in the iterator when there are no more items to return.

        // Throw an UnsupportedOperationException if the client calls the remove()
        // method in the iterator.

        return null;
    }

    // unit testing (required)
    public static void main(String[] args) {}

}
