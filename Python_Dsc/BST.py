# Python implementation of BST Data Structure

class Node:

    def __init__(self,data):
        self.left = None
        self.right = None
        self.data = data

    #Insert new node with data
    def insert(self,data):
        if self.data:
            if data < self.data:
                if self.left is None:
                    self.left = Node(data)
                else:
                    self.left.insert(data) #Recursive left-tree insert search
            elif data > self.data:
                if self.right is None:
                    self.right = Node(data)
                else:
                    self.right.insert(data) #Recursive right-tree insert search
            else:
                self.data = data

    #Look-up Method
    def lookup(self, data, parent = None):
        if data < self.data:
            if self.left is None:
                return None, None
            return self.left.lookup(data,self)
        elif data > self.data:
            if self.right is None:
                return None, None
            return self.right.lookup(data,self)
        else:
            return self,parent

    # children_count : returns number of children of a node
    def children_count(self):
        cnt = 0
        if self.left:
            cnt += 1
        if self.right:
            cnt += 1
        return cnt

    #Delete Method
    def delete(self, data):
        #get node containing data
        node, parent = self.lookup(data)
        if node is not None:
            children_count = node.children_count()
            # if node has no children, just remove it
            if children_count == 0:
                if parent:
                    if parent.left is node:
                        parent.left = None
                    else:
                        parent.right = None
                    del node
                else:
                    self.data = None
            elif children_count == 1:
                # If node has 1 child, replace node with its child
                if node.left:
                    n = node.left
                else:
                    n = node.right
                if parent:
                    if parent.left is node:
                        parent.left = n
                    else:
                        parent.right = n
                    del node
                else:
                    self.left = n.left
                    self.right = n.right
                    self.data = n.data
            else:
                # if node has 2 children, find its successor
                parent = node
                successor = node.right
                while successor.left:
                    parent = successor
                    successor = successor.left
                #replace node data by its successor data
                node.data = successor.data
                #fix successor's parent's child
                if parent.left == successor:
                    parent.left = successor.right
                else:
                    parent.right = successor.right

    def print_tree(self):
        if self.left:
            self.left.print_tree()
        print self.data
        if self.right:
            self.right.print_tree()

    # Compare 2 trees
    def compare_trees(self, node):
        if node is None:
            return False
        if self.data != node.data:
            return False
        
        res = True

        if self.left is None:
            if node.left:
                return False
        else:
            res = self.left.compare_trees(node.left)
        
        if res is False:
            return False

        if self.right is None:
            if node.right:
                return False
        else:
            res = self.right.compare_trees(node.right)
        return res

root = Node(8)
root.insert(3)
root.insert(10)
root.insert(1)
root.insert(6)
root.insert(4)
root.insert(7)
root.insert(14)
root.insert(13)
node, parent = root.lookup(6)
root.delete(1)
root.delete(14)
root.delete(3)
root.print_tree()

root2 = Node(8)
root2.insert(3)
root2.insert(11)

root3 = Node(8)
root3.insert(3)
root3.insert(11)
if(root3.compare_trees(root2)):
    print "two trees are identical"
else:
    print "two trees are non-identical"
