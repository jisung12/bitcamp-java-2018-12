// java.util.Set 클래스 사용법 - add(), Iterator
package ch20.C;

import java.util.HashSet;
import java.util.Iterator;

public class Test01 {

  public static void main(String[] args) {
    HashSet<String> set = new HashSet<>();
    
    // Set에 값 추가하기
    set.add("aaa");
    set.add("bbb");
    set.add("ccc");
    
    // Set은 집합의 특성을 따른다.
    // => 같은 값을 중복해서 넣을 수 없다.
    set.add("aaa");
    set.add("bbb");
    
    // => null을 넣을 수 있지만 중복해서 넣을 수 없다.
    set.add(null);
    set.add(null);
    
    // Set에 들어있는 값 꺼내기
    // => 직접 값을 한 개씩 꺼내는 메서드가 없다.
    // => 꺼내주는 객체(iterator)의 도움을 받아야 한다.
    // 
    Iterator<String> iterator = set.iterator();
    
    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    
    // 출력 결과를 보면 입력 순서로 꺼낼 수 없다.
    // 이유?
    // => 저장할 때 각 인스턴스에 대해 hashCode()의 리턴 값으로 위치를 정하기 때문이다.
    
    System.out.println("==================================");
    
    Object[] values = set.toArray();
    for(Object a : values) {
      System.out.println(a);
    }
    
    System.out.println("====================================");
    
    // 입력한 값의 타입으로 배열을 받고 싶다면?
    // => 파라미터로 넘겨 준 배열이 값을 담을 만큼 크지 않다면, 새 배열을 만들어 리턴한다.
    String[] temp = new String[0];
    String[] values2 = set.toArray(new String[0]);
    System.out.println(temp == values2);
    for(String b : values2) {
      System.out.println(b);
    }
    
    System.out.println("====================================");
    
    String[] values3 = new String[set.size()];
    String[] values4 = set.toArray(values3);
    System.out.println(values3 == values4);
    for(String b : values2) {
      System.out.println(b);
    }
  }

}
