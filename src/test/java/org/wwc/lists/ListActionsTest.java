package org.wwc.lists;

import org.junit.jupiter.api.Test;

import java.util.EnumSet;

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

    @Test
    void removeDuplicates() {
        ListActions listActions = new ListActions();

        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int result = listActions.removeDuplicates(nums);
        assertThat(result).isEqualTo(5);
        assertThat(nums[0]).isEqualTo(1);
        assertThat(nums[1]).isEqualTo(1);
        assertThat(nums[2]).isEqualTo(2);
        assertThat(nums[3]).isEqualTo(2);
        assertThat(nums[4]).isEqualTo(3);

    }

    @Test
    void checkValidGrid() {
        ListActions listActions = new ListActions();
        int[][] grid = {{0,11,16,5,20},{17,4,19,10,15},{12,1,8,21,6},{3,18,23,14,9},{24,13,2,7,22}};
        boolean result = listActions.checkValidGrid(grid);
        assertThat(result).isTrue();
    }

    @Test
    void checkNotValidGrid() {
        ListActions listActions = new ListActions();
        int[][] grid = {{0,3,6},{5,8,1},{2,7,4}};
        boolean result = listActions.checkValidGrid(grid);
        assertThat(result).isFalse();
    }
}