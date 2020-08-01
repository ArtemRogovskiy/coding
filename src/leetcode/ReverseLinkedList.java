package leetcode;

import leetcode.aux.ListNode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode last = new ListNode(3);
        ListNode second = new ListNode(2, last);
        ListNode first = new ListNode(1, second);
        System.out.println(first);
//        System.out.println(new ReverseLinkedList().reverseList(first));
        System.out.println(new ReverseLinkedList().reverseList3(first));
        System.out.println(new ReverseLinkedList().reverseList3(null));
    }

    // recursion method 2
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    // recursion method
    public ListNode reverseList2(ListNode head) {
        return auxReverseList2(null, head);
    }

    private ListNode auxReverseList2(ListNode last, ListNode first) {
        if (first == null) return last;
        ListNode next = first.next;
        first.next = last;
        return auxReverseList2(first, next);
    }


    // iteration method
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode current = head;
        ListNode prev = null;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
