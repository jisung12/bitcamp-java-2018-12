// 논리 연산자 - &&, ||, ^, !
package ch04;

public class Test10 {
  public static void main(String[] args) {
    // && (AND) 논리 연산자
    // => 피 연산자 모두 ture 일 때만 결과가 ture 된다.
    // => 둘 중 하나라도 false면 결과가 false.
    System.out.println(true && true); //true
    System.out.println(true && false); //false
    
    // || (OR) 논리 연산자
    // => 둘 중 하나라도 true이면 결과가 true 이다.
    // => 둘 다 false 일때만 false.
    System.out.println(true || false); //true
    System.out.println(false || false); //false
    
    // ^ (exclusive OR) 논리 연산자
    // => 피연산자가 서로 '다를 때만' true 이다.
    System.out.println(true ^ true); //false
    System.out.println(false ^ false); //false
    System.out.println(true ^ false); //true
    
    //논리 연산자의 피연산자 값은 반드시 true or false이어야한다.
     //System.out.println(1 && 1);  //컴파일 오류
    
    
    // !(not) 연산자
    System.out.println(!true);
    System.out.println(!false);
    
    
  }
}