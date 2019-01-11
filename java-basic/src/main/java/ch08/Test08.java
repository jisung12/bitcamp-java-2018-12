// 패키지 용도 - 서로 관련된 일이나 유사한 일을 하는 클래스를 분류할 때 사용한다.
package ch08;
import java.util.Scanner;

public class Test08 {
   
  public static void main(String[] args) {
    // Calculator 클래스를 향후 유지보수하기 쉽도록 별도의 패키지로 분류한다
    // ch08.util 패키지를 만들어 분류한다.
    Scanner keyboard = new Scanner(System.in);
    System.out.print("계산식?(예 : 12 * 2) ");
    int a = keyboard.nextInt();
    String op = keyboard.next();
    int b = keyboard.nextInt();
     
    keyboard.close();
    
    int result = 0;
    switch(op) {
      
      // 다른 패키지로 분류한 클래스를 사용한다는 것을 보여주기 위해
      // 일부러 import를 하지 않고 클래스를 사용한다.
      // 메소드 사용 불가 = 이유 : 메서드의 접근 허용이 같은 패키지만 가능하기 때문!
      // 해결책 : 해당 클래스로가서 메서드 공개하기!
      case "+" : result = ch08.util.Calculator2.plus(a, b); break;
      case "-" : result = ch08.util.Calculator2.minus(a, b); break;
      case "*" : result = ch08.util.Calculator2.multiple(a, b); break;
      case "/" : result = ch08.util.Calculator2.divide(a, b); break;
      default :
        System.out.println("지원하지 않는 연산자");
        return; //main() 메서드를 그만 실행하고 나간다(JVM 종료)  
        
       
    }//switch
    
    System.out.printf("%d %s %d = %d\n",a, op, b, result);
       
  }//main
 
}//class 
