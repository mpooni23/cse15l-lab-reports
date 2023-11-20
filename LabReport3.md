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

# **4. The bug, as the before-and-after code change required to fix it (as two code blocks in Markdown)**

```
    static int[] reversed(int[] arr) {
        int[] newArray = new int[arr.length];
        for(int i = 0; i < arr.length; i += 1) {
          arr[i] = newArray[arr.length - i - 1];
        }
        return arr;
    }
```

```
    static int[] reversed(int[] arr) {
      int[] newArray = new int[arr.length];
      for(int i = 0; i < arr.length; i += 1) {
        newArray[i] = arr[arr.length - i - 1];
      }
      return newArray;
    }
```

# PART 2

1. find . -name "Chapter*.*" -print
2. find . -type d -print
3. find . -type d -size +1k 
4. find . -type f -name "chapter*.*" -print 
5. find . -name "Chapter*.*" -exec wc -l {} \;
6. find . -name "*.*" -exec grep -nH "Tuesday, September 11, 2001" {} \;
7. find . -name "*.java" -exec grep -nH "Collections.sort" {} \; 


