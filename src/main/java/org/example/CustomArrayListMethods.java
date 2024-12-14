package org.example;

/**
 * Интерфейс для кастомной реализации ArrayList.
 *
 * @param <A> Тип элементов, которые будут храниться в списке.
 */
public interface CustomArrayListMethods<A> {
  /**
   * Добавляет элемент в конец списка.
   *
   * @param item Элемент, который нужно добавить.
   * @throws NullPointerException Если элемент равен null
   */
  void add(A item);

  /**
   * Возвращает элемент по указанному индексу.
   *
   * @param index Индекс элемента, который нужно вернуть.
   * @return Элемент по указанному индексу.
   * @throws ArrayIndexOutOfBoundsException Если индекс выходит за пределы списка.
   */
  A get(int index);

  /**
   * Удаляет элемент по указанному индексу.
   *
   * @param index Индекс элемента, который нужно удалить.
   * @throws ArrayIndexOutOfBoundsException если индекс выходит за пределы списка.
   */
  void remove(int index);
}