package org.example.exception;

public class ArrayLengthException extends RuntimeException {
  public ArrayLengthException(int length) {
    super("Список длины " + length + " превышает ограничение на максимальное количество элементов");
  }
}