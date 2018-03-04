# Python implementation of Hash Table


class HashEntry(object):

    def __init__(self, k, v):
        self.key = k
        self.value = v
        self.next = None

class HashTable(object):

    def __init__(self, capacity, load):
        self.capacity = capacity
        self.load = load
        self.cur_capacity = 0

        self.slots = [None] * self.capacity

    def _set_linked_list(self,key,value,slots, slot_index):
        curr_node = slots[slot_index]
        while curr_node is not None:
            if curr_node.key == key:
                curr_node.value = value
                curr_node = None
            elif curr_node.next is None:
                curr_node.next = HashEntry(key,value)
                curr_node = None
            else:
                curr_node = curr_node.next

    def set(self,key,value):
        slot_index = (hash(key)) % self.capacity;

        if self.slots[slot_index] is None:
            self.slots[slot_index] = HashEntry(key,value)
        else:
            _set_linked_list(key,value,self.slots, slot_index)
        
        self.cur_capacity += 1
        cur_load = float(self.cur_capacity) / float(self.capacity)
        if cur_load >= self.load:
            self.resize()

    def get(self,key):
        slot_index = (hash(key)) % self.capacity;

        if self.slots[slot_index] is not None:
            curr_node = self.slots[slot_index]
            while curr_node is not None:
                if curr_node.key == key:
                    return curr_node.value
                curr_node = curr_node.next

    def resize(self):
        new_capacity = self.capacity*2
        new_slots = [None] * new_capacity
        
        # rehash all items into new slots
        for slot_index in range(0,  len(self.slots)):
            curr_node = self.slots[slot_index]
            while curr_node is not None:
                new_slot_index = (hash(curr_node.key)) % new_capacity
                if new_slots[new_slot_index] is None:
                    new_slots[new_slot_index] = HashEntry(curr_node.key,curr_node.value)
                else:
                    self._set_linked_list(curr_node.key,curr_node.value, new_slots, new_slot_index)

                curr_node = curr_node.next

        self.slots = new_slots
        self.capacity = new_capacity

H = HashTable(capacity=6, load=1)
H.set(1,"dog1")
H.set(2,"dog2")
H.set(3,"dog3")
H.set(4,"dog4")
H.set(5,"dog5")

for index in range(1, H.capacity):
    print index,H.get(index)

'''
Output:
    1 dog1
    2 dog2
    3 dog3
    4 dog4
    5 dog5
'''
