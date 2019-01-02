package ch01;

public class Test03 {

  @Override 
  public String toString(){
    return "ok";
  }
  public static void main(String[] args) {
  System.out.println("Hello!");
  } 
}

/*
  $ javadoc -d [문서를 저장할 폴더] -sourcepath [소스폴더] 패키지명
  $ javadoc -d doc -sourcepath src/main/java ch01
*/

