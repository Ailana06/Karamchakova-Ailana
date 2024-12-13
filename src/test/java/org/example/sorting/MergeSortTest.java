package org.example.sorting;

import org.example.exception.ArrayLengthException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {
  @Test
  public void testMergeSort(){
    MergeSort mergeSort = new MergeSort(20);
    List<Integer> list = Arrays.asList(7, 6, 8, 5, 4, 3, 2, 9, 1);
    List<Integer> sortedList = mergeSort.sort(list);
    assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), sortedList);
  }

  @Test
  void testMergeSortArrayLengthException() {
    MergeSort mergeSort = new MergeSort(5);
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
    assertThrows(ArrayLengthException.class, () -> mergeSort.sort(list));
  }
}
