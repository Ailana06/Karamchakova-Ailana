package org.example;

import org.example.exception.ArrayLengthException;
import org.example.sorting.BubbleSort;
import org.example.sorting.MergeSort;
import org.example.sorting.SortType;
import org.example.sorting.SortingAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SorterTest {
  @Test
  void testSortBubbleSortSuccess() {
    List<SortingAlgorithm> algorithms = Arrays.asList(new BubbleSort(10), new MergeSort(Integer.MAX_VALUE));
    Sorter sorter = new Sorter(algorithms);
    List<Integer> list = Arrays.asList(5, 2, 8, 1, 9, 4, 7, 3, 6);
    List<Integer> sortedList = sorter.sort(list, SortType.BUBBLE);
    assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), sortedList);
  }

  @Test
  void testSortMergeSortSuccess() {
    List<SortingAlgorithm> algorithms = Arrays.asList(new BubbleSort(10), new MergeSort(Integer.MAX_VALUE));
    Sorter sorter = new Sorter(algorithms);
    List<Integer> list = Arrays.asList(5, 2, 8, 1, 9, 4, 7, 3, 6);
    List<Integer> sortedList = sorter.sort(list, SortType.MERGE);
    assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), sortedList);
  }


  @Test
  void testBubbleSortArrayLengthException() {
    BubbleSort bubbleSort = new BubbleSort(5); // Set a smaller maxElements
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
    assertThrows(ArrayLengthException.class, () -> bubbleSort.sort(list));
  }

  @Test
  void testSortEmptyList() {
    List<SortingAlgorithm> algorithms = Arrays.asList(new BubbleSort(10), new MergeSort(Integer.MAX_VALUE));
    Sorter sorter = new Sorter(algorithms);
    List<Integer> list = Collections.emptyList();
    assertTrue(sorter.sort(list, SortType.BUBBLE).isEmpty());
    assertTrue(sorter.sort(list, SortType.MERGE).isEmpty());
  }

  @Test
  void testSortNullList() {
    List<SortingAlgorithm> algorithms = Arrays.asList(new BubbleSort(10), new MergeSort(Integer.MAX_VALUE));
    Sorter sorter = new Sorter(algorithms);
    List<Integer> list = null;
    assertThrows(NullPointerException.class, () -> sorter.sort(list, SortType.BUBBLE));
  }
}