// java.util.ArrayList 사용법 - 메서드 사용 
package ch20.A;

import java.util.ArrayList;

public class Test02 {

  public static void main(String[] args) {
    
    ArrayList<String> list = new ArrayList<>();
    
    // add(value) : 목록에 순차적으로 추가한다.
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");
    list.add(null); // ArrayList는 null을 추가하는 것을 허용한다.
    list.add("eee");
    list.add(null); // ArrayList는 null을 추가하는 것을 허용한다.
    list.add("aaa"); // ArrayList는 같은 인스턴스를 중복해서 추가할 수 있다.
    list.add("bbb"); // ArrayList는 같은 인스턴스를 중복해서 추가할 수 있다.
    
    
    System.out.println(list);
    
    
  }

}
