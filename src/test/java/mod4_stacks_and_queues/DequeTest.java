package mod4_stacks_and_queues;

import mod4_stacks_and_queues.assignment.Deque;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DequeTest {

    @Test
    void addFirstThenRemoveFirst() {
        var deque = new Deque<Integer>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);

        assertThat(deque.size()).isEqualTo(3);
        assertThat(deque.removeFirst()).isEqualTo(3);
        assertThat(deque.removeFirst()).isEqualTo(2);
        assertThat(deque.removeFirst()).isEqualTo(1);
        assertThat(deque.isEmpty()).isTrue();
    }

    @Test
    void addFirstThenRemoveLast() {
        var deque = new Deque<Integer>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);

        assertThat(deque.size()).isEqualTo(3);
        assertThat(deque.removeLast()).isEqualTo(1);
        assertThat(deque.removeLast()).isEqualTo(2);
        assertThat(deque.removeLast()).isEqualTo(3);
        assertThat(deque.isEmpty()).isTrue();
    }

    @Test
    void addLastThenRemoveFirst() {
        var deque = new Deque<Integer>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        assertThat(deque.size()).isEqualTo(3);
        assertThat(deque.removeFirst()).isEqualTo(1);
        assertThat(deque.removeFirst()).isEqualTo(2);
        assertThat(deque.removeFirst()).isEqualTo(3);
        assertThat(deque.isEmpty()).isTrue();
    }

    @Test
    void addLastThenRemoveLast() {
        var deque = new Deque<Integer>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        assertThat(deque.size()).isEqualTo(3);
        assertThat(deque.removeLast()).isEqualTo(3);
        assertThat(deque.removeLast()).isEqualTo(2);
        assertThat(deque.removeLast()).isEqualTo(1);
        assertThat(deque.isEmpty()).isTrue();
    }

    @Test
    void iteratorShouldWorkAsExpected() {
        var deque = new Deque<Integer>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        var index = 1;
        for (Integer i : deque) {
            assertThat(i).isEqualTo(index);
            index++;
        }
    }
}
