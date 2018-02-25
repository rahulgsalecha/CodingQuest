# Python program for implementation of Selection Sort

# Function to do selection sort iteratively
def iterativeSelectionSort(arr,n):
    #Traverse through l to len(arr)
    for i in range(0,n-1):
        min = i
        for j in range(i+1,n):
            if(arr[j] < arr[j-1]):
                min = j
        
        temp = arr[i]
        arr[i] = arr[min]
        arr[min] = temp
    return arr      

# Driver code to test above
arr = [12, 11, 13, 5, 6]
print("Input Array is:")
print arr
iterativeSelectionSort(arr, len(arr))
print ("Iterated Selection : Sorted array is:")
print arr


''' Output:
    Input Array is:
    [12, 11, 13, 5, 6]
    Iterated Selection : Sorted array is:
    [5, 6, 11, 12, 13]

'''
