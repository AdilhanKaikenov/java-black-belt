**Collection**  

![collection-01](https://raw.githubusercontent.com/AdilhanKaikenov/java-black-belt/master/src/main/java/com/epam/adilkhan/collection/etc/collection-01.jpg)

Collection is some kind of container, that is, a collection of objects that we store together. 
All collections work with **generics**, that is, they work with objects of a certain type. 
All collections derive from the **Collection** interface, which derives from the **Iterable** interface. 
Due to **Iterable** interface, all the collections can be used in the construction **forEach**. 

**If it is assumed that objects will be stored in a collection, then it is good practice to override the 
equals and hashcode methods.**

**List**  

![collection-02](https://raw.githubusercontent.com/AdilhanKaikenov/java-black-belt/master/src/main/java/com/epam/adilkhan/collection/etc/collection-02.jpg)

**List** is the basic collection interface that contains ordered items. Allows to store duplicates and null. 
Each element has an index.

**ArrayList** is an array that can change its length. It is based on an array of Object.

When ArrayList is created, an array with size 10 is created behind the scenes. If the array is empty, 
its size is zero and its default capacity is 10. If 10 items are added to the list and an 11th item 
is added, then a new array will be created which will copy all 10 elements from the previous array and 
give a certain amount of free space, that is, the size of the array will be increased. When this array 
is full, an even larger array will be created. All these operations require a certain amount of time, 
and therefore if the number of elements that the array will store is known in advance, then you can 
create a list indicating its initial capacity. Thus, the speed of adding items to the list can be increased.

```java
ArrayList<Integer> list = new ArrayList<>(300);
```

**ArrayList Note (!)**
```java
List<String> arrayList = new ArrayList<>();
arrayList.add("Zaur");
arrayList.add("Misha");
arrayList.add("Mariya");

arrayList.add(6, "Ivan"); // Exception java.lang.IndexOutOfBoundsException: Index: 6, Size: 3
```
Methods and related methods:  

![collection-03](https://raw.githubusercontent.com/AdilhanKaikenov/java-black-belt/master/src/main/java/com/epam/adilkhan/collection/etc/collection-03.jpg)
![collection-04](https://raw.githubusercontent.com/AdilhanKaikenov/java-black-belt/master/src/main/java/com/epam/adilkhan/collection/etc/collection-04.jpg)

`List.of(E... elements)` and `List.copyOf(Collection<E> c)` cannot be modified and contain null.

**Iterator**  

The main difference between Iterator and forEach is that it is possible to delete an element during iteration.

```java
List<String> arrayList = new ArrayList<>();
arrayList.add("Zaur");
arrayList.add("Misha");
arrayList.add("Mariya");

Iterator<String> iterator = arrayList.iterator();
while (iterator.hasNext()) {
    iterator.next(); // required
    iterator.remove();
}
```

**LinkedList**  

The elements of a linked list - the links of one chain. These elements store specific data, as well as links to the 
previous and next element. It is based on a chain, not an array.

![collection-05](https://raw.githubusercontent.com/AdilhanKaikenov/java-black-belt/master/src/main/java/com/epam/adilkhan/collection/etc/collection-05.jpg)

When adding an element to the middle of the list or removing it, all that will be done is the replacement 
of links (**but this element needs to be reached**) and everything else in the list will not be affected, 
unlike ArrayList.

As a general rule, a linked list should be used:
1) The number of operations for obtaining elements is small;
2) The number of operations for adding and removing elements is large. 
Especially when it comes to elements at the beginning of the collection.

**ListIterator**  

It extends the capabilities of the Iterator and in it you can work not only with each next element, 
but also with the previous one.

```java
String s = "madam";

LinkedList<Character> characters = new LinkedList<>();
for (char ch : s.toCharArray()) {
    characters.add(ch);
}

ListIterator<Character> listIterator = characters.listIterator();
ListIterator<Character> reverseIterator = characters.listIterator(characters.size());

boolean isPalindrome = true;
while (listIterator.hasNext() && reverseIterator.hasPrevious()) {
    if (listIterator.next() != reverseIterator.previous()) {
        isPalindrome = false;
        break;
    }
}

if (isPalindrome) {
    System.out.println("It is palindrome!");
} else {
    System.out.println("It is not palindrome!");
}
```

**Big O notation**  

This notation is used to describe the complexity of an algorithm. How long does it take to execute certain algorithms.

For example, the most common:
- `O(1)` - an algorithm runs in constant time (The fastest);
- `O(n)` - linear algorithm. Complexity scales linearly (the number of operations increases linearly, the number of elements); 
- `O(log n)` - the simplest example is binary search.

**Equals and Hashcode methods**  

Some collections use hashing when searching and comparing. 
In Java, hashing is a transformation using the hashcode method of any object to an integer.

In HashMap, comparison is performed first by hashcode and then by equals.
These methods must be properly overridden. 
When different objects return the same hash code, this is called a collision.

- The result of executing the hashcode method for the same object must be the same.
- If, according to the equals method, two objects are equal, then the hashcode of these objects must be the same.
- If, according to the equals method, two objects are not equal, then the hash code of these objects does not have to be different.

**Map**  

![map-01](https://raw.githubusercontent.com/AdilhanKaikenov/java-black-belt/master/src/main/java/com/epam/adilkhan/collection/etc/map-01.jpg)

**HashMap** elements are key / value pairs (just like all Map). HashMap does not remember the order in 
which elements are added. His methods are very fast.

- Item keys must be unique. If we put a value with a key that already exists, 
then the value of the existing key is overwritten.
- The key can be null. 
- Element values can be repeated. 
- Values can be null.

![map-02](https://raw.githubusercontent.com/AdilhanKaikenov/java-black-belt/master/src/main/java/com/epam/adilkhan/collection/etc/map-02.jpg)

HashMap is based on an array. The elements of this array are LinkedList structures. 
The LinkedList structure data is filled with elements that we add to the HashMap. Also, the elements of an array in a 
HashMap are called baskets. Baskets contain HashMap elements.

![map-03](https://raw.githubusercontent.com/AdilhanKaikenov/java-black-belt/master/src/main/java/com/epam/adilkhan/collection/etc/map-03.jpg)

When creating a HashMap, two parameters can be specified that affect performance:
- Initial capacity - Initial size of the array (DEFAULT_INITIAL_CAPACITY = 16); 
- Load factor - The coefficient of how much the array should be filled, after which 
its size should be doubled 
(16 * 0,75 = 12 -> after the 12th element, the capacity will be doubled and all elements will be rehashed).

**TreeMap**  

The elements of a TreeMap are a key / value pair. In TreeMap, items are stored in ascending sorted order.
Sorted by key.

TreeMap is based on a red-black tree. This allows methods to run faster, but not faster than HashMap.

We cannot use null in TreeMap as a key and we cannot use classes that do not implement the Comparable 
interface as a key in TreeMap. Alternatively a comparator can be passed to the constructor when creating 
the TreeMap.

```java
TreeMap<Student, Double> treeMap = new TreeMap<>(new Comparator<Student>() {
    @Override
    public int compare(Student o1, Student o2) {
        return 0;
    }
});
```
When working with TreeMap, there is no need to override equals and hashcode for the key object.
Because search, add and delete (except contains) by key are done using the compareTo method.

Thanks to the red-black tree, the work of methods such as containsKey, remove, get, 
put is processed in O (log n).

![map-04](https://raw.githubusercontent.com/AdilhanKaikenov/java-black-belt/master/src/main/java/com/epam/adilkhan/collection/etc/map-04.jpg)

**LinkedHashMap**

LinkedHashMap inherits from HashMap. Stores information about the order in which elements are 
added or the order in which they are used. Method performance is slightly lower than that of HashMap.

```java
LinkedHashMap<Double, Student> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
```

**Set**

Set is a collection that stores unique elements. The methods in this collection are very fast.

![set-01](https://raw.githubusercontent.com/AdilhanKaikenov/java-black-belt/master/src/main/java/com/epam/adilkhan/collection/etc/set-01.jpg)

Any Set is based on a stripped-down version of Map. At the heart of a HashSet is a HashMap object. 
For the elements of this HashMap: keys are elements of the HashSet, and values are a stub constant. 
Set has no get method.

```java
public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, java.io.Serializable {
    ...
    private transient HashMap<E,Object> map;    

    // Dummy value to associate with an Object in the backing Map
     private static final Object PRESENT = new Object();

    /**
     * Constructs a new, empty set; the backing <tt>HashMap</tt> instance has
     * default initial capacity (16) and load factor (0.75).
     */
    public HashSet() {
        map = new HashMap<>();
    }

    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }
    ...
}
```

Set operations:  
- `addAll` - union (объединение)
- `retainAll` - intersect (пересечение)
- `removeAll` - subtract (разность)

**TreeSet**  

TreeSet stores items in sorted order. TreeSet is based on TreeMap. For the elements of this TreeMap: 
keys are elements of the TreeSet, and values are a stub constant.

![set-02](https://raw.githubusercontent.com/AdilhanKaikenov/java-black-belt/master/src/main/java/com/epam/adilkhan/collection/etc/set-02.jpg)

**LinkedHashSet**

LinkedHashSet inherits from HashSet. Stores information about the order in which elements are 
added. Method performance is slightly lower than that of HashMap.

At the heart of a LinkedHashSet is a HashMap object. For the elements of this HashMap: keys are elements 
of the LinkedHashSet, and values are a stub constant.

**Queue**  

Queue is a collection that stores a sequence of items. An element is added to the end of the queue, used 
from the head of the queue - FIFO rule.

![queue-01](https://raw.githubusercontent.com/AdilhanKaikenov/java-black-belt/master/src/main/java/com/epam/adilkhan/collection/etc/queue-01.jpg)

![queue-02](https://raw.githubusercontent.com/AdilhanKaikenov/java-black-belt/master/src/main/java/com/epam/adilkhan/collection/etc/queue-02.jpg)

**PriorityQueue**

PriorityQueue is a special kind of queue that uses a natural sort or one that we describe with a Comparable or Comparator.
Thus, the element from the queue is used, the priority of which is higher.

**Deque** 

Deque - double ended queue (bidirectional queue). In such a queue, items can be used at both ends. 
Both rules work here - FIFO and LIFO.

![deque-01](https://raw.githubusercontent.com/AdilhanKaikenov/java-black-belt/master/src/main/java/com/epam/adilkhan/collection/etc/deque-01.jpg)