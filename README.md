# Java algorithms and collections

Custom collection of data for technical interview for junior java developer role. 

## Algorithms
[SEE WHOLE LIST HERE](https://github.com/vmorkhat/java-algorithms-collections/blob/main/algorithms/ALGORITHMS.md)

# Big O notation
* **Time Complexity**: estimation of the number of operations or steps an algorithm needs to run as a function of the input size.
* **Space Complexity**: maximum amount of auxiliary memory that an algorithm needs to allocate or use during its execution as a function of the input size.
  * **Auxiliary Space** is the extra space or temporary space used by an algorithm.

`n` in Time Complexity — the number of elements in the input.

`n` in Space Complexity — input size in units of bits needed to represent the input.

### Big-O Time Complexity Table
| Type         | Name                   | Explanation                                                                                                                       | Status    | Example                       |  
|--------------|------------------------|-----------------------------------------------------------------------------------------------------------------------------------|-----------|-------------------------------| 
| `O(1)`       | Constant Time          | Algorithm is executed the same number of times each time, regardless of the size of the input                                     | Excellent | Search in a hash table by key |  
| `O(log n)`   | Logarithm Time         | The execution time increases very slowly compared to the increase in the size of the input data                                   | Excellent | Binary Search (Average)       |  
| `O(n)`       | Linear Time            | The execution time is linearly proportional to the size of the input data                                                         | Good      | Brute Force Search            | 
| `O(n + k)`   | Combined/Additive Time | Combined complexity of two separate inputs                                                                                        | Good      | Counting Sort                 | 
| `O(n log n)` | Quasilinear Time       | As the input size increases, the number of divisions required to solve the problem increases slowly due to the logarithmic growth | Bad       | Merge Sort, Heap Sort         |  
| `O(n^2)`     | Quadratic Time         | Involves nested iterations or comparisons for each element                                                                        | Horrible  | Selection Sort                |  
| `O(2^n)`     | Exponential Time       | Involves exhaustive search or enumeration of all possible combinations of the input, execution time increases exponentially       | Horrible  | TSP (dynamic programming)     | 
| `O(n!)`      | Factorial Time         | Involves exhaustive search or enumeration of all possible combinations of the input, execution time increases factorially         | Horrible  | TSP (brute force)             |


### Big-O Space Complexity Table
| Type       | Name                    | Explanation                                                                             | Status    | Example    |  
|------------|-------------------------|-----------------------------------------------------------------------------------------|-----------|------------| 
| `O(1)`     | Constant Space          | Algorithm requires a fixed amount of additional memory, regardless of the input size    | Excellent | Heap Sort  | 
| `O(log n)` | Logarithmic Space       | The space usage increases slowly compared to the increase in the size of the input data | Excellent | Quick Sort | 
| `O(n)`     | Linear Space            | The space usage scales linearly with the input size                                     | Good      | Merge Sort |
| `O(n + k)` | Combined/Additive Space | The space usage scales linearly with the sum of `n` and `k`                             | Bad       | Radix Sort |


### Definitions
| Term                     | Definition                                                                                                                                      | Examples                                                                         |  
|--------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------| 
| Abstract Data Type (ADT) | Represents a high-level description of a data type, focusing on its behavior and operations rather than the specific implementation details     | stack, queue, dictionary, sequence, set                                          |  
| Data Structure           | Technique or strategy for implementing a particular data type, organizing and storing data in a specific way to facilitate efficient operations | array, linked list, hash table, trees (binary search tree, heap, red/black trees |  


## Java collections classes
* **Collection**
  * **Set**
    * [HashSet](https://github.com/vmorkhat/java-algorithms-collections/blob/main/collections/sets/SETS.md#hashset)
    * [LinkedHashSet](https://github.com/vmorkhat/java-algorithms-collections/blob/main/collections/sets/SETS.md#linkedhashset)
      * **SortedSet**
      * **NavigableSet**
        * [TreeSet](https://github.com/vmorkhat/java-algorithms-collections/blob/main/collections/sets/SETS.md#treeset)
  * **List**
    * [ArrayList](https://github.com/vmorkhat/java-algorithms-collections/blob/main/collections/lists/LISTS.md)
    * [LinkedList](https://github.com/vmorkhat/java-algorithms-collections/blob/main/collections/lists/LISTS.md#linkedlist)
    * **Vector**
      * Stack
  * **Queue**
    * Priority Queue
      * **Deque**
        * ArrayDequeue
* **Map**
  * [HashTable](https://github.com/vmorkhat/java-algorithms-collections/blob/main/collections/maps/MAPS.md#hashtable)
  * [HashMap](https://github.com/vmorkhat/java-algorithms-collections/blob/main/collections/maps/MAPS.md#hashmap)
  * [LinkedHashMap](https://github.com/vmorkhat/java-algorithms-collections/blob/main/collections/maps/MAPS.md#linkedhashmap)
    * **SortedMap**
    * **NavigableMap**
      * [TreeMap](https://github.com/vmorkhat/java-algorithms-collections/blob/main/collections/maps/MAPS.md#treemap)


### Comparing Collection Types:
| Type   | Duplicate elements | Order of elements                                                                  | Must add/remove in specific order |
|--------|--------------------|------------------------------------------------------------------------------------|-----------------------------------|
| List   | Allowed            | By index                                                                           | No                                |
| Map    | Allowed for values | Java uses the hashCode() of the key to determine the order, for us it’s not sorted | No                                |
| Queue  | Allowed            | Retrieved in defined order                                                         | Yes                               |
| Set    | Prohibited         | Only in TreeSet                                                                    | Yes                               |

### Collection attributes:
| Type          | Interface      | Sorted?   | Calls `hashCode()`?   | Calls `compareTo()`?   |
|---------------|----------------|-----------|-----------------------|------------------------|
| ArrayList     | List           | No        | No                    | No                     |
| LinkedList    | List, Deque    | No        | No                    | No                     |
| ArrayDeque    | Queue, Deque   | No        | No                    | No                     |
| HashSet       | Set            | No        | Yes                   | No                     |
| TreeSet       | Set, SortedSet | Yes       | No                    | Yes                    |
| LinkedHashSet | Set            | No        | Yes                   | No                     |
| HashMap       | Map            | No        | Yes                   | No                     |
| LinkedHashMap | Map            | No        | Yes                   | No                     |
| TreeMap       | Map, SortedMap | Yes       | No                    | Yes                    |


The data structures that involve sorting don’t allow null values.