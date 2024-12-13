package org.example;

public class Main {
  public static void main(String[] args) {
    CustomArrayList<String> numbers = new CustomArrayList<>();

    for (int i = 0; i < 5; i++) {
      numbers.add(i * i);
    }

    System.out.print(numbers.get(0) + " ");
    System.out.print(numbers.get(1) + " ");
    System.out.print(numbers.get(2) + " ");
    System.out.print(numbers.get(3) + " ");
    System.out.println(numbers.get(4));

    numbers.remove(2);

    System.out.print(numbers.get(0) + " ");
    System.out.print(numbers.get(1) + " ");
    System.out.print(numbers.get(2) + " ");
    System.out.print(numbers.get(3));
    System.out.print(numbers.get(4));
  }
}