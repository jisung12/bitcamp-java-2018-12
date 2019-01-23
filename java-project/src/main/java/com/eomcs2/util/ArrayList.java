package com.eomcs2.util;

import java.util.Arrays;
import com.eomcs2.lms.domain.Lesson;

public class ArrayList<E> {
  static final int DEFAULT_CAPACITY = 10;
  Object[] list;
  int size = 0;

  public ArrayList() {
    list  = new Object[DEFAULT_CAPACITY];
  }//ArrayList

  public ArrayList(int initialCapacity) {
    if (initialCapacity > DEFAULT_CAPACITY)
      list = new Object[initialCapacity];
    else
      list = new Object[DEFAULT_CAPACITY];
  }//ArrayList

  @SuppressWarnings("unchecked")
  public E[] toArray(E[] a) {
    if (a.length < size) {
      return (E[]) Arrays.copyOf(list, size, a.getClass());
    }
    System.arraycopy(list, 0, a, 0, size);
    if (a.length > size)
      a[size] = null;
    return a;
  }// toArray

  public void add(E obj) {
    if (size >= list.length) {
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      list = Arrays.copyOf(list, newCapacity);
    }

    list[size++] = obj;
  }//add
  
  public int size() {
    return size;
  }

  public E get(int index) {
    if (index < 0 || index >= size) 
      return null;
    
    return (E) list[index];
  }

  
  public E set(int index, E value) {
    if (index < 0 || index >= size)
      return null;
    
    @SuppressWarnings("unchecked")
    E obj = (E) list[index];
    
    list[index] = value;
    
    return obj;
  }

  
 
}//ArrayList<E>
