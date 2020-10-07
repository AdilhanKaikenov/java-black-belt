**Stream**

Stream is a sequence of elements that support sequential and parallel operations on them. Stream methods 
allow you to write fast and powerful code for working with collections, thus they allow you to write code 
in a functional style.

- Stream methods do not change the collection itself or the array from which the stream was created
- Stream after processing cannot be reused otherwise there will be an error
- Intermediate operations will not be processed until the terminal method is called

**Method Reference** 

Method reference is used to refer method of functional interface. It is compact and easy form of lambda 
expression. Each time when you are using lambda expression to just referring a method, you can replace 
your lambda expression with method reference.

```java
interface Sayable{  
    void say();  
}  
public class MethodReference {  
    public static void saySomething(){  
        System.out.println("Hello, this is static method.");  
    }  
    public static void main(String[] args) {  
        // Referring static method  
        Sayable sayable = MethodReference::saySomething;  
        // Calling interface method  
        sayable.say();  
    }  
}    
```

```java
interface Sayable{  
    void say();  
}  
public class InstanceMethodReference {  
    public void saySomething(){  
        System.out.println("Hello, this is non-static method.");  
    }  
    public static void main(String[] args) {  
        InstanceMethodReference methodReference = new InstanceMethodReference(); // Creating object  
        // Referring non-static method using reference  
            Sayable sayable = methodReference::saySomething;  
        // Calling interface method  
            sayable.say();  
            // Referring non-static method using anonymous object  
            Sayable sayable2 = new InstanceMethodReference()::saySomething; // You can use anonymous object also  
            // Calling interface method  
            sayable2.say();  
    }  
}  
```

**Stream methods Intermediate and Terminal**

- Intermediate methods (lazy)
- Terminal method (eager)

`Source(collection) -> Stream -> Intermediate methods -> Terminal method`

All intermediate operations return Stream (can be chained), while terminal operations don't.
Intermediate operations will not be processed until the terminal method is called, 
therefore Intermediate operations are called lazy.

Intermediate Operations are:

- filter(Predicate<T>)
- map(Function<T>)
- flatMap(Function<T>)
- sorted(Comparator<T>)
- peek(Consumer<T>)
- distinct()
- limit(long n)
- skip(long n)  

Terminal operations produces a non-stream (cannot be chained) result such as primitive value, a collection or no value at all.

Terminal Operations are:

- forEach
- forEachOrdered
- toArray
- reduce
- collect
- min
- max
- count
- anyMatch
- allMatch
- noneMatch
- findFirst    
- findAny