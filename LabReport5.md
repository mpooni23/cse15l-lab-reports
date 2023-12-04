# Week 9 - Putting it All Together

# PART 1

For this lab report, we are asked to describe a debugging scenario as a conversation on Edstem. It should start with a original post from a student showing a symptom and a description of a guess at some possible bug with some sense of what the failure-inducing input is. It should have a response from a TA asking a leading question or suggesting a command to try. There should be a screenshot/terminal output showing what information the student got from trying the TAs suggestion, and a clear description of what the bug is. It should involve at least a Java file and a bash script. Describing the bug should involve reading some output at the terminal resulting from running one or more commands.

# **1.  EdStem Post and Response**

Post from Student:
Hello, I am experiencing an issue with my code, where I am trying to merge two sorted lists of integers into a single list, by calling a method called **merge**. The **merge** method takes the two sorted lists as its parameters. The merge algorithm runs a while loop, running from the beginning to the lengths of the lists comparing elements in the first list with the elements in the second list. It starts the comparison starting from index 0 of the first list, with the element at index 0 of the second list. The smaller of the two elements gets added to a new combined list and its inex fgets incremented. Also the index of the list from which the element was copied to the new combined list gets incremented. However, I seem to be running into a series of bugs while running the Junits. It says "array lengths differed, expected.length=4 actual.length=2;". I can't decipher how to fix them. My guess here is definitely something to do with the way the integers are being added to the merged list. Any advice would be helpful! I've included the output of the junit tests below to showcase the bugs.

```
[cs15lfa23nz@ieng6-201]:lab7:262$ ./test.sh
JUnit version 4.13.2
.E.E
Time: 0.02
There were 2 failures:
1) testMerge1(ListExamplesTests)
array lengths differed, expected.length=4 actual.length=2; arrays first differed at element [2]; expected:<x> but was:<end of array>
        at org.junit.internal.ComparisonCriteria.arrayEquals(ComparisonCriteria.java:89)
        at org.junit.internal.ComparisonCriteria.arrayEquals(ComparisonCriteria.java:28)
        at org.junit.Assert.internalArrayEquals(Assert.java:534)
        at org.junit.Assert.assertArrayEquals(Assert.java:285)
        at org.junit.Assert.assertArrayEquals(Assert.java:300)
        at ListExamplesTests.testMerge1(ListExamplesTests.java:12)
        ... 9 trimmed
Caused by: java.lang.AssertionError: expected:<x> but was:<end of array>
        at org.junit.Assert.fail(Assert.java:89)
        at org.junit.Assert.failNotEquals(Assert.java:835)
        at org.junit.Assert.assertEquals(Assert.java:120)
        at org.junit.Assert.assertEquals(Assert.java:146)
        at org.junit.internal.ComparisonCriteria.arrayEquals(ComparisonCriteria.java:87)
        ... 15 more
2) testMerge2(ListExamplesTests)
array lengths differed, expected.length=6 actual.length=4; arrays first differed at element [4]; expected:<d> but was:<end of array>
        at org.junit.internal.ComparisonCriteria.arrayEquals(ComparisonCriteria.java:89)
        at org.junit.internal.ComparisonCriteria.arrayEquals(ComparisonCriteria.java:28)
        at org.junit.Assert.internalArrayEquals(Assert.java:534)
        at org.junit.Assert.assertArrayEquals(Assert.java:285)
        at org.junit.Assert.assertArrayEquals(Assert.java:300)
        at ListExamplesTests.testMerge2(ListExamplesTests.java:19)
        ... 9 trimmed
Caused by: java.lang.AssertionError: expected:<d> but was:<end of array>
        at org.junit.Assert.fail(Assert.java:89)
        at org.junit.Assert.failNotEquals(Assert.java:835)
        at org.junit.Assert.assertEquals(Assert.java:120)
        at org.junit.Assert.assertEquals(Assert.java:146)
        at org.junit.internal.ComparisonCriteria.arrayEquals(ComparisonCriteria.java:87)
        ... 15 more

FAILURES!!!
Tests run: 2,  Failures: 2

[cs15lfa23nz@ieng6-201]:lab7:263$
```
# **2. Response From TA**

Hi there! Can you please send me a private post with your code listing. It would really help me to try it out on my side to figure out any issues. From the errors that you are able to see in your junits, it is obvious that the length of the combined array is lesser than the expected size. Let's analyze this a little bit.

