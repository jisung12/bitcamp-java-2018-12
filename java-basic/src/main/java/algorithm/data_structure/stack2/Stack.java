package algorithm.data_structure.stack2;

public class Stack<E> {
  public static final int DEFAULT_SIZE = 5;

  Object[] list;
  int size;

  public Stack() {
    list = new Object[DEFAULT_SIZE];
  }

  public void push(E value) {
    // 맨 마지막에 추가한다.
    // 배열의 크기가 작다면 확장해야 한다.
    if(size == list.length) {
      int originSize = list.length;
      int newSize = originSize + (originSize >> 1);
      Object[] arr = new Object[newSize];
//   Object[] arr = new Object[list.length + list.length >> 1)];
      for (int i = 0; i < list.length; i++) {
        arr[i] = list[i];
      }
      list = arr;
    }
    list[size++] = value;
  }

  @SuppressWarnings("unchecked")
  public E pop() {
    // 맨 마지막 값을 리턴한다 
    // 꺼낸 값을 배열에서 제거되어야 한다.
    if(size == 0)
      return null;
    
    size--;
    return (E) list[size]; // return list[--size];
  }

  public boolean empty() {
    return size == 0;
  }

  public int size() {
    return this.size;
  }

}