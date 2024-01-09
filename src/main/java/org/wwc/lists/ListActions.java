package org.wwc.lists;

import java.util.ArrayList;
import java.util.List;


public class ListActions {

    /**
     * this is for <a href="https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem">hackerrank problem</a>
     */
    static boolean hasCycle(SinglyLinkedListNode head) {

        boolean retval = false;

        // just need to remember if the node has been visited
        List<SinglyLinkedListNode> visited = new ArrayList<>();
        SinglyLinkedListNode node = head;

        while (node != null) {
            if (visited.contains(node)) {
                retval = true;
                break;
            } else {
                visited.add(node);
            }
            node = node.next;
        }

        return retval;
    }


    /**
     * this is for <a href="https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem">hackerrank problem</a>
     * some of the tests on the site are not passing. runtime error, must be performance issue?
     */
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        List<SinglyLinkedListNode> visited = new ArrayList<>();
        SinglyLinkedListNode node = head1;
        SinglyLinkedListNode node2 = head2;

        int retval = 0;
        while (node != null) {
                visited.add(node);
                node = node.next;
        }

        while (node2 != null) {

            if (visited.contains(node2)) {
                retval = node2.data;
                break;
            }

            visited.add(node2);
            node2 = node2.next;
        }

        return retval;
    }

}
