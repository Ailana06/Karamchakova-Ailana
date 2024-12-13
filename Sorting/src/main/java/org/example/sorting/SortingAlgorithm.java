package org.example.sorting;

import org.example.exception.ArrayLengthException;
import org.example.exception.SortingAlgorithmException;

import java.util.List;

public interface SortingAlgorithm {
  static void checkListSize(int size, int maxListSize){
    if ((size < 0) || (size > maxListSize)) {
      throw new ArrayLengthException(size);
    }
  }

  SortType type();

  List<Integer> sort(List<Integer> list) throws SortingAlgorithmException;
}
