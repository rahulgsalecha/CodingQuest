# Python program for implementation of heap Sort

# To heapify subtree rooted at index i.
# n is size of heap
def maxHeapify(a,n,i):
    largest = i # Initialize largest as root
    l=2*i+1     # left = 2*i + 1
    r=2*i+2     # right = 2*i + 2
    
    # See if left child of root exists and is
    # greater than root
    if (l < n and a[i] < a[l]):
        largest = l
    
    # See if right child of root exists and is
    # greater than root
    if ( r < n and a[largest] < a[r]):
        largest = r

    # Change root if needed
    if largest != i:
        a[i],a[largest] = a[largest],a[i] #swap

        #Heapify the root
        maxHeapify(a,n,largest)

# The main function to sort an array of given size
def heapSort(a):
    n = len(a)
    
    # Build a maxheap
    for i in range(n, -1, -1):
        maxHeapify(a,n,i)
    
    # One by One extract elements
    for i in range(n-1, 0, -1):
        a[i], a[0] = a[0], a[i]   # swap
        maxHeapify(a,i,0)

    
#Testing    
a = [12, 11, 13, 5, 6, 7]
print "Input array is:"
print a
heapSort(a)
print "Sorted array is:"
print a

''' Output:
    Input array is:
    [12, 11, 13, 5, 6, 7]
    Sorted array is:
    [5, 6, 7, 11, 12, 13]
'''
