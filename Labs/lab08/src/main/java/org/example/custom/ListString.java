package org.example.custom;

public class ListString {

  String[] list = new String[10]; // wrapper

  public void add(String item) {
    for (int i = 0; i < list.length; i++) {
      if (list[i] == null) {
        list[i] = item;
        break;
      }
    }
  }

  public void remove(String item) {
    for (int i = 0; i < list.length; i++) {
      if (list[i] != null && list[i].equals(item)) {
        list[i] = null;
        break;
      }
    }
  }

  public String get(int index) {
    return list[index];
  }
}
