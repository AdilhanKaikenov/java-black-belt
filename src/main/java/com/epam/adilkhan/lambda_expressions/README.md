**Lambda expressions**

Lambda expressions are a new way to do the same, but in a cleaner and shorter way of using anonymous 
inner classes.

Lambda expressions bring functionality to Java. Lambda expressions are a way to visualize functional 
programming in the object-oriented Java world. In functional language, lambda expressions are functions; 
but in Java, lambda expressions are represented by objects, and must be associated with a specific object 
type called a **functional interface**. Functional interface should contain only one single method without 
implementation (abstract method).

The main advantage of the functional interface is that we can use lambda expressions to instantiate and, 
as a result, avoid using large implementations of the anonymous class.

Example:
```java
filterStudentsByCheck(students, (Student student) -> {return student.age <= 20;});
```

Even shorter.
```java
filterStudentsByCheck(students, student -> student.age <= 20);
```

External variables can be used in a lambda expression if they are final or if not changed:
Even shorter.
```java
public static void main(String[] args){
    int i = 10;
    method(() -> System.out.println(i););
}

public static void main(String[] args){
    int i = 10;
    i++;
    method(() -> System.out.println(i);); // compile error
}
```