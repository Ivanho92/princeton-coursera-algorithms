package mod4_stacks_and_queues.assignment;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int size;
    private int capacity;
    private Item[] array;

    // construct an empty randomized queue
    public RandomizedQueue() {
        size = 0;
        capacity = 1;
        array = (Item[]) new Object[capacity];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    private void resize(int newCapacity) {
        this.capacity = newCapacity;
        Item[] resizedArray = (Item[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
            resizedArray[i] = array[i];
        array = resizedArray;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException();

        if (size == capacity)
            resize(2 * capacity);
        array[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();

        int randomIndex = StdRandom.uniformInt(size);
        Item deletedItem = array[randomIndex];

        // Rearrange array to get rid of null values
        // (order of elements doesn't matter inside a RandomizedQueue)
        array[randomIndex] = array[--size];
        array[size] = null;

        if (size == (double) capacity / 4)
            resize(capacity / 2);
        return deletedItem;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException();

        return array[StdRandom.uniformInt(size)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int iteratorIndex;
        private final Item[] iteratorItems;
        private final int iteratorSize;

        public RandomizedQueueIterator() {
            iteratorIndex = size;
            iteratorSize = size;

            iteratorItems = (Item[]) new Object[size];
            for (int i = 0; i < size; i++) iteratorItems[i] = array[i];
            StdRandom.shuffle(iteratorItems);
        }

        @Override
        public boolean hasNext() {
            return iteratorIndex > 0;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();

            if (size != iteratorSize)
                throw new java.util.ConcurrentModificationException();

            return iteratorItems[--iteratorIndex];
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
        StdOut.print("Items in queue (in iterator random order): ");
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

        // 6. Adding, removing, then adding again
        StdOut.println("\nTest 6: Adding, Removing, then Adding again");
        queue.enqueue("F");
        StdOut.println("Added: F");
        StdOut.println("Expected size: 1, Actual: " + queue.size());
        StdOut.println("Expected isEmpty: false, Actual: " + queue.isEmpty());

        String removedItem = queue.dequeue();
        StdOut.println("Removed item: " + removedItem);
        StdOut.println("Expected size: 0, Actual: " + queue.size());
        StdOut.println("Expected isEmpty: true, Actual: " + queue.isEmpty());

        queue.enqueue("G");
        StdOut.println("Added: G");
        StdOut.println("Expected size: 1, Actual: " + queue.size());
        StdOut.println("Expected isEmpty: false, Actual: " + queue.isEmpty());

        // 7. Edge Cases
        StdOut.println("\nTest 7: Edge Cases");
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
