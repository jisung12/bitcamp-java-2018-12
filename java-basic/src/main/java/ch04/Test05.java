// 연산자 우선 순위
package ch04;

public class Test05 {
  public static void main(String[] args) {
    float r = 3.2f + 5 / 2;
    System.out.println(r); // 5.2
   
      
   // => 연산자 우선 순위에 따라 *, /, %, 연산자가 +, - 연산자 보다 먼저 계산.
      
    float r2 = (3.2f + 5) / 2;
    System.out.println(r2); // 4.1
     // 연산자 우선 순위에서 괄호가 최우선
    
    int a = 2;
    int r3 = a++ + a++ * a++; // 2 , 3 , 4  =>  2 + (3 * 4) = 14
    System.out.println(r3);
    
    
    
/*
  # 연산자 우선 순위
  괄호
  후위 연산자(a++, a--)
  전위 연산자(++a, --a), 단항 연산자(+, -)
  *, /, %
  +, -
  비트이동 연산자 : <<, >>, >>>
  관계 연산자 : <, >, <=, >=, instanceof
  등위 연산자 : ==, !=
  &
  ^ 
  |
  논리 연산자 AND : &&
  논리 연산자 OR : ||
  삼항 연산자 : (조건) ? 값 : 값
  할당 연산자 : =, +=, -=, *=, /=, %=, &=, ^=, |=, <<=, >>=, >>>=
 */
      
     
    
    
  }
}