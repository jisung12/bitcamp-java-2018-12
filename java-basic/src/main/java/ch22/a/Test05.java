// java.io.File 클래스 : 파일 생성 
package ch22.a;

import java.io.File;

public class Test05 {

  public static void main(String[] args) throws Exception {

    // 존재하지 않는 새파일 생성.(이미 존재한다면 생성 불가)
    File file = new File("temp2/text.txt");
    if (file.createNewFile()) {
      System.out.println("파일 생성됨.");
    } else {
      System.out.println("파일 생성 못함");
    }
    
    // 디렉토리가 존재하지 않아도 파일 생성 못함 
    // => 디렉토리가 자동으로 생성되지 않는다. 예외 발생.
    file = new File("temp3/text.txt");
    if (file.createNewFile()) {
      System.out.println("파일 생성됨.");
    } else {
      System.out.println("파일 생성 못함");
    }
    
    

    
  }

}


