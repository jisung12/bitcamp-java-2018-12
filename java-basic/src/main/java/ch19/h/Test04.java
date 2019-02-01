// Lambda 문법 - 람다 파라미터 1
package ch19.h;

public class Test04 {

  // 다음과 같이 추상 메서드가 한 개 있는 인터페이스를 "functional interface"라고 부른다.
  // => 이런 경우에 람다 문법을 사용할 수 있다.
  static interface Player {
    void play(String name, int age);
  }

  public static void main(String[] args) {
    // 1) 파라미터는 괄호안에 선언한다.
    Player p1 = (String name, int age) ->
    System.out.printf("%s(%d)님 환영합니다.\n", name, age);
    p1.play("홍길동", 20);
    
    // 2) 파라미터 타입을 생략할 수 있다.
    Player p2 = (name, age) ->
    System.out.printf("%s(%d)님 환영합니다.\n", name, age);
    p2.play("임꺽정", 30);

    // 3) 파라미터가 여러 개일 때는 괄호 생략 불가.
    Player p3 = (name, age) ->
    System.out.printf("%s(%d)님 환영합니다.\n", name, age);
    p3.play("임꺽정", 30);
    
    
  }//main

}//Test01









