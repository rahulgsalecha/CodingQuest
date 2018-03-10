/* Java Program for Implementation of K Sorted Lists */

public class KSortedLists {
    
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(List<LisyNode> lists){
        if(list.size() == 0){
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.size(),new Comparator<ListNode>(){
                    
            @Override
            public int compare(ListNode o1, ListNode o2){
                return o1.val - o2.val;
            }
        });

        for(int i=0;i < lists.size(); i++){
            if(lists.get(i) != null) {
                queue.add(lists.get(i));
            }
        }

        ListNode head = new ListNode(0);
        ListNode p = head;

        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            p.next = node;
            if(node.next != null) {
                queue.add(node.next);
            }
            p = p.next;
        }

        return head.next;
    }
}
