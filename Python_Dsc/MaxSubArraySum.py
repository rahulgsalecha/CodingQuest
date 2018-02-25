def maxSubArraySum(a,size):
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

# Driver program to test maxSubArraySum
a = [-2, -3, 4, -1, -2, 1, 5, -3]
print a
maxSubArraySum(a,len(a))

a = [-3,-4,5,5,-9,5,-3]
print a
maxSubArraySum(a,len(a))

a = [-3,-4,-5,-5,-9,-5,-3]
print a
maxSubArraySum(a,len(a))
