package mod04_stacks_and_queues.assignment;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Reservoir sampling approach
 * (maximum size at most k)

 * Each input string has an equal probability of being in the final k items.
 * This ensures the randomness requirement while only storing up to k items at any time.
 */
public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> queue = new RandomizedQueue<>();

        int i = 0;
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();

            if (i < k) {
                // Add the first k items directly
                queue.enqueue(item);
            } else if (StdRandom.uniformInt(i + 1) < k) {
                // With probability k / i, replace a random item in the queue
                queue.dequeue();
                queue.enqueue(item);
            }

            i++;
        }

        for (int j = 0; j < k; j++) {
            StdOut.println(queue.dequeue());
        }
    }
}

/**
 * Straighforward approach
 * (maximum size at most n)
 */
// public class Permutation {
//    public static void main(String[] args) {
//        RandomizedQueue<String> queue = new RandomizedQueue<>();
//        int k = Integer.parseInt(args[0]);
//
//        while(!StdIn.isEmpty()) {
//            String item = StdIn.readString();
//            queue.enqueue(item);
//        }
//
//        for (int i = 0; i < k; i++) {
//            StdOut.println(queue.dequeue());
//        }
//    }
//}
