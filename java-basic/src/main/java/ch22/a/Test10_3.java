// java.io.File 클래스 : 필터 사용하기 2
package ch22.a;

import java.io.File;
import java.io.FilenameFilter;

public class Test10_3 {
  // local class(nested class)
  public static void main(String[] args) throws Exception {
    
    
    // 파일은 디렉토리와 파일을 통칭하는 용어다.
    File file = new File(".");

    // anonymous class
    String[] names = file.list(new FilenameFilter() {
      @Override
      public boolean accept(File dir, String name) {
      if (name.endsWith(".txt"))
        return true;
      else
        return false;
      }
    });
    
    for (String name : names) {
      System.out.println(name);
    }

  }

}



