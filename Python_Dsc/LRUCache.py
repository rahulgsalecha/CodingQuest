# Python implementation of LRUCache

import collections

class LRUCache:
    def __init__(self, capacity):
        self.capacity = capacity
        self.cache = collections.OrderedDict() # Ordered Hash Table

    def get(self,key):
        try:
            value = self.cache.pop(key)
            self.cache[key] = value
            return value
        except KeyError:
            return -1
        
    def set(self, key, value):
        try:
            self.cache.pop(key)
        except KeyError:
            if len(self.cache) >= self.capacity:
                self.cache.popitem(last=False)
            self.cache[key] = value

    def printCache(self):
        print self.cache

cache = LRUCache(5)
cache.set(1,2)
cache.set(2,3)
cache.set(3,4)
cache.printCache()
cache.get(2)
cache.printCache()
cache.get(1)
cache.printCache()

'''
Output:
    OrderedDict([(1, 2), (2, 3), (3, 4)])
    OrderedDict([(1, 2), (3, 4), (2, 3)])
    OrderedDict([(3, 4), (2, 3), (1, 2)])
'''
