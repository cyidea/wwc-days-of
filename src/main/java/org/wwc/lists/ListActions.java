package org.wwc.lists;

import java.awt.color.ICC_ColorSpace;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ListActions {

    /**
     * Here is a leetcode problem regarding Arrays:
     * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/">remove duplicates</a>
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> countmap = new HashMap<>();

        int index = 0;
        int replaceindex = nums.length - 1;
        int end = nums.length - 1;
        while (index <= end) {
            int val = nums[index];
            Integer count = countmap.get(val);
            if (count == null) {
                countmap.put(val, 1);
                index++;
            } else {
                if (count < 2) {
                    countmap.put(val, count+1);
                    index++;
                } else {
                    // move the item to the end
                    shiftItem(nums, val, index, replaceindex);
                    replaceindex--;
                    end = end - 1;
                }
            }
        }

        return end + 1;
    }

    // move item from start index to the end index
    // and shift each of the items to the left at the same time
    private void shiftItem(int[] nums, int val, int start, int end) {
        int moveTo = start;

        while (moveTo < end) {
            nums[moveTo] = nums[moveTo + 1];
            moveTo++;
        }
        nums[end] = val;
    }
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
