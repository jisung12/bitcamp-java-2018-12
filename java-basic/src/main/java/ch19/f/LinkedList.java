// 특정 클래스에 의해서만 사용되는 클래스가 있다면 그 클래스 안에 정의하라!
package ch19.f;

// Array 클래스는 LinkedList 클래스에서만 사용하는 클래스이다.
// 그래서 패키지 맴버 크래스에서 중첩 클래스로 옮겼다.
// 즉 LinkedList 클래스 안에 Array 클래스를 정의하였다.
// *맨 아래에 Array 클래스를 참조!
public class LinkedList {
  public static final int FORWARD = 1; 
  public static final int REVERSE = 2;

  protected Node head;
  protected Node tail;
  protected int size;
  protected int index;
  
  public LinkedList() {
    head = new Node();
    tail = head;
    size = 0;
  }


  public void add(Object value) {
    tail.value = value;

    Node node = new Node();

    tail.next = node;

    node.prev = tail;

    tail = node;

    size++;
  } //add


  public int size() {
    return size;
  }


  public Object get(int index) {
    if (index < 0 || index >= size)
      return null;

    Node cursor = head;

    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }

    return cursor.value;
  }//get



  public Object[] toArray(int direction) {
    // 이제 Array 클래스는 남이 아니다. 같은 식구다
    // 그래서 LinkedList의 맴버를 사용할 수 있다.
    // Array 클래스가 non-static nested 클래스이기 때문에 
    // LinkedList의 non-static 맴버를 사용할 수 있다. 
    
    Array helper = new Array(); // <== LinkedList 객체 주소를 넘겨줄 필요가 없다.

    if(direction == FORWARD) {
      // 그래야만 Array 객체는 생성자에게 넘겨받은 LinkedList의 대에티럴 꺼내 배열로 만든다.
      return helper.copy();
    } else {
      return helper.reverseCopy();
    }

  }//toArray



  public Object set(int index, Object value) {
    if(index<0 || index >= size)
      return null;
    Node cursor = head;
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    Object old = cursor.value;
    cursor.value = value;
    return old;
  }//set



  public int insert(int index, Object value) {
    if(index < 0 || index >= size)
      return -1;

    Node node = new Node(value);

    Node cursor = head;

    for(int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }

    node.next = cursor;

    node.prev = cursor.prev;

    cursor.prev = node;
    if(node.prev != null) { 

      node.prev.next = node;

    } else {

      head = node;
    }

    size++;
    return 0;

  }//insert



  // 중첩 클래스는 크게 static이냐 non-static이냐로 나눌 수 있는데,
  // 특정 인스턴스를 사용하지 않는다면 static nested class로 선언하라!
  // 그러나 바깥 클래스의 특정 인스턴스를 사요한다면 그 인스턴스에 종속되기 때문에
  // non-static nested class로 선언하라!
  // => 다음 Array 클래스는 LinkedList의 특정 인스턴스의 값을 사용해야하기 때문에
  //   non-static 클래스로 선언한다.
  // => 내부에서만 사용할 클래스라면 비공개로 처리하라.
  private class Array {
    // 이제 Array 클래스는 LinkedList의 인스턴스 맴버가 되었다.
    // => 즉, 인스턴스 필드나 메서드처럼 특정 인스턴스에 대해 주소를 받는다는 것이다.
    // => 따라서 바깥 클래스의 인스턴스를 마음대로 사용할 수 있다. 그냥 인스턴스 메서드라 생각하라!
    
    /*
    LinkedList list;   <== 이 코드가 필요 없다

    public Array(LinkedList list) {
      this.list = list;
    }
     */
    
    
    // 입력된 순서대로 배열을 만든다.
    public Object[] copy() {
      // 바깥 클래스의 인스턴스 주소는 다음과 같이 사용해야 한다.
      //      바깥클래스명.this.인스턴스맴버
      // 만약 바깥 클래스의 인스턴스맴버명이 내부 클래스의 맴버 이름과 충돌하지 않는다면
      //      바깥클래스명.this를 생략해도 된다.
      Object[] arr = new Object[LinkedList.this.size()];  // 정확한 표기 

      for (int i = 0; i<size(); i++) {
        arr[i] = get(i);
      }
      return arr;
    }

    // 입력된 순서의 반대로 배열을 만든다.
    public Object[] reverseCopy() {
      // 다음과 같이 내부 맴버에 같은 이름이 없다면 바깥 클래스의 인스턴스 맴버를 사용할 때
      //     LinkedList.this 를 생략해도 된다.
      // 그냥 LinkedList의 메서드라 생각하고 작성하라!
      Object[] arr = new Object[size()];

      for (int i = size()-1, j=0;   i>=0;   i--,j++) {
        arr[j] = get(i);
      } 
      return arr;
    }
  }


}//LinkedList

