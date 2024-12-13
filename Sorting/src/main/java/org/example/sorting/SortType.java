package org.example.sorting;

public enum SortType {
  BUBBLE("Bubble Sort"),
  MERGE("Merge Sort");

  private final String algorithmName;

  SortType(String algorithmName) {
    this.algorithmName = algorithmName;
  }

  public String toString() {
    return algorithmName;
  }
}