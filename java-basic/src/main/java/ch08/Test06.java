// 클래스 문법의 또 다른 용도
package ch08;
import java.util.Scanner;

public class Test06 {
   
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("계산식?(예 : 12 * 2) ");
    int a = keyboard.nextInt();
    String op = keyboard.next();
    int b = keyboard.nextInt();
    
    
    keyboard.close();
    
    int result = 0;
    switch(op) {
      case "+" : plus(a, b); break;
      case "-" : minus(a, b); break;
      case "*" : multiple(a, b); break;
      case "/" : divide(a, b); break;
      default :
        System.out.println("지원하지 않는 연산자");
        return; //main() 메서드를 그만 실행하고 나간다(JVM 종료)
      
    }
    
    
    System.out.printf("%d %s %d = %d\n",a, op, b, result);
    
    
  }//main
  
  
  static int plus(int a, int b) {
    return a + b;
  }
  
  static int minus(int a, int b) {
    return a - b;
  }
  
  static int multiple(int a, int b) {
    return a * b;
  }
  static int divide(int a, int b) {
    return a / b;
  }
  
}//class 
