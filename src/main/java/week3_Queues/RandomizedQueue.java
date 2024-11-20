package week3_Queues;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<T> implements Iterable<T> {

    int n;
    T[] items;

    // construct an empty randomized queue
    public RandomizedQueue() {
        n = 0;
        items = (T[]) new Object[1];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return n;
    }

    // add the item
    public void enqueue(T item) {
        if (item == null)
            throw new IllegalArgumentException();

        if (n == items.length) resize(2 * items.length);
        items[n++] = item;
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        int tempIndex = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) continue;
            temp[tempIndex] = items[i];
            tempIndex++;
        }
        items = temp;
    }

    // remove and return a random item
    public T dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();

        T deletedItem = randomItem(true);
        if (n == items.length / 2) resize(items.length / 2);
        return deletedItem;
    }

    // return a random item (but do not remove it)
    public T sample() {
        if (isEmpty())
            throw new NoSuchElementException();

        return randomItem(false);
    }

    private T randomItem(boolean deleteItem) {
        while(true) {
            int randomIndex = StdRandom.uniformInt(n);
            T randomItem = items[randomIndex];

            if (randomItem == null) continue;

            if (deleteItem) {
                items[randomIndex] = null;
                n--;
            }

            return randomItem;
        }
    }

    // return an independent iterator over items in random order
    public Iterator<T> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<T> {
        private int i = n;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return items[--i];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        StdOut.println("===== RandomizedQueue Unit Tests =====");

        // 1. Initialization Test
        StdOut.println("\nTest 1: Initialization");
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        StdOut.println("Expected: true, Actual: " + queue.isEmpty() + " (isEmpty)");
        StdOut.println("Expected: 0, Actual: " + queue.size() + " (size)");

        // 2. Adding Items
        StdOut.println("\nTest 2: Adding Items (enqueue)");
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        queue.enqueue("E");
        StdOut.println("Added items: A, B, C, D, E");
        StdOut.println("Expected: false, Actual: " + queue.isEmpty() + " (isEmpty)");
        StdOut.println("Expected: 5, Actual: " + queue.size() + " (size)");
        StdOut.print("Items in queue (in iterator order): ");
        for (String str : queue) StdOut.print(str + " ");
        StdOut.println();

        // 3. Sampling Without Removal
        StdOut.println("\nTest 3: Sampling Items (sample)");
        StdOut.print("Sampled items (random, non-removal): ");
        for (int i = 0; i < 5; i++) StdOut.print(queue.sample() + " ");
        StdOut.println("\nItems in queue after sampling: ");
        for (String str : queue) StdOut.print(str + " ");
        StdOut.println();

        // 4. Removing Items
        StdOut.println("\nTest 4: Removing Items (dequeue)");
        String removedItem1 = queue.dequeue();
        String removedItem2 = queue.dequeue();
        StdOut.println("Removed items: " + removedItem1 + ", " + removedItem2);
        StdOut.println("Expected size: 3, Actual: " + queue.size());
        StdOut.print("Remaining items in queue: ");
        for (String str : queue) StdOut.print(str + " ");
        StdOut.println();

        // 5. Emptying the Queue
        StdOut.println("\nTest 5: Removing All Items");
        while (!queue.isEmpty()) {
            StdOut.println("Removed item: " + queue.dequeue());
        }
        StdOut.println("Expected: true, Actual: " + queue.isEmpty() + " (isEmpty)");
        StdOut.println("Expected: 0, Actual: " + queue.size() + " (size)");

        // 6. Edge Cases
        StdOut.println("\nTest 6: Edge Cases");
        try {
            queue.dequeue();
        } catch (NoSuchElementException e) {
            StdOut.println("Expected exception on dequeue from empty queue: " + e);
        }
        try {
            queue.sample();
        } catch (NoSuchElementException e) {
            StdOut.println("Expected exception on sample from empty queue: " + e);
        }
        try {
            queue.enqueue(null);
        } catch (IllegalArgumentException e) {
            StdOut.println("Expected exception on enqueue null: " + e);
        }

        StdOut.println("\nAll tests completed.");
    }
}
