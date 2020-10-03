**Generics**  

Generics are parameterized types. They can be used to declare classes, 
interfaces and methods, where the data type is specified as a parameter.

Two main reasons for the existence of generalizations:

- Type safe. Allows identifying errors at the compilation level. 
Compilation errors are always better than runtime errors.
- Reusable code. Make it possible not to create a similar code, 
and use it for different types. 

**Parametrized method**  

```java
public static <T> T getSecondElement(List<T> list) {
    return list.get(1);
}
```

The parameter `<T>` must be specified to say that the method is parameterized, if the parameter is specified 
at the class level `public class ParametrizedMethod<T> {...}`, then it does not have to be specified 
at the method level.

**Type erasure**  

Generics appeared in version 5 of Java and needed to maintain **backward compatibility** - 
this means that code that works with generics should work fine with code that does 
not use generics.

For example, when it is written like this, the compiler sees it and everything is fine:
```java 
List<String> list = new ArrayList<>();
String str = list.get(0);
```

But at runtime all type information is removed. JVM sees it as:
```java 
List list = new ArrayList();
String str = (String) list.get(0);
```
That is, only the compiler knows information about generics for the checks it needs.
The virtual machine does not see parameterized types. This process is called type erasure.  
This is necessary to maintain backward compatibility of the code.  

There is no concept of generics for a virtual machine. Generics information is erased. 
For a virtual machine, after compilation, there is no information about `<T>`. Instead of `<T>`, 
an Object is written, because this is the original class that all classes inherit.

Example:
```java
class Info<T> {
    private T value;

    public Info(T value) {
        this.value = value;
    }
}
```

After compilation:
```java
class Info {
    private Object value;

    public Info(Object value) {
        this.value = value;
    }
}
```

**Overloading**  

Generics prevent us from creating overloaded methods:  

```java 
public void methodName(List<String> list) { // compile error
    ...
}

public void methodName(List<Integer> list) {
    ...
}
```

**Overwriting**  

Generics prevent us from overwriting methods when changing the parameter type in the overridden method:  
```java 

class Parent {
    public void methodName(List<String> list) { 
        ...
    }
}

class Chind extends Parent {
    public void methodName(List<Integer> list) { // compile error
        ...
    }
}


```

**Subtyping**  

```java
class Parent {

}

class Child extends Parent {

}
```

We can create a Child object and assign it to the Parent variable: 
```java
Parent instance = new Child();
```

But we can't do the same with generics:
```java
List<Parent> list = new ArrayList<Child>(); // compile error
```

Despite the fact that `class Child extends Parent` and `ArrayList implements List` it is not working, 
because together `ArrayList<Child>` is not a subtype of `List<Parent>`.

Detailed explanation:
```java
List<Number> list = new ArrayList<Integer>(); // compile error
list.add(18); // integer
list.add(3.14); // double
```

`Integer extends Number` and `Double extends Number`, but `new ArrayList<Integer>` can't contain double values.
So dynamically at runtime this will throw an error. Generics are designed to detect this at compile level.

If we want to constrain the type, we can do the following:
```java
public class Info<T extends Number> {...}
```
Now instead of T, can put only the class 
that is a subclass of Number including Number.

```java
Info<Number> number = new Info<>(1);
Info<Integer> integer = new Info<>(1);
Info<Double> doubleInfo = new Info<>(3.14);
```

Example:
```java
class Info<T extends Number> {
    private T value;

    public Info(T value) {
        this.value = value;
    }
}
```

After compilation:
```java
class Info {
    private Number value;

    public Info(Number value) {
        this.value = value;
    }
}
```

Example with interfaces:

```java
interface I1 {}
interface I2 {}

class Parent {

}

class Child<T extends Parent&I1&I2> {

}
```

**Wildcards**

Java Generic's wildcards is a mechanism in Java Generics aimed at making it possible to cast a collection 
of a certain class, e.g A, to a collection of a subclass or superclass of A. 

```java
// no problem
Object obj = new String("Test!");;

// compilation error
List<Object> objects = new ArrayList<String>();;
```

There is an important difference between an object and a collection of objects.
If class B inherits from class A, then `Collection <B>` is not inherited from `Collection <A>`.

The generic wildcard operator is a solution to the problem explained above:

```java
List<?>           listUknown = new ArrayList<A>();
List<? extends A> listUknown = new ArrayList<A>();
List<? super   A> listUknown = new ArrayList<A>();
```
- `<?>` - any class
- `<? extends X>` - class X or any of its subclasses
- `<? super X>` - class X or any of its superclasses

**Note (!)**

```java
List<?> list = new ArrayList<>();
list.add("text"); // compile error
```

The compiler does not allow this. When we use a sign, we are telling the compiler that anything can be here, 
so the type is unknown, there can be any type. Every time we try to add a value to the list, the compiler 
tries to check the type we are trying to add with the type of the list, but in this case the compiler does not 
know what type the list is, so it considers it very risky to add any value to the list whose type it does not 
know.

