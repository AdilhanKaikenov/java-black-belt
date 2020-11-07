**Annotation**  
- Annotations are descriptors included in the text of the program and are used to store the metadata of the program code required at different stages of the program life cycle.  
- Annotations are special comments / tags / metadata that are needed to convey certain information.  

`@Target` shows the area of code to which the Annotation can be applied. The most common areas of code are:
* TYPE –class, interface, enum;
* FIELD - class field;
* METHOD – class method;
* PARAMETER - parameters of a method or constructor

Annotation is needed to convey information. To whom and where are we going to share this information?
`@Retention` describes the life cycle of an Annotation
* SOURCE –The annotation is visible in the source code, discarded by the compiler and is not visible in the byte code (e.g. Override);
* CLASS –The annotation is visible in the byte code (in a .class file), discarded by the JVM during program execution (default);
* RUNTIME - Annotation is visible during program execution (Can be accessed using reflection).

The`@Inherited` annotation marks an annotation that will be inherited by a descendant of the class marked with such annotation.    
The ChildClass class will inherit only the PublicAnnotate annotation from the parent class.
```java
@Inherited
@interface PublicAnnotate { }

@interface PrivateAnnotate { }

@PublicAnnotate 
@PrivateAnnotate 
class ParentClass { }

class ChildClass extends ParentClass { }
```

