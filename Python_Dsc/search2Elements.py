from MergeSort import mergeSort
from BinarySearch import IterativeBinarySearch

def Search2Elements(S,x):
    for i in range(0,len(S)-1):
        key = x-S[i]
        mergeSort(S, 0 , len(S)-1)
        loc = IterativeBinarySearch(S,key,i+1,len(S)-1)
        if(S[loc] == key):
            print '2 Elements exist whose sum is equal to {0}'.format(x)
            return 1

    print '2 Elements do not exist that sum to {0}'.format(x)
    return 0

arr = [2,3,4,5,1,3,8]
Search2Elements(arr,11)
Search2Elements(arr,9)
Search2Elements(arr,19)

