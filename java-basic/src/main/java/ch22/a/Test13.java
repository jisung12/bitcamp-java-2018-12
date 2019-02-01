// java.io.File 클래스 : 연습 과제 - bin 폴더를 삭제하라!
package ch22.a;

import java.io.File;
import java.io.FileFilter;

public class Test13 {
  
  static void delete(File dir) {
    // 파일의 하위 디렉토리와 파일 목록을 얻는다. pseudo code
    File files = dir.listFiles();
    for (File file : files) {
      if (file.isFile()) {
        file.delete();
      } else {
        delete(file);
      }
    }
    dir.delete();
    
    // 파일 목록에서 파일을 하나 꺼낸다.
    // 만약 파일이면 삭제한다.
    // 디렉토리면 delete() 호출하여 삭제한다.
  }

  

  public static void main(String[] args) throws Exception {

    // bin의 하위 폴더와 파일을 모두 삭제해야만 bin 폴더를 삭제할 수 있다.
    // 재귀 호출 이용.
    
    
    
   

   // delete(dir);


  }

}


