// 파일 필터 클래스를 익명 클래스로 만든다.
package ch19.g;

import java.io.File;
import java.io.FilenameFilter;

public class Test06 {
  
  //MyFilenameFilter
  
  public static void main(String[] args) {
    
    File dir = new File("./"); // 이클립스에서 실행하면 ./는 프로젝트 디렉토리를 가리킨다.

    // list()를 호출할 때 필터 객체를 딱 한 번만 만들어 사용할 것이기 때문에 
    // 굳이 로컬 클래스로 단정하게 정의할 필요가 없다.
    // 익명 클래스를 사용하자!
    
    String[] names = dir.list(new FilenameFilter(){
      @Override
      public boolean accept(File dir, String name) {
        if(name.endsWith(".txt"))
          return true;
        else
          return false;
      }
    });
    // 
    // 필터가 무슨일을 하는지 바로 알 수 있다
    // => 필터의 소스 코드를 확인하기 위해 돌아 다닐 필요가 없다.
    // 단, 코드의 길이가 짧을 경우에 이 방식이 보기좋다.
    // 코드가 너무길면 어디서 어디까지가 중첩 클래스인지 가늠하기 어렵다.
    
    for(String name : names) {
      System.out.println(name);
    }
    
  }

}
