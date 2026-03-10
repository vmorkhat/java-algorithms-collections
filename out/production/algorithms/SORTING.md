# Sorting Algorithms

Mostly taken from [here](https://neerc.ifmo.ru/wiki/index.php?title=%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B8).
| EN name | RU name | Average Time Complexity | Space Complexity | Explanation |
| ---- | ---- | ---- | ---- | ---- |  
| Bubble Sort | Пузырьковая сортировка | `O(n^2)`| `O(1)` | Swap adjacent elements if they are in the wrong order, gradually **"bubble"** the max (or min) element to its correct position in each pass |
| Selection Sort | Сортировка выбором | `O(n^2)` | `O(1)` | Find the min (or max) element from the unsorted portion and swap it with the first element of the unsorted portion |
| Insertion Sort | Сортировка вставками | `O(n^2)` | `O(1)` | Select one of the input data elements and insert it to the desired position in the already sorted part of the array |
| Merge Sort | Сортировка слиянием | `O(log n)` | `O(n)` | Split an array in half, sort the halves and merge them |
| Quick Sort | Быстрая сортировка | `O(log n)` | `O(log n)` | Select a pivot element, partition the input array around the pivot, and recursively sort the sub-arrays on either side of the pivot |
| Bucket Sort | Карманная сортировка | `O(log k n)` | `O(n)` | Distribute the elements into `k` number of pockets, sort them inside the pockets, from each pocket the data is written to the array in the order of division |
| Heap Sort | Сортировка кучей | `O(log n)` | `O(1)` | Build a max (or min) heap from the input array, then repeatedly extract the root element (max or min) and restore the heap property |