**CPEN 221 / Fall 2020 / Exercise 14**

## Honour Code

By submitting your work to Github you agree to the following:

+ You did not consult with any other person in completing the examination.
+ You did not aid any other person in the class in completing their examination.
+ If you consulted any external sources, such as resources available on the World Wide Web, in completing the examination then you have cited the source. (You do not need to cite class notes or Sun/Oracle Java documentation.)
+ You are not aware of any infractions of the honour code for this examination.

> Violations of this honour code will be treated as a case of academic misconduct and will dealt with under UBC policies governing such issues. A consequence of this may be to nullify this exam for everyone that submits work for grading!

# SumSequence
> The skeleton source code for this question is in the package `sumsequence`. You have to implement the required method in the class `SumSequence`.

 Let us define a SumSequence as a sequence, s<sub>1</sub>, s<sub>2</sub>, ..., s<sub>M</sub>, such that s<sub>M</sub> is s<sub>1</sub>+ ... +s<sub>M-1</sub>.

 **Task:** Given an array of `int`s, return a `Map<Integer, Integer>` where, given a key that is an index `i` in the array, the `Map` contains the length of the *longest consecutive subsequence* starting at that index that is a `SumSequence`.

You can use the provided tests as examples to guide your implementation. Once you clone your Github repository, open the skeleton code as a Gradle project.

## Example Test cases

```java
@Test
public void test1() {
  // array contains only one number
  Map<Integer, Integer> expMap = new TreeMap<Integer, Integer>();
  expMap.put(0, 0);
  assertEquals(expMap, SumSequence.getSumSequenceLengths(new int[] { 3 }));
}

@Test
public void test2() {
  // array contains only a few numbers but no SumSequence
  Map<Integer, Integer> expMap = new TreeMap<Integer, Integer>();
  expMap.put(0, 0);
  expMap.put(1, 0);
  expMap.put(2, 0);
  expMap.put(3, 0);
  assertEquals(expMap, SumSequence.getSumSequenceLengths(new int[] { 3, 5, 7, 2 }));
}

@Test
public void test3() {
  // array contains exactly one SumSequence
  // Here 3, 5, 8 is a subsequence that is a SumSequence
  // The length of the subsequence starting at index 0 is 3
  Map<Integer, Integer> expMap = new TreeMap<Integer, Integer>();
  expMap.put(0, 3);
  expMap.put(1, 0);
  expMap.put(2, 0);
  expMap.put(3, 0);
  assertEquals(expMap, SumSequence.getSumSequenceLengths(new int[] { 3, 5, 8, 2 }));
}

@Test
public void test4() {
  // array contains exactly two SumSequences, at different indices
  // Here 3, 5, 8 is a subsequence that is a SumSequence (3+5=8)
  // and 5, 8, 13 is another subsequence that is a SumSequence (5+8=13)
  // The length of the subsequence starting at index 0 is 3
  // The length of the subsequence starting at index 1 is 3
  Map<Integer, Integer> expMap = new TreeMap<Integer, Integer>();
  expMap.put(0, 3);
  expMap.put(1, 3);
  expMap.put(2, 0);
  expMap.put(3, 0);
  assertEquals(expMap, SumSequence.getSumSequenceLengths(new int[] { 3, 5, 8, 13 }));
}

@Test
public void test5() {
  // array contains exactly two SumSequences,
  // both starting at the same index
  // Here 3, 5, 8 is a subsequence that is a SumSequence (3+5=8)
  // and 3, 5, 8, 16 is another subsequence that is a SumSequence (3+5+8=16)
  // The length of the longest subsequence starting at index 0 is 4
  Map<Integer, Integer> expMap = new TreeMap<Integer, Integer>();
  expMap.put(0, 4);
  expMap.put(1, 0);
  expMap.put(2, 0);
  expMap.put(3, 0);
  assertEquals(expMap, SumSequence.getSumSequenceLengths(new int[] { 3, 5, 8, 16 }));
}

@Test
public void test6() {
  // array contains exactly one SumSequences of length 2
  // Here 5, 5 is a subsequence that is a SumSequence (5=5)
  Map<Integer, Integer> expMap = new TreeMap<Integer, Integer>();
  expMap.put(0, 0);
  expMap.put(1, 2);
  expMap.put(2, 0);
  expMap.put(3, 0);
  assertEquals(expMap, SumSequence.getSumSequenceLengths(new int[] { 3, 5, 5, 16 }));
}

@Test
public void test7() {
  // array contains exactly two SumSequences that do not overlap
  // Here 5, 5 is a subsequence that is a SumSequence (5=5)
  // and 8, 3, 11 is a subsequence that is a SumSequence (8+3=11)
  Map<Integer, Integer> expMap = new TreeMap<Integer, Integer>();
  expMap.put(0, 0);
  expMap.put(1, 2);
  expMap.put(2, 0);
  expMap.put(3, 3);
  expMap.put(4, 0);
  expMap.put(5, 0);
  assertEquals(expMap, SumSequence.getSumSequenceLengths(new int[] { 3, 5, 5, 8, 3, 11 }));
}

@Test
public void test8() {
  // an array with -ve values
  Map<Integer, Integer> expMap = new TreeMap<Integer, Integer>();
  expMap.put(0, 0);
  expMap.put(1, 3);
  expMap.put(2, 0);
  expMap.put(3, 0);
  assertEquals(expMap, SumSequence.getSumSequenceLengths(new int[] { 3, 5, -2, 3 }));
}

@Test
public void test9() {
  // an array with 0
  // { 0 } is a SumSequence because the sum of the previous
  // values is the last value
  Map<Integer, Integer> expMap = new TreeMap<Integer, Integer>();
  expMap.put(0, 1);
  assertEquals(expMap, SumSequence.getSumSequenceLengths(new int[] { 0 }));
}
```

## What Should You Implement / Guidelines

+ You should implement all the methods that are indicated with `TODO`.
+ Passing the provided tests is the minimum requirement. Use the tests to identify cases that need to be handled. Passing the provided tests is *not sufficient* to infer that your implementation is complete and that you will get full credit. Additional tests will be used to evaluate your work. The provided tests are to guide you.
+ You can implement additional helper methods if you need to but you should keep these methods `private` to the appropriate classes.
+ You do not need to implement new classes.
+ You can use additional standard Java libraries by importing them.
+ Do not throw new exceptions unless the specification for the method permits exceptions.
