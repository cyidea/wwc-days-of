package org.wwc.lists;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ListActionsTest {

    @Test
    void hasCycle() {
        SinglyLinkedListNode head = new SinglyLinkedListNode();
        head.data = 1;

        SinglyLinkedListNode second = new SinglyLinkedListNode();
        second.data = 2;

        SinglyLinkedListNode third = new SinglyLinkedListNode();
        third.data = 3;

        // link them:
        head.next = second;
        second.next = third;

        boolean result = ListActions.hasCycle(head);
        assertThat(result).isFalse();
    }

    @Test
    void hasCycle2() {
        SinglyLinkedListNode head = new SinglyLinkedListNode();
        head.data = 1;

        SinglyLinkedListNode second = new SinglyLinkedListNode();
        second.data = 2;

        SinglyLinkedListNode third = new SinglyLinkedListNode();
        third.data = 3;

        // link them:
        head.next = second;
        second.next = third;
        third.next = second;

        boolean result = ListActions.hasCycle(head);
        assertThat(result).isTrue();
    }

    @Test
    void findMergeNode() {
        SinglyLinkedListNode head = new SinglyLinkedListNode();
        head.data = 1;

        SinglyLinkedListNode second = new SinglyLinkedListNode();
        second.data = 2;

        SinglyLinkedListNode third = new SinglyLinkedListNode();
        third.data = 3;

        // link them:
        head.next = second;
        second.next = third;

        int result = ListActions.findMergeNode(head, third);
        assertThat(result).isEqualTo(3);
    }

}