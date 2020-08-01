package leetcode;

import leetcode.aux.ListNode;
import leetcode.test.Constants;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        System.out.println(mergeTwoLists(Constants.HEAD_1_SORTED, Constants.HEAD_2_SORTED));
    }

    // USE PREHEAD FOR WRITING LESS CODE
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        // ListNode prehead = new ListNode(-1);
        // ListNode current = prehead;
        ListNode current = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = l1 == null ? l2 : l1;
        return head; // prehead.next
    }
}
