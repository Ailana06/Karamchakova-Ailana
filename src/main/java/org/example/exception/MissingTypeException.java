package org.example.exception;

public class MissingTypeException extends RuntimeException{
  public MissingTypeException(String message) {
    super(message);
  }
}