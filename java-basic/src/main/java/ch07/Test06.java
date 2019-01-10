// 가비지와 가비지 컬렉터 그리고 레퍼런스 카운트
package ch07;

public class Test06 {
  
  static class Score{
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }

  public static void main(String[] args) {
    Score s1 = new Score();
    Score s2 = new Score();
    
    s2 = s1; // s2에 저장되었던 주소는 s1에 저장된 주소로 변경된다.
               // 따라서 s2가 가리키던 원래의 인스턴스는 주소를 잃어버려 사용할 수 없는 상태가 된다.
               // 이렇게 주소를 잃어버려 사용할 수 없는 인스턴스를 "가비지(garbage)"라 부른다.
               // 가비지는 가비지 컬렉터에 의해 제거될 수 있다.
               // 개발자가 임의로 제거할 수 없다.
    
    // s1이 가리키던 인스턴스를 이제 s2도 가리킨다.
    // JVM은 인스턴스 주소를 몇 개의 레퍼런스가 갖고 있는지 따로 관리한다.
    // 이것을 "레퍼런스 카운트(reference count)"라고 한다.
    // 다른 레퍼런스가 인스턴스 주소를 가질 때마다 해당 인스턴스의 레퍼런스 카운트는 증가한다.
    // 인스턴스 주소를 가리키는 레퍼런스가 줄 때마다 해당 인스턴스의 레퍼런스 카운트도 감소한다.
    // 레퍼런스 카운트가 0인 것이 바로 "가비지"이다.
    
  } //main--------------

}//class Test01----------







