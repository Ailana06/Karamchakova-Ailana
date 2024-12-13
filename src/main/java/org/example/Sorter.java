package org.example;

import org.example.exception.ArrayLengthException;
import org.example.exception.MissingTypeException;
import org.example.exception.SortingAlgorithmException;
import org.example.sorting.SortType;
import org.example.sorting.SortingAlgorithm;

import java.util.List;

public class Sorter {
  private final List<SortingAlgorithm> algorithms;

  public Sorter(List<SortingAlgorithm> algorithms) {
    this.algorithms = algorithms;
  }

  public List<Integer> sort(List<Integer> list, SortType type) {
    for (SortingAlgorithm algorithm : algorithms) {
      if (algorithm.type().equals(type)) {
        try {
          return algorithm.sort(list);
        } catch (ArrayLengthException e) {
          System.err.println(e.getMessage());
        } catch (SortingAlgorithmException e) {
          System.err.println("Ошибка во время сортировки: " + e.getMessage());
        }
      }
    }
    throw new MissingTypeException("Тип " + type + "не найден");
  }
}
