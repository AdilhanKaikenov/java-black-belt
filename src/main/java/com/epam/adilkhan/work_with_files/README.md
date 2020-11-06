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

**Interface Path & class Files**  
An object of type Path represents the path to a file or directory.

```java
Path path= Paths.get(“text1.txt”);
```

Path Methods: 
```java
path.getFileName();
path.getParent();
path.getRoot();
path.is Absolute();
path.toAbsolutePath();
path1.resolve(path2); 
path1.relativize(path2);
```

Files Methods: 
```java
Files.exists(path);
Files.createFile(path);
Files.createDirectory(path);

Files.isReadable();
Files.isWritable();
Files.isExecutable();

Files.isSameFile(path1, path2);
Files.size();
Files.getAttribute(path, attribute_name);
Files.readAttributes(path, attributes);
```

More Files Methods:
```java
Files.copy(path1, path2, copy_options);
Files.copy(txtFilePath, directoryPath.resolve(txtFilePath), StandardCopyOption.REPLACE_EXISTING);

Files.move(path1, path2, copy_options);
/// We can rename file
Files.move(Path.get("text_file_1.txt"), Path.get("renamed_text_file_2.txt"))

Files.delete(path);
Files.write(path, byte_array);
Files.readAllLines(path);
```

**Files.walkFileTree**  
The Files.walkFileTree (Path start, FileVisitor visitor) method is used to traverse the file tree.  
The logic for traversing the file tree is in a class that implements the FileVisitor interface.  
- preVisitDirectory - fires before accessing folder items;
- visitFile - fires when accessing a file;
- postVisitDirectory - fires after accessing all items in the folder;
- visitFileFailed - fires when a file is unavailable for some reason.

**enum FileVisitResult**  
FileVisitResult values:  
- CONTINUE means that you need to continue crawling through files;
- TERMINATE means that you need to immediately stop crawling through files;
- SKIP_SUBTREE - means that you do not need to enter this directory;
- SKIP_SIBLINGS - means that you do not need to continue crawling through files in this directory.