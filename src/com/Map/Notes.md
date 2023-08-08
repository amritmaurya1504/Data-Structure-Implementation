## HashMap Implementation

#### Important Methods - 
````
1. put() TC => O(lambda)
2. get()
3. containsKey()
4. remove()
5. size()
6. keySet()

Note :- Average time complexity of all methods is O(1)

````

1. Hashmap store data in <Key, Value> pair where key is always unique but 
value maybe same.
2. Hashmap is internally impplemented using array of linkedlist (also called
   as Bucket array) where each index
contains a linkedlist and nodes of linkedlist is the data which we added in
hashmap
   
````
n (node) = number of nodes 
N (size) = size of bucket array
````


Hashing -> Data form changed, java has inbuilt function.
n/N = lambda (average element per bucket) O(lambda)
lambda <= 0.7 
if lambda > 0.7 then we will do rehashing and increase the bucket array
size. (it may be double size) to decrease the time complexity. of put function


--------
=====> Key ===> HashFunction ====> Bucket Index

### Collion Resolution Technique
````
1. Chaining (Open Hashing)
2. Open Addressing (Closed Hashing)
    2a. Linear Probing
    2b. Quadratic Probing
    2c  Double Hashing
````




