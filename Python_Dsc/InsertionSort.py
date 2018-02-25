# Python program for implementation of Insertion Sort

# Function to do insertion sort iteratively
def iterativeInsertionSort(arr,reverse):
    #Traverse through l to len(arr)
    for i in range(1,len(arr)):
        for j in range(i, 0, -1):
            if reverse == False: 
                if(arr[j] < arr[j-1]):
                    temp = arr[j]
                    arr[j] = arr[j-1]
                    arr[j-1] = temp
            else:
                if(arr[j] > arr[j-1]):
                    temp = arr[j]                
                    arr[j] = arr[j-1]                
                    arr[j-1] = temp
    return arr      

# Recursive Python program for insertion sort
def recursiveInsertionSort(arr,n):
    #base case
    if n<=1:
        return
    
    #sort first n-1 elements
    recursiveInsertionSort(arr,n-1)

    '''Insert last element at its correct position
            in sorted array.'''
    last = arr[n-1]
    j = n-2
    
    # Move elements of arr[0..i-1], that are
    # greater than key, to one position ahead
    # of their current position 

    while ( j >=0 and arr[j] > last):
        arr[j+1] = arr[j];
        j = j-1
    
    arr[j+1] = last
    return arr

# Driver code to test above
arr = [12, 11, 13, 5, 6]
print("Input Array is:")
print arr
iterativeInsertionSort(arr, False)
print ("Iterated Insertion : Sorted array is:")
print arr

arr1 = [15, 13, 16, 5, 6]
print("Input Array is:")
print arr1
iterativeInsertionSort(arr1, True)
print ("Reverse Iterated Insertion : Sorted array is:")
print arr1


arr2 = [15, 12, 16, 5, 7]
print("Input Array is:")
print arr2
n = len(arr2)
recursiveInsertionSort(arr2, n)
print ("Recursive Insertion : Sorted array is:")
print arr2

''' Output:
    Input Array is:
    [12, 11, 13, 5, 6]
    Iterated Insertion : Sorted array is:
    [5, 6, 11, 12, 13]
    Input Array is:
    [15, 13, 16, 5, 6]
    Reverse Iterated Insertion : Sorted array is:
    [16, 15, 13, 6, 5]
    Input Array is:
    [15, 12, 16, 5, 7]
    Recursive Insertion : Sorted array is:
    [5, 7, 12, 15, 16]
'''
