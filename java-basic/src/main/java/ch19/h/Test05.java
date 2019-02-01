// Lambda 문법 - 람다 리턴 
package ch19.h;

public class Test05 {

  // 다음과 같이 추상 메서드가 한 개 있는 인터페이스를 "functional interface"라고 부른다.
  // => 이런 경우에 람다 문법을 사용할 수 있다.
  static interface Calculator {
    int compute(int a, int b);
  }

  
  public static void main(String[] args) {
    // 1) 리턴 값은 return 명령을 사용하여 처리한다.
    Calculator c1 = (a, b) -> { return a + b; };
    System.out.println(c1.compute(10, 20));
    
    // 2) 한 문장으로 된 표현식(=값을 리턴하는 한 문장의 코드) 경우 괄호 생략 가능.
    Calculator c2 = (a, b) ->  a - b;
    System.out.println(c2.compute(10, 20));
    
    // 3) Math.max()는 int 값을 리턴한다. 그래서 이 메서드를 호출하는 문장은 표현식이다.
    Calculator c3 = (a, b) ->  Math.max(a, b);
    System.out.println(c3.compute(10, 20));
    
    // 4) 값을 리턴해야 하는데 람다 문장에서 값을 리턴하지 않으면 컴파일 오류!
   // Calculator c4 = (a, b) -> System.out.println(a + ",", b); //컴파일 오류!
   // System.out.println(c4.compute(10, 20));
    
    
    
    
    
  }//main

}//Test01









