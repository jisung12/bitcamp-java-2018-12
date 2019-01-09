// 메서드 - 로컬 변수의 생성과 소멸
package ch06;

public class Test09 {
  public static void main(String[] args) {
    int value = 100;
    m1(value);
    System.out.println(value);
    
    m1(value + 15);
    System.out.println(value);
    
    m1(value + 15);
    System.out.println(value);
  }

  static void m1(int value) {
    value = 200;
    System.out.printf("m1(): %d\n", value);
  }
  // 위 코드를 보고 로컬 변수를 모두 찾아 그 이름을 나열하라.
                //로컬 변수란. 메소드에 있는 변수, 파라미터 포함
  // 답 : main() - value, args / m1() - value

}//class Test09

