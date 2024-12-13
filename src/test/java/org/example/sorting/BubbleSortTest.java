package org.example.sorting;

import org.example.exception.ArrayLengthException;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BubbleSortTest {
  @Test
  public void testBubbleSort(){
    BubbleSort bubbleSort = new BubbleSort(20);
    List<Integer> list = Arrays.asList(7, 6, 8, 5, 4, 3, 2, 9, 1);
    List<Integer> sortedList = bubbleSort.sort(list);
    assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), sortedList);
  }

  @Test
  void testBubbleSortArrayLengthException() {
    BubbleSort bubbleSort = new BubbleSort(5); // Set a smaller maxElements
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
    assertThrows(ArrayLengthException.class, () -> bubbleSort.sort(list));
  }
}
