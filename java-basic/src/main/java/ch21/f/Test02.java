// try-with-resources 활용법 
package ch21.f;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

public class Test02 {

  public static void main(String[] args)  {

    // 자바에서는 자원 해제를 자동화시키는 try ~ catch 문법을 제공한다.
    // 개발자가 finally에서 자원 해제시키는 코드를 작성할 필요가 없다.
    // => 단, java.lang.AutoCloseable 구현체인 경우에만 해당한다.
    // 사용법
    //    try (java.lang.AutoCloseable 구혐체의 변수를 선언) { 
    //        ...
    //     } catch (...) {...}
    
   
    try (Scanner keyboard = new Scanner(System.in);){
      System.out.print("값? ");
      int a = Integer.parseInt(keyboard.nextLine());

      int result = sum(a);

      System.out.println(result);


    } catch (Exception e) {
      
      try( 
           StringWriter out = new StringWriter();
           PrintWriter out2 = new PrintWriter(out);
          ){         
        // 상세 오류 정보를 String으로 받기
        e.printStackTrace(out2);
       
        // StringWriter 객체에 저장된 문자열 꺼내기
        String str = out.toString();
        System.out.println(str);
       
      } catch(Exception e2){
        // 자원을 해제시키다가 예외가 발생할 경우 개발자가 처리할게 많다.
        // 그래서 예외를 받기만하고 특별히 뭔가를 수행하지는 않는다.
      }

    } finally {
      // try-with-resources 문법을 사용하면 
      // JVM이 try()에 선언한 레퍼런스에 대해 try 블록을 벗어나기 전에 close()를 
      // 자동호출하기 때문에 다음과 같이 개발자가 직접 close()를 호출하는 코드를 작성할 필요가 없다.
     // keyboard.close();      
    }

  }//main



  static int sum(int value) { // f(n) = n + f(n-1)
    if (value == 1)
      return 1;
    return value + sum(value - 1);
  }//sum




}//Test02


