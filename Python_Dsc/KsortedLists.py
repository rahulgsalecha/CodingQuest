#Python implementation of K sorted lists

#Solution 1 : Heap Based solution
import heapq

class ListNode(object):
    def __init__(self,x):
        self.val = x
        self.next = None

    def __repr__(self):
        if self:
            return "{} -> {}".format(self.val,self.next)

class Solution1:

    def mergeKLists(lists):
        dummy = ListNode(0)
        current = dummy

        heap = []
        for sorted_list in lists:
            if sorted_list:
                heapq.heappush(heap, (sorted_list.val, sorted_list))

        while heap:
            smallest = heapq.heappop(heap)[1]
            current.next = smallest
            current = current.next
            if smallest.next:
                heapq.heappush(heap,(smallest.next.val, smallest.next))

        return dummy.next

    if __name__ == "__main__":
        list1 = ListNode(1)
        list1.next = ListNode(3)
        list2 = ListNode(2)
        list2.next = ListNode(4)

        print mergeKLists([list1,list2])

''' Output:
    1 -> 2 -> 3 -> 4 -> None
    '''
