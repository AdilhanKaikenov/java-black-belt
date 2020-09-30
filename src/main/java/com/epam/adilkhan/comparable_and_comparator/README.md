**Comparable in Java**  

The Comparator interface is used to compare objects using natural ordering.
Comparable interface contains only one method, i.e., compareTo(). The  compareTo() method is used to compare 
the given object with the current object. The compareTo() method returns an int value. The value can be 
either positive, negative, or zero.  

- Comparable interface is used to sort the objects with natural ordering.
- Comparable interface compares “this” reference with the object specified.
- Comparable is present in java.lang package.
- Comparable affects the original class, i.e., the actual class is modified.
- Comparable provides compareTo() method to sort elements.

```java
@Override
public int compareTo(Employee anotherEmployee) {
    if (this.id == anotherEmployee.id) {
        return 0;    
    } else if (this.id < anotherEmployee.id) {
        return -1;    
    } else {
        return 1;    
    } 
}
```

```java
@Override
public int compareTo(Employee anotherEmployee) {
    return this.id - anotherEmployee.id; 
}
```

```java
@Override
public int compareTo(Employee anotherEmployee) {
    return this.id.compareTo(anotherEmployee.id); 
}
```

**Comparator in Java**  

The Comparator interface is used to compare objects using non-natural ordering. 

- Comparator in Java is used to sort attributes of different objects.
- Comparator in Java compares two different class objects provided.
- Comparator is present in the java.util package.
- Comparator doesn’t affect the original class
- Comparator provides compare() method, equals() method to sort elements.

Employees are sorted in a natural order by first and last name, but if at some point it is necessary to sort 
employees by ID or salary, then we cannot constantly change the `compareTo(Employee anotherEmployee)` method. 
In this case, a comparator can be created and used as a second parameter and the sorting rules will be rewritten.