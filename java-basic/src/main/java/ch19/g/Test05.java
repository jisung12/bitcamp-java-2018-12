// 파일 필터 클래스를 익명 클래스로 만든다.
package ch19.g;

import java.io.File;
import java.io.FilenameFilter;

public class Test05 {
  
  //MyFilenameFilter
  
  public static void main(String[] args) {
    
    File dir = new File("./"); // 이클립스에서 실행하면 ./는 프로젝트 디렉토리를 가리킨다.

    // 익명 클래스는 어차피 단 한 개의 인스턴스만 만들 수 있다.
    // 그렇다면 레퍼런스에 따로 인스턴스 주소를 저장하지 말고,
    // 필요한 곳에 바로 선언하자!
    
    FilenameFilter filter = new FilenameFilter(){
      @Override
      public boolean accept(File dir, String name) {
        if(name.endsWith(".txt"))
          return true;
        else
          return false;
      }
    };
    
    String[] names = dir.list(filter);
    // 
    // 조금 더 가까이!
    // => list()를 호출하는 코드를 보는 즉시 무엇을 필터링하는지 알 수 있다면 
    //     소스 코드를 더 잘 읽을 수 있을텐데
    
    for(String name : names) {
      System.out.println(name);
    }
  }

}
