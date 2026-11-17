class Solution {
     public ListNode getMiddle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
   public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;
        }

        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }

        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length < 1) return null;

        ListNode head = lists[0];

        for(int i =  1;  i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;

        
    }
}