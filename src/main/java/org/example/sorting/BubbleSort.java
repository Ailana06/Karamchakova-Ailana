package org.example.sorting;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort implements SortingAlgorithm {
  private final int maxListSize;

  public BubbleSort(int maxListSize) {
    this.maxListSize = maxListSize;
  }

  @Override
  public SortType type() {
    return SortType.BUBBLE;
  }

  @Override
  public List<Integer> sort(List<Integer> list) {
    SortingAlgorithm.checkListSize(list.size(), maxListSize);
    List<Integer> sortedList = new ArrayList<>(list);
    for (int i = 0; i < sortedList.size(); i++) {
      for (int j = i + 1; j < sortedList.size(); j++) {
        if (sortedList.get(i) > sortedList.get(j)) {
          int temp = sortedList.get(j);
          sortedList.set(j, sortedList.get(i));
          sortedList.set(i, temp);
        }
      }
    }
    return sortedList;
  }
}