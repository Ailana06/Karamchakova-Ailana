package org.example;

import org.example.sorting.BubbleSort;
import org.example.sorting.MergeSort;
import org.example.sorting.SortType;
import org.example.sorting.SortingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    List<SortingAlgorithm> algorithms = Arrays.asList(new BubbleSort(3), new MergeSort(), new BubbleSort(10), new MergeSort(5));
    Sorter sorter = new Sorter(algorithms);

    List<Integer> numbers = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i < 5; i++) {
      numbers.add(random.nextInt(100));
    }

    System.out.println(numbers);
    try{
      List<Integer> sortedNumbersFirst = sorter.sort(numbers, SortType.BUBBLE);
      System.out.println(SortType.BUBBLE + " : "+ sortedNumbersFirst);

      List<Integer> sortedNumbersSecond = sorter.sort(numbers, SortType.MERGE);
      System.out.println(SortType.MERGE + " : "+ sortedNumbersSecond);
    } catch (IllegalArgumentException e){
      System.err.println(e.getMessage());
    }

  }
}