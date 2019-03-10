package cn.zilion.onetofifty;

import cn.zilion.utils.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    /**
     * @description: This method just calculate two node result, if anyone is null, set it as zero or else set it as it's value.
     * @param l1
     * @param l2
     * @return
     */
    private int sum(ListNode l1, ListNode l2) {
        int a = l1 == null ? 0 : l1.val;
        int b = l2 == null ? 0 : l2.val;
        return a + b;
    }

    /**
     * @description: This method just used to move cursor to next node. If node is null return it or else move to next.
     * @param l
     * @return
     */
    private ListNode goAhead(ListNode l) {
        if(l == null) {
            return null;
        }
        return l.next;
    }

    /**
     * @description: This method used to split Integer number due to sometimes this number would greater then 9, split it
     *               into array.
     * @param a Integer
     * @return Integer array.
     */
    private int[] getNumberSize(int a) {
        int[] res = new int[2];
        res[0] = a % 10;
        res[1] = a / 10;
        return res;
    }

    /**
     * @description: This method used to calculate two List result and return its sum with ListNode.
     * @param l1 First ListNode
     * @param l2 Second ListNode.
     * @return sum of above two ListNode.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean increaseFlg = false;
        ListNode L1 = l1, L2 = l2;
        ListNode res = null, node = null;
        int[] sum = null;
        int decade = 0;
        while(L1 != null || L2 != null) {
            if(res == null) {
                sum = getNumberSize(sum(L1, L2));
                decade = sum[1];
                node = new ListNode(sum[0]);
                res = node;
            } else {
                sum = getNumberSize(sum(L1, L2) + decade);
                node.next = new ListNode(sum[0]);
                node = node.next;
                decade = sum[1];
            }
            if(L1 != null) {
                L1 = L1.next;
            }
            if(L2 != null) {
                L2 = L2.next;
            }
        }
        if(decade > 0) {
            node.next = new ListNode(decade);
        }
        return res;
    }
}
