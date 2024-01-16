package org.wwc.lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ListActions {

    /**
     * <a href="https://leetcode.com/problems/check-knight-tour-configuration/">check knight tour</a>
     * @param grid
     * @return
     */

    // putting the current location here, so don't need to create another data structure
    int row;
    int col;

    List<Integer> visited = new ArrayList<>();

    public boolean checkValidGrid(int[][] grid) {


        boolean retval = false;

        int n = grid.length;
        // need a visited list
        // the integer in this list is along 0, 1, 2, ..., n*n - 1

        int value = 0; // this value increases until the end. what it the end val?
        // there is no end val. until the visited contains exactly n*n

        visited.add(0);
        row = 0;
        col = 0;

        while (visited.size() < n * n) {
            List<Integer> nextPossibleLocations = new ArrayList<>();

            createPossibleLocations(grid, nextPossibleLocations);

            if (nextPossibleLocations.size() > 0) {
                boolean found = testLocations(nextPossibleLocations, n, grid, ++value);
                if (!found)
                    return false;
                // now that value is increased
                // can go to next round
            } else {
                break;
            }

        }

        return retval;
    }

    private void createPossibleLocations(int[][] grid, List<Integer> nextPossibleLocations) {
        // how many possible locations? given the row and col?
        // there are 8 of them
        int newrow = row-2;
        int newcol = col-1;
        if (newrow >= 0 && newcol >= 0) {
            int newval = newrow * grid.length + newcol;
            if (!visited.contains(newval))
                nextPossibleLocations.add(newval);
        }
        newrow = row-2;
        newcol = col+1;
        if (newrow >= 0 && newcol >= 0) {
            int newval = newrow * grid.length + newcol;
            if (!visited.contains(newval))
                nextPossibleLocations.add(newval);        }
        newrow = row-1;
        newcol = col-2;
        if (newrow >= 0 && newcol >= 0) {
            int newval = newrow * grid.length + newcol;
            if (!visited.contains(newval))
                nextPossibleLocations.add(newval);        }
        newrow = row-1;
        newcol = col+2;
        if (newrow >= 0 && newcol >= 0) {
            int newval = newrow * grid.length + newcol;
            if (!visited.contains(newval))
                nextPossibleLocations.add(newval);        }
        newrow = row+1;
        newcol = col-2;
        if (newrow >= 0 && newcol >= 0) {
            int newval = newrow * grid.length + newcol;
            if (!visited.contains(newval))
                nextPossibleLocations.add(newval);        }
        newrow = row+1;
        newcol = col+2;
        if (newrow >= 0 && newcol >= 0) {
            int newval = newrow * grid.length + newcol;
            if (!visited.contains(newval))
                nextPossibleLocations.add(newval);        }

        newrow = row+2;
        newcol = col-1;
        if (newrow >= 0 && newcol >= 0) {
            int newval = newrow * grid.length + newcol;
            if (!visited.contains(newval))
                nextPossibleLocations.add(newval);        }
        newrow = row+2;
        newcol = col+1;
        if (newrow >= 0 && newcol >= 0) {
            int newval = newrow * grid.length + newcol;
            if (!visited.contains(newval))
                nextPossibleLocations.add(newval);        }


    }

    private boolean testLocations(List<Integer> nextPossibleLocations, int n, int[][] grid, int nextval) {
        // return the location where the value is at
        boolean found = false;
        for (Integer location: nextPossibleLocations) {
            row = location/n;
            col = location % n;
            if (grid[row][col] == nextval) {
                // found it, so this will be it
                visited.add(location);
                return true;
            }
        }
        // didn't find anything, this will end the whole thing
        return found;
    }

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
