**IO**  

**Character Streams and Byte Streams**  
Stream for working with files is an ordered sequence of data.

Files are divided into
• human readable – text files;
• unreadable for humans – binary files (i.e. pictures).

When working with text and binary files, we need to use different types of streams.

**FileReader & FileWriter**  
FileReader and FileWriter are used to work with text files.
```java
FileWriterwriter = new FileWriter (“file1.txt”);
```

```java
FileReaderreader = new FileReader (“file1.txt”);
```
Never forget to close streams after use.

**BufferedReader & BufferedWriter**  
Buffering is the process of loading a portion of a file that occurs while streaming.  
Using buffering in streams allows you to achieve greater efficiency when reading or writing to a file.  

BufferedReader and BufferedWriter are wrappers that wrap the FileReader and the FileWriter 
and add buffering functionality:
```java
BufferedWriter writer = new BufferedWriter(new FileWriter(“file1.txt”));
```

```java
BufferedReader reader = new BufferedReader(new FileReader(“file1.txt”));
```

Thanks to buffering, we will have much less access to the file, this is the difference between writing and 
reading from a file with and without buffering.

**FileInputStream & FileOutputStream**  
FileInputStream and FileOutputStream are used to work with binary files.

```java
FileInputStream inputStream = new FileInputStream(“test2.bin”);
```

```java
FileOutputStream outputStream = new FileOutputStream(“test2.bin”);
```

**DataInputStream & DataOutputStream**  
DataInputStream and DataOutputStream allow writing to and reading primitive data types from a file.

```java
DataInputStream inputStream = new DataInputStream(new FileInputStream(“test2.bin”));
```

```java
DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(“test2.bin”));
```

**Serialization**  
Serialization is the process of converting an object to a sequence of bytes.  
Deserialization is the process of restoring an object from these bytes.

```java
ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(“test2.bin”));
```

```java
ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(“test2.bin”));
```

* In order for a class object to be serializable, the class must implement the Serializable interface.
* Class fields marked with the transient keyword are not written to the file during serialization.
* In the class being serialized, you must use serialVersionUID to indicate the version of the class.

**RandomAccessFile**  
The RandomAccessFile class allows you to read information from anywhere in a file and write information to any location in the file.

```java
RandomAccessFile file = new RandomAccessFile(“test1.txt”, “rw”);
```

**File class**  
The File class allows you to manage information about files and directories.  
- Absolute path contains complete information about the location of a file or folder.  
- Relative path does not contain complete information about the location of the file, it contains information about where we are.

```java
File file = new File (“test1.txt”);
```

Mathods: getAbsolutePath, isAbsolute, isDirectory, exists, createNewFile, 
mkdir, length, delete, listFiles, isHidden, canRead, canWrite, canExecute

**NIO**  

**Buffers and Channels**  

Buffer - This is a block of memory in which we can write information, as well as read it.  
Unlike streams, a Channel can both read a file and write to it.  

![nio-01](https://raw.githubusercontent.com/AdilhanKaikenov/java-black-belt/master/src/main/java/com/epam/adilkhan/work_with_files/etc/nio-01.jpg)

Reading a file: Channel reads information from a file and writes to Buffer.  
Write to file: Channel reads information from Buffer and writes it to file.  


