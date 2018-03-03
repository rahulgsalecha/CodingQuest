# Python implementation of Stack Datastructure

#Used to return -infinite when stack is empty
from sys import maxsize

def createStack():
    stack = []
    return stack

def isEmpty(stack):
    return len(stack) == 0

def push(stack, item):
    stack.append(item)
    print("pushed to stack"+item)

def pop(stack):
    if(isEmpty(stack)):
        return str(-maxsize -1) #return minus infinite
    
    return stack.pop()

# Driver program to test above functions    
stack = createStack()
push(stack, str(10))
push(stack, str(20))
push(stack, str(30))
print(pop(stack) + " popped from stack")

''' Output:
    pushed to stack10
    pushed to stack20
    pushed to stack30
    30 popped from stack
    '''
