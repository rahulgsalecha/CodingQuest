def maxSubArraySum_KadaneMethod(a,size):
    max_so_far = -1
    max_ending_here = 0
    start = end = s = 0

    for i in range(0,size):
        max_ending_here += a[i]

        if max_so_far < max_ending_here:
            max_so_far = max_ending_here
            start = s
            end = i

        if max_ending_here < 0:
            max_ending_here = 0
            s = i+1
        
    print ("Maximum contiguous sum is %d"%(max_so_far))
    print ("Starting Index %d"%(start))
    print ("Ending Index %d"%(end))

def maxCrossingSum_DivideNConquerMethod(a,l,m,h):
    sm = 0
    left_sum = -10000

    # Include elements on left of mid
    for i in range(m, l-1, -1):
        sm = sm + a[i]

        if(sm > left_sum):
            left_sum = sm

    # Include elements on right of mid
    sm = 0
    right_sum = -1000
    for i in range(m+1, h+1):
        sm = sm + a[i]

        if(sm > right_sum):
            right_sum =sm

    # Return sum of elements on left and right of mid
    return left_sum + right_sum

def maxSubArraySum_DivideNConquerMethod(a,l,h):
    if(l == h):
        return a[l]

    m = (l+h)/2

    return max(maxSubArraySum_DivideNConquerMethod(a,l,m),
            maxSubArraySum_DivideNConquerMethod(a,m+1,h),
            maxCrossingSum_DivideNConquerMethod(a,l,m,h))



# Driver program to test maxSubArraySum_KadaneMethod
print "Max Sub Array Sum using Dynamic Programming method"
print " "
print "Test 1"
a = [-2, -3, 4, -1, -2, 1, 5, -3]
print a
maxSubArraySum_KadaneMethod(a,len(a))

print " "
print "Test 2"
a = [-3,-4,5,5,-9,5,-3]
print a
maxSubArraySum_KadaneMethod(a,len(a))

print " "
print "Test 3"
a = [-3,-4,-5,-5,-9,-5,-3]
print a
maxSubArraySum_KadaneMethod(a,len(a))

print "=================================================="

arr = [2, 3, 4, 5, 7]
print "Max Sub Array Sum using Divide & Conquer method"
print " "
print "Test 1"
print arr
max_sum = maxSubArraySum_DivideNConquerMethod(arr,0, len(arr)-1)
print "Max Sub Array Sum is {0}".format(max_sum)


''' Output:
    Max Sub Array Sum using Dynamic Programming method
     
     Test 1
     [-2, -3, 4, -1, -2, 1, 5, -3]
     Maximum contiguous sum is 7
     Starting Index 2
     Ending Index 6
      
      Test 2
      [-3, -4, 5, 5, -9, 5, -3]
      Maximum contiguous sum is 10
      Starting Index 2
      Ending Index 3
       
       Test 3
       [-3, -4, -5, -5, -9, -5, -3]
       Maximum contiguous sum is -1
       Starting Index 0
       Ending Index 0
       ==================================================
       Max Sub Array Sum using Divide & Conquer method
        
        Test 1
        [2, 3, 4, 5, 7]
        Max Sub Array Sum is 21

        '''
