// hash code 응용4 - 사용자가 만든 클래스를 key로 사용하기
package ch15;
import java.util.HashMap;

class Key {
  String contents;
  
  public  Key(String contents) {
    this.contents = contents;
  }

  @Override
  public String toString() {
    return "key [contents=" + contents + "]";
  }  
}// Key

public class Test10 {

  public static void main(String[] args) {
   
    HashMap map = new HashMap();
    
    Key k1 = new Key("ok");
    Key k2 = new Key("no");
    Key k3 = new Key("haha");
    Key k4 = new Key("ohora");
    Key k5 = new Key("hul");
    
    // String을 key로 사용해보자!    
    map.put(k1, new Student("홍길동", 20, false));
    map.put(k2, new Student("임꺽정", 30, true));
    map.put(k3, new Student("유관순", 17, true));
    map.put(k4, new Student("안중근", 24, true));
    map.put(k5, new Student("윤봉길", 22, false));
    
    System.out.println(map.get(k3));
    
    // key를 사용하여 값을 꺼내보자
    Key k6 = new Key("haha");
    
    System.out.println(k3 == k6); // 인스턴스는 다르지만
    System.out.println(k3.hashCode()); // hash code는 같다.
    System.out.println(k6.hashCode()); // hash code는 다르다.
    System.out.println(k3.equals(k6)); // equals()의 비교 결과도 다르다.
    
    // k3와 k6의 내용물이 같다하더라도 (둘다 "haha"이다.)
    // hashCode()의 리턴 값이 다르고 equals()의 비교결과도 false이기 때문에
    // HahsMap 클래스에서는 서로 다른 key라고 간주한다.
   
    System.out.println(map.get(k6));
     
     // 해당 키로 저장한 값을 찾을 수 없으면 null을 리턴한다.
    String k7 = new String("Haha");
    System.out.println(map.get(k7));
    
  }

}
