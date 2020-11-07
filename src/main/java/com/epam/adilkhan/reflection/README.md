**Reflection**  
Reflection is a mechanism for exploring data about a program during its execution.  
Reflection allows you to explore information about fields, methods, constructors, and other constituent classes.  

Instances of the class Class (package java.lang) are classes and interfaces in a running Java application. 
```java
Class clazz= Class.forName(“package_name.Class_name”);
Class clazz= Class_name.class;
Class_namec = new Class_name();
Class clazz= c.getClass();
```

Reflection methods:
```java
getField();
getType();
getFields();
getName();
getDeclaredFields();
getMethod();
getReturnType();
getParameterTypes();
getMethods();
getDeclaredMethods();
isPublic();
getModifiers();
getConstructor();
getParameterCount();
getConstructors();
newInstance();
invoke();
setAccessible();
get();
set();
```

**Difference between getMethods() and getDeclaredMethods()**    
Note: `getDeclaredMethods()` includes all methods declared by the class itself, whereas `getMethods()` 
returns only public methods, but also those inherited from a base class (here from `java.lang.Object`)