One of the most obvious reasons this could happen is if there is a bug in incrementing the indices of the arrays. Are you correctly incrementing the indices of the list from which an element has been promoted to the combined list ? Secondly, also see if the legnths of your sorted lists are different. If not, while comparing and promoting elements to the combined array, you could see a premature termination as the shorter list might run out of elements. These are the few points I might consider initially based on your error description.

Best, 
Your TA

# **3. Another screenshot/terminal output showing what information the student got from trying that, and a clear description of what the bug is.**
From Student:

Hi TA, thank you for your suggestions. I inspected my code and I observed that the incrementing of the indices of the arrays was happening properly. It so happens that the while condition has a bug. If we are running through both the lengths of the list, then we might encounter the end of the shorter list ealier than the logner one. But I was surprised in some scenarios I found we were reaching the end of long list earlier than compared to th shorter list.
In the worst case if all the elements of the first list is smaller than the second list, we would reach the end of thefirst lit earlier when ther are still elements in the second list. similarly if the elemnts in the second list are samller than the elements in the first list we might reach reach the end of the second list earlier. So it is a problems where the elements in the first list or the second list are not being copied to the combined list on an early termination of the other list. So I run a loop to copy over the remaining elements from the first list or second list into the combined array based on early while loop termination. This solved the issue.

```
[cs15lfa23nz@ieng6-201]:lab7:271$ ./test.sh
JUnit version 4.13.2
..
Time: 0.015

OK (2 tests)

[cs15lfa23nz@ieng6-201]:lab7:272$
```

# **4a. The file & directory structure needed**
```
[cs15lfa23nz@ieng6-201]:lab7:282$ ls -lR
.:
total 28
-rw-r----- 1 cs15lfa23nz ieng6_cs15lfa23 1461 Dec  3 22:50 ListExamples.class
-rw-r----- 1 cs15lfa23nz ieng6_cs15lfa23 1435 Dec  3 22:50 ListExamples.java
-rw-r----- 1 cs15lfa23nz ieng6_cs15lfa23 1095 Dec  3 22:50 ListExamplesTests.class
-rw-r----- 1 cs15lfa23nz ieng6_cs15lfa23  747 Dec  3 18:16 ListExamplesTests.java
-rw-r----- 1 cs15lfa23nz ieng6_cs15lfa23  152 Dec  3 22:50 StringChecker.class
drwxr-s--- 2 cs15lfa23nz ieng6_cs15lfa23 4096 Dec  3 18:16 lib
-rwxr----- 1 cs15lfa23nz ieng6_cs15lfa23  169 Dec  3 18:16 test.sh

./lib:
total 428
-rw-r----- 1 cs15lfa23nz ieng6_cs15lfa23  45024 Dec  3 18:16 hamcrest-core-1.3.jar
-rw-r----- 1 cs15lfa23nz ieng6_cs15lfa23 384581 Dec  3 18:16 junit-4.13.2.jar
[cs15lfa23nz@ieng6-201]:lab7:283$
```

# **4b. The contents of each file before fixing the bug**

ListExamples.java 

```
import java.util.ArrayList;
import java.util.List;

interface StringChecker { boolean checkString(String s); }

class ListExamples {

  // Returns a new list that has all the elements of the input list for which
  // the StringChecker returns true, and not the elements that return false, in
  // the same order they appeared in the input list;
  static List<String> filter(List<String> list, StringChecker sc) {
    List<String> result = new ArrayList<>();
    for(String s: list) {
      if(sc.checkString(s)) {
        result.add(0, s);
      }
    }
    return result;
  }


  // Takes two sorted list of strings (so "a" appears before "b" and so on),
  // and return a new list that has all the strings in both list in sorted order.
  static List<String> merge(List<String> list1, List<String> list2) {
    List<String> result = new ArrayList<>();
    int index1 = 0, index2 = 0;
    while(index1 < list1.size() && index2 < list2.size()) {
      if(list1.get(index1).compareTo(list2.get(index2)) < 0) {
        result.add(list1.get(index1));
        index1 += 1;
      }
      else {
        result.add(list2.get(index2));
        index2 += 1;
      }
    }
    return result;
  }
}
```
# **4c. Full command line (or lines) you ran to trigger the bug**

