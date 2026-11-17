
class Solution {
    private static record Pair(int val, ListNode node){

    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length < 1) return null;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val(), b.val())
        );

        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;

        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null){
            pq.offer(new Pair(lists[i].val, lists[i]));
            }
        }

        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            int val = p.val();
            ListNode node = p.node();
            tmp.next = node;
            if(node.next != null) pq.offer(new Pair(node.next.val, node.next));
            tmp = tmp.next;
        }
       return dummy.next;
        
    }
}