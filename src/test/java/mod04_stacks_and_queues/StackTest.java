package mod04_stacks_and_queues;

import mod04_stacks_and_queues.sandbox.LinkedListStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StackTest {
// TODO
//    private LinkedListStack<Integer> stack;
//
//    @BeforeEach
//    void setUp() {
//        stack = new LinkedListStack<>();
//    }
//
//    @Test
//    void shouldBeEmptyWhenCreated() {
//        assertThat(stack.isEmpty()).isTrue();
//        assertThat(stack.size()).isZero();
//    }
//
//    @Test
//    void shouldAllowPushingElements() {
//        stack.push(1);
//        assertThat(stack.isEmpty()).isFalse();
//        assertThat(stack.size()).isEqualTo(1);
//        assertThat(stack.peek()).isEqualTo(1);
//    }
//
//    @Test
//    void shouldReturnLastPushedElementOnPop() {
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//
//        assertThat(stack.pop()).isEqualTo(3);
//        assertThat(stack.size()).isEqualTo(2);
//
//        assertThat(stack.pop()).isEqualTo(2);
//        assertThat(stack.size()).isEqualTo(1);
//
//        assertThat(stack.pop()).isEqualTo(1);
//        assertThat(stack.isEmpty()).isTrue();
//    }
//
//    @Test
//    void shouldThrowExceptionWhenPoppingEmptyStack() {
//        assertThatThrownBy(() -> stack.pop())
//                .isInstanceOf(EmptyStackException.class);
//    }
//
//    @Test
//    void shouldThrowExceptionWhenPeekingEmptyStack() {
//        assertThatThrownBy(() -> stack.peek())
//                .isInstanceOf(EmptyStackException.class);
//    }
//
//    @Test
//    void shouldAllowPeekingWithoutModifyingStack() {
//        stack.push(42);
//        stack.push(99);
//
//        assertThat(stack.peek()).isEqualTo(99);
//        assertThat(stack.size()).isEqualTo(2);
//        assertThat(stack.isEmpty()).isFalse();
//    }
//
//    @Test
//    void shouldHandleMixedOperations() {
//        stack.push(10);
//        stack.push(20);
//
//        assertThat(stack.pop()).isEqualTo(20);
//        assertThat(stack.peek()).isEqualTo(10);
//
//        stack.push(30);
//        assertThat(stack.size()).isEqualTo(2);
//        assertThat(stack.pop()).isEqualTo(30);
//        assertThat(stack.pop()).isEqualTo(10);
//
//        assertThat(stack.isEmpty()).isTrue();
//    }
//
//    @Test
//    void shouldAllowClearingStack() {
//        stack.push(5);
//        stack.push(15);
//        stack.pop();
//        stack.pop();
//
//        assertThat(stack.isEmpty()).isTrue();
//        assertThat(stack.size()).isZero();
//        assertThatThrownBy(() -> stack.pop())
//                .isInstanceOf(EmptyStackException.class);
//    }
//
//    @Test
//    void shouldAllowAddingElementsAfterClearing() {
//        stack.push(1);
//        stack.push(2);
//        stack.pop();
//        stack.pop();
//        assertThat(stack.isEmpty()).isTrue();
//        assertThat(stack.size()).isZero();
//
//        stack.push(3);
//        stack.push(4);
//        assertThat(stack.isEmpty()).isFalse();
//        assertThat(stack.size()).isEqualTo(2);
//
//        assertThat(stack.pop()).isEqualTo(4);
//        assertThat(stack.pop()).isEqualTo(3);
//        assertThat(stack.isEmpty()).isTrue();
//    }
}

