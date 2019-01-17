// 상속 관계에서 생성자 호출 과정2 - 임의의 수퍼 클래스 생성자 호출하기 
package ch13.f;

public class Test02 {

  public static void main(String[] args) {
    Y obj1 = new Y();
    // 생성자 호출 과정
    // => Y() => X(int) => Object()
   
    obj1.m1(); 
    obj1.m2(); 

    // 결론 !  수퍼 클래스부터 초기화 작업을 실행한다.
  }

}
