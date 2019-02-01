// java.io.File 클래스 : FileFilter 사용하기
package ch22.a;

import java.io.File;
import java.io.FileFilter;

public class Test11_3 {

  //static nested class
  

  public static void main(String[] args) throws Exception {
    
    // local class
   
    
    File file = new File(".");

    // anonymous class
    File[] files = file.listFiles(new FileFilter() {
      @Override
      public boolean accept(File pathname) {
        if (pathname.isFile() && pathname.getName().endsWith(".txt"))
          return true;
        else 
          return false;
      }
    });

    for (File f : files) {
      System.out.printf("%s %12d %s\n",
          f.isDirectory() ? "d" : "-", 
              f.length(),
              f.getName());
    }


  }

}


