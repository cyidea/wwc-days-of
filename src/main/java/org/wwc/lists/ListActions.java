package org.wwc.lists;

import java.util.ArrayList;
import java.util.List;

/**
 * this is for <a href="https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem">hackerrank problem</a>
 */
public class ListActions {
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

}
