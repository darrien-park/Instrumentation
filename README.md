# SOFT437-A3
**Overview:**

This is an group project. In this project, you are going to design a class to instrument a program so we can monitor its performance and uncover any performance problems. This instrumentation class is to be developed in Java. The instrumentation class can be inserted into your program to track the time consumption of blocks, function calls, and statements. For example, the following code shows how to use the instrumentation class. ins is an instrumentation object. 

```java
ins.startTiming(“loop”);
for (int i=0; i<100000; i++)
{
	int j=i;
}
ins->stopTiming(“loop”);
```

As a result, an instrumentation log file is produced and contains:
```
STARTTIMING: loop
STOPTIMING: loop 2ms
```
**Class Description:**

The instrumentation class will consist of the following methods:

>startTiming(string comment) – start timing a  method, or block of code

>stopTiming(string comment) – stop timing a method, or block of code

>comment(string comment) – place an additional comment in the output of the instrumentation log file

>dump(string filename) – dump() writes formatted/indented pairs of startTiming/stopTiming statements to a human readable log file.  If you provide NULL as filename then a logfile will be created with the timestamp instrumentationddyyMMhhmmss.log.  You should call this method ONCE at the end of a program that uses the instrumentation class.

>activate(bool onoff) – activates/deactivates instrumentation.  You should call this ONCE at the beginning of any program that uses the instrumentation class.  Pass in false and the calls to all instrumentation methods will return immediately with no effect.  The class behaves as if activate(false) was called by default.

Here’s an example which ties all of these methods together:
```Java
...
Instrumentation ins=Instrumentation.Instance();

void main()
{
   ins.activate(true);
   ins.startTiming(“main”);
   ...
   ins.startTiming(“loop”);
   for (int i=0; i<5; i++) 
   {
      doSomeStuff();
   }
   ins.stopTiming(“loop”);
   ...
   ins.comment(“this is an example of a comment!”);
   ins.stopTiming(“main”);
   ins.dump();
 
}

void doSomeStuff();
{
   ins.startTiming(“doSomeStuff()”);
 
   System.out.println(“Hello there!”);

   Ins.stopTiming(“doSomeStuff()”);
}
```


Will produce the following instrumentation log output:

```
STARTTIMING: main
|  STARTTIMING: loop
|  |  STARTTIMING: doSomeStuff()
|  |  STOPTIMING: doSomeStuff() 1ms
|  |  STARTTIMING: doSomeStuff()
|  |  STOPTIMING: doSomeStuff() 1ms
|  |  STATTIMING: doSomeStuff()
|  |  STOPTIMING: doSomeStuff() 1ms
|  |  STARTTIMING: doSomeStuff()
|  |  STOPTIMING: doSomeStuff() 1ms
|  |  STARTTIMING: doSomeStuff()
|  |  STOPTIMING: doSomeStuff() 1ms
|  STOPTIMING: loop 5ms
|  COMMENT: this is an example of a comment!
STOPTIMING: main 5ms
TOTAL TIME: 5ms
```

You instrumentation class should follow the Singleton Design Pattern as documented in “Design Patterns: Elements of Reusable Object-Oriented Software” by Gamma, Helm, Johnson and Vlissides, ISBN 0-201-63361-2.  A singleton is a class for which there can be only one instance.  The class ITSELF manages this through the use of a protected constructor and a static “Instance()” method.  Logging classes are well suited to the singleton design pattern. More references can be found at https://www.tutorialspoint.com/design_pattern/singleton_pattern.htm

**Test drive your instrumentation class:**

Once you are happy with your instrumentation class, you should try it out by answering these questions.

1)	What is the overhead of the instrumentation itself? There are two resources consumed when calling startTiming and stopTiming which make up the bulk of the time consumed by your instrumentation calls.  Design several tests which measure the overhead of these resources and report on them.
•	BubbleSort at http://disi.unal.edu.co/~gjhernandezp/aa/sortanim/waterloo/BubbleSort2Algorithm.java, 
•	QuickSort at http://disi.unal.edu.co/~gjhernandezp/aa/sortanim/waterloo/NaiveQuickSortAlgorithm.java, 
•	MergeSort at http://disi.unal.edu.co/~gjhernandezp/aa/sortanim/waterloo/ExtraStorageMergeSortAlgorithm.java
•	SelectionSort at http://disi.unal.edu.co/~gjhernandezp/aa/sortanim/waterloo/SelectionSortAlgorithm.java
modify the code necessary to make them run.
NOTE: All of these classes extend SortAlgorithm Class which is available below
http://disi.unal.edu.co/~gjhernandezp/aa/sortanim/waterloo/SortAlgorithm.java
2)	Write a test class to run all the sorting algorithms. In the test class, write a method, called populateArray(), which generates an array and fills the array with random numbers from 1 to 99999.  Then have another four methods to sort the array using all sorting algos 
3)	What are the running times for all the algorithms?  Which algorithm takes more time?  Why?
4)	What are the running times for the main and populateArray functions?
5)	Add instrumentation to the BubbleSort class. Based on your answer to (1), predict the new running time for the BubbleSort algorithm.  Run the program.  Is the new running time inline with the instrumentation overhead you predicted?  Why or why not?  
6)	Do step 5 for rest of the three algorithms as well
