package week3_Queues;

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
    }

}
