package org.example.custom;

public class List<T extends ListableObject> {

  Object[] list = new Object[10]; // wrapper

  public void add(T item) {
    for (int i = 0; i < list.length; i++) {
      if (list[i] == null) {
        list[i] = item;
        break;
      }
    }
  }

  public void remove(T item) {
    for (int i = 0; i < list.length; i++) {
      if (list[i] != null && list[i].equals(item)) {
        list[i] = null;
        break;
      }
    }
  }

  public T get(int index) {
    return (T) list[index];
  }
}