```
[cs15lfa23nz@ieng6-201]:lab7:291$ ./test.sh
++ javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar ListExamples.java ListExamplesTests.java
++ java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore ListExamplesTests
JUnit version 4.13.2
.E.E
Time: 0.021
There were 2 failures:
1) testMerge1(ListExamplesTests)
array lengths differed, expected.length=4 actual.length=2; arrays first differed at element [2]; expected:<x> but was:<end of array>
        at org.junit.internal.ComparisonCriteria.arrayEquals(ComparisonCriteria.java:89)
        at org.junit.internal.ComparisonCriteria.arrayEquals(ComparisonCriteria.java:28)
        at org.junit.Assert.internalArrayEquals(Assert.java:534)
        at org.junit.Assert.assertArrayEquals(Assert.java:285)
        at org.junit.Assert.assertArrayEquals(Assert.java:300)
        at ListExamplesTests.testMerge1(ListExamplesTests.java:12)
        ... 9 trimmed
Caused by: java.lang.AssertionError: expected:<x> but was:<end of array>
        at org.junit.Assert.fail(Assert.java:89)
        at org.junit.Assert.failNotEquals(Assert.java:835)
        at org.junit.Assert.assertEquals(Assert.java:120)
        at org.junit.Assert.assertEquals(Assert.java:146)
        at org.junit.internal.ComparisonCriteria.arrayEquals(ComparisonCriteria.java:87)
        ... 15 more
2) testMerge2(ListExamplesTests)
array lengths differed, expected.length=6 actual.length=4; arrays first differed at element [4]; expected:<d> but was:<end of array>
        at org.junit.internal.ComparisonCriteria.arrayEquals(ComparisonCriteria.java:89)
        at org.junit.internal.ComparisonCriteria.arrayEquals(ComparisonCriteria.java:28)
        at org.junit.Assert.internalArrayEquals(Assert.java:534)
        at org.junit.Assert.assertArrayEquals(Assert.java:285)
        at org.junit.Assert.assertArrayEquals(Assert.java:300)
        at ListExamplesTests.testMerge2(ListExamplesTests.java:19)
        ... 9 trimmed
Caused by: java.lang.AssertionError: expected:<d> but was:<end of array>
        at org.junit.Assert.fail(Assert.java:89)
        at org.junit.Assert.failNotEquals(Assert.java:835)
        at org.junit.Assert.assertEquals(Assert.java:120)
        at org.junit.Assert.assertEquals(Assert.java:146)
        at org.junit.internal.ComparisonCriteria.arrayEquals(ComparisonCriteria.java:87)
        ... 15 more

FAILURES!!!
Tests run: 2,  Failures: 2

[cs15lfa23nz@ieng6-201]:lab7:292$
```
# **4d. A description of what to edit to fix the bug**

```
[cs15lfa23nz@ieng6-201]:lab7:304$ git diff ListExamples.java
diff --git a/ListExamples.java b/ListExamples.java
index 4dd46f2..7c67c21 100644
--- a/ListExamples.java
+++ b/ListExamples.java
@@ -34,8 +34,14 @@ class ListExamples {
         index2 += 1;
       }
     }
+    while(index1 < list1.size()) {
+      result.add(list1.get(index1));
+      index1 += 1;
+    }
+    while(index2 < list2.size()) {
+      result.add(list2.get(index2));
+      index2 += 1;
+    }
     return result;
   }
-
-
 }
```
# **4e. Contents of each file after fixing the bug**

```
[cs15lfa23nz@ieng6-201]:lab7:309$ cat ListExamples.java
import java.util.ArrayList;
import java.util.List;

interface StringChecker { boolean checkString(String s); }

class ListExamples {

  // Returns a new list that has all the elements of the input list for which
  // the StringChecker returns true, and not the elements that return false, in
  // the same order they appeared in the input list;
  static List<String> filter(List<String> list, StringChecker sc) {
    List<String> result = new ArrayList<>();
    for(String s: list) {
      if(sc.checkString(s)) {
        result.add(0, s);
      }
    }
    return result;
  }


  // Takes two sorted list of strings (so "a" appears before "b" and so on),
  // and return a new list that has all the strings in both list in sorted order.
  static List<String> merge(List<String> list1, List<String> list2) {
    List<String> result = new ArrayList<>();
    int index1 = 0, index2 = 0;
    while(index1 < list1.size() && index2 < list2.size()) {
      if(list1.get(index1).compareTo(list2.get(index2)) < 0) {
        result.add(list1.get(index1));
        index1 += 1;
      }
      else {
        result.add(list2.get(index2));
        index2 += 1;
      }
    }
    while(index1 < list1.size()) {
      result.add(list1.get(index1));
      index1 += 1;
    }
    while(index2 < list2.size()) {
      result.add(list2.get(index2));
      index2 += 1;
    }
    return result;
  }
}
[cs15lfa23nz@ieng6-201]:lab7:310$ 

```
