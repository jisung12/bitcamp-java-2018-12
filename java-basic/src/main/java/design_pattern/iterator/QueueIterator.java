package design_pattern.iterator;

public class QueueIterator<E> implements Iterator<E>{
  // 이 클래스는 ArrayList에서 값을 꺼내주는 일을 전문적으로 한다.
  // => 이런 일을 하는 객체를 "Iterator"라 부른다.
  // 
  Queue<E> list;
  int index = 0;

  public QueueIterator(Queue<E> list) {
    this.list = list;
  }


  @Override
  public boolean hasNext() {
   /* if (index < list.size())
      return false;
    else
      return true; */
    return index < list.size();
  }

  @Override
  public E next() {
    
    return (E) list.get(index++);
  }

}
