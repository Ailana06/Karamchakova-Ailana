package org.example;

/**
 * Кастомная реализация ArrayList.
 *
 * @param <A> Тип элементов, которые будут храниться в списке.
 */
public class CustomArrayList<A> implements CustomArrayListMethods<Object> {
  /**
   * list - структура, в которой хранятся все элементы.
   * size - поле, в котором храниться информация о количестве элементов в массиве на данный момент.
   * capacity - поле, в котором содержится информация о максимальном количестве элементов в массиве на данный момент.
   */
  private Object[] list;
  private int size;
  private final int capacity = 5;

  /**
   * Конструктор инициализирует новый объект CustomArrayList.
   */
  public CustomArrayList() {
    list = new Object[capacity];
  }

  @Override
  public void add(Object item) {
    if (item == null) {
      throw new NullPointerException("Элемент не может быть null");
    }
    if (size + 1 >= capacity) {
      increaseCapacity();
    }
    list[size++] = item;
  }

  @Override
  public Object get(int index) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException("Элемента с  индексом " + index + " не существует");
    }
    return list[index];
  }

  @Override
  public void remove(int index) {
    for (int i = index; i < size; i++) {
      list[i] = list[i + 1];
    }

    size--;
  }

  /**
   * Увеличивает capacity CapacityArrayList.
   */
  private void increaseCapacity() {
    int newCapacity = capacity * 2;
    Object[] newList = new Object[newCapacity];
    for (int i = 0; i < capacity; i++) {
      newList[i] = list[i];
    }
    list = newList.clone();
  }
}