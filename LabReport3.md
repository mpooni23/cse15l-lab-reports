# Week 4 - Testing and Files

# PART 1
A failure-inducing input for the buggy program, as a JUnit test and any associated code (write it as a code block in Markdown)


# **1. A failure-inducing input for the buggy program, as a JUnit test and any associated code (write it as a code block in Markdown)**

```
    @Test
    public void testReversedOddElements() {
        int[] input1 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, ArrayExamples.reversed(input1));
    }
```

# **2. An input that doesn’t induce a failure, as a JUnit test and any associated code**

```
    @Test
    public void testReversed() {
        int[] input1 = {};
        assertArrayEquals(new int[]{}, ArrayExamples.reversed(input1));
    }
```

# **3. The symptom, as the output of running the tests (provide it as a screenshot of running JUnit with at least the two inputs above)**

![Image](Symptom.png)

The symptom appears to say that the arrays differed at the element location zero. This means there is an mismatch between the expected output and actual output

# **4. The bug, as the before-and-after code change required to fix it (as two code blocks in Markdown)**

The before code is as follows :

```
    static int[] reversed(int[] arr) {
        int[] newArray = new int[arr.length];
        for(int i = 0; i < arr.length; i += 1) {
          arr[i] = newArray[arr.length - i - 1];
        }
        return arr;
    }
```

The fix is given below :

```
    static int[] reversed(int[] arr) {
      int[] newArray = new int[arr.length];
      for(int i = 0; i < arr.length; i += 1) {
        newArray[i] = arr[arr.length - i - 1];
      }
      return newArray;
    }
```

The reason for the bug is even though a newArray has been created with the same length as the old array arr, the assignment withint the loop is incorrect. The old array is being assingmed values for the newly created array.
Hence all the elements in the old array will be set to 0.  Als0 the function incorrectly return the old array.  As part the fix, the assignments is reversed where the new array is assigned values from the old arrya and the contents of the new array is being returned from the function.

# PART 2

1. find . -name "Chapter*.*" -print

```
./911report/chapter-13.4.txt
./911report/chapter-13.5.txt
./911report/chapter-13.1.txt
./911report/chapter-13.2.txt
./911report/chapter-13.3.txt
./911report/chapter-3.txt
./911report/chapter-2.txt
./911report/chapter-1.txt
./911report/chapter-5.txt
./911report/chapter-6.txt
./911report/chapter-7.txt
./911report/chapter-9.txt
./911report/chapter-8.txt
./911report/chapter-12.txt
./911report/chapter-10.txt
./911report/chapter-11.txt
```
2. find . -type d -print

```
.
./government
./government/About_LSC
./government/Env_Prot_Agen
./government/Alcohol_Problems
./government/Gen_Account_Office
./government/Post_Rate_Comm
./government/Media
./plos
./biomed
./911report
```
3. find . -type d -size +1k
   
```
./government/Gen_Account_Office
./government/Media
./plos
./biomed

```
4. find . -type f -name "chapter*.*" -print
   
```
./911report/chapter-13.4.txt
./911report/chapter-13.5.txt
./911report/chapter-13.1.txt
./911report/chapter-13.2.txt
./911report/chapter-13.3.txt
./911report/chapter-3.txt
./911report/chapter-2.txt
./911report/chapter-1.txt
./911report/chapter-5.txt
./911report/chapter-6.txt
./911report/chapter-7.txt
./911report/chapter-9.txt
./911report/chapter-8.txt
./911report/chapter-12.txt
./911report/chapter-10.txt
./911report/chapter-11.txt
```
5. find . -name "Chapter*.*" -exec wc -l {} \;
   
```
 2941 ./911report/chapter-13.4.txt
    3237 ./911report/chapter-13.5.txt
    1089 ./911report/chapter-13.1.txt
    1236 ./911report/chapter-13.2.txt
    1718 ./911report/chapter-13.3.txt
    3159 ./911report/chapter-3.txt
     948 ./911report/chapter-2.txt
     731 ./911report/chapter-1.txt
    1204 ./911report/chapter-5.txt
    1898 ./911report/chapter-6.txt
    1579 ./911report/chapter-7.txt
    1885 ./911report/chapter-9.txt
    1036 ./911report/chapter-8.txt
    1539 ./911report/chapter-12.txt
     603 ./911report/chapter-10.txt
     817 ./911report/chapter-11.txt

```
6. find . -name "*.*" -exec grep -nH "Tuesday, September 11, 2001" {} \;
    
```
grep: .: Is a directory
./911report/chapter-1.txt:6:    Tuesday, September 11, 2001, dawned temperate and nearly cloudless in the eastern United States. Millions of men and women readied themselves for work. Some made their way to the Twin Towers, the signature structures of the World Trade Center complex in New York City. Others went to Arlington, Virginia, to the Pentagon. Across the Potomac River, the United States Congress was back in session. At the other end of Pennsylvania Avenue, people began to line up for a White House tour. In Sarasota, Florida, President George W. Bush went for an early morning run.
```
7. find . -name "*.java" -exec grep -nH "Tuesday" {} \;

```

```
Sources:
https://unix.stackexchange.com/questions/638335/find-command-size-behavior

