package week3_Queues;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<T> implements Iterable<T> {

    private Node head;
    private Node tail;
    private int n;

    private class Node {
        T value;
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
    public void addFirst(T item) {
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
    public void addLast(T item) {
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
    public T removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException("Cannot remove from empty deque");

        // Updating counter
        n--;

        // Getting head (to be removed) value
        T item = head.value;

        // Updating head
        head = head.next;
        if (!isEmpty()) head.previous = null ;
        else tail = null;

        return item;
    }

    // remove and return the item from the back
    public T removeLast() {
        if (isEmpty())
            throw new NoSuchElementException("Cannot remove from empty deque");

        // Updating counter
        n--;

        // Getting tail (to be removed) value
        T item = tail.value;

        // Updating tail
        tail = tail.previous;
        if (!isEmpty()) tail.next = null;
        else head = null;

        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<T> {

        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (current == null)
                throw new NoSuchElementException();

            T value = current.value;
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
        StdOut.println("Creating an empty deque...");
        Deque<Integer> deque = new Deque<>();

        StdOut.println("\nChecking if the deque is empty:");
        StdOut.println("Expected: true, Actual: " + deque.isEmpty());

        StdOut.println("\nAdding elements to the front of the deque...");
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        StdOut.println("Added 3, 2, 1 to the front. Size: " + deque.size());

        StdOut.println("\nRemoving elements from the front of the deque...");
        StdOut.println("Removed: " + deque.removeFirst());
        StdOut.println("Removed: " + deque.removeFirst());
        StdOut.println("Removed: " + deque.removeFirst());
        StdOut.println("Deque empty? " + deque.isEmpty());

        StdOut.println("\nAdding elements to the back of the deque...");
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        StdOut.println("Added 1, 2, 3 to the back. Size: " + deque.size());

        StdOut.println("\nRemoving elements from the back of the deque...");
        StdOut.println("Removed: " + deque.removeLast());
        StdOut.println("Removed: " + deque.removeLast());
        StdOut.println("Removed: " + deque.removeLast());
        StdOut.println("Deque empty? " + deque.isEmpty());

        StdOut.println("\nAdding elements to the deque using addFirst...");
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        StdOut.println("Added 3, 2, 1 to the front. Size: " + deque.size());

        StdOut.println("\nRemoving elements from the back of the deque...");
        StdOut.println("Removed: " + deque.removeLast());
        StdOut.println("Removed: " + deque.removeLast());
        StdOut.println("Removed: " + deque.removeLast());
        StdOut.println("Deque empty? " + deque.isEmpty());

        StdOut.println("\nAdding elements to the deque using addLast...");
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        StdOut.println("Added 1, 2, 3 to the back. Size: " + deque.size());

        StdOut.println("\nRemoving elements from the front of the deque...");
        StdOut.println("Removed: " + deque.removeFirst());
        StdOut.println("Removed: " + deque.removeFirst());
        StdOut.println("Removed: " + deque.removeFirst());
        StdOut.println("Deque empty? " + deque.isEmpty());

        StdOut.println("\nTesting iterator...");
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        StdOut.println("Added 1, 2, 3 to the deque.");
        StdOut.print("Iterating over deque: ");
        for (Integer value : deque)
            StdOut.print(value + " ");
        StdOut.println("\nExpected order: 1 2 3");

        StdOut.println("\nAll tests completed successfully.");
    }

}
