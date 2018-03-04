#Python implementation of LinkedList 

class Node:
    def __init__(self,data):
        self.data = data
        self.next = None

    def getData(self):
        return self.data

    def getNext(self):
        return self.next

    def setData(self,newdata):
        self.data = newdata

    def setNext(self,newnext):
        self.next = newnext

class LinkedList:
    def __init__(self):
        self.head = None

    def isEmpty(self):
        return self.head == None

    def add(self, item):
        temp = Node(item)
        temp.setNext(self.head)
        self.head = temp

    def size(self):
        current = self.head
        count = 0
        while current != None:
            count = count + 1
            current = current.getNext()

        return count

    def search(self,item):
        current = self.head
        found = False
        while current != None and not found:
            if current.getData() == item:
                found = True
            else:
                current = current.getNext()

        return found

    def remove(self,item):
        current = self.head
        previous = None
        found = False
        while not found:
            if current.getData() == item:
                found = True
            else:
                previous = current
                current = current.getNext()
        
        if previous == None:
            self.head = current.getNext()
        else:
            previous.setNext(current.getNext())

    def printList(self):
        node = self.head
        while node:
            print node.data
            node = node.next


mylist = LinkedList()
mylist.add(31)
mylist.add(41)
mylist.add(51)
mylist.add(61)
mylist.add(71)
mylist.add(81)

print("List before removal:")
mylist.printList()
mylist.search(17)
mylist.search(31)
mylist.remove(81)
print("List after removal:")
mylist.printList()

''' Output:
    List before removal:
    81
    71
    61
    51
    41
    31
    List after removal:
    71
    61
    51
    41
    31
'''
