package sumsequence;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class SumSequenceTest {

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

}
