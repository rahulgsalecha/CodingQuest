#Python implementation of Binary Search

def IterativeBinarySearch(arr,key,l,r):
    while(l <= r):
        mid = l + (r-l) / 2
        if(arr[mid] < key):
            l = mid + 1
        elif(arr[mid] > key):
            r = mid - 1
        else:
            return mid
    return -1

def RecursiveBinarySearch(arr,key,l,r):
    while(l <= r):
        mid = l + (r-l) / 2
        if(arr[mid] < key):
            return RecursiveBinarySearch(arr,key,mid+1,r)
        elif(arr[mid] > key):
            return RecursiveBinarySearch(arr,key,l,mid-1)
        else:
            return mid
    return -(l+1)

def outputPrint(key,ret):
    if (ret > -1):
        print "key {0} found at index {1}".format(key,ret)
    else:
        print "Key {0} not found".format(key)

#testing
arr=[1,3,5,7,9,18,22]

key = 18
ret = IterativeBinarySearch(arr,key,0,len(arr)-1)
outputPrint(key,ret)

key1 = 23
ret1 = IterativeBinarySearch(arr,key1,0,len(arr)-1)
outputPrint(key1,ret1)

key2 = 7
ret2 = RecursiveBinarySearch(arr,key2,0,len(arr)-1)
outputPrint(key2,ret2)

key3 = 90
ret3 = RecursiveBinarySearch(arr,key3,0,len(arr)-1)
outputPrint(key3,ret3)

''' Output:
    key 18 found at index 5
    Key 23 not found
    key 7 found at index 3
    Key 90 not found
'''

