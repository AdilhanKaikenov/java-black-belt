**Nested classes**

Nested classes are used when a class needs to be tightly bound to another, to an external one, 
without which it is unnecessary for others.

- Static Nested class
```java
public class TopLevelClass {
    static class StaticNestedClass {}
}
```
- Inner class
```java
public class TopLevelClass {
    class InnerClass {}
}
```
- Local Inner class
```java
public class TopLevelClass {

    public void method() {
        class LocalInnerClass {}
    }
}
```
- Anonymous Inner class 
```java
interface AnonymousInnerClass {
    void method() {}
} 

public class AnonymousDemo {
    public static void main(String[] args){
      AnonymousInnerClass oj1 = new AnonymousInnerClass() { 
          @Override
          public void method() {
            ...
          } 
      }; 
      oj1.method(); 
    }
}
```

**Static Nested class**

- Static Nested class is very similar to a regular outer class, but is inside another class.
- When creating a Static nested class, you need to specify the class that contains it.
```java
TopLevelClass.StaticNestedClass staticClass = new TopLevelClass.StaticNestedClass();
```
- Examples:
```java
public class TopLevelClass {
    public abstract static class AbstractStaticNestedClass {}
    public final static class FinalStaticNestedClass {}
    private static class PrivateStaticNestedClass {}
    public static class PublicStaticNestedClass extends Parent {}
}

public class Parent {}

public class Child extends TopLevelClass.PublicStaticNestedClass {}
```
- Static nested class can contain static and non-static members.
```java
public class TopLevelClass {
    public static class StaticNestedClass {
        String name;
        static int count; 
    }
}
```
- Static nested class can access private members of an outer class, but only static ones.
- Outer class can access private members of Static nested class.
```java
public class TopLevelClass {
    public void method() {
        int count = StaticNestedClass.count;
    
        StaticNestedClass instance = new StaticNestedClass();
        String name = instance.name;
    }

    public static class StaticNestedClass {
        private String name;
        private static int count; 
    }
}
```

**Inner class**

- Each inner class object is associated with an outer class object.
- When creating an object of the inner class, it is always necessary to create an object of the outer class.
```java
public class TopLevelClass {
    public class InnerClass {

    }
}

public class Test {
    public static void main(String[] args){
        TopLevelClass topLevelClass = new TopLevelClass();
        TopLevelClass.InnerClass innerClass = topLevelClass.new InnerClass();
    }
}
```
- Examples
```java
public class TopLevelClass {
    public abstract class AbstractInnerClass {}
    public final class FinalInnerClass {}
    private class PrivateInnerClass {}
    public class PublicInnerClass extends Parent {}
}

public class Parent {}
```
- Inner class can only contain non-static members, but `final static` fields are allowed:
```java
public class TopLevelClass {
    public class InnerClass {
        private final static int CONSTANT = 10; 
        private static int count; // compile error 
    }
}
```
- Inner class can access private members of an outer class.
- The outer class can access the private elements of the inner class by creating its object.
```java
public class TopLevelClass {
    public void method() {
        InnerClass instance = new InnerClass();
        String name = instance.name;
    }

    public class InnerClass {
        private String name;
    }
}
```

**Local Inner class**  

- Local inner class is located in blocks of code such as, for example, a method or constructor.
- Local inner class can not be static and access modifiers can not be defined.
- The scope of the local inner class is the block in which it is located.
- Local inner class can access private members of an outer class.
- Local inner class can access the elements of the block in which it is written, provided that 
they are final (`final int number = 10;`) or effectively final (`int number = 10;`).
```java
public class TopLevelClass {
    public void method(String name) {
        int number = 10;

        class LocalInnerClass implements SomeInterface {
            public void printLocalNumber() {
                System.out.println(number);
                System.out.println(name);
            }   
        }
    }
}
```

**Anonymous Inner class**

- Anonymous inner class has no name.
- Anonymous inner class can be used wherever a local inner.
class is needed and is used much more often than a local inner class.  
- Anonymous inner class is the declaration of the class and at the same time the creation of the object.
- It is impossible to write a constructor in an anonymous class, therefore, for a constructor, 
you need to write a class name, and an anonymous class has no name.
- Anonymous inner class  can access private members of an outer class.
```java
public class TopLevelClass {
    private int number;
    public static void main(String[] args){
        AnonymousInnerClass anonymousInnerClass = new AnonymousInnerClass() {
            @Override
            public void method() {
                TopLevelClass topLevelClass = new TopLevelClass();
                System.out.println(topLevelClass.number);
            }
        };
    }
}
```
- Lambda expressions is a short form of writing anonymous inner classes.
```java
public class TopLevelClass {
    private int number;
    public static void main(String[] args) {
        AnonymousInnerClass anonymousInnerClass = () -> {
            TopLevelClass topLevelClass = new TopLevelClass();
            System.out.println(topLevelClass.number);
        };
    }
}
```