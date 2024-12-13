package org.example.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeSort implements SortingAlgorithm {
  private int maxListSize;

  public MergeSort () {

  }

  public MergeSort(int maxListSize) {
    this.maxListSize = maxListSize;
  }

  @Override
  public SortType type() {
    return SortType.MERGE;
  }

  @Override
  public List<Integer> sort(List<Integer> list){
    SortingAlgorithm.checkListSize(list.size(), maxListSize);
    List<Integer> sortedList = new ArrayList<>(list);
    Collections.sort(sortedList);
    return sortedList;
  }
}
