package design_pattern.iterator;

import java.util.Arrays;

public class ArrayList<E> {
  static final int DEFAULT_SIZE = 5;
  Object[] arr;
  int size;


  public ArrayList() {
    this(DEFAULT_SIZE);
    // this(0);
  }


  public ArrayList(int capacity) {
    if (capacity > DEFAULT_SIZE)
      arr = new Object[capacity];
    else
      arr = new Object[DEFAULT_SIZE];
  }

  
  public Object[] toArray() {
    // 데이터 개수 만큼 배열을 만들고 값을 복사하여 리턴.
    Object[] list = new Object[this.size];
    for (int i = 0; i< this.size; i++) {
      list[i] = this.arr[i]; // *
    }
    return list;
  }


  public void add(E value) {
    // 현재 배열이 꽉 찼다면 현재 배열 크기의 50% 만큼 증가시켜라.
    if(this.size == arr.length) {
      int originSize = arr.length;
      int newSize = originSize + (originSize >> 1);
      Object[] temp = new Object[newSize];
      for(int i = 0; i < this.arr.length; i++) {
        temp[i] = this.arr[i];
      }
      arr = temp;
    }
    arr[this.size++] = value;

    /*
    if (size >= arr.length) {
      int oldCapacity = arr.length;
      int newCapacity = oldCapacity + (oldCapacity / 2 );
      arr = Arrays.copyOf(arr, newCapacity);
     */
  }


  public void insert(int index, E value) {  //* void => int
    // 현재 배열이 꽉 찼다면 현재 배열 크기의 50% 만큼 증가시켜라.
    // 유효 인덱스(현재 배열에 데이터가 저장된 방 번호)가 아니면 저장하지 말라.
    // 삽입할 위치의 항목부터 이후의 항목들을 뒤로 밀어라.
    if(index <0 || index >= size)
      return; //*return -1;
    
    if(this.size == arr.length) {
      int originSize = arr.length;
      int newSize = originSize + (originSize >> 1);
      Object[] temp = new Object[newSize];
      for(int i = 0; i < this.arr.length; i++) {
        temp[i] = this.arr[i];
      }
      arr = temp;
    }
    //increase();
    
      for(int i = size -1; i >= index; i--)
        this.arr[i + 1] = this.arr[i]; 
        
      this.arr[index] = value;
      size++;
      
      //*return 0;
  }

  
  public E get(int index) {
    // 유효 인덱스(현재 배열에 데이터가 저장된 방 번호)가 아니면 null을 리턴하라.
    if (index < 0 || index >= size) 
      return null;

    return(E) arr[index];
  }


  public E set(int index, E value) {
    // 유효 인덱스(현재 배열에 데이터가 저장된 방 번호)가 아니면 변경하지 말라. 리턴 값은 null이다.
    if (index < 0 || index >= size) 
      return null;

    E old = (E) this.arr[index];
    this.arr[index] = value;
    return old;
  }


  public E remove(int index) {
    // 유효 인덱스(현재 배열에 데이터가 저장된 방 번호)가 아니면 삭제하지 말라.
    // 삭제한 후 다음 항목을 앞으로 당긴다.
    if (index < 0 || index >= size)
      return null;

    E old = (E) this.arr[index];
    
    for(int i=index; i < size-1; i++)
      this.arr[i] = this.arr[i+1];
    
    size--;
    
    return old;
  }

  
  public int size() {
    return this.size;
  }

  
  private void increase() {
    if(this.size == arr.length) {
      int originSize = arr.length;
      int newSize = originSize + (originSize >> 1);
      Object[] temp = new Object[newSize];
      for(int i = 0; i < this.arr.length; i++) {
        temp[i] = this.arr[i];
      }
      arr = temp;
    }
  }

  // 자신이 보유한 데이터를 꺼내주는 일을 하는 객체를 알려주는 메서드
  public Iterator<E> iterator() {
    return new  Iterator<E>(){
      // 이 클래스는 ArrayList에서 값을 꺼내주는 일을 전문적으로 한다.
      // => 이런 일을 하는 객체를 "Iterator"라 부른다.
      // 
//      ArrayList<E> list; 
      int index = 0;

//      public ArrayListIterator(ArrayList<E> list) {
//        this.list = list;
//      }

      @Override
      public boolean hasNext() {
       /* if (index < list.size())
          return false;
        else
          return true; */
        return index < size();  // ArrayList.this.size();
      }

      @Override
      public E next() {
        
        return (E) get(index++); // ArrayList.this.get(index++);
      }
    //ArrayListIterator<E>();
    
  };//Iterator
 
  }
}//Arraylist
