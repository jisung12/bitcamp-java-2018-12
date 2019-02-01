// java.io.File 클래스 : 필터 사용하기 2
package ch22.a;

import java.io.File;

public class Test10_4 {
  // local class(nested class)
  public static void main(String[] args) throws Exception {


    // 파일은 디렉토리와 파일을 통칭하는 용어다.
    File file = new File(".");

    // lambda class
    // => 메서드가 한 개짜리인 경우 lambda 표현식을 사용할 수 있다.
    // => 문법 :
    //       (파라미터, 파라미터, ... ) -> 문장 한개
    //       (파라미터, 파라미터, ... ) -> {문장1; 문장2; 문장3;}
    //       () -> 문장 한개
    //       () -> {문장1; 문장2; 문장3;}

    String[] names = file.list((File dir, String name) -> {
        if (name.endsWith(".txt"))
          return true;
        else
          return false;
      });

    for (String name : names) {
      System.out.println(name);
    }

  }

}


