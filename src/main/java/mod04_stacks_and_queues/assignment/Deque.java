package mod04_stacks_and_queues.assignment;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node head;
    private Node tail;
    private int n;

    private class Node {
        Item value;
        Node next = null;
        Node previous = null;
    }

    // construct an empty deque
    public Deque() {
        head = null;
        tail = null;
        n = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the deque
    public int size() {
        return n;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Cannot add null item");

        // Adding new node
        Node newNode = new Node();
        newNode.value = item;

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            Node oldHead = head;
            head = newNode;
            newNode.next = oldHead;
            oldHead.previous = newNode;
        }

        // Updating counter
        n++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Cannot add null item");

        // Adding new node
        Node newNode = new Node();
        newNode.value = item;

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            Node oldTail = tail;
            tail = newNode;
            newNode.previous = oldTail;
            oldTail.next = newNode;
        }

        // Updating counter
        n++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException("Cannot remove from empty deque");

        // Updating counter
        n--;

        // Getting head (to be removed) value
        Item item = head.value;

        // Updating head
        head = head.next;
        if (!isEmpty()) head.previous = null;
        else tail = null;

        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty())
            throw new NoSuchElementException("Cannot remove from empty deque");

        // Updating counter
        n--;

        // Getting tail (to be removed) value
        Item item = tail.value;

        // Updating tail
        tail = tail.previous;
        if (!isEmpty()) tail.next = null;
        else head = null;

        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null)
                throw new NoSuchElementException();

            Item value = current.value;
            current = current.next;
            return value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        StdOut.println("===== Deque Unit Tests =====");

        // 1. Initialization Test
        StdOut.println("\nTest 1: Initialization");
        Deque<Integer> deque = new Deque<>();
        StdOut.println("Expected: true, Actual: " + deque.isEmpty() + " (isEmpty)");
        StdOut.println("Expected: 0, Actual: " + deque.size() + " (size)");

        // 2. Adding to Front and Removing from Front
        StdOut.println("\nTest 2: Add to Front and Remove from Front");
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        StdOut.println("Added 3, 2, 1 to the front. Size: " + deque.size());
        StdOut.println("Removed (Expected: 3): " + deque.removeFirst());
        StdOut.println("Removed (Expected: 2): " + deque.removeFirst());
        StdOut.println("Removed (Expected: 1): " + deque.removeFirst());
        StdOut.println("Expected: true, Actual: " + deque.isEmpty() + " (isEmpty)");

        // 3. Adding to Back and Removing from Back
        StdOut.println("\nTest 3: Add to Back and Remove from Back");
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        StdOut.println("Added 1, 2, 3 to the back. Size: " + deque.size());
        StdOut.println("Removed (Expected: 3): " + deque.removeLast());
        StdOut.println("Removed (Expected: 2): " + deque.removeLast());
        StdOut.println("Removed (Expected: 1): " + deque.removeLast());
        StdOut.println("Expected: true, Actual: " + deque.isEmpty() + " (isEmpty)");

        // 4. Mixed Operations
        StdOut.println("\nTest 4: Mixed Operations");
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);
        deque.addLast(4);
        StdOut.println("Added 3, 1 to the front; 2, 4 to the back. Size: " + deque.size());
        StdOut.println("Removed from front (Expected: 3): " + deque.removeFirst());
        StdOut.println("Removed from back (Expected: 4): " + deque.removeLast());
        StdOut.println("Removed from front (Expected: 1): " + deque.removeFirst());
        StdOut.println("Removed from back (Expected: 2): " + deque.removeLast());
        StdOut.println("Expected: true, Actual: " + deque.isEmpty() + " (isEmpty)");

        // 5. Iterator Test
        StdOut.println("\nTest 5: Iterator");
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        StdOut.println("Added 1, 2, 3 to the deque.");
        StdOut.print("Iterating over deque (Expected: 1 2 3): ");
        for (Integer value : deque)
            StdOut.print(value + " ");
        StdOut.println();

        // 6. Edge Cases
        StdOut.println("\nTest 6: Edge Cases");
        try {
            deque.removeFirst();
            deque.removeFirst();
            deque.removeFirst(); // Remove all items
            deque.removeFirst(); // Extra remove
        } catch (NoSuchElementException e) {
            StdOut.println("Expected exception on removeFirst from empty deque: " + e);
        }
        try {
            deque.removeLast(); // Extra remove
        } catch (NoSuchElementException e) {
            StdOut.println("Expected exception on removeLast from empty deque: " + e);
        }
        try {
            deque.addFirst(null);
        } catch (IllegalArgumentException e) {
            StdOut.println("Expected exception on addFirst(null): " + e);
        }
        try {
            deque.addLast(null);
        } catch (IllegalArgumentException e) {
            StdOut.println("Expected exception on addLast(null): " + e);
        }

        StdOut.println("\nAll tests completed.");
    }

}
