# Python program for implementation of Selection Sort

# Function to do selection sort iteratively
def BubbleSort(arr):
    n = len(arr)
    for i in range(0,n):
        for j in range(0,n-i-1):
            if(arr[j] > arr[j+1]):
                arr[j], arr[j+1] = arr[j+1], arr[j]
    return arr      

# Driver code to test above
arr = [12, 11, 13, 5, 6]
print("Input Array is:")
print arr
BubbleSort(arr)
print ("Bubble Sort : Sorted array is:")
print arr


''' Output:
    Input Array is:
    [12, 11, 13, 5, 6]
    Bubble Sort : Sorted array is:
    [5, 6, 11, 12, 13]
'''
